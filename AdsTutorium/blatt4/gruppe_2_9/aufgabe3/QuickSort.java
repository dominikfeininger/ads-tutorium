package gruppe_2_9.aufgabe3;

import static gdi.MakeItSimple.*;

public class QuickSort {

	static int compares = 0;
	static int runs = 0;
	
	public static void main(String[] args) {
		
		//int [] F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//		# Rekusionen: 30 # Vergleiche: 119  # Vertauschungen: 31
		
		int [] F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//		# Rekusionen: 8 # Vergleiche: 99  # Vertauschungen: 0	
		
//  	F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Rekusionen: 8 # Vergleiche: 74  # Vertauschungen: 5


//		F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Rekusionen: 6 # Vergleiche: 41  # Vertauschungen: 9

//		F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
//		# Rekusionen: 8 # Vergleiche: 54  # Vertauschungen: 9

//		F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen
//		# Rekusionen: 7 # Vergleiche: 53  # Vertauschungen: 5


//		F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
//		# Rekusionen: 8 # Vergleiche: 90  # Vertauschungen: 1
		
//		F = new int[] {1};
//		# Rekusionen: 0 # Vergleiche: 0  # Vertauschungen: 0		

//		F = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das größte Element steht ganz links
//		# Rekusionen: 7 # Vergleiche: 81  # Vertauschungen: 9	

//		F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//		# Rekusionen: 8 # Vergleiche: 99  # Vertauschungen: 0	

		int[] row = { 3, 1, 7, 5, 6, 3, 2, 7, 77 };
		
		// execution of function printRun
		printRun(F);
		println();
		// execution of function quickSort
		quickSort(F, 0, F.length - 1);
		printRun(F);
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
