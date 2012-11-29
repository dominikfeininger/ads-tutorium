package blatt3.g303;

//Gruppe 3-3: 1230485 Marc Misoch, 1226580 Marcel Ortega, 1229645 Dominik Foos
//Aufgabe1

import static gdi.MakeItSimple.*;
public class SearchAlgorythms {
	static int ergebnisse = 0;
	static int anzahl = 4096;
	
	public static void main (String[]args){
		int[] Array = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,3,19,20,};
	
		
		//println(lineareSuchekurzB(Array,3));
		//println(lineareSuchelangA(Array,3));
		//println(binarySearchD(Array,20));
		//println(binarySearchC(Array,20,0,Array.length));
	}

	public static int lineareSuchekurzB(int[] suche, int suchnummer){
		for (int i = 0;i < suche.length; i++){
			if (suche[i] == suchnummer){
				return i;
			}
		}
	
	return -1;
	}
	
	public static int lineareSuchelangA(int[] suche, int suchnummer){
		int zahler = -1;
		
		for (int i = 0;i < suche.length; i++){
			if (suche[i] == suchnummer){
				zahler = i;
			}
			
		}
		return zahler;	
	}
	
	public static int binarySearchD(int [] array, int suchnummer) {
		int u = 0, o = array.length - 1;
		
		while (u <= o) {
			int m = (u + o) / 2;
			if (array[m] == suchnummer){
				return m; 
			} else if (suchnummer < array[m]){
				o = m-1;
			} else {
				u = m+1; 
			}
			
		}
		return -1;
	}

	public static int binarySearchC(int[] array, int suchnummer, int u, int o){
		if(u <= o) {
			int m = (u + o) / 2;
			if(array[m] == suchnummer) {
				return m;
			} else if(suchnummer < array[m]) {
				return binarySearchC(array, suchnummer, u, --m);
			} else {
				return binarySearchC(array, suchnummer, ++m, o);
			}
		} else {
			return -1;
		}
	}
	
	
}
