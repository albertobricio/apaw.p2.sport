package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidSportNameException extends Exception {

	private static final long serialVersionUID = 4719454026293928631L;
	private static final String DESCRIPTION = "Deporta no válido, ya existe";

	public InvalidSportNameException(String detail) {
		super(DESCRIPTION + "." + detail);
	}

	public InvalidSportNameException() {
		this("");
	}

}
