package model;

public class Task {
	
	private Status status;
	private char[] name;
	private User[] nutzer;
	private Datum erstellungsDatum;
	private Datum letzteBewegung;
	private char[] kommentar;
	private int farbe;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public char[] getName() {
		return name;
	}
	public void setName(char[] name) {
		this.name = name;
	}
	public User[] getNutzer() {
		return nutzer;
	}
	public void setNutzer(User[] nutzer) {
		this.nutzer = nutzer;
	}
	public Datum getErstellungsDatum() {
		return erstellungsDatum;
	}
	public void setErstellungsDatum(Datum erstellungsDatum) {
		this.erstellungsDatum = erstellungsDatum;
	}
	public Datum getLetzteBewegung() {
		return letzteBewegung;
	}
	public void setLetzteBewegung(Datum letzteBewegung) {
		this.letzteBewegung = letzteBewegung;
	}
	public char[] getKommentar() {
		return kommentar;
	}
	public void setKommentar(char[] kommentar) {
		this.kommentar = kommentar;
	}
	public int getFarbe() {
		return farbe;
	}
	public void setFarbe(int farbe) {
		this.farbe = farbe;
	}
	
	
	
}
