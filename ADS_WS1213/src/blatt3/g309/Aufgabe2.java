package blatt3.g309;

import static gdi.MakeItSimple.*;

public class Aufgabe2 {

	public static void main(String[] args) {
		long A = 0;
		long B = 0;
		long C = 0;
		long D = 0;
		char successOption = ' ';
		int key = 0;

		// successful tests?
		print("Should the tests be successful? Enter y or n: ");
		successOption = readChar();
		readLine();

		// choosing array length
		print("Please choose your array length: ");
		int arrayLength = readInt();
		readLine();
		int[] array = new int[arrayLength];

		// number of tests
		print("Please choose number of tests: ");
		int numberTests = readInt();
		readLine();

		// filling the array
		int index = 0;
		while (index < array.length) {
			array[index] = index;
			index++;
		}

		// executing the tests
		int indexTests = 0;
		while (indexTests < numberTests) {
			if (successOption == 'y' || successOption == 'Y')
				// search for random keys
				key = (int) Math.floor(Math.random() * arrayLength);
			else
				// unsuccessful tests
				key = arrayLength;

			A = A + aufgabeA(array, key);
			B = B + aufgabeB(array, key);
			C = C + aufgabeC(array, key, 0, array.length - 1);
			D = D + aufgabeD(array, key);
			indexTests++;
		}

		// printing results
		println("a) Average number of comparisons : " + A / numberTests);
		println("b) Average number of comparisons : " + B / numberTests);
		println("c) Average number of comparisons : " + C / numberTests);
		println("d) Average number of comparisons : " + D / numberTests);
		println("Based on " + numberTests + " tests with " + arrayLength
				+ " numbers each.");

	}

	// sequential search last key
	public static int aufgabeA(int[] array, int key) {
		int index = 0;
		int keyPos = -1;
		int numberComparisons = 0;
		// test every array slot
		while (index < array.length) {
			if (array[index] == key)
				keyPos = index;
			// count comparisons
			numberComparisons++;
			index++;
		}

		return numberComparisons;
	}

	// sequential search first key
	public static int aufgabeB(int[] array, int key) {
		int index = 0;
		int keyPos = -1;
		int numberComparisons = 0;
		// stop when first key found
		while (index < array.length && keyPos == -1) {
			if (array[index] == key)
				keyPos = index;
			// count comparisons
			numberComparisons++;
			index++;
		}

		return numberComparisons;
	}

	// recursive binary search
	public static int aufgabeC(int[] array, int key, int low, int high) {
		int mid = (low + high) / 2;
		if (low <= high) {
			if (array[mid] == key)
				return 1; // key found
			else if (array[mid] < key)
				// continue search in upper half
				return 1 + aufgabeC(array, key, mid + 1, high);
			else
				// continue search in lower half
				return 1 + aufgabeC(array, key, low, mid - 1);
		}
		return 0;
	}

	// binary search
	public static int aufgabeD(int[] array, int key) {
		int numberComparisons = 0;
		int low = 0, high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == key)
				return numberComparisons + 1; // key found
			else if (key < array[mid]) {
				high = mid - 1; // continue search in lower half
				// count comparisons
				numberComparisons++;
			} else {
				low = mid + 1; // continue search in upper half
				// count comparisons
				numberComparisons++;
			}
		}
		return numberComparisons;
	}
}
