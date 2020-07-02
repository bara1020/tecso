package coop.tecso.examen.config.enums;

public enum MovementTypeEnum {

	DEBIT("Débito",1),
	CREDIT("Crédito",2); 
	
	private MovementTypeEnum (String description, int code){
		this.description = description;
		this.code = code;
	}
	
	private String description;
	private int code;
	
	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}	
	
}
