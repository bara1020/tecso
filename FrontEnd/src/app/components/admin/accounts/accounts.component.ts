import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { Account } from 'src/app/model/account';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder, Validators, FormGroupDirective } from '@angular/forms';
import { CurrencyService } from 'src/app/services/currency.service';
import { CurrencyAccount } from 'src/app/model/currency-account';
import { MovementTypeService } from 'src/app/services/movement-type.service';
import { MovementType } from 'src/app/model/movement-type';
import { Movement } from 'src/app/model/movement';
import { MovementService } from 'src/app/services/movement.service';
import { InputNumberModule } from 'primeng/inputnumber';
import { Message } from 'src/app/commons/message';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  public account: Account;
  public numberAccount: number;
  public closeResult: string;
  public currencyCode: string;
  public selectedCurrency: number;
  public selectedMovementType: number;
  public submitted:boolean = false;
  public submittedMovementType:boolean = false;
  public addMovement:boolean = true;
  public accountForm: FormGroup;
  public movementForm: FormGroup;
  public currencyList: Array<CurrencyAccount>;
  public movementTypesList: Array<MovementType>;
  public message:Message = new Message();

  get accountFormControls() { return this.accountForm.controls; }
  get movementFormControls() { return this.movementForm.controls; }

  constructor(private _accountService: AccountService,
    private _movementTypeService: MovementTypeService,
    private _movementService: MovementService,
    private modalService: NgbModal, 
    private accountFormBuilder: FormBuilder,
    private movementFormBuilder: FormBuilder,
    private _currencyService: CurrencyService) {
    this.getCurrency();
    this.getMovementTypes();
  }

  ngOnInit(): void {
    this.accountForm = this.accountFormBuilder.group({
      numberAccount: ['', [Validators.required]],
      balance: ['', [Validators.required,Validators.pattern(/^[0-9]*\.[0-9][0-9]$/g)]],
      currency: ['', [Validators.required]],
    });

    this.movementForm = this.movementFormBuilder.group({
      description: ['', [Validators.required]],
      amount: ['', [Validators.required]],
      movementType: ['', [Validators.required]],
    });
  }

/**
   * Este metodo se de capturar las monedas disponibles
   */
  getCurrency() {
    this._currencyService.getCurrency().subscribe(
      data => this.currencyList = data,
      error => error
    );
  }
  /**
   * Este metodo se encarga de consultar la cuenta a partir del número de cuenta
   */
  getAccount() {
    if(this.numberAccount == null){
      alert("Debe digitar un número de cuenta");
      return;
    }
    this.cleaner();
    this.account = null;
    this._accountService.getAccount(this.numberAccount).subscribe(
      data => {
        this.account = data;
        this.currencyCode = this.account.currency.code;
        this.addMovement = false;
        this.getMovements();
      },
      error =>{ 
        this.handlerMessage("error",error.error.message)
    }
    );
  }

  /**
   * Este metodo se encarga de consultar los movimientos a partir del id de la cuenta
   */
  getMovements() {
    this._accountService.getMovementsByAccount(this.account.id).subscribe(
      data => this.account.movementList = data,
      error => this.handlerMessage("error",error.error.message)
    );
  }

    /**
   * Este metodo se encarga de consultar los tipos de moviemientos
   */
  getMovementTypes() {
    this._movementTypeService.getMovementType().subscribe(
      data => this.movementTypesList = data,
      error => this.handlerMessage("error",error.error.message)
    );
  }

  /**
   * Este metodo se encarga de consultar la cuenta a partir del número de cuenta
   */
  createAccount() {
    this.cleaner();
    this.submitted = true;
    if (this.accountForm.invalid) {
      return;
    }

    let form = this.accountForm.value;
    let newAccount = new Account();
    newAccount.balance = form.balance;
    newAccount.numberAccount = form.numberAccount;
    newAccount.creationTimestamp = new Date();    
    newAccount.currency.id = this.selectedCurrency;
    this._accountService.createAccount(newAccount).subscribe(
      data => {
        this.handlerMessage("ok","La cuenta fue creada exitosamente!");
        this.accountForm.reset;
        this.modalService.dismissAll();
      },
      error => this.handlerMessage("error",error.error.message)
    );
    
  }

/**
   * Este metodo se encarga de eliminar una cuenta
   */
  deleteAccount(){
    this.cleaner();
    this._accountService.deleteAccount(this.account.id).subscribe(
      data => {
        this.account = null;
        this.addMovement = true;
        this.numberAccount = null;
        this.handlerMessage("ok","Cuenta eliminada correctamente!")
      },
      error => this.handlerMessage("error",error.error.message)
    );
  }

  /**
   * Metodo encargar de abrir la modal
   * @param content 
   */
  open(content) {
    this.cleaner();
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
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  /**
   * Controla los mesajes de alerta
   * @param type 
   * @param message 
   */
  handlerMessage(type:string, message:string){
    this.message.type = type;
    this.message.message = message;
  }

  /**
   * Este metodo se encarga limpiar las variables
   */
  cleaner(){
    this.message.message = null;
    //this.account = null;
  }

  /**
   * Se encarga de crear el movimiento
   */
  createMovement(){
    this.cleaner();
    this.submittedMovementType = true;
    if (this.movementForm.invalid) {
      return;
    }

    let form = this.movementForm.value;
    let amount = form.amount;
    let newMovement = new Movement();
    newMovement.account.id = this.account.id;
    newMovement.description = form.description;
    newMovement.creationTimestamp = new Date();    
    if(this.selectedMovementType == 2 )// indica que es un crédito
      newMovement.amount= -amount;
    else // indica que es débito
      newMovement.amount = amount;
    newMovement.movementType.id = this.selectedMovementType;
    
    this._movementService.createMovement(newMovement).subscribe(
      data => {
        this.handlerMessage("ok","El movimiento fue creado exitosamente!");
        this.account.movementList.unshift(newMovement);
        this.movementForm.reset;
        if(this.selectedMovementType == 2 )// indica que es un crédito
          this.account.balance = this.account.balance - amount;
        else // indica que es débito
          this.account.balance = Number(this.account.balance) + Number(amount);
        
        this.modalService.dismissAll();
      },
      error => { 
        this.handlerMessage("error",error.error.message)
      }
    );
  }

}
