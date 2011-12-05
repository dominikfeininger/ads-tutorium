package gruppe_2_6;


import static gdi.MakeItSimple.*;

public class Shellsort {

	/**
	 * prints an array on the console
	 * 
	 * @param array
	 */
	static void printRun(int[] array) {
		int i = 0;
		while (i < array.length)
			print(array[i++] + " ");
		println();
	}

	/**
	 * normal insertion Sort but with every h. element
	 * @param array
	 * @param h ("jump-length")
	 * @param counter
	 */
	static void insertionSort(int[] array, int h, int[] counter) {
		int i = 0, j, t;
		while (i < array.length) {
			j = i;
			t = array[j];
			while (j > 0 && array[j - h] > t) {
				array[j] = array[j - h];
				j -= h;
				counter[0] += 1;
			}
			counter[1] += 1;
			array[j] = t;
			i += h;
		}
	}

	/**
	 * assorts an array like insertion sort but more efficient as it "jumps"
	 * over some elements and assorts it in a few runs with different length of
	 * the jumps
	 * 
	 * @param array
	 */
	static void shellSort(int[] array) {
		
		// defines the "jumps"
		int[] h = { 9, 7, 4, 1 };
		int[] counter = new int[2];
		counter[0] += 0; // changes
		counter[1] += 0; // compares

		// do insertion sort with every h. element
		for (int i = 0; i < h.length; i++) {
			insertionSort(array, h[i], counter);
			printRun(array);
		}
		println();
		println("anzahl der Vertauschungen: " + counter[0]);
		println("anzahl der Vergleiche: " + counter[1]);
	}

	public static void main(String[] args) {
		
		//int[] F = new int[40];
		//int[] F = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//int [] F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//		# Vergleiche: 106  # Vertauschungen: 68	
//		int [] F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//		# Vergleiche: 23  # Vertauschungen: 0		
  	int [] F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Vergleiche: 32  # Vertauschungen: 18
//		int [] F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Vergleiche: 34  # Vertauschungen: 21
//		int [] F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//		# Vergleiche: 23  # Vertauschungen: 0

		int i = 0;
		// create an array and fill with random numbers
//		int[] array = new int[14];
//		while (i < array.length) {
//			array[i++] = (int) (Math.random() * 50);
//		}

		println("startarray");
		printRun(F);
		println();

		shellSort(F);
	}

}