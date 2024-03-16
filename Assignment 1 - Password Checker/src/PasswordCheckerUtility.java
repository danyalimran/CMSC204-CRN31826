/**
 * @author Mohammad Danyal
 * @version 1/31/2024
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class starts here and extends Object
 */
public class PasswordCheckerUtility extends java.lang.Object {

	/**
	 * Constructor
	 */
	public PasswordCheckerUtility() {
		
	}
	
	/**
	 * 
	 * @param password is the password to check
	 * @param passwordConfirm is the variable to compare "password" with
	 * @throws UnmatchedException is thrown if passwords do not match
	 */
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException {
			
		if (!password.equals(passwordConfirm)) {
			
			throw new UnmatchedException();
		}
	} 
	
	/**
	 * 
	 * @param password is the password to check
	 * @param passwordConfirm is the variable to compare "password" with
	 * @return true If passwords match, else false
	 */
	 
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		
		if (password.equals(passwordConfirm)) {
		
		return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param password is the password to check
	 * @return true If the length is valid, else Exception is thrown
	 * @throws LengthException is thrown if the password length is not valid
	 */
	public static boolean isValidLength(java.lang.String password) throws LengthException { // Checks the length of the password. If the length is not valid, the system exits. As there is no need to check the rest.
		
		if (password.length() >= 6) {
			
			return true;
		}
		
		else if (password.length() < 6) {
			
			throw new LengthException();
		}

		return false;
	}
	
	/**
	 * 
	 * @param password is the password to check
	 * @return true If the password has between six and nine characters, else false
	 */
	public static boolean hasBetweenSixAndNineChars(java.lang.String password) {
			
		if (password.length() >= 6 && password.length() <= 9) {
				
			return true;
			}
			
		return false;
	}
	
	/**
	 * 
	 * @param password is the password to check
	 * @return true if upper case alphabet is found, else Exception is thrown
	 * @throws NoUpperAlphaException is thrown if no upper case alphabet is found
	 */
	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException {
		
        for (int i = 0; i < password.length(); i++) {
			
			if (Character.isUpperCase(password.charAt(i))) {
				
				return true;
			}
			
		}
		
		throw new NoUpperAlphaException();
	}
	
	/**
	 * 
	 * @param password is the password to check
	 * @return true if lower case alphabet is found, else Exception is thrown
	 * @throws NoLowerAlphaException is thrown if no lower case alphabet is found
	 */
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException {
		
		for (int i = 0; i < password.length(); i++) {
			
			if (Character.isLowerCase(password.charAt(i))) {
				
				return true;
			}
			
		}
		
		throw new NoLowerAlphaException();
	}
	
	/**
	 * 
	 * @param password is the password to check
	 * @return digitFound if digit is found, else Exception is thrown
	 * @throws NoDigitException is thrown if no digit is found
	 */
	public static boolean hasDigit(java.lang.String password) throws NoDigitException {
		
		boolean digitFound = true;
		char passwordChar = ' ';
		
		for (int i = 0; i < password.length(); i++) {
			
			passwordChar = password.charAt(i);
			
			if (Character.isDigit(passwordChar)) {
				
				return  digitFound;
			}
		}
	
		throw new NoDigitException();
	}
	
	/**
	 * 
	 * @param password is the password to be checked
	 * @return true if the password contains a special character, else false
	 * @throws NoSpecialCharacterException is thrown if no special character is found
	 */
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException {
		
     	Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		if((matcher.matches())) {
			
			throw new NoSpecialCharacterException();
		}
		
		return (!matcher.matches());
	}
	
	/**
	 * 
	 * @param password password is the password to be checked
	 * @return true if password is valid, else false
	 * @throws LengthException is thrown if the password length is not valid
	 * @throws NoUpperAlphaException is thrown if no upper case alphabet is found
	 * @throws NoLowerAlphaException is thrown if no lower case alphabet is found
	 * @throws NoDigitException is thrown if no digit is found
	 * @throws NoSpecialCharacterException is thrown if no special character is found
	 * @throws InvalidSequenceException is thrown if there are more than 2 characters in a sequence
	 */
	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		
        if (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && !NoSameCharInSequence(password)) {
			
			return true;
		}
		
        return false;
	}
	
	/**
	 * 
	 * @param password password is the password to be checked
	 * @return Exception if password is is valid and has between six and nine characters, else false
	 * @throws WeakPasswordException is thrown if the password is weak
	 * @throws LengthException is thrown if the password length is not valid
	 * @throws NoUpperAlphaException is thrown if no upper case alphabet is found
	 * @throws NoLowerAlphaException is thrown if no lower case alphabet is found
	 * @throws NoDigitException is thrown if no digit is found
	 * @throws NoSpecialCharacterException is thrown if no special character is found
	 * @throws InvalidSequenceException is thrown if there are more than 2 characters in a sequence
	 */
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		
		if (isValidPassword(password)) {
			
			if (hasBetweenSixAndNineChars(password)) {
				
				throw new WeakPasswordException();
			}
		}

		return false;
	}
	
	/**
	 * 
	 * @param password is the password to be checked
	 * @return Exception is thrown if there are more than 2 characters in a sequence, else false
	 * @throws InvalidSequenceException is thrown if there are more than 2 characters in a sequence
	 */
	public static boolean NoSameCharInSequence(java.lang.String password) throws InvalidSequenceException {
	
		for (int i = 1; i < password.length() - 1; i++) {
			
			if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i - 1)) {
				
				throw new InvalidSequenceException();
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param passwords is the Array List
	 * @return passwordReturn is the Array List to be returned
	 */
    public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords) {
		
    	java.util.ArrayList<java.lang.String> passwordReturn = new ArrayList<String>();
    	
		for (int i = 0; i < passwords.size(); i++) {
			
			/**
			 * The catch clauses below basically catch the exception.
			 * the passwords.get(i) goes into the text file named passwords.txt and loops through all the passwords in that file.
			 * While looping through all the passwords, it checks if the passwords meet ALL the requirements.
			 * If a password does not meet a specific requirement, it adds it to the Array List named passwordReturn and throws the exception for it.
			 */
			
			try {
				
				isValidPassword(passwords.get(i));
				
			} catch (LengthException LE) {
				
				passwordReturn.add(passwords.get(i) + " " + "The password must be at least 6 characters long");
				
			} catch (NoUpperAlphaException NUAE) {
				
				passwordReturn.add(passwords.get(i) + " " + "The password must contain at least one uppercase alphabetic character");
				
			} catch (NoLowerAlphaException NLAE) {
				
				passwordReturn.add(passwords.get(i) + " " + "The password must contain at least one lowercase alphabetic character");
				
			} catch (NoDigitException NDE) {
				
				passwordReturn.add(passwords.get(i) + " " + "The password must contain at least one digit");
				
			} catch (NoSpecialCharacterException NSCE) {
				
				passwordReturn.add(passwords.get(i) + " " + "The password must contain at least one special character");
				
			} catch (InvalidSequenceException ISE) {
				
				passwordReturn.add(passwords.get(i) + " " + "The password cannot contain more than two of the same letters in a sequence");
				
			} 
			
		}
		
		return passwordReturn;
	}
}