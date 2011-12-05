package gruppe_2_10;

public class ShellSort {
	  private long[] data;
	 
	  private int len;
	 
	  public ShellSort(int max) {
	    data = new long[max];
	    len = 0;
	  }
	 
	  public void insert(long value){
	    data[len] = value;
	    len++;
	  }
	 
	  public void display() {
	    System.out.print("Data:");
	    for (int j = 0; j < len; j++)
	      System.out.print(data[j] + " ");
	    System.out.println("");
	  }
	 
	  public void shellSort() {
	    int inner, outer;
	    long temp;
	    //find initial value of h
	    int h = 1;
	    while (h <= len / 3)
	      h = h * 3 + 1; 
	 
	    while (h > 0)
	    {
	      // h-sort the file
	      for (outer = h; outer < len; outer++) {
	        temp = data[outer];
	        inner = outer;
	        while (inner > h - 1 && data[inner - h] >= temp) {
	          data[inner] = data[inner - h];
	          inner -= h;
	        }
	        data[inner] = temp;
	      }
	      h = (h - 1) / 3; // decrease h
	    }
	  }
	 
	  public static void main(String[] args) {
		  
		//int[] F = new int[40];
			//int[] F = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			//int [] F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//			# Vergleiche: 106  # Vertauschungen: 68	
//			int [] F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//			# Vergleiche: 23  # Vertauschungen: 0		
	  	int [] F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//			# Vergleiche: 32  # Vertauschungen: 18
//			int [] F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//			# Vergleiche: 34  # Vertauschungen: 21
//			int [] F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//			# Vergleiche: 23  # Vertauschungen: 0
	    int maxSize = 4;
	    ShellSort arr = new ShellSort(maxSize);
	    
	    int x = 1;
	    	if (x == 1) {
	  	      long n = (int) (9);
		      arr.insert(n);
		      x++;
	    	}
	    	if (x == 2) {
	  	      long n = (int) (7);
		      arr.insert(n);
		      x++;	
	    	}
	    	if (x == 3){
	  	      long n = (int) (4);
		      arr.insert(n);
		      x++;
	    	}
	    	if (x == 4){
	  	      long n = (int) (1);
		      arr.insert(n);
		      x++;
	    	}
	    	
	    arr.display();
	    arr.shellSort();
	    arr.display();
	  }
}