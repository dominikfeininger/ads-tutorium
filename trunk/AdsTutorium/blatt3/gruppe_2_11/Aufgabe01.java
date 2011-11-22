package gruppe_2_11;

import static gdi.MakeItSimple.*;

public class Aufgabe01 {

static int linearSearch1(int[] numbers, int search) {
	/* To search the array in every element from
	 * the front to the back it ends with the last
	 * element of the array*/
		int index = 0, found, compare = 0;
		while (index < numbers.length) {
			compare++;
			if (numbers[index] == search)
				found = index;
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

	static int binarySearchRec(int[] numbers, int search, int index, int indexEnd) {
		
		if (index > indexEnd){
			return -1;
		}	
		int indexMiddle = index + ((indexEnd - index) / 2);
		
		if (numbers[indexMiddle] < search){
			return binarySearchRec(numbers, search, index - 1, indexEnd);
		}
		if (numbers[indexMiddle] > search){
			return binarySearchRec(numbers, search, index + 1, indexEnd);
		}
		return indexMiddle;	
	}
	
	static int binarySearchIt(int[] numbers, int search) {
		/* To search the array by halving 
		 * in every step*/
		int index = 0, end = numbers.length - 1,indexMiddle, compare = 0;
		
		while (index <= end){
			indexMiddle = index + ((end -index) / 2);
			
			if (numbers[indexMiddle] > search){
				end = indexMiddle -1;
				compare++;
			}
			else if (numbers[indexMiddle] < search){
				index = indexMiddle + 1;
				compare++;
			}
			else if (numbers[indexMiddle] == search){
				compare++;
				return indexMiddle;
				
			}
		}
		return compare;
	}
	
	public static void main(String[] args) {
		int[] numbers = new int [1024];
		int search = readInt(), index = 0, indexEnd = numbers.length -1;
		for (int i = 0; i<numbers.length; i++) {numbers[i] = i;};

		println(linearSearch1(numbers, search));
		println(linearSearch2(numbers, search));
		println(binarySearchRec(numbers, search, index, indexEnd));
		println(binarySearchIt(numbers, search));
	}
}
