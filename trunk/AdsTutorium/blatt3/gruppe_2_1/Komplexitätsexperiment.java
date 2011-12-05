package gruppe_2_1;

import static gdi.MakeItSimple.*;

public class Komplexitätsexperiment {

	public static void main(String[] args) {
		//TODO: Beschriftung console stimmt nicht!!!
		//TODO: Aufrufe fehlen!!!

		succesfulSearch();
		unsuccesfulSearch();
	}


	/**
	 * return number of comparison
	 */
	static int linearSearchLastElement(int array[], int searchKey) {

		int numberOfComparisons = 0;

		int searchIndex = 0;

		while (searchIndex < array.length) {

			numberOfComparisons++;
			if (array[searchIndex] == searchKey) {
				// TODO: in while Schleife neue declaration?? ohne Verwendung
				int indexSearchKey = searchIndex;
			}
			searchIndex++;
		}

		return numberOfComparisons;
	}

	static int linearSearchFirstElement(int array[], int searchKey) {

		int searchIndex = 0;

		boolean keyFound = false; // variable to save the status of the search

		int numberOfComparisons = 0;

		while (searchIndex < array.length && !keyFound) {

			numberOfComparisons++;
			if (array[searchIndex] == searchKey) {
				keyFound = true; // abandon search
			}

			searchIndex++;
		}

		return numberOfComparisons;
	}

	/**
	 * 
	 * @param array
	 * @param searchKey
	 * @return numberOfComparisons
	 */
	static int binarySearchIterative(int array[], int searchKey) {

		int numberOfComparisons = 0;

		int lowerBound = 0;
		int upperBound = array.length;
		int middle = 0;

		boolean searchKeyFound = false;

		// search ends, when the bounds intersect, or when the searchKey was
		// found
		while (lowerBound <= upperBound && !searchKeyFound) {

			// calculating the middle
			middle = (lowerBound + upperBound) / 2;
			//TODO: statt searchKeyFound andere M�glichkeit: else geschachtelt
			numberOfComparisons++;
			if (searchKey == array[middle]) {
				searchKeyFound = true; // abandon search
			}

			// go on in the lower side
			else if (searchKey < array[middle]) {
				upperBound = middle - 1;
			}

			// go on in the upper side
			else {
				lowerBound = middle + 1;
			}
			//TODO: wie in Musterl�sung:
			//numberOfComparisons++;
		}

		return numberOfComparisons;
	}

	static int binarySearchRecursive(int array[], int searchKey,
			int lowerBound, int upperBound) {

		// calculate the middle
		int middle = (lowerBound + upperBound) / 2;

		if (searchKey == array[middle])
			return 1; // searchKey found, number of comparisons is 1

		// go on in the lower side
		else if (searchKey < array[middle] && lowerBound <= upperBound)
			// recusive calling with middle-1 as upperBound and return result +
			// 1
			return binarySearchRecursive(array, searchKey, lowerBound,
					middle - 1) + 1;

		// go on in the upper side
		else if (searchKey > array[middle] && lowerBound <= upperBound)
			// recusive calling with middle+1 as lowerBound and return result +
			// 1
			return binarySearchRecursive(array, searchKey, middle + 1,
					upperBound) + 1;

		else
			return -1; // method doesn't arrive here, but a return is required

	}

	// method for performing and printing the succesfull search
	static void succesfulSearch() {
		
		//TODO: fehlen Aufrufe bei linearSearch

		println("______________________succesfulSearch:_________________________");

		int numberOfElements = 0;
		int[] array1 = new int[1024];
		int[] array2 = new int[2048];
		int[] array3 = new int[4096];

		// Initialising array1
		while (numberOfElements < array1.length) {

			array1[numberOfElements] = numberOfElements;
			numberOfElements++;
		}
		numberOfElements = 0;

		// Initialising array2
		while (numberOfElements < array2.length) {

			array2[numberOfElements] = numberOfElements;
			numberOfElements++;
		}
		numberOfElements = 0;

		// Initialising array3
		while (numberOfElements < array3.length) {

			array3[numberOfElements] = numberOfElements;
			numberOfElements++;
		}

		int average = 0;
		int numberOfCallings = 0;

		// TODO: f�r jeden Vergleich eine neue random Zahl!!!
		// runs with first array
		// /////////////////////////////////
		// initialize keys
		// keep in mind that the range of the keys is 0 .. len1
		/*
		for (int i = 0; i < KEYS_NUM; i++) {
			keys[i] = (int) Math.floor(Math.random() * len1);
		};
		*/
		
		int searchKey1 = (int) Math.floor(Math.random() * array1.length);
		int searchKey2 = (int) Math.floor(Math.random() * array2.length);
		int searchKey3 = (int) Math.floor(Math.random() * array3.length);

		/*
		 * System.out.println(searchKey1); System.out.println(searchKey2);
		 * System.out.println(searchKey3);
		 */

		// linear search (last hit)

		while (numberOfCallings < 100) {

			average += linearSearchLastElement(array1, searchKey1);
			numberOfCallings++;
		}
		println("linear search (last hit) with 1024 elements: " + average
				/ numberOfCallings);
		//TODO: was soll ??? "average += linearSearchLastElement(array1, searchKey1);"
		/*
		System.out.println(linearSearchLastElement(array1, searchKey1));
		System.out.println("Verlgeiche: " + average);
		 */
		average = 0;
		numberOfCallings = 0;

		// linear search (first hit)

		while (numberOfCallings < 100) {

			average += linearSearchFirstElement(array1, searchKey1);
			numberOfCallings++;
		}
		println("linear search (last hit) with 1024 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += linearSearchFirstElement(array2, searchKey2);
			numberOfCallings++;
		}
		println("linear search (last hit) with 2048 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += linearSearchFirstElement(array3, searchKey3);
			numberOfCallings++;
		}
		println("linear search (last hit) with 4096 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		// bin�re Suche (iterativ)

		while (numberOfCallings < 100) {

			average += binarySearchIterative(array1, searchKey1);
			numberOfCallings++;
		}
		println("binary search (iterative) with 1024 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += binarySearchIterative(array2, searchKey2);
			numberOfCallings++;
		}
		println("binary search (iterative) with 2048 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += binarySearchIterative(array3, searchKey3);
			numberOfCallings++;
		}
		println("binary search (iterative) with 4096 elements: " + average
				/ numberOfCallings);
		// TODO:
		/*
		System.out.println(numberOfCallings);
		System.out.println(average);
		System.out.println(binarySearchIterative(array3, searchKey3));
		 */
		average = 0;
		numberOfCallings = 0;

		// bin�re Suche Rekursiv

		while (numberOfCallings < 100) {

			average += binarySearchRecursive(array1, searchKey1, 0,
					array1.length);
			numberOfCallings++;
		}
		println("binary search (recursive) with 1024 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += binarySearchRecursive(array2, searchKey2, 0,
					array2.length);
			numberOfCallings++;
		}
		println("binary search (recursive) with 2048 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += binarySearchRecursive(array3, searchKey3, 0,
					array3.length);
			numberOfCallings++;
		}
		println("binary search (recursive) with 4096 elements: " + average
				/ numberOfCallings);

	}

	// method for performing and printing the unsuccesfull search
	static void unsuccesfulSearch() {
		
		//TODO: fehlen Aufrufe bei linearSearch

		println();
		println("____________________unsuccesfull search:________________________");

		int numberOfElements = 0;
		int[] array1 = new int[1024];
		int[] array2 = new int[2048];
		int[] array3 = new int[4096];

		// Initialising array1
		while (numberOfElements < array1.length) {

			if (numberOfElements == array1.length / 2)
				array1[numberOfElements] = numberOfElements + 1;
			else
				array1[numberOfElements] = numberOfElements;

			numberOfElements++;
		}
		numberOfElements = 0;

		// Initialising array2
		while (numberOfElements < array2.length) {

			if (numberOfElements == array2.length / 2)
				array2[numberOfElements] = numberOfElements + 1;
			else
				array2[numberOfElements] = numberOfElements;
			numberOfElements++;
		}
		numberOfElements = 0;

		// Initialising array3
		while (numberOfElements < array3.length) {

			if (numberOfElements == array3.length / 2)
				array3[numberOfElements] = numberOfElements + 1;
			else
				array3[numberOfElements] = numberOfElements;
			numberOfElements++;
		}

		int average = 0;
		int numberOfCallings = 0;

		// linear search (last hit)

		while (numberOfCallings < 100) {

			average += linearSearchLastElement(array1, array1.length / 2);
			numberOfCallings++;
		}
		println("linear search (last hit) with 1024 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		// linear search (first hit)

		while (numberOfCallings < 100) {

			average += linearSearchFirstElement(array1, array1.length / 2);
			numberOfCallings++;
		}
		println("linear search (first hit) with 1024 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += linearSearchFirstElement(array2, array2.length / 2);
			numberOfCallings++;
		}
		println("linear search (first hit) with 2048 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += linearSearchFirstElement(array3, array3.length / 2);
			numberOfCallings++;
		}
		println("linear search (first hit) with 4096 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		// binary search (iterative)

		while (numberOfCallings < 100) {

			average += binarySearchIterative(array1, array1.length / 2);
			numberOfCallings++;
		}
		println("binary search (iterative) with 1024 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += binarySearchIterative(array2, array2.length / 2);
			numberOfCallings++;
		}
		println("binary search (iterative) with 2048 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += binarySearchIterative(array3, array3.length / 2);
			numberOfCallings++;
		}
		println("binary search (iterative) with 4096 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		// binary search (recursive)

		while (numberOfCallings < 100) {

			average += binarySearchRecursive(array1, array1.length / 2, 0,
					array1.length);
			numberOfCallings++;
		}
		println("binary search (recursive) with 1024 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += binarySearchRecursive(array2, array2.length / 2, 0,
					array2.length);
			numberOfCallings++;
		}
		println("binary search (recursive) with 2048 elements: " + average
				/ numberOfCallings);

		average = 0;
		numberOfCallings = 0;

		while (numberOfCallings < 100) {

			average += binarySearchRecursive(array3, array3.length / 2, 0,
					array3.length);
			numberOfCallings++;
		}
		println("binary search (recursive) with 4096 elements: " + average
				/ numberOfCallings);

	}
}
