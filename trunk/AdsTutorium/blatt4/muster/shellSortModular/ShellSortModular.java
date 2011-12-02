package muster.shellSortModular;

/**
 * @author schramm
 *
 * Folgendes ausw�hlen, um die Schablone f�r den erstellten Typenkommentar zu �ndern:
 * Fenster;Benutzervorgaben;Java;Codegenerierung;Code und Kommentare
 */

import static gdi.MakeItSimple.*;

class counter {
	public int swapc;
	public int cmpc;
	
	public counter () {
		swapc = 0;
		cmpc = 0;
	}
}
 
public class ShellSortModular  {
	
	public static void printArray (int [] F) {
		
		// Gibt das komplette Feld aus
		
		println("Aktuelles Feld:");
		for (int i = 0; i < F.length; i++){
			print (F[i] + " ");
			if (i % 10 == 9) println();   // max. 10 Zahlen pro Zeile
		}
		println();
		println("========================");   // Markierung f�r Ende einer Ausgabe
	}
	
	public static void printArrayh (int [] F, int h) {
		
	  // gibt die Indexbereiche einer h-Sortierung getrennt aus
	  
	  println(h + " Sortierung");
	  for (int j = 0; j < h; j++) {
		println("Indexmenge " + (j+1));
		for (int i = j, k = 0; i < F.length; i =i+h, k++){
			print (F[i] + " ");
			if (k % 10 == 9) println();   // max. 10 Zahlen pro Zeile
		}
		println();
		println("------------------------");  // Markierung f�r Ende eines Indexbereichs
	  }
	  println("========================");  // Markierung f�r Ende einer Ausgabe	  
	}

	public static int [] fillArray (String filename) {
		// f�llt den Vektor F von der Datei filename
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
	
	public static void insertionSorth(int [] F, int h, int s, counter statistics) {
		// sortiert Indexmenge von Feld F mit Insertion Sort
		// h = aktueller Wert aus der h-Menge
		// s = Startindex, ab dem der InsertionSort losl�uft
		
		int j, m;
		
		for (int i = s+h; i < F.length; i+=h) {
			m = F[i];
			
			statistics.cmpc++; // f�r Vergleich m < F[l-h] sonst wird bei nicht erf�llen nicht gez�hlt

			for (j = i; j >= h && m < F[j-h]; j -= h) { // r�ckw�rts laufen zum Einf�gen an der richtigen Stelle
			  F[j] = F[j-h];
			  statistics.swapc++;
			  statistics.cmpc++;			  
			}
			   
			  
			if (j != i) { // nur dann einf�gen, wenn nicht eh schon an der richtigen Stelle
			   F[j] = m;  // bringe Element m an die richtige Stelle
			   statistics.swapc++;
			}
		}
	}

	
//  all-in-one Version des ShellSort
	
//	public static void shellsort (int F []) {
//		// sortiert das übergebene Array F mittels ShellSort
////		int [] h_idx = {9, 4, 3, 1}; // Array mit Indizes für h-Sortierung
//		int [] h_idx = {1}; // Ist nur die 1 in der h-Menge ==> InsertionSort !!!
//		int swapc = 0; // Zähler für Vertauschungen, # Vergleiche = # Vertauschungen
//		int cmpc  = 0; // Zähler für Vergleiche
//		for (int i = 0; i < h_idx.length; i++) { // alle h-Sortierungen abarbeiten
//			int h = h_idx[i];  // aktuelle h-Sortierung
//			for (int j = 0; j < h; j++) { // j = Startindex einer h-Sortierung
//				for (int k = j+h; k < F.length; k += h) { // k = aktueller Index der aktuellen h-Sortierung
//					int m = F[k];   // merke rein zu schiebendes Element
//					int l = k;      // Index innerhalb der aktuellen h-Sortierung ab dem rückwärts
//									// laufend - via Insertion Sort eingefügt bzw. eingeschoben wird
//					cmpc++; // für Vergleich m < F[l-h] sonst wird bei nicht erfüllen nicht gezählt
//					while (l-h >= 0 && m < F[l-h]) {
//						F[l] = F[l-h];
//						l -=h;
//						swapc++;
//						cmpc++;
//					}   // Ende des rein Schiebens
//					if (l != k) { // nur dann einfügen, wenn nicht eh schon an der richtigen Stelle
//					   F[l] = m;  // bringe Element m an die richtige Stelle
//					   swapc++;
//					}
//				}
//			}
//			// Ausgabe von F - nach jeder h-Sortierung
//			println ("Array nach " + h + "-Sortierung");
//			printArrayh(F, h);
//		  }
//			println("# Vertauschungen: " + swapc + " # Vergleiche: " + cmpc);
//		}
		
	public static void shellSort (int F []) {
		int [] hSet = {9, 4, 3, 1}; // hSet: Array mit Indizes für h-Sortierung
//		int [] h_idx = {1}; // Ist nur die 1 in der h-Menge ==> InsertionSort !!!
		int h;    // aktueller Index aus hSet
//		int swapc = 0; // Zähler für Vertauschungen, # Vergleiche = # Vertauschungen
//		int cmpc  = 0; // Zähler für Vergleiche
		
		counter statistics = new counter();
	
		for (int i = 0; i < hSet.length; i++) {
			h = hSet[i];
			for (int j = 0; j < h; j++)
			  insertionSorth(F, h, j, statistics);  
			  printArray (F); // Ausgabe nach jeder h-Sortierung
		}

			println("# Vertauschungen: " + statistics.swapc + " # Vergleiche: " + statistics .cmpc);
				
	}
		
	
	public static void main(String[] args) {
		
//		int [] F = {0}; 
		int [] F = {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29};

		
//		Object file;
//		String filename;
//		
//		do {
//		  print ("Zu sortierende Datei = ");
//		  filename = readLine();
//		} while (!isFilePresent(filename));  // sicherstellen, dass Datei existiert
//				
//		
//		F = fillArray (filename);


		println ("Unsortiertes Array:");
		printArray (F);
		
		shellSort (F);

//		insertionSorth(F, 3, 0);

		printArray(F);
	}
}
