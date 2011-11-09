package blatt3uebung01;

import java.util.Random;

import blatt3uebung04.BinarySort;

public class MainSortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// array lenght
		int length = 100;

		// number to search
		int toSarch = 6;

		// create array
		int[] array = new int[length];
		int[] binaryarray = new int[length];

		// create Random Generator
		Random random = new Random();

		// fill array with random int values
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(array.length);
		}

		// run search linear Search
		// if (-1 != (LinearSearch.linaearSearch(array, toSarch))) {
		// System.out.println(LinearSearch.linaearSearch(array, toSarch));
		// } else {
		// System.out.println("false");
		// }

		// fill array with random numbers sorted
		for (int i = binaryarray.length-1; i >= 0; i--) {
			binaryarray[i] = i*2;
		}

		// run binary search iterativ
		if (-1 != (BinarySort.binarySortIterativ(toSarch, binaryarray))) {
			System.out.println(BinarySort.binarySortIterativ(toSarch,
					binaryarray));
		} else {
			System.out.println("false");
		}

		// run binary search rekursiv
		// if (-1 != (BinarySort.binarySortRekursic(0, binaryarray.length,
		// toSarch, binaryarray))) {
		// System.out.println(BinarySort.binarySortRekursic(0,
		// binaryarray.length, toSarch, binaryarray));
		// } else {
		// System.out.println("false");
		// }
	}

	// print array
	public static void printArray(int[] toprint) {
		for (int i = 0; i < toprint.length; i++) {
			System.out.println(toprint[i]);
		}
	}
}
