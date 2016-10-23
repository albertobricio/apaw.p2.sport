package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.*;
import es.upm.miw.apiArchitectureTheme.entities.*;

public class SportController {
	
	public void createSport(String name)
	{
		DaoFactory.getFactory().getSportDao().create(new Sport(name));
	}

	public boolean isCreatedSport(String name) {
		List<Sport> sports = DaoFactory.getFactory().getSportDao().findAll();
		for(Sport sport:sports)
		{
			if(sport.getName().equals(name))
				return true;
		}
		return false;
	}

}
