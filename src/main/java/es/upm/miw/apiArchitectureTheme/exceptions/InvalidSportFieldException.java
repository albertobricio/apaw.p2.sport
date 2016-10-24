package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidSportFieldException extends Exception {

	private static final long serialVersionUID = 4763844362278861834L;
	private static final String DESCRIPTION = "Nombre de deporte no encontrado";

	public InvalidSportFieldException(String detail) {
		super(DESCRIPTION + "." + detail);
	}

	public InvalidSportFieldException() {
		this("");
	}

}
