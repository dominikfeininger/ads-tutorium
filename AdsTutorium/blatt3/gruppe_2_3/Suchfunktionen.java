package gruppe_2_3;

import static gdi.MakeItSimple.*;

public class Suchfunktionen {
	
	
	
	public static void main(String[] args) {
		// initialize and fill array in ascending order ( 1 to 100 )
		int[] sortedNumbers = new int[100];
		fillArray(sortedNumbers);
		
		int first = 0;
		int last = sortedNumbers.length - 1;
		
		int searched = 0;
		
		// Input
		println("Enter a Digit to search for [ Type Integer ]:  ");
		searched = readInt();
		readLine();
		
		// Search
		int linearLast = linearLastIndex(sortedNumbers, searched);
		int linearFirst = linearFirstIndex(sortedNumbers, searched);
		int binaryRecursive = binarySearchRecursive(sortedNumbers, searched, first, last);
		int binaryIterative = binarySearchIterative(sortedNumbers, searched);
		
		println("Linear Search ( Last Index)");
		if(linearLast == -1){
			println("digit not found!");
		}else{
			println("Searched digit at index: "+linearLast);
		}
		println("Linear Search ( First Index)");
		if(linearFirst == -1){
			println("digit not found!");
		}else{
			println("Searched digit at index: "+linearFirst);
		}
		println("Binary Search ( Recursive )");
		if(binaryRecursive == -1){
			println("digit not found!");
		}else{
			println("Searched digit at index: "+binaryRecursive);
		}
		println("Binary Search ( Iterative )");
		if(binaryIterative == -1){
			println("digit not found!");
		}else{
			println("Searched digit at index: "+binaryIterative);
		}
	
		
	}
	static int linearLastIndex(int[] array, int searched){
		int i = 0;
		int found = -1;
		while(i < array.length){
			if(searched == array[i]){
				found = i;
			}
			i++;
		}
		return found;
	}
	
	static int linearFirstIndex(int[] array, int searched){
		int i = 0;
		int found = -1;
		while(i < array.length){
			if(searched == array[i])
				return i;
			i++;
		}
		
		return found;
	}
	
	static int binarySearchRecursive(int[] array, int searched,int first, int last){
		if( last < first){
			return -1;
		}
		int mid = first + ( last - first) / 2;
		if( array[mid] > searched){
			return binarySearchRecursive(array, searched, first, mid-1);
		}else if( array[mid] < searched ){
			return binarySearchRecursive(array, searched, mid+1, last);
		}else{
			return mid;
		}
	}
	
	static int binarySearchIterative(int[] array, int searched){
		int mid = array.length / 2;
		int first = 0;
		int last = array.length-1;
		
		while( array[mid] != searched && first <= last ){
			mid = (first + last) / 2;
			if(searched == array[mid]){
				return mid;
			}
			if(searched < array[mid]){
				last = mid - 1; 
				
			}
			if(searched > array[mid]){
				first = mid + 1;
			
			}
		}
		
		return -1;
	}
	
	
	static void fillArray(int[] array) {
		// fill given Array in ascending order via side effect
		int i = 0;
		int number = 1;
		while (i < array.length) {
			if ((int) Math.floor(Math.random() * Integer.MAX_VALUE) % 2 == 0) {
				number = number + (int) Math.floor(Math.random() * 5);
				array[i] = number;

			} else {
				number++;
				array[i] = number;
			}
			i++;
		}
	}
	
}


