package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.*;

public class UserResource {
	
	//POST **/users body=nick:email
	public void createUser(String nick, String email)
	{
		this.validateField(nick);
		this.existNick(nick);
		this.validateField(email);
		new UserController().createUser(nick,email);
	}
	
	private void validateField(String field)
	{
		if (field == null || field.isEmpty()){
			throw new InvalidUserFieldException();
		}
	}
	
	private void existNick (String nick)
	{
		
	}
	
	//PUT **/users/{nick}/sport body=sportName
	public void putSportToUser(String nick, String sportName)
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
