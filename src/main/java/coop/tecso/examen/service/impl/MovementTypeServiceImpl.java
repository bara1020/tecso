package coop.tecso.examen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.MovementType;
import coop.tecso.examen.repository.MovementTypeRepository;
import coop.tecso.examen.service.MovementTypeService;

@Service
public class MovementTypeServiceImpl implements MovementTypeService {

	@Autowired
	protected MovementTypeRepository repository;
	
	@Override
	public Iterable<MovementType> findAll() {
		return repository.findAll();
	}

}
