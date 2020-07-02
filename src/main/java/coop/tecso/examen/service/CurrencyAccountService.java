package coop.tecso.examen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import coop.tecso.examen.model.CurrencyAccount;

@Service
public interface CurrencyAccountService {

	
	void save(CurrencyAccount currencyAccount);

	Iterable<CurrencyAccount> findAll();

	Optional<CurrencyAccount> findById(Long id);

	void deleteById(Long id);
}
