/**
 *@author Mohammad Danyal 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.LinkedList;

/**
 * CourseDBStructure class
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	LinkedList<CourseDBElement>[] hashTable;

	int hashTableSize = 0;
	int minimumSizeRequired = 0;
	int hashTableIndex = 0;
	
	// The loading factor (divide the number of courses by it)
	final double loadingFactor = 1.5;
	
	/**
	 * No-arg constructor
	 */
	public CourseDBStructure() {
		
		
	}
	
	/**
	 * Determines the size of the hash table
	 * @param n the estimated number of courses
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int n) {
		
		boolean primeFound = false;
		boolean primeLargeEnoughFound = false;
		
		// Determine the minimum size required
		minimumSizeRequired = (int) (n / loadingFactor);
		
		while (primeFound == false) {
			
			for (int k = 0; !primeLargeEnoughFound; k++) {
				
				hashTableSize = (4 * k) + 3;
				
				if (checkPrime(hashTableSize) == true && hashTableSize > minimumSizeRequired) {
					
					primeLargeEnoughFound = true;
					primeFound = true;
					
					hashTable = new LinkedList[hashTableSize];
				}
				
			}
			
		}
		
	}
	
	/**
	 * 
	 * @param Testing used for testing
	 * @param size the size of the hash table
	 */
	public CourseDBStructure(String Testing, int size) {
		
		this.hashTableSize = size;
		
		hashTable = new LinkedList[hashTableSize];
	}
	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly (replace it)
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		
		int addCRN = 0;
		int intCRN = 0;
		int hashCode = 0;
		String objectCRN = Integer.toString(element.getCRN());
		
		for (int i = 0; i < objectCRN.length(); i++) {
			
			intCRN = Character.getNumericValue(objectCRN.charAt(i));
			
			addCRN += intCRN;
		}
		
		hashCode = (addCRN % hashTableSize);
		
		// The corresponding list at the hash code
		LinkedList<CourseDBElement> correspondingList = hashTable[hashCode];
		
		/**
		 * Case 1 - if there is no list at the specific hash code (index)
		 */
		if (hashTable[hashCode] == null) {
			
			hashTable[hashCode] = new LinkedList<CourseDBElement>();
			
			hashTable[hashCode].add(element);
		}
		
		/**
		 * Case 2
		 */
		else {
					
				for (int i = 0; i < correspondingList.size(); i++) {
						
					// If the same course (CRN) is being added again then replace it with the existing one
					if (((element.compareTo(correspondingList.get(i))) == 0)) {
						
						// Replace the course
						correspondingList.set(i, element);
					}
					
					// If the course does not exist in the table/list
					else if (((element.compareTo(correspondingList.get(i))) > 0) || ((element.compareTo(correspondingList.get(i))) < 0)) {
							
						correspondingList.add(element);
					}
				}
		}
		
	}

	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		// TODO Auto-generated method stub
		
		int addCRN = 0;
		int intCRN = 0;
		int hashCode = 0;
		String objectCRN = Integer.toString(crn);
		
		for (int i = 0; i < objectCRN.length(); i++) {
			
			intCRN = Character.getNumericValue(objectCRN.charAt(i));
			
			addCRN += intCRN;
		}
		
		hashCode = (addCRN % hashTableSize);
		
		// The corresponding list at the hash code
		LinkedList<CourseDBElement> correspondingList = hashTable[hashCode];
		
		if (correspondingList == null) {
			
			throw new IOException();
		}
		
		else {
			
			for (int i = 0; i < correspondingList.size(); i++) {
				
				if (crn == correspondingList.get(i).getCRN()) {
					
					return correspondingList.get(i);
				}
				
			}
			
		}
		
		return null;
	}

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		
		ArrayList<String> strRepOfCoursesArrayList = new ArrayList<String>();
		
		String strRepOfCourse = "";
		String strRepOfCRN = "";
		String strRepOfCredits = "";
		String strRepOfInstructor = "";
		String strRepOfRoom = "";
		String showCourse = "";
		
		for (int i = 0; i < hashTable.length; i++) {
		
			if (hashTable[i] != null) {
				
				for (int j = 0; j < hashTable[i].size(); j++) {
					
					// Get the course
					strRepOfCourse = hashTable[i].get(j).getID();
					
					// Change the data type of CRN to String
					strRepOfCRN = Integer.toString(hashTable[i].get(j).getCRN());
					
					// Change the data type of Credits to String
					strRepOfCredits = Integer.toString(hashTable[i].get(j).getCredits());
					
					// Get the instructor
					strRepOfInstructor = hashTable[i].get(j).getInstructor();
					
					// Get the room number
					strRepOfRoom = hashTable[i].get(j).getRoomNum();
					
					// Put the course information in the correct format
					showCourse = "\nCourse:" + strRepOfCourse + " " + "CRN:" + strRepOfCRN + " " + "Credits:" + strRepOfCredits + " " + "Instructor:" + strRepOfInstructor + " " + "Room:" + strRepOfRoom;
					
					// Add the course information in the Array List
					strRepOfCoursesArrayList.add(showCourse);
				}
			}
		}
		
		return strRepOfCoursesArrayList;
	}

	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		
		return hashTableSize;
	}

	/**
	 * This method checks if a number is Prime
	 * @param n
	 * @return
	 */
	private boolean checkPrime(int n) {
		
		int number = 2;
		boolean numIsPrime = true;
		
		if (n == 0) {
			
			return false;
		}
		
		else if (n == 1) {
			
			return false;
		}

		while (number < n && numIsPrime == true) {
			
			if (n % number == 0) {
				
				numIsPrime = false;
			}
			
			number++;
		}
		
		return numIsPrime;
	}
	
}
