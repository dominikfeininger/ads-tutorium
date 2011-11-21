package gruppe_2_1;

import static gdi.MakeItSimple.*;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] array = {4, -563, 342, 22, 545, -22, 0, 222, -35, 22, 66, -235, 64433, 3};

		printArray(array);
		
		selectionSort(array);
		
	}
	
	static public void selectionSort(int[] array) {
		
		int numberOfPermutations = 0;
		int numberOfComparisons = 0;
		
		// number of elements, which are in the right order
		int sortedElements = 0;
		
		for (int index=0; index < array.length-index; index++) {
			
			// sorted elements increase with each iteration
			sortedElements = index;
			
			int smallest = index;
			int largest = 0;
			
			// variable to check if a new largest element was found
			boolean swappedLargest = false;
			// variable to check if a new smallest element was found
			boolean swappedSmallest = false; 
			
			// iteration border decreases with each revision of the outer loop
			while (sortedElements<array.length-index) {
				
				// if a new largest element was found
				if (array[sortedElements] > array[largest]) {
					numberOfComparisons++;
					largest = sortedElements;
					swappedLargest = true;
				}
				
				// if a new smallest element was found
				if (array[sortedElements] < array[smallest]) {
					numberOfComparisons++;
					smallest = sortedElements;
					swappedSmallest = true;
				}
				sortedElements++;
			}	
			
			if (swappedLargest) {
				swap(array, smallest, index);
				numberOfPermutations++;
			}

			if (index == largest)
				largest = smallest;
			
			if (swappedSmallest) {
				swap(array, largest, array.length-1-index);
				numberOfPermutations++;
			}	
		}
		
		println("Number of comparisons: " + numberOfComparisons);
		println("Number of permutations: "+ numberOfPermutations);
	}
	
	/**
	 * This method transposes the values in index1 and index2 of the array 'array'
	 */
	static void swap (int[] array, int index1, int index2) {
		
		// variable to store the value of index1
		int help = array[index1];
		
		array[index1] = array[index2];
		array[index2] = help;
		printArray(array);
	}
	
	/**
	 * The function of this method is to print all the values in 'array' onto the console
	 */
	static void printArray(int[] array) {
		
		for (int i=0; i<array.length; i++) {
			
			print(array[i]+ "  ");
		}
		println();
		println();
	}

}
