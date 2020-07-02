package coop.tecso.examen.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account extends AbstractPersistentObject{

	
	private static final long serialVersionUID = -343122947411269982L;
	
	@Column(precision=11)
	private BigInteger numberAccount;
	
	@Column(precision=15, scale=2)
	private BigDecimal balance;
	
	@ManyToOne
    @JoinColumn(name = "id_currency_type")
	private CurrencyAccount currency;
	
	@OneToMany(mappedBy = "account")
	private List<Movement> movementList;

	public BigInteger getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(BigInteger numberAccount) {
		this.numberAccount = numberAccount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public CurrencyAccount getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyAccount currency) {
		this.currency = currency;
	}

	public List<Movement> getMovementList() {
		return movementList;
	}

	public void setMovementList(List<Movement> movementList) {
		this.movementList = movementList;
	}


}
