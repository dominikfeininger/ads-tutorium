package gruppe_2_3;

import static gdi.MakeItSimple.*;

public class Komplexitätsexperiment {
	
	//TODO: Kommentare???

	public static void main(String[] args) {
		// initialize and fill array in ascending order ( 1 to max )
		int[] shortArray = new int[1024];
		int[] midArray = new int[2048];
		int[] longArray = new int[4096];

		fillArray(shortArray);
		fillArray(midArray);
		fillArray(longArray);

		int index = 0;

		int[] result1024 = new int[8];
		int[] result2048 = new int[8];
		int[] result4096 = new int[8];

		int[] counter1024 = new int[8];
		int[] counter2048 = new int[8];
		int[] counter4096 = new int[8];

		/*
		 * Succesful: 
		 * index 0 = linear Last 
		 * index 1 = linear First 
		 * index 2 = binary Recursive 
		 * index 3 = binary Iterative
		 * 
		 * Unsuccesful: 
		 * index 4 = linear Last 
		 * index 5 = linear First 
		 * index 6 = binary Recursive 
		 * index 7 = binary Iterative
		 */

		while (index < 100000) {
			int array1024 = (int) Math.floor(Math.random() * (shortArray.length + 200));
			int array2048 = (int) Math.floor(Math.random()
					* (midArray.length + 400));
			int array4096 = (int) Math.floor(Math.random()
					* (longArray.length + 800));

			// Array length 1024
			if (binarySearchHelp(shortArray, array1024) != -1) {
				result1024[0] += linearLastIndex(shortArray, array1024);
				counter1024[0]++;
			} else {
				result1024[4] += linearLastIndex(shortArray, array1024);
				counter1024[4]++;
			}

			if (binarySearchHelp(shortArray, array1024) != -1) {
				result1024[1] += linearFirstIndex(shortArray, array1024);
				counter1024[1]++;
			} else {
				result1024[5] += linearFirstIndex(shortArray, array1024);
				counter1024[5]++;
			}

			if (binarySearchHelp(shortArray, array1024) != -1) {
				result1024[2] += binarySearchRecursive(shortArray, array1024,
						0, shortArray.length - 1);
				counter1024[2]++;
			} else {
				result1024[6] += binarySearchRecursive(shortArray, array1024,
						0, shortArray.length - 1);
				counter1024[6]++;
			}

			if (binarySearchHelp(shortArray, array1024) != -1) {
				result1024[3] += binarySearchIterative(shortArray, array1024);
				counter1024[3]++;
			} else {
				result1024[7] += binarySearchIterative(shortArray, array1024);
				counter1024[7]++;
			}

			// Array length 2048
			if (binarySearchHelp(midArray, array2048) != -1) {
				result2048[0] += linearLastIndex(midArray, array2048);
				counter2048[0]++;
			} else {
				result2048[4] += linearLastIndex(midArray, array2048);
				counter2048[4]++;
			}

			if (binarySearchHelp(midArray, array2048) != -1) {
				result2048[1] += linearFirstIndex(midArray, array2048);
				counter2048[1]++;
			} else {
				result2048[5] += linearFirstIndex(midArray, array2048);
				counter2048[5]++;
			}

			if (binarySearchHelp(midArray, array2048) != -1) {
				result2048[2] += binarySearchRecursive(midArray, array2048, 0,
						midArray.length - 1);
				counter2048[2]++;
			} else {
				result2048[6] += binarySearchRecursive(midArray, array2048, 0,
						midArray.length - 1);
				counter2048[6]++;
			}

			if (binarySearchHelp(midArray, array2048) != -1) {
				result2048[3] += binarySearchIterative(midArray, array2048);
				counter2048[3]++;
			} else {
				result2048[7] += binarySearchIterative(midArray, array2048);
				counter2048[7]++;
			}

			// Array length 4096
			if (binarySearchHelp(longArray, array4096) != -1) {
				result4096[0] += linearLastIndex(longArray, array4096);
				counter4096[0]++;
			} else {
				result4096[4] += linearLastIndex(longArray, array4096);
				counter4096[4]++;
			}

			if (binarySearchHelp(longArray, array4096) != -1) {
				result4096[1] += linearFirstIndex(longArray, array4096);
				counter4096[1]++;
			} else {
				result4096[5] += linearFirstIndex(longArray, array4096);
				counter4096[5]++;
			}

			if (binarySearchHelp(longArray, array4096) != -1) {
				result4096[2] += binarySearchRecursive(longArray, array4096, 0,
						longArray.length - 1);
				counter4096[2]++;
			} else {
				result4096[6] += binarySearchRecursive(longArray, array4096, 0,
						longArray.length - 1);
				counter4096[6]++;
			}

			if (binarySearchHelp(longArray, array4096) != -1) {
				result4096[3] += binarySearchIterative(longArray, array4096);
				counter4096[3]++;
			} else {
				result4096[7] += binarySearchIterative(longArray, array4096);
				counter4096[7]++;
			}
			index++;
		}
		
		/* 
		 * Analysis
		 * Arrayl�nge(Anzhal der Suchen): durchschnittliche Anzahl Schl�sselvergleiche
		 */
		println("Linear Search Last:");
		println("Succecfull");
		println("1024 ("+ counter1024[0] +"): " + (result1024[0] / counter1024[0]));
		println("2048 ("+ counter1024[0] +"): " + (result2048[0] / counter2048[0]));
		println("4096 ("+ counter1024[0] +"): " + (result4096[0] / counter4096[0]));
		println("Unsuccecfull");
		println("1024 ("+ counter1024[4] +"): " + (result1024[4] / counter1024[4]));
		println("2048 ("+ counter1024[4] +"): " + (result2048[4] / counter2048[4]));
		println("4096 ("+ counter1024[4] +"): " + (result4096[4] / counter4096[4]));

		println();
		println("Linear Search First:");
		println("Succecfull");
		println("1024 ("+ counter1024[1] +"): " + (result1024[1] / counter1024[1]));
		println("2048 ("+ counter1024[1] +"): " + (result2048[1] / counter2048[1]));
		println("4096 ("+ counter1024[1] +"): " + (result4096[1] / counter4096[1]));
		println("Unsuccecfull");
		println("1024 ("+ counter1024[5] +"): " + (result1024[5] / counter1024[5]));
		println("2048 ("+ counter1024[5] +"): " + (result2048[5] / counter2048[5]));
		println("4096 ("+ counter1024[5] +"): " + (result4096[5] / counter4096[5]));

		println();
		println("Binary Search Recursive :");
		println("Succecfull");
		println("1024 ("+ counter1024[2] +"): " + (result1024[2] / counter1024[2]));
		println("2048 ("+ counter1024[2] +"): " + (result2048[2] / counter2048[2]));
		println("4096 ("+ counter1024[2] +"): " + (result4096[2] / counter4096[2]));
		println("Unsuccecfull");
		println("1024 ("+ counter1024[6] +"): " + (result1024[6] / counter1024[6]));
		println("2048 ("+ counter1024[6] +"): " + (result2048[6] / counter2048[6]));
		println("4096 ("+ counter1024[6] +"): " + (result4096[6] / counter4096[6]));

		println();
		println("Binary Search Iterativ :");
		println("Succecfull");
		println("1024 ("+ counter1024[3] +"): " + (result1024[3] / counter1024[3]));
		println("2048 ("+ counter1024[3] +"): " + (result2048[3] / counter2048[3]));
		println("4096 ("+ counter1024[3] +"): " + (result4096[3] / counter4096[3]));
		println("Unsuccecfull");
		println("1024 ("+ counter1024[7] +"): " + (result1024[7] / counter1024[7]));
		println("2048 ("+ counter1024[7] +"): " + (result2048[7] / counter2048[7]));
		println("4096 ("+ counter1024[7] +"): " + (result4096[7] / counter4096[7]));
	}

	static int linearLastIndex(int[] array, int searched) {
		int i = 0;
		while (i < array.length) {
			i++;;
		}
		return i;
	}

	static int linearFirstIndex(int[] array, int searched) {
		int i = 0;
		while (i < array.length) {
			if (searched == array[i])
				return i + 1;
			i++;
		}

		return i + 1;
	}

	static int binarySearchRecursive(int[] array, int searched, int first,
			int last) {
		if (last < first) {
			return 0;
		}
		int mid = first + (last - first) / 2;
		if (array[mid] > searched) {
			return 1 + binarySearchRecursive(array, searched, first, mid - 1);
		} else if (array[mid] < searched) {
			return 1 + binarySearchRecursive(array, searched, mid + 1, last);
		} else {
			return 1;
		}
	}

	static int binarySearchIterative(int[] array, int searched) {
		int mid = array.length / 2;
		int first = 0;
		int last = array.length - 1;
		int comparisons = 1;

		while (array[mid] != searched && first <= last) {
			mid = (first + last) / 2;
			if (searched == array[mid]) {
				return comparisons;
			}
			if (searched < array[mid]) {
				last = mid - 1;
				comparisons++;

			}
			if (searched > array[mid]) {
				first = mid + 1;
				comparisons++;
			}
		}

		return comparisons;
	}

	static void fillArray(int[] array) {
		// fill given Array in ascending order via side effect
		int i = 0;
		int number = 1;
		while (i < array.length) {
			if ((int) Math.floor(Math.random() * Integer.MAX_VALUE) % 2 == 0) {
				number = number + (int) Math.floor(Math.random() * 5);
				array[i] = number;

			} else {
				number++;
				array[i] = number;
			}
			i++;
		}
	}

	static int binarySearchHelp(int[] array, int searched) {
		// This method determines if the randomly generated key is found
		int mid = array.length / 2;
		int first = 0;
		int last = array.length - 1;

		while (array[mid] != searched && first <= last) {
			mid = (first + last) / 2;
			if (searched == array[mid]) {
				return mid;
			}
			if (searched < array[mid]) {
				last = mid - 1;

			}
			if (searched > array[mid]) {
				first = mid + 1;

			}
		}

		return -1;
	}

}
