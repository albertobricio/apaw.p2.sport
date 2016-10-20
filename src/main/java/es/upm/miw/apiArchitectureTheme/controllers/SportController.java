package es.upm.miw.apiArchitectureTheme.controllers;

import es.upm.miw.apiArchitectureTheme.daos.*;
import es.upm.miw.apiArchitectureTheme.entities.*;
import es.upm.miw.apiArchitectureTheme.wrappers.*;

public class SportController {
	
	public void createSport(String name)
	{
		DaoFactory.getFactory().getSportDao().create(new Sport(name));
	}

}
