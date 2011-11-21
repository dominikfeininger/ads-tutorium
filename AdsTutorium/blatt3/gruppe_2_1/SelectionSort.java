package gruppe_2_1;

import static gdi.MakeItSimple.*;

public class SelectionSort {

	public static void main(String[] args) {

		// int[] array = {4, -563, 342, 22, 545, -22, 0, 222, -35, 22, 66, -235,
		// 64433, 3};
		int[] array = { 10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32,
				23, 19, 7, 6, 14, 29 };
		
		printArray(array);

		selectionSort(array);

	}
	
	//TODO: Anzahl Vertauschungen richtig!! Vergleiche falsch
	static public void selectionSort(int[] array) {
		//TODO: angepasster SelectionSort vertauscht in jedem Durchlauf größte UND kleinste Zahl!!!
		int numberOfPermutations = 0;
		int numberOfComparisons = 0;

		// number of elements, which are in the right order
		int sortedElements = 0;

		for (int index = 0; index < array.length - index; index++) {

			// sorted elements increase with each iteration
			//TODO: was macht diese Variable???
			sortedElements = index;

			// TODO: Variablen declaration in Schleife!!!
			int smallest = index;
			int largest = 0;

			// variable to check if a new largest element was found
			boolean swappedLargest = false;
			// variable to check if a new smallest element was found
			boolean swappedSmallest = false;

			// iteration border decreases with each revision of the outer loop
			while (sortedElements < array.length - index) {

				// if a new largest element was found
				if (array[sortedElements] > array[largest]) {
					numberOfComparisons++;
					largest = sortedElements;
					//TODO: warum ausgelagert???
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
				swap(array, largest, array.length - 1 - index);
				numberOfPermutations++;
			}
		}
		//TODO: swap aufruf zum schluss 3 mal zu oft!!!

		println("Number of comparisons: " + numberOfComparisons);
		println("Number of permutations: " + numberOfPermutations);
	}

	/**
	 * This method transposes the values in index1 and index2 of the array
	 * 'array'
	 */
	static void swap(int[] array, int index1, int index2) {

		// variable to store the value of index1
		int help = array[index1];

		array[index1] = array[index2];
		array[index2] = help;
		printArray(array);
	}

	/**
	 * The function of this method is to print all the values in 'array' onto
	 * the console
	 */
	static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {

			print(array[i] + "  ");
		}
		println();
		println();
	}

}
