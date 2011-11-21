package blatt3muster;

import static gdi.MakeItSimple.*;

//import java.io.IOException;

/**
 * @author Peter Kaiser modified by Wolfgang Schramm
 * @version 1.1 Implementierung von 4 Such-Algorithmen in einem Array Lineare
 *          Suche (bis zum ersten Erfolg): seekLin2 Lineare Suche im ganzen
 *          Array: seekLin1 Binäre Suche iterativ: seekBinItr Binäre Suche
 *          rekursiv: seekBinRec Zur Zählung der Vergleiche (c) 2009 Peter
 *          Kaiser ADS Übung WS2011; 1IB Blatt 3 / Aufgabe 4 HINWEIS: Die
 *          Suchverfahren sind dergestalt modifiziert, dass sie nicht mehr den
 *          Index des gefundenen Elements zurückgeben, sondern die Anzahl der
 *          durchgeführten Vergleiche. Der Bequemlichkeit halber wurden
 *          for-Schleifen verwendet, obwohl die noch nicht in GDI eingeführt
 *          wurden.
 */
public class SearchExp {
	// length of array to be searched
	final static int LEN = 1024;
	// number of keys to be searched for
	final static int KEYS_NUM = 100;
	// special value to indicate failed search
	final static int NO_KEY = -1;

	/**
	 * @param args
	 *            none
	 */
	public static void main(String[] args) {

		// all arrays to be searched are sorted with gaps

		// first array to be searched
		int len1 = LEN;
		int data1[] = new int[len1];
		// initialize data
		for (int i = 0; i < data1.length; i++) {
			data1[i] = i * 2; // there is always one number in between 2
								// entries, e.g. 1, 3, 5, 7, ...
		}
		;

		// second array to be searched
		int len2 = 2 * LEN;
		int data2[] = new int[len2];
		// initialize data
		for (int i = 0; i < data2.length; i++) {
			data2[i] = i * 3; // there are always two numbers in between 2
								// entries, e.g. 1, 4, 7, 10, ...
		}
		;

		// third array to be searched
		int len3 = 4 * LEN;
		int data3[] = new int[len3];
		// initialize data
		for (int i = 0; i < data3.length; i++) {
			data3[i] = i * 3; // there are always three numbers in between 2
								// entries, e.g. 1, 5, 9, 13, ...
		}
		;

		// keys - perform KEYS_NUM searches per array per function
		int keys[] = new int[KEYS_NUM];
		// print heading

		println("Statistik\n");
		println("\tlin1\tlin2\tbinr\tbini");

		//
		// runs with first array
		// /////////////////////////////////
		// initialize keys
		// keep in mind that the range of the keys is 0 .. len1
		for (int i = 0; i < KEYS_NUM; i++) {
			keys[i] = (int) Math.floor(Math.random() * len1);
		};

		// initialize counter
		int lin1 = 0; // number of comparisions for seekLin1
		int lin2 = 0; // number of comparisions for seekLin2
		int binr = 0; // number of comparisions for seekBinRec
		int bini = 0; // number of comparisions for seekBinItr
		for (int i = 0; i < KEYS_NUM; i++) {
			lin1 += seekLin1(data1, keys[i]);
			lin2 += seekLin2(data1, keys[i]);
			binr += seekBinRec(data1, keys[i]);
			bini += seekBinItr(data1, keys[i]);
		}
		;
		lin1 /= KEYS_NUM;
		lin2 /= KEYS_NUM;
		binr /= KEYS_NUM;
		bini /= KEYS_NUM;

		println(len1 + "\t" + lin1 + "\t" + lin2 + "\t" + binr + "\t" + bini);
		//
		// runs with second array
		// /////////////////////////////////
		// initialize keys
		for (int i = 0; i < KEYS_NUM; i++) {
			keys[i] = (int) Math.floor(Math.random() * len2);
		}
		;
		// reinitialize counter
		lin1 = 0; // number of comparisions for seekLin1
		lin2 = 0; // number of comparisions for seekLin2
		binr = 0; // number of comparisions for seekBinRec
		bini = 0; // number of comparisions for seekBinItr
		for (int i = 0; i < KEYS_NUM; i++) {
			lin1 += seekLin1(data2, keys[i]);
			lin2 += seekLin2(data2, keys[i]);
			binr += seekBinRec(data2, keys[i]);
			bini += seekBinItr(data2, keys[i]);
		}
		;
		lin1 /= KEYS_NUM;
		lin2 /= KEYS_NUM;
		binr /= KEYS_NUM;
		bini /= KEYS_NUM;
		println(len2 + "\t" + lin1 + "\t" + lin2 + "\t" + binr + "\t" + bini);
		//
		// runs with third array
		// /////////////////////////////////
		// initialize keys
		for (int i = 0; i < KEYS_NUM; i++) {
			keys[i] = (int) Math.floor(Math.random() * len3);
		}
		;
		// initialize counter
		lin1 = 0; // number of comparisions for seekLin1
		lin2 = 0; // number of comparisions for seekLin2
		binr = 0; // number of comparisions for seekBinRec
		bini = 0; // number of comparisions for seekBinItr
		for (int i = 0; i < KEYS_NUM; i++) {
			lin1 += seekLin1(data3, keys[i]);
			lin2 += seekLin2(data3, keys[i]);
			binr += seekBinRec(data3, keys[i]);
			bini += seekBinItr(data3, keys[i]);
		}
		;
		lin1 /= KEYS_NUM;
		lin2 /= KEYS_NUM;
		binr /= KEYS_NUM;
		bini /= KEYS_NUM;
		println(len3 + "\t" + lin1 + "\t" + lin2 + "\t" + binr + "\t" + bini);
	}

	/**
	 * seekLin1 linear search, searching the complete array
	 * 
	 * @param data
	 *            array to be search
	 * @param key
	 *            search key
	 * @return number of comparions
	 */
	public static int seekLin1(int data[], int key) {
		// int indexFound = NO_KEY;
		int cnt = 0;
		for (int j = 0; j < data.length; j++) {
			cnt++;
			if (data[j] == key) {
				// indexFound = j;
			}
			;
		}
		;
		return cnt;
	}

	/**
	 * seekLin2 linear search, searching till found
	 * 
	 * @param data
	 *            array to be search
	 * @param key
	 *            search key
	 * @return number of comparions
	 */
	public static int seekLin2(int data[], int key) {
		int cnt = 0;
		for (int j = 0; j < data.length; j++) {
			cnt++;
			if (data[j] == key) {
				return cnt;
			};
		};
		return cnt;
	}

	/**
	 * seekBinRec binary search, recursive
	 * 
	 * @param data
	 *            array to be search
	 * @param key
	 *            search key
	 * @return number of comparions
	 */
	static public int seekBinRec(int[] data, int key) {
		return seekBR(data, 0, data.length - 1, key);
	}

	/**
	 * seekBR binary search, recursive, internal used fct with additional
	 * parameters
	 * 
	 * @param data
	 *            array to be search
	 * @param left
	 *            leftmost index of search array
	 * @param rght
	 *            rightmost index of search array
	 * @param key
	 *            search key
	 * @return number of comparisons
	 */

	static public int seekBR(int[] data, int left, int rght, int key) {
		int middle;
		int cnt = 0;
		if (left <= rght) {
			middle = (left + rght) / 2; // integer division!
			cnt++;
			if (data[middle] == key)
				return cnt; // key found
			else {
				cnt++;
				if (key > data[middle]) {
					// search in right part
					return cnt + seekBR(data, middle + 1, rght, key);
				} else {
					// search in left part
					return cnt + seekBR(data, left, middle - 1, key);
				}
			}
		} else {
			return 0; // key not found
		}
	}

	/**
	 * seekBinIter binary search, recursive
	 * 
	 * @param data
	 *            array to be search
	 * @param key
	 *            search key
	 * @return number of comparisions
	 */
	static public int seekBinItr(int[] data, int key) {
		int u = 0;
		int o = data.length - 1;
		int m;
		int cnt = 0;
		while (u <= o) {
			m = (u + o) / 2;
			cnt++;
			if (data[m] == key) {
				return cnt; // found !
			} else {
				//TODO: cnt doppelt hochgez‰hlt???
				cnt++;
				if (key < data[m]) {
					o = m - 1; // continue search in lower half
				} else {
					u = m + 1; // continue search in upper half
				}
				;
			}
		}
		;
		return cnt;
	}
}
