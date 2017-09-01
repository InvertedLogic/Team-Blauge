package model;

import java.util.ArrayList;

public class Statusliste {
	private Status head;
	private int laenge;

	public Statusliste() {
		this.head = null;
	}

	public Statusliste(Status head) {
		this.head = head;
	}

	public Status getHead() {
		return head;
	}

	public void setHead(Status head) {
		this.head = head;
	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	/**
	 * 
	 * @param status
	 */
	public void insertStatus(Status status) {
		this.laenge ++;
		Status tmp = this.head;
		if (this.head == null) {
			this.head = status;
		} else {
			while (tmp.getNachfolger() != null) {
				tmp = tmp.getNachfolger();
			}
			status.setVorgaenger(tmp);
			tmp.setNachfolger(status);
		}
	}
	
	/**
	 * 
	 * @param status
	 * @param vorg
	 * @param nachf
	 */
	public void insertBetween(Status status, Status vorg, Status nachf) {
		if (this.search(vorg) && this.search(nachf)) {
			Status lauf = this.head;
			while(lauf != null && !lauf.equals(vorg)) {
				lauf = lauf.getNachfolger();
			}
			if(lauf.equals(vorg)) {
				status.setNachfolger(nachf);
				nachf.setVorgaenger(status);
				status.setVorgaenger(lauf);
				lauf.setNachfolger(status);
			}
		}		
	}

	/**
	 * 
	 * @return all elements of the list
	 */
	public ArrayList<Status> getAll() {
		ArrayList<Status> erg = new ArrayList<>();
		Status tmp = this.head;
		while (tmp != null) {
			erg.add(tmp);
			tmp = tmp.getNachfolger();
		}
		return (erg);
	}
	
	public boolean search(Status status) {
		Status lauf = this.head;
		while (lauf != null && !lauf.equals(status)) {
			lauf = lauf.getNachfolger();
		}
		return (lauf != null);
	}

}
