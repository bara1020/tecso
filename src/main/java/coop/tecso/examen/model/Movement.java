package coop.tecso.examen.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Movement extends AbstractPersistentObject{
	
	private static final long serialVersionUID = -4586444059539892832L;
	
	private String description;

	@Column(precision=15, scale=2)
	private BigDecimal amount;
	
	@ManyToOne
    @JoinColumn(name = "id_movement_Type")
	private MovementType movementType;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	private Account account;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public MovementType getMovementType() {
		return movementType;
	}
	public void setMovementType(MovementType movementType) {
		this.movementType = movementType;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
