package blatt3.g311;

import static gdi.MakeItSimple.*;

public class InsertionSort {

	
	/**
	 * This Function assort an Array with the Insertion Sort.
	 * @param array: An Array of Integer will be provided, which have to be assort.
	 */
	public static void insertionSort(int[] array){
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int m = array[i];
			while (j > 0 && array [j-1] > m) {
				array [j] = array [j-1];
				j--;
				array[j] = m;
			}

		}
	}
	
	/**
	 * Diese Mehode sucht die Position im Array, an die der gesuchte Wert gesetzt werden muss. This method locates the position in the array, which the searched value must be set.
	 * @param array: An Array of integer will be provided where the position have to be searched.
	 * @param suchSchlüssel: The Position of the Value will be searched.
	 * @param o: The Area beetween 0 and O is already assort. We need O because only in the assorted Area have to be searched.
	 * @return: If the Index in the Array is provided and returned as an statement. Now the founded Value goes to this position.
	 */
	public static int sucheEinfugeposition(int[] array, int suchSchlussel, int o){
		int u = 0;
		while (u <= o) {
			int m = (u + o) / 2;
			if (suchSchlussel >= array[m] & suchSchlussel < array[m + 1]){
				return m + 1;
			}
			else if (suchSchlussel < array[m]){
				o = m-1;
			}
			else{
				u = m+1;
			}
		}
		return 0;
	}
	
	/**
	 * This Function assort an Array with the Insertion Sort but it does not check if the position smaller then the actual Index position. 
	 * It searches the Position where the actual have to be. After that every value will be desplaced to the right side of the actual position.
	 * The Value will be placed at the founded position. 
	 * @param array: An array of int will eb provided, which will be assort.
	 */
	public static void insertionSortBinär(int[] array){
		int einfugeposition = 0;
		for (int i = 1; i < array.length; i++) {
			int m = array[i];
			if(array[i] < array[i-1]){
				einfugeposition = sucheEinfugeposition(array, array[i], i);
				while (einfugeposition < i) {
					array [i] = array [i-1];
					i--;
				}
				array[einfugeposition] = m;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] array = new int[10];
		int zufallszahl;
		for (int ij= 0; ij < 100; ij++){
			for (int i = 0; i < array.length; i++){ //Hier wird ein Array mit Zufallszahlen gefüllt.
				zufallszahl = (int) (Math.random()*100)+1;
				array[i] = zufallszahl;
			}
		}
		insertionSort(array); //Das Sortierverfahren wird aufgerufen und der Array wird auf der Konsole ausgegeben.
		for (int j = 0; j < array.length; j++){
			print(array[j] + " ");
		}

	}

}
