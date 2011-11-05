package blatt3uebung4;

public class SelectionSort {
	
	//SelectionSort
	public static int[] selectionSort(int[] toSort){
		int n = toSort.length;
		int left = 0;
		int min, tmp;
		//whole array
		while (left < n){
			min = left;
			//find two item to change
			for (int i = left; i<n; i++){
				//change
				if(toSort[i]<toSort[min]){
					min = i;
				}
			}
			//shift
			tmp = toSort[min];
			toSort[min] = toSort[left];
			toSort[left] = tmp;
			//go one step "right"
			left++;
		}
		return toSort;
	}
}


//PSEUDOCODE
//prozedur SelectionSort( A : Liste sortierbarer Elemente ) 
//n = Länge( A )
//links = 0
//wiederhole
//  min = links
//  für jedes i von links + 1 bis n wiederhole 
//    falls A[ i ] < A[ min ] dann
//        min = i
//    ende falls
//  ende für
//  Vertausche A[ min ] und A[ links ]
//  links = links + 1
//solange links < n
//prozedur ende
