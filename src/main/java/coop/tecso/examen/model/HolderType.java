package coop.tecso.examen.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class HolderType extends AbstractPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2496808968244401286L;

	
	private String holderType;
	
    @OneToMany(mappedBy = "holderType")
    private List<Holder> holderList;


	public String getHolderType() {
		return holderType;
	}

	public void setHolderType(String holderType) {
		this.holderType = holderType;
	}
	
	
	
}
