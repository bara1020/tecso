package coop.tecso.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Account;
import coop.tecso.examen.model.Movement;

@Service
public interface MovementService {

	void save(Movement movement);

	Iterable<Movement> findAll();

	Optional<Movement> findById(Long id);
	
	List<Movement> findByAccountOrderByCreationTimestampDesc(Account account);

}
