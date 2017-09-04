package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Task;
import model.User;
import model.Datum;
import model.Status;

/**
 * Test class for Task.
 *
 */
public class Test_Task {

	Task task = null;
	
	/**
	 * set up for the test cases.
	 */
	@Before
	public void setUp() {
		
		User user1 = new User("TestNutzername",false, "TestNachname","TestVorname");
		task = new Task("3Pkt Contest", "nothing but net",user1);

	}
	
	
	@Test
	public void testName() {
		User user1 = new User("TestNutzername",false, "TestNachname","TestVorname");
		Task task = new Task("","", user1);
		assertEquals("", task.getName());
		task.setName("TestTask");
		assertEquals("TestTask", task.getName());
	}
	@Test
	public void testKommentar()
	{
		User user1 = new User("TestNutzername",false, "TestNachname","TestVorname");
		Task task = new Task("","", user1);
		assertEquals("", task.getKommentar());
		task.setKommentar("Test");
		assertEquals("Test", task.getKommentar());
	}
	@Test
	public void testStatus()
	{
		User user1 = new User("TestNutzername",false, "TestNachname","TestVorname");
		Status toDo = new Status("toDo");
		Task task = new Task("","", user1);
		task.setStatus(toDo);
		assertEquals(toDo, task.getStatus());
		
	}
	@Test
	public void testLetztAenderung() {
		Datum datum1 = new Datum(25, 8, 2017);
		task.setLetzteAenderung(datum1);
		assertEquals(datum1, task.getLetzteAenderung());
	}
	@Test
	public void testFarbe()
	{
		task.setFarbe(5);
		assertEquals(5, task.getFarbe());
	}
	@Test
	public void testID()
	{
		task.setId(9348357);
		assertEquals(9348357, task.getId());
	}
	@Test
	public void testTags()
	{
		
	}
	@Test
	public void testLetzterNutzer()
	{
		User user2 = new User("TestNutzername2",false, "TestNachname2","TestVorname2");
		task.setLetzterNutzer(user2);
		assertEquals(user2, task.getLetzterNutzer());
	}
		
}
