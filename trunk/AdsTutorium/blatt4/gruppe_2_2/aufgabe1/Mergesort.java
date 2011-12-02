package gruppe_2_2.aufgabe1;

import static gdi.MakeItSimple.*;

public class Mergesort {

	public static void main(String[] args) {
		String fileName = "";
		String filePath = "";
		String band2Path = "C:\\Users\\Daniel\\Documents\\ADS\\ueb4a1\\Band2.txt";
		String band3Path = "C:\\Users\\Daniel\\Documents\\ADS\\ueb4a1\\Band3.txt";
		String protokollPath = "C:\\Users\\Daniel\\Documents\\ADS\\ueb4a1\\protokoll.txt";
		Object Band1;
		Object Band2;
		Object Band3;
		Object Protokoll;
		
		println("Bitte Dateinamen eingeben (MIT ENDUNG):");
		fileName = readLine();
		String path = "C:\\Users\\Daniel\\Documents\\ADS\\ueb4a1\\";
		filePath = path + fileName;
		
		if(isFilePresent(filePath) && isFileReadable(filePath) && isFileWritable(filePath)) {
			Band1 = openInputFile(filePath);
			closeInputFile(Band1);
			// check if files can be build if they don't exist. If they are available check if they can be edited 
			if((!isFilePresent(band2Path) || (isFilePresent(band2Path) && isFileWritable(band2Path))) 
					&& (!isFilePresent(band3Path) || (isFilePresent(band3Path) && isFileWritable(band3Path)))
					&& (!isFilePresent(protokollPath) || (isFilePresent(protokollPath) && isFileWritable(protokollPath)))) {
				// create Bands and protocol files
				Band2 = openOutputFile(band2Path);
				Band3 = openOutputFile(band3Path);
				closeOutputFile(Band2);
				closeOutputFile(Band3);
				Protokoll = openOutputFile(protokollPath);
				println("Dateien erstellt!");
				// check if file is already sorted
				if(checkBand(filePath)) {
					printruns(filePath, Protokoll, 0);
					println(Protokoll,"-----------------");
					println(Protokoll, "No merge needed!");
				}
				// while file isn't sorted
				while (!checkBand(filePath)) {
					// split files in two bands
					split(filePath, band2Path, band3Path, Protokoll);
					// add two bands together
					merge(filePath, band2Path, band3Path);
					println(Protokoll, "-----------------------------------------------------------");
					// log runs of startfile to protocol
					printruns(filePath, Protokoll,0);
					println(Protokoll, "-----------------------------------------------------------");
				}
				
//				closeInputFile(Band1);
//				closeOutputFile(Band2);
//				closeOutputFile(Band3);
				closeOutputFile(Protokoll);
				println("Logfile: " + protokollPath);
			}
			else {
				println("Keine Schreibrechte zum erstellen der Hilfsdateien!");
			}
		}
		else {
			println("Die eingegebene Datei existiert nicht oder ist schreibgeschützt!");
		}
	}
	/**
	 * Function splits off an inputFile full of Integers in two files by detecting runs. If a run is over, the current write file is changed. 
	 */
	static void split(String band1Path, String band2Path, String band3Path, Object Protokoll) {
		// Open Band1 for reading operations
		Object Band1 = openInputFile(band1Path);
		// Open Band2 &3 for writing operations
		Object Band2 = openOutputFile(band2Path);
		Object Band3 = openOutputFile(band3Path);
		int buffer = 0;
		// get first Int to have a comparative value
		int lastBuffer = readInt(Band1);

		boolean lastFileWrite = true; // true: Band2 ; false: Band3
		// start in Band2 with first read Int
		print(Band2, " " + lastBuffer);
		// as long as EOF isn't reached
		while (!isEndOfInputFile(Band1)) {
			buffer = readInt(Band1);
			if (lastFileWrite == true) {
				// write in Band2
				if (buffer > lastBuffer) {
					print(Band2, " " + buffer);
				} else if (buffer < lastBuffer) {
					print(Band3, " " + buffer);
					lastFileWrite = false;
				} else if (buffer == lastBuffer) {
					print(Band2, " " + buffer);
				}
			} else {
				// write in Band3
				if (buffer > lastBuffer) {
					print(Band3, " " + buffer);
				} else if (buffer < lastBuffer) {
					print(Band2, " " + buffer);
					lastFileWrite = true;
				} else if (buffer == lastBuffer) {
					print(Band3, " " + buffer);
				}
			}
			lastBuffer = buffer;
		}
		closeInputFile(Band1);
		closeOutputFile(Band3);
		closeOutputFile(Band2);
		printruns(band2Path, Protokoll, 1);
		printruns(band3Path, Protokoll, 1);
	}
	/**
	 * Function puts two files full of Integers back together to one file by analyzing the runs.
	 */
	static void merge(String band1Path, String band2Path, String band3Path) {
		// Open Band1 for writing operations
		Object Band1 = openOutputFile(band1Path);
		// Open Band2 & Band3 for reading operations
		Object Band2 = openInputFile(band2Path);
		Object Band3 = openInputFile(band3Path);
		int band2Buffer = readInt(Band2);
		int band3Buffer = readInt(Band3);
		int lastBand2Buffer = band2Buffer-2;		// to start first run
		int lastBand3Buffer = band3Buffer-2;		//     ""
		boolean buffer2Empty = false;
		boolean buffer3Empty = false;
		boolean band2Fin = false;
		boolean band3Fin = false;
		
		while(!isEndOfInputFile(Band2) && !isEndOfInputFile(Band3)) {
		
			if((lastBand2Buffer <= band2Buffer) && (lastBand3Buffer <= band3Buffer)) {	// check if run isn't over
				// both runs are on the run
				if(band2Buffer <= band3Buffer) {
					print(Band1, " " + band2Buffer);
					lastBand2Buffer = band2Buffer;
					band2Buffer = readInt(Band2);
					buffer2Empty = true;
				}
				else {
					print(Band1, " " + band3Buffer);
					lastBand3Buffer = band3Buffer;
					band3Buffer = readInt(Band3);
					buffer3Empty = true;
				}
			}
			else if((lastBand2Buffer >= band2Buffer) && (lastBand3Buffer <= band3Buffer)) {
				// run in band2 is over, run in band3 is running
				if(band2Buffer <= band3Buffer && !buffer2Empty) {
					print(Band1, " " + band2Buffer);
					// no element in buffer of band2
					buffer2Empty = true;
				}
				else {
					print(Band1, " " + band3Buffer);
					lastBand3Buffer = band3Buffer;
					band3Buffer = readInt(Band3);
					buffer3Empty = false;
				}
			}
			else if((lastBand2Buffer <= band2Buffer) && (lastBand3Buffer >= band3Buffer)) {
				// run in band is running, run in band2 is over
				if(band3Buffer <= band2Buffer && !buffer3Empty) {
					print(Band1, " " + band3Buffer);
					buffer3Empty = true;
				}
				else {
					print(Band1, " " + band2Buffer);
					lastBand2Buffer = band2Buffer;
					band2Buffer = readInt(Band2);
					buffer2Empty = false;
				}
			}
			else if((lastBand2Buffer >= band2Buffer) && (lastBand3Buffer >= band3Buffer)) {
				// both runs are over 
				
				lastBand2Buffer = band2Buffer -2;		// to start with new run
				lastBand3Buffer = band3Buffer -2;		// 			""
				buffer2Empty = false;
				buffer3Empty = false;
			}
		}
		// while all elements (inkl. last one) are processed
		while(!band2Fin && !band3Fin) {
			// if both filereads are @ EOF
			if(isEndOfInputFile(Band2) && isEndOfInputFile(Band3)) {
				// last element of each file are in buffers
				// look for smaller one and write it first in Band1. then write the higher one in Band1
				if(band2Buffer <= band3Buffer) {
					print(Band1, " " + band2Buffer);
					print(Band1, " " + band3Buffer);
					band2Fin = true;
					band3Fin = true;
				}
				else {
					print(Band1, " " + band3Buffer);
					print(Band1, " " + band2Buffer);
					band2Fin = true;
					band3Fin = true;
				}
				
			}
			// if only band2 is @EOF		(1 element @ buffer2 left - x elements in buffer3)
			else if(isEndOfInputFile(Band2)) {
				if(band2Buffer <= band3Buffer) {
					// if band2buffer <= band3buffer -> buffer2 empty -> put everything else from band3 to band1
					print(Band1, " " + band2Buffer);
					while(!isEndOfInputFile(Band3)) {
						print(Band1, " " + band3Buffer);
						lastBand3Buffer = band3Buffer;
						band3Buffer = readInt(Band3);
					}
					// EOF is reached, last element is in buffer -> write it to band1
					print(Band1, " " + band3Buffer);	
					band2Fin = true;
					band3Fin = true;
				}
				else {
					// add band3buffer to band1 and get new buffer 
					print(Band1, " " + band3Buffer);	
					lastBand3Buffer = band3Buffer;
					band3Buffer = readInt(Band3);
				}
			}
			// if only band3 is @EOF
			else if(isEndOfInputFile(Band3)) {
				if(band3Buffer <= band2Buffer) {
					// if band3buffer <= band2buffer -> buffer3 empty -> put everything else from band2 to band1
					print(Band1, " " + band3Buffer);
					while(!isEndOfInputFile(Band2)) {
						print(Band1, " " + band2Buffer);
						lastBand2Buffer = band2Buffer;
						band2Buffer = readInt(Band2);
					}
					// EOF is reached, last element is in buffer -> write it to band1
					print(Band1, " " + band2Buffer);
					band2Fin = true;
					band3Fin = true;
				}
				else {
					// add band2buffer to band1 and get new buffer
					print(Band1, " " + band2Buffer);
					lastBand2Buffer = band2Buffer;
					band2Buffer = readInt(Band2);
				}
			}
		}
		closeOutputFile(Band1);
		closeInputFile(Band2);
		closeInputFile(Band3);
	}
	/**
	 * Function checks if band is sorted.
	 * @return boolean -> expected true or false
	 */
	static boolean checkBand(String bandPath) {
		Object Band = openInputFile(bandPath);
		int buffer = 0;
		int lastBuffer = 0;
		if (!isEndOfInputFile(Band)) {
			buffer = readInt(Band);
			lastBuffer = buffer - 1;
		} else {
			// if file is empty -> false
			closeInputFile(Band);
			return false;
		}
		// while EOF isn't reached
		while (!isEndOfInputFile(Band)) {
			if (buffer >= lastBuffer) {
				lastBuffer = buffer;
				buffer = readInt(Band);
			} else {
				// if buffer smaller than lastBuffer -> no row -> return false
				closeInputFile(Band);
				return false;
			}
		}
		// check last file which is in buffer 
		if(buffer < lastBuffer){
			closeInputFile(Band);
			return false;
		}
		// if no return till now -> everything sorted -> return true
		closeInputFile(Band);
		return true;
	}
	/**
	 * function prints a protocol file, which includes a band with marked runs. If a run starts ( is printed. if run stops ) is printed
	 * 
	 * OUTCOMMENTED output was only for test
	 */
	static void printruns(String bandPath, Object Protokoll, int typ) {
		Object band = openInputFile(bandPath);
		boolean firstRun = true;
		boolean notNeed = false;
		int lastBuffer = 0;
		int buffer = 0;
		//String output = "";
		boolean runEnds = true;
		// while EOF isn reached
		while (!isEndOfInputFile(band)) {
			notNeed = false;
			if (runEnds && firstRun) {
				//output += "(";
				print(Protokoll, "(");
			}
			if (runEnds && !firstRun) {
				//output += "( " + buffer;
				print(Protokoll, "( " + buffer);
			}
			runEnds = false;
			firstRun = false;
			buffer = readInt(band);
			// check for run
			if (buffer >= lastBuffer) {
				//output += " " + buffer;
				print(Protokoll, " " + buffer);
				notNeed = true;
			} else {
				//output += " )";
				print(Protokoll, " )");
				runEnds = true;
			}
			lastBuffer = buffer;
		}
		if(runEnds) {
			//output += "(";
			print(Protokoll, "(");
		}
		if(!notNeed) {
			//output += " " + buffer +" )";
			print(Protokoll, " " + buffer + " )");
		}
		else {
			//output += " )";
			print(Protokoll, " )");
		}
		// if typ 0 add only one empty line to file
		// if typ 1 add three empty lines to file
		if(typ == 0) {
			println(Protokoll);
		}
		else if(typ == 1) {
			println(Protokoll);
			println(Protokoll);
			println(Protokoll);
		}
		closeInputFile(band);
	}
}
