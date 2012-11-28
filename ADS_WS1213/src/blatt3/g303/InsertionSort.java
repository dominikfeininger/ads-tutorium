package blatt3.g303;

//Gruppe 3-3: 1230485 Marc Misoch, 1226580 Marcel Ortega, 1229645 Dominik Foos
//Aufgabe3a

import static gdi.MakeItSimple.*;

public class InsertionSort {

	public static int vertauschen=0, vergleichen= 0;
	public static void main (String[] args){
		int[] array = createRandomArray(1024);
		insertion(array);
		for (int i = 0; i< array.length; i++){
			print(array[i] + " ");
		}
		println("\n" + "vergleiche: " +"\t" +vergleichen + "\n" + "vertauschungen: " +vertauschen);
	}
	
	static void insertion(int [] array) {
		
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int m = array[i];
			while (j > 0 && array [j-1] > m) {
				
				vergleichen++;
				array [j] = array [j-1];
				vertauschen++;
				j--;
				
			}
			array[j] = m;
			vertauschen++;
		}
	}
	
	private static int[] createRandomArray(int anzahl) {
		int[] rückgabeA = new int[anzahl];
		
		for(int i = 0; i < anzahl; i++) {
			rückgabeA[i] = (int) Math.floor(Math.random()*anzahl);
		}
		return rückgabeA;
	}
}