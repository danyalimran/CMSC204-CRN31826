/**
 * @author Mohammad Danyal
 */

import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface {

	Graph<Town, Road> map;
	
	public TownGraphManager() {
		
		this.map = new Graph<>();
	}
	
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		// TODO Auto-generated method stub
	
		Town townToGet1 = map.getTown(town1.hashCode());
		Town townToGet2 = map.getTown(town2.hashCode());
		
		map.addEdge(townToGet1, townToGet2, weight, roadName);
		
		return map.containsEdge(townToGet1, townToGet2);
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		
		for (Road roadIterator : map.returnRoadHashTable().values()) {
			
			if ( (roadIterator.getSource().getName().equals(town1) && roadIterator.getDestination().getName().equals(town2)) || ((roadIterator.getSource().getName().equals(town2) && roadIterator.getDestination().getName().equals(town1))) ) {
			
				
				return roadIterator.getName();
			}
			
		}
		
		return null;
	}

	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		// TODO Auto-generated method stub
		
		Town townToAdd = new Town(v);
		
		if (map.addVertex(townToAdd)) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		// TODO Auto-generated method stub
		
		for (Town townIterator : map.vertexSet()) {
			
			if (townIterator.getName().equals(name)) {
				
				return townIterator;
			}
			
		}
		
		return null;
	}

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		
		if (getTown(v) != null) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}

	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		
		Town townToCheck1 = getTown(town1);
		Town townToCheck2 = getTown(town2);
		
		if (map.containsEdge(townToCheck1, townToCheck2)) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		// TODO Auto-generated method stub
		
		ArrayList<String> roadHashTableToArrayList = new ArrayList<String>();
		
		// Iterate through the road hash table values and add them to the array list
		for (Road roadIterator : map.returnRoadHashTable().values()) {
			
			roadHashTableToArrayList.add(roadIterator.getName());
		}
		
		// Sort the array list
		Collections.sort(roadHashTableToArrayList);
		
		return roadHashTableToArrayList;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		
		Town townToCheck1 = getTown(town1);
		Town townToCheck2 = getTown(town2);
		
		if (map.containsEdge(townToCheck1, townToCheck2)) {
			
			map.removeEdge(townToCheck1, townToCheck2, 0, road);
			
			return true;
		}
		
		else {
			
			return false;
		}
	}

	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		
		Town townToDelete = getTown(v);
		
		return map.removeVertex(townToDelete);
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		
		ArrayList<String> vertexSetToArrayList = new ArrayList<String>();
		
		// Iterate through the vertex (town) set and add the them to the array list
		for (Town townIterator : map.vertexSet()) {
			
			vertexSetToArrayList.add(townIterator.getName());
		}
		
		// Sort the array list
		Collections.sort(vertexSetToArrayList);
		
		return vertexSetToArrayList;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		
		ArrayList<String> shortestPath;
		
		Town sourceTown = getTown(town1);
		Town destinationTown = getTown(town2);
		
		shortestPath = map.shortestPath(sourceTown, destinationTown);
		
		return shortestPath;
	}

}
