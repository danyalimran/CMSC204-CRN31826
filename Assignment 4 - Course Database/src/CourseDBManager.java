/**
 * @author Mohammad Danyal
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CourseDBManager class
 */
public class CourseDBManager implements CourseDBManagerInterface {

	// create a data base
	CourseDBStructure dataBase = new CourseDBStructure(20);
	
	CourseDBElement returnCourse = null;
	
	/**
	 * No-arg constructor
	 */
	public CourseDBManager() {
		
		
	}
	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		
		// Course that needs to be added
		CourseDBElement courseInfo = new CourseDBElement(id, crn, credits, roomNum, instructor);
		
		// Add the course in the data base
		dataBase.add(courseInfo);
	}

	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
		// TODO Auto-generated method stub
		
		try {
			return dataBase.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	

	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@SuppressWarnings("resource")
	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner fileScanner = new Scanner(input);
		
		try {
			
			if (fileScanner.hasNext() == false) {
				
				throw new FileNotFoundException();
			}
			
			else {
				
				while (fileScanner.hasNext()) {
					
					String courseID = fileScanner.next();
					int courseCRN = Integer.valueOf(fileScanner.nextInt());
					int credits = Integer.valueOf(fileScanner.nextInt());
					String roomNum = fileScanner.next();
					String professorName = fileScanner.nextLine();
					
					CourseDBElement CourseDBElementObject = new CourseDBElement(courseID, courseCRN, credits, roomNum, professorName);
					
					dataBase.add(CourseDBElementObject);
				}	
			}
			
		}
		
		finally {
			
			fileScanner.close();
		}
		
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
		
		return dataBase.showAll();
	}
	
}
