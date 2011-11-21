package gruppe_2_13;

import static gdi.MakeItSimple.*;

public class Aufgabe2 {

	public static int linearSuche1(int wert, int[] array) {
		int zaehler, schlussVergleichAnzahl = 0;
		for (zaehler = 0; zaehler < array.length; zaehler++) {
			if (wert == array[zaehler]) {
			}
		}
		schlussVergleichAnzahl = zaehler;
		return schlussVergleichAnzahl;
	}

	public static int linearSuche2(int wert, int[] array) {
		int zaehler, schlussVergleichAnzahl;
		for (zaehler = 0; zaehler < array.length; zaehler++) {
			if (wert == array[zaehler]) {
				schlussVergleichAnzahl = zaehler + 1;
				return schlussVergleichAnzahl;
			}
		}
		schlussVergleichAnzahl = zaehler;
		return schlussVergleichAnzahl;
	}

	public static int iterativBinaereSuche(int wert, int[] array) {

		int anfangIndex = 0, endIndex = array.length - 1, index = 0, schlussVergleichAnzahl = 0;
		boolean weiter = true;// This variable indicates whether or not the
								// process continues

		while (weiter) {
			index = (anfangIndex + endIndex) / 2;
			if (anfangIndex == endIndex) {
				weiter = false;
			}
			if (array[index] == wert) {// The value was found and the number of
										// comparison is returned
				return ++schlussVergleichAnzahl;
			} else {// value has not been found; the number of comparisons
					// increases and ongoing research

				if (array[index] < wert) {// the desired value is in the right
											// half of the Array
					anfangIndex = index + 1;
				} else {// the desired value is in the left half of the Array
					endIndex = index - 1;
				}
				++schlussVergleichAnzahl;
			}
		}
		return schlussVergleichAnzahl;// In this case the required value is not
										// in the Array
	}

	public static int rekurcivBinaereSuche(int wert, int anfangIndex,
			int endIndex, int[] array) {
		int index = (anfangIndex + endIndex) / 2, schlussVergleichAnzahl = 0;

		if (endIndex < anfangIndex)// In this case the required value is not in
									// the Array
			return schlussVergleichAnzahl;

		else if (array[index] == wert)// the required value was found and the
										// number of comparison is returned
			return ++schlussVergleichAnzahl;

		else if (array[index] < wert) {// the desired value is in the right half
										// of the Array
			schlussVergleichAnzahl++;
			anfangIndex = index + 1;
			return schlussVergleichAnzahl
					+ rekurcivBinaereSuche(wert, anfangIndex, endIndex, array);
		}

		else {// the desired value is in the left half of the Array
			schlussVergleichAnzahl++;
			endIndex = index - 1;
			return schlussVergleichAnzahl
					+ rekurcivBinaereSuche(wert, anfangIndex, endIndex, array);
		}
	}

	public static void main(String[] args) {
		int[] ersteArray = new int[1024];
		int[] zweiteArray = new int[2048];
		int[] dritteArray = new int[4096];
		int ausgabe, anfang = 0, ende, eingabe;
		for (int i = 0; i < ersteArray.length; i++) {
			ersteArray[i] = i;
		}
		;
		for (int i = 0; i < zweiteArray.length; i++) {
			zweiteArray[i] = i;
		}
		;
		for (int i = 0; i < dritteArray.length; i++) {
			dritteArray[i] = i;
		}
		;
		print("Geben sie ein Zahl ein: ");
		eingabe = readInt();
		readLine();
		ausgabe = linearSuche1(eingabe, ersteArray);
		println("Anzahl der Vergeliche bei der Linear (letzte Treffer)= "
				+ ausgabe);
		ausgabe = linearSuche2(eingabe, ersteArray);
		println("Anzahl der Vergeliche bei der Linear (erste Treffer)= "
				+ ausgabe);
		ausgabe = iterativBinaereSuche(eingabe, ersteArray);
		println("Anzahl der Vergeliche bei der Binäreiterativsuche= " + ausgabe);
		ende = ersteArray.length - 1;
		ausgabe = rekurcivBinaereSuche(eingabe, anfang, ende, ersteArray);
		println("Anzahl der Vergeliche bei der Binärerekursivsuche= " + ausgabe);
	}

}
