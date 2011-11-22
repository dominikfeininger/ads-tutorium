package gruppe_2_3;

// Gruppe 2/3
import static gdi.MakeItSimple.*;

//TODO: Kommentare!!!

public class ShakerSort {
	public static void main(String[] args) {

		int[] array = { 78, 8, 6, 99, 5, 4, 51, 2, 88 };

		// TODO: Musterlösung
		int[] F = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };

		println();
		println();
		printArray(F);
		print("       Ausgangsfolge");
		int[] sorted = shakerSort(F);
		println();
		println();
		println("Sorted Array:");
		printArray(sorted);

	}

	static int[] shakerSort(int[] unsortedArray) {

		int[] sortedArray = new int[unsortedArray.length];
		int index = 0;
		int reversedIndex = 0;
		int max = sortedArray.length - 1;
		int min = 0;
		boolean swapped = true;
		boolean forwardSwapped = true;

		// Effort variables
		int swappings = 0;
		int cycle = 0;
		int comparisons = 0;

		// copy array to avoid side effects
		while (index < unsortedArray.length) {
			sortedArray[index] = unsortedArray[index];
			index++;
		}
		index = 0;

		while (swapped && min < max) {
			reversedIndex = max;
			index = min;

			if (forwardSwapped && swapped) {

				swapped = false;
				cycle++;
				/*
				 * forward if n > n+1 swap positions
				 */
				while (index < reversedIndex) {
					if (sortedArray[index] > sortedArray[index + 1]) {
						printEffort(sortedArray, index, index + 1, cycle);
						swapIndex(sortedArray, index, index + 1);
						swapped = true;
						swappings++;
					}
					index++;
					comparisons++;
				}
				forwardSwapped = false;
				max--;
			}

			else if (!forwardSwapped && swapped) {

				swapped = false;
				cycle++;
				/*
				 * Backward if n < n-1 swap positions
				 */
				while (reversedIndex > min) {
					if (sortedArray[reversedIndex] < sortedArray[reversedIndex - 1]) {
						printEffort(sortedArray, reversedIndex - 1,
								reversedIndex, cycle);
						swapIndex(sortedArray, reversedIndex - 1, reversedIndex);
						swapped = true;
						swappings++;
					}
					reversedIndex--;
					comparisons++;
				}
				forwardSwapped = true;
				min++;
			}
		}

		// print Effort
		println();
		println("Swaps needed to Sort: " + swappings);
		println("Comparisons needed to Sort: " + comparisons);
		println("Cycles needed to Sort: " + cycle);
		return sortedArray;
	}

	static void printEffort(int[] array, int swapindex, int targetindex,
			int cycle) {
		int index = 0;
		println();

		// print steps, digits to be changed are highlighted
		while (index < array.length) {
			if (index == swapindex) {
				print(" (" + array[index]);
			} else if (index == targetindex) {
				print(" " + array[targetindex] + ")");

			} else {
				print(" " + array[index]);
			}
			index++;
		}

		print("       Durchlauf " + cycle);
	}

	static void printArray(int[] array) {
		int index = 0;
		// print given array
		while (index < array.length) {
			print(" " + array[index]);
			index++;
		}
	}

	static void swapIndex(int[] array, int index1, int index2) {
		int temp = 0;
		temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;

	}

}
