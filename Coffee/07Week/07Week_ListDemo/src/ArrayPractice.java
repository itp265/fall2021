import java.util.Arrays;

public class ArrayPractice {

	public static int[] pairWiseMin(int[] a, int[] b) {
		int small, big; // 2 variables one for the long length, onw for the short length
		int[] longerArray, shorterArray;
		
		//problem so;ving, have some temp variables to help out.
		if(a.length > b.length) {
			small = b.length;
			shorterArray = b;
			big = a.length;
			longerArray = a;
		}
		else {
			small = a.length;
			shorterArray = a;
			big = b.length;
			longerArray = b;
			
		}
		
		int[] minArray = new int[big];
		// fill first using both arrays, up to the small length
		for(int i = 0; i < small; i++) {
			if(shorterArray[i] < longerArray[i]) { //a[i] < b;[i]
				minArray[i] = shorterArray[i];
			}
			else {
				minArray[i] = longerArray[i];
			}
		}
		// now we have to copy from the longer array
		for (int i =small; i < big; i++) {
			minArray[i] = longerArray[i];
		}
		
		
		return minArray;
	}
	public static void main(String[] args) {
		int[] array1 = {234, 324,43};
		int[] array2 = {55, 66, 77, 22, 33, 44, 4, 4};
		
		System.out.println("Array1: " + Arrays.toString(array1));
		System.out.println("Array2: " + Arrays.toString(array2));
		
		int[] min = pairWiseMin(array1, array2);
		
		System.out.println("MinArray: " + Arrays.toString(min));
	}
	
}
