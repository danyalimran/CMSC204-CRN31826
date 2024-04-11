import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * STUDENT test for MorseCodeTree Class
 */
class MorseCodeTree_STUDENT_Test {

	MorseCodeTree testTree;

	ArrayList<String> testTreeToArrayList;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.testTree = new MorseCodeTree();
		
		testTreeToArrayList = new ArrayList<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
		
		this.testTree = null;
	}

	@Test
	void test() {
		
	}

	@Test
	public void testAddNode() {
		
	    assertEquals("a", testTree.getRoot().getLeftChild().getRightChild().getData());
	    
	    assertEquals("z", testTree.getRoot().getRightChild().getRightChild().getLeftChild().getLeftChild().getData());
	    
	    assertEquals("k", testTree.getRoot().getRightChild().getLeftChild().getRightChild().getData());
	    
	    assertEquals("r", testTree.getRoot().getLeftChild().getRightChild().getLeftChild().getData());
	    
	    assertEquals("o", testTree.getRoot().getRightChild().getRightChild().getRightChild().getData());
	}
	
	@Test
	public void testFetchNode() {
		
		assertEquals(testTree.fetchNode(testTree.getRoot(), "-.."), "d");
		
		assertEquals(testTree.fetchNode(testTree.getRoot(), ".--"), "w");
		
		assertEquals(testTree.fetchNode(testTree.getRoot(), "-.--"), "y");
		
		assertEquals(testTree.fetchNode(testTree.getRoot(), ".-.."), "l");
		
		assertEquals(testTree.fetchNode(testTree.getRoot(), "--"), "m");
	}
	
	@Test
	public void testToArrayList() {
		
		ArrayList<String> testList = new ArrayList<String>();
		
		testList.add("h");
	    testList.add("s");
	    testList.add("v");
	    testList.add("i");
	    testList.add("f");
	    testList.add("u");
	    testList.add("e");
	    testList.add("l");
	    testList.add("r");
	    testList.add("a");
	    testList.add("p");
	    testList.add("w");
	    testList.add("j");
	    testList.add("");
	    testList.add("b");
	    testList.add("d");
	    testList.add("x");
	    testList.add("n");
	    testList.add("c");
	    testList.add("k");
	    testList.add("y");
	    testList.add("t");
	    testList.add("z");
	    testList.add("g");
	    testList.add("q");
	    testList.add("m");
	    testList.add("o");
		
		assertEquals(testList, testTree.toArrayList());
	}
	
	@Test
	 public void testmorseCodeConverterConvertToEnglish() {
			
			String testConverter = MorseCodeConverter.convertToEnglish("-.-. --- -- .--. ..- - . .-. / ... -.-. .. . -. -.-. . / .. ... / ..-. ..- -.");
			assertEquals("computer science is fun", testConverter);
	}
	
	@Test
	public void testLNRoutputTraversal() {
		
		testTree.LNRoutputTraversal(testTree.getRoot(), testTreeToArrayList);
		
		assertEquals(testTreeToArrayList.toString(), "[h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o]");
	}
}
