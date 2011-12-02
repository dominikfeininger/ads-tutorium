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

		int i = 0;
		// create an array and fill with random numbers
		int[] F = new int[10];
		while (i < F.length) {
			F[i++] = (int) (Math.random() * 20);
		}
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
