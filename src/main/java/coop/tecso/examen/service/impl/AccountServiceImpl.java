package coop.tecso.examen.service.impl;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.Account;
import coop.tecso.examen.repository.AccountRepository;
import coop.tecso.examen.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	protected AccountRepository  repository;
	
	@Override
	public Iterable<Account> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Account> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(Account account) {
		repository.save(account);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Account> findByNumberAccount(BigInteger numberAccount) {
		return repository.findByNumberAccount(numberAccount);
	}

}
