/**
 * @author Mohammad Danyal
 */
public class InvalidSequenceException extends Exception {

	/**
	 * Exception class to throw InvalidSequenceException
	 */
	public InvalidSequenceException() {
		
		super("The password cannot contain more than two of the same letters in a sequence");
	}
	
}
