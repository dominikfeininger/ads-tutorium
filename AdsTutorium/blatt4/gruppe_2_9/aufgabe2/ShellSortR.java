package gruppe_2_9.aufgabe2;

import static gdi.MakeItSimple.*;

public class ShellSortR {

	static int compares = 0;
	static int runs = 0;
	static int exchanges = 0;

	public static void main(String[] args) {
		//int[] F = new int[40];
		//int[] F = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//int [] F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//		# Vergleiche: 106  # Vertauschungen: 68	
//		int [] F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//		# Vergleiche: 23  # Vertauschungen: 0		
 // 	int [] F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Vergleiche: 32  # Vertauschungen: 18
//		int [] F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Vergleiche: 34  # Vertauschungen: 21
		int [] F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//		# Vergleiche: 23  # Vertauschungen: 0
		int liste[] = { 7, 4, 3, 3, 1, 8, 11 };
		int i = 0;

		// print array on console
		while (i < liste.length) {
			print(liste[i] + ". ");
			i++;
		}
		println();

		// execution of shellSort function
		shellSort(F);

		println();
		println("runs: " + runs);
		println("compares: " + compares);
		println("exchanges: " + exchanges);

	}

	// insertionSort function with h-parameters
	static void insertionSort(int[] array, int h) {
		
		int i = 0, j = 0, temp = 0;
		
		while (i * h < array.length) {
			j = 0;
			
			// position j & i (* h-distance) comparison
			while (j * h < i * h) {
				compares++;
				
				// Swapping of the two numbers
				if (array[i * h] < array[j * h]) {
					exchanges++;
					temp = array[i * h];
					array[i * h] = array[j * h];
					array[j * h] = temp;
					temp = 0;
				}
				j++;
			}
			i++;
			
			// print every step of the sort
			printRun(array);
			println();

		}
	}

	static void shellSort(int[] array) {
		// initializing h - parameters
		int[] h = { 9, 7, 4, 1 };

		// for every h - parameter execute insertionSort with array and h
		// parameter on i position in array
		for (int i = 0; i < h.length; i++) {

			insertionSort(array, h[i]);
		}

	}

	static void printRun(int[] array) {

		print("F: ");
		// printing every number on array
		for (int j = 0; array.length > j; j++) {
			print(array[j] + " ");
		}
		runs++;

	}

}
