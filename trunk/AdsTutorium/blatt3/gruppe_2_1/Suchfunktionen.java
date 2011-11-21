package gruppe_2_1;

import static gdi.MakeItSimple.*;

public class Suchfunktionen {

	public static void main(String[] args) {
		
		//						  0		1	2	 3	 4	 5	6	 7	  8	   9	10
		int [] array = {-100, -55, -50, -28, -7, 0, 66, 127, 453, 999, 1000};
		
		print("Search key: ");
		int searchKey = readInt();
		
		println("Result Linear Search (last element): " + linearSearchLastElement(array, searchKey));
		println("Result Linear Search (first element): " + linearSearchFirstElement(array, searchKey));
		println("Result Binary Search (recursive): " + binarySearchIterative(array, searchKey));
		println("Result Binary Search (iterative): " + binarySearchRecursive(array, searchKey, 0, array.length-1));	
	}
	
	static int linearSearchLastElement(int array[], int searchKey) {
		
		// at the beginning you presume, that the searchKey is not in the array
		int indexSearchKey = -1; 
		
		int searchIndex = 0;
		
		while (searchIndex < array.length) {
			
			if (array[searchIndex]==searchKey){
				
				indexSearchKey = searchIndex;	
			}
			searchIndex++;
		}
		
		return indexSearchKey;
	}

	static int linearSearchFirstElement (int array[], int searchKey) {
		
		// at the beginning you presume, that the searchKey is not in the array (=> -1)
		int indexSearchKey = -1;
		
		int searchIndex = 0;
		
		while (searchIndex < array.length){
			
			if (array[searchIndex]==searchKey){
				
				indexSearchKey = searchIndex;
				return indexSearchKey;				
			}
			searchIndex++;
		}
		
		return indexSearchKey;
	}

	static int binarySearchIterative (int array[], int searchKey) {
		
		// at the beginning you presume, that the searchKey is not in the array
		int indexSearchKey = -1;
		
		int lowerBound = 0;	
		int upperBound = array.length-1;
		int middle = 0;
		
		// variable to save the status of the search
		boolean searchKeyFound = false;
		
		// search ends, when the bounds intersect, or when the searchKey was found
		while (lowerBound<=upperBound && !searchKeyFound) {
			
			// calculating the middle
			middle = (lowerBound+upperBound)/2;
			
			if (searchKey == array[middle]) {
				
				indexSearchKey = middle;
				searchKeyFound = true; // abandon search
			}			
			
			// go on in the lower side
			else if (searchKey < array[middle]) {
				
				upperBound = middle-1;	
			}
			
			// go on in the upper side
			else {
				
				lowerBound = middle+1;
			}
		}
		
		return indexSearchKey;
	}

	// The lower and upper bounds have to be given to the method, 
	// because they change with the number of callings
	static int binarySearchRecursive (int array[], int searchKey, int lowerBound, int upperBound) {
		
		// calculating the middle
		int middle = (lowerBound+upperBound)/2;
		
		if (searchKey==array[middle])
			return middle; // searchKey found
		
		// go on in the lower side
		else if (searchKey < array[middle] && lowerBound<=upperBound)
			// recusive calling with middle-1 as upperBound
			return binarySearchRecursive(array, searchKey, lowerBound, middle-1);
			
		// go on in the upper side
		else if (searchKey > array[middle] && lowerBound<=upperBound)
			// recusive calling with middle+1 as lowerBound
			return binarySearchRecursive(array, searchKey, middle+1, upperBound);
		
		// searchKey is not in the array
		else
			return -1;
	}

}
