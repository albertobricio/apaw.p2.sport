package es.upm.miw.apiArchitectureTheme.entities;

public class Sport {

	private int id;

	private String name;

	public Sport() {

	}

	public Sport(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
