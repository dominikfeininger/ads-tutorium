package blatt3.g305;
import static gdi.MakeItSimple.*;

public class aufgabe01 {
	
	//Aufgabe 1a)
	static int linearSearchA(int[] array, int value){
	//returns the indes of value at last sucess
		int pos = -1;
		for(int i=0;i<array.length;i++){
			if(array[i]==value){
				pos=i;
			}
		}
		return pos;
	}
	
	//Aufgabe 1b)
	static int linearSearchB(int[] array, int value){
	//returns the index of the value at first sucess
		for(int i=0;i<array.length;i++){
			if(array[i]==value){
				return i;
			}
		}
		return -1;
	}
	
	//Aufgabe 1c)
	static int binarySearchRecursive(int[] array, int value, int small, int large) {
		//recursive funktion, the lower border and the upper border are parameters
		int half = small + (large-small) / 2; 
		if (value == array[half]) {
			return half;//if value equals the half, sucess
		} 
		else {
			//if lower border quals upper border no value found
			if (small == large){
				return -1;
			} 
			else {
				//if value is lower than half, half is set as new upper border
				//and function searches in the lower half
				if (  value < array[half]) {
	                return binarySearchRecursive(array, value, small, half );
				}
				//else half+1 is set as lower border, and function searches in
				//the upper half
				else {
					return binarySearchRecursive(array, value, half+1, large);
	            }
			}
		}
	}
	 
	static int binarySearchRecursive(int[] array, int value) {
	    //first callup of the recursive binary search
		return binarySearchRecursive(array, value, 0, array.length - 1);
	}
	
	//Aufgabe 1d)
	static int binarySearchIterative(int[] array, int value){
		int small = 0, large = array.length - 1;
		while (small <= large) {
			int half = (small + large) / 2;
			if (array[half] == value) return half; //value found!
			else if (value < array[half]){
				large = half-1; //searches in the lower half
			}
			else{
				small = half+1; //searches in the upper half
			}
		}
		return -1;//if no value found, -1 is returned
	}
	
	public static void main(String[] args){
		int value;
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		println("Geben Sie bitte den gesuchten Wert ein:");
		value=readInt();
		println(linearSearchA(array,value));
		println(linearSearchB(array,value));
		println(binarySearchRecursive(array,value));
		println(binarySearchIterative(array,value));
	}
}
	

