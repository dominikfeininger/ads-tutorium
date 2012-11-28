package blatt3.g303;

//Gruppe 3-3: 1230485 Marc Misoch, 1226580 Marcel Ortega, 1229645 Dominik Foos
//Aufgabe4

import static gdi.MakeItSimple.*;

public class ShakerSort { 

	public static long zählervergleiche = 0, zählervertauschungen = 0, anzahl = 1024;
	
	public static void main (String[] args){
		int[] array = new int[(int)anzahl];
		
		for (int i = 0; i< array.length; i++)
			array[i] = (int) Math.floor(Math.random()*anzahl);
		
		sort(array);
		
		for (int i=0; i < array.length; i++)
			print(array[i] + " ");
		
		print("\nvergleiche: " + "\t" + zählervergleiche + "\n" + "vertauschungen: " + zählervertauschungen);
	}
	
	public static void sort(int[] intArray){ 
    	int k = 0;
        int i = 0, length = intArray.length; 
        
        while (i < length) { 
        	for (int j = i; j < length - 1; j++) { 
        		zählervergleiche++;
        		if (intArray[j] > intArray[j + 1]) { 
        			zählervertauschungen++;
        			
        			printArray(intArray, j, j + 1);
        			println();
        			
        			k = intArray[j]; 
        			intArray[j] = intArray[j + 1]; 
        			intArray[j + 1] = k; 
                } 
            }
        	 
            length--; 
            
            for (int j = length - 1; j >= i; j--) { 
            	zählervergleiche++;
            	if (intArray[j] > intArray[j + 1]) { 
            		zählervertauschungen++;
            		
            		printArray(intArray, j, j + 1);
            		println();
            		
            		k = intArray[j]; 
                    intArray[j] = intArray[j + 1]; 
                    intArray[j + 1] = k; 
                }
            }
        }
    }
	
	private static void printArray(int[] array, int n, int j) {
		for(int i = 0; i < array.length; i++) 
			if(n == i || j == i)
				print("[" + array[i] + "] ");
			else
				print(array[i] + " ");
	}
}
