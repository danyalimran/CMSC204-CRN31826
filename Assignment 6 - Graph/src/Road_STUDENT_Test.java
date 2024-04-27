import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test ALL methods of Road class
 */

class Road_STUDENT_Test {

	Town sourceTown1;
	Town sourceTown2;
	Town sourceTown3;

	Town destinationTown1;
	Town destinationTown2;
	Town destinationTown3;
	
	Road roadToTest1;
	Road roadToTest2;
	Road roadToTest3;
	
	@BeforeEach
	void setUp() throws Exception {
		
		sourceTown1 = new Town("Rockville");
		sourceTown2 = new Town("Riyadh");
		sourceTown3 = new Town("Dubai");
		
		destinationTown1 = new Town("Germantown");
		destinationTown2 = new Town("Jeddah");
		destinationTown3 = new Town("Abu Dhabi");
		
		roadToTest1 = new Road(sourceTown1, destinationTown1, 8, "Rockville Pike");
		roadToTest2 = new Road(sourceTown2, destinationTown2, 8, "King Abdulaziz Road");
		roadToTest3 = new Road(sourceTown3, destinationTown3, 8, "Shaikh Zayed Road");
	}

	@AfterEach
	void tearDown() throws Exception {
		
		sourceTown1 = null;
		sourceTown2 = null;
		sourceTown3 = null;
		
		destinationTown1 = null;
		destinationTown2 = null;
		destinationTown3 = null;
	}

	@Test
	public void testGetName() {
		
		assertEquals(roadToTest1.getName(), "Rockville Pike");
		assertEquals(roadToTest2.getName(), "King Abdulaziz Road");
		assertEquals(roadToTest3.getName(), "Shaikh Zayed Road");
	}
	
	@Test
	public void testGetSource() {
		
		assertEquals(roadToTest1.getSource(), sourceTown1);
		assertEquals(roadToTest2.getSource(), sourceTown2);
		assertEquals(roadToTest3.getSource(), sourceTown3);
		
		assertEquals(roadToTest1.getDestination(), destinationTown1);
		assertEquals(roadToTest2.getDestination(), destinationTown2);
		assertEquals(roadToTest3.getDestination(), destinationTown3);
	}
	
	@Test
	public void testGetDestination() {
		
		assertEquals(roadToTest1.getDestination(), destinationTown1);
		assertEquals(roadToTest2.getDestination(), destinationTown2);
		assertEquals(roadToTest3.getDestination(), destinationTown3);
	}
	
	@Test
	public void testCompareTo() {
		
		assertTrue(roadToTest1.getName().compareTo(roadToTest2.getName()) > 0);
		assertTrue(roadToTest2.getName().compareTo(roadToTest3.getName()) < 0);
		
		assertFalse(roadToTest1.getName().compareTo(roadToTest2.getName()) < 0);
		assertFalse(roadToTest2.getName().compareTo(roadToTest3.getName()) > 0);
	}
	
//	@Test
//	public void testEquals() {
//		
//		assertTrue(roadToTest1.equals(roadToTest1));
//		assertTrue(roadToTest2.equals(roadToTest2));
//		assertTrue(roadToTest3.equals(roadToTest3));
//	}
	
}
