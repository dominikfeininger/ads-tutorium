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