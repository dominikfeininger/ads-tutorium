package gruppe_2_2.aufgabe3;

import static gdi.MakeItSimple.*;

public class Quicksort {

	/**
	 * @param args
	 */
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
		
		//int[] F = new int[20];
//		for (int i = 0; i < F.length; i++) { // Fill array with random numbers
//												// between 0 and 100
//			int x = (int) Math.floor(Math.random() * 100);
//			F[i] = x;
//		}
		printArray(F);
		QuickSort(F, 0, F.length - 1); 		// start Quicksort with first and last element as bounds
		printArray(F);
	}
	/**
	 * function splits up an unsorted array by the pivo element ( in our case this element is the same
	 * as upper bound ). 
	 * @return index -> expected number between value of lower and value of upper.
	 * 					{index is element of N} 
	 */
	static int split(int[] F, int lower, int upper) {
		int p = upper; // set pv to upper border element
		int index = lower; // set index to lower border element
		for (int pointer = lower; pointer <= upper - 1; pointer++) { 
			// as long as pointer reached upper	bound-1
			if (F[pointer] <= F[p]) { 
				// if element at pos pointer <= element at upper border -> change
				change(F, index, pointer);
				printArray(F);
				index++;
			}
		}
		change(F, index, upper); // put p at right position
		printArray(F);
		return index;
	}
	/**
	 * procedure swaps the elements with the index1 and index2.
	 */
	static void change(int[] F, int index1, int index2) {
		int tmp = F[index1];
		F[index1] = F[index2];
		F[index2] = tmp;
	}
	/**
	 * procedure calls it self the recursive way and splits up F by calling the function split
	 */
	static void QuickSort(int[] F, int lower, int upper) {
		if (upper > lower) {						// if lower and upper index are equal -> no call 
			int i = split(F, lower, upper);
			QuickSort(F, lower, i - 1);				// do without pivo element
			QuickSort(F, i + 1, upper);
		}
	}
	/**
	 * procedure prints out the array at console
	 * @param F
	 */
	static void printArray(int[] F) {
		String out = "  ";
		for (int i = 0; i < F.length; i++) {
			out += " " + F[i];
		}
		println(out);
	}
}
