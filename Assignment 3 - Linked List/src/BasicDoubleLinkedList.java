/**
 * @author Mohammad Danyal
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * BasicDoubleLinkedList extends Object implements Iterable
 */
public class BasicDoubleLinkedList<T> extends java.lang.Object implements java.lang.Iterable<T> {
	
	Node basicDoubleLinkedListHead;
	Node basicDoubleLinkedListTail;
	int basicDoubleLinkedListSize;
	
	/**
	 * Constructor to initialize head & tail to null, and size to 0
	 */
	public BasicDoubleLinkedList() {
		
		this.basicDoubleLinkedListHead = null;
		this.basicDoubleLinkedListTail = null;
		this.basicDoubleLinkedListSize = 0;
	}
	
	/**
	 * 
	 * @return basicDoubleLinkedListSize - the size of the basic double linked list
	 */
	public int getSize() {
		
		return basicDoubleLinkedListSize;
	}
	
	/**
	 * 
	 * @param data - the data to be added at the end of the list
	 */
	public void addToEnd(T data) {
		
		 // new node to be added at the end of the basic double linked list
		Node endNode = new Node(data);
		
		// If the size is 0, the head and tail point to the same node
		if (basicDoubleLinkedListSize == 0) {
			
			basicDoubleLinkedListHead = endNode;
			basicDoubleLinkedListTail = endNode;
		}
		
		else {
				endNode.prev = basicDoubleLinkedListTail;
				basicDoubleLinkedListTail.next = endNode;
				basicDoubleLinkedListTail = endNode;
		}
		
		basicDoubleLinkedListSize++;
	}
	
	/**
	 * 
	 * @param data - the data to be added at the front of the list
	 */
	public void addToFront(T data) {
		
		// new node to be added at the front of the basic double linked list
		Node frontNode = new Node(data);
		
		// If the size is 0, the head and tail point to the same node
		if (basicDoubleLinkedListSize == 0) {
			
			basicDoubleLinkedListHead = frontNode;
			basicDoubleLinkedListTail = frontNode;
		}
		
		else {
				frontNode.next = basicDoubleLinkedListHead;
				basicDoubleLinkedListHead.prev = frontNode;
				basicDoubleLinkedListHead = frontNode;
		}
		
		basicDoubleLinkedListSize++;
	}
	
	/**
	 * 
	 * @return the first element in the list
	 */
	public T getFirst() {
		
		// if there are no elements return null
		if (basicDoubleLinkedListSize == 0) {
			
			return null;
		}
		
		else {
			
			return basicDoubleLinkedListHead.data;
		}
				
	}
	
	/**
	 * 
	 * @return the last element in the list
	 */
	public T getLast() {
		
		// if there are no elements return null
		if (basicDoubleLinkedListSize == 0) {
			
			return null;
		}
		
		else {
			
			return basicDoubleLinkedListTail.data;
		}
	}
	
	/**
	 * 
	 * @return DoubleLinkedListIterator
	 */
	public java.util.ListIterator<T> iterator() {
		
		
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * 
	 * @param targetData - the data to compare
	 * @param comparator - the method to compare the object. This method return an integer
	 * @return currentNode - the node that contains data that matches with targetData
	 */
	public BasicDoubleLinkedList<T>.Node remove(T targetData, java.util.Comparator<T> comparator) {
		
		Node currentNode = null;
		int counter = 0;
		boolean reachedEndOfList = false;
		boolean targetDataFound = false;
		
		currentNode = basicDoubleLinkedListHead;
		
		/**
		 * If the basic double linked list size is 0
		 */
		if (basicDoubleLinkedListSize == 0) {
			 
			 return null;
		}
		
		/**
		 * If the basic double linked list size is 1
		 */
		else if (basicDoubleLinkedListSize == 1) {
			
			// If the size is 1, then there's only one node which is both, the head and the tail. So, we can return either one
			if ((comparator.compare(targetData, basicDoubleLinkedListHead.data) == 0)) {
			
				targetDataFound = true;
				currentNode = basicDoubleLinkedListHead;
			
				basicDoubleLinkedListHead = null;
				basicDoubleLinkedListTail = null;
			
				basicDoubleLinkedListSize--;
			}
			
			return currentNode;
		}
		
		/**
		 * If the basic double linked list size is 2
		 */
		else if (basicDoubleLinkedListSize == 2) {
			
			while (targetDataFound == false && reachedEndOfList == false) {
				
				counter++;
				
				// If the size is 2 and the data is found at the head
				if ((comparator.compare(targetData, basicDoubleLinkedListHead.data) == 0)) {
					
					targetDataFound = true;
					currentNode = basicDoubleLinkedListHead;
					
					basicDoubleLinkedListHead = basicDoubleLinkedListTail;
					basicDoubleLinkedListTail.prev = null;
					
                    basicDoubleLinkedListSize--;
				}
				
				// If the size is 2 and the data is found at the tail
				else if ((comparator.compare(targetData, basicDoubleLinkedListTail.data) == 0)) {
					
					targetDataFound = true;
					currentNode = basicDoubleLinkedListTail;
					
					basicDoubleLinkedListTail = basicDoubleLinkedListHead;
					basicDoubleLinkedListHead.next = null;
					
                    basicDoubleLinkedListSize--;
				}
				
				currentNode = currentNode.next;
				
				if (counter < basicDoubleLinkedListSize) {
					
					reachedEndOfList = true;
				}
				
			}
			
		}
		
		/**
		 * If the basic double linked list size is greater than 2
		 */
	else if (basicDoubleLinkedListSize > 2) {
			
		while (targetDataFound == false && reachedEndOfList == false) {
			
			counter++;
			
			if ((comparator.compare(targetData, currentNode.data) == 0)) {
				
				targetDataFound = true;
				
				// If the size is grater than 2, data could still be at the head
				if (currentNode == basicDoubleLinkedListHead) {
					
                    basicDoubleLinkedListHead = basicDoubleLinkedListHead.next;
                    basicDoubleLinkedListHead.prev = null;
                    
                    basicDoubleLinkedListSize--;
				}
				
				// If the size is grater than 2, data could still be at the tail
				else if (currentNode == basicDoubleLinkedListTail) {
					
                    basicDoubleLinkedListTail = basicDoubleLinkedListTail.prev;
                    basicDoubleLinkedListTail.next = null;
                    
                    basicDoubleLinkedListSize--;
				}
				
				// if current node is somewhere in between
				else {
					
					currentNode.prev.next = currentNode.next;
					currentNode.next.prev = currentNode.prev;
                    
                    basicDoubleLinkedListSize--;
				}
				
			}
 			
			currentNode = currentNode.next;
			
			if (counter >= basicDoubleLinkedListSize) {
				
				reachedEndOfList = true;
			}
		}
			
	}
		return currentNode;    
	}
	
	/**
	 * 
	 * @return the element at the front of the list
	 */
	public T retrieveFirstElement() {
		
		T firstElement = null;
		
		// Checks if size is 0
		if (basicDoubleLinkedListSize == 0) {
			
			return null;
		}
		
		else {
			
			// Calls the getFirst() method to return the first element
			firstElement = getFirst();
			
			// The head now points to the next node
			basicDoubleLinkedListHead = basicDoubleLinkedListHead.next;
			
			basicDoubleLinkedListHead.prev = null;
			
			// Size is decremented
			basicDoubleLinkedListSize--;
		} 
		
		return firstElement;
	}
	
	/**
	 * 
	 * @return element at the end of the list
	 */
	public T retrieveLastElement() {
		
		T lastElement = null;
		
		// Checks if size is 0
		if (basicDoubleLinkedListSize == 0) {
			
			return null;
		}
		
		else {
			
			// Calls the getLast() method to return the last element
			lastElement = getLast();
			
			// The tail now points to the previous node
			basicDoubleLinkedListTail = basicDoubleLinkedListTail.prev;
			
			basicDoubleLinkedListTail.next = null;
			
			// Size is decremented
			basicDoubleLinkedListSize--;
		}
		
		return lastElement;
	}
	
	/**
	 * 
	 * @return the Array List
	 */
	public java.util.ArrayList<T> toArrayList() {
		
		ArrayList<T> basicDoubleLinkedListToArrayList = new ArrayList<T>();
		
		Node currentNode = basicDoubleLinkedListHead;
		boolean reachedEndOfList = false;
		
		// While the end of the list is not reached
		while (reachedEndOfList == false) {
			
			// Keep adding elements into the Array List one by one
			basicDoubleLinkedListToArrayList.add(currentNode.data);
			
			currentNode = currentNode.next;
			
			// If the current node is null, it means the end of the list has been reached
			if (currentNode == null) {
				
				// This makes the loop stop
				reachedEndOfList = true;
			}
		}
		
		return basicDoubleLinkedListToArrayList;
	}
	
			/**
			 * public inner class Node
			 */
			public class Node extends java.lang.Object {
		
					T data = null;
					Node prev;
					Node next;
			
					/**
					 * 
					 * Constructor
					 * @param dataNode - create an instance variable and assign dataNode to it
					 */
					public Node(T dataNode) {
			
						this.data = dataNode;
					}
			}
	
			/**
			 * public inner class DoubleLinkedListIterator
			 */
			public class DoubleLinkedListIterator extends java.lang.Object implements java.util.ListIterator<T> {
				
					private Node cursor = basicDoubleLinkedListHead;
				
					/**
					 * 
					 * @return true if has next
					 * @throws NoSuchElementException - if there is no element in the right
					 */
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						
					if (cursor == null) {
						
						return false;
					}
					
					else {
						
						return true;
					}
					
					}

					/**
					 * 
					 * @return element while traversing in the right direction
					 */
					@Override
					public T next() throws java.util.NoSuchElementException {
						// TODO Auto-generated method stub
						
						if (hasNext() == false) {
							
							throw new NoSuchElementException();
						}
						
							T element = cursor.data;
							cursor = cursor.next;
							
							return element;
					}

					/**
					 * 
					 * @return true if has previous
					 */
					@Override
					public boolean hasPrevious() {
						// TODO Auto-generated method stub
						
						if (cursor == basicDoubleLinkedListHead) {
							
							return false;
						}
						
						else {
							
							return true;
						}
						
					}

					/**
					 * 
					 * @return element while traversing in the left direction
					 * @throws NoSuchElementException - if there is no element in the left
					 */
					@Override
					public T previous() throws java.util.NoSuchElementException {
						// TODO Auto-generated method stub
						
						if (hasPrevious() == false) {
							
							throw new NoSuchElementException();
						}
						
						if (cursor == null) {
							
							cursor = basicDoubleLinkedListTail;
						}
						
						else {
							
							cursor = cursor.prev;
						}
						
						return cursor.data;
					}

					/**
					 * 
					 * @throws UnsupportedOperationException - throw this exception
					 */
					@Override
					public int nextIndex() throws UnsupportedOperationException {
						// TODO Auto-generated method stub
						
						throw new UnsupportedOperationException();
					}

					/**
					 * 
					 * @throws UnsupportedOperationException - throw this exception
					 */
					@Override
					public int previousIndex() throws UnsupportedOperationException {
						// TODO Auto-generated method stub
						
						throw new UnsupportedOperationException();
					}

					/**
					 * 
					 * @throws UnsupportedOperationException - throw this exception
					 */
					@Override
					public void remove() throws UnsupportedOperationException {
						// TODO Auto-generated method stub
			
						throw new UnsupportedOperationException();
					}

					/**
					 * 
					 * @throws UnsupportedOperationException - throw this exception
					 */
					@Override
					public void set(T e) throws UnsupportedOperationException {
						// TODO Auto-generated method stub
			
						throw new UnsupportedOperationException();
					}

					/**
					 * 
					 * @throws UnsupportedOperationException - throw this exception
					 */
					@Override
					public void add(T e) throws UnsupportedOperationException {
						// TODO Auto-generated method stub
			
						throw new UnsupportedOperationException();
					}
		
		
			}
}
