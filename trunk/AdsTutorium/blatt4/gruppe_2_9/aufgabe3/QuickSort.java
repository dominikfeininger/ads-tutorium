package gruppe_2_9.aufgabe3;

import static gdi.MakeItSimple.*;

public class QuickSort {

	static int compares = 0;
	static int runs = 0;
	
	public static void main(String[] args) {

		int[] row = { 3, 1, 7, 5, 6, 3, 2, 7, 77 };
		
		// execution of function printRun
		printRun(row);
		println();
		// execution of function quickSort
		quickSort(row, 0, row.length - 1);
		printRun(row);
		println();
		println();
		println("compares: " + compares);
		println("runs: " + runs);
		

	}

	static void quickSort(int[] row, int lowerLimit, int upperLimit) {

		int i = 0;
		
		// When upperLimit bigger lowerLimit
		if (upperLimit > lowerLimit) {
			i = split(row, lowerLimit, upperLimit);
			quickSort(row, lowerLimit, i - 1);
			quickSort(row, i + 1, upperLimit);

		}
	}

	static int split(int[] row, int lowerLimit, int upperLimit) {

		
		int index = lowerLimit;
		int arrow = 0;
		// loop for splitting row in parts
		for (arrow = lowerLimit; arrow <= upperLimit - 1; arrow++) {
			
			// if row[arrow] smaller row[upperLimit]
			compares++;
			if (row[arrow] <= row[upperLimit]) {
				// swap f, index and arrow
				runs++;
				swap(row, index, arrow);
				// raise index 
				index++;
				
			}
			// execution of printRun to show every step on console
			printRun(row);
			println();
		}
		// swap function with row, index and arrow
		swap(row, index, arrow);
		
		// return index of function split
		return index;
	}

	static void printRun(int[] array) {

		print("F: ");
		// printing every number in array
		for (int j = 0; array.length > j; j++) {
			print(array[j] + " ");
		}
	}

	// swapping 2 compared numbers of array
	static void swap(int[] row, int idx1, int idx2) {
		int tmp = row[idx1];
		row[idx1] = row[idx2];
		row[idx2] = tmp;
		
	}
}
