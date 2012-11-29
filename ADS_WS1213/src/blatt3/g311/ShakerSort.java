package blatt3.g311;

import static gdi.MakeItSimple.*;

public class ShakerSort {
	
	/**
	 * This function uses the Bubblesort procedure to assort the Array from left to right and right to left.
	 * @param array: An Array of integer will be provided which have to be sort.
	 */
	public static void shakerSort(int[] array){
		int uebergabe, anfang = 0, ende = array.length - 1;
		while(anfang < ende){
			for (int i = anfang; i < ende; i++){ //Sortierung von links nach rechts
				if(array [i] > array[i+1]){
					uebergabe = array[i+1];
					array[i+1] = array[i];
					array[i] = uebergabe;
				}
			}
			for (int j = 0; j < array.length; j++){
				print(array[j] + " ");
			}
			println();
			ende--;
			for (int i = ende; i > anfang; i--){ //Sortierung von rechts nach links
				if(array [i] < array[i-1]){
					uebergabe = array[i];
					array[i] = array[i-1];
					array[i-1] = uebergabe;
				}
			}
			anfang++;
			for (int j = 0; j < array.length; j++){
				print(array[j] + " ");
			}
			println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] array = new int[10];
		int zufallszahl;
		for (int i = 0; i < array.length; i++){ //Hier wird ein Array mit Zufallszahlen gefüllt.
			zufallszahl = (int) (Math.random()*100)+1;
			array[i] = zufallszahl;
		}
		for (int j = 0; j < array.length; j++){
			print(array[j] + " ");
		}
		println();
		shakerSort(array);

	}

}
