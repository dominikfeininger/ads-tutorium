package gruppe_2_6;


import static gdi.MakeItSimple.*;

public class Shellsort {

	/**
	 * prints an array on the console
	 * 
	 * @param array
	 */
	static void printRun(int[] array) {
		int i = 0;
		while (i < array.length)
			print(array[i++] + " ");
		println();
	}

	/**
	 * normal insertion Sort but with every h. element
	 * @param array
	 * @param h ("jump-length")
	 * @param counter
	 */
	static void insertionSort(int[] array, int h, int[] counter) {
		int i = 0, j, t;
		while (i < array.length) {
			j = i;
			t = array[j];
			while (j > 0 && array[j - h] > t) {
				array[j] = array[j - h];
				j -= h;
				counter[0] += 1;
			}
			counter[1] += 1;
			array[j] = t;
			i += h;
		}
	}

	/**
	 * assorts an array like insertion sort but more efficient as it "jumps"
	 * over some elements and assorts it in a few runs with different length of
	 * the jumps
	 * 
	 * @param array
	 */
	static void shellSort(int[] array) {
		
		// defines the "jumps"
		int[] h = { 9, 7, 4, 1 };
		int[] counter = new int[2];
		counter[0] += 0; // changes
		counter[1] += 0; // compares

		// do insertion sort with every h. element
		for (int i = 0; i < h.length; i++) {
			insertionSort(array, h[i], counter);
			printRun(array);
		}
		println();
		println("anzahl der Vertauschungen: " + counter[0]);
		println("anzahl der Vergleiche: " + counter[1]);
	}

	public static void main(String[] args) {

		int i = 0;
		// create an array and fill with random numbers
		int[] array = new int[14];
		while (i < array.length) {
			array[i++] = (int) (Math.random() * 50);
		}

		println("startarray");
		printRun(array);
		println();

		shellSort(array);
	}

}