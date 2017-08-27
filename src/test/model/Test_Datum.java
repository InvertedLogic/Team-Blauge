package test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.*;

/**
 * Test class for Datum.
 * @author Lars Raschke
 *
 */
public class Test_Datum {

	Datum date = null;
	
	/**
	 * set up for the test cases.
	 */
	@Before
	public void setUp() {
		
		date = new Datum(1, 1, 2016);
		
	}
	
	/**
	 * test-method for Date.toString().
	 */
	@Test
	public void testToString() {
		
		assertEquals("1.1.2015", Datum.toString(new Datum(1, 1, 2015)));
		assertEquals("11.12.2000", Datum.toString(new Datum(11, 12, 2000)));
	}
	
	/**
	 * test-method for Date.toDate().
	 */
	@Test
	public void testToDate() {
		
		assertEquals(this.date.getDay(), Datum.toDate("1.1.2016").getDay());
		assertEquals(this.date.getMonth(), Datum.toDate("1.1.2016").getMonth());
		assertEquals(this.date.getYear(), Datum.toDate("1.1.2016").getYear());
	}
	
	/**
	 * test-method for Date.before().
	 */
	@Test
	public void testBefore() {
		
		assertEquals(true, this.date.before(new Datum(1, 1, 2017)));
		assertEquals(false, this.date.before(new Datum(31, 12, 2015)));
		assertEquals(false, this.date.before(new Datum(1, 1, 2016)));
	}
	
	/**
	 * test-method for Date.after().
	 */
	@Test
	public void testAfter() {
		
		assertEquals(false, this.date.after(new Datum(1, 1, 2017)));
		assertEquals(true, this.date.after(new Datum(31, 12, 2015)));
		assertEquals(false, this.date.after(new Datum(1, 1, 2016)));
	}
	
	/**
	 * test-method for Date.same().
	 */
	@Test
	public void testSame() {
		
		assertEquals(false, this.date.same(new Datum(1, 1, 2017)));
		assertEquals(false, this.date.same(new Datum(31, 12, 2015)));
		assertEquals(true, this.date.same(new Datum(1, 1, 2016)));
	}
	
	/**
	 * test-method for Date.monthInDays().
	 */
	@Test
	public void testMonthInDays() {
		
		assertEquals(31, Datum.monthInDays(1));
		assertEquals(28, Datum.monthInDays(2));
		assertEquals(31, Datum.monthInDays(3));
		assertEquals(30, Datum.monthInDays(4));
		assertEquals(31, Datum.monthInDays(5));
		assertEquals(30, Datum.monthInDays(6));
		assertEquals(31, Datum.monthInDays(7));
		assertEquals(31, Datum.monthInDays(8));
		assertEquals(30, Datum.monthInDays(9));
		assertEquals(31, Datum.monthInDays(10));
		assertEquals(30, Datum.monthInDays(11));
		assertEquals(31, Datum.monthInDays(12));
	}
	
	/**
	 * test-method for Date.daysBetween().
	 */
	@Test
	public void testDaysBetween() {
		
		assertEquals(10, Datum.daysBetween(new Datum(1, 1, 2016), new Datum(11, 1, 2016)));
		assertEquals(35, Datum.daysBetween(new Datum(2, 3, 2016), new Datum(6, 4, 2016)));
		assertEquals(268, Datum.daysBetween(new Datum(20, 4, 2016), new Datum(13, 1, 2017)));
		assertEquals(365, Datum.daysBetween(new Datum(23, 3, 2016), new Datum(23, 3, 2017)));
		assertEquals(372, Datum.daysBetween(new Datum(23, 3, 2016), new Datum(30, 3, 2017)));
	}

	/**
	 * test-method for Datum.between().
	 */
	@Test
	public void testBetween() {

		assertEquals(true, new Datum(2, 2, 2016).between(new Datum(1, 1, 2016), new Datum(3, 3, 2016)));
		assertEquals(true, new Datum(2, 2, 2016).between(new Datum(3, 3, 2016), new Datum(1, 1, 2016)));
		assertEquals(true, new Datum(2, 2, 2016).between(new Datum(2, 2, 2015), new Datum(2, 2, 2017)));
		assertEquals(true, new Datum(2, 2, 2016).between(new Datum(1, 2, 2016), new Datum(3, 2, 2016)));
		assertEquals(true, new Datum(2, 2, 2016).between(new Datum(2, 1, 2016), new Datum(2, 3, 2016)));
		assertEquals(false, new Datum(2, 2, 2016).between(new Datum(2, 2, 2016), new Datum(2, 3, 2016)));
		assertEquals(false, new Datum(2, 2, 2016).between(new Datum(2, 1, 2016), new Datum(2, 2, 2016)));
		assertEquals(false, new Datum(2, 2, 2016).between(new Datum(3, 2, 2016), new Datum(4, 2, 2016)));
	}

}
