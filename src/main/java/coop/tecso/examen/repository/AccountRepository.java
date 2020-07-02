package coop.tecso.examen.repository;


import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import coop.tecso.examen.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{
	
	Optional<Account> findByNumberAccount(BigInteger account);
	
	boolean existsByNumberAccount(BigInteger account);

}
