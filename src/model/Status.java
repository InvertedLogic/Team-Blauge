package model;

public class Status {
	
	private Status vorgaenger;
	private Status nachfolger;
	private String name; 

	public Status(String name) {
		this.name = name;
		this.vorgaenger = null;
		this.nachfolger = null;
	}
	
	public Status getVorgaenger() {
		return vorgaenger;
	}
	public void setVorgaenger(Status vorgaenger) {
		this.vorgaenger = vorgaenger;
	}
	public Status getNachfolger() {
		return nachfolger;
	}
	public void setNachfolger(Status nachfolger) {
		this.nachfolger = nachfolger;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
