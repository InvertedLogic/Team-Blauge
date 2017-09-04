package test.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Projekt;
import model.Projektliste;
import model.User;

public class Test_Projektliste {
	
	Projektliste testProjektliste = new Projektliste();
	ArrayList<Projekt> testListOfProjekt = new ArrayList<Projekt>();
	User user1 = new User("Nutzername", false, "Vorname", "Nachname");
	Projekt pro1 = new Projekt(user1, "Projekt1 Beschreibung");
	Projekt pro2 = new Projekt(user1, "Projekt2 Beschreibung");
	
	@Before
	public void setUp(){
		int counter = 1;
		testListOfProjekt.add(pro1);
		testListOfProjekt.add(pro2);
		testProjektliste.setListOfProjekt(testListOfProjekt);
		testProjektliste.setCounter(counter);	
	}
	
	@Test
	public void getCounterTest(){
		assertEquals(1, testProjektliste.getCounter());
	}
	
	@Test
	public void getListOfProjektTest(){
		assertTrue(testProjektliste.getListOfProjekt().contains(pro1));
		assertTrue(testProjektliste.getListOfProjekt().contains(pro2));
	}
}
