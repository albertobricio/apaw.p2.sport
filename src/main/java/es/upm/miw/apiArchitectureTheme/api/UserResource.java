package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.*;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidNicknameException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureTheme.wrappers.*;

public class UserResource {

	// POST **/users body=nick:email
	public void createUser(String nick, String email) throws InvalidUserFieldException, InvalidNicknameException {
		this.validateField(nick);
		this.validateField(email);
		this.validateNick(nick);
		new UserController().createUser(nick, email);
	}

	private void validateField(String field) throws InvalidUserFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidUserFieldException();
		}
	}

	private void validateNick(String nick) throws InvalidNicknameException {
		if (new UserController().isCreatedNick(nick)) {
			throw new InvalidNicknameException(nick);
		}
	}

	// PUT **/users/{nick}/sport body=sportName
	public void putSportToUser(String nick, String sportName) throws InvalidUserFieldException {
		this.validateField(nick);
		this.validateField(sportName);
		new UserController().putSportToUser(nick, sportName);
	}

	// GET **/users
	public UserListWrapper userList() {
		return new UserController().userList();
	}

	// GET **/users/search?sport=*
	public NickListWrapper nickListBySport(String sportName) {
		return new UserController().userListBySport(sportName);
	}

}
