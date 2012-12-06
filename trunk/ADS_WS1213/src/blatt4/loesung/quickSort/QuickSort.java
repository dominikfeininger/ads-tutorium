
package blatt4.loesung.quickSort;

import static gdi.MakeItSimple.*;

/**
 * @author Schramm
 *
 * 
 */



public class QuickSort {
	
	static void swap (int [] array, int idx1, int idx2, int [] counters) {
		  int tmp = array[idx1];
		  println ("swap (" + array[idx1] + ", " + array[idx2] +")");
		  

		  
		  array[idx1] = array[idx2];
		  array[idx2] = tmp;
		  counters[1]++;
		}	
	
	public static void printArray (int [] F, int u, int o) {
		
		// prints array from range u to o
		
		println("Aktuelles Feld:");
		for (int i = u; i <= o; i++){
			print (F[i] + " ");
			if (i % 10 == 9) println();   // max. 10 Zahlen pro Zeile
		}
		println();
		println("========================");   // Markierung für Ende einer Ausgabe
	}
	

	public static int [] fillArray (String filename) {
		// füllt den Vektor F von der Datei xxxx
		// Auf der Datei stehen nur int-Werte
		// der erste Wert gibt die Anzahl der Elemente an
		
		int [] F;
		
		Object file = openInputFile(filename);  // Annahme: Datei existiert
				
		int noi = readInt (file);   // # Elemente einlesen
		
		F = new int [noi];
		
		for (int i = 0; i < noi && !isEndOfInputFile(file); i++) 
		
			F[i] = readInt(file);

		closeInputFile(file);
		
		return F;
	}


	static int split (int [] F, int u, int o, int [] counters) {

		// variant 3 from lecture;
		// modification: number of swaps is minimize --> there is no swap addressing the same index
		// number of comparisons increases
		// Pivot element is at the rightmost position.
		// Splits the array F in relation to the Pivot element and
		// return the index where the Pivot element is placed. 
		
		int p = o; // p = index of Pivot element
			//Man bräuchte p nicht - da man o unerverändert lässt (anders als in V2) kann man immer mit o arbeiten. Ist m.E. so aber besser lesbar.
		
		int idx = u;
		
		for (int pos = u; pos <= o-1; pos++) {
			counters [0]++;
			if (F[pos] <= F[p]) {
				
				counters [0]++;    // increment comparison count for the reason of the following if		(***)
				if (idx != pos)    // don't swap if idx == pos											(***)
					swap (F, idx, pos, counters);

				idx++;
			}
		}

		counters [0]++;    // increment comparison count for the reason of the following if				(***)
		if (idx != o) swap (F, idx, o, counters);  // insert Pivot element at the right place			(***)

//		swap (F, idx, o, counters);  // insert Pivot element at the right place							(****)
		
		
		// original version: comment out lines with (***) and un-comment line with (****)
		
		return idx;

	
	} // ~ split

	
	
	static void quicksort (int [] F, int u, int o, int [] counters) {
		
		// variant 3 from lectures

		int i;
		
		if (o > u) {
			i = split (F, u, o, counters);
			if (u < i-1) {
				quicksort (F, u, i-1, counters);
				printArray (F, u, i-1);
				counters[2]++;
			}
			if (o > i+1) {
				quicksort (F, i+1, o, counters);
				printArray (F, i+1, o);
				counters[2]++;
			}


		}
	}

		
	
	public static void main(String[] args) {
		
		int [] counters = new int[] {0, 0, 0}; // array for counting comparisons (idx 0), swaps (idx 1) & recursions (idx 2)

		
		int [] F;
		
		
		F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//		# Rekusionen: 30 # Vergleiche: 119  # Vertauschungen: 31
		
//		F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//		# Rekusionen: 8 # Vergleiche: 99  # Vertauschungen: 0	
		
//  	F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Rekusionen: 8 # Vergleiche: 74  # Vertauschungen: 5


//		F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Rekusionen: 6 # Vergleiche: 41  # Vertauschungen: 9

//		F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
//		# Rekusionen: 8 # Vergleiche: 54  # Vertauschungen: 9

//		F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen
//		# Rekusionen: 7 # Vergleiche: 53  # Vertauschungen: 5


//		F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
//		# Rekusionen: 8 # Vergleiche: 90  # Vertauschungen: 1
		
//		F = new int[] {1};
//		# Rekusionen: 0 # Vergleiche: 0  # Vertauschungen: 0		

//		F = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das größte Element steht ganz links
//		# Rekusionen: 7 # Vergleiche: 81  # Vertauschungen: 9	

//		F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//		# Rekusionen: 8 # Vergleiche: 99  # Vertauschungen: 0		

		
//		Array aus Datei füllen
		
//		Object file;
//		String filename;
//		
//		do {
//		  print ("Zu sortierende Datei = ");
//		  filename = readLine();
//		} while (!fileExists(filename));  // sicherstellen, dass Datei existiert
//				
//		
//		F = fillArray (filename);

		println ("Unsortiertes Array:");
		printArray (F, 0, F.length-1);
		
		quicksort (F, 0, F.length-1, counters);

		println ("Sortiertes Array:");
		printArray(F, 0, F.length-1);
		
		println ("# Rekursionen: " + counters [2] +  " "  + "# Vergleiche: " + counters [0] +  "  # Vertauschungen: " + counters [1]);
		println();

	}
}



