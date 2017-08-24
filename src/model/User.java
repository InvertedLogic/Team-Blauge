package model;

public class User {
	
	private char name;
	private long id;
	private char[] passwort;
	
	
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public char[] getPasswort() {
		return passwort;
	}
	public void setPasswort(char[] passwort) {
		this.passwort = passwort;
	}
	
	
}
