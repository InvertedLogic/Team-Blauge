package model;

import java.util.ArrayList;

public class Task {
	
	private Status status;
	private String name;
	private Datum letzteAenderung;
	private String kommentar;
	private int farbe;
	private int id;
	private ArrayList<String> tags;
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
		this.setLetzterNutzer(u);
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
	public ArrayList<String> getTags()
	{
		return this.tags;
	}
	public void setTags(ArrayList<String> tags)
	{
		this.tags = tags;
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
	
	/**
	 * 
	 * @param nr - number of the searched tag in Tags
	 * @return - the place in Tags of the searched tag
	 */
	public String getSingleTag(int nr)
	{
		if(this.getTags().get(nr) != null)
		{
			return this.getTags().get(nr);
		}
		else
		{
			System.out.println("ERROR: Tag does not exist");
			return null;
		}
	}
	
	/**
	 * 
	 * @param bezeichnung - name of the searched tag
	 * @return - name of the searched tag
	 */
	public String getSingleTag(String bezeichnung)
	{
		for(int i=0; i<this.getTags().size(); i++)
		{
			if(this.getTags().get(i) == bezeichnung)
			{
				return this.getTags().get(i);
			}
		}
		System.out.println("ERROR: Tag \"" + bezeichnung + "\" not found");
		return null;
	}
	
	/**
	 * 
	 * @param nr - place in tags of the tag to delete
	 */
	public void loescheTag(int nr)
	{
		if(nr > this.tags.size())
		{
			System.out.println("ERROR: Tag not found");
		}
		else
		{
			this.getTags().remove(nr);
		}
	}
	
	/**
	 * 
	 * @param bezeichnung - name of the tag to delete
	 */
	public void loescheTag(String bezeichnung)
	{
		boolean found = false;
		for(int i=0; i<this.getTags().size(); i++)
		{
			if(this.tags.get(i) == bezeichnung)
			{
				this.getTags().remove(i);
				found = true;
			}
		}
		if(found == false)
			System.out.println("ERROR: Tag not found.");
	}
	
	/**
	 * 
	 * @param bezeichnung - name of the tag to create
	 */
	public void erstelleTag(String bezeichnung)
	{
		this.getTags().add(bezeichnung);
	}


}
