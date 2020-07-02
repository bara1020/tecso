package coop.tecso.examen.config.exceptions;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3741972953966337613L;

	public BadRequestException() {
		
	}
	
	public BadRequestException(String message) {
		super(message);
	}
	
}
