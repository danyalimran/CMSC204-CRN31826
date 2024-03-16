/*
 * @author Mohammad Danyal
 * This class has a method named sumOfArray to calculate the sum of an array
 */

public class ArraySum {

	public int sumOfArray(Integer[] a, int index) {
		
		int element = 0;
		int sumOfArray = 0;
		
		if (index < 0) { // checks if the index is below 0
			
			return 0;
		}
		
		element = a[index]; 
		sumOfArray = element + sumOfArray(a, index - 1); // calculates the sum of the array using recursion
		
		return sumOfArray;
	}
}