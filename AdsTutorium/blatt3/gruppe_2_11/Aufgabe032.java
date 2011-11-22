package gruppe_2_11;

import static gdi.MakeItSimple.*;

public class Aufgabe032 {
	
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
		
		while (index < end) {
			
			int max = index, i = index + 1, min = end;
			
			while (i <= end) {
				if (numbers[i] > numbers[max])
					max = i;
				i++;
				compare++;	
			}
			
			if (numbers[max] > numbers[--i]) {
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

		int[] numbers = {20 , 48, 77, 24, 13, 2, 11, 50, 85, 36,61};
		
		printArray(numbers);
		selectionSort(numbers);
	}
}
