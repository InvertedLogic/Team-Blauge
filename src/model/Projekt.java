package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Projekt {
	
	private User ersteller;
	private HashMap<String, Task> tasks = new HashMap<String, Task>();
	private HashMap<String, User> users = new HashMap<String, User>();
	private String bezeichnung; /* evt. name? */
	private int id;
	private Statusliste statusliste;
	private Datum letzteAenderung;
	private Datum erstellungsDatum;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Statusliste getStatusliste() {
		return statusliste;
	}

	public void setStatusliste(Statusliste statusliste) {
		this.statusliste = statusliste;
	}

	public Datum getLetzteAenderung() {
		return letzteAenderung;
	}

	public void setLetzteAenderung(Datum letzteAenderung) {
		this.letzteAenderung = letzteAenderung;
	}

	public Datum getErstellungsDatum() {
		return erstellungsDatum;
	}

	public void setErstellungsDatum(Datum erstellungsDatum) {
		this.erstellungsDatum = erstellungsDatum;
	}

	public void setTasks(HashMap<String, Task> tasks) {
		this.tasks = tasks;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}

	public Projekt(User u, String bezeichnung) {
		this.ersteller = u;
		this.bezeichnung = bezeichnung;
		users.put(u.getName(), u);
		
	}

	public User getErsteller() {
		return ersteller;
	}

	public void setErsteller(User ersteller) {
		this.ersteller = ersteller;
	}
	public HashMap<String, Task> getTasks() {
		return tasks;
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public void addTaskToHashMap(Task task){
		tasks.put(task.getName(), task);
	}
	
	public void deleteTaskFromHashMap(Task task){
		tasks.remove(task.getName());
	}
	
	public void addUserToHashMap(User user){
		users.put(user.getName(), user);
	}
	
	public void deleteUserFromHashMap(User user){
		users.remove(user.getName());
	}

	public void createTask(String name, String kommentar) {
		Task task = new Task(name,kommentar);
		this.addTaskToHashMap(task);
	}
	
}
