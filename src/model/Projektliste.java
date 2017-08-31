package model;

import java.util.ArrayList;

public class Projektliste {
	
	private int counter;
	private ArrayList<Projekt> listOfProjekt;
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public ArrayList<Projekt> getListOfProjekt() {
		return listOfProjekt;
	}
	public void setListOfProjekt(ArrayList<Projekt> listOfProjekt) {
		this.listOfProjekt = listOfProjekt;
	}
	
}
