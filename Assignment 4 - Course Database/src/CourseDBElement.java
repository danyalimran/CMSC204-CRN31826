/**
 *@author Mohammad Danyal 
 */

/**
 * CourseDBElement class
 */
public class CourseDBElement implements Comparable<Object> {

	public String id = "";
	public String roomNum = "";
	public String instructor = "";
	public int crn = 0;
	public int credits = 0;
	
	/**
	 * No-arg constructor
	 */
	public CourseDBElement() {
		
		
	}
	
	/**
	 * @param courseID - the course ID
	 * @param lectureRoomNum - the lecture room number
	 * @param professorName - the name of the Professor
	 * @param courseCRN - CRN of the course
	 * @param numOfCredits - the number of credits for the course
	 */
	public CourseDBElement(String courseID, int courseCRN, int numOfCredits, String lectureRoomNum, String professorName) {
		
		this.id = courseID;
		this.roomNum = lectureRoomNum;
		this.instructor = professorName;
		this.crn = courseCRN;
		this.credits = numOfCredits;
	}
	
	/**
	 * MUTATORS/SETTERS
	 */
	
	/**
	 * 
	 * @param courseID set course Id
	 */
	public void setID(String courseID) {
		
		this.id = courseID;
	}
	
	/**
	 * 
	 * @param lectureRoomNum set lecture room number
	 */
	public void setRoomNum(String lectureRoomNum) {
		
		this.roomNum = lectureRoomNum;
	}
	
	/**
	 * 
	 * @param professorName set the Professor name
	 */
	public void setInstructor(String professorName) {
		
		this.instructor = professorName;
	}
	
	/**
	 * 
	 * @param courseCRN set the CRN
	 */
	public void setCRN(int courseCRN) {
		
		this.crn = courseCRN;
	}
	
	/**
	 * 
	 * @param numOfCredits set the number of credits
	 */
	public void setCredits (int numOfCredits) {
		
		this.credits = numOfCredits;
	}
	
	/**
	 * ACCESSORS/GETTERS
	 */
	
	/**
	 * 
	 * @return the Id
	 */
	public String getID() {
		
		return id;
	}
	
	/**
	 * 
	 * @return the room number
	 */
	public String getRoomNum() {
		
		return roomNum;
	}
	
	/**
	 * 
	 * @return the instructor
	 */
	public String getInstructor() {
		
		return instructor;
	}
	
	/**
	 * 
	 * @return the CRN
	 */
	public int getCRN() {
		
		return crn;
	}
	
	/**
	 * 
	 * @return the number of credits
	 */
	public int getCredits() {
		
		return credits;
	}
	
	/**
	 * Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 * @param o - the object to be compared
	 * @return 0, if the object is equal. Returns a positive integer if the value is grater. Returns a negative integer if the value is less
	 * @throws NullPointerException if the object is null
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		
		CourseDBElement tempElement = (CourseDBElement) o;
		
		int returnValue = 0;
		
		if (o == null) {
			
			throw new NullPointerException();
		}
		
		else {
			
			// returns 0 if equal
			if (crn == tempElement.getCRN()) {
				
				returnValue = 0;
			}
			
			// returns 1 (positive integer) if greater
			else if (crn > tempElement.getCRN()) {
				
				returnValue = 1;
			}
			
			// returns -1 (negative integer) if less 
			else if (crn < tempElement.getCRN()) {
				
				returnValue = -1;
			}
			
		}
		
		return returnValue;
	}

}
