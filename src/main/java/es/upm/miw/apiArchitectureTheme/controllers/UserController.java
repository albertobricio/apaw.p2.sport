package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.*;
import es.upm.miw.apiArchitectureTheme.entities.*;
import es.upm.miw.apiArchitectureTheme.wrappers.*;

public class UserController {

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}

	public NickListWrapper userListBySport(String sportName) {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAllWhoPracticeAnySport(sportName);
		NickListWrapper nickListWrapper = new NickListWrapper();
		for (User user : userList) {
			nickListWrapper.addNickWrapper(new NickWrapper(user.getNick()));
		}
		return nickListWrapper;
	}

	public void createUser(String nick, String email) {
		DaoFactory.getFactory().getUserDao().create(new User(nick, email));
	}

	public void putSportToUser(String nick, String sportName) {
		List<User> users = DaoFactory.getFactory().getUserDao().findAll();
		for (User user : users) {
			if (user.getNick().equals(nick)) {
				Sport sport = new Sport(sportName);
				user.putSportinList(sport);
				DaoFactory.getFactory().getUserDao().update(user);
				break;
			}
		}
	}

	public boolean isCreatedNick(String nick) {
		List<User> users = DaoFactory.getFactory().getUserDao().findAll();
		for (User user : users) {
			if (user.getNick().equals(nick))
				return true;
		}
		return false;
	}

}
