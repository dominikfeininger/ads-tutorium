package gruppe_2_4;



import static gdi.MakeItSimple.*;

public class Mergesort {

	public static void main(String[] args) {

		mergeSort("/Users/feininger/Documents/workspace/AdsTutorium/blatt4/muster/txt/numbers02.txt");

	}

	static void mergeSort(String inputFile) {
		
		
		
		boolean sortiert = false;
		while (sortiert == false) {
			sortiert = mergeSplit(inputFile); // fehlt: test im split ob ein
												// store leer, dann kein join
												// mehr sondern store
			if (!sortiert) {
				join(inputFile);
				println("");
			}

		}
	}

	static void printBand(String inputString) {

		Object input = openInputFile(inputString);

		String ausgabe = inputString + ": (";
		int wert = 0;
		int wertAlt = 0;
		while (!isEndOfInputFile(input)) {
			wertAlt = wert;
			wert = readInt(input);
			if (wertAlt > wert) {
				ausgabe = ausgabe + " ) (";
			}
			ausgabe = ausgabe + " " + wert;
		}
		ausgabe = ausgabe + " )";
		System.out.println(ausgabe);

		closeInputFile(input);
	}

	static void writeStores(int value, int swapcounter, Object a, Object b) {
		// writes value to storeA on even swapcounter,
		// StoreB on uneven, or same Store on same counter

		int n = swapcounter;

		if ((n % 2) == 0)
			print(a, " " + value);
		else
			print(b, " " + value);

	}

	static boolean mergeSplit(String inputFile) {

		if (isFilePresent(inputFile)) {
			if (isFileWritable(inputFile)) {
				Object input = openInputFile(inputFile);
				Object storeA = openOutputFile("storeA.txt");
				Object storeB = openOutputFile("storeB.txt");

				int vorgänger = Integer.MIN_VALUE; // saves value for compare
				int nachfolger = Integer.MIN_VALUE; // reads next value
				int swapcounter = 0; // swaps stores (A(even)<>B(odd)) on count

				while (!isEndOfInputFile(input)) {

					vorgänger = nachfolger;
					nachfolger = readInt(input);

					if (nachfolger >= vorgänger)
						writeStores(nachfolger, swapcounter, storeA, storeB);
					else
						writeStores(nachfolger, ++swapcounter, storeA, storeB);
				}

				closeOutputFile(storeA);
				closeOutputFile(storeB);
				closeInputFile(input);
				printBand(inputFile);
				if (swapcounter == 0) {
					return true;
				}

			}
		}
		return false;

	}

	static boolean join(String outputFile) {
		Object storeA = openInputFile("storeA.txt");
		Object storeB = openInputFile("storeB.txt");
		Object output = openOutputFile(outputFile);

		int wertA = readInt(storeA);
		int wertB = readInt(storeB);

		boolean fertig = false;

		while (fertig == false) {
			// values with common index at both stores are compared
			// and written in increasing order

			if (wertA == wertB) {
				print(output, " " + wertA + " " + wertB);
				// if equal, write both
				if (!isEndOfInputFile(storeA) && !isEndOfInputFile(storeB)
						&& !fertig) {
					wertA = readInt(storeA);
					wertB = readInt(storeB);
				} else
					fertig = true;
			}

			if (wertA < wertB) {
				print(output, " " + wertA); // else write smaller
				if (!isEndOfInputFile(storeA) && !fertig) {
					wertA = readInt(storeA);
				} else {
					while (isEndOfInputFile(storeA) && !fertig) {
						// storeA empty, fill output up with rest of storeB
						print(output, " " + wertB);
						if (!isEndOfInputFile(storeB))
							wertB = readInt(storeB);
						else
							fertig = true;
					}
				}
			}

			if (wertA > wertB) {
				print(output, " " + wertB);
				if (!isEndOfInputFile(storeB) && !fertig) {
					wertB = readInt(storeB);
				} else {
					while (isEndOfInputFile(storeB) && !fertig) {
						// storeB empty, fill output up with rest of storeA
						print(output, " " + wertA);
						if (!isEndOfInputFile(storeA))
							wertA = readInt(storeA);
						else
							fertig = true;
					}
				}
			}

		}
		closeInputFile(storeA);
		closeInputFile(storeB);
		closeOutputFile(output);

		printBand("storeA.txt");
		printBand("storeB.txt");

		return false;
	}
}
