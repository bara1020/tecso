package coop.tecso.examen.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Holder;
import coop.tecso.examen.repository.HolderRepository;
import coop.tecso.examen.service.HolderService;

@Service
public class HolderServiceImpl implements HolderService {
	
	
	@Autowired
	protected HolderRepository  repository;
	
	@Override
	public Iterable<Holder> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Holder> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(Holder holder) {
		repository.save(holder);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}

