package blatt4.kopierteDateien;

import static gdi.MakeItSimple.*;

public class Aufgabe1 {

	// the main methods executes the mergeSort with given path
	public static void main(String[] args) {

		String pfadDerFolge = readLine();
		String pfadDerDatei1 = "E:\\Programme\\eclipse\\workspace\\ADS\\src\\uebung04\\1.txt";
		String pfadDerDatei2 = "E:\\Programme\\eclipse\\workspace\\ADS\\src\\uebung04\\2.txt";

		// execute mergeSort
		mergeSort(pfadDerFolge, pfadDerDatei1, pfadDerDatei2);
	}

	/**
	 * This method sorts an undefined amount of numbers inside a file
	 * chronologically with the help of two additional files.
	 * 
	 * @param pfadDerFolge
	 * @param pfadDerDatei1
	 * @param pfadDerDatei2
	 */
	public static void mergeSort(String pfadDerFolge, String pfadDerDatei1,
			String pfadDerDatei2) {
		boolean firstSplit = true;
		boolean fertig = false;

		// as long as the file isn't completely sorted
		while (!fertig) {
			// test for presence of file
			if (isFilePresent(pfadDerFolge)) {

				// test for read and write ability for split method
				if (isFileReadable(pfadDerFolge)
						&& isFileWritable(pfadDerDatei1)
						&& isFileWritable(pfadDerDatei2)) {
					// open the files for read and write
					Object folge = openInputFile(pfadDerFolge);
					Object datei1 = openOutputFile(pfadDerDatei1);
					Object datei2 = openOutputFile(pfadDerDatei2);

					// execute split with opened files
					split(folge, datei1, datei2, firstSplit);

					// set firstSplit to false after the first execution of
					// split
					firstSplit = false;

					// print the subsequences after splitting
					print("F1:");
					printRuns(pfadDerDatei1);
					println();
					print("F2:");
					printRuns(pfadDerDatei2);
					println();
					// close all files after splitting
					closeInputFile(folge);
					closeOutputFile(datei1);
					closeOutputFile(datei2);
				}
				// if the files are not readable or writable
				else {
					print("Datei kann nicht beschrieben/geöffnet werden.");
					return;
				}
				// test for read and write ability for merge method
				if (isFileWritable(pfadDerFolge)
						&& isFileReadable(pfadDerDatei1)
						&& isFileReadable(pfadDerDatei2)) {

					// open the files for read and write
					Object folge = openOutputFile(pfadDerFolge);
					Object datei1 = openInputFile(pfadDerDatei1);
					Object datei2 = openInputFile(pfadDerDatei2);

					// if subsequence1 is empty, copy subsequence2 into the main
					// sequence
					if (isEndOfInputFile(datei1)) {
						kopiereRestdatei(datei2, folge);
						print("Folge:");
						printRuns(pfadDerFolge);
						println();
						println("Fertig sortiert.");
						closeInputFile(datei1);
						closeInputFile(datei2);
						closeOutputFile(folge);
						return;
					}

					// if subsequence2 is empty, copy subsequence1 into the main
					// sequence
					if (isEndOfInputFile(datei2)) {
						kopiereRestdatei(datei1, folge);
						print("Folge:");
						printRuns(pfadDerFolge);
						println();
						println("Fertig sortiert.");
						closeInputFile(datei1);
						closeInputFile(datei2);
						closeOutputFile(folge);
						return;
					}
					// execute merge with opened files
					merge(datei1, datei2, folge);
					// print main sequence after merge
					print("Folge:");
					printRuns(pfadDerFolge);
					println();

					// close all files after merge
					closeInputFile(datei1);
					closeInputFile(datei2);
					closeOutputFile(folge);
				}
				// if the files are not readable or writable
				else {
					print("Datei kann nicht beschrieben/geöffnet werden.");
					return;
				}

			}
			// if file could not be found
			else {
				print("Datei nicht gefunden.");
				return;
			}

			// test for sorted main sequence after every merge
			Object folge = openInputFile(pfadDerFolge);
			if (istSortiert(folge) == true) {
				// if the file is completely sorted
				fertig = true;
				println("Fertig sortiert.");
			}
			closeInputFile(folge);
		}
	}

	/**
	 * This method splits the main sequence into two subsequences.
	 * 
	 * @param folge
	 * @param datei1
	 * @param datei2
	 * @param firstSplit
	 *            (true when you start split for the first time)
	 */

	public static void split(Object folge, Object datei1, Object datei2,
			boolean firstSplit) {
		int zahl1;
		int zahl2;
		boolean datei2Aktiv = false;

		// first integer is the amount of numbers to sort
		if (firstSplit)
			readInt(folge);

		// start if the file has more than 1 number
		if (!isEndOfInputFile(folge)) {
			// read in first number and write it into the subsequence1
			zahl1 = readInt(folge);
			print(datei1, " " + zahl1);

			// run until the end of file is reached
			while (!isEndOfInputFile(folge)) {
				// read in the next number
				zahl2 = readInt(folge);

				// compare the first and second number
				if (zahl1 <= zahl2) {
					// if you are still in subsequence 1, write the next number
					// into
					// subsequence 1
					if (datei2Aktiv == false)
						print(datei1, " " + zahl2);
					// if you are in subsequence 2, write the next number into
					// subsequence 2
					else
						print(datei2, " " + zahl2);
				}
				// if the second number is higher
				else {
					// if you are still in subsequence 1, write the next number
					// in subsequence 2 and set the boolean status to
					// subsequence 2
					if (datei2Aktiv == false) {
						print(datei2, " " + zahl2);
						datei2Aktiv = true;
					}
					// if you are in subsequence 2, write the next number into
					// subsequence 1 and reset the boolean status to subsequence
					// 1
					else {
						print(datei1, " " + zahl2);
						datei2Aktiv = false;
					}

				}
				// give the first number the value of the second number after
				// they have been compared. So you can read in the next number
				zahl1 = zahl2;
			}
		}
	}

	/**
	 * This method compounds the two subsequences to one.
	 * 
	 * @param datei1
	 * @param datei2
	 * @param folge
	 */

	public static void merge(Object datei1, Object datei2, Object folge) {
		// read in the first two numbers
		int zahlDatei1 = readInt(datei1);
		int zahlDatei2 = readInt(datei2);
		int alteZahlDatei1;
		int alteZahlDatei2;

		while (true) {

			if (zahlDatei1 <= zahlDatei2) {
				// write the first number into the main sequence
				print(folge, " " + zahlDatei1);

				if (!isEndOfInputFile(datei1)) {
					// save the old value and read in the next number of
					// subsequence 1
					alteZahlDatei1 = zahlDatei1;
					zahlDatei1 = readInt(datei1);

					// if the next number is smaller, write all sorted numbers
					// of the other (2nd) subsequence into the main sequence
					// until
					// the next read in number is smaller
					if (alteZahlDatei1 > zahlDatei1) {
						alteZahlDatei2 = zahlDatei2;

						while (alteZahlDatei2 <= zahlDatei2
								&& !isEndOfInputFile(datei2)) {

							print(folge, " " + zahlDatei2);
							alteZahlDatei2 = zahlDatei2;
							zahlDatei2 = readInt(datei2);
						}
					}

				}
				// if end of file is reached, copy all numbers of the other file
				// to the main sequence
				else {
					print(folge, " " + zahlDatei2);
					kopiereRestdatei(datei2, folge);
					return;
				}
			}
			// if the first number of subsequence 2 is smaller
			else {
				print(folge, " " + zahlDatei2);

				if (!isEndOfInputFile(datei2)) {
					// save the old value and read in the next number of
					// subsequence 2
					alteZahlDatei2 = zahlDatei2;
					zahlDatei2 = readInt(datei2);

					// if the next number is smaller, write all sorted numbers
					// of the other (1st) subsequence into the main sequence
					// until
					// the next read in number is smaller
					if (alteZahlDatei2 > zahlDatei2) {
						alteZahlDatei1 = zahlDatei1;

						while (alteZahlDatei1 <= zahlDatei1
								&& !isEndOfInputFile(datei1)) {
							print(folge, " " + zahlDatei1);
							alteZahlDatei1 = zahlDatei1;
							zahlDatei1 = readInt(datei1);
						}
					}
				}
				// if end of file is reached, copy all numbers of the other file
				// to the main sequence
				else {
					print(folge, " " + zahlDatei1);
					kopiereRestdatei(datei1, folge);
					return;
				}

			}

		}

	}

	/**
	 * This method copies all numbers from on file to another file.
	 * 
	 * @param datei1
	 * @param datei2
	 */
	public static void kopiereRestdatei(Object datei1, Object datei2) {
		int zahl;
		// write all files from file1 into file2
		while (!isEndOfInputFile(datei1)) {
			zahl = readInt(datei1);
			print(datei2, " " + zahl);
		}
	}

	/**
	 * This method tests the main sequence for the right order.
	 * 
	 * @param folge
	 * @return true/false
	 */
	public static boolean istSortiert(Object folge) {
		int zahl1 = readInt(folge);
		int zahl2;

		while (!isEndOfInputFile(folge)) {
			zahl2 = readInt(folge);
			// if the sequence isn't sorted, return false
			if (zahl1 > zahl2)
				return false;
			// give number1 the value of number2 so you can read in the next
			// number
			zahl1 = zahl2;

		}
		// return true if the whole sequence is sorted
		return true;
	}

	/**
	 * This method prints all numbers of the file from the given path.
	 * 
	 * @param dateiPfad
	 */
	public static void printRuns(String dateiPfad) {
		// open file
		Object datei = openInputFile(dateiPfad);

		// in case of an empty file
		if (isEndOfInputFile(datei)) {
			closeInputFile(datei);
			println(" Datei ist leer.");
			return;
		}
		// read in first number
		int zahl1 = readInt(datei);

		// in case there is only one number in the file
		if (isEndOfInputFile(datei)) {
			println(" (" + zahl1 + ")");
			closeInputFile(datei);
			return;
		}

		int zahl2;

		while (!isEndOfInputFile(datei)) {
			// read in next number
			zahl2 = readInt(datei);
			// print opening bracket with first number
			print(" (" + zahl1);

			// new run begins
			if (zahl1 <= zahl2) {

				// print all numbers until number2 is smaller than number1 or
				// the end of file is reached
				while (zahl1 <= zahl2 && !isEndOfInputFile(datei)) {
					print(" " + zahl2);
					zahl1 = zahl2;
					zahl2 = readInt(datei);
				}
				// if end of file is reached, print the last number
				// with a closing bracket.
				if (isEndOfInputFile(datei)) {
					if (zahl1 > zahl2)
						print(")(" + zahl2 + ")");
					else
						print(" " + zahl2 + ")");
				}
				// if the run is over close the bracket
				else
					print(")");
			}
			// if second number is smaller
			else {
				// if the last run has only one number
				if (isEndOfInputFile(datei))
					print(")(" + zahl2 + ")");
				else
					print(")");
			}
			// give number1 the value of number2 to read in the next number
			zahl1 = zahl2;
		}
		// close file
		closeInputFile(datei);
	}
}

