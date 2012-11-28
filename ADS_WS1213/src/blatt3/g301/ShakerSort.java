package blatt3.g301;

import static gdi.MakeItSimple.*;

public class ShakerSort {
	static void ShakerSort (int array[]) { 
	    boolean swapped; 
	    int swap=0 , comparison=0;
	do { 
	      swapped = false; 
	      for (int arrayIndex = 0; arrayIndex < array.length - 1; arrayIndex++) { 
	        if (array [arrayIndex] > array [arrayIndex+1]) { 
	        	comparison++;
	          swap (array, arrayIndex, arrayIndex+1); // swap the elements in the array 
	          swap++;
	          swapped = true; 
	        } 
	        else{
	        	comparison++;
	        }
	        for (int arrayIndexBack = array.length-1; arrayIndexBack > 0; arrayIndexBack--){
	        	if (array[arrayIndexBack] < array[arrayIndexBack-1]){
	        		comparison++;
	        		swap(array,arrayIndexBack-1,arrayIndexBack);
	        		swap++;
	        		swapped=true;
	        	}
	        	else{
	        		comparison++;
	        	}
	        }
	      } 
	    } while (swapped); // aslong as it is swapping. 
	println("It was swapped "+swap+" times");
	println("It was compared "+comparison+" times");
	  }
	
	static void swap (int [] array, int idx1, int idx2) 
	// method for swapping the elements in the array. 
	 { 
	    int tmp = array[idx1]; 
	    array[idx1] = array[idx2]; 
	    array[idx2] = tmp; 
	  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] , i =0, arraylength=0;
		println("Bitte geben Sie die größe des Arrays ein.");
		arraylength = readInt();
		array = new int [arraylength];
		while(i < array.length){
			array[i] = (int) Math.floor(Math.random()*arraylength);
			i++;
		}
		ShakerSort(array);
	}

}
