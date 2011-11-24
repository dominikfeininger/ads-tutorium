package gruppe_2_11;

import static gdi.MakeItSimple.*;

public class Aufgabe02 {
	//TODO: Kommentare!!!
static int linearSearch1(int[] numbers, int search) {
	/* To search the array in every element from
	 * the front to the back it ends with the last
	 * element of the array*/
		int index = 0, compare = 0;
		while (index < numbers.length) {
			compare++;
			if (numbers[index] == search)
				;
			index++;
		}
		return compare;
	}

	static int linearSearch2(int[] numbers, int search) {
		/*To search the array in every element
		 * from he back to the front it ends when
		 * the searched element was found*/
		int index = 0, found = -1, compare = 0;
		while ((index < numbers.length) && (found == -1)) {
			compare++;
			if (numbers[index] == search)
				found = index;
			index++;
		}
		return compare;
	}

	static int binarySearchRec(int[] numbers, int search, int index, int indexEnd, int compare) {
		
		if (index > indexEnd){    			
			return compare;
		}	
		
		int indexMiddle = index + ((indexEnd - index) / 2);
		
		if (numbers[indexMiddle] < search){
			compare++;
			return binarySearchRec(numbers, search, index + 1, indexEnd, compare);
		}
		if (numbers[indexMiddle] > search){
			compare++;
			return binarySearchRec(numbers, search, index - 1, indexEnd, compare);
		}
		return compare;	
	}
	
	static int binarySearchIt(int[] numbers, int search) {
		/* To search the array by halving 
		 * in every step*/
		int index = 0, end = numbers.length - 1,indexMiddle = -1, compare = 0;
		
		while (index <= end){
			indexMiddle = index + ((end -index) / 2);
			
			if (numbers[indexMiddle] > search){
				end = indexMiddle -1;
			}
			else if (numbers[indexMiddle] < search){
				index = indexMiddle + 1;
			}
			else if (numbers[indexMiddle] == search){
				return indexMiddle;				
			}
			if (index > end)
				return compare;
			compare++;
		}
		return compare;
	}
	
	public static void main(String[] args) {
		
		
		//TODO. Ausgabe strukturieren
		int[] numbers = new int [1024];
		int search, index = 0, indexEnd = numbers.length -1, läufe = 0, compare = 0, a = 0, b= 0;
		for (int i = 0; i<numbers.length; i++) {numbers[i] = i;};
		
		while (läufe <= 100){
			
			search = (int) (Math.random() * 1024);

			println("lineare Suche letzter Treffer: " + linearSearch1(numbers, search));
			println("lineare Suche erster Treffer: " + linearSearch2(numbers, search));
			println("binäre Suche rekursiv: " + binarySearchRec(numbers, search, index, indexEnd, compare));
			println("binäre Suche iterativ:" + binarySearchIt(numbers, search));
			println();
			läufe++;
			a = a + binarySearchRec(numbers, search, index, indexEnd, compare);
			b = b + binarySearchIt(numbers, search);
		
		}
		
		println("Durchschnitt binäre Suche rekursiv: " + (a / 100));
		println("Durchschnitt binäre Suche iterativ: " + (b / 100));
		println("---------------------------------------------------------");
		
		numbers = new int [2048];
		index = läufe = compare = a = b= 0;
		indexEnd = numbers.length -1;
		for (int i = 0; i<numbers.length; i++) {numbers[i] = i;};
		
		while (läufe <= 100){
			
			search = (int) (Math.random() * 2048);
			//TODO: ermittelte Werte in Tabelle eintragen!!!!
			println("lineare Suche letzter Treffer: " + linearSearch1(numbers, search));
			println("lineare Suche erster Treffer: " + linearSearch2(numbers, search));
			println("binäre Suche rekursiv: " + binarySearchRec(numbers, search, index, indexEnd, compare));
			println("binäre Suche iterativ:" + binarySearchIt(numbers, search));
			println();
			läufe++;
			a = a + binarySearchRec(numbers, search, index, indexEnd, compare);
			b = b + binarySearchIt(numbers, search);
		
		}
		
		println("Durchschnitt binäre Suche rekursiv: " + (a / 100));
		println("Durchschnitt binäre Suche iterativ: " + (b / 100));
		println("---------------------------------------------------------");
		
		numbers = new int [4096];
		index = läufe = compare = a = b= 0;
		indexEnd = numbers.length -1;
		for (int i = 0; i<numbers.length; i++) {numbers[i] = i;};
		
		while (läufe <= 100){
			
			search = (int) (Math.random() * 4096);

			println("lineare Suche letzter Treffer: " + linearSearch1(numbers, search));
			println("lineare Suche erster Treffer: " + linearSearch2(numbers, search));
			println("binäre Suche rekursiv: " + binarySearchRec(numbers, search, index, indexEnd, compare));
			println("binäre Suche iterativ:" + binarySearchIt(numbers, search));
			println();
			läufe++;
			a = a + binarySearchRec(numbers, search, index, indexEnd, compare);
			b = b + binarySearchIt(numbers, search);
		
		}
		
		println("Durchschnitt binäre Suche rekursiv: " + (a / 100));
		println("Durchschnitt binäre Suche iterativ: " + (b / 100));
	}
}
