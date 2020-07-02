package coop.tecso.examen.config.exceptions;

public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4333994040341956875L;

	public NotFoundException() {

	}

	public NotFoundException(String message) {
		super(message);
	}
}
