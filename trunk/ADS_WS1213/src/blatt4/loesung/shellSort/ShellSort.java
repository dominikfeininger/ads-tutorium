package blatt4.loesung.shellSort;

import static gdi.MakeItSimple.*;
/**
 * @author schramm
 *
 * 
 */

public class ShellSort {
	
	public static void printArray (int [] F) {
		
		// prints the complete array
		
		println("Aktuelles Feld:");
		for (int i = 0; i < F.length; i++){
			print (F[i] + " ");
			if (i % 10 == 9) println();   // max. 10 numbers per line
		}
		println();
		println("===================================================");   // marks the end of output
	}
	
	public static void printArrayh (int [] F, int h, int vg, int vt) {
		
	  // prints all index areas of one h sorting separately
	  
	  println("===================================================");  // marks the start of output	  
	  println(h + " Sortierung");
	  println("---------------");
	  for (int j = 0; j < h; j++) {
		println("Indexmenge " + (j+1));
		for (int i = j, k = 0; i < F.length; i =i+h, k++){
			print (F[i] + " ");
			if (k % 10 == 9) println();   // max. 10 numbers per line
		}
		println();
		println("------------------------");  // marks the start of an index area
	  }
	  println ("Zahlen für die aktuelle h-Sortierung");
	  println("# Vergleiche: " + vg + " # Vertauschungen: " + vt);
	  println("===================================================");  // marks the end of an index area	  
	}

	public static int [] fillArray (String filename) {
		// fills array F from file xxxx
		// there are only int value on file
		// the first value on the file indicates the number of the following values and is not sorted 
		
		int [] F;
		
		Object file = openInputFile(filename);  // precondition: file already exists
				
		int noi = readInt (file);   // # read number of elements
		
		F = new int [noi];
		
		for (int i = 0; i < noi && !isEndOfInputFile(file); i++) 
		
			F[i] = readInt(file);

		closeInputFile(file);
		
		return F;
	}

	public static void shellsort (int F [], int h_idx []) {
		// Array F is sorted by ShellSort
//		int [] h_idx = {1}; // is only 1 in the h-set ==> InsertionSort !!!
		int swapc  = 0; // counter for swaps (total) 
		int cmpc   = 0; // counter for comparisons (total) 
		int swapcl = 0; // counter for swaps (current index) 
		int cmpcl  = 0; // counter for comparisons (current index) 
		int swapch = 0; // counter for swaps (current h sorting) 
		int cmpch  = 0; // counter for comparisons (current h sorting) 
		int dlc = 0;    // counter for loops; 1 loop = inserting 1 element by Insertiion Sort
		
		for (int i = 0; i < h_idx.length; i++) { // alle h-Sortierungen abarbeiten
			int h = h_idx[i];  // current h-sorting
			for (int j = 0; j < h; j++) { // j = starting index of h-sorting
				// Hint: only for testing reasons
				//store "locally" comparisons and swaps
				swapcl = cmpcl = 0;
				for (int k = j+h; k < F.length; k += h) { // k = current index of current h-sorting
					int m = F[k];   // keep element to be inserted
					int l = k;      // index in current h sorting starting for  backward inserting by Insertion Sort 
					dlc++;  // increment loop counter
					while (l-h >= 0) {  // arriving at front?
						cmpc++; // for comparison m < F[l-h]
						cmpcl++; // only for testing reasons
						if (m < F[l-h]) { 
							F[l] = F[l-h];
							l -=h;
							swapc++;
							swapcl++;  // only for testing reasons
						}
						else break;
					}   // end of insertion
					if (l != k) { // insert only when not already at the right place
					   F[l] = m;  // move element to the right place
					   // moving the element to the right place is not counted as a swap

					}
				}
				println ("lokale Vergleiche= " + cmpcl + " lokale Vertauschungen= " + swapcl);
				cmpch = cmpch + cmpcl;
				swapch = swapch + swapcl;
			}
			// output of F - for each h-sorting
//			println ("Array nach " + h + "-Sortierung");
			printArrayh(F, h, cmpch, swapch);
			cmpch = swapch = 0;
//			printArrayh(F, h, cmpc, swapc);
		  }
		println ("Gesamtzahl");
		println ("# Vergleiche: " + cmpc + " # Vertauschungen: " + swapc);
		println ("#Insertion Sort Durchläufe= " + dlc);

		}
		
	
	public static void main(String[] args) {
		
		int [] F;
//		F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
		
//
//		F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert

		F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert

		

//		F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend sortiert und umgekehrt sortiert

		
//		F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
//		F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen


//		F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
//		F = new int[] {1};
//		F = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das größte Element steht ganz links
		
		int [] h_idx = {9, 7, 4, 1}; // indices for h sorting
		
//		int [] h_idx = {1}; // Ist nur die 1 in der h-Menge ==> InsertionSort !!!
		
//		String filename;
		
//		do {
//		  print ("Zu sortierende Datei = ");
//		  filename = readLine();
//		} while (!fileExists(filename));  // sicher stellen, dass Datei existiert
//				
//		
//		F = fillArray (filename);

		println ("Unsortiertes Array:");
		printArray (F);
		
		shellsort (F, h_idx);
		
		printArray(F);
	}
}

