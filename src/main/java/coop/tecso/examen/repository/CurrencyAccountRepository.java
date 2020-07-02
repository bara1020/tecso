package coop.tecso.examen.repository;

import org.springframework.data.repository.CrudRepository;

import coop.tecso.examen.model.CurrencyAccount;

public interface CurrencyAccountRepository extends CrudRepository<CurrencyAccount, Long> {

}
