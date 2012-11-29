package blatt3.g303;

//Gruppe 3-3: 1230485 Marc Misoch, 1226580 Marcel Ortega, 1229645 Dominik Foos

//Aufgabe3b

import static gdi.MakeItSimple.*;

public class BinaryInsertion {
  
	public static int zahlervergleiche = 0, zahlervertauschungen = 0, anzahl = 4096;
	public static void main (String[] args){
		
		int[] array = new int[anzahl];
		for (int i = 0; i< array.length; i++)
			array[i] = (int) Math.floor(Math.random()*anzahl);
		BinaryInsertionSort(array, array.length);
		for (int i=0; i < array.length; i++){
			print(array[i] + " ");
			

		}print("\nvergleiche: "  + "\t"+ zahlervergleiche + "\n" + "vertauschungen: "  + zahlervertauschungen);
	}
	
	
	
	public static void BinaryInsertionSort(int array[],int n){
        for (int i=0;i<n;++i){
            int temp=array[i];
            int left=0;
            int right=i;
            while (left<right){
                int middle=(left+right)/2;
                zahlervergleiche++;
                if (temp>=array[middle]){
                    left=middle + 1;
                }else{
                	right=middle;
                }
            }
            
            for (int j=i;j>left;--j){
            	zahlervertauschungen++;
            	int k=array[j-1];
                 array[j-1]=array[j];
                 array[j]=k;
            }
        }
    }
}
