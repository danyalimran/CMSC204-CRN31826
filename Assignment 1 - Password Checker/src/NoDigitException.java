/**
 * @author Mohammad Danyal
 */
public class NoDigitException extends Exception {

	/**
	 * Exception class to throw NoDigitException
	 */
	public NoDigitException() {
		
		super("The password must contain at least one digit");
	}
	
}
