/**
 * @author Mohammad Danyal
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student test for double linked list
 */
class DoubleLinkedList_STUDENT_Tests {

	BasicDoubleLinkedList<String> basicList;
	SortedDoubleLinkedList<String> sortedList;
	StringComparator compareStrings = new StringComparator();
	
	/**
	 * 
	 * set up method
	 * @throws Exception if fails
	 */
	@BeforeEach
	void setUp() throws Exception {
		basicList = new BasicDoubleLinkedList<String>();
		basicList.addToEnd("apple");
		basicList.addToEnd("cat");
		basicList.addToEnd("dog");
		
	}

	/**
	 * 
	 * tear down method
	 * @throws Exception if fails
	 */
	@AfterEach
	void tearDown() throws Exception {
		
		basicList = null;
	}

	/**
	 * 
	 * test method
	 */
	@Test
	void test() {
		assertEquals(3, basicList.getSize());
		assertEquals("dog", basicList.retrieveLastElement());
		assertEquals(2, basicList.getSize());
		ArrayList<String> items = basicList.toArrayList();
		assertEquals(2, items.size());
	}
	
	/**
	 * 
	 * tests the remove method
	 */
	@Test
	void testRemoveMethod() {
		basicList.remove("dog", compareStrings);
		assertEquals(2, basicList.getSize());
		
	}
	
	/**
	 * 
	 * tests the has next method
	 */
	@Test
	void testIteratorHasNext() {
		ListIterator<String> it = basicList.iterator();
		assertEquals(it.next(), "apple");
		assertEquals(it.next(), "cat");
		assertEquals(it.next(), "dog");
		assertFalse(it.hasNext());
	}
	
	/**
	 * 
	 * tests the next method
	 */
	@Test
	void testIteratorNext() {
		ListIterator<String> it = basicList.iterator();
		assertEquals(it.next(), "apple");
	}
	
	/**
	 * 
	 * tests the has previous method
	 */
	@Test
	void testIteratorHasPrevious() {
		ListIterator<String> it = basicList.iterator();
		assertFalse(it.hasPrevious());
	}
	
	/**
	 * 
	 * tests the previous method
	 */
	@Test
	void testIteratorPrevious() {
		ListIterator<String> it = basicList.iterator();
		assertEquals(it.next(), "apple");
		assertEquals(it.next(), "cat");
		assertEquals(it.previous(), "cat");
	}
	
	/**
	 * 
	 * String comparator class
	 */
	private class StringComparator implements Comparator<String>
	{

		/**
		 * 
		 * compare strings
		 */
		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}

}

