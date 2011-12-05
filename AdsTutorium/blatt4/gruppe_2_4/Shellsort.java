package gruppe_2_4;


import static gdi.MakeItSimple.*;
public class Shellsort {

	
	public static void main(String[] args) {
		//int[] F = new int[40];
		//int[] F = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//		# Vergleiche: 106  # Vertauschungen: 68	
//		int [] F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//		# Vergleiche: 23  # Vertauschungen: 0		
  	//int [] F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Vergleiche: 32  # Vertauschungen: 18
//		int [] F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Vergleiche: 34  # Vertauschungen: 21
//		int [] F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//		# Vergleiche: 23  # Vertauschungen: 0
	
	int[]array = {9,3,2,5,4,7,6,8,0};
	shellsort(F);
	for (int i = 0; i < array.length; i++) {
		System.out.print(array[i] + " ");
	}
	}
	static void shellsort (int [] array){
		int[] step = {9,8,3,1};
		int vergleiche =0 ;
		for (int i = 0; i < step.length; i++) {
			vergleiche = vergleiche + insertionSort(array, step[i], vergleiche);
		}
		System.out.println(vergleiche+ " Vergleiche");
	}
		
	static int insertionSort (int [] array, int step,int vergleiche) {
		int vertauschen=0;
		for (int h = step; h < array.length; h = h + step) {
			int arrayIndex = h;
			int sortierWert = array[h];
			while (arrayIndex > 0 && array[arrayIndex - step] > sortierWert) {
				// Verschiebe alle gr��eren Elemente nach hinten
				array[arrayIndex] = array[arrayIndex - step];
				arrayIndex = arrayIndex - step;
				vergleiche++;
				vertauschen++;
				for (int i = 0; i < array.length; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println();

			}
			vergleiche++;
			// Setze m auf das freie Feld
			array[arrayIndex] = sortierWert;
		}
		System.out.println("vertauschen" + vertauschen);
		return vergleiche;
	}
	}

