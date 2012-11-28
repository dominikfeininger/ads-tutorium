package blatt3.g305;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

public class aufgabe03 {

	
	static int binarySearch(int[] array, int value, int small, int large) {
		int half = small + (large - small) / 2;
		if (value == array[half]) {
			return half;
		} else {
			if (small == large) {
				return small;
			} else {
				if (value < array[half]) {
					return binarySearch(array, value, small, half);
				} else {
					return binarySearch(array, value, half + 1, large);
				}
			}
		}
	}
	
	static int binarySearchCounter(int[] array, int value, int small, int large,int counter) {
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
		                return counter + binarySearchCounter(array, value, small, half, +1 );
					}
					//else the small border is set as half+1
					else {
						return counter + binarySearchCounter(array, value, half+1, large, +1);
		            }
				}
			}
		}

	static int insertionSort(int[] array) {
		int counter = 0;//counter is equal to number of shifts
		for (int i = 1; i < array.length; i++) {
			int j = i;
			int m = array[i]; //marker position
			while (j > 0 && array[j - 1] > m) {
				// shift all bigger elements and compare at same time
				counter++;
				array[j] = array[j - 1];
				j--;
			}
			//set m on the free place
			array[j] = m;
		}
		return counter;
	}
	
	static int[] binaryInsertionSort(int array[]) {
		//binary sort modified to give back counter 
		int m, i, j, tmp;
		int[] counter = {0,0};
		for (i = 0; i < array.length; i++) {
			counter[0] = counter[0] + binarySearchCounter(array, array[i], 0, i,0);
			m = binarySearch(array, array[i], 0, i);//marker position
			if (m < i) {
				tmp = array[i];
				for (j = i - 1; j >= m; j--){
					counter[1]++;
					//protocoll(array);
					array[j + 1] = array[j];//shift all bigger elements
				}
				array[m] = tmp;
				//protocoll(array);
			}
		}
		return counter;
	}
	
	static int[] randomFillArray(int sizeOfArray){
		//function that fills an array with a given 
		//number of elements with sorted elements
		int data[] = new int[sizeOfArray];
		for(int i=0; i<sizeOfArray-1;i++){
			data[i] = (int) Math.floor(Math.random()*sizeOfArray-1);
		}
		return data;
	}
	
	static int[] Experiment(int numberOfTrys, int sizeOfArray){
		//function for the experiment
		int[] result = {0,0,0,0};
		for(int i=0; i<numberOfTrys;i++){
			int[] array=randomFillArray(sizeOfArray);
			result[0]=result[0]+insertionSort(array);
			//number of shifts is equal to number of coparisons
			result[1]=result[0];
		}
		for(int i=0; i<numberOfTrys;i++){
			int[] array=randomFillArray(sizeOfArray);
			int[] tmp = new int[2];
			tmp=binaryInsertionSort(array);
			result[2]=result[2]+tmp[0];
			result[3]=result[3]+tmp[1];
		}
		result[0]=result[0]/numberOfTrys;
		result[1]=result[1]/numberOfTrys;
		result[2]=result[2]/numberOfTrys;
		result[3]=result[3]/numberOfTrys;
		return result;
	}

	public static void main(String[] args) {
		int[] array = new int[3];
		int arraysize=0, trys=0;
		println("Geben Sie bitte die anzahl der Suchläufe ein :");
		trys = readInt();
		println("Geben Sie bitte die Größe des Arrays ein :");
		arraysize = readInt();
		array = Experiment(trys,arraysize);
		println("InsertionSort, Anzahl der Vergleiche im Durchschnitt:" + " " + array[0]);
		println("InsertionSort, Anzahl der Shifts im Durchschnitt:" + " " + array[1]);
		println("binaryInsertionSort, Anzahl der Vergleiche im Durchschnitt:" + " " + array[2]);
		println("binaryInsertionSort, Anzahl der Shifts im Durchschnitt:" + " " + array[3]);
	}
}
