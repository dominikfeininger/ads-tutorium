package gruppe_2_13;

import static gdi.MakeItSimple.*;

public class MergeSort {

	/**
	 * This function posts(shows) contained by a File.
	 * 
	 * @param dateiName
	 *            The File to be posted.
	 */
	public static void printDatei(String dateiName) {
		Object datei = openInputFile(dateiName);
		while (!isEndOfInputFile(datei)) {
			print(" " + readInt(datei));
		}
		println();
		closeInputFile(datei);
	}

	/**
	 * This function posts(shows) contained by a file as well as the various under groups("runs").
	 * @param dateiName The file to be posted.
	 */
	public static void printRuns(String dateiName){
		Object datei=openInputFile(dateiName);
		//boolean open=false,close=false;
		int currentZahl=0,nextZahl;
		if(!isEndOfInputFile(datei)){
			currentZahl=readInt(datei);
			print(" ("+currentZahl);
			//open=true;
		}
		while(!isEndOfInputFile(datei)){
			nextZahl=readInt(datei);
			if(nextZahl>=currentZahl){
				print(" "+nextZahl);
			}
			else{
				print(") "+" ("+nextZahl);
			}
			currentZahl=nextZahl;
		}
		print(")"); println();
		closeInputFile(datei);
	}
	
	/**
	 * This function determine the number of integer contained in a file
	 * 
	 * @param dateiName
	 *            The file to be treated.
	 * @return
	 */
	public static int dateiLaengeErmitteln(String dateiName) {
		int anzahl = 0;
		if (isFilePresent(dateiName)) {
			Object datei = openInputFile(dateiName);
			while (!isEndOfInputFile(datei)) {
				readInt(datei);
				anzahl++;
			}
			closeInputFile(datei);
		} else {
			println("Die L�nge der Datei kann nicht ermitteln werden, da die Datei nicht gefunden wird");
		}
		return anzahl;
	}

	/**
	 * This function determine if the file is sorted or not.
	 * 
	 * @param dateiName
	 *            The file to be treated
	 * @return boolean: true when the file is sorted and false when not.
	 */
	public static boolean isSchonSortirt(String dateiName) {
		int zahl1, zahl2;
		Object datei = openInputFile(dateiName);
		zahl1 = readInt(datei);
		while (!isEndOfInputFile(datei)) {
			zahl2 = readInt(datei);
			if (zahl1 <= zahl2) {
				zahl1 = zahl2;
			} else {
				closeInputFile(datei);
				return false;
			}
		}
		closeInputFile(datei);
		return true;
	}

	/**
	 * This function cuts a file in 2 under files.
	 * 
	 * @param dateiName
	 *            File to be cut.
	 * @param teil1
	 *            The first one under file.
	 * @param teil2
	 *            The second under file.
	 */
	public static void split(String dateiName, String teil1, String teil2) {
		// With the valuable change of this variable, also change the under file
		// of destination.
		boolean inErsteTeilderDatei = true;
		Object datei = openInputFile(dateiName);
		Object ersteTeilderDatei = openOutputFile(teil1);
		Object zweiteTeilderDatei = openOutputFile(teil2);
		// The current and the next variable to be treated
		int zahl1 = readInt(datei), zahl2;

		print(ersteTeilderDatei, " " + zahl1);
		while (!isEndOfInputFile(datei)) {
			zahl2 = readInt(datei);
			if (zahl1 > zahl2) {
				inErsteTeilderDatei = !inErsteTeilderDatei;
				zahl1 = zahl2;
			}
			if (zahl1 <= zahl2 && inErsteTeilderDatei) {
				print(ersteTeilderDatei, " " + zahl2);
				zahl1 = zahl2;
			} else if (zahl1 <= zahl2 && !inErsteTeilderDatei) {
				print(zweiteTeilderDatei, " " + zahl2);
				zahl1 = zahl2;
			}
		}
		closeInputFile(datei);
		closeOutputFile(ersteTeilderDatei);
		closeOutputFile(zweiteTeilderDatei);
		println("nach dem Split:");
		print("teil1: ");
		printRuns(teil1);
		print("teil2: ");
		printRuns(teil2);
	}

	/**
	 * This Function merge two under Files.
	 * @param dateiName The destination File
	 * @param teil1 The first under File.
	 * @param teil2 The second under File.
	 */
	public static void merge(String dateiName, String teil1, String teil2) {
		// current und next variable to be treated for both under files.
		int currentZahl1, nextZahl1 = 0, currentZahl2, nextZahl2 = 0;
		
		// Indicating variable if the next variable must be read
		boolean zahl1erhöhen = true, zahl2erhöhen = true;
		// Indicating variable, if the last value of under file in already
		// incorporated into the merger.
		boolean istTheEndOfFile1 = false, istTheEndOfFile2 = false;
		Object datei = openOutputFile(dateiName);
		Object ersteTeilderDatei = openInputFile(teil1);
		Object zweiteTeilderDatei = openInputFile(teil2);
		currentZahl1 = readInt(ersteTeilderDatei);
		currentZahl2 = readInt(zweiteTeilderDatei);
		while (!isEndOfInputFile(ersteTeilderDatei)
				&& !isEndOfInputFile(zweiteTeilderDatei)) {
			if (zahl1erhöhen)
				nextZahl1 = readInt(ersteTeilderDatei);
			if (zahl2erhöhen)
				nextZahl2 = readInt(zweiteTeilderDatei);
			zahl1erhöhen = true;
			zahl2erhöhen = true;
			// ********************1*************************
			if (nextZahl1 < currentZahl1) {// currentZahl1 is the last one of under treated
									// group in the first under file
				boolean gearbeitet = false; // Indicating variable, if the
											// variale currentZahl1 already
											// incorporated into the merger.
				if (nextZahl2 < currentZahl2) {// both are the last value of them under
										// respective group
					if (currentZahl1 < currentZahl2) {
						print(datei, " " + currentZahl1);
						print(datei, " " + currentZahl2);
					} else {
						print(datei, " " + currentZahl2);
						print(datei, " " + currentZahl1);
					}
					currentZahl1 = nextZahl1;
					currentZahl2 = nextZahl2;
				} else {
					while (currentZahl2 <= nextZahl2) {// currentZahl2 are not the last
												// value of under treated group
												// in the second under file
						if (!gearbeitet) {
							if (currentZahl1 < currentZahl2) {
								print(datei, " " + currentZahl1);
								print(datei, " " + currentZahl2);
								gearbeitet = true;
							} else {
								print(datei, " " + currentZahl2);
							}
						} else
							print(datei, " " + currentZahl2);
						currentZahl2 = nextZahl2;
						if (!isEndOfInputFile(zweiteTeilderDatei))
							nextZahl2 = readInt(zweiteTeilderDatei);
						else {
							if (gearbeitet)
								print(datei, " " + nextZahl2);
							else {
								if (nextZahl2 < currentZahl1) {
									print(datei, " " + nextZahl2);
									print(datei, " " + currentZahl1);
								} else {
									print(datei, " " + currentZahl1);
									print(datei, " " + nextZahl2);
								}
								currentZahl1 = nextZahl1;
							}
							istTheEndOfFile2 = true;
							break;
						}
					}
					if (!istTheEndOfFile2) {
						if (!gearbeitet) {
							if (currentZahl1 < currentZahl2) {
								print(datei, " " + currentZahl1);
								print(datei, " " + currentZahl2);
								gearbeitet = true;
							} else {
								print(datei, " " + currentZahl2);
								print(datei, " " + currentZahl1);
							}
						} else
							print(datei, " " + currentZahl2);
					}
					currentZahl1 = nextZahl1;
					currentZahl2 = nextZahl2;
				}
			}
			// ********************2***************************
			else if (nextZahl2 < currentZahl2) {// currentZahl2 is the last one of under
											// treated group in the second under
											// file
				boolean gearbeitet = false;
				if (nextZahl1 < currentZahl1) {// Indicating variable, if the variale
										// currentZahl2 already incorporated into the
										// merger.
					if (currentZahl1 < currentZahl2) {// both are the last value of them
											// under respective group
						print(datei, " " + currentZahl1);
						print(datei, " " + currentZahl2);
					} else {
						print(datei, " " + currentZahl2);
						print(datei, " " + currentZahl1);
					}
					currentZahl1 = nextZahl1;
					currentZahl2 = nextZahl2;
				} else {
					while (currentZahl1 <= nextZahl1) {// currentZahl1 are not the last
												// value of under treated group
												// in the first under file
						if (!gearbeitet) {
							if (currentZahl2 < currentZahl1) {
								print(datei, " " + currentZahl2);
								print(datei, " " + currentZahl1);
								gearbeitet = true;
							} else {
								print(datei, " " + currentZahl1);
							}
						} else
							print(datei, " " + currentZahl1);
						currentZahl1 = nextZahl1;
						if (!isEndOfInputFile(ersteTeilderDatei))
							nextZahl1 = readInt(ersteTeilderDatei);
						else {
							if (gearbeitet)
								print(datei, " " + nextZahl1);
							else {
								if (nextZahl1 < currentZahl2) {
									print(datei, " " + nextZahl1);
									print(datei, " " + currentZahl2);
								} else {
									print(datei, " " + currentZahl2);
									print(datei, " " + nextZahl1);
								}
								currentZahl2 = nextZahl2;
							}
							istTheEndOfFile1 = true;
							break;
						}
					}
					if (!istTheEndOfFile1) {
						if (!gearbeitet) {
							if (currentZahl2 < currentZahl1) {
								print(datei, " " + currentZahl2);
								print(datei, " " + currentZahl1);
								gearbeitet = true;
							} else {
								print(datei, " " + currentZahl1);
								print(datei, " " + currentZahl2);
							}
						} else
							print(datei, " " + currentZahl1);
					}
					currentZahl1 = nextZahl1;
					currentZahl2 = nextZahl2;
				}
			}
			// *********************3************************
			else {
				if (currentZahl2 < currentZahl1) {
					print(datei, " " + currentZahl2);
					currentZahl2 = nextZahl2;
					zahl1erhöhen = false;
					if (isEndOfInputFile(ersteTeilderDatei)) {
						int zaehler = 0;
						// Reposition on the front last element of under file
						closeInputFile(ersteTeilderDatei);
						ersteTeilderDatei = openInputFile(teil1);
						while (zaehler < dateiLaengeErmitteln(teil1) - 1) {
							readInt(ersteTeilderDatei);
							zaehler++;
						}
						zahl1erhöhen = true;
					} else if (isEndOfInputFile(zweiteTeilderDatei)) {// current
																		// value
																		// of
																		// currentZahl1
																		// into
																		// merger
																		// incorpore
						if (currentZahl2 < currentZahl1) {
							print(datei, " " + currentZahl2);
							print(datei, " " + currentZahl1);
							istTheEndOfFile2 = true;
							currentZahl1 = nextZahl1;
						} else {
							print(datei, " " + currentZahl1);
							currentZahl1 = nextZahl1;
						}
					}
				} else {
					print(datei, " " + currentZahl1);
					currentZahl1 = nextZahl1;
					zahl2erhöhen = false;
					if (isEndOfInputFile(zweiteTeilderDatei)) {
						int zaehler = 0;
						// Reposition on the front last element of under file
						closeInputFile(zweiteTeilderDatei);
						zweiteTeilderDatei = openInputFile(teil2);
						while (zaehler < dateiLaengeErmitteln(teil2) - 1) {
							readInt(zweiteTeilderDatei);
							zaehler++;
						}
						zahl2erhöhen = true;
					} else if (isEndOfInputFile(ersteTeilderDatei)) {// current
																		// value
																		// of
																		// currentZahl2
																		// into
																		// merger
																		// incorpore
						if (currentZahl1 < currentZahl2) {
							print(datei, " " + currentZahl1);
							print(datei, " " + currentZahl2);
							istTheEndOfFile1 = true;
							currentZahl2 = nextZahl2;
						} else {
							print(datei, " " + currentZahl2);
							currentZahl2 = nextZahl2;
						}
					}
				}
			}
		}
		if (isEndOfInputFile(zweiteTeilderDatei)
				&& isEndOfInputFile(ersteTeilderDatei)) {
			if (!istTheEndOfFile1 && !istTheEndOfFile2) {
				if (currentZahl1 < currentZahl2) {
					print(datei, " " + currentZahl1);
					print(datei, " " + currentZahl2);
				} else {
					print(datei, " " + currentZahl2);
					print(datei, " " + currentZahl1);
				}
			} else {
				if (!istTheEndOfFile1)
					print(datei, " " + currentZahl1);
				if (!istTheEndOfFile2)
					print(datei, " " + currentZahl2);
			}
		} else {
			if (!isEndOfInputFile(zweiteTeilderDatei)) {// kopie von dem Rest
														// der
														// zweiteTeilderDatei,
														// wenn es noch elemente
														// drin stehen
				boolean gearbeitet = false, zahlerhöhen = false;
				while (!isEndOfInputFile(zweiteTeilderDatei)) {
					if (zahlerhöhen)
						currentZahl2 = readInt(zweiteTeilderDatei);
					if (!gearbeitet && !istTheEndOfFile1) {
						if (currentZahl1 < currentZahl2) {
							print(datei, " " + currentZahl1);
							print(datei, " " + currentZahl2);
							gearbeitet = true;
						} else
							print(datei, " " + currentZahl2);
					} else {
						print(datei, " " + currentZahl2);
					}
					zahlerhöhen = true;
				}
				if (!gearbeitet && !istTheEndOfFile1)
					print(datei, " " + currentZahl1);
			}
			if (!isEndOfInputFile(ersteTeilderDatei)) {
				boolean gearbeitet = false, zahlerhöhen = false;
				while (!isEndOfInputFile(ersteTeilderDatei)) {
					if (zahlerhöhen)
						currentZahl1 = readInt(ersteTeilderDatei);
					if (!gearbeitet && !istTheEndOfFile2) {
						if (currentZahl2 < currentZahl1) {
							print(datei, " " + currentZahl2);
							print(datei, " " + currentZahl1);
							gearbeitet = true;
						} else
							print(datei, " " + currentZahl1);
					} else {
						print(datei, " " + currentZahl1);
					}
					zahlerhöhen = true;
				}
				if (!gearbeitet && !istTheEndOfFile2)
					print(datei, " " + currentZahl2);
			}
		}

		closeInputFile(zweiteTeilderDatei);
		closeInputFile(ersteTeilderDatei);
		closeOutputFile(datei);
		println("Datei nach dem Merge:");
		printDatei(dateiName);
	}

	public static void main(String[] args) {
		// int zahl;
		boolean zugeordnet;
		String dateiName = "numbers04.txt", teil1 = "teil1.txt", teil2 = "teil2.txt";
		// Object datei = openOutputFile(dateiName);
		// for (int i = 0; i < 32; i++) {
		// zahl = (int) (Math.random() * 100) + 0;
		// print(datei, " " + zahl);
		// }
		// closeOutputFile(datei);
		//print("Bitte geben Sie den Name des Datei: ");
		//dateiName = readLine();
		if(isFilePresent(dateiName)){
			print("Urprunglich Datei: ");
			printDatei(dateiName);
			zugeordnet = isSchonSortirt(dateiName);
			while (!zugeordnet) {
				split(dateiName, teil1, teil2);
				merge(dateiName, teil1, teil2);
				zugeordnet = isSchonSortirt(dateiName);
			}
			print("Sortiert Datei: ");
			printDatei(dateiName);

		}
		else print(" Die Datei wurde nicht gefunde!!! Pröfen Sie bitte den Pfad und den Name der Datei");
		
	}

}
