package model;

public class Task {
	
	private Status status;
	private String name;
	private Datum letzteAenderung;
	private String kommentar;
	private int farbe;
	private int id;
	private User letzterNutzer;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Task(String name, String kommentar, User u){
		this.name = name;
		this.kommentar = kommentar;
		this.letzterNutzer = u;
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

	public User getLetzterNutzer() {
		return letzterNutzer;
	}

	public void setLetzterNutzer(User letzterNutzer) {
		this.letzterNutzer = letzterNutzer;
	}

	public Datum getLetzteAenderung() {
		return letzteAenderung;
	}
	public void setLetzteAenderung(Datum letzteAenderung) {
		this.letzteAenderung = letzteAenderung;
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
