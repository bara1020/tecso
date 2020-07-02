package coop.tecso.examen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Account;
import coop.tecso.examen.model.Movement;
import coop.tecso.examen.repository.MovementRepository;
import coop.tecso.examen.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService{

	@Autowired
	protected MovementRepository  repository;
	
	@Override
	public Iterable<Movement> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Movement> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(Movement movement) {
		repository.save(movement);
	}
	
	@Override
	public List<Movement> findByAccountOrderByCreationTimestampDesc(Account account){
		return repository.findByAccountOrderByCreationTimestampDesc(account);
	}
	
}
