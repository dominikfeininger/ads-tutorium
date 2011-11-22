package gruppe_2_1;

import static gdi.MakeItSimple.*;

public class ShakerSort {

	public static void main(String[] args) {

		int[] array = new int[10];

		// initialising array
		for (int i = 0; i < array.length; i++)
			array[i] = (int) Math.floor(Math.random() * 40);

		int[] F = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
		shakerSort(F);
	}

	static void shakerSort(int[] array) {

		boolean swapped = true; // variable to check if two elements were
								// swapped

		boolean fromTheFront = true; // variable to determine the direction of
										// sorting

		int numberOfPermutations = 0;
		int numberOfComparisons = 0;

		// as long as two elements were swapped, you have to check the order
		// once again
		while (swapped) {

			swapped = false; // you presume that no element will be swapped

			if (fromTheFront) {

				for (int i = 0; i < array.length - 1; i++) {

					numberOfComparisons++;

					// if the two elements aren't in the right order
					if (array[i + 1] < array[i]) {
						printArray(array);
						swap(array, i, i + 1);
						swapped = true;
						numberOfPermutations++;
					}
				}
				fromTheFront = false; // change direction in the next iteration
			}

			else {

				for (int i = array.length - 1; i > 0; i--) {

					numberOfComparisons++;

					// if the two elements aren't in the right order
					if (array[i - 1] > array[i]) {
						printArray(array);
						swap(array, i, i - 1);
						swapped = true;
						numberOfPermutations++;
					}
				}
				fromTheFront = true; // change direction in the next iteration
			}

			printArray(array);

			println();
		}

		println();

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
	}

}
