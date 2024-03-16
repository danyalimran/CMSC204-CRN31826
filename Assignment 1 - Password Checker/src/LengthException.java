/**
 * @author Mohammad Danyal
 */
public class LengthException extends Exception {

	/**
	 * Exception class to throw LengthException
	 */
	public LengthException() {
		
		super("The password must be at least 6 characters long");
	}
	
}
