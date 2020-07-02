package coop.tecso.examen.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.NaturalPerson;
import coop.tecso.examen.repository.NaturalPersonRepository;
import coop.tecso.examen.service.NaturalPersonService;

@Service
public class NaturalPersonServiceImpl implements NaturalPersonService {

	@Autowired
	protected NaturalPersonRepository  repository;
	
	@Override
	public Iterable<NaturalPerson> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<NaturalPerson> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(NaturalPerson naturalPerson) {
		repository.save(naturalPerson);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
