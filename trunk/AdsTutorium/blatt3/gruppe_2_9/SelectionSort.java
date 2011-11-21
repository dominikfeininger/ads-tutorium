package gruppe_2_9;

import static gdi.MakeItSimple.*;

public class SelectionSort {
	
	//TODO: Ergebnis net schlecht, aber Vergleiche und Vertaushcungen falsch gez‰hlt!!!

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int row[] = { 9,8,7,6,5,4,3,2,1,0};
		// int row[] = {0,1,1,1,1,51,134,5,15,31,314,15,15,0};
		// int row[] = { 123,125,135,145,135,125,123 };
		// int row[] = { 1,4,2,5,6,1,15,1515,15,15,51,5,6666,2243,234,244,111,11,1,0,15,51,123,51,16,135,999,9999,99999 };
		int row[] = { 1,2,3,4,5,262,62,73,25,14,3874,1,2,3,4 };
		int[] F;
		F = new int[] { 10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32,
				23, 19, 7, 6, 14, 29 }; // "zufälliges" Feld
		// int row[] = { 2000000,199999,99999};
		// int row[] = { 1,2};
		int i = 0, compare = 0, changes = 0;

		selectionSort(F, compare, changes);

		while (i < F.length) {
			print(F[i] + ". ");
			i++;

		}

	}


	static void selectionSort(int[] row, int compare, int countedSort) {
		int upperLimit = row.length - 1, lowerLimit = 0;

		// loop ends when the limits are reaching each other
		while (upperLimit != lowerLimit && upperLimit - lowerLimit != 1) {

			// prints after every done loop
			for (int j = 0; row.length > j; j++) {
				print(row[j] + " ");
			}
			
			int max = 0;
			int min = lowerLimit;
			int i = min;

			while (i <= upperLimit) {
				// if the biggest element was found
				if (row[i] > row[max]) {
					max = i;
					compare++;
				}
				// if the smallest one was found
				if (row[i] < row[min]) {
					min = i;
					compare++;
				}
				i++;
			}

			// Swap the current position with the biggest element
			swapElements(row, upperLimit, max);
			countedSort++;

			// if smallest Element equal the biggest one
			if (min == upperLimit) {
				min = max;
			}

			// Swap current position with the smallest element
			swapElements(row, lowerLimit, min);

			upperLimit--;
			lowerLimit++;
			println();
		}
		println("Counted Sorts : " + countedSort);
		println("Compares : " + compare);

	}


	static void swapElements(int[] row, int index1, int index2) {
		
		// Swap the elements from the given arrays
		int help = row[index1];
		row[index1] = row[index2];
		row[index2] = help;

	}

}
