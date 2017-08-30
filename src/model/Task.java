package model;

public class Task {
	
	private Status status;
	private String name;
	private User[] nutzer;
	private Datum erstellungsDatum;
	private Datum letzteBewegung;
	private String kommentar;
	private int farbe;
	
	public Task(String name, String kommentar){
		this.name = name;
		this.kommentar = kommentar;
	}
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
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
	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
	public int getFarbe() {
		return farbe;
	}
	public void setFarbe(int farbe) {
		this.farbe = farbe;
	}
	
	/**
	 * method to move a task forward
	 * 
	 */
	public void taskNachVorne()
	{
		/**
		 * Task can be moved by any user
		 */
		Status temp;
		temp = this.getStatus().getNachfolger().getNachfolger();
		if(this.getStatus().getNachfolger() != null)
		{
			this.getStatus().setVorgaenger(this.status);
			this.setStatus(this.getStatus().getNachfolger());
			this.getStatus().setNachfolger(temp);
		}
		else
		{
			System.out.println("ERROR: Task already in last status.");
		}
	}
	
	/**
	 * method to move a task backward
	 * 
	 */
	public void taskNachHinten()
	{
		/**
		 * TODO: Implement admin-only in this method
		 */
		Status temp;
		temp = this.getStatus().getVorgaenger().getVorgaenger();
		if(this.getStatus().getVorgaenger() != null)
		{
			this.getStatus().setNachfolger(this.getStatus());
			this.setStatus(this.getStatus().getVorgaenger());
			this.getStatus().setVorgaenger(temp);
		}
		else
		{
			System.out.println("ERROR: Task already in first status.");
		}
	}
	
}
