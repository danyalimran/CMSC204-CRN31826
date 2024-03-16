/**
 * @author Mohammad Danyal
 */
public class NoUpperAlphaException extends Exception {

	/**
	 * Exception class to throw NoUpperAlphaException
	 */
	public NoUpperAlphaException() {
		
		super("The password must contain at least one uppercase alphabetic character");
	}
	
}
