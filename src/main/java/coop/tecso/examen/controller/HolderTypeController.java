package coop.tecso.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.HolderType;
import coop.tecso.examen.service.impl.HolderTypeServiceImpl;

@RestController
@RequestMapping("/holdertype")
@CrossOrigin(origins = "*")
public class HolderTypeController {
	
	@Autowired
	private HolderTypeServiceImpl serviceHolder;
	
	/**
	 * Se encarga de guardar un nuevo tipo de titular
	 * @param holderType
	 * @return
	 */
	@PostMapping
	public HolderType save(@RequestBody HolderType holderType) {
		serviceHolder.save(holderType);
		 return holderType;
	}
	
	/**
	 * Se encarga de actualizar un tipo de titular
	 * @param holderType
	 * @return
	 */
	@PutMapping
	public HolderType update(@RequestBody HolderType holderType) {
		serviceHolder.save(holderType);
		 return holderType;
	}
	
	/**
	 * Retorna todos los tipos de titular disponibles
	 * @return
	 */
	@GetMapping(value="/findAll")
	public Iterable<HolderType> findAll() {
		return serviceHolder.findAll();
	}
	
}
