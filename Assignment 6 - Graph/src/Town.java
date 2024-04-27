/**
 * @author Mohammad Danyal
 */

import java.util.ArrayList;

public class Town extends java.lang.Object implements java.lang.Comparable<Town> {

	ArrayList<Road> roadList;
	
	String townName;
	int townHashCode;
	
	// Additional Variables
	int totalDistance;
	Town previousTown;
	Road previousRoad;
	
	/**
	 * No-arg Constructor
	 */
	public Town() {
		
		roadList = new ArrayList<Road>();
		
		townHashCode = 0;
		this.townName = "";
		
		this.totalDistance = Integer.MAX_VALUE;
		this.previousTown = null;
		this.previousRoad = null;
	}
	
	/**
	 * Creates an instance of name
	 * @param name the variable to create instance of
	 */
	public Town(java.lang.String name) {
		
		roadList = new ArrayList<Road>();
		
		townHashCode = 0;
		//roadList = null;
		
		this.townName = name;
		this.totalDistance = Integer.MAX_VALUE;
		this.previousTown = null;
	}
	
	/**
	 * Creates an instance of templateTown
	 * @param templateTown the variable to create instance of 
	 */
	public Town(Town templateTown) {
		
		roadList = new ArrayList<Road>();
		
		townHashCode = 0;
		//roadList = null;
		
		this.townName =  templateTown.getName();
		this.totalDistance = Integer.MAX_VALUE;
		this.previousTown = null;
		this.previousRoad = null;
	}
	
	/**
	 * 
	 * @return the town name
	 */
	public java.lang.String getName() {
		

		return townName;
	}	
	
	/**
	 * Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 * @param o - the object to be compared
	 * @return 0, if the object is equal. Returns a positive integer if the value is grater. Returns a negative integer if the value is less
	 * @throws NullPointerException if the object is null
	 */
	@Override
	public int compareTo(Town o) {
		// TODO Auto-generated method stub
		
//		Town templateTown = null;
//		
//		int returnValue = 0;
//	o.get	
//		if (o == null) {
//			
//			throw new NullPointerException();
//		}
//		
//		else {
//			
//			// returns 0 if equal
//			if (templateTown.equals(blueprintTown.getName())) {
//				
//				returnValue = 0;
//			}
//			
//			// returns 1 (positive integer) if greater
//			else if (templateTown.equals(blueprintTown.getName()) == false) {
//				
//				returnValue = 1;
//			}
//			
//		}
//		
//		return returnValue;
		
		return this.getName().compareTo(o.getName());
	}
	
	/**
	 * @return the town name
	 */
	@Override
	public java.lang.String toString() {
		
		
		return townName;
	}
	
	/**
	 * @return the hash code
	 */
	@Override
	public int hashCode() {

		
		return townName.hashCode();
	}
	
	/**
	 * @return true if the names are same
	 * @return false if the names are not same
	 */
	@Override
	public boolean equals(java.lang.Object obj) {
		
//		if (obj == townName) {
//			
//			return true;
//		}
//		
//		else {
//			
//			return false;
//		}
		
		Town townObject = (Town) obj;
		
		if (this.townName.equals(townObject.getName())) {
			
			return true;
		}
		
		else {
			
			return false;
		}
		
	}
	
	/**
	 * Adds a road to the list
	 * @param road the road to add
	 */
	public void addToRoadList(Road road) {
		
		roadList.add(road);
	}
	
	/**
	 * MUTATORS/SETTERS
	 */
	
	/**
	 * 
	 * @param distance the distance to be set
	 */
	public void setTotalDistance(int distance) {
		
		totalDistance = distance;
	}
	
	/**
	 * 
	 * @param prevTown the previous town to set
	 */
	public void setPreviousTown(Town prevTown) {
		
		this.previousTown = prevTown;
	}
	
	/**
	 * 
	 * @param prevRoad the previous road to set
	 */
	public void setPreviousRoad(Road prevRoad) {
		
		this.previousRoad = prevRoad;
	}
	
	/**
	 * ACCESSORS/GETTERS
	 */
	
	/**
	 * 
	 * @return totalDistance the total distance to return
	 */
	public int getTotalDistance() {
		
		return totalDistance;
	}
	
	/**
	 * 
	 * @return previousTown the previous town
	 */
	public Town getPreviousTown() {
		
		return previousTown;
	}
	
	/**
	 * 
	 * @return previousRoad the previous road
	 */
	public Road getPreviousRoad() {
		
		return previousRoad;
	}
	
	/**
	 * 
	 * @return roadList the list containing all roads
	 */
	public ArrayList<Road> getRoadList() {
		
		return roadList;
	}
}
