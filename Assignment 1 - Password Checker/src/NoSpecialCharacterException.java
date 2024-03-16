/**
 * @author Mohammad Danyal
 */
public class NoSpecialCharacterException extends Exception {

	/**
	 * Exception class to throw NoSpecialCharacterException
	 */
	public NoSpecialCharacterException() {
		
		super("The password must contain at least one special character");
	}
	
}
