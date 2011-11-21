package gruppe_2_13;

import static gdi.MakeItSimple.*;

public class Aufgabe1 {

	static final int NO_KEY = -1;

	public static int linearSuche1(int wert, int[] array) {

		int index = NO_KEY, zaehler;

		for (zaehler = 0; zaehler < array.length; zaehler++) {
			if (wert == array[zaehler])// save in index the Position where the
										// Value is egals to the required value
				index = zaehler;
		}
		return index;
	}

	public static int linearSuche2(int wert, int[] array) {

		int index = NO_KEY, zaehler = 0;

		for (zaehler = 0; zaehler < array.length; zaehler++) {
			if (wert == array[zaehler]) {// zaehler is at the position of the
											// first element equals to the one
											// we are looking for
				return zaehler;
			}
		}
		return index;// NO_KEY then we didn't find the element
	}

	public static int iterativBinaereSuche(int wert, int[] array) {

		int anfangIndex = 0, endIndex = array.length - 1, index = 0, zaehler = 0;
		boolean weiter = true;// This variable indicates whether or not the
								// process continues

		while (weiter) {
			index = (anfangIndex + endIndex) / 2;

			if (anfangIndex == endIndex || ++zaehler == array.length) {
				weiter = false;
			}
			if (array[index] == wert) {// The value was found and the location
										// is returned
				return index;
			} else {// value has not been found; the search continues

				if (array[index] < wert) // the desired value is in the right
											// half of the Array
					anfangIndex = index + 1;

				else
					// the desired value is in the left half of the Array
					endIndex = index - 1;
			}
		}
		return NO_KEY;// In this case the required value is not in the Array
	}

	public static int rekurcivBinaereSuche(int wert, int anfangIndex,
			int endIndex, int[] array) {

		int index = (anfangIndex + endIndex) / 2;

		if (endIndex < anfangIndex)// In this case the required value is not in
									// the Array
			return NO_KEY;

		else if (array[index] == wert)// the required value was found and the
										// number of comparison is returned
			return index;

		else if (array[index] < wert) {// the desired value is in the right half
										// of the Array
			anfangIndex = index + 1;

			return rekurcivBinaereSuche(wert, anfangIndex, endIndex, array);
		} else {// the desired value is in the left half of the Array
			endIndex = index - 1;

			return rekurcivBinaereSuche(wert, anfangIndex, endIndex, array);
		}

	}

	public static void main(String[] args) {

		int [] array = {6,55,12,18,42,55,55,44,55,67,94};   // fix array 
		//int[] array = new int[100];
		int ausgabe, eingabe, anfangIndex = 0, endIndex = array.length - 1;

		//for (int i = 0; i < array.length; i++) {
			//array[i] = i;
		//};


		print("Geben sie die gesuchte Werte ein: ");
		eingabe = readInt();
		readLine();
		ausgabe = linearSuche1(eingabe, array);
		// TODO:ausgabe Variable üerflüssig
		println("Linearsuche(letzte Treffer): index= "
				+ linearSuche1(eingabe, array));
		ausgabe = linearSuche2(eingabe, array);
		println("Linearsuche(erste Treffer) : index= " + ausgabe);
		ausgabe = iterativBinaereSuche(eingabe, array);
		println("binäre Iterativsuche       : index= " + ausgabe);
		ausgabe = rekurcivBinaereSuche(eingabe, anfangIndex, endIndex, array);
		println("binäre rekursivsuche       : index= " + ausgabe);
	}

}
