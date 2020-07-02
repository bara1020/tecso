package coop.tecso.examen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Holder;
import coop.tecso.examen.model.NaturalPerson;

@Service
public interface NaturalPersonService {

	
	void save(NaturalPerson naturalPerson);

	public Iterable<NaturalPerson> findAll();

	public Optional<NaturalPerson> findById(Long id);

	public void deleteById(Long id);
}
