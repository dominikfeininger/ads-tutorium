package blatt3uebung04;

import java.util.Arrays;

public class RunSorts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//init array 
		int[] toSort = {75,74,96,19,32,25,58,31,10,83,7,4,6,9,2,5,8,1,0,3,100,102,101,186,0,9,3,1};
		//print orig. array
		System.out.println(Arrays.toString(toSort));
		//sort
		toSort = SelectionSort.selectionSort(toSort);
		//print sorted
		System.out.println(Arrays.toString(toSort));
	}
}
