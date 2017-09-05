package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Datum;
import model.Projekt;
import model.Status;
import model.Statusliste;
import model.User;

/*
 * Hashmap Funktionen müssen noch getestet werden 
 */

public class Test_Projekt {
	
	User user1 = new User("Nutzername", false, "Nachname", "Vorname");
	Projekt projekt1 = new Projekt(user1, "");
	
	@Before
	public void setUp(){
		
	}
	@Test
	public void testErsteller() {
		projekt1.setErsteller(user1);
		assertEquals(user1, projekt1.getErsteller());
	}
	@Test
	public void testBezeichnung(){
		projekt1.setBezeichnung("Projekt1");
		assertEquals("Projekt1", projekt1.getBezeichnung());
	}
	@Test
	public void testId(){
		projekt1.setId(555);
		assertEquals(555, projekt1.getId());
	}
	@Test
	public void testStatusliste(){
		Statusliste statusliste1 = new Statusliste();
		projekt1.setStatusliste(statusliste1);
		assertEquals(statusliste1, projekt1.getStatusliste());
	}
	@Test
	public void testLetzteAenderung(){
		Datum datum1 = new Datum(4, 9, 2017);
		projekt1.setLetzteAenderung(datum1);
		assertEquals(datum1, projekt1.getLetzteAenderung());
	}
	@Test
	public void testErstellungsDatum(){
		Datum datum1 = new Datum(3, 8, 2017);
		projekt1.setErstellungsDatum(datum1);
		assertEquals(datum1, projekt1.getErstellungsDatum());
	}

}
