/**
 * @author Mohammad Danyal
 */
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	
	private final T[] stackArray;
	private int arrayIndex;
	
	@SuppressWarnings("unchecked")
	public MyStack(int arraySize) {
		
		arrayIndex = 0;
		stackArray = (T[]) new Object[arraySize];
	}
	
	@SuppressWarnings("unchecked")
	public MyStack() {
		
		arrayIndex = 0;
		stackArray = (T[]) new Object[30];
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		
	    if(arrayIndex == 0) {
			
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		
		if (arrayIndex == stackArray.length) {
			
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
	
		if (arrayIndex == 0) {
			
	        throw new StackUnderflowException();
	        }
		
		T data = null;
		
		data = stackArray[arrayIndex - 1];
		
		stackArray[arrayIndex - 1] = null;
		arrayIndex--;
		
		// TODO Auto-generated method stub
		return data;
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		
         if (arrayIndex == 0) {
			
	        throw new StackUnderflowException();
	        }
		
		T data = null;
		
		data = stackArray[arrayIndex - 1];
		
		// TODO Auto-generated method stub
		return data;
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		
		int stackSize = 0;
		stackSize = stackArray.length;
		int numOfElements = 0;
		
		for (int i = 0; i < stackSize; i++) {
			
			if (stackArray[i] != null) {
				
				numOfElements++;
			}
		}
		
		// TODO Auto-generated method stub
		return numOfElements;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		
        if (arrayIndex == stackArray.length) {
			
			throw new StackOverflowException();
		}
		
		stackArray[arrayIndex] = e;
        arrayIndex++;
		
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		
		String stringElement = "";
		
		for (int i = 0; i < size(); i++) {
			
			if (i == size() - 1) {
				
				stringElement += stackArray[i].toString();
			}
			
			else {
				
			    stringElement += stackArray[i].toString() + delimiter;
			}
		}
		
		// TODO Auto-generated method stub
		return stringElement;
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		
         String stringElement = "";
		
		 for (int i = 0; i < size(); i++) {
			
			stringElement += stackArray[i].toString();
		 }
		 
		// TODO Auto-generated method stub
		 return stringElement;
	}
	
	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList list) throws StackOverflowException {
		
		@SuppressWarnings("unused")
		T temp;
		
		for (int i = 0; i < list.size(); i++) {
			
			 if (arrayIndex == stackArray.length) {
					
					throw new StackOverflowException();
				}
			
			temp = (T) list.get(i);
			push(temp);
		}
		
	}

	// TODO Auto-generated method stub
}
