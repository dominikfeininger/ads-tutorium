package gruppe_2_9.aufgabe2;

import static gdi.MakeItSimple.*;

public class ShellSortR {

	static int compares = 0;
	static int runs = 0;
	static int exchanges = 0;

	public static void main(String[] args) {
		int liste[] = { 7, 4, 3, 3, 1, 8, 11 };
		int i = 0;

		// print array on console
		while (i < liste.length) {
			print(liste[i] + ". ");
			i++;
		}
		println();

		// execution of shellSort function
		shellSort(liste);

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
