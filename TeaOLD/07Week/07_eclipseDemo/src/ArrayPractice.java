import java.util.Arrays;

/**
 * Write description of class
 *
 * @author Kendra Walther
 * ITP 265, Spring 2021, NightOwl Section
 * email: kwalther@usc.edu
 * Assignment xx
 *
 */
public class ArrayPractice {

	public static int[] pairWiseMinimum(int[] a, int[] b) {
		int longLength;
		int[] smallerArray;
		int[] longerArray; 
		
		
		System.out.println("a len: " + a.length + " and b len: " + b.length);
		int[] minArray;
		
		//make an array that holds the MINIMUM value from each array slot
		// if one array is longer, we just copy over from the end of the longer 
		if(a.length > b.length) {
			longLength = a.length;
			smallerArray = b;
			longerArray = a;
		
		}
		else { 
			longLength = b.length;
			smallerArray = a;
			longerArray = b;
		}
		minArray = new int[longLength]; //length of the longer one
		
		for(int i = 0; i < smallerArray.length; i++) { //loop until we run out of elements
			// in the smaller of the two arrays
			if(smallerArray[i] < longerArray[i]) {
				minArray[i] = smallerArray[i]; // copy from smaller
				
			}
			else {
				minArray[i] = longerArray[i]; // copy from longer
			}
			
		}// end of for loop, reached the end of the SMALLER array
			
		//now fill up the END of the array
		for (int i = smallerArray.length; i < longLength; i++) {
			minArray[i] = longerArray[i];
		}
	
		System.out.println("Smaller Array: " + Arrays.toString(smallerArray));
		System.out.println("Larger Array: " + Arrays.toString(longerArray));
		System.out.println("Min Array: " + Arrays.toString(minArray));
		
		return minArray;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {55, 77, 88, 22, 44, 23, 34, 56, 3453, 34, 44, 44, 44, 44, 44, 44, 44, 44, 44};
		int[] b = {435, 23,2,3,43,5,454,23,1,12, 55, 66, 77};
		
		
		int[] answer = pairWiseMinimum(a, b);
	
	}

}
