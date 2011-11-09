package blatt3uebung01;

public class BinarySearch {

	public static int binarySearchIterativ(final int zeichen, final int[] alphabet) {
		int erstes = 0;
		int letztes = alphabet.length - 1;

		while (erstes <= letztes) {
			final int mitte = erstes + ((letztes - erstes) / 2); // vermeidet Überläufe des int
			if (alphabet[mitte] < zeichen) {
				erstes = mitte + 1; // rechts weitersuchen
			} else if (alphabet[mitte] > zeichen) {
				letztes = mitte - 1; // links weitersuchen
			} else {
				return mitte; // Zeichen gefunden
			}
		}

		return -1;
	}

	public static int binarySearchRekursiv(int indexAnfang, int indexEnde, int eingabeZeichen, int[] alphabet) {
		if (indexAnfang > indexEnde) {
			return -1;
		}

		int indexMitte = indexAnfang + ((indexEnde - indexAnfang) / 2);

		if (eingabeZeichen > alphabet[indexMitte]) {
			return binarySearchRekursiv(indexMitte + 1, indexEnde,
					eingabeZeichen, alphabet);
		}

		if (eingabeZeichen < alphabet[indexMitte]) {
			return binarySearchRekursiv(indexAnfang, indexMitte - 1,
					eingabeZeichen, alphabet);
		}

		return indexMitte;
	}

}
