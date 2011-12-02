package gruppe_2_6;

import static gdi.MakeItSimple.*;

public class Mergesort {

	/** This methode merges and sort from the two helpfiles and create the outputfile
	 * @param filehelp1	Inputed helpfile1
	 * @param filehelp2 Inputed helpfile2
	 * @param fileout
	 */
	public static void merge(String filehelp1, String filehelp2, String fileout) {

		int actelementhelp1 = 0, actelementhelp2 = 0, nextelementhelp1 = 0, nextelementhelp2 = 0;
		boolean rest1, rest2;
		// Open Input file to read and open or create the to help files
		Object outputfile = openOutputFile(fileout);
		Object helpfile1 = openInputFile(filehelp1);
		Object helpfile2 = openInputFile(filehelp2);
		// Initial the first elements of the two helpfiles
		nextelementhelp1 = actelementhelp1 = readInt(helpfile1);
		nextelementhelp2 = actelementhelp2 = readInt(helpfile2);
		// Merge the two helpfiles including sorting
		while (!isEndOfInputFile(helpfile1) && !isEndOfInputFile(helpfile2)) {
			// Look which number is lower (This is the way if the number of
			// helpfile1 is lower
			if (actelementhelp1 <= actelementhelp2) {
				print(outputfile, " " + actelementhelp1);
				// Read the next Number from helpfile1
				if (!isEndOfInputFile(helpfile1))
					nextelementhelp1 = readInt(helpfile1);
				// Look if the next number is lower then is coming the next run
				if (nextelementhelp1 < actelementhelp1) {
					rest2 = true;
					// Because the next number is lower add all remaining
					// numbers from helpfile2 of this run
					while (rest2) {
						print(outputfile, " " + actelementhelp2);
						if (!isEndOfInputFile(helpfile2))
							nextelementhelp2 = readInt(helpfile2);
						// Breaks if the next number of helpfile2 is lower(new
						// run) or end of file
						if (nextelementhelp2 < actelementhelp2
								|| isEndOfInputFile(helpfile2))
							rest2 = false;
						else
							actelementhelp2 = nextelementhelp2;
					}
				}
				// This is the way if the number of helpfile2 is lower
			} else {
				print(outputfile, " " + actelementhelp2);
				if (!isEndOfInputFile(helpfile2))
					nextelementhelp2 = readInt(helpfile2);
				// Look if the next number is smaller then new run
				if (nextelementhelp2 < actelementhelp2) {
					rest1 = true;
					// If it is smaller add all remaining numbers from helpfile1
					// of this run
					while (rest1) {
						print(outputfile, " " + actelementhelp1);
						if (!isEndOfInputFile(helpfile1))
							nextelementhelp1 = readInt(helpfile1);
						// Breaks if the next number of helpfile1 is lower(new
						// run) or end of file
						if (nextelementhelp1 < actelementhelp1
								|| isEndOfInputFile(helpfile1))
							rest1 = false;
						else
							actelementhelp1 = nextelementhelp1;
					}
				}
			}
			// Move one number
			actelementhelp1 = nextelementhelp1;
			actelementhelp2 = nextelementhelp2;
		}
		// Now we look if one helpfile is longer than the other one(more runs)
		// If they have the same size add the last elements sorted
		if (isEndOfInputFile(helpfile1) && isEndOfInputFile(helpfile2)) {
			if (actelementhelp1 > actelementhelp2) {
				print(outputfile, " " + actelementhelp2);
				print(outputfile, " " + actelementhelp1);
			}
		}
		// If helpfile1 is longer add the remaining last number of helpfile2
		// sorted an then add the remaining number of helpfile1
		if (!isEndOfInputFile(helpfile1) && isEndOfInputFile(helpfile2)) {
			// Look if the last number of helpfile2 is higher then find the
			// right place(sorted) and add it
			if (actelementhelp1 <= actelementhelp2) {
				print(outputfile, " " + actelementhelp1);
				while (actelementhelp1 < actelementhelp2
						&& !isEndOfInputFile(helpfile1)) {
					if (!isEndOfInputFile(helpfile1))
						actelementhelp1 = readInt(helpfile1);
					print(outputfile, " " + actelementhelp1);
				}
				print(outputfile, " " + actelementhelp2);

			}
			// If the last number of helpfile2 is smaller just add id
			if (actelementhelp1 > actelementhelp2) {
				print(outputfile, " " + actelementhelp2);
				print(outputfile, " " + actelementhelp1);
			}
			// Add the remaining numbers(runs)
			while (!isEndOfInputFile(helpfile1)) {
				if (!isEndOfInputFile(helpfile1))
					print(outputfile, " " + readInt(helpfile1));
			}
		}
		// If helpfile2 is longer add the remaining last number of helpfile1
		// sorted an then add the remaining number of helpfile1
		if (isEndOfInputFile(helpfile1) && !isEndOfInputFile(helpfile2)) {
			// If the last number of helpfile1 is lower just add id
			if (actelementhelp1 < actelementhelp2) {
				print(outputfile, " " + actelementhelp1);
				print(outputfile, " " + actelementhelp2);
			}
			// Look if the last number of helpfile1 is higher then find the
			// right place(sorted) and add it
			if (actelementhelp1 > actelementhelp2) {
				print(outputfile, " " + actelementhelp2);
				while (actelementhelp1 >= actelementhelp2
						&& !isEndOfInputFile(helpfile2)) {
					if (!isEndOfInputFile(helpfile2))
						print(outputfile, " " + readInt(helpfile2));
				}
				print(outputfile, " " + actelementhelp1);
			}
			// Add the remaining numbers(runs)
			while (!isEndOfInputFile(helpfile2)) {
				if (!isEndOfInputFile(helpfile2))
					print(outputfile, " " + readInt(helpfile2));
			}
		}
		// Close our files to avoid errors
		closeInputFile(helpfile1);
		closeInputFile(helpfile2);
		closeOutputFile(outputfile);
	}

	/**This is a help function which changes the actuel object (In our case file) to the other one
	 * @param Actuelfile
	 * @param File1
	 * @param File2
	 * @return The other File
	 */
	static Object change(Object file, Object file1, Object file2) {

		if (file == file1)
			return file2;
		else
			return file1;
	}

	/**This methode splits the inputed file into two helpfiles. It changes the outputfile everytime an run ends.
	 * @param filein is the Inputed file which is going to be split
	 * @param filehelp1	Is one of the outputed helpfiles
	 * @param filehelp2 Is the other one of the outputed helpfiles
	 */
	public static void split(String filein, String filehelp1, String filehelp2) {

		int actelement = 0, nextelement = 0;
		boolean ende = false;

		// Open Input file to read and open or create the to help files
		Object Inputfile = openInputFile(filein);
		Object helpfile1 = openOutputFile(filehelp1);
		Object helpfile2 = openOutputFile(filehelp2);
		// Set our actuelfile on helpfile1
		Object aktfile = helpfile1;
		// Initial the two first elements of the input file
		actelement = readInt(Inputfile);
		nextelement = readInt(Inputfile);
		// Go throw the input file and split the numbers
		while (!isEndOfInputFile(Inputfile)) {
			// If the right number is bigger then the left number add it and read the next
			if (actelement > nextelement) {
				print(aktfile, " " + actelement);
				actelement = nextelement;
				if (!isEndOfInputFile(Inputfile))
					nextelement = readInt(Inputfile);
				// If we reach the end split the last two numbers in the correct order
				if (isEndOfInputFile(Inputfile)) {
					aktfile = change(aktfile, helpfile1, helpfile2);
					print(aktfile, " " + actelement);
					aktfile = change(aktfile, helpfile1, helpfile2);
					print(aktfile, " " + nextelement);
				}
			}
			// If the left number is bigger then the right number add it until it comes an lower one(run)
			else {
				while (actelement <= nextelement && (!ende)) {
					print(aktfile, " " + actelement);
					actelement = nextelement;
					if (!isEndOfInputFile(Inputfile))
						nextelement = readInt(Inputfile);
					else
						ende = true;
				}
				// If we reach the end split the last two numbers in the correct order
				if (isEndOfInputFile(Inputfile) && actelement > nextelement) {
					print(aktfile, " " + actelement);
					aktfile = change(aktfile, helpfile1, helpfile2);
					print(aktfile, " " + nextelement);
				} else {
					print(aktfile, " " + actelement);
					actelement = nextelement;
				}
				if (!isEndOfInputFile(Inputfile)) {
					nextelement = readInt(Inputfile);
					// If we reach the end split the last two numbers in the correct order
					if (isEndOfInputFile(Inputfile)	&& actelement > nextelement) {
						aktfile = change(aktfile, helpfile1, helpfile2);
						print(aktfile, " " + actelement);
						aktfile = change(aktfile, helpfile1, helpfile2);
						print(aktfile, " " + nextelement);
					}
					// If we reach the end split the last two numbers in the correct order
					if (isEndOfInputFile(Inputfile)
							&& actelement < nextelement) {
						aktfile = change(aktfile, helpfile1, helpfile2);
						print(aktfile, " " + actelement);
						print(aktfile, " " + nextelement);
					}
				}
			}
			// Change the actuel temp file to the other helpfile
			aktfile = change(aktfile, helpfile1, helpfile2);
		}
		// Close our files to avoid errors
		closeInputFile(Inputfile);
		closeOutputFile(helpfile1);
		closeOutputFile(helpfile2);
	}

	/**This is an helpfunction which counts the runs
	 * @param filein The inputed file
	 * @return The number of runs, if it is 1 we know that the file is sorted
	 */
	static int runs(String filein) {

		int actelement = 0, nextelement = 0, run = 0;
		boolean kommtfolge = true;

		// Open Input file to read and open or create the to help files
		Object Inputfile = openInputFile(filein);
		// Initial the two first elements of the input file
		actelement = readInt(Inputfile);
		nextelement = readInt(Inputfile);
		// Go throw the input file and split the numbers
		while (!isEndOfInputFile(Inputfile)) {
			// If the left number is bigger then the right number increase run an read the next number
			if (actelement > nextelement) {
				run++;
				actelement = nextelement;
				if (!isEndOfInputFile(Inputfile))
					nextelement = readInt(Inputfile);
				// Look if we reach the end and count if there is an run
				if (actelement > nextelement && (isEndOfInputFile(Inputfile)))
					run++;
			}
			// If the right number is bigger then the left number
			else {
				// Going throw the run until we reach the next run(lower number)
				while (actelement <= nextelement
						&& (!isEndOfInputFile(Inputfile))) {
					actelement = nextelement;
					if (!isEndOfInputFile(Inputfile))
						nextelement = readInt(Inputfile);
					// If we previously counted the run and are still in the same
					if (!kommtfolge) {
						kommtfolge = true;
						run--;
					}
				}
				// Increase run
				run++;
				// Look if the actuel number is higher then the next number and increase run also put the variable kommtfolge on true because it can be an run
				if (actelement > nextelement
						&& (!isEndOfInputFile(Inputfile))) {
					run++;
					kommtfolge = false;
				}
				// Look if we reach the end and count if there is an run
				if (actelement > nextelement && (isEndOfInputFile(Inputfile)))
					run++;
				// Set the next number
				actelement = nextelement;
				if (!isEndOfInputFile(Inputfile))
					nextelement = readInt(Inputfile);
				// Look if we reach the end and count if there is an run
				if (actelement > nextelement && (isEndOfInputFile(Inputfile)))
					run ++;
			}
		}
		// Close our files to avoid errors
		closeInputFile(Inputfile);
		return run;
	}

	/**This methode reads an inputfile and returns on the console the runs formated in number of run ( run ) 
	 * @param filein Inputfile
	 */
	public static void printruns(String filein) {

		int actelement = 0, nextelement = 0, run = 0;
		boolean kommtfolge = true, firstofrun = false,same=false;

		// Open Input file to read and open or create the to help files
		Object Inputfile = openInputFile(filein);
		// Initial the two first elements of the input file
		actelement = readInt(Inputfile);
		nextelement = readInt(Inputfile);
		// Go throw the input file and split the numbers
		while (!isEndOfInputFile(Inputfile)) {
			// If the left number is bigger then the right number increase run an read the next number
			if (actelement > nextelement) {
				run++;
				if(!kommtfolge){
					print(" ) " + run + ". run" + "( " + nextelement + " ) ");
					kommtfolge=true;
					firstofrun=true;
					same=true;
				}
				else 
					if (!same)
						print(run + ". run" + "( " + actelement + " ) ");
					else
						same=false;
				actelement = nextelement;
				if (!isEndOfInputFile(Inputfile))
					nextelement = readInt(Inputfile);
				// Look if we reach the end and count if there is an run
				if (actelement > nextelement && (isEndOfInputFile(Inputfile))){
					print(run + ". run" + "( " + actelement + " ) ");	
					run++;
					print(run + ". run" +  "( " + nextelement + " )");
				}
			}
			// If the right number is bigger then the left number(sorted)
			else {
				// Increase run
				run++;
				// Going throw the run until we reach the next run(lower number)
				if(!kommtfolge)
					print(" ");
				else
					if (firstofrun){
						print( " " + nextelement + " ");
						run--;
					}
					
					else
						print(run + ". run" + "( " + actelement + " ");
				while (actelement <= nextelement && (!isEndOfInputFile(Inputfile))) {
					if (firstofrun){
						actelement = nextelement;
						firstofrun=false;
					}
					else{
						actelement = nextelement;
						print(actelement + " ");
					}
					if (!isEndOfInputFile(Inputfile))
						nextelement = readInt(Inputfile);
					// If we previously counted the run and are still in the same
					if (!kommtfolge) {
						kommtfolge = true;
						run--;
					}
				}
				print(") ");
				// Look if the actuel number is higher then the next number and increase run also put the variable kommtfolge on true because it can be an run
				if (actelement > nextelement
						&& (!isEndOfInputFile(Inputfile))) {
					run++;
					kommtfolge = false;
				}
				// Look if we reach the end and count if there is an run
				if (actelement > nextelement && (isEndOfInputFile(Inputfile))){
					run++;
					print(run + ". run" + "( " + nextelement + " )");
				}
				// Set the next number
				actelement = nextelement;
				if (!isEndOfInputFile(Inputfile))
					nextelement = readInt(Inputfile);
				// Look if we reach the end and count if there is an run
				if (actelement > nextelement && (isEndOfInputFile(Inputfile))){
					print(run + ". run" + "( " + actelement + " )");
					run++;
					print(run + ". run" + "( " + nextelement + " )");
				}
				// Look if we reach the end and count if there is an run
				if (actelement <= nextelement && (isEndOfInputFile(Inputfile)) && !kommtfolge){
					print(run + ". run" + "( " + actelement + " " + nextelement + " )" );
				}
				if ((!isEndOfInputFile(Inputfile)) && !kommtfolge)
					print(run + ". run" + "( " + actelement );
			}
		}
		// Close our files to avoid errors
		closeInputFile(Inputfile);
	}

	
	
	/**This methode sorts an ipnuted file per mergesort
	 * @param filein File
	 */
	public static void mergesort(String filein) {

		int runs = 0;

		Object datei = openInputFile(filein);
		runs = runs(filein);
		// Do split and merge till the file is sortef (runs=1)
		while (runs > 1) {
			split(filein, "help01.txt", "help02.txt");
			merge("help01.txt", "help02.txt", filein);
			runs = runs(filein);
		}

		closeInputFile(datei);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String file="";
		int i=0;
		
		while(i!=3){
			println("Bitte wählen sie: \n 1)Wenn sie eine Datei sortieren wollen \n 2)Wenn sie die runs ausgeben wollen \n 3)Für Beenden");
			i=readInt();
			if (i==1){
				println("Bitte geben sie die Datei an die Sortiert werden soll: ");
				readLine();
				file=readLine();
				if (!isFilePresent(file))
					println("Datei existiert nicht");
				else
					mergesort(file);
			}
			if (i==2){
				println("Bitte geben sie die Datei an die Sortiert werden soll: ");
				readLine();
				file=readLine();
				if (!isFilePresent(file))
					println("Datei existiert nicht");
				else
					printruns(file);
			}
			if(i!=1 && i!=2 && i!=3)
				println("Üngultige Einagbe");
		}
	}
}
