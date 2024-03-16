/**
 * @author Mohammad Danyal
 */
public class WeakPasswordException extends Exception {

	/**
	 * Exception class to throw WeakPasswordException
	 */
	public WeakPasswordException() {
		
		super("The password is OK but weak - it contains fewer than 10 characters.");
	}

}
