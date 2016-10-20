package es.upm.miw.apiArchitectureTheme.controllers;

import es.upm.miw.apiArchitectureTheme.daos.*;
import es.upm.miw.apiArchitectureTheme.entities.*;
import es.upm.miw.apiArchitectureTheme.wrappers.*;

public class UserController {
	
	public UserListWrapper userList()
	{
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}
	
	public UserListWrapper userListBySport(String sportName)
	{
		List<User> userList = DaoFactory.getFactory().getUserDao().findAllWhoPracticeAnySport(sportName);
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}
	
	public void createUser(String nick, String email)
	{
		DaoFactory.getFactory().getUserDao().create(new User(nick,email));
	}
	
	public void putSportToUser(String nick, String sportName)
	{
		DaoFactory.getFactory().getUserDao().putSport(nick,sportName);
	}

}
