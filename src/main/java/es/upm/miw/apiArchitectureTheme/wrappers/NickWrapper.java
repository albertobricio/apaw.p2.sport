package es.upm.miw.apiArchitectureTheme.wrappers;

public class NickWrapper {

	private String nick;

	public NickWrapper(String nick) {
		this.setNick(nick);
	}

	public NickWrapper() {

	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String toString() {
		return "{\"nick\":\"" + nick + "\"}";
	}

}
