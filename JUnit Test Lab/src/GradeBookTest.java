import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	int size = 5;
	
	GradeBook gradeBookObject1 = new GradeBook(size); 
	GradeBook gradeBookObject2 = new GradeBook(size); 	
	
	@BeforeEach
	void setUp() throws Exception {
	
		// Calling the addScore() method for gradeBookObject1 three times
		gradeBookObject1.addScore(50);
		gradeBookObject1.addScore(70);
		gradeBookObject1.addScore(90);
		
		// // Calling the addScore() method for gradeBookObject2 three times
		gradeBookObject2.addScore(40);
		gradeBookObject2.addScore(60);
		gradeBookObject2.addScore(80);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		gradeBookObject1 = null;
		gradeBookObject2 = null;
	}

	@Test
	void testAddScore() {
		
	//	assertEquals(gradeBookObject1.toString(), " ");
		
		assertTrue(gradeBookObject1.toString().equals("50.0 70.0 90.0 0.0 0.0 "));
		assertTrue(gradeBookObject2.toString().equals("40.0 60.0 80.0 0.0 0.0 "));
		
		assertEquals(3, gradeBookObject1.getScoreSize(), 0.001);
		//assertEquals(70, gradeBookObject1.getScoreSize(), 0.001);
		//assertEquals(90, gradeBookObject1.getScoreSize(), 0.001);
		
		assertEquals(3, gradeBookObject2.getScoreSize(), 0.001);
		//assertEquals(60, gradeBookObject2.getScoreSize(), 0.001);
		//assertEquals(80, gradeBookObject2.getScoreSize(), 0.001);
	}

	@Test
	void testSum() {
		
		assertEquals(210, gradeBookObject1.sum(), 0.001);
		assertEquals(180, gradeBookObject2.sum(), 0.001);
		
	}

	@Test
	void testMinimum() {
		
		assertEquals(50, gradeBookObject1.minimum(), 0.001);
		assertEquals(40, gradeBookObject2.minimum(), 0.001);
		
	}


	@Test
	void testFinalScore() {
		
		assertEquals(160, gradeBookObject1.finalScore(), 0.001);
		assertEquals(140, gradeBookObject2.finalScore(), 0.001);
		
	}
}
