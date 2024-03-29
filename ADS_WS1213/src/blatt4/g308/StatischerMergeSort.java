/*
Fabienne Seitz, Matr.Nr: 1220109

Michelle Bauer, Matr.Nr: 1230289

Brice Tsakeng Tontsa, Matr.Nr: 1228123
 */

package blatt4.g308;

import static gdi.MakeItSimple.*;

public class StatischerMergeSort {
	
	/**Function to sort and mix with the external process files
	 
	 * @param pfadOriginal is the original main file
	 
	 * @param hilfsPfad1 is an auxiliary file, and includes a part of the main file. 
	          You will need to apply the methods split and merge
	 
	 
	 * @param hilfsPfad2 is an auxiliary file, and includes a part of the main file. 
	          You will need to apply the methods split and merge
	  
	 */
	
	
	public static void mergeSort(String pfadOriginal, String hilfsPfad1, String hilfsPfad2){
		int lauflänge = 1;
		int anzahlDerZahl = anzahlDerZahlen(pfadOriginal);
		if(!isFilePresent(pfadOriginal) && !isFileReadable(pfadOriginal)) {
			println("Die Datei existiert nicht oder ist Lese-und Schreibgeschützt");
			return;
		}
		
		while(lauflänge < anzahlDerZahl){
			split(pfadOriginal, hilfsPfad1, hilfsPfad2, lauflänge);
			merge(pfadOriginal, hilfsPfad1, hilfsPfad2, lauflänge);
			
			lauflänge = lauflänge*2;
		}
		
	}
	
	/**funtion, Function which is needed to count the number of values ​​in the file to be tested
	 
	 * @param testDatei is the file with the figures contained
	 
	 
	 * @return Returns the number of numbers of the tested file

	 */
	public static int anzahlDerZahlen (String testDatei){
		int anzahlDerZahl = 0;
		Object eingabe = openInputFile(testDatei);
		while(!isEndOfInputFile(eingabe)){
			readInt(eingabe);
			anzahlDerZahl++;
		}
		closeInputFile(eingabe);
		return anzahlDerZahl;
		
	}
	
	/**Function with the main file is split alternately in the two auxiliary files
	 
	 * @param pfadOriginal is the original main file
	 
	 * @param hilfsPfad1 is an auxiliary file, and includes a part of the main file. 
	          You will need to apply the methods split and merge
	
	 * @param hilfsPfad2 is an auxiliary file, and includes a part of the main file. 
	          You will need to apply the methods split and merge
	   
	 * @param lauflänge is number of runs on the target band
	  
	 */
	public static void split(String pfadOriginal, String hilfsPfad1, String hilfsPfad2, int lauflänge){
		Object eingabe = openInputFile(pfadOriginal);
		Object ausgabe1 = openOutputFile(hilfsPfad1);
		Object ausgabe2 = openOutputFile(hilfsPfad2);
		int zwischenspeicher = 0;
		int i = 0;
		
		while(!isEndOfInputFile(eingabe)){
			
			
			while(i < lauflänge && !isEndOfInputFile(eingabe)) {
				zwischenspeicher = readInt(eingabe);
				print(ausgabe1," " + zwischenspeicher);
				i++;
			}
			i=0;
			while(i < lauflänge && !isEndOfInputFile(eingabe)) {
				zwischenspeicher = readInt(eingabe);
				print(ausgabe2," " + zwischenspeicher);
				
				i++;
			}
			i=0;
		}
		closeInputFile(eingabe);
		closeOutputFile(ausgabe1);
		closeOutputFile(ausgabe2);
	}
	/**function which the pre-sorted file combined into a file
	 
	 * @param pfadOriginal pfadOriginal the original main file
	 
	 * @param hilfsPfad1 Includes a part of the main file. 
	          Is required to apply the methods split and merge
	   
	 * @param hilfsPfad2 Includes a part of the main file.
		  Is required to apply the methods split and merge
	   
	 * @param lauflänge is number of runs on the target band
	 
	 */
	public static void merge(String pfadOriginal, String hilfsPfad1, String hilfsPfad2, int lauflänge){
		Object ausgabe = openOutputFile(pfadOriginal);
		Object eingabe1 = openInputFile(hilfsPfad1);
		Object eingabe2 = openInputFile(hilfsPfad2);
		
		int zwischenspeicher1 = readInt(eingabe1);
		int zwischenspeicher2 = readInt(eingabe2);
		int i=0;
		int j=0;
		int k=0;
		boolean ende1 = false;
		boolean ende2 = false;
		
		while(!ende1 || !ende2){
			if(!ende1){
				j=0;
			}
			if(!ende2){
				k=0;
			}
			i = 0;
			while(i < lauflänge*2 && (!ende1 || !ende2)) {
				if(j == lauflänge|| k == lauflänge || ende1 || ende2){
					if(j!= lauflänge || (ende2 && !ende1)){
						print(ausgabe," " + zwischenspeicher1);
						if(!isEndOfInputFile(eingabe1)){
							zwischenspeicher1 = readInt(eingabe1);
						}else{
							ende1 = true;
						}
						j++;
					}else if (k != lauflänge || (ende1 && !ende2)){
						print(ausgabe," " + zwischenspeicher2);
						if(!isEndOfInputFile(eingabe2)){
							zwischenspeicher2 = readInt(eingabe2);
						}else{
							ende2 = true;
						}
						k++;
					}
				}else if (zwischenspeicher1 <= zwischenspeicher2 && j!= lauflänge) {
					print(ausgabe," " + zwischenspeicher1);
					if(!isEndOfInputFile(eingabe1)){
						zwischenspeicher1 = readInt(eingabe1);
					}else{
						ende1 = true;
					}
					j++;
				}else if (zwischenspeicher1 > zwischenspeicher2 && k != lauflänge) {
					print(ausgabe," " + zwischenspeicher2);
					if(!isEndOfInputFile(eingabe2)){
						zwischenspeicher2 = readInt(eingabe2);
					}else{
						ende2 = true;
					}
					k++;
				}
				i++;
				
			}
			
			
		}
		
		closeOutputFile(ausgabe);
		closeInputFile(eingabe1);
		closeInputFile(eingabe2);
	}


	public static void main(String[] args) {
		String band1 = "band1.txt";
		String band2 = "band2.txt";
		String band3 = "band3.txt";
		
		mergeSort(band1,band2,band3);
		}

	  }