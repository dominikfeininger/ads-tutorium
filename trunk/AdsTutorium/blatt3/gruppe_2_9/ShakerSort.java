package gruppe_2_9;

import static gdi.MakeItSimple.*;

public class ShakerSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//TODO: Ergebnis richtig, Darstellung!!! zu wenig zeilen

		// Initializing variables
		int[] numbers = { 44, 55, 12, 42, 94, 18, 6, 67 };
		int [] F = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
		println("Eingabe der Arraylänge");
		int i = 0;
		int compare = 0;
		int countedSort = 0;

		// requesting function shakerSort
		shakerSort(F, compare, countedSort);

		// loop to print array on console
		while (i < F.length) {
			print(F[i] + ". ");
			i++;
		}

	}

	static int[] shakerSort(int[] array, int compare, int countedSort) {

		boolean sort = false;
		boolean forward = true;

		int leftNumber = 0;
		int rightNumber = array.length - 1;
		int counterTry = 0;
		int changingVariable = 0;

		// loop whether leftNumber < rightNumber and sort = false
		while (leftNumber < rightNumber && !sort) {
			sort = true;

			// printing flow 0 to flow n
			print("F" + counterTry + ": ");

			// loop for printing numbers on console
			for (int arrayCounter = 0; array.length > arrayCounter; arrayCounter++) {
				print(array[arrayCounter] + " ");
			}
			counterTry++;

			if (forward == true) {

				// loop whether i < rightNumber - sort from left to right
				for (int i = leftNumber; i < rightNumber; i++) {
					compare++;

					// swapping digit i with digit i+1
					if (array[i] > array[i + 1]) {
						changingVariable = array[i];
						array[i] = array[i + 1];
						array[i + 1] = changingVariable;
						sort = false;
						countedSort++;
					}

				}
				rightNumber--;
			} else {
				// loop to sort from right to left
				for (int i = rightNumber; i > leftNumber; i--) {
					compare++;

					if (array[i] < array[i - 1]) {
						changingVariable = array[i];
						array[i] = array[i - 1];
						array[i - 1] = changingVariable;
						sort = false;
						countedSort++;
					}
				}
				leftNumber++;
			}
			// end of sort
			forward = false;
			println();
		}
		// printing Compares and Counted sorts on console
		println("Compares : " + compare);
		println("Counted Sorts : " + countedSort);
		return array;
	}
}
