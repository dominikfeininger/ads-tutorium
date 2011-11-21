package gruppe_2_3;

// Gruppe 2/3
import static gdi.MakeItSimple.*;

public class SelectionSort {

	public static void main(String[] args) {

		/*
		 * Testing Arrays 
		 * int [] unsorted = { 200, 111 , 777 , 888 , 99 , 111 };
		 * int [] unsorted = { 5, 55 ,4 ,7 ,8, 97874, 8, 7 ,6881 }; 
		 * int [] unsorted = { 89464, 8946, 684666, 678, 68768, 68768, 978 }; 
		 * int [] unsorted = { 57, 0, 684, 987812, 54887, 4, 4 };
		 */

		int[] unsorted = { 9, 20, 5, 8, 77, 55, 33, 548, 789, 1 };

		print("unsorted : ");
		println();
		printArray(unsorted);
		println();

		int[] sorted = selectionSort(unsorted);

		print("sorted : ");
		printArray(sorted);
	}

	static int[] selectionSort(int[] unsortedArray) {

		int[] sortedArray = new int[unsortedArray.length];
		int index = 0;

		// copy array to avoid side effects
		while (index < unsortedArray.length) {
			sortedArray[index] = unsortedArray[index];
			index++;
		}

		index = 0;
		int minIndex = 0;
		int maxIndex = 0;
		int lowerLimit = 0;
		int upperLimit = sortedArray.length - 1;
		int temp = 0;

		// Effort variables
		int comparisons = 0;
		int swappings = 0;

		while (upperLimit >= lowerLimit) {
			// search for max

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			index = lowerLimit;

			while (index <= upperLimit) {
				if (sortedArray[index] > max) {
					max = sortedArray[index];
					maxIndex = index;
				}
				index++;
				comparisons++;
			}

			// swap max to last index
			temp = sortedArray[upperLimit];
			sortedArray[upperLimit] = max;
			sortedArray[maxIndex] = temp;
			upperLimit--;
			index = lowerLimit;
			swappings++;

			// search for min
			while (index <= upperLimit) {
				if (sortedArray[index] < min) {
					min = sortedArray[index];
					minIndex = index;
				}
				index++;
				comparisons++;
			}

			// swap min to first index
			temp = sortedArray[lowerLimit];
			sortedArray[lowerLimit] = min;
			sortedArray[minIndex] = temp;
			lowerLimit++;
			swappings++;

			println();
			printArray(sortedArray);

		}
		println();
		println();
		println("needed comparisons: " + comparisons);
		println("needed swappings: " + swappings);
		return sortedArray;
	}

	static void printArray(int[] array) {
		int index = 0;
		// print given array
		while (index < array.length) {
			print(" " + array[index]);
			index++;
		}
	}

}
