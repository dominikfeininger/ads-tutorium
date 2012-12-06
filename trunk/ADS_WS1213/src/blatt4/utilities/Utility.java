package blatt4.utilities;

import static gdi.MakeItSimple.closeInputFile;

import static gdi.MakeItSimple.closeOutputFile;
import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.openOutputFile;
import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;
import static gdi.MakeItSimple.readLine;

public class Utility {

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

	// ////////////printRunsOnFile
	// //////////////////////////////////////////////

	static void printRunsOnFile(String filename) {

		// Hinweis: Werden sehr viele Elemente ausgegeben, kommt es zu einem
		// Pufferüberlauf:
		// Dabei wird nichts mahr auf der Konsole protokolliert.
		// Quick Fix: Nach 500 Elementen gibt es einen Zeilenumbruch.

		Object tape = openInputFile(filename);
		// it is assumed that there are no problems with file handling !!!

		boolean eot; // indicates if there are elements on tape
		int v, vn; // values read from tape1 v = last value, vn = actual value
		int epl = 0; // counter: elements on line

		eot = !isEndOfInputFile(tape);

		println(filename + ":");

		eot = !isEndOfInputFile(tape);

		if (!eot) { // empty tape
			closeInputFile(tape);
			return;
		}

		vn = readInt(tape); // read first value
		print("(");

		do {
			print(vn); // print value vn to destination tape

			epl++;

			eot = !isEndOfInputFile(tape);
			if (eot) { // more elements on tape
				v = vn;
				vn = readInt(tape);
				if (vn < v)
					print(") (");
				else
					print(" ");
			}

			// if (epl == 500) println(); // line feed after every 500th element

		} while (eot);

		println(")");

		closeInputFile(tape);
	}

	// ------------ printRunsOnFile
	// ----------------------------------------------
	
	public static void testSorting () {	// tests if the elements of file are in ascending order
		String filename;
		
		print ("Name of file to be tested: ");
		filename = readLine();
		
		int cnt=0;    // counts elements on file
		int el, ea;   // 2 continuing elements
		
		Object tape = openInputFile(filename);
		
		if (!isFilePresent(filename)) {
			println ("file " + filename + " does not exist");
			return;  // exit programm if file doesn't exist
		}
		
		
		el = readInt(tape);  // first element
		cnt++;
		
		
		while (!isEndOfInputFile(tape)) { // more than 1 element
			cnt++;
			ea = readInt(tape);   // actual element
			if (ea < el) { // wrong precedence  
				println("sorting error " + el + " " + ea + " at element " + cnt);
				closeInputFile(filename);
				return;
			}
			el = ea;
		}
		
		println(cnt + " elements correctly sorted");
		
	}


}
