package coop.tecso.examen.service;

import org.springframework.stereotype.Service;

import coop.tecso.examen.model.MovementType;

@Service
public interface MovementTypeService {

	Iterable<MovementType> findAll();
}
