package gruppe_2_11;

import static gdi.MakeItSimple.*;
//TODO: Kommentare!!!
public class Aufgabe04 {
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

	static String ShakerSort(int[] numbers){
		/* To sort an array by checking the array 
		 * from the front to the back and then 
		 * from the back to the front*/
		int index = 0, swap = 0, compare = 0;
		String result = "";
		boolean swapped = true;
		
		while (swapped == true){
			swapped = false;
			println("*" + printArray(numbers) + "*");
			while (index < numbers.length -1){
				if (numbers[index] > numbers[index + 1]){
					swap(numbers, index, index + 1);
					swapped = true;
					swap++;
					compare++;
					index++;
					printArray(numbers);
				}
				else{
					compare++;
					index++;
				}
			}
			
			while (index > 0){
				if (numbers[index] < numbers[index - 1]){
					swap(numbers, index, index - 1);
					swapped = true;
					swap++;
					compare++;
					index--;
					printArray(numbers);
				}
				else{
					compare++;
					index--;
				}
			}
		}
		
		return result + swap + ", " + compare;
	}

	public static void main(String[] args) {
		//TODO. vgl doppel so hoch!!!
		int[] numbers;// = {7, 5, 1, 3, 6, 4};
		//numbers = new int [] {1,2,3,4,5,6,7,8,9,10};
		//numbers = new int [] {2,3,4,5,6,7,8,9,10,1};
		numbers = new int [] {10,9,8,7,6,5,4,3,2,1};
		//TODO. 45, 45
		printArray(numbers);
		
		System.out.println();
		System.out.println(ShakerSort(numbers));

	}

}
