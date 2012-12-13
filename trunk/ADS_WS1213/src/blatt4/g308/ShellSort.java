
/*
Fabienne Seitz, Matr.Nr: 1220109

Michelle Bauer, Matr.Nr: 1230289

Brice Tsakeng Tontsa, Matr.Nr: 1228123
 */
package blatt4.g308;

import static gdi.MakeItSimple.*;

public class ShellSort {
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
	
	
	public static void shellSort (int[] a){
		int n = a.length;
	    int i, j, k, h, t;
	 
	    int[] spalten = {9,7,4,1};
	 
	    for (k=0; k<spalten.length; k++)
	    { 
	        h=spalten[k];
	        // Sort the gabs with an insertionsort algorithm.
	        for (i=h; i<n; i++)
	        { 
	            t=a[i];
	            j=i;
	            while (j>=h && a[j-h]>t)
	            {
	                a[j]=a[j-h];
	                j=j-h;
	            }
	            a[j]=t;
	        }
	    }
	}
	public static void main(String[] args) {
		int i = 10;
		int[] eingabe = new int[i];
		for (int j= 0;j<eingabe.length;j++){
			eingabe[j] = (int) Math.floor(Math.random()*9999);
		}
		printIntAray(eingabe);
		shellSort(eingabe);
		printIntAray(eingabe);
	}

}
