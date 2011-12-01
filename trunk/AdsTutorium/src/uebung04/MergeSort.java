package uebung04;

import static gdi.MakeItSimple.*;

public class MergeSort {
	//class variable to enter the file name, and work with the
	//file name in every method
	private static String input;
		// class variabel for method split
		private static int i = 0;
	public static void main(String[] args) {
		println("Please enter a file name (name.txt):");
		// read file name
		input = readLine();
		Object file = openOutputFile("c:\\" + input);
		// test if file present
		if (isFilePresent("c:\\" + input)) {
			print(file, "44 55 12 42 94 18 6 67");
		}
		closeOutputFile(file);
		mergeSort();
	}

	public static void mergeSort() {
		println("merge sort");
		println("initialarray: ");
		printtape("c:\\" + input);
		println();
		int[] unsorted = loadFromFile();
		
		//the loop runs till the tape in the entered 
		//file(name) is sorted
		while (!isSorted(unsorted)) {
			split(unsorted);
			printtape("c:\\Band1.txt");
			printtape("c:\\Band2.txt");
			println();

			merge();
			printtape("c:\\" + input);
			println();

			unsorted = loadFromFile();
		}
	}

	// method to switch 2 elements
	static void swap(int[] array, int idx1, int idx2) {
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}

	// method to print an array
	public static void printArray(int[] a) {
		// variable for print loop
		int i2 = 0;
		while (i2 < a.length) {
			// print array
			print(a[i2] + ", ");
			i2++;
		}
	}

	// method to load from file
	public static int[] loadFromFile() {
		int i = 0, c;
		int[] f;
		Object file = openInputFile("c:\\" + input);
		if (isFilePresent("c:\\" + input)) {
			// count elements in file
			while (!isEndOfInputFile(file)) {
				c = readInt(file);
				i++;
			}
			// new array for integer values from file
			f = new int[i];
			closeInputFile(file);
			file = openInputFile("c:\\" + input);
			i = 0;

			// write elements in array
			while (!isEndOfInputFile(file)) {
				c = readInt(file);
				f[i] = c;
				i++;
			}

		} else {
			f = new int[1];
			println("## file doesn't exist!");
		}
		closeInputFile(file);
		return f;
	}

	// method which get content of the file
	private static void printtape(String path) {
		Object file = openInputFile(path);
		println(readLine(file));
		closeInputFile(file);

	}

	// method to test if the tape is completely sorted
	private static boolean isSorted(int[] unsorted) {
		for (int i = 0; i < unsorted.length - 1; i++) {
			//test if the value is smaller than the next.
			if (unsorted[i] > unsorted[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// method to merge the values of the tape
	private static void merge() {
		Object file1 = openInputFile("c:\\Band1.txt");
		Object file2 = openInputFile("c:\\Band2.txt");
		Object file = openOutputFile("c:\\" + input);

		int tapeValue1 = 0; // current value of tape 1
		int tapeValue2 = 0; // current value of tape 2

		// till end of file 1 and end of file 2 = true make:
		while (!isEndOfInputFile(file1) || !isEndOfInputFile(file2)) {
			tapeValue1 = readInt(file1);
			tapeValue2 = readInt(file2);
			//test to print the values in the correct sequence
			if (tapeValue1 < tapeValue2) {
				print(file, " " + tapeValue1 + " " + tapeValue2);
			} else {
				print(file, " " + tapeValue2 + " " + tapeValue1);
			}
		}
		closeInputFile(file2);
		closeInputFile(file1);
		closeOutputFile(file);
	}

	public static void split(int[] unsplit) {
		// open files
		Object file1 = openOutputFile("c:\\Band1.txt");
		Object file2 = openOutputFile("c:\\Band2.txt");

		boolean bool = true;

		for (int j = 0; j < unsplit.length; j++) {
			// write in actual tape
			if (bool == true) {
				print(file1, " " + unsplit[j]);
				bool = false;
			} else {
				print(file2, " " + unsplit[j]);
				bool = true;
			}/*first run
			 * tape1 0 1	 4 5	 8 9
			 * tape2 2 3	 6 7 	10 11
			 * second run
			 * tape1 0 1 2 3	 8 9 10 11
			 * tape2 4 5 6 7	 12 13 14 15
			 * 
			 * the first run works
			 * in the second run the virtual machine split the two
			 * first numerarys again, so the for loop never ends.
			 * 
			 * he should set the variable j to 2 pow 2, after every split 
			 * [f.e. with an class variable]
			 *  
			 * if the split is right, the method merge works correctly 
			 * and the program is finished.
			 */
		}
		closeOutputFile(file1);
		closeOutputFile(file2);
	}
}