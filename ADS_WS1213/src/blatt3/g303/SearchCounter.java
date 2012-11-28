package blatt3.g303;

//Gruppe 3-3: 1230485 Marc Misoch, 1226580 Marcel Ortega, 1229645 Dominik Foos
//Aufgabe2

import static gdi.MakeItSimple.*;

public class SearchCounter {
	static int zähler1 = 0;
	static int anzahl = 1024;
	static int ergebnisA = 0;
	static int ergebnisB = 0;
	static int ergebnisC = 0;
	static int ergebnisD = 0;
	
	public static void main(String[] args) {
		int[] array = createArray(anzahl);
			
		for(int i = 0; i < 500; i++) {
			ergebnisA += lineareSuchelangA(array,(int) Math.floor(Math.random()*anzahl));
			ergebnisB += lineareSuchekurzB(array,(int) Math.floor(Math.random()*anzahl));
			ergebnisC += binarySearchC(array,(int) Math.floor(Math.random()*anzahl), 0 , array.length);
			ergebnisD += binarySearchD(array,(int) Math.floor(Math.random()*anzahl));
		}
			
		//println(ergebnisA / 500);
		//println(ergebnisB / 500);
		//println(ergebnisC / 500);
		//println(ergebnisD / 500);
		
			
		}

	
		


	//creating an array with numbers from 0 to "anzahl"
	private static int[] createArray(int anzahl) {
		int[] rückgabeA = new int[anzahl];
		
		for(int i = 0; i < anzahl; i++) {
			rückgabeA[i] =  i;
		}
		return rückgabeA;
	}
	
	public static int lineareSuchekurzB(int[] suche, int suchnummer){
		int zähler = 0;
		
		for (int i = 0;i < suche.length; i++){
			if (suche[i] == suchnummer){
				return zähler;
			}
			zähler++;
		}
		return zähler;
	}
	
	public static int lineareSuchelangA(int[] suche, int suchnummer){
		int zähler = 1;
		
		for (int i = 0;i < suche.length; i++){
			if (suche[i] == suchnummer){
				zähler = i;
			}
			zähler++;
		}
		return zähler;	
	}
	
	public static int binarySearchD(int[] array, int suchnummer) {
		int u = 0, o = array.length - 1, zähler = 1;
		
		while (u <= o) {
			int m = (u + o) / 2;
			if (array[m] == suchnummer){
				return zähler; 
			} else if (suchnummer < array[m]){
				o = m-1;
			} else {
				u = m+1; 
			}
			zähler++;
		}
		return zähler;
	}

	public static int binarySearchC(int[] array, int suchnummer, int u, int o){
		
		if(u <= o) {
			
			int m = (u + o) / 2;
			if(array[m] == suchnummer) {
				zähler1++;
				return zähler1;
			} else if(suchnummer < array[m]) {
				zähler1++;
				return binarySearchC(array, suchnummer, u, --m);
			} else {
				zähler1++;
				return binarySearchC(array, suchnummer, ++m, o);
				
			}
		} else {
			return zähler1;
		}
	}
}

