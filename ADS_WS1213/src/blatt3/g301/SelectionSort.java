package blatt3.g301;
import static gdi.MakeItSimple.*;
public class SelectionSort {
static void SelectionSort(int array[]){
	int marker = array.length-1;
	while (marker>0) {
		int max=0;
		//println("schleife");
		for (int i =1; i<=marker; i++){
			if (array[i]>array[max]){
				//println(i);
				max=i;
				swap(array,marker,max);
			}
			marker--;
		}
	}
}
static void swap (int array[],int idx1, int idx2){
	int tmp = array[idx1];
	array[idx1] = array[idx2];
	array[idx2] = tmp;
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] , i =0;
		array = new int [10];
		while(i < array.length){
			array[i] = (int) Math.floor(Math.random()*50);
			i++;
		}
		SelectionSort(array);
		i=0;
		while(i< array.length){
			println(array[i]);
			i++;
		}
	}

}
