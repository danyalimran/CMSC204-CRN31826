import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Mohammad Danyal
 * 
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwordArray;
	String password1, password2;
	
	/**
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		passwordArray = new ArrayList<String>();
		
		passwordArray.add("Cs@4");
		passwordArray.add("cmsc@204");
		passwordArray.add("CMSC@204");
		passwordArray.add("Cmsc@!");
		passwordArray.add("Cmsc204");
		passwordArray.add("Cmsccc@204");
	}
	
/**
 * 
 * @throws Exception
 */
	@After
	public void tearDown() throws Exception {
	
		passwordArray = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Cs@4"));
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("cmsc@204"));
			 
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("CMSC@204"));
 
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("Cmsc@4");
			
			
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a WeakPasswordExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Cmsccc@204"));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Cmsc@!"));
 
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Cmsc@204"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception",false);
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		 
		ArrayList<String> resultArray;
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwordArray);
		
		Scanner scan;
		
		scan = new Scanner(results.get(0));  
		assertEquals(scan.next(), "Cs@4");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
		scan = new Scanner(results.get(1));  
		assertEquals(scan.next(), "cmsc@204");
		nextResults = scan.nextLine().toLowerCase();
	    assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(2)); 
		assertEquals(scan.next(), "CMSC@204");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(3));  
		assertEquals(scan.next(), "Cmsc@!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit") );
		
		scan = new Scanner(results.get(4));  
		assertEquals(scan.next(), "Cmsc204");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special") );
		
		scan = new Scanner(results.get(5));  
		assertEquals(scan.next(), "Cmsccc@204");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("sequence"));
	}
}
