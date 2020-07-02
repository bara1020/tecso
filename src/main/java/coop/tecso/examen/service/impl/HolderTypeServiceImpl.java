package coop.tecso.examen.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.HolderType;
import coop.tecso.examen.repository.HolderTypeRepository;
import coop.tecso.examen.service.HolderTypeService;

@Service
public class HolderTypeServiceImpl implements HolderTypeService {
	
	
	@Autowired
	protected HolderTypeRepository repository;
	
	@Override
	public Iterable<HolderType> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<HolderType> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(HolderType holder) {
		repository.save(holder);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<HolderType> findById(long id) {
		return repository.findById(id);
	}

}

