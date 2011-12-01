package klausur;

import static gdi.MakeItSimple.*;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 5, 9, 7, 8, 6, 4, 2, 3 };
		printarray(array);
		array = insertionSort(array);
		println();
		printarray(array);
	}

	public static int[] insertionSort(int[] array) {
		int m, j;
		for (int i = 1; i < array.length; i++) {
			j = i;
			m = array[i];
			while (j > 0 && array[j - 1] > m) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = m;
		}
		return array;
	}

	public static void printarray(int[] array) {
		for (int i = 0; i <= array.length - 1; i++) {
			print(array[i] + " , ");
		}
	}
}