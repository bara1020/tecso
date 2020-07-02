package coop.tecso.examen.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Account;

@Service
public interface AccountService {
	
	void save(Account numberAccount);

	Iterable<Account> findAll();

	Optional<Account> findById(Long id);

	void deleteById(Long id);
	
	Optional<Account> findByNumberAccount(BigInteger numberAccount);
	
}
