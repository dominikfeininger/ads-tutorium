package gruppe_2_6;

import static gdi.MakeItSimple.*;

public class Quicksort {

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
	 * changes two elements of an array
	 * 
	 * @param F
	 * @param idx1
	 * @param idx2
	 */
	static void swap(int[] F, int idx1, int idx2) {
		int tmp = F[idx1];
		F[idx1] = F[idx2];
		F[idx2] = tmp;
	}

	/**
	 * divides the array in 2 parts, all elements smaller than pivot are
	 * assorted to the left, then the pivot element is assorted to the right
	 * side of the smaller part
	 * 
	 * @param F
	 * @param lowerLimit
	 * @param upperLimit
	 * @param counter
	 * @return
	 */
	static int divide(int[] F, int lowerLimit, int upperLimit, int[] counter) {
		int index, marker;
		index = lowerLimit;
		for (marker = lowerLimit; marker <= upperLimit - 1; marker++) {
			if (F[marker] <= F[upperLimit]) {
				swap(F, index, marker);
				counter[0] += 1;
				index++;
			}
			counter[1] += 1;
		}
		printRun(F);
		swap(F, index, upperLimit);
		counter[0] += 1;
		return index;
	}

	/**
	 * assorts an array by dividing it in 2 parts, all elements of the first
	 * part are smaller than the pivot element and all elements of the other
	 * part are bigger. The pivot element is the last element of the array.
	 * 
	 * @param F
	 * @param lowerLimit
	 * @param upperLimit
	 * @param counter
	 */
	static void quickSort(int[] F, int lowerLimit, int upperLimit, int[] counter) {
		int i = 0;
		if (upperLimit > lowerLimit) {
			i = divide(F, lowerLimit, upperLimit, counter);
			quickSort(F, lowerLimit, i - 1, counter);
			quickSort(F, i + 1, upperLimit, counter);
		}
	}

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

		int i = 0;
		// create an array and fill with random numbers
//		//int[] F = new int[10];
//		while (i < F.length) {
//			F[i++] = (int) (Math.random() * 20);
//		}
		int[] counter = new int[2];

		printRun(F);
		println();

		quickSort(F, 0, F.length - 1, counter);
		println();

		printRun(F);
		println();

		println("anzahl der Vertauschungen: " + counter[0]);
		println("anzahl der Vergleiche: " + counter[1]);

	}

}
