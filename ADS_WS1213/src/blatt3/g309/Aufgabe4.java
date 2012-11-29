package blatt3.g309;

import static gdi.MakeItSimple.*;

public class Aufgabe4 {

	public static void main(String[] args) {
		// Array length
		print("Please enter the amount of numbers to sort: ");
		int arrayLength = readInt();
		readLine();
		int[] array = new int[arrayLength];

		// fill the array
		int index = 0;
		while (index < array.length) {
			print("Please enter a number for the " + (index + 1)
					+ ". position: ");
			array[index] = readInt();
			readLine();
			index++;
		}
		// array before changes
		println("Array before any changes:");
		for (index = 0; index < array.length; index++) {
			print(" " + array[index]);
		}
		// execute shakersort
		shakerSort(array);
	}

	public static void shakerSort(int[] array) {
		int index = 0;
		int backIndex = 0;
		boolean swapped = false;
		int comparisons = 0;
		int changes = 0;
		int helpSwap = 0;
		int swap1 = 0;
		int swap2 = 0;
		int help1 = 0;
		int help2 = 0;

		// (bubblesort) from left to right
		do {
			swapped = false;
			for (index = 0; index < array.length - 1; index++) {
				comparisons++;
				if (array[index] > array[index + 1]) {
					// swap numbers
					helpSwap = array[index + 1];
					array[index + 1] = array[index];
					array[index] = helpSwap;
					changes++;
					swapped = true;
					swap1 = index;
					swap2 = index + 1;
					println();
					println("Changes:");
					for (help1 = 0; help1 < array.length; help1++) {
						if (help1 == swap1 || help1 == swap2)
							print("|" + array[help1] + "| ");
						else
							print(array[help1] + " ");
					}
					println();
				}

			}

			// (bubblesort) from right to left
			if (swapped) {
				swapped = false;
				for (backIndex = array.length - 1; backIndex > 0; backIndex--) {
					comparisons++;
					if (array[backIndex] < array[backIndex - 1]) {
						// swap numbers
						helpSwap = array[backIndex - 1];
						array[backIndex - 1] = array[backIndex];
						array[backIndex] = helpSwap;
						changes++;
						swapped = true;
						swap1 = backIndex - 1;
						swap2 = backIndex;
						println();
						println("Changes:");
						for (help2 = 0; help2 < array.length; help2++) {
							if (help2 == swap1 || help2 == swap2)
								print("|" + array[help2] + "| ");
							else
								print(array[help2] + " ");
						}
						println();
					}

				}

			}

		} while (swapped);
		// print results
		println();
		println("Number of comparisons: " + comparisons);
		println("Number of changes: " + changes);
		println("Sorted array:");
		for (index = 0; index < array.length; index++) {
			print(" " + array[index]);
		}
	}

}
