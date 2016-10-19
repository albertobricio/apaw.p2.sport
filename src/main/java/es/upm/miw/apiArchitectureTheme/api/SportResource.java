package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.*;

public class SportResource {
	
	//POST **/sports body=name
	public void createSport(String name)
	{
		this.validateField(name);
		this.existSport(name);
		new SportController().createSport(name);
	}
	
	private void validateField(String field)
	{
		if (field == null || field.isEmpty())
		{
			throw new InvalidSportFieldException(field);
		}
	}
	
	private void existSport(String name)
	{
		
	}
	
}
