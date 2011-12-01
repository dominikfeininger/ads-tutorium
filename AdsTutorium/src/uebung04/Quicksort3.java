package uebung04;

import static gdi.MakeItSimple.*;

public class Quicksort3 {

	/**
	 * @param args
	 */

	static int swaps = 0;
	static int compares = 0;
	
	static void printArraySwaps(int[] array, int minIndex, int maxIndex) {
		for (int i = 0; i < array.length; i++) {
			if ((i == minIndex) || (i == maxIndex)) {
				print("[" + array[i] + "] ");
			} else {
				print(array[i] + " ");
			}
		}
	}

	// Hilfsmethode zum Vertauschen zweier Feldelemente
	static void swap(int[] array, int idx1, int idx2) {
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
		swaps++;
	}

	// Hilfsmethode zum Ausgeben eines Arrays
	static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			print(array[i] + " ");
		}
	}

	// Zerlege-Funktion für den Quicksort
	public static int zerlege(int[] f, int u, int o) {
		int p = o;
		int pivotelement = f[p];
		int index = u;
		for (int zeiger = u; zeiger <= o - 1; zeiger++) {
			compares++;
			if (f[zeiger] < f[p]) {
				if (index != zeiger) {
					swap(f, index, zeiger);
				}
				index++;
			}
		}
		swap(f, index, o);
		return index;
	}

	// Quicksort-Funktion
	public static void quicksort(int[] f, int u, int o) {
		if (o > u) {
			int index = zerlege(f, u, o);
			quicksort(f, u, index - 1);
			quicksort(f, index + 1, o);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 17, 31, 5 ,59 ,13 ,41};
		println("Initialarray:");
		printArray(array);
		println();
		println();
		quicksort(array, 0, array.length - 1);
		println("swaps: " + swaps);
		println("compares: " + compares);
		println();
		println("Sortiertes Array:");
		printArray(array);
	}

}
