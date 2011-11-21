package gruppe_2_13;

import static gdi.MakeItSimple.*;

public class Aufgabe4 {

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			print(" " + array[i]);
		}
		println();
	}

	public static void stelleTauchen(int[] array, int index1, int index2) {
		int halter;
		halter = array[index1];
		array[index1] = array[index2];
		array[index2] = halter;
	}
	//TODO: gefordert: BubbleShakerSort!!! was macht mod 2???
	public static int[] shakeSort(int[] array) {
		int zaehler1, zaehler2, anzahlDerVertauchungen = 0, anzahlDerVergleiche = 0;
		for (zaehler1 = 0; zaehler1 < array.length; zaehler1++) {
			if (zaehler1 % 2 == 0) {// if zaehler is even then go left to right
				for (zaehler2 = zaehler1; zaehler2 < array.length - 2; zaehler2++) {
					anzahlDerVergleiche++;
					if (array[zaehler2] > array[zaehler2 + 1]) {
						stelleTauchen(array, zaehler2, zaehler2 + 1);
						anzahlDerVertauchungen++;
					}
				}
			} else {// if zaehler is odd then go right to left
				for (zaehler2 = array.length - 1; zaehler2 > 0; zaehler2--) {
					anzahlDerVergleiche++;
					if (array[zaehler2] < array[zaehler2 - 1]) {
						stelleTauchen(array, zaehler2, zaehler2 - 1);
						anzahlDerVertauchungen++;
					}
				}
			}
			zaehler2 = 0;
			if (zaehler1 < 9)
				print("nach der Durchlauf 0" + (zaehler1 + 1) + ":  ");
			else
				print("nach der Durchlauf " + (zaehler1 + 1) + ":  ");
			printArray(array);
		}
		println();
		println("Anzal der Vergleiche= " + anzahlDerVergleiche);
		println("Anzahl der Vertauchungen= " + anzahlDerVertauchungen);
		return array;
	}

	public static void main(String[] args) {
		/*
		int[] meinArray = new int[11];// {524,0,14,413,682};
		for (int i = 0; i < meinArray.length; i++) {
			meinArray[i] = (int) Math.floor(Math.random() * 1000);
		}
		*/
		//TODO:Musterlösung
		int [] F = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
		print("Ursprungarray:          ");
		printArray(F);
		println();
		F = shakeSort(F);
	}

}
