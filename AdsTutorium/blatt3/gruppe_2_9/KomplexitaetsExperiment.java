package gruppe_2_9;

import static gdi.MakeItSimple.*;

public class KomplexitaetsExperiment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] row;
		int j = 0, counter = 0, lowerLimit = 0, key;
		int averageLinearA = 0, averageLinearB = 0, averageBinaryC = 0, averageBinaryD = 0;

		// input
		println("Please type in the length of your row: ");
		int n = readInt();
		readLine();
		row = new int[n];
		int upperLimit = row.length - 1;

		// generates a random array length
		for (int i = 0; i < row.length; i++) {
			row[i] = (int) Math.floor(Math.random() * n);
		}

		println("Please type in the length of your key: ");

		// to test it 100 times to get an average
		while (counter != 100) {

			// generates a random key
			key = (int) Math.floor(Math.random() * n);

			// output
			println("Excercise A");
			println("Linaer search - number of comparisons: "
					+ linearSearchA(row, key));
			averageLinearA += linearSearchA(row, key);
			println("-----------------------------------------------------");
			println("Excercise B");
			println("Linear Search - number of comparisons: "
					+ linearSearchB(row, key));
			averageLinearB += linearSearchB(row, key);
			println("-----------------------------------------------------");
			println("Excercise C");
			println("Recursive Search - number of comparisons: "
					+ binarySearchRecursive(lowerLimit, upperLimit, key, row, j));
			averageBinaryC += binarySearchRecursive(lowerLimit, upperLimit,
					key, row, j);
			println("-----------------------------------------------------");
			println("Excercise D");
			println("Binary Search - number of comparisons: "
					+ binarySearch(row, key));
			averageBinaryD += binarySearch(row, key);
			counter++;
			println(averageLinearB);
		}

		// calculate the average of each search
		averageLinearA = averageLinearA / 100;
		println("Mittelwert der Aufgabe A: " + averageLinearA);
		averageLinearB = averageLinearB / 100;
		println("Mittelwert der Aufgabe B: " + averageLinearB);
		averageBinaryC = averageBinaryC / 100;
		println("Mittelwert der Aufgabe C: " + averageBinaryC);
		averageBinaryD = averageBinaryD / 100;
		println("Mittelwert der Aufgabe D: " + averageBinaryD);

	}

	// a)
	static int linearSearchA(int[] row, int key) {
		int i = 0;
		int result = 0;
		int j = 0;

		// till i(counter) is as high as the length of row
		while (i <= row.length) {

			// if key is equal to the row at i, add the position
			if (key == row[i]) {
				result = i + 1;
				i++;
				j++;
			} else {
				i++;
				j++;
			}
			// to end the loop
			if (i == row.length) {
				i = row.length + 1;
			}
			// if no search was successful return 0
			if (i == row.length && result == 0) {
				return 0;
			}
		}
		return j;

	}

	// b)
	static int linearSearchB(int[] row, int key) {
		int i = 0;
		int result = 0;
		int j = 0;

		while (i <= row.length) {

			// if it's equal write result and end the loop
			if (key == row[i]) {
				result = i + 1;
				i++;
				j++;
				i = row.length + 1;
			} else {
				i++;
				j++;
			}
			if (i == row.length && result == 0) {
				return j;
			}
		}
		return j;

	}

	// c)
	static int binarySearchRecursive(int lowerLimit, int upperLimit, int key,
			int[] row, int j) {

		int mid;

		// if the lowerLimit is higher then the upperLimit return counter
		if (lowerLimit > upperLimit) {
			j++;
			return j;
		}

		mid = lowerLimit + ((upperLimit - lowerLimit) / 2);

		// if key is higher then the position, count mid up by 1 and restart
		// function
		if (key > row[mid]) {
			j++;
			return binarySearchRecursive(mid + 1, upperLimit, key, row, j);
		}

		// if it's lower, count mid down by 1 and restart function
		if (key < row[mid]) {
			j++;
			return binarySearchRecursive(lowerLimit, mid - 1, key, row, j);
		}

		return j;
	}

	// d)
	static int binarySearch(int[] row, int key) {

		int lowerLimit = 0, mid = 0;
		int upperLimit = row.length - 1;
		int j = 0;

		// till lowerLimit is equal upperLimit
		while (lowerLimit <= upperLimit) {

			mid = ((lowerLimit + upperLimit) / 2);

			// if the mid of row is equal to key return the counter
			if (row[mid] == key) {
				j++;
				return j;
			} else
			// if key is lower then the position, reduce upperLimit by 1
			if (key < row[mid]) {
				upperLimit = mid - 1;
				j++;
			} else {
				// if it's higher increase lowerLimit by 1
				lowerLimit = mid + 1;
				j++;
			}
		}
		// if nothing found then return the counter + 1
		return j + 1;
	}

}