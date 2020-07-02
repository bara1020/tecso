package coop.tecso.examen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.config.enums.HolderTypeEnum;
import coop.tecso.examen.config.exceptions.BadRequestException;
import coop.tecso.examen.config.exceptions.NotFoundException;
import coop.tecso.examen.model.Holder;
import coop.tecso.examen.service.impl.HolderServiceImpl;

@RestController
@RequestMapping("/holder")
@CrossOrigin(origins = "*")
public class HolderController {

	@Autowired
	private HolderServiceImpl serviceHolder;

	
	/**
	 * Este metodo se encarga de realizar la creación de un nuevo titular
	 * @param holder
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Holder> save(@RequestBody Holder holder) {
		if (UserTypeValidation(holder)) {
			serviceHolder.save(holder);
			return new ResponseEntity<Holder>(holder,HttpStatus.CREATED);
		}
		return null;
	}

	/**
	 * Este metodo se encarga de realizas la actualización de la información del titular
	 * @param holder
	 * @return
	 */
	@PutMapping
	public ResponseEntity<Holder> update(@RequestBody Holder holder) {
		if (UserTypeValidation(holder)) {
			serviceHolder.save(holder);
			return new ResponseEntity<Holder>(holder,HttpStatus.OK);
		}
		return null;
	}

	/**
	 * Metodo encargado de retornar todos los titulares
	 * @return
	 */
	@GetMapping
	public Iterable<Holder> findAll() {
		return serviceHolder.findAll();
	}
	
	/**
	 * Metodo encargar de realizar la eliminación del titular
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		Optional<Holder> holder = serviceHolder.findById(id);
		if(holder.isPresent()) {
				serviceHolder.deleteById(holder.get().getId());
				return ResponseEntity.noContent().build();
		} else {
			throw new NotFoundException("El registro no se encuentra en el sistema.");
		}
		
	}

	/**
	 * Este metodo se encarga de validar que el json de entrada esté bien construido
	 * @param holder
	 * @return
	 */
	private boolean UserTypeValidation(Holder holder) {
		Long holderTypeId = holder.getHolderType().getId();
		if (holderTypeId == HolderTypeEnum.NATURAL.getCode()) {
			if (holder.getLegalEntity() != null) {
				throw new BadRequestException(
						"El tipo de titular es PERSONA NATURAL y el nodo legalEntity no debe ser enviado");
			}
		}
		if (holderTypeId == HolderTypeEnum.LEGALENTITY.getCode()) {
			if (holder.getNaturalPerson() != null) {
				throw new BadRequestException(
						"El tipo de titular es PERSONA JURIDICA y el nodo naturalPerson no debe ser enviado");
			}
		}
		return true;
	}

}
