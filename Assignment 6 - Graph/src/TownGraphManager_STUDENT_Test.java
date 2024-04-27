import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test ALL methods of TownGraphManager class with a different set of data
 */

class TownGraphManager_STUDENT_Test {

	TownGraphManager testMap;
	
	@BeforeEach
	void setUp() throws Exception {
		
		testMap = new TownGraphManager();
		
		// Add the towns in the map
		testMap.addTown("Rockville");
		testMap.addTown("Germantown");
		testMap.addTown("Bethesda");
		testMap.addTown("Takoma Park");
        
        // Add the roads in the map
		testMap.addRoad("Rockville", "Germantown", 2, "Rockville Pike");
		testMap.addRoad("Germantown", "Bethesda", 5, "Viers Mill Rd");
		testMap.addRoad("Bethesda", "Takoma Park", 7, "Hungerford Drive");
		testMap.addRoad("Takoma Park", "Rockville", 9, "Park Rd");
	}

	@AfterEach
	void tearDown() throws Exception {
		
		testMap = null;
	}

	@Test
	public void testAddRoad() {
		
		/**
		 * Gets tested in the setup()
		 */
		
		// Checks if the road has been added/exists
		assertEquals("Rockville Pike", testMap.getRoad("Rockville", "Germantown"));
		assertEquals("Viers Mill Rd", testMap.getRoad("Germantown", "Bethesda"));
		assertEquals("Hungerford Drive", testMap.getRoad("Bethesda", "Takoma Park"));
		assertEquals("Park Rd", testMap.getRoad("Takoma Park", "Rockville"));
	}
	
	@Test
	public void testGetRoad() {
		
		assertEquals("Rockville Pike", testMap.getRoad("Rockville", "Germantown"));
		assertEquals("Viers Mill Rd", testMap.getRoad("Germantown", "Bethesda"));
		assertEquals("Hungerford Drive", testMap.getRoad("Bethesda", "Takoma Park"));
		assertEquals("Park Rd", testMap.getRoad("Takoma Park", "Rockville"));
	}
	
	@Test
	public void testAddTown() {
		
		/**
		 * Gets tested in the setup()
		 */
		
		// Checks if the town has been added/exists
		assertEquals("Rockville", testMap.getTown("Rockville").getName());
		assertEquals("Germantown", testMap.getTown("Germantown").getName());
		assertEquals("Bethesda", testMap.getTown("Bethesda").getName());
		assertEquals("Takoma Park", testMap.getTown("Takoma Park").getName());
	}
	
	@Test
	public void testGetTown() {
		
		assertEquals("Rockville", testMap.getTown("Rockville").getName());
		assertEquals("Germantown", testMap.getTown("Germantown").getName());
		assertEquals("Bethesda", testMap.getTown("Bethesda").getName());
		assertEquals("Takoma Park", testMap.getTown("Takoma Park").getName());
	}
	
	@Test
	public void testContainsTown() {
		
		assertTrue(testMap.containsTown("Rockville"));
		assertTrue(testMap.containsTown("Germantown"));
		assertTrue(testMap.containsTown("Bethesda"));
		assertTrue(testMap.containsTown("Takoma Park"));
	}
	
	@Test
	public void testContainsRoadConnection() {
		
		assertTrue(testMap.containsRoadConnection("Rockville", "Germantown"));
		assertTrue(testMap.containsRoadConnection("Germantown", "Bethesda"));
		assertTrue(testMap.containsRoadConnection("Bethesda", "Takoma Park"));
		assertTrue(testMap.containsRoadConnection("Takoma Park", "Rockville"));
	}
	
	@Test
	public void testDeleteRoadConnection() {
		
		assertTrue(testMap.deleteRoadConnection("Rockville", "Germantown", "Rockville Pike"));
		assertTrue(testMap.deleteRoadConnection("Germantown", "Bethesda", "Viers Mill Rd"));
		assertTrue(testMap.deleteRoadConnection("Bethesda", "Takoma Park", "Hungerford Drive"));
		assertTrue(testMap.deleteRoadConnection("Takoma Park", "Rockville", "Park Rd"));
		
		assertFalse(testMap.containsRoadConnection("Rockville", "Germantown"));
		assertFalse(testMap.containsRoadConnection("Germantown", "Bethesda"));
		assertFalse(testMap.containsRoadConnection("Bethesda", "Takoma Park"));
		assertFalse(testMap.containsRoadConnection("Takoma Park", "Rockville"));
	}
	
	@Test
	public void testDeleteTown() {
		
		assertTrue(testMap.deleteTown("Rockville"));
		assertTrue(testMap.deleteTown("Germantown"));
		assertTrue(testMap.deleteTown("Bethesda"));
		assertTrue(testMap.deleteTown("Takoma Park"));
		
		assertFalse(testMap.containsTown("Rockville"));
		assertFalse(testMap.containsTown("Germantown"));
		assertFalse(testMap.containsTown("Bethesda"));
		assertFalse(testMap.containsTown("Takoma Park"));
	}
}

