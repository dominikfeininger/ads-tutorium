package blatt3.loesung;

import static gdi.MakeItSimple.*;
/**
 * @author Wolfgang Schramm
 *
 * 
 */
public class Sorts {
	
	static int cmps;    // number of comparisons
	static int swps;	// number of swaps
	static int runs;	// number of runs
	
	static void copyArray (int [] source, int [] dest) {
		// copies source --> dest
		// it is need to reinitialize an array
		for (int i = 0; i< source.length; i++)
			dest[i] = source[i];
	}
	
	static void swap (int [] array, int idx1, int idx2) {
		  int tmp = array[idx1];
		  array[idx1] = array[idx2];
		  array[idx2] = tmp;
		}	
	
	public static void printArray (int [] F) {
		
		// prints array F
		
		println("Aktuelles Feld:");
		for (int i = 0; i < F.length; i++){
			print (F[i] + " ");
			if (i % 10 == 9) println();   // max. 10 numbers per line
		}
		println();
		println("========================");   // marks end of output
	}
	

	public static int [] fillArray (String filename) {
		// fills fillArray from file
		// there are only int values on file
		// first value on file: number of elements
		
		int [] F;
		
		Object file = openInputFile(filename);  // it is assumed that file exists
				
		int noi = readInt (file);   // # read number of elements
		
		F = new int [noi];
		
		for (int i = 0; i < noi && !isEndOfInputFile(file); i++) 
		
			F[i] = readInt(file);

		closeInputFile(file);
		
		return F;
	}
	
	
	static void insertionSort (int [] array) { // original insertionSort
	  for (int i = 1; i < array.length; i++) {
	    int j = i;
	    int m = array[i]; // marker-field
	    cmps++;
	    while (j > 0 && array [j-1] > m) {
	    	// move all elements bigger to the right
	    	array [j] = array [j-1];
	    	swps++;
	    	j--;
	    }
	    // place maker field to the right position
	    array[j] = m;
	    swps++;
	  }
	}
	
	static int bsRec (int [] array, int key, int l, int u) {
		
		// recursive search implementation
		// does not look up if key is in array, instead 
		// returns the position key has to be inserted
		
		cmps++;
		
		if (l >= u)  return l; 
		
		int m = (l+u)/2;
		
		cmps++;
		
		if (array [m] <= key) return bsRec (array, key, m+1, u);
		else return bsRec (array, key, l, m-1); // search in left part
	}

		
	static void insertionSortB (int [] array) { // insertionSort with binary search for insert position
		
		  for (int i = 1; i < array.length; i++) {
			  runs++;
			  int j = i;
			  int m = array[i]; // marker-field
				
			  int pos = bsRec (array, m, 0, i);
			  
			  if (m == array[pos]) { // no swap necessary
				  cmps++;
				  continue;
			  }
			  		  
				
			  while (j > pos) {
					// move all elements bigger to the right
				  array [j] = array [j-1];
				  j--;
				  swps++;
			  }

			  // place maker field to the right position
	
				  array[j] = m;
				  swps++;

			  
				printArray(array);

		  }
		}



	static void selectionsort (int [] array) {  // modified selection sort
		
		// Variante: Es werden pro Durchlauf der kleinste und der größte Wert im (Rest) Feld gesucht
		//           und an die richtige Stelle getauscht.
		// Hinweis:  # Vergleiche gegenüber dem "normalen" Selctionsort verringert sich nicht, sie ist sogar
		//           etwas höher; n*n / 2 statt n * (n-1) / 2
		//           # Vertauschungen ist (natürlich in Abhängigkeit vom Aussehen der Sortierfolge) geringer (<=).

		
		int markermax = array.length - 1;	// position for biggest element
		int markermin = 0;					// position for smallest element
		  
		while (markermax > markermin) {  
		      // searches biggest and smallest element
		  int max = markermin;  // ... start with the first element
		  int min = max;        // smallest element dto.
		  
		  // elementary solution
		  for (int i = markermin+1; i <= markermax; i++) { // search in the remainder sequence
		    if (array [i] >= array [max]) // bigger element found,  >= --> probably no swap (if i resp. max is the rightmost position)
		      max = i;
		    if (array [i] < array [min]) // smallest element found
		    	min = i;
		    cmps += 2; // 2 comparisons
		  }
		  
		  if (markermax != max) {   // max. element not already at right position
			  swap (array, markermax, max);

			  if (markermax == min) // min. element is swapped to position max
				  min = max;
				  swps++;
			  }  // eigentlich 2 weitere Vergleiche
	
		  if (markermin != min) {   // min. element not already at right position
			  swap (array, markermin, min);
			  swps++;
		  }  // eigentlich 1 weiterer Vergleich
		  
		    
		  markermax--;
		  markermin++;
		  
		  runs++;
		  
		}
		
	}

	static void selectionsortO(int [] array) { // SelectionSort original
		
		
		int markermax = array.length - 1;	// position for biggest element
		int markermin = 0;					// position for smallest element
		  
		while (markermax > markermin) {  
		      // search biggest element
		  int max = markermin;  // ... start with the first element
		   
		  for (int i = markermin+1; i <= markermax; i++) { // search in the remainder sequence
			cmps++;
			if (array [i] >= array [max]) //
				max = i;
		  }
			
		  if (markermax != max) {   // max. element not already at right position
			  swps++;
			  swap (array, markermax, max);

		  }
		  
		    
		  markermax--;
		  runs++;
		  
//		  printArray (array);  // print array in intermediate state
		}
		

	}

		
	
	public static void main(String[] args) {
		
		int [] F;
		F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//		# Durchläufe: 10 # Vergleiche: 220  # Vertauschungen: 17
		
//		F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//		# Durchläufe: 5 # Vergleiche: 50  # Vertauschungen: 0	
		
//    	F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Durchläufe: 5 # Vergleiche: 50  # Vertauschungen: 5

//		F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Durchläufe: 5 # Vergleiche: 50  # Vertauschungen: 7

//		F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
//		# Durchläufe: 5 # Vergleiche: 50  # Vertauschungen: 9

//		F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen
//		# Durchläufe: 5 # Vergleiche: 50  # Vertauschungen: 5

//		F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
//		# Durchläufe: 5 # Vergleiche: 50  # Vertauschungen: 1
		
//		F = new int[] {1};
//		# Durchläufe: 0 # Vergleiche: 0  # Vertauschungen: 0
		

//		F = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das größte Element steht ganz links
//		# Durchläufe: 5 # Vergleiche: 50  # Vertauschungen: 9	
		
//		F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//		# Durchläufe: 5 # Vergleiche: 50  # Vertauschungen: 0
		
//
		
//		Object file;
//		String filename;
//		
//		do {
//		  print ("Zu sortierende Datei = ");
//		  filename = readLine();
//		} while (!fileExists(filename));  // guarantee that file exists
//				
//		
//		F = fillArray (filename);

		println ("Unsortiertes Array:");
		printArray (F);
		
		int F2 [] = new int[F.length];
		copyArray (F, F2);	// kopiert F nach F2, dann läuft der min-max-SelectionSort mit F und der normale SelectionSort mit F2
		
		insertionSortB (F);
		println ("Modifizierter Insertion Sort");
		println ("Sortiertes Array:");
		printArray(F);
		
		println ("# Durchläufe: " + runs +  " "  + "# Vergleiche: " + cmps +  "  # Vertauschungen: " + swps);
		println();

		
		
//		println ("Unsortiertes Array:");
//		printArray(F2);
//		selectionsortO (F2);
//		println ("Selection Sort (Original)");
//		println ("Sortiertes Array:");
//		printArray(F2);

	}
	
}



