package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.*;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureTheme.wrappers.*;

public class UserResource {
	
	//POST **/users body=nick:email
	public void createUser(String nick, String email) throws InvalidUserFieldException
	{
		this.validateField(nick);
		this.existNick(nick);
		this.validateField(email);
		new UserController().createUser(nick,email);
	}
	
	private void validateField(String field) throws InvalidUserFieldException
	{
		if (field == null || field.isEmpty()){
			throw new InvalidUserFieldException();
		}
	}
	
	private void existNick (String nick)
	{
		
	}
	
	//PUT **/users/{nick}/sport body=sportName
	public void putSportToUser(String nick, String sportName) throws InvalidUserFieldException
	{
		this.validateField(nick);
		this.validateField(sportName);
		this.existSport(sportName);
		new UserController().putSportToUser(nick,sportName);
	}
	
	private void existSport(String sportName)
	{
		
	}

	
	//GET **/users
	public UserListWrapper userList()
	{
		return new UserController().userList();
	}
	
	//GET **/users/search?sport=*
	public UserListWrapper userListBySport(String sportName)
	{
		return new UserController().userListBySport(sportName);
	}

}
