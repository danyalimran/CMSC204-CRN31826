/**
 * @author Mohammad Danyal
 */

import java.util.ArrayList;

public class Road extends java.lang.Object implements java.lang.Comparable<Road> {

	Town oneTownOnRoad;
	Town anotherTownOnRoad;
	int weightOfEdge;
	String roadName;
	ArrayList<Road> roads;
	
	/**
	 * No-arg constructor
	 */
	public Road() {
		
		oneTownOnRoad = null;
		anotherTownOnRoad = null;
		weightOfEdge = 0;
		roadName = "";
		this.roads = new ArrayList<Road>();
	}
	
	/**
	 * Constructor
	 * @param source one town on the road
	 * @param destination another town on the road
	 * @param degrees weight of the edge, i.e. distance from one town to another
	 * @param name name of the road
	 */
	public Road(Town source, Town destination, int degrees, java.lang.String name) {
		
		this.oneTownOnRoad = source;
		this.anotherTownOnRoad = destination;
		this.weightOfEdge = degrees;
		this.roadName = name;
	}
	
	/**
	 * Constructor with weight preset at 1
	 * @param source one town on the road
	 * @param destination another town on the road
	 * @param name name of the road
	 */
	public Road(Town source, Town destination, java.lang.String name) {
		
		
		this(source, destination, 1, name);
	}
	
	/**
	 * 
	 * @param town a vertex of the graph
	 * @return true if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		
		if (town.equals(oneTownOnRoad)) {
			
			return true;
		}
		
		else if (town.equals(anotherTownOnRoad)) {
		
			return true;
		}
	
		return false;
	}
	
	/**
	 * toString() method
	 */
	@Override
	public java.lang.String toString() {
		
		
		return null;
	}
 	
	/**
	 * 
	 * @return the road name
	 */
	public java.lang.String getName() {
		
		
		return roadName;
	}
	
	/**
	 * 
	 * @return the second town on the road
	 */
	public Town getDestination() {
		
		
		return anotherTownOnRoad;
	}
	
	/**
	 * 
	 * @return the first town on the road
	 */
	public Town getSource() {
		
		
		return oneTownOnRoad;
	}

	/**
	 * Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 * @param o - the object to be compared
	 * @return 0, if the object is equal. Returns a positive integer if the value is grater. Returns a negative integer if the value is less
	 */
	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		
		int compareToReturnValue = (this.getWeight() - o.getWeight());
		
		
		return compareToReturnValue; 
	}
	
	/**
	 * 
	 * @return the distance of the road
	 */
	public int getWeight() {
		
		
		return weightOfEdge;
	}
	
	/**
	 * @return true if each of the ends of road r is the same as the ends of this road
	 * RMEMEBER: a road that goes from point A to point B is the same as a road that goes from point B to point A
	 */
	@Override
	public boolean equals(java.lang.Object r) {
		
		Road roadObject = (Road) r;
		
		if ((this.roadName.equals(roadObject.getName()))) {
			
			
			if (((this.oneTownOnRoad.equals(roadObject.oneTownOnRoad)) && !(this.oneTownOnRoad.equals(roadObject.anotherTownOnRoad))) || ((this.oneTownOnRoad.equals(roadObject.anotherTownOnRoad)) && !(this.oneTownOnRoad.equals(roadObject.oneTownOnRoad)))) {
				
				
				if (this.getWeight() == roadObject.weightOfEdge) {
					
					
					return true;
				}
				
			}
			
		}
		
		return false;
	}
	
}
