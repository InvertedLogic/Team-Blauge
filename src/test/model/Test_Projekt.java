package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Projekt;
import model.User;

public class Test_Projekt {
	
	User user1 = new User("Nutzername", false, "Nachname", "Vorname");
	Projekt projekt1 = new Projekt(user1, "Projekt1");
	
	@Before
	public void setUp(){
		
	}
	@Test
	public void testErsteller() {
		projekt1.setErsteller(user1);
		assertEquals(user1, projekt1.getErsteller());
	}

}
