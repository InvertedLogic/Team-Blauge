package model;

public class Status {
	
	private Status vorgaenger;
	private Status nachfolger;
	private enum stati {DOING, DONE, FINISHED}
	
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
	};
	
	
}
