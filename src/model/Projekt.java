package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Projekt {
	
	private User ersteller;
	private HashMap<String, Task> Tasks= new HashMap<String, Task>();
	private HashMap<String, User> Users = new HashMap<String, User>();
	private String bezeichnung; /* evt. name? */
	private ArrayList<Status> statusliste;

	public Projekt(User u) {
		this.ersteller = u;
	}

	public User getErsteller() {
		return ersteller;
	}

	public void setErsteller(User ersteller) {
		this.ersteller = ersteller;
	}
	public HashMap<String, Task> getTasks() {
		return Tasks;
	}

	public HashMap<String, User> getUsers() {
		return Users;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public void addTaskToHashMap(Task task){
		Tasks.put(task.getName(), task);
	}
	
	public void deleteTaskFromHashMap(Task task){
		Tasks.remove(task.getName());
	}
	
	public void addUserToHashMap(User user){
		Users.put(user.getName(), user);
	}
	
	public void deleteUserFromHashMap(User user){
		Users.remove(user.getName());
	}

	public void createTask(String name, String kommentar) {
		Task task = new Task(name,kommentar);
		this.addTaskToHashMap(task);
	}
	
}
