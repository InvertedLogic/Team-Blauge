package model;

public class User {


	private String nutzername;
	private boolean isAdmin;
	private String nachname;
	private String vorname;
	
	public User(String nutzername, boolean isAdmin, String nachname, String vorname) {
		this.nutzername = nutzername;
		this.isAdmin = isAdmin;
		this.nachname = nachname;
		this.vorname = vorname;
	}
	
	public String getNutzername() {
		return nutzername;
	}

	public void setNutzername(String nutzername) {
		this.nutzername = nutzername;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}
