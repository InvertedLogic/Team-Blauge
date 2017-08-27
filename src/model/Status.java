package model;

public class Status {
	
	private Status vorgaenger;
	private Status nachfolger;
	private Stati status; /* koennte Problem mit der Flexibilitaet geben */
	
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
	public void setStatus(Stati status){
		this.status = status;
	}
	public Stati getStatus(){
		return this.status;
	}
	
}
