package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.*;
import es.upm.miw.apiArchitectureTheme.exceptions.*;

public class SportResource {
	
	//POST **/sports body=name
	public void createSport(String name) throws InvalidSportFieldException, InvalidSportNameException
	{
		this.validateField(name);
		this.validateSport(name);
		new SportController().createSport(name);
	}
	
	private void validateField(String field) throws InvalidSportFieldException
	{
		if (field == null || field.isEmpty())
		{
			throw new InvalidSportFieldException(field);
		}
	}
	
	private void validateSport(String name) throws InvalidSportNameException 
	{
		if(new SportController().isCreatedSport(name))
		{
			throw new InvalidSportNameException(name);
		}			
	}

}
