package blatt3muster;

import static gdi.MakeItSimple.*;
/**
 * @author Schramm
 *
 * 
 */
public class SelectionSort {
	
	static void copyArray (int [] source, int [] dest) {// copies source --> dest
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

	static void selectionsort (int [] array) {  // modified selection sort (exercise 3)
		
		// Variante: Es werden pro Durchlauf der kleinste und der größte Wert im (Rest) Feld gesucht
		//           und an die richtige Stelle getauscht.
		// Hinweis:  # Vergleiche gegenüber dem "normalen" Selctionsort verringert sich nicht, sie ist sogar
		//           etwas höher; n*n / 2 statt n * (n-1) / 2
		//           # Vertauschungen ist (natürlich in Abhängigkeit vom Aussehen der Sortierfolge) geringer.

		int cnt = 0; // no. of comparisons
		int vrt = 0; // no. of swaps
		int dlf = 0; // no. of loops

		
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
		    cnt += 2; // 2 comparisons
		  }
		  
		  if (markermax != max) {   // max. element not already at right position
			  swap (array, markermax, max);

			  if (markermax == min) // min. element is swapped to position max
				  min = max;
				  vrt++;
			  }
	
		  if (markermin != min) {   // element not already at right position
			  swap (array, markermin, min);
			  vrt++;
		  }
		  
		    
		  markermax--;
		  markermin++;
		  
		  dlf++;
		  
		  printArray (array);
		}
		
		println ("# Durchl‰ufe: " + dlf +  " "  + "# Vergleiche: " + cnt +  "  # Vertauschungen: " + vrt);
		println();

	}

	static void selectionsortO(int [] array) { // SelectionSort Original
		
		// 
		
		int cnt = 0; // no. of comparisons
		int vrt = 0; // no. of swaps
		int dlf = 0; // no. of loops

		
		int markermax = array.length - 1;	// position for biggest element
		int markermin = 0;					// position for smallest element
		  
		while (markermax > markermin) {  
		      // search biggest element
		  int max = markermin;  // ... start with the first element
		   
		  for (int i = markermin+1; i <= markermax; i++) { // search in the remainder sequence
			cnt++;
			if (array [i] >= array [max]) // grˆﬂeres Element gefunden, kann nicht das kleinste sein --> 1 Vergleich weniger
		      max = i;
		  }
			
		  if (markermax != max) {   // max. element not already at right position
			  vrt++;
			  swap (array, markermax, max);

		  }
		  
		    
		  markermax--;
		  dlf++;
		  
		  printArray (array);
		}
		
		println ("# Durchläufe: " + dlf +  " "  + "# Vergleiche: " + cnt +  "  # Vertauschungen: " + vrt);
		println();

	}

		
	
	public static void main(String[] args) {
		
		int [] F;
		F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//
		
//		F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
		
//    	F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert

//		F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert

//		F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts

//		F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen

//		F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
		
//		F = new int[] {1};
		
//		F = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das grˆﬂte Element steht ganz links
		
//		F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Element sind gleich
		
//
		
//		Object file;
//		String filename;
//		
//		do {
//		  print ("Zu sortierende Datei = ");
//		  filename = readLine();
//		} while (!fileExists(filename));  // sicher stellen, dass Datei existiert
//				
//		
//		F = fillArray (filename);

		println ("Unsortiertes Array:");
		printArray (F);
		
		int F2 [] = new int[F.length];
		copyArray (F, F2);
		
		selectionsort (F);
		println ("Erweiterter Selection Sort");
		println ("Sortiertes Array:");
		printArray(F);
		
		println ("Unsortiertes Array:");
		printArray(F2);
		selectionsortO (F2);
		println ("Selection Sort (Original)");
		println ("Sortiertes Array:");
		printArray(F2);

	}
	
}


