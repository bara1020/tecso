package coop.tecso.examen.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.model.CurrencyAccount;
import coop.tecso.examen.repository.CurrencyAccountRepository;
import coop.tecso.examen.service.CurrencyAccountService;

@Service
public class CurrencyAccountServiceImpl implements CurrencyAccountService {

	@Autowired
	protected CurrencyAccountRepository  repository;
	
	@Override
	public Iterable<CurrencyAccount> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<CurrencyAccount> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(CurrencyAccount account) {
		repository.save(account);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}


}
