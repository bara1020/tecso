package coop.tecso.examen.config.enums;

public enum HolderTypeEnum {

	NATURAL("Persona Natural",1),
	LEGALENTITY("Persona Judírica",2); 
	
	private HolderTypeEnum (String description, int code){
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
