package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidNicknameException extends Exception {

	private static final long serialVersionUID = -196899242516855573L;
	private static final String DESCRIPTION = "Nickname no válido, ya existe";

	public InvalidNicknameException(String detail) {
		super(DESCRIPTION + "." + detail);
	}

	public InvalidNicknameException() {
		this("");
	}

}
