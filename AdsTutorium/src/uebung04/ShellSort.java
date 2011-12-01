package uebung04;
import static gdi.MakeItSimple.*;
public class ShellSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4,8,1,9,6,3,7,2,5,18,100,18}; 
		// initialize test array
		println("initialarray");
		for (int i = 0; i < array.length; i++) {
			print(array[i] + ", ");
		}
		println("");
		shellSort(array); 
	}
	public static void printArray(int[] a) {
		int i2 = 0; 
		// variable for print loop
		while (i2 < a.length) { 
			// print array
			print(a[i2] + ", ");
			i2++;
		}
	}
	public static void shellSort(int[] a) {
		int n;
		n = a.length;
		int i, j, k, h, t, swaps = 0, compares = 0;
		int cols[] = {9, 7, 4, 1 }; 
		// series of h
		for (k = 0; k < cols.length; k++) {
			h = cols[k];
			println(" ");
			println("actuell column width :" + h);
			for (i = h; i < n; i++) {
				j = i;
				t = a[j];
				while (j >= h) { 
					// insert sort
					compares++;
					if(a[j - h] > t) {
						a[j] = a[j - h];
						swaps++;
						j = j - h;
					}else{
						break;
					}
				}
				a[j] = t;
				printArray(a);
				println("");
			}
		}
		println("");
		println("compares:" + compares);
		println("");
		println("swaps: " + swaps);
		println("");
		println("end sort");
		printArray(a);
	}
}