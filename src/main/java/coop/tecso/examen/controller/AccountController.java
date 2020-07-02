package coop.tecso.examen.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.config.enums.MovementTypeEnum;
import coop.tecso.examen.config.exceptions.BadRequestException;
import coop.tecso.examen.config.exceptions.NotFoundException;
import coop.tecso.examen.model.Account;
import coop.tecso.examen.model.Movement;
import coop.tecso.examen.service.impl.AccountServiceImpl;
import coop.tecso.examen.service.impl.MovementServiceImpl;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*")
public class AccountController {

	@Autowired
	private AccountServiceImpl serviceAccount;

	@Autowired
	private MovementServiceImpl serviceMoviment;

	/**
	 * Este metodo se encargar de guardar un nuevo número de cuenta
	 * @param account
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Account> save(@RequestBody Account account) {
		if (serviceAccount.findByNumberAccount(account.getNumberAccount()).isPresent()) {
			throw new BadRequestException("El número de cuenta ya existe.");
		} else {
			serviceAccount.save(account);
			return new ResponseEntity<Account>(account,HttpStatus.CREATED);
		}
	}

	
	/**
	 * Este número se encarga de realizar la actualización de la cuenta
	 * @param account
	 * @return
	 */
	@PutMapping
	public ResponseEntity<Account> update(@RequestBody Account account) {
		Optional<Account> currentAccount = serviceAccount.findByNumberAccount(account.getNumberAccount());
		if (currentAccount.isPresent()) {
			serviceAccount.save(account);
			return new ResponseEntity<Account>(account,HttpStatus.OK);
		} else {
			throw new BadRequestException("El número de cuenta no existe.");

		}
	}

	/*
	 * Metodo encargado de cargar todos los números de cuenta
	 */
	@GetMapping
	public Iterable<Account> findAll() {
		return serviceAccount.findAll();
	}
	
	/**
	 * Este metodo se encargar de retornar la información de la cuenta a partir del número de la cuenta
	 * @param numberAccount
	 * @return
	 */
	@GetMapping(value = "/{numberAccount}")
	public ResponseEntity<Account> findByAccount(@PathVariable BigInteger numberAccount) {
		Optional<Account> account = serviceAccount.findByNumberAccount(numberAccount);
		if (account.isPresent()) {
			return new ResponseEntity<>(account.get(), HttpStatus.OK);
		}
		throw new NotFoundException("Número de cuenta no encontrado en el sistema");
	}

	
	/**
	 * Este metodo se encargar de eliminar un número de cuenta
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Account> account = serviceAccount.findById(id);
		if (account.isPresent()) {
			if (account.get().getMovementList().size() == 0) {
				serviceAccount.deleteById(account.get().getId());
				return new ResponseEntity<>(account.get(), HttpStatus.OK);
			} else {
				throw new BadRequestException("El número de cuenta tiene movimientos asociados por lo tanto no puede ser eliminada.");
			}
		} else {
			throw new NotFoundException("Número de cuenta no encontrado en el sistema.");
		}
	}

	/**
	 * Este metodo se encargar de guardar un nuevo movimiento
	 * @param movement
	 * @return
	 */
	@PostMapping(value = "/movement")
	public ResponseEntity<Movement>  saveMovement(@RequestBody Movement movement) {
		Account account = serviceAccount.findById(movement.getAccount().getId()).get();
		BigDecimal balance;
		BigDecimal minValue = account.getCurrency().getMinValue();
		
		if(movement.getMovementType().getId() == MovementTypeEnum.DEBIT.getCode()) {
			if(movement.getAmount().signum() == -1)
				balance = account.getBalance().subtract(movement.getAmount());
			else 
				balance = account.getBalance().add(movement.getAmount());
		} else {
			if(movement.getAmount().signum() == -1)
				balance = account.getBalance().add(movement.getAmount());
			else 
				balance = account.getBalance().subtract(movement.getAmount());
			
			if(balance.compareTo(minValue) == -1) 
				throw new BadRequestException("Saldo insuficiente: No se puede ejecutar la transacción ya que minimamente debe tener en su cuenta " + minValue);
		}
		
		serviceMoviment.save(movement);
		account.setBalance(balance);
		serviceAccount.save(account);
		return new ResponseEntity<Movement>(movement,HttpStatus.CREATED);
	}
	
	/**
	 * Este metodo se encarga de obtener los movimientos apartir del id de la cuenta
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/movement/{id}")
	public ResponseEntity<Iterable<Movement>> findByAccountOrderByCreationTimestampDesc(@PathVariable Long id) {
		return new ResponseEntity<Iterable<Movement>>(serviceMoviment.findByAccountOrderByCreationTimestampDesc(serviceAccount.findById(id).get()),HttpStatus.OK);
	}
	
	
	
}
