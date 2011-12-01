package uebung03;
import static gdi.MakeItSimple.*;
public class SelectSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] f = {2, 14, 5, 6, 7, 10, 4, 8, 11, 1, 3, 9, 12, 13};
		//int [] f= {10,1,2,3,4,5,6,7,8,9};
		//int[] f = {10,9,8,7,6,5,4,3,2,1};
		//int[] f= {10,1,9,2,8,3,7,4,5,6};
		int[] f={6,7,8,9,10,1,2,3,4,5};
		int [] array = SelectionSort(f);
		//println("Ergebnis:   " +array);
	}
	static int[] SelectionSort(int[] array) {
		int marker = array.length - 1;
		for (int ii = 0; ii != array.length; ii++){
			while (marker > 0) {
				// Suche größtes Element
				int max = 0; 			// ... das ist zunächst das erste Element
				for (int i = 1; i <= marker; i++) 		// Suche in Restfolge
					if (array [i] > array [max]) 			// größeres Element gef.
						max = i;
				swap (array, marker, max);
				// Tausche array[marker] mit dem gefundenen Element
				int min = 0; 			// ... das ist zunächst das erste Element
				for (int i = 1; i <= marker; i++) 		// Suche in Restfolge
					if (array [i] < array [min]) 			// kleineres Element gef.
						min = i;
				swap (array, marker, min);
				// Tausche array[marker] mit dem gefundenen Element
				marker--;
			}print(+ii+1 +" , ");
		}return array;
	}
	static void swap(int [] array, int idx1, int idx2){
		//Hilfsmethode zum Vertauschen zweier Feldelemente
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp; 
	}
}
