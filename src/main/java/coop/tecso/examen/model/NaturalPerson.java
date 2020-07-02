package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

@Entity
public class NaturalPerson extends AbstractPersistentObject  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6091022615641712458L;
	
	@Column(nullable = false, length = 80)
	private String name;
	
	@Column(nullable = false, length = 250)
	private String lastName;
	
	@Column(nullable = false)
	private Integer nit;
	
	@OneToOne(mappedBy = "naturalPerson")
	private Holder holder;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getNit() {
		return nit;
	}
	public void setNit(Integer nit) {
		this.nit = nit;
	}

}
