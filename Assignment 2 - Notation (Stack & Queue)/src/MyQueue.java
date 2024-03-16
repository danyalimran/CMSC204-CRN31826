/**
 * @author Mohammad Danyal
 */
import java.util.ArrayList;

/**
 * 
 * @param <T> generic type
 */
public class MyQueue<T> implements QueueInterface<T> {

	private final T[] queueArray;
	private int arrayIndex;
	
	/**
	 * 
	 * @param arraySize, the size of the array
	 */
	@SuppressWarnings("unchecked")
	public MyQueue(int arraySize) {
	
		arrayIndex = 0;
	    queueArray = (T[]) new Object[arraySize];
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue() {
		
		arrayIndex = 0;
		queueArray = (T[]) new Object[30];
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		
		if (arrayIndex == 0) {
			
			return true;
		}
	
		return false;
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		
        if (arrayIndex == queueArray.length) {
			
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return element, the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		
		T element = null;
			
            	if (arrayIndex == 0) {
        			
            		throw new QueueUnderflowException();
        		}
				
				element = queueArray[0];
			
			for (int i = 0; i < size() - 1; i++) {
				
				queueArray[i] = queueArray[i + 1];
			}
            
			queueArray[arrayIndex - 1] = null;
			arrayIndex--;
			
	    // TODO Auto-generated method stub
		return element;
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		
		// TODO Auto-generated method stub
		return arrayIndex;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		
		if (arrayIndex == queueArray.length) {
			
    		throw new QueueOverflowException();
		}
		
		/** for (int i = size() + 1; i < queueArray.length; i++) {
			
			queueArray[i] = (T) e;
		}
		
		return true;
		*/
		
		queueArray[arrayIndex++] = (T) e;
		
		// TODO Auto-generated method stub
		return true;
		
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		
        String stringElement = "";
		
		for (int i = 0; i < size(); i++) {

			if (i == size() - 1) {
				
				stringElement += queueArray[i].toString();
			}
			
			else {
				
			    stringElement += queueArray[i].toString() + delimiter;
			}
		}
		
		// TODO Auto-generated method stub
		return stringElement;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		
		 String stringElement = "";
			
		 for (int i = 0; i < size(); i++) {
			
			stringElement += queueArray[i].toString();
		 }
		 
		// TODO Auto-generated method stub
		 return stringElement;
	}

	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	  */
	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList list) throws QueueOverflowException {
		
		@SuppressWarnings("unused")
        T temp;
		
		for (int i = 0; i < list.size(); i++) {
			
			 if (arrayIndex == queueArray.length) {
					
					throw new QueueOverflowException();
				}
			
			temp = (T) list.get(i);
			enqueue(temp);
		}
		
	}
	// TODO Auto-generated method stub
	}