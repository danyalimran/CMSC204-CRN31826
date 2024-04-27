import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test ALL methods of TownGraphManager class
 */

class Town_STUDENT_Test {

	Town testTown1;
	Town testTown2;
	Town testTown3;
	
	@BeforeEach
	void setUp() throws Exception {
		
		testTown1 = new Town("Rockville");
		testTown2 = new Town("Germantown");
		testTown3 = new Town("Takoma Park");
	}

	@After
	public void tearDown() throws Exception {
		
		testTown1 = null;
		testTown2 = null;
		testTown3 = null;
	}

	@Test
	public void getTownName() {
		
		assertEquals("Rockville", testTown1.getName());
		assertEquals("Germantown", testTown2.getName());
		assertEquals("Takoma Park", testTown3.getName());
	}
	
	@Test
	public void testCompareTo() {
		
		assertTrue(testTown1.compareTo(testTown2) > 0);
		assertTrue(testTown2.compareTo(testTown3) < 0);
		assertTrue(testTown3.compareTo(testTown1) > 0);
		
		assertEquals(0, testTown1.compareTo(testTown1));
		assertEquals(0, testTown2.compareTo(testTown2));
		assertEquals(0, testTown3.compareTo(testTown3));
	}
	
	@Test
	public void testEquals() {
		
		assertTrue(testTown1.equals(testTown1));
		assertTrue(testTown2.equals(testTown2));
		assertTrue(testTown3.equals(testTown3));
		
		assertFalse(testTown1.equals(testTown2));
		assertFalse(testTown2.equals(testTown3));
	}

	
	@Test
	public void testSetTotalDistance() {
		
		testTown3.setTotalDistance(40);
		
		assertEquals(40, testTown3.getTotalDistance());
	}
	
	@Test
	public void getTotalDistance() {
		
		testTown3.setTotalDistance(40);
		
		assertEquals(40, testTown3.getTotalDistance());
	}
	
}
