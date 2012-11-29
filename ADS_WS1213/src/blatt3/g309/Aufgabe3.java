package blatt3.g309;

import static gdi.MakeItSimple.*;

public class Aufgabe3 {

	public static int[] fillArray(int[] array, int arrayLength) {
		for (int index = 0; index < array.length; index++) {
			array[index] = (int) Math.floor(Math.random() * arrayLength);
		}
		return array;
	}

	public static void main(String[] args) {

		// Array length
		print("Please choose your array length: ");
		int arrayLength = readInt();
		readLine();
		int[] array = new int[arrayLength];

		// fill the array
		fillArray(array, arrayLength);

		println("Array before insertion sort:");
		for (int test = 0; test < array.length; test++) {
			print(array[test] + " ");
		}

		// execute insertion sort
		insertionSort(array);

		// array for binary insertion sort
		println();
		int[] array2 = new int[arrayLength];

		// fill the array
		fillArray(array2, arrayLength);

		println("+++++++++++++++++++++++++++++++++++");
		println("+++++++++++++++++++++++++++++++++++");
		println("Array before binary insertion sort:");
		for (int test = 0; test < array2.length; test++) {
			print(array2[test] + " ");
		}

		sort(array2);

	}

	public static void insertionSort(int[] array) {
		int comparisons = 0;
		int changes = 0;
		for (int index = 1; index < array.length; index++) {
			int index2 = index;
			int marker = array[index]; // marker field
			// if the number in the previous index2 slot is bigger than the
			// marker, insert the number at the index2 slot
			while (index2 > 0 && array[index2 - 1] > marker) {
				comparisons++;
				changes++;
				array[index2] = array[index2 - 1];
				index2--;
			}
			comparisons++;

			// insert the marker field at the new (free) index2 slot
			array[index2] = marker;

		}
		// print results
		println();
		println("Number of comparisons: " + comparisons);
		println("Number of changes: " + changes);
		println("Array after insertion sort:");
		for (int test = 0; test < array.length; test++) {
			print(array[test] + " ");
		}
	}

	public static int binaryComparisons = 0;

	public static int binarySearch(int array[], int key, int low, int high) {
		if (low == high) {
			binaryComparisons++;
			return low;
		}
		int mid = low + ((high - low) / 2);
		if (key > array[mid]) {
			binaryComparisons++;
			return binarySearch(array, key, mid + 1, high);
		} else if (key < array[mid]) {
			binaryComparisons++;
			return binarySearch(array, key, low, mid);
		}
		return mid;
	}

	public static void sort(int[] array) {
		int binaryIndex, index, index2;
		int marker;
		int changes = 0;
		for (index = 1; index < array.length; index++) {
			binaryIndex = binarySearch(array, array[index], 0, index);
			marker = array[index];
			for (index2 = index - 1; index2 >= binaryIndex; index2--) {
				binaryComparisons += 2;
				if ((array[index2 + 1] != array[index2])
						&& array[index2 + 1] < array[index2]) {
					changes++;

					array[index2 + 1] = array[index2];

				}
			}
			array[binaryIndex] = marker;
			binaryComparisons++;
		}
		println();
		println("Comparisons: " + binaryComparisons);
		println("Changes: " + changes);
		println("Array after binary insertion sort:");
		for (int test = 0; test < array.length; test++) {
			print(array[test] + " ");
		}

	}

}
