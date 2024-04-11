/**
 * @author Mohammad Danyal
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MorseCodeConverter Class
 */
public class MorseCodeConverter extends java.lang.Object {

	static MorseCodeTree converterTree = new MorseCodeTree();
	
	/**
	 * 
	 * @return a string with all data in the tree in LNR order with an space in between them
	 */
	public static java.lang.String printTree() {
		
		String returnValue = "";
		
		ArrayList<String> printTreeArrayList = new ArrayList<String>();
		
		printTreeArrayList = converterTree.toArrayList();
		
		for (int i = 0; i < printTreeArrayList.size(); i++) {
			
			if (printTreeArrayList.size() - 1 == i) {
				
				returnValue += printTreeArrayList.get(i);
			}
			
			else {
				
				returnValue += printTreeArrayList.get(i) + " ";
			}
		}
		
		return returnValue;
	}
	
	/**
	 * Converts Morse code into English
	 * Each letter is delimited by a space (' ')
	 * Each word is delimited by a  '/'
	 * 
	 * @param code the morse code
	 * @return the English translation
	 */
	public static java.lang.String convertToEnglish(java.lang.String code) {
		
		String returnString = "";
		
		String[] wordArray = code.split("/");
		
		for (int i = 0; i < wordArray.length; i++) {
			
			String[] letterArray = wordArray[i].split(" ");
			
			for (int j = 0; j < letterArray.length; j++) {
				
				returnString += converterTree.fetchNode(converterTree.getRoot(), letterArray[j]);
			}
			
			if ((wordArray.length - 1) != i) {
				
				returnString += " ";
			}
		}
		
		return returnString;
	}
	
	/**
	 * Converts Morse code into English
	 * Each letter is delimited by a space (' ')
	 * Each word is delimited by a  '/'
	 * 
	 * @param codeFile name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException if file is not found
	 */
	public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException {
		
		String codeFromFile = "";
		
		Scanner readFile = new Scanner(codeFile);
		
		if (readFile.hasNext() == false) {
			
			throw new FileNotFoundException();
		}
		
		while (readFile.hasNext()) {
			
			codeFromFile += readFile.nextLine();
		}
		
		String returnString = "";

		String[] wordArray = codeFromFile.split("/");

		for (int i = 0; i < wordArray.length; i++) {

			String[] letterArray = wordArray[i].split(" ");

			for (int j = 0; j < letterArray.length; j++) {

				returnString += converterTree.fetchNode(converterTree.getRoot(), letterArray[j]);
			}
			
			if ((wordArray.length - 1) != i) {

				returnString += " ";
			}
		}
		
		return returnString;
	}

}
