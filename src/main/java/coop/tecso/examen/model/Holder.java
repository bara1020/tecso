package coop.tecso.examen.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Holder extends AbstractPersistentObject {

	private static final long serialVersionUID = -7734255710254324681L;

	@Column(unique=true)
	private String rut;

	@ManyToOne
    @JoinColumn(name = "id_holder_Type")
    private HolderType holderType;

	@OneToOne(cascade = CascadeType.ALL)
	private LegalEntity legalEntity;

	@OneToOne(cascade = CascadeType.ALL)
	private NaturalPerson naturalPerson;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public HolderType getHolderType() {
		return holderType;
	}

	public void setHolderType(HolderType holderType) {
		this.holderType = holderType;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	public NaturalPerson getNaturalPerson() {
		return naturalPerson;
	}

	public void setNaturalPerson(NaturalPerson naturalPerson) {
		this.naturalPerson = naturalPerson;
	}
	
	


}
