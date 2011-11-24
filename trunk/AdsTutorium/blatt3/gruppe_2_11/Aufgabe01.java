package gruppe_2_11;

import static gdi.MakeItSimple.*;

public class Aufgabe01 {

static int linearSearch1(int[] numbers, int search) {
	/* To search the array in every element from
	 * the front to the back it ends with the last
	 * element of the array*/
		int index = 0, found = -1;
		while (index < numbers.length) {
			if (numbers[index] == search)
				found = index;
			index++;
		}
		return found;
	}

	static int linearSearch2(int[] numbers, int search) {
		/*To search the array in every element
		 * from he back to the front it ends when
		 * the searched element was found*/
		int index = 0, found = -1;
		while ((index < numbers.length) && (found == -1)) {
			if (numbers[index] == search)
				found = index;
			index++;
		}
		return found;
	}

	static int binarySearchRec(int[] numbers, int search, int index, int indexEnd) {
			
		if (index > indexEnd){    			
			return -1;
		}	
		int indexMiddle = index + ((indexEnd - index) / 2);
		
		if (numbers[indexMiddle] < search){
			return binarySearchRec(numbers, search, index + 1, indexEnd);
		}
		if (numbers[indexMiddle] > search){
			return binarySearchRec(numbers, search, index - 1, indexEnd);
		}
		return indexMiddle;	
		}
	
	static int binarySearchIt(int[] numbers, int search) {
		/* To search the array by halving 
		 * in every step*/
		int index = 0, end = numbers.length - 1,indexMiddle = -1;
		
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
				return -1;
		}
		return indexMiddle;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 5};
		int search = 8, index = 0, indexEnd = numbers.length -1;


		println(linearSearch1(numbers, search));
		println(linearSearch2(numbers, search));
		println(binarySearchRec(numbers, search, index, indexEnd));
		println(binarySearchIt(numbers, search));
	}
}