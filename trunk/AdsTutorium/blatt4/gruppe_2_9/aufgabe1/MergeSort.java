package gruppe_2_9.aufgabe1;

import static gdi.MakeItSimple.*;

public class MergeSort {

	/**
	 * counts the amount of runs of the mergesort
	 */
	static int amountOfRuns = 0;

	public static void main(String[] args) {
		println("Type 1 to start the sort");

		// reads a number from the console for choosing one of the five files
		int startSort = readInt();
		readLine();
		sort(startSort);
	}

	// initiate the sort with one input-file and two output-files
	public static void sort(int startSort) {
		
		Object file1, file2, file3;
		String tmp1 = "tmp01.txt";
		String tmp2 = "tmp02.txt";
		String file = "/Users/feininger/Documents/workspace/AdsTutorium/blatt4/muster/txt/numbers04.txt";
		int runs = 0;

		if (startSort == 1) {
			while (runs != 1) {
				Object input = openInputFile(file);
				runs = printRuns(input);
				closeInputFile(input);

				if (runs != 1) {
					file1 = openInputFile(file);
					file2 = openOutputFile(tmp1);
					file3 = openOutputFile(tmp2);

					split(file1, file2, file3);

					closeInputFile(file1);
					closeOutputFile(file2);
					closeOutputFile(file3);

					file1 = openOutputFile(file);
					file2 = openInputFile(tmp1);
					file3 = openInputFile(tmp2);

					merge(file1, file2, file3);

					closeOutputFile(file1);
					closeInputFile(file2);
					closeInputFile(file3);
				}
			}

		}
		println("\n");
		println("Runs: " + amountOfRuns);
	}

	// splits numbers in the text-file into two pieces
	// file1 contains the numbers, file2 & file3 gets the sorted numbers
	public static void split(Object file1, Object file2, Object file3) {
		Object outputfile2 = file2;
		int previousNumber = 0;
		int currentNumber = 0;
		
		amountOfRuns++;
		
		previousNumber = readInt(file1);
		print(outputfile2, previousNumber + " ");

		while (!isEndOfInputFile(file1)) {
			currentNumber = readInt(file1);

			if (currentNumber < previousNumber) {

				if (outputfile2 == file2)
					outputfile2 = file3;
				else
					outputfile2 = file2;
			}
			print(outputfile2, currentNumber + " ");
			previousNumber = currentNumber;

			if (!isEndOfInputFile(file1))
				readChar(file1);
		}
	}


	// the two sorted files will be merged together into file1
	// it will be merged  till file2 & file3 are full read
	public static void merge(Object file1, Object file2, Object file3) {

		boolean endfile2 = false;
		boolean endfile3 = false;
		int number1 = readInt(file2);
		int number2 = readInt(file3);

		// while the end of the two files aren't reached
		while (!isEndOfInputFile(file2) && !isEndOfInputFile(file3)) {

			if (number1 <= number2) {
				print(file1, number1 + " ");
				readChar(file2);

				if (!isEndOfInputFile(file2))
					number1 = readInt(file2);

				if (isEndOfInputFile(file2))
					endfile3 = true;

			} else if (number1 > number2) {
				print(file1, number2 + " ");
				readChar(file3);

				if (!isEndOfInputFile(file3))
					number2 = readInt(file3);

				if (isEndOfInputFile(file3))
					endfile2 = true;
			}

			// if one of the files reached their end
			if (isEndOfInputFile(file2) && !endfile3 && number1 <= number2) {
				print(file1, number1 + " ");
				endfile3 = true;
			}

			if (isEndOfInputFile(file3) && !endfile2 && number2 <= number1) {
				print(file1, number2 + " ");
				endfile2 = true;
			}
		}
		
		// then print the rest of the numbers
		if (endfile3) {
			print(file1, number2 + " ");

			while (!isEndOfInputFile(file3)) {
				readChar(file3);

				if (!isEndOfInputFile(file3)) {
					number2 = readInt(file3);
					print(file1, number2 + " ");
				}
			}
		}

		if (endfile2) {
			print(file1, number1 + " ");

			while (!isEndOfInputFile(file2)) {
				readChar(file2);

				if (!isEndOfInputFile(file2)) {
					number1 = readInt(file2);
					print(file1, number1 + " ");
				}
			}
		}
	}

	/**
	 * shows the recent sort of the file
	 * 
	 * @param file
	 * @return
	 */
	
	// prints the current sorted numbers in the console
	public static int printRuns(Object file) {

		int previousnumber, currentnumber;
		int runs = 0;
		
		previousnumber = readInt(file);
		print("  (" + previousnumber);

		while (!isEndOfInputFile(file)) {
			currentnumber = readInt(file);

			if (currentnumber >= previousnumber) {
				print(" " + currentnumber);
			} else {
				print(") (" + currentnumber);
				runs++;
			}
			previousnumber = currentnumber;

			if (!isEndOfInputFile(file))
				readChar(file);
		}
		println(")");
		runs++;

		return runs;
	}
}