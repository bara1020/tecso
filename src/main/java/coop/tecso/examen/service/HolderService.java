package coop.tecso.examen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Holder;

@Service
public interface HolderService  {	
	
	void save(Holder holder);

	public Iterable<Holder> findAll();

	public Optional<Holder> findById(Long id);

	public void deleteById(Long id);
}
