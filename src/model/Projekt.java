package model;

import java.util.HashMap;

public class Projekt {
	
	private User ersteller;
	private HashMap<String, Task> Tasks= new HashMap<String, Task>();
	private HashMap<String, User> Users = new HashMap<String, User>();

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

	public void addTaskToHashMap(Task task){
		Tasks.put(task.getName(), task);
	}
	
	public void deleteTaskFromHashMap(Task task){
		Tasks.remove(task.getName());
	}
	
}
