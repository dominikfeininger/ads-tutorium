package blatt3.g303;

//Gruppe 3-3: 1230485 Marc Misoch, 1226580 Marcel Ortega, 1229645 Dominik Foos
//Aufgabe2

import static gdi.MakeItSimple.*;

public class SearchCounter {
	static int z�hler1 = 0;
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
		int[] r�ckgabeA = new int[anzahl];
		
		for(int i = 0; i < anzahl; i++) {
			r�ckgabeA[i] =  i;
		}
		return r�ckgabeA;
	}
	
	public static int lineareSuchekurzB(int[] suche, int suchnummer){
		int z�hler = 0;
		
		for (int i = 0;i < suche.length; i++){
			if (suche[i] == suchnummer){
				return z�hler;
			}
			z�hler++;
		}
		return z�hler;
	}
	
	public static int lineareSuchelangA(int[] suche, int suchnummer){
		int z�hler = 1;
		
		for (int i = 0;i < suche.length; i++){
			if (suche[i] == suchnummer){
				z�hler = i;
			}
			z�hler++;
		}
		return z�hler;	
	}
	
	public static int binarySearchD(int[] array, int suchnummer) {
		int u = 0, o = array.length - 1, z�hler = 1;
		
		while (u <= o) {
			int m = (u + o) / 2;
			if (array[m] == suchnummer){
				return z�hler; 
			} else if (suchnummer < array[m]){
				o = m-1;
			} else {
				u = m+1; 
			}
			z�hler++;
		}
		return z�hler;
	}

	public static int binarySearchC(int[] array, int suchnummer, int u, int o){
		
		if(u <= o) {
			
			int m = (u + o) / 2;
			if(array[m] == suchnummer) {
				z�hler1++;
				return z�hler1;
			} else if(suchnummer < array[m]) {
				z�hler1++;
				return binarySearchC(array, suchnummer, u, --m);
			} else {
				z�hler1++;
				return binarySearchC(array, suchnummer, ++m, o);
				
			}
		} else {
			return z�hler1;
		}
	}
}

