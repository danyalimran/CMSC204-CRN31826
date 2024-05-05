import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author Mohammad Danyal
 */

public class CarQueue {

	Queue<Integer> carQueue;
	
	Random addRandomValues;
	
	/** Adds 0,1,2 or 3 to queue
     *  0 = up
     *  1 = down
     *  2 = right
     *  3 = left
     */

	public CarQueue() {
		
		carQueue = new LinkedList<Integer>();
		
		addRandomValues = new Random();
		
		// Add 5 or 6 numbers in the queue
		carQueue.add(addRandomValues.nextInt(4));
		carQueue.add(addRandomValues.nextInt(4));
		carQueue.add(addRandomValues.nextInt(4));
		carQueue.add(addRandomValues.nextInt(4));
		carQueue.add(addRandomValues.nextInt(4));
		carQueue.add(addRandomValues.nextInt(4));
		
	}
	
	public void addToQueue() {
		
			// Inner class that implements Runnable
			class addToQueRunnableInnerClass implements Runnable {
	
					/**
					 * Add random directions and then sleep
					 */
					@Override
					public void run() {
						// TODO Auto-generated method stub
							
							try {
								
								while (true) {
									
									carQueue.add(addRandomValues.nextInt(4));
									Thread.sleep(10);
								}
								
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
					}
				
				
			}
		
			// Create and instance of the class
			addToQueRunnableInnerClass myAddToQueRunnableInnerClass = new addToQueRunnableInnerClass();
			
			// Thread object
			Thread threadForAddToQueRunnableInnerClass = new Thread(myAddToQueRunnableInnerClass);
			
			// Start the thread
			threadForAddToQueRunnableInnerClass.start();
	}
	
	/**
	 * A deleteQueue method that returns an Integer
	 * @return the removed integer
	 */
	public int deleteQueue() {
		
//		int deleteQueueValue = 0;
	int	deleteQueueValue = carQueue.remove();
		
		return deleteQueueValue;
	}
}
