package blatt3.loesung;

import static gdi.MakeItSimple.*;


public class DivSearches {
	
	static int sequentialSearchL (int [] array, int key) {
		
		// sequential search: returns the last index of the element found
		
		int idx = -1;
		
		for (int i = 0; i < array.length; i++)
			if (array[i] == key) idx = i;
		
		return idx;
			
	
	}
	
	
	static int sequentialSearchF (int [] array, int key) {
		
		// sequential search: returns the first index of the element found
		
		for (int i = 0; i < array.length; i++)
			if (array[i] == key) return i;
		
		return -1;
			
	
	}
	
	static int binarySearch (int [] array, int key) {
		 
		// iterative version
		
		// searchs for key in sequence array
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
	
	
	static int bsRec (int [] array, int key, int l, int u) {
		
		// recursive search implementation
		
		if (l > u) return -1;
		
		int m = (l+u)/2;
		
		if (array [m] == key) return m;
		else if (key > array [m]) return bsRec (array, key, m+1, u); // search in right part
		else return bsRec (array, key, l, m-1); // search in left part
	}
	

	static int binarySearchRec (int [] array, int key) {
		 
		// recursive version -  >>same<< interface  (therefore we need a separate recursive method)
		
		// searchs for key in sequence array
		// return index of key - if key is in sequence
		// returns -1 if key is not found
		
		int l = 0;
		int r = array.length-1;

		return bsRec (array, key, l, r);
	}
	

	
	
	public static void main(String[] args) {
		
//		  int [] F = {6,12,18,42,44,55,55,67,94};   // Feld darf fest vorgegeben sein
		  int [] F = {6};   // Feld darf fest vorgegeben sein
//		  int [] F = {};   // Feld darf fest vorgegeben sein
		  int key, a, b, idx;
		  char c = 'n';
		  int [] F2;

		  do {
		  	print ("Suchschlüssel: ");
		  
		    key = readInt();
		  
		    if ((idx =  binarySearch (F, key)) < 0)
		    	println (key + " not found in array");
		    else
		    	println (key + " found at index " + idx);
		    
		    if ((idx =  binarySearchRec (F, key)) < 0)
		    	println (key + " not found in array");
			else
				println (key + " found at index " + idx);

		    if ((idx =  sequentialSearchF (F, key)) < 0)
		    	println (key + " not found in array");
		    else
				println (key + " found at index " + idx);

		    if ((idx =  sequentialSearchL (F, key)) < 0)
		    	println (key + " not found in array");
		    else
				println (key + " found at index " + idx);
		      
		    print ("continue search (y/n)?");
		    
		    c = readChar(); // Zum Puffer leeren MakeItSimple
		    c = readChar(); // jetzt erst hat man die richtige Eingabe
			c = Character.toLowerCase(c);
		    
		  } while (c == 'y');
		  
  
	}
}


