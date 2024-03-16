/**
 * @author Mohammad Danyal
 */
public class NoLowerAlphaException extends Exception {

	/**
	 * Exception class to throw NoLowerAlphaException
	 */
	public NoLowerAlphaException() {
		
		super("The password must contain at least one lowercase alphabetic character");
	}
	
}
