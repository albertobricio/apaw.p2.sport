package es.upm.miw.apiArchitectureTheme.entities;

import java.util.List;

public class User {
	
	private int id;
	
	private String nick;
	
	private String email;
	
	private List<Sport> sports;
	
	public User(){
	}
	
	public User(String nick, String email)
	{
		this.nick=nick;
		this.email=email;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id=id;
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
	
	public void setSportList(List<Sport> sports)
	{
		this.sports=sports;
	}
	
	public void putSportinList (Sport sport)
	{
		this.sports.add(sport);
	}
	
	public List<Sport> getSportList()
	{
		return this.sports;
	}
	
}
