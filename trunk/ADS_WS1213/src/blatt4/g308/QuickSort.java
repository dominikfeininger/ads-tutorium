/*
Fabienne Seitz, Matr.Nr: 1220109

Michelle Bauer, Matr.Nr: 1230289

Brice Tsakeng Tontsa, Matr.Nr: 1228123
 */

package blatt4.g308;

import static gdi.MakeItSimple.*;

public class QuickSort {
	
	public static void printIntAray(int[] ausgabe){
		int i = 0;
		while(i < ausgabe.length){
			if(i == 0){
				print(ausgabe[i]);
			}else{
				print(", " + ausgabe[i]);
			}
			i++;
		}
		println();
	}
	
	/**
	 * The method quickSort divides the array (with the method zerlegen)
	 * @param eingabe the array which we will be sorted.
	 * @param min the lower index.
	 * @param max the upper index.
	 */
	
	public static void quickSort(int[] eingabe,int min,int max){
		if(min<max){
			int i = zerlegen(eingabe,min,max);
			quickSort(eingabe,min,i-1);
			quickSort(eingabe,i+1,max);
		}
	}
	
	/**
	 * The method "zerlegen" takes a pivo element, puts it to the right place
	 * and puts all bigger numbers above and all lower numbers down.
	 * @param eingabe the array which we will be sorted.
	 * @param min the lower index.
	 * @param max the upper index.
	 * @return index returns the index of the pivo element
	 */
	
	public static int zerlegen(int[] eingabe,int min,int max){
		int p = max;
		int index = min;
		for(int zeiger = min;zeiger<=max-1;zeiger++){
			if(eingabe[zeiger]<=eingabe[p]){
				swap(eingabe,index,zeiger);
				index++;
			}
		}
		swap(eingabe,index,p);
		return index;
	}
	
	/**
	 * The method swap swaps the content of two indexes.
	 */
	
	public static void swap(int a[],int i,int j){
        int k=a[i];
        a[i]=a[j];
        a[j]=k;
    }
	public static void main(String[] args){
		int i = 10;
		int[] eingabe = new int[i];
		for (int j= 0;j<eingabe.length;j++){
			eingabe[j] = (int) Math.floor(Math.random()*9999);
		}
		printIntAray(eingabe);
		quickSort(eingabe,0,eingabe.length-1);
		printIntAray(eingabe);
	}

}
