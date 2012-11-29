package blatt3.g309;

import static gdi.MakeItSimple.*;

public class Aufgabe1 {

	public static void main(String[] args) {
		int index = 0;

		// choosing array length
		print("Please enter wanted array length: ");
		int arrayLength = readInt();
		readLine();
		int[] array = new int[arrayLength];

		// filling the array
		while (index < array.length) {
			print((index + 1) + ". number: ");
			array[index] = readInt();
			readLine();
			index++;
		}

		// wanted key
		print("Please enter wanted key: ");
		int key = readInt();

		// printing results
		println("a) Number at position: " + aufgabeA(array, key));
		println("b) Number at position: " + aufgabeB(array, key));
		println("c) Number at position: "
				+ aufgabeC(array, key, 0, array.length - 1));
		println("d) Number at position: " + aufgabeD(array, key));

	}

	// sequential search last key
	public static int aufgabeA(int[] array, int key) {
		int index = 0;
		int keyPos = -1; // in case key not found
		// test every array slot
		while (index < array.length) {
			if (array[index] == key)
				keyPos = index;
			index++;
		}

		return keyPos;
	}

	// sequential search first key
	public static int aufgabeB(int[] array, int key) {
		int index = 0;
		int keyPos = -1; // in case key not found
		// stop when first key found
		while (index < array.length && keyPos == -1) {
			if (array[index] == key)
				keyPos = index;
			index++;
		}

		return keyPos;
	}

	// recursive binary search
	public static int aufgabeC(int[] array, int key, int low, int high) {
		int mid = (low + high) / 2;
		if (low <= high) {
			if (array[mid] == key)
				return mid; // key found
			else if (array[mid] < key)
				// continue search in upper half
				return aufgabeC(array, key, mid + 1, high);

			else
				// continue search in lower half
				return aufgabeC(array, key, low, mid - 1);
		}
		return -1;// key not found
	}

	// binary search
	public static int aufgabeD(int[] array, int key) {
		int low = 0, high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == key)
				return mid; // key found
			else if (key < array[mid])
				high = mid - 1; // continue search in lower half
			else
				low = mid + 1; // continue search in upper half
		}
		return -1;// key not found
	}

}
