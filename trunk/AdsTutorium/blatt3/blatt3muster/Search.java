package blatt3muster;

import static gdi.MakeItSimple.*;

public class Search {
	
	static int linearSearch (int [] array, int key) {
		
		// linear search for key in sequence array
		// return the index of key - if key is in sequence
		// returns -1 if key is not found
		
		int l = 0;
		
		while (l <= array.length-1) {
		  if (array [l] == key) return l; // key found
		  l++;
		}
		  
		return -1;
	}
	
	static int linearSearchL (int [] array, int key) {
		
		// linear search for key in sequence array
		// return the last index of key in array - if key is in sequence
		// doublets are allowed
		// returns -1 if key is not found
	
		int idx = -1;
		for (int i = 0; i < array.length; i++)  
			if (array [i] == key) idx = i; // key found

		  
		return idx;
	}

	static int binarySearch (int [] array, int key) {
		// binary search for key in sequence array
		// return the index of key - if key is in sequence
		// returns -1 if key is not found
		
		int l = 0;
		int r = array.length-1;
	    int m;
		
		while (l <= r) {
		  m = (l + r)/2;
		  if (array [m] == key) return m; // key found
		  else if (key > array [m]) l = m+1; // search in right part
		  else r = m-1; // search in left part
		}
		  
		return -1;
	}

	static int binarySearchRec (int [] array, int key, int u, int o) {
		// recursively binary search for key in sequence array
		// return the index of key - if key is in sequence
		// returns -1 if key is not found
		
		  if (u > o) return -1;
		  if (array [(u+o)/2] == key) return (u+o)/2; // key found
		  else if (key > array [(u+o)/2]) return binarySearchRec (array, key, (u+o)/2+1, o); // search in right part
		  else return binarySearchRec (array, key, u, (u+o)/2-1); // search in left part
	}
	
	
	public static void main(String[] args) {
		int [] F = {6,55,12,18,42,55,55,44,55,67,94};   // fix array 
		  int key, idx;
		  char c = 'n';
		  
		  do {
		  	print ("SuchschlŸssel: ");
		  
		    key = readInt();
		  
		    if ((idx =  binarySearch (F, key)) < 0)
		      println (key + " not found in array");
		    else
		      println (key + " found at index " + idx);

		    if ((idx =  binarySearchRec (F, key, 0, F.length-1)) < 0)
			      println (key + " not found in array");
			    else
			      println (key + " found at index " + idx);
		    
		    if ((idx =  linearSearch (F, key)) < 0)
			      println (key + " not found in array");
			    else
			      println (key + " found at index " + idx);
		    
		    if ((idx =  linearSearchL (F, key)) < 0)
			      println (key + " not found in array");
			    else
			      println (key + " found at index " + idx);

		    
		    print ("continue search (y/n)?");

		    c = readChar();  // 2 x char lesen, um Zeilenumbruch zu Ÿberlesen - wg. MakeItSimple 
		    
		    c = Character.toLowerCase(readChar());
		    
		  } while (c == 'y');
		  
		  
	}
}	
	
