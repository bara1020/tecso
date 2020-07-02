package coop.tecso.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.CurrencyAccount;
import coop.tecso.examen.service.impl.CurrencyAccountServiceImpl;

@RestController
@RequestMapping("/currency")
@CrossOrigin(origins = "*")
public class CurrencyAccountController {
	
	@Autowired
	private CurrencyAccountServiceImpl serviceCurrencyAccount;
	
	/**
	 * Se encarga de listar todas las modenas disponibles
	 * @return
	 */
	@GetMapping
	public Iterable<CurrencyAccount> findAll() {
		return serviceCurrencyAccount.findAll();
	}

}
