/**
 *@author Mohammad Danyal 
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test ALL methods of Graph class with a different set of data
 */

class Graph_STUDENT_Test {

	Graph<Town, Road> graphToTest;
//	Graph<Town, Road> anotherGraphToTest;
	
	Town testTown1;
	Town testTown2;
	Town testTown3;
	Town testTown4;
	
//	Town testTownA;
//	Town testTownB;
//	Town testTownC;
//	Town testTownD;
	
	Road testRoad1;
	Road testRoad2;
	Road testRoad3;
	Road testRoad4;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		graphToTest = new Graph();
//		anotherGraphToTest = new Graph();
		
		testTown1 = new Town("Rockville");
		testTown2 = new Town("Germantown");
		testTown3 = new Town("Bethesda");
		testTown4 = new Town("Takoma Park");
		
//		Town testTownA = new Town("Riyadh");
//		Town testTownB = new Town("Jeddah"); 
//		Town testTownC = new Town("Dammam");
//		Town testTownD = new Town("Jubail");
		
		testRoad1 = new Road(testTown1, testTown2, 2, "Rockville Pike");
		testRoad2 = new Road(testTown2, testTown3, 5, "Viers Mill Rd");
		testRoad3 = new Road(testTown3, testTown4, 7, "Hungerford Drive");
		testRoad4 = new Road(testTown4, testTown1, 9, "Park Rd");
		
		graphToTest.addVertex(testTown1);
		graphToTest.addVertex(testTown2);
		graphToTest.addVertex(testTown3);
		graphToTest.addVertex(testTown4);
		
		graphToTest.addEdge(testTown1, testTown2, 2, "Rockville Pike");
		graphToTest.addEdge(testTown2, testTown3, 5, "Viers Mill Rd");
		graphToTest.addEdge(testTown3, testTown4, 7, "Hungerford Drive");
		graphToTest.addEdge(testTown4, testTown1, 9, "Park Rd");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
		testTown1 = null;
		testTown2 = null;
		testTown3 = null;
		testTown4 = null;
		
		testRoad1 = null;
		testRoad2 = null;
		testRoad3 = null;
		testRoad4 = null;
	}
	
	@Test
	public void testAddEdge() {
		
		/**
		 * Gets tested in the setup()
		 */
		
		// To check if the edge (road) exists
		assertEquals(testRoad1, graphToTest.getEdge(testTown1, testTown2));
		assertEquals(testRoad2, graphToTest.getEdge(testTown2, testTown3));
		assertEquals(testRoad3, graphToTest.getEdge(testTown3, testTown4));
		assertEquals(testRoad4, graphToTest.getEdge(testTown4, testTown1));
	}
	
	@Test
	public void testGetEdge() {
		
		assertEquals(testRoad1, graphToTest.getEdge(testTown1, testTown2));
		assertEquals(testRoad2, graphToTest.getEdge(testTown2, testTown3));
		assertEquals(testRoad3, graphToTest.getEdge(testTown3, testTown4));
		assertEquals(testRoad4, graphToTest.getEdge(testTown4, testTown1));
	}
	
	@Test
	public void testAddVertex() {
		
		/**
		 * Gets tested in setup()
		 */
		
		// To check if the vertex (town) exists
		assertEquals(testTown1, graphToTest.getTown(testTown1.getName().hashCode()));
		assertEquals(testTown2, graphToTest.getTown(testTown2.getName().hashCode()));
		assertEquals(testTown3, graphToTest.getTown(testTown3.getName().hashCode()));
		assertEquals(testTown4, graphToTest.getTown(testTown4.getName().hashCode()));
	}
	
	@Test
	public void testContainsEdge() {
		
		assertTrue(graphToTest.containsEdge(testTown1, testTown2));
		assertTrue(graphToTest.containsEdge(testTown2, testTown3));
		assertTrue(graphToTest.containsEdge(testTown3, testTown4));
		assertTrue(graphToTest.containsEdge(testTown4, testTown1));
		
		assertTrue(graphToTest.containsEdge(testTown2, testTown1));
		assertTrue(graphToTest.containsEdge(testTown3, testTown2));
		assertTrue(graphToTest.containsEdge(testTown4, testTown3));
		assertTrue(graphToTest.containsEdge(testTown1, testTown4));
	}
	
	@Test
	public void testContainsVertex() {
		
		assertTrue(graphToTest.containsVertex(testTown1));
		assertTrue(graphToTest.containsVertex(testTown2));
		assertTrue(graphToTest.containsVertex(testTown3));
		assertTrue(graphToTest.containsVertex(testTown4));
	}
	
	@Test
	public void testRemoveEdge() {
		
		assertEquals(testRoad1, graphToTest.removeEdge(testTown1, testTown2, 2, "Rockville Pike"));
		assertEquals(testRoad2, graphToTest.removeEdge(testTown2, testTown3, 5, "Viers Mill Rd"));
		assertEquals(testRoad3, graphToTest.removeEdge(testTown3, testTown4, 7, "Hungerford Drive"));
		assertEquals(testRoad4, graphToTest.removeEdge(testTown4, testTown1, 9, "Park Rd"));
	}
	
	@Test
	public void testRemoveVertex() {
		
		assertTrue(graphToTest.removeVertex(testTown1));
		assertTrue(graphToTest.removeVertex(testTown2));
		assertTrue(graphToTest.removeVertex(testTown3));
		assertTrue(graphToTest.removeVertex(testTown4));
	}
	
	@Test
	public void testRockvilleToTakomaPark() {
		
		ArrayList<String> testListForShortestPath = new ArrayList<String>();
		
		testListForShortestPath.add("Rockville via Park Rd to Takoma Park 9 mi");
		
		assertEquals(testListForShortestPath, graphToTest.shortestPath(testTown1, testTown4));
	}
}
