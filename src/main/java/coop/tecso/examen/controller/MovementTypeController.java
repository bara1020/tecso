package coop.tecso.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.MovementType;
import coop.tecso.examen.service.impl.MovementTypeServiceImpl;

@RestController
@RequestMapping("/movementType")
@CrossOrigin(origins = "*")
public class MovementTypeController {
	
	@Autowired
	private MovementTypeServiceImpl serviceMovementType;

	/**
	 * Retorna todos los tipos de movimiento
	 * @return
	 */
	@GetMapping
	public Iterable<MovementType> findAll() {
		return serviceMovementType.findAll();
	}

}
