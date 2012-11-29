package blatt3.g311;

import static gdi.MakeItSimple.*;



public class Suchfunktionen {
	
	/**
	 * This function assort an array for using the binary search.
	 * @param suchArray:It will provide an Array of Integer, which is to be sorted.
	 * @return
	 */
	
	public static void bubbleSort(int[] suchArray){
		int uebergabe, index = suchArray.length - 1;
		while(index > 0){
			for (int i = 0; i < index; i++){
				if(suchArray [i] > suchArray[i+1]){
					uebergabe = suchArray[i+1];
					suchArray[i+1] = suchArray[i];
					suchArray[i] = uebergabe;
				}
			}
			index--;
		}
	}
	
	/**
	 * This Method search an entered number at an Array.
	 * @param suchArray: Thats the Array which have to be searched.
	 * @param suchSchlüssel: Thats the Value which have to be searched.
	 * @return: As a return statement, it will provide the last index, where the search key is found.
	 * @return: If the Value isn't found, it will return -1.
	 */
	public static int lineareSuche1(int[] suchArray, int suchSchlussel){
		int index = -1;
		
		for (int i = 0; i < suchArray.length; i++){
			if(suchArray[i] == suchSchlussel){
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * This Method search an entered number at an Array. 
	 * @param suchArray: Thats the Array which have to be searched.
	 * @param suchSchlüssel: Thats the Value which have to be searched.
	 * @return: As a return statemnet, it will provide the first index, where the search has been found.
	 * @return: If the Value isn't found, it will return -1.
	 */
	public static int lineareSuche2(int[] suchArray, int suchSchlussel){
		
		for (int i = 0; i < suchArray.length; i++){
			if(suchArray[i] == suchSchlussel){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * This Method search an entered number at an Array. The Binary search halved the Array and search the upper part or the lower part.
	 * The Method procedure works recursively.
	 * @param suchArray: Thats the Array which have to be searched.
	 * @param suchSchlüssel: Thats the Value which have to be searched.
	 * @param u: U limited the Area which have to be searched. This procedure works from low to High.
	 * @param o: O limited the Area which have to be searched. This procedure works from High to low.
	 * @return: As the return statement, the Index will be provide, where the Value was found.
	 * @return: If the Value is not found, -1 will be returned.
	 */
	public static int binaereSuche1(int[] suchArray, int suchSchlussel, int u, int o){
		int m = (u + o) / 2;
		if (suchArray[m] == suchSchlussel){
			return m;
		}
		else if((m ==  0) || (m == suchArray.length - 1)){
			return -1;
		}
		else if(suchSchlussel < suchArray[m] && suchSchlussel > suchArray[m-1]){
			return -1;
		}
		else if (suchSchlussel < suchArray[m]){
			return binaereSuche1(suchArray, suchSchlussel, u, m - 1);
		}
		else{
			return binaereSuche1(suchArray, suchSchlussel, m + 1, o);
		}
	}
	
	/**
	 * This Method search an entered Number. The Binary search halfved the Array and search from High to lower part.
	 * This Method runs iterative.
	 * @param suchArray: Thats the Array which have to be searched.
	 * @param suchSchlüssel: Thats the Value which have to be searched.
	 * @return:  As the return statement, the Index will be provide, where the Value was found.
	 * @return:  If the Value is not found, -1 will be returned.
	 */
	public static int binaereSuche2(int[] suchArray, int suchSchlussel){
		int u = 0, o = suchArray.length - 1; //u und o grenzen den Bereich in dem gesucht werden soll ab.
		while (u <= o) {
			int m = (u + o) / 2;
			if (suchArray[m] == suchSchlussel){
				return m;
			}
			else if (suchSchlussel < suchArray[m]){
				o = m-1;
			}
			else{
				u = m+1;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int zufallszahl, eingabe;
		int[] suchArray = new int[10];
		for (int i = 0; i < suchArray.length; i++){ //Hier wird ein Array mit Zufallszahlen gefüllt.
			zufallszahl = (int) (Math.random()*99)+1;
			suchArray[i] = zufallszahl;
		}
		for (int j = 0; j < suchArray.length; j++){
			print(suchArray[j] + " ");
		}
		println("");
		bubbleSort(suchArray); //Der Array wird sortiert und auf der Konsole ausgegeben
		for (int j = 0; j < suchArray.length; j++){
			print(suchArray[j] + " ");
		}
		println("");
		
		println("Geben sie eine Zahl ein, die im Array gesucht werden soll:");
		eingabe = readInt();
		
		/*
		 * Die einzelnen Suchverfahren werden hier aufgerufen.
		 */
		println(lineareSuche1(suchArray, eingabe));
		println(lineareSuche2(suchArray, eingabe));
		println(binaereSuche1(suchArray, eingabe, 0, suchArray.length -1));
		println(binaereSuche2(suchArray, eingabe));
	}

}
