package model;

public class User {
	
	private String name;
	private long id;
	private String passwort;
	
	public User(String name, long id, String passwort){
		this.name = name;
		this.id = id;
		this.passwort = passwort;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	
}
