package blatt3.g305;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

public class aufgabe02 {

	
	//Lineare Suche mir erstem Treffer
	static int linearSearchA(int[] array, int value){
	//returns counter on first sucessed comparing
		int counter=0;
		for(int i=0;i<array.length;i++){
			counter++;
			if(array[i]==value){
				return counter;
			}
		}
		return counter;
	}
	
	//Lineare Suche mit letztem Treffer
	static int linearSearchB(int[] array, int value){
	//return counter after comparing all elements
		int counter=0;
		int pos = -1;
		for(int i=0;i<array.length;i++){
			counter++;
			if(array[i]==value){
				pos=i;
			}
		}
		return counter;
	}
	
	//Rekursive binäre Suche
	static int binarySearchRecursive(int[] array, int value, int small, int large,int counter) {
	//recursive version of the binary Search
		int half = small + (large-small) / 2; 
		//if value equals the element at index half of the array, sucess
		if (value == array[half]) {
			counter++;
			return counter;
		} 
		else {
			// termination if small border is equal to large border
			if (small == large){
				counter++;
				return counter;
			} 
			else {
				//if value is lower then half, half border is set as large border
				if (  value < array[half]) {
	                return counter + binarySearchRecursive(array, value, small, half, +1 );
				}
				//else the small border is set as half+1
				else {
					return counter + binarySearchRecursive(array, value, half+1, large, +1);
	            }
			}
		}
	}
	 
	static int binarySearchRecursive(int[] array, int value) {
		//recursive callup of binary Search
		return binarySearchRecursive(array, value, 0, array.length - 1,0);
	}
	
	//Iterative binäre Suche
	static int binarySearchIterative(int[] array, int value){
		int small = 0, large = array.length - 1, counter = 0;
		//termination if small border is bigger than the large border
		while (small <= large) {
			int half = (small + large) / 2;
			if (array[half] == value){
				counter++;
				return counter;
			}
			else if (value < array[half]){
				counter++;
				large = half-1; // searching in the lower half of the array
			}
			else{
				counter++;
				small = half+1; // searching in the higher half of the array
			}
		}
		return counter;//return array lengh when no sucess
	}
	
	static int[] fillArray(int numberOfElements){
		//function that fills an array with a given 
		//number of elements with sorted elements
		int data[] = new int[numberOfElements];
		for(int i=0; i<numberOfElements-1;i++){
			data[i] = i;
		}
		return data;
	}
	
	static int[] experiment(int numberOfTrys, int sizeOfArray, int[] array){
		//function that calculated the avarage value of the comparisons
		//based on overall number of trys and the size of a given array
		int[] result = {0,0,0,0};
		//Array for each  result
		for(int i=0; i<numberOfTrys;i++){
			//for each i a new random number from the array is generated
			//searching with sucess
			//int wert = (int) Math.floor(Math.random()*sizeOfArray-1);
			int wert = -1; //searching without sucess
			result[0]=result[0]+linearSearchA(array, wert);
			result[1]=result[1]+linearSearchB(array, wert);
			result[2]=result[2]+binarySearchRecursive(array, wert);
			result[3]=result[3]+binarySearchIterative(array, wert);
		}
		//now we are calculating the average value of comparisons
		result[0]=result[0]/numberOfTrys;
		result[1]=result[1]/numberOfTrys;
		result[2]=result[2]/numberOfTrys;
		result[3]=result[3]/numberOfTrys;
		return result;
	}
	
	public static void main(String[] args){
		int arraysize=0, trys=0;
		println("Geben Sie bitte die anzahl der Suchläufe ein :");
		trys = readInt();
		println("Geben Sie bitte die Größe des Arrays ein :");
		arraysize = readInt();
		int[] array = fillArray(arraysize);
		int[] result = experiment(trys,arraysize,array);
		println("Lineare Suche(letzterTreffer), Anzahl der Vergleiche im Durchschnitt:" + " " + result[0]);
		println("Lineare Suche(letzterTreffer),  Anzahl der Vergleiche im Durchschnitt:" + " " + result[1]);
		println("Binäre Suche iterativ,  Anzahl der Vergleiche im Durchschnitt:" + " " + result[2]);
		println("Binäre Suche rekursiv,  Anzahl der Vergleiche im Durchschnitt:" + " " + result[3]);
	}
}
	

