package gruppe_2_11;

import static gdi.MakeItSimple.*;

public class Aufgabe03 {
	//TODO: Kommentare!!!
	static void swap(int[] numbers, int index1, int index2) {
		// To swap two numbers in an array.
		int var = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = var;
	}

	static String printArray(int[] numbers) {
		// To print all elements of an array.
		int index = 0;
		String array = "";
		while (index < numbers.length) {
			array = array + numbers[index] + " ";
			index++;
		}
		println(array);
		return array;
	}

	static void selectionSort(int[] numbers) {
		/* To sort an array by searching the highest number and swapping it to the end
		 * and searching the lowest number and swapping it to the beginning*/

		int index = 0, end = numbers.length - 1, run = 0, swap = 0, compare = 0;
		
		while (index <= end) {
			
			int max = index, i = index + 1, min = end;
			
			while (i <= end) {
				if (numbers[i] > numbers[max])
					max = i;
				i++;
				compare++;	
			}
			
			if (numbers[max] > numbers[i-1]) {
				swap(numbers, max, end);
				swap++;
			}
			
			end--;
			i = end - 1;
	
			while (i >= index) {
				if (numbers[i] < numbers[min])
					min = i;
				i--;
				compare++;	
			}
			
			if (numbers[min] < numbers[++i]) {
				swap(numbers, min, index);
				swap++;
			}
			
			index++; 
			run++;
			print("nach dem " + run + ". Durchlauf -> ");
			printArray(numbers);
			
		}

		println();
		println(compare + ", " + swap);
	}


	public static void main(String[] args) {
		
		//Vertauschungen und Vergleiche stimmern nicht

//		int[] numbers = {20 , 48, 77, 24, 13, 2, 11, 50, 85, 36,61};
		int[]F;
		
//		printArray(numbers);
//		selectionSort(numbers);

		//F = new int[] { 10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32,
				//23, 19, 7, 6, 14, 29 }; // "zufälliges" Feld
		//TODO: Soll 220, 17
	//	F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // array already sorted
		//50 vertauschungen!!!
		F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; // array sorted in reverse
		//
//		F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};	// partially presorted
//		F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1}; // sorted but last element
//		F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5}; // first half sorted, second half sorted
//		F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // sorted but first and last element
//		F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
//		F = new int[] {1};

		selectionSort(F);
	}
}
