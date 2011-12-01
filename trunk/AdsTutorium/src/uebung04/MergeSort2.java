
package uebung04;

import static gdi.MakeItSimple.*;

public class MergeSort2 {
	private static int run = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object file = openOutputFile("c:\\Band.txt");
		if (isFilePresent("c:\\Band.txt")) {
			print(file,"44 55 12 42 94 18 6 67");
		}
		closeOutputFile(file);
		straightMergeSort();
	}

	public static int[] loadFromFile() {
		int i = 0, c;
		int[] f;
		Object file = openInputFile("c:\\Band.txt");
		if (isFilePresent("c:\\Band.txt")) {
			//count elements in file
			while (!isEndOfInputFile(file)) {
				c = readInt(file);
				i++;
			}
			f = new int[i];
			closeInputFile(file);
			file = openInputFile("c:\\Band.txt");
			i = 0;

			//write elements in array
			while (!isEndOfInputFile(file)) {
				c = readInt(file);
				f[i] = c;
				i++;
			}

		} else {
			f = new int[1];
			println("## Datei existiert nicht!");
		}
		closeInputFile(file);
		return f;
	}

	public static void straightMergeSort() {
		int[] unsorted = loadFromFile();;

		while(!isSorted(unsorted)){			
			split(unsorted);
			printtape("c:\\Band1.txt");
			printtape("c:\\Band2.txt");
			println();
			println("current runLength" + run);
			merge();
			//printtape("c:\\Band.txt");
			unsorted = loadFromFile();
			run = 2 * run; //max run length
		}
	}

	private static void printtape(String path) {
		Object file = openInputFile(path);
		println(readLine(file));
		closeInputFile(file);

	}

	private static boolean isSorted(int[] unsorted) {
		for(int i=0;i<unsorted.length-1;i++){
			if(unsorted[i]>unsorted[i+1]){
				return false;
			}
		}return true;
	}

	private static void merge() {
		Object file1 = openInputFile("c:\\Band1.txt");
		Object file2 = openInputFile("c:\\Band2.txt");
		Object file	 = openOutputFile("c:\\Band.txt");

		int tapeValue1 = 0;
		int tapeValue2 = 0;
		int actualrun1;
		int actualrun2;

		tapeValue1 = readInt(file1);
		tapeValue2 = readInt(file2);
		
		while(!isEndOfInputFile(file1) && !isEndOfInputFile(file2)){
			actualrun1 = 0;
			actualrun2 = 0;
			
			//while not end of run check values and copy the lower one to mergeFile
			while(actualrun1 < run && actualrun2 < run ){
				
				if(tapeValue1 > tapeValue2){
					print(file," "+tapeValue2);
					print(" "+tapeValue2);
					actualrun2++;
					tapeValue2 = readInt(file2);
					
					/*
					//wenn das ende von file 2 ereicht dann schrieb komplett file1 ans ende von der mergedatei
					if(isEndOfInputFile(file2)){
						while(!isEndOfInputFile(file1)){
							print(file," "+tapeValue1);
							print(" "+tapeValue1);
							tapeValue1 = readInt(file1);
							actualrun1++;
						}
					}else{
						//falls nicht, lese einfach den nächsten wert der datei2
						tapeValue2 = readInt(file2);
					}*/

				}else{
					print(file," "+tapeValue1);
					print(" "+tapeValue1);
					actualrun1++;
					tapeValue1 = readInt(file1);
					/*
					//wenn das ende von file1 erreicht dann schreib komplett file2 ans ende von der mergedatei
					if(isEndOfInputFile(file1)){
						while(!isEndOfInputFile(file2)){
							print(file," "+tapeValue2);
							print(" "+tapeValue2);
							tapeValue2 = readInt(file2);
							actualrun2++;
						}
					}else{
						//falls nicht, lese einfach den nächsten wert der datei2
						tapeValue1 = readInt(file1);
					}*/
				}
			}

			//one run is @ the end!
			//print rest of other run to mergeFile
			if(actualrun1 >= run){
				//run1 is @ the end
				while(actualrun2 < run ){
					print(file," "+tapeValue2);
					print(" "+tapeValue2);
					actualrun2++;
					tapeValue2 = readInt(file2);
				}
			}

			if(actualrun2 >= run){
				//run2 is @ the end
				while(actualrun1 < run ){
					print(file," "+tapeValue1);
					print(" "+tapeValue1);
					actualrun1++;
					tapeValue1 = readInt(file1);
				}
			}
		}
		closeInputFile(file2);
		closeInputFile(file1);
		closeOutputFile(file);
	}

	public static void split(int[] unsplit) {
		Object file1 = openOutputFile("c:\\Band1.txt");
		Object file2 = openOutputFile("c:\\Band2.txt");



		boolean bool = true;
		int actualrun = 0; //actual runCounter, counts how long the actual run is

		for (int j = 0; j < unsplit.length; j++) {

			//falls länge des runs noch nicht am ende, schreibe den aktuellen wert in das aktuelle tape
			if (actualrun < run) {
				if (bool == true) {
					print(file1, " "+unsplit[j]);
				} else {
					print(file2, " "+unsplit[j]);
				}
			} else {//falls nicht, wechsle das band (und setze die aktuelle run länge wieder auf 0, da der nächste run dann ja hier beginnt) und schreibe dann den aktuellen wert in das aktuelle tape
				if (bool == true) {
					bool = false;
				} else {
					bool = true;
				}
				actualrun = 0;
				if (bool == true) {
					print(file1, " "+unsplit[j]);
				} else {
					print(file2, " "+unsplit[j]);
				}
			}
			actualrun++;
		}
		closeOutputFile(file1);
		closeOutputFile(file2);
		println();
	}
}
