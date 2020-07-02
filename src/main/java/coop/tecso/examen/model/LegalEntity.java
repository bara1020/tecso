package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class LegalEntity extends AbstractPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6453153012834729671L;

	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false)
	private Integer foundationYear;

	@OneToOne(mappedBy = "legalEntity")
	private Holder holder;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(Integer foundationYear) {
		this.foundationYear = foundationYear;
	}

}
