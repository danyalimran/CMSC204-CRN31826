import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {

ArrayList<String> testList = new ArrayList<String>();
	
	CourseDBStructure structure;
	
	CourseDBElement courseOne;
	CourseDBElement courseTwo;
	CourseDBElement courseThree;
	CourseDBElement courseFour;
	
	@BeforeEach
	void setUp() throws Exception {
		
		structure = new CourseDBStructure(12);
		
		courseOne = new CourseDBElement("CMSC140", 202330, 4, "SC426", "Kash Tajammul");
        courseTwo = new CourseDBElement("CMSC203", 20984, 4, "SW211", "Ahmed Tarek");
        courseThree = new CourseDBElement("CMSC204", 202430, 4, "SW217", "Huseyin Aygun");	
		courseFour = new CourseDBElement("CMSC207", 330202, 4, "SW303", "Jason Lee");
	}

	@AfterEach
	void tearDown() throws Exception {
		
		structure = null;
		
		courseOne = null;
		courseTwo = null;
		courseThree = null;
		courseFour = null;
	}

	@Test
	void test() {
		
	}
	
	/**
	 * Test to check the checkPrime() method for prime numbers
	 */
	@Test
	public void testPrimeCheck() {
		
		// Prime numbers to check if the checkPrime() method passes (returns true)
		assertTrue(checkPrime(2));
		assertTrue(checkPrime(3));
		assertTrue(checkPrime(5));
		assertTrue(checkPrime(7));
	}
	
	/**
	 * Test to check the checkPrime() method for non prime numbers
	 */
	@Test
	public void testNotPrimeCheck() {
		
		// Non prime numbers to check if the checkPrime() method fails (returns false)
		assertFalse(checkPrime(1));
		assertFalse(checkPrime(4));
		assertFalse(checkPrime(6));
		assertFalse(checkPrime(8));
	}
	
	/**
	 * Test to check the compareTo() method
	 */
	@Test
	public void testCompareTo() {
		
		// Compare courses one and two
		assertTrue(courseOne.compareTo(courseTwo) > 0);
		
		// Compare courses two and three
		assertTrue(courseTwo.compareTo(courseThree) < 0);
		
		// Compare courses three and four
		assertTrue(courseThree.compareTo(courseFour) < 0);
		
		// Compare courses one and four (same crn)
		assertTrue(courseOne.compareTo(courseFour) != 0);
	}
	
	/**
	 * Test to check the add method
	 */
	@Test
	public void testAdd() {
		
			structure.add(courseOne);
			assertEquals(structure.hashTable[10].get(0), courseOne);
			
			// Checks the scenario where a course that already exists get added
			structure.add(courseOne);
			assertEquals(structure.hashTable[10].get(0), courseOne);
			
			structure.add(courseTwo);
			assertEquals(structure.hashTable[1].get(0), courseTwo);
			
			structure.add(courseThree);
			assertEquals(structure.hashTable[0].get(0), courseThree);
			
			structure.add(courseFour);
			assertEquals(structure.hashTable[10].get(1), courseFour);		
	}
	
	/**
	 * Test to check the get method
	 */
	@Test
	public void testGetCRN() {
		
			structure.add(courseOne);
			try {
				assertEquals(structure.get(202330), courseOne);
				assertTrue("Did not throw IOException",true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				assertTrue("Successfully threw IOException",false);
				e.printStackTrace();
			}
			
			// Checks the scenario where a course that already exists get added
			structure.add(courseOne);
			try {
				assertEquals(structure.get(202330), courseOne);
				assertTrue("Did not throw IOException",true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				assertTrue("Successfully threw IOException",false);
				e.printStackTrace();
			}
			
			structure.add(courseTwo);
			try {
				assertEquals(structure.get(20984), courseTwo);
				assertTrue("Did not throw IOException",true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				assertTrue("Successfully threw IOException",false);
				e.printStackTrace();
			}
			
			structure.add(courseThree);
			try {
				assertEquals(structure.get(202430), courseThree);
				assertTrue("Did not throw IOException",true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				assertTrue("Successfully threw IOException",false);
				e.printStackTrace();
			}
			
			structure.add(courseFour);
			try {
				assertEquals(structure.get(330202), courseFour);
				assertTrue("Did not throw IOException",true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				assertTrue("Successfully threw IOException",false);
				e.printStackTrace();
			}		
	}

	/**
	 * Test to check the show all method
	 */
	@Test
	public void testShowAll() {
		
		structure.add(courseOne);
		structure.add(courseTwo);
		structure.add(courseThree);
		
		ArrayList<String> courses = structure.showAll();
		
		assertEquals(courses.get(0),"\nCourse:CMSC204 CRN:202430 Credits:4 Instructor:Huseyin Aygun Room:SW217");
		assertEquals(courses.get(1),"\nCourse:CMSC203 CRN:20984 Credits:4 Instructor:Ahmed Tarek Room:SW211");
		assertEquals(courses.get(2),"\nCourse:CMSC140 CRN:202330 Credits:4 Instructor:Kash Tajammul Room:SC426");
	}
	
	/**
	 * This method checks if a given number (passed in) is prime
	 * @param n is the number to check
	 * @return true (prime) or false (not prime)
	 */
	private static boolean checkPrime(int n) {
		
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
