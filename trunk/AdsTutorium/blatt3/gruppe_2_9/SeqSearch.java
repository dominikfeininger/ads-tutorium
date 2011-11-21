package gruppe_2_9;

import static gdi.MakeItSimple.*;

public class SeqSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] row = { 2, 4, 5, 5, 7, 8, 9, 11 };
		int key;
		int lowerLimit = 0;
		int upperLimit = row.length - 1;

		// Output
		println("Please type in your key: ");
		key = readInt();
		println("Exercise A");
		println("Your searched number is on position: "
				+ linearSearchA(row, key));
		println("-----------------------------------------------------");
		println("Excercise B");
		println("Your searched number is on position: "
				+ linearSearchB(row, key));
		println("-----------------------------------------------------");
		println("Excercise C");
		println("Recursive search: "
				+ binarySearchRecursive(lowerLimit, upperLimit, key, row));
		println("-----------------------------------------------------");
		println("Excercise D");
		println("Binary search: " + binarySearch(row, key));
	}

	// a)
	static int linearSearchA(int[] row, int key) {
		int i = 0;
		int result = 0;

		// till i(counter) is as high as the length of row
		while (i <= row.length) {

			// if key is equal to the row at i, add the position
			if (key == row[i]) {
				result = i + 1;
				i++;
			} else {
				i++;
			}

			// if no search was successfull return -1
			if (i == row.length && result == 0) {
				return -1;
			}

			// to end the loop
			if (i == row.length) {
				i = row.length + 1;
			}

		}
		return result;

	}

	// b)
	static int linearSearchB(int[] row, int key) {
		int i = 0;
		int result = 0;

		while (i <= row.length) {
			// if it's equal write result and end the loop
			if (key == row[i]) {
				result = i + 1;
				i++;
				i = row.length + 1;
			} else {
				i++;
			}
			if (i == row.length && result == 0) {
				return -1;
			}
		}
		return result;

	}

	// c)
	static int binarySearchRecursive(int lowerLimit, int upperLimit, int key,
			int[] row) {
		// if the lowerLimit is higher then the upperLimit return -1
		if (lowerLimit > upperLimit) {
			return -1;
		}

		int mid = lowerLimit + ((upperLimit - lowerLimit) / 2);

		// if key is higher then the position, count mid up by 1 and restart
		// function
		if (key > row[mid]) {
			return binarySearchRecursive(mid + 1, upperLimit, key, row);
		}

		// if it's lower, count mid down by 1 and restart function
		if (key < row[mid]) {
			return binarySearchRecursive(lowerLimit, mid - 1, key, row);
		}

		return mid + 1;
	}

	// d)
	static int binarySearch(int[] row, int key) {

		int lowerLimit = 0, mid = 0;
		int upperLimit = row.length - 1;

		// till lowerLimit is equal upperLimit
		while (lowerLimit <= upperLimit) {

			mid = ((lowerLimit + upperLimit) / 2);

			// if the mid of row is equal to key return the position
			if (row[mid] == key) {
				return mid + 1;
			} else
			// if key is lower then the position, reduce upperLimit by 1
			if (key < row[mid]) {
				upperLimit = mid - 1;
			} else {
				// if it's higher increase lowerLimit by 1
				lowerLimit = mid + 1;
			}
		}
		// if nothing found then return -1
		return -1;
	}

}