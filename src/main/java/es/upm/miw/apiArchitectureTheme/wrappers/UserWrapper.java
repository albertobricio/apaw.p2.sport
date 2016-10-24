package es.upm.miw.apiArchitectureTheme.wrappers;

public class UserWrapper {

	private String nick;
	private String email;

	public UserWrapper(String nick, String email) {
		this.setNick(nick);
		this.setEmail(email);
	}

	public UserWrapper() {

	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "{\"nick:email\":\"" + nick + ":" + email + "\"}";
	}

}
