package es.upm.miw.apiArchitectureTheme.entities;

public class User {
	
	private String nick;
	
	private String email;
	
	private Sport sport;
	
	public User()
	{
		
	}
	
	public User(String nick, String email)
	{
		this.nick=nick;
		this.email=email;
	}
	
	public void setNick(String nick)
	{
		this.nick = nick;
	}
	
	public String getNick()
	{
		return this.nick;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setSport(Sport sport)
	{
		this.sport=sport;
	}
	
	public Sport getSport()
	{
		return this.sport;
	}
	
}