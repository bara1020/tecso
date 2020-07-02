package coop.tecso.examen.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class MovementType extends AbstractPersistentObject{
	
	private static final long serialVersionUID = 6584693051405683168L;
	
	private String type;
	
	@OneToMany(mappedBy = "movementType")
	private List<Movement> movementList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
