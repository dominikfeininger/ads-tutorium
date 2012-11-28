package blatt3.g307;
import static gdi.MakeItSimple.*;

public class B3G37 {

	public static int zählervertauschungen = 0;
	public static int zählervergleiche = 1;
	public static int versuche1 = 0;
	
	// Sequentially search from behind | Task 1a
	static int searchA( int [] array, int key )
	{
		for( int i = array.length -1; i < array.length; i-- )
		{
			if( array[i] == key )
			{
				return i;
			}
		}
		return -1;
	}
	
	// Sequentially search from the beginning | Task 1b
	static int searchB( int [] array, int key )
	{
		int i=0;
		while(  i < array.length )
		{
			if( array[i] == key )
			{
				return i;
			}
			i++;
		}
		return -1;
	}
	
	// Recursive binary search | Task 1c
	static int searchC( int[] array, int key, int u, int o )
	{
		if( u <= o )
		{
			int m = (u + o) / 2;
			if( array[m] == key )
			{
				return m; // found
			}
			else if( key < array[m])
			{
				return searchC(array,key,u,--m);  // search in the lower half
			}
			else
			{
				return searchC(array,key,++m,o);   // search in the upper half
			}
		}
		else
		{
			return -1;
		}
	}
	
	// Binary search iterative | Task 1d
	static int searchD( int [] array, int key )
	{
		int u=0, o=array.length - 1;
		while (u <= o)
		{
			int m = (u + o) / 2;
			
			if( array[m] == key )
			{
				return m; // found
			}
			else if ( key < array[m] )
			{
				o = m-1; // search in the lower half
			}
			else
			{
				u = m+1; // search in the upper half
			}
		}
		return -1;
	}
		
	// Linearly search form behind | Task 2
	static int suchVersucheA( int [] array, int key )
	{
		int i = array.length-1, versuche=1;
		while(  i > 0 )
		{
			if( array[i] == key )
			{
				return versuche;
			}
			versuche++;
			i--;
		}
		return versuche;
	}
	
	// Linearly search form the beginning | Task 2
	static int suchVersucheB( int [] array, int key )
	{
		int i=0, versuche=1;
		while( i < array.length )
		{
			if( array[i] == key)
			{
				return versuche;
			}
			i++;
			versuche++;
		}
		return -1;
	}
	
	// Binary search iterative | Task 2
	static int suchVersucheD( int [] array, int key )
	{
		int u=0, o=array.length - 1, versuche=1;
		while (u <= o)
		{
			int m = (u + o) / 2;
			
			if( array[m] == key )
			{
				return versuche; // found !
			}
			else if ( key < array[m] )
			{
				o = m-1; // search in the lower half
			}
			else
			{
				u = m+1; // search in the upper half
			}
			versuche++;
		}
		return versuche;
	}
	
	// Recursive binary search | Task 2
	static int suchVersucheC( int[] array, int key, int u, int o )
	{
		if( u <= o )
		{
			versuche1++;
			int m = (u + o) / 2;
			if( array[m] == key )
			{ 
				return versuche1; // found
			}
			else if( key < array[m])
			{
				return suchVersucheC(array,key,u,--m);  // search in the lower half
			}
			else
			{
				return suchVersucheC(array,key,++m,o);  // search in the upper half
			}
		}
		else
		{
			return versuche1;
		}
	}
	
	// Task 3 | InsertionSort
	static void insertionSort(int [] array)
	{
		int vertauschen=0, vergleichen=0;
		for (int i = 1; i < array.length; i++)
		{
			int j = i;
			int m = array[i];
			while (j > 0 && array [j-1] > m)
			{
				array [j] = array [j-1];
				j--;
				vergleichen++;
			}
			array[j] = m;
			vertauschen++;
		}
		print("anzahl vertauschungen: " + vertauschen + "\nanzahl vergleiche: " + vergleichen + "\n");
	}

	static void insertionSortVorlseung(int [] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			int j = i, m = array[i]; // Marker-Feld
			while (j > 0 && array [j-1] > m)
			{
				array [j] = array [j-1];
				j--;
			}
			array[j] = m;
		}
	}

	// Task 4 | Shakersort
 	public static void shakerSort(int[] intArr)
 	{ 
    	int k = 0;
        int i = 0, length = intArr.length; 
        while (i < length)
        { 
        	for (int j = i; j < length - 1; j++)
        	{ 
        		zählervergleiche++;
        		if (intArr[j] > intArr[j + 1])
        		{ 
        			zählervertauschungen++;
        			k = intArr[j]; 
                    intArr[j] = intArr[j + 1]; 
                    intArr[j + 1] = k; 
                } 
        	} 
            length--; 
            for (int j = length - 1; j >= i; j--)
            { 
            	zählervergleiche++;
            	if (intArr[j] > intArr[j + 1])
            	{ 
            		zählervertauschungen++;
            		k = intArr[j]; 
                    intArr[j] = intArr[j + 1]; 
                    intArr[j + 1] = k; 
                } 
            }  
            i++; 
        }
        print("\nvergleiche: " + zählervergleiche + "\n" + "vertauschungen: " + zählervertauschungen+ "\n");
    }
	
	public static void main( String[] arg)
	{
		//int[] Array = new int [1024];
		//int[] Array = new int [2048];
		int[] Array = new int [4096];
		int druchschnitt=0, i=0;
		while( i < Array.length )
		{
			Array[i] = (int) Math.floor(Math.random()*Array.length);
			i++;
		}
		int key = readInt();
		//int key = (int) Math.floor(Math.random()*Array.length);
/*
		// ~~~~~~Task 1~~~~~~
		println( "Gesuchter Key: "+key+", befindet sich an der Position: " +searchA(Array,key) );
		println( "Gesuchter Key: "+key+", befindet sich an der Position: " +searchB(Array,key) );
		println( "Gesuchter Key: "+key+", befindet sich an der Position: " +searchC(Array,key,0,Array.length) );
		println( "Gesuchter Key: "+key+", befindet sich an der Position: " +searchD(Array,key) );
		// ~~~~~~Task 2~~~~~~
		println( "Versuche: " +suchVersucheA(Array,key)+", beim Key: "+key );
		println( "Versuche: " +suchVersucheB(Array,key)+", beim Key: "+key );
		println( "Versuche: " +suchVersucheC(Array,key,0,Array.length)+", beim Key: "+key );
		println( "Versuche: " +suchVersucheD(Array,key)+", beim Key: "+key );
*//*
		// ~~~~~~Task 3&4~~~~~~
		//int[] sotierArray = {21312,12,312,11,23,20,7,3,1,123,42342};
		//insertionSort(Array);  			// sort the "Array"
		shakerSort(Array);
		int b=0;
		println("neu sortiertes Array:");
		while( b < Array.length ) 	// print the new Sortet Array
		{
			print(" "+Array[b]);
			b++;
		}
*//*
		print("\n\n");
		for( int t=0; t < 100 ; t++)	// makes middle with different Keys
		{
			int key = (int) Math.floor(Math.random()*Array.length);
			druchschnitt += suchVersucheA(Array,key);
			
		}
		
		println("Durchschnitt: "+druchschnitt/100);  // prints the middle
*/
	}
}
