package blatt4.loesung.straightMergeSort;

import static gdi.MakeItSimple.*;

class StraightMergeSort {

	static void copyFile(String filename, String filename1) {

		// copies filename --> filename1

		// if cnt > 0 print only cnt elements (only for the reason of tests

		Object tape = openInputFile(filename); // no problems with file handling
												// !!!
		Object tape1 = openOutputFile(filename1); // no problems with file
													// handling !!!

		while (!isEndOfInputFile(tape))
			print(tape1, " " + readInt(tape));

		closeInputFile(tape);
		closeOutputFile(tape1);

	}

	static void printFile(String filename) {

		Object tape = openInputFile(filename); // no problems with file handling
												// !!!

		println();
		println(filename + ": ");

		while (!isEndOfInputFile(tape))
			print(readInt(tape) + " ");

		closeInputFile(tape);
	}

	static void printRunsOnFile(String filename, int rl) {

		Object tape = openInputFile(filename);
		// it is assumed that there are no problems with file handling !!!

		int arl = 1; // actual run length
		boolean eot; // indicates if there are elements on tape

		eot = !isEndOfInputFile(tape);

		println(filename + ":");

		if (!eot) { // empty tape
			println("()");
			closeInputFile(tape);
			return;
		}

		while (eot) {

			if (arl == 1)
				print("(");

			if (arl == rl) {
				print(readInt(tape) + ")");
				eot = !isEndOfInputFile(tape);
				arl = 1;
			} else {
				print(readInt(tape));
				arl++;
				eot = !isEndOfInputFile(tape);
				if (eot)
					print(" ");
				else
					print(")");
			}
		}

		println();

		closeInputFile(tape);
	}

	static void split(String filename1, String filename2, String filename3,
			int rl) {

		// splits tape1 into 2 auxiliary tapes with runs of length rl

		int arl; // actual run length
		boolean eot; // indicates that there are elements on tape1 further more

		Object tape1 = openInputFile(filename1);
		Object tape2 = openOutputFile(filename2); // it is assumed that there
													// are no
		Object tape3 = openOutputFile(filename3); // problems with file handling
													// !!!

		eot = !isEndOfInputFile(tape1);

		while (eot) {

			arl = 1;

			while (arl++ <= rl && eot) {
				print(tape2, " " + readInt(tape1));
				eot = !isEndOfInputFile(tape1);
			}

			arl = 1;

			while (arl++ <= rl && eot) {
				print(tape3, "  " + readInt(tape1));
				eot = !isEndOfInputFile(tape1);
			}

		}

		closeInputFile(tape1);
		closeOutputFile(tape2);
		closeOutputFile(tape3);
	}

	static void copyTailOfRun(Object tape2, Object tape1, int ic, int rl, int i) {

		// function is called only if there is at least 1 element on tape2
		// copies the tail of a run on tape2 to tape1

		print(tape1, " " + i);
		ic++;

		while (!isEndOfInputFile(tape2) && ic <= rl) {
			print(tape1, " " + readInt(tape2));
			ic++;
		}
	}

	static void copyTailofTape(Object tape2, Object tape1) {

		// copies the tail of tape2 to tape1

		while (!isEndOfInputFile(tape2))
			print(tape1, " " + readInt(tape2));
	}

	static boolean runsNotFinished (boolean nextExist, int rl, int i2c, int i3c) {
		
		return  i2c <= rl && i3c <= rl && nextExist;

	}

	static boolean thereAreElementsOnBothTapes(Object tape2, Object tape3) {

		return !isEndOfInputFile(tape2) && !isEndOfInputFile(tape3);

	}
	
	static boolean hasNext (Object tape) {
		return !isEndOfInputFile(tape);
	}

	static int readNextElementFromTape(Object tape, int ic, int rl) {

		if (!isEndOfInputFile(tape) && ic <= rl) // read only, if not eof &&
													// run length not reached
			return readInt(tape);
		else
			return -1; // else return a dummy value

	}

	static int merge(String filename1, String filename2, String filename3, int rl) {

		// return the number of runs on tape filename1

		// merges file2 and file3 by runlength rl into file1
		// number of elements on file2 and file3 >= 1

		int i2 = 0, i3 = 0, i2c = 0, i3c = 0;
		// i2/i3 = actual value read from tape2/3
		// i2c/i3c = counts the values read from actual run from tape2/3

		int rc = 0; // counts the runs

		boolean eot2, eot3; // indicate that there are elements on tape2/3
		
		Object tape1 = openOutputFile(filename1);
		Object tape2 = openInputFile(filename2); // it is assumed that there are no
		Object tape3 = openInputFile(filename3); // problems with file handling,
													// i.e. files exist !!!
		
		boolean nextExist = true;   //????!!!


		while (thereAreElementsOnBothTapes(tape2, tape3)) { // both tapes
															// contain elements

			rc++; // ???

			i2c = i3c = 1; // reset counters

			i2 = readInt(tape2); // element from tape2
			i3 = readInt(tape3); // element from tape3

			while (runsNotFinished(nextExist, rl, i2c, i3c)) { // there are elements in runs on both tapes
				
				if (i2 < i3) {
					print(tape1, " " + i2);
					i2c++;
					if (nextExist = hasNext(tape2))
						i2 = readNextElementFromTape(tape2, i2c, rl);
				} else {
					print(tape1, " " + i3);
					i3c++;
					if (nextExist = hasNext(tape3))
						i3 = readNextElementFromTape(tape3, i3c, rl);

				}
			}

			// situation:
			// the actual run on one tape is finished at the other
			// tape the there is a run remainder
			// now the remainder of the run not finished has to be appended to
			// tape1
			
			println("i2c= "+ i2c + ", i3c= " + i3c + ", i2= "+ i2 + ", i3= "+ i3);

			if (i2c > rl) // run on tape2 is finished -> copy tail of run of tape3
				copyTailOfRun(tape3, tape1, i3c, rl, i3); // tape3 -> tape1
			else
				copyTailOfRun(tape2, tape1, i2c, rl, i2); // tape3 -> tape1

		}

		copyTailofTape(tape2, tape1); // copy tail of tape2 -> tape1

		// close all files

		closeOutputFile(tape1);
		closeInputFile(tape2);
		closeInputFile(tape3);

		return rc;

	}

	public static void main(String[] args) {

		int runlength = 1; // length of actual run
		int rc = 2; // no. of runs on input tape (finish if == 1), 2 is an arbitrary value > 1
		int cnt = 1; // counter for splits & merges
		String filename, filename1;
		String filename2, filename3;
		

		print("file to be sorted = "); 
		filename = readLine();

		if (isFilePresent(filename)) {
			filename1 = filename + "___1";
			filename2 = filename + "___2";
			filename3 = filename + "___3";
		} else {
			println("file " + filename + "does not exist");
			return; // exit program if file doesn't exist
		}

		copyFile (filename, filename1); // copies filename --> filename1, source
										// file is not changed, so we keep the original file

		printFile(filename1);   // print unsorted file
		println();

		while (rc > 1) {  // as long as there are more than 1 runs on file1 --> sort
			
			split(filename1, filename2, filename3, runlength);
			
			printRunsOnFile(filename2, runlength);
			printRunsOnFile(filename3, runlength);
			
			rc = merge(filename1, filename2, filename3, runlength);

			
//			println(); println();
//			println("Durchlauf Nr. " + cnt++);
//			println("=================");
//
//			printFile(filename1);
//			runlength *= 2;
//			printRunsOnFile(filename1, runlength);

		}
		
		println();
		println ("Sorted File:");
		printFile(filename1);
	}
}
