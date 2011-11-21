package blatt3muster;

import static gdi.MakeItSimple.*;

// Hinweis: es werden nur die ursprüngliche und die sortierte Folge ausgegeben
// Der Ausdruck von Zwischenergebnissen ist auskommentiert.
// ... und nur geeignet für kleine Folgen

// Für das Testen ist es ganz interessant die Ergebnisse von Shakersort und Bubblesort gegenüberzustellen

class BubbleShakerSort {

	public static int[] fillArray(String filename) {
		// füllt den Vektor F von der Datei xxxx
		// Auf der Datei stehen nur int-Werte
		// der erste Wert gibt die Anzahl der Elemente an

		int[] F;

		Object file = openInputFile(filename); // Annahme: Datei existiert

		int noi = readInt(file); // # Elemente einlesen

		F = new int[noi];

		for (int i = 0; i < noi && !isEndOfInputFile(file); i++)

			F[i] = readInt(file);

		closeInputFile(file);

		return F;
	}

	static void swap(int[] array, int idx1, int idx2) {
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}

	static void printloopseparators(int[] array) {
		for (int i = 0; i < array.length; i++)
			print("----");
		println();
	}

	public static void printArray(int[] F) {

		// Prints Array F with 10 numbers per line
		// marks end of output with separate ==== - line

		println("Aktuelles Feld:");
		for (int i = 0; i < F.length; i++) {
			print(F[i] + " ");
			if (i % 10 == 9)
				println(); // max. 10 Zahlen pro Zeile
		}
		println();
		println("========================"); // Markierung für Ende einer
												// Ausgabe
	}

	static void printarrayswap(int[] array, int pos) {
		// prints the array with swapped pair emphasized
		for (int i = 0; i < array.length; i++)
			if (i == pos) {
				print("(" + array[i] + " " + array[i + 1] + ") ");
				i++; // increment index because 2 elements are printed
			} else
				print(array[i] + " ");

		println();
	}

	static void BubbleSort(int[] array) {

		int cnt = 0; // no. of comparisons
		int dlf = 0; // no. of loops
		int vrt = 0; // no. of swaps

		boolean swapped = true;

		for (int j = 0; j < array.length - 1 && swapped; j++) {
			dlf++;
			swapped = false;
			for (int i = 0; i < array.length - (j + 1); i++) {
				cnt++;
				if (array[i] > array[i + 1]) {
					// printarrayswap (array, i); // print before swap
					swap(array, i, i + 1); // swap elements
					swapped = true;
					vrt++;
				}
			}
			// printloopseparators (array);
		}

		println("# Vergleiche: " + cnt + "  # Durchläufe: " + dlf
				+ "  # Vertauschungen: " + vrt);
		println();
	}

	static void ShakerSort(int[] array) {

		int cnt = 0; // no. of comparisons
		int dlf = 0; // no. of loops left --> right and right --> left are
						// counted separatly
		int vrt = 0; // no. of swaps

		boolean swapped = true;
		int og = array.length - 1;
		int ug = 0;

		while (ug < og && swapped) {
			swapped = false;
			for (int i = ug; i < og; i++) { // left --> right
				cnt++;
				if (array[i] > array[i + 1]) {
					printarrayswap(array, i); // print before swap
					swap(array, i, i + 1); // swap elements
					swapped = true;
					vrt++;
				}
			}
			printArray(array); // print after loop
			printloopseparators(array);
			og--;
			dlf++;
			if (swapped) { // go on when swapped
				swapped = false;
				for (int i = og; i > ug; i--) { // right --> left
					cnt++;
					if (array[i - 1] > array[i]) {
						printarrayswap(array, i - 1); // print before swap
						swap(array, i - 1, i); // swap slements
						swapped = true;
						vrt++;
					}
				}
				if (ug < og) {
					printArray(array); // print after loop
					printloopseparators(array); // output after each loop
					ug++;
					dlf++;
				}
			}
		}
		//TODO: anzahl vergleiche falsch? 27 (3*9)!!! Bsp. auf Blatt?
		println("# Vergleiche: " + cnt + "  # Durchläufe: " + dlf
				+ "  # Vertauschungen: " + vrt);
		println();
	}

	// ///// ---------- main ----------------------------------------

	public static void main(String[] args) {

		int[] F;
		// Object file;
		// String filename;
		//
		// do {
		// print ("Zu sortierende Datei = ");
		// filename = readLine();
		// } while (!fileExists(filename)); // sicher stellen, dass Datei
		// existiert
		//
		//
		// F = fillArray (filename);

		// F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11,
		// 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
		// F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // array already
		// sorted
		// F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; // array sorted in
		// reverse
		// F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5}; // partially
		// presorted
		// F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1}; // sorted but last
		// element
		// F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5}; // first half sorted,
		// second half sorted
		// F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1}; // sorted but first
		// and last element
		// F = new int[] {1};

		// println("-------- end of bubble sort ------");
		// println();

		// F = fillArray (filename);

		// Fest vorgegebene Testfälle für die Testate

		// F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // F ist schon
		// sortiert
		// #Vgl = 9, #Dlf = 1, # Vert = 0
		// F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; // F ist umgekehrt
		// sortiert
		// #Vgl = 45, #Dlf = 9, # Vert = 45
		// F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5}; // F ist
		// alternierend, umgekehrt sortiert
		// #Vgl = 42, #Dlf = 7, # Vert = 25
		F = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 }; // F ist fast sortiert
															// - das kleinste
															// Element steht
															// ganz rechts
		// #Vgl = 24, #Dlf = 3, # Vert = 9
		// F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5}; // F besteht aus 2
		// sortierten Teilfolgen
		// #Vgl = 45, #Dlf = 9, # Vert = 25

		// F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1}; // F besteht aus 2
		// sortierten Teilfolgen
		// #Vgl = 24, #Dlf = 3, # Vert = 17

		// F = new int[] {1};

		println("Unsortiertes Array [vor Shakersort]");
		printArray(F);

		ShakerSort(F);

		println("Sortiertes Array");
		printArray(F);
		println();
		println("-------- end of shaker sort ------");

	}
}
