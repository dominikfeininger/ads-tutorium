package gruppe_2_4;


import static gdi.MakeItSimple.*;
public class Shellsort {

	
	public static void main(String[] args) {
	
	int[]array = {9,3,2,5,4,7,6,8,0};
	shellsort(array);
	for (int i = 0; i < array.length; i++) {
		System.out.print(array[i] + " ");
	}
	}
	static void shellsort (int [] array){
		int[] step = {5,4,1};
		int vergleiche =0 ;
		for (int i = 0; i < step.length; i++) {
			vergleiche = vergleiche + insertionSort(array, step[i], vergleiche);
		}
		System.out.println(vergleiche+ " Vergleiche");
	}
		
	static int insertionSort (int [] array, int step,int vergleiche) {
		int vertauschen=0;
		for (int h = step; h < array.length; h = h + step) {
			int arrayIndex = h;
			int sortierWert = array[h];
			while (arrayIndex > 0 && array[arrayIndex - step] > sortierWert) {
				// Verschiebe alle größeren Elemente nach hinten
				array[arrayIndex] = array[arrayIndex - step];
				arrayIndex = arrayIndex - step;
				vergleiche++;
				vertauschen++;
				for (int i = 0; i < array.length; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println();

			}
			vergleiche++;
			// Setze m auf das freie Feld
			array[arrayIndex] = sortierWert;
		}
		System.out.println("vertauschen" + vertauschen);
		return vergleiche;
	}
	}

