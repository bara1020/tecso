package coop.tecso.examen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import coop.tecso.examen.model.Account;
import coop.tecso.examen.model.Movement;

public interface MovementRepository extends CrudRepository<Movement, Long> {
	
	
	List<Movement> findByAccountOrderByCreationTimestampDesc(Account account);
}
