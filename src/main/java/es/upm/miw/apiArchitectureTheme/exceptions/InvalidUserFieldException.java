package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidUserFieldException extends Exception{
	
	private static final long serialVersionUID = -519427086596746117L;
	public static final String DESCRIPTION = "Campo de usuario vacío";
	
	public InvalidUserFieldException (String detail)
	{
		super(DESCRIPTION+"."+detail);
	}
	
	public InvalidUserFieldException()
	{
		this("");
	}

}
