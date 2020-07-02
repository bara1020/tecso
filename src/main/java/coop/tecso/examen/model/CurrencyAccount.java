package coop.tecso.examen.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class CurrencyAccount extends AbstractPersistentObject {

	private static final long serialVersionUID = 7077622125098899086L;

	private String currency;

	private String code;
	
	private BigDecimal minValue;

	@OneToMany(mappedBy = "currency", cascade = CascadeType.ALL)
	private List<Account> accountList;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}
	
	


}
