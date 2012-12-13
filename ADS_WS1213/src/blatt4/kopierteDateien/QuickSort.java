package blatt4.kopierteDateien;

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
	public static void quickSort(int[] eingabe,int min,int max){
		if(min<max){
			int i = zerlegen(eingabe,min,max);
			quickSort(eingabe,min,i-1);
			quickSort(eingabe,i+1,max);
		}
	}
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

