/**
 * @author Mohammad Danyal
 */

import java.util.Comparator;
import java.util.ListIterator;

/**
 * SortedDoubleLinkedList extends BasicDoubleLinkedList
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	Comparator<T> comparator = null;
	
	/**
	 * 
	 * Constructor
	 * @param compareableObject - create an instance variable and assign compareableObject to it
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> compareableObject) {
		
		super();
		
		this.comparator = compareableObject;
	}
	
	/**
	 * Checks if the data is greater or less than the current nodes data and adds it accordingly
	 * @param data - the data to be added
	 */
	public void add(T data) {

		// Node object
		Node insertNode = new Node(data);
		
		// The left node
		Node leftNode = basicDoubleLinkedListHead;
		
		// The right node
		Node rightNode = null;
		
		// If the Head is not null only then will we have a right node
		if (basicDoubleLinkedListHead != null) {
			
			rightNode = basicDoubleLinkedListHead.next;
		}
		
		boolean insertionPointFound = false;
		
		// If the size is 0
		if (basicDoubleLinkedListSize == 0) {
			
			// There will be only one node, so head and tail point to the same node
			basicDoubleLinkedListHead = insertNode;
			basicDoubleLinkedListTail = insertNode;
			
			// Size is increased after adding a new node
			basicDoubleLinkedListSize++;
		}
		
		else {
			
				// If the node has to be added before the head, meaning it is smaller than the head
				if ((comparator.compare(data, basicDoubleLinkedListHead.data)) < 0) {
					
					insertNode.next = basicDoubleLinkedListHead;
					basicDoubleLinkedListHead.prev = insertNode;
					basicDoubleLinkedListHead = insertNode;
					
					// Size is increased after adding a new node
					basicDoubleLinkedListSize++;
				}
				
				// If the node has to be added after the tail, meaning it is grater than the tail
				else if ((comparator.compare(data, basicDoubleLinkedListTail.data)) > 0) {
					
					insertNode.prev = basicDoubleLinkedListTail;
					basicDoubleLinkedListTail.next = insertNode;
					basicDoubleLinkedListTail = insertNode;
					
					// Size is increased after adding a new node
					basicDoubleLinkedListSize++;
				}
				
					// While we do not found the right insertion point and our right node is not equal to null (end of list is not reached) we traverse through the entire list
					while (insertionPointFound == false && rightNode != null) {
				
							if ((comparator.compare(data, leftNode.data)) > 0 && (comparator.compare(data, rightNode.data)) < 0) {
					
								// Means we have found the insertion point and the loop stops
								insertionPointFound = true;
								
								// The new nodes next points to the right node and its previous points to the left node, thus it gets added in between the left and right node
								insertNode.next = rightNode;
								insertNode.prev = leftNode;
								
								// The right nodes previous points to the new node and the left nodes next points to the new node
								rightNode.prev = insertNode;
								leftNode.next = insertNode;
								
								// Size is increased after adding a new node
								basicDoubleLinkedListSize++;
							}
				
							// left node now becomes the next node (right node) and the right node is now the one after it, so right.next
							leftNode = rightNode;
							rightNode = rightNode.next;
					}
		}
	}
	
	/**
	 * 
	 * @throws UnsupportedOperationException - throw this exception
	 */
	@Override
	public void addToEnd(T data) throws java.lang.UnsupportedOperationException {
		
		
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * 
	 * @throws UnsupportedOperationException - throw this exception
	 */
	@Override
	public void addToFront(T data) throws java.lang.UnsupportedOperationException {
		
		
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * 
	 * Calls the super class iterator() method
	 */
	@Override
	public java.util.ListIterator<T> iterator() {
		
		return super.iterator();
	}
	
	/**
	 * 
	 * Calls the super class remove() method
	 */
	public BasicDoubleLinkedList.Node remove(T data, java.util.Comparator<T> comparator) {
		
		return super.remove(data, comparator);
	}
	
}
