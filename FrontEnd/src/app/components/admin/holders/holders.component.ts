import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Message } from 'src/app/commons/message';
import { HolderService } from 'src/app/services/holder.service';
import { Holder } from 'src/app/model/holder';
import { NaturalPerson } from 'src/app/model/natural-person';
import { LegalEntity } from 'src/app/model/legal-entity';

@Component({
  selector: 'app-holders',
  templateUrl: './holders.component.html',
  styleUrls: ['./holders.component.css']
})
export class HoldersComponent implements OnInit {

  public closeResult: string;
  public process: string;
  public holderNaturalPersonForm: FormGroup;
  public holderLegalEntityForm: FormGroup;
  public submittedHolderNaturalPerson: boolean = false;
  public submittedLegalEntityPerson: boolean = false;
  public message: Message = new Message();
  public selectedYear: number;
  public year: number = new Date().getFullYear();
  public holdersList: Array<Holder>;
  public currentHolder: Holder;
  public currentHolderTemp: Holder;
  public tabHandler:number = 0;
  public indexSelected:number;
  get holderNaturalPersonFormControls() { return this.holderNaturalPersonForm.controls; }
  get holderLegalEntityFormControls() { return this.holderLegalEntityForm.controls; }

  public years = [];


  constructor(private modalService: NgbModal,
    private holderNaturalPersonFormBuilder: FormBuilder,
    private holderLegalEntityFormBuilder: FormBuilder,
    private _holderService: HolderService) {
    this.cleaner();
    this.setYears();
    this.findAllHolders();
  }

  ngOnInit(): void {
    this.holderNaturalPersonForm = this.holderNaturalPersonFormBuilder.group({
      rut: ['', [Validators.required]],
      name: ['', [Validators.required, Validators.maxLength(80)]],
      lastName: ['', [Validators.required, Validators.maxLength(250)]],
      nit: ['', [Validators.required]],
    });

    this.holderLegalEntityForm = this.holderLegalEntityFormBuilder.group({
      rut: ['', [Validators.required]],
      name: ['', [Validators.required, Validators.maxLength(100)]],
      foundationYear: ['', [Validators.required]],
    });
  }

  /**
   * Reinicia valores
   */
  cleaner() {
    this.currentHolder = null;
    this.currentHolder = new Holder();
    this.currentHolder.naturalPerson = new NaturalPerson();
    this.currentHolder.legalEntity = new LegalEntity();
    this.tabHandler = 0;
    this.selectedYear = null;
  }

  /**
   * Consulta todos los titulares disponibles
   */
  findAllHolders() {
    this._holderService.findAllHolders().subscribe(
      data => {
      this.holdersList = data;
      },
      error => this.handlerMessage("error", error.error.message)
    );
  }

  /**
 * Metodo encargar de abrir la modal
 * @param content 
 */
  open(content, process, index) {
    this.holderSelected(index);
    if (process == 'crear'){
      this.cleaner();
    }else if(this.currentHolder.holderType.id == 2){// persona jurídica
      this.selectedYear = this.currentHolder.legalEntity.foundationYear;
    }

    this.process = process;
    this.message.message = null;
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title', centered: true }).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  /**
   * 
   * @param reason Se ejecuta cuando se cierra la modal
   */
  private getDismissReason(reason: any): string {
    this.closeModel();
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  /**
   * Handler para la creación del titular
   * @param type 
   */
  handlerCreateHolder(type: number) {
    if (type == 1) {//Persona física
      this.submittedHolderNaturalPerson = true;
      if (this.holderNaturalPersonForm.invalid) {
        return;
      }
      this.createNaturalPerson(type);
    } else {//Persona jurídica
      this.submittedLegalEntityPerson = true;
      if (this.holderLegalEntityForm.invalid) {
        return;
      }
      this.createLegalEntity(type);
    }
  }

  /**
   * Este metodo se encarga de hacer la construcción del payload para la creación de la persona física
   * @param type 
   */
  createLegalEntity(type: number) {
    let form = this.holderLegalEntityForm.value;
    let newHolder = new Holder();
    newHolder.rut = form.rut;
    newHolder.holderType.id = type;

    let legalEntity = new LegalEntity();
    legalEntity.name = form.name;
    legalEntity.foundationYear = this.selectedYear;
    this.currentHolder.legalEntity.foundationYear = this.selectedYear;
    newHolder.legalEntity = legalEntity;
    newHolder.creationTimestamp = new Date();
    if (this.process == 'crear')
      this.createHolder(newHolder);
    else
      this.updateHolder();
  }

  /**
   * Este metodo se encarga de hacer la construcción del payload para la creación de la persona jurídica
   * @param type 
   */
  createNaturalPerson(type: number) {
    let form = this.holderNaturalPersonForm.value;

    let newHolder = new Holder();
    newHolder.rut = form.rut;
    newHolder.holderType.id = type;

    let naturalPerson = new NaturalPerson();
    naturalPerson.name = form.name;
    naturalPerson.lastName = form.lastName;
    naturalPerson.nit = form.nit;

    newHolder.naturalPerson = naturalPerson;

    if (this.process == 'crear')
      this.createHolder(newHolder);
    else
      this.updateHolder();
  }

  /**
   * 
   * @param holder 
   */
  createHolder(holder: Holder) {
    this._holderService.createHolder(holder).subscribe(
      data => {
        this.handlerMessage("ok", "El titular fue creado exitosamente!");
        this.holderNaturalPersonForm.reset;
        this.holderLegalEntityForm.reset;
        this.modalService.dismissAll();
      },
      error => this.handlerMessage("error", error.error.message)
    );
  }

  /**
   * 
   * @param holder 
   */
  updateHolder() {
    this._holderService.updateHolder(this.currentHolder).subscribe(
      data => {
        this.handlerMessage("ok", "El titular fue actualizado exitosamente!");
        this.holderNaturalPersonForm.reset;
        this.holderLegalEntityForm.reset;
        this.modalService.dismissAll();
      },
      error => this.handlerMessage("error", error.error.message)
    );
  }

  /**
    * Controla los mesajes de alerta
    * @param type 
    * @param message 
    */
  handlerMessage(type: string, message: string) {
    this.message.type = type;
    this.message.message = message;
  }

  /**
   * Se encarga de listas los años disponibles
   */
  setYears() {
    for (let index = this.year; index >= 1800; index--)
      this.years.push(index);
  }

  /**
   * Se encarga de capturar el titular seleccionado
   * @param index 
   */
  holderSelected(index: number) {
    this.currentHolder = this.holdersList[index];
    this.tabHandler = this.currentHolder.holderType.id;
  }

  /**
   * Este metodo se encargar de ejecutar el cierre de la modal
   */
  closeModel() {
    this.findAllHolders();
  }

  /**
   * Este metodo se enencargar de eliminar el registro
   * @param index 
   */
  deleteHolder() {
    this._holderService.deleteHolder(this.currentHolder.id).subscribe(
      data => {
        this.handlerMessage("ok", "El titular fue eliminado exitosamente!");
        this.holdersList.splice(this.indexSelected, 1);
        this.modalService.dismissAll();
      },
      error => this.handlerMessage("error", error.error.message)
    );

  }

  /**
   * Manejador del borrado de titular
   * @param index 
   */
  deleteHandler(index: number) {
    this.holderSelected(index);
    this.indexSelected = index;
  }  
  selectdYearHandler(event:any){
      this.selectedYear= event.target.value;
  }

}
