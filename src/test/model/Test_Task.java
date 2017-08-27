package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Task;

/**
 * Test class for Task.
 * @author Lars Raschke
 *
 */
public class Test_Task {

	Task task = null;
	
	/**
	 * set up for the test cases.
	 */
	@Before
	public void setUp() {
		
		task = new Task("3Pkt Contest", "nothing but net");
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
