package gruppe_2_2.aufgabe2;

import static gdi.MakeItSimple.*;

public class Shellsort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] F = new int[40];
		//int[] F = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int x;
		int[] H = {9,7,4,1 };
		
		for (int i = 0; i < F.length; i++) {					// Fill array with random numbers between 0 and 100 
			 x = (int) Math.floor(Math.random() * 100); 
			 F[i] = x; 
		}

		ShellSort(H,F);
		println("sorted: " + checkArray(F));
		
	}
	/**
	 * routine shellSort sorts the given array F. It goes through the array for each step size given in hValues.  
	 * If h = 1 -> insertion sort 
	 * @param hValues
	 * @param F
	 */
	static void ShellSort(int[] hValues, int[] F) {
		int reminder = 0;
		int h = 0;				// Wert des aktuellen h wertes
		int i = 0;				// zähler für hWerte Array
		int pos = 0;			// pos is initialized with h, but will be edited
		int equalCounter = 0;
		int runCounter = 0;
		int changeCounter = 0;
		boolean swaped = false;
		int checkpos = 0;
		int resultCounter = 0;
		int resultRuns = 0;
		int resultChanges = 0;
		
		for(i = 0; i < hValues.length; i++) {						// as long as all hNumbers are used 
			h = hValues[i];
			pos = h;
			println("Schrittweite: " + h);
			println("----------------");
			while(pos < F.length) {									// as long as end of array is reached
				swaped = false;
				runCounter++;
				reminder = F[pos];									// save Number in F at index pos. we need it later when did a swap
				equalCounter++;
				checkpos=pos;										// we need checkpos -> otherwise we would edit pos -> nosearch (insertion)
				while(checkpos >= h && F[checkpos-h] > reminder ) { // swap if pos >= h, because we compare with checkpos-h
																	// if we wont do that -> ArrayOutOf.. error
					printSwaps(F,checkpos,checkpos-h);				
					F[checkpos] = F[checkpos-h];					// change elemenets
					changeCounter++;				
					checkpos -= h;									// prepare checkpos for next check
					swaped = true;
				}
				F[checkpos] = reminder;
				if(!swaped) printArray(F);
				pos++;
			}
			println("----------------");
			println("Vgl=" + equalCounter + "; Runs=" + runCounter + "; Changes= " + changeCounter);
			println();
			resultCounter += equalCounter;
			resultRuns += runCounter;
			resultChanges += changeCounter;
			equalCounter = 0;
			runCounter = 0;
			changeCounter = 0;
		}
		printArray(F);
		println("----------------");
		println("Vgl=" + resultCounter + "; Runs=" + resultRuns + "; Changes= " + resultChanges);
	}
	/**
	 * routine shows prints the array at the console and marks the swaped elemetns with (&).
	 * @param F
	 * @param index1
	 * @param index2
	 */
	static void printSwaps(int[] F, int index1, int index2) {
		String out = "";
		for (int i = 0; i < F.length; i++) {
			if(i == index1 || i == index2) {
				out += " (" + F[i] + ")";
			}
			else {
				out += " " + F[i];
			}
		}
		println(out);
		
	}
	/**
	 * routine prints out the given array on console
	 * @param F
	 */
	static void printArray(int[] F) {
		String out = "";
		for (int i = 0; i < F.length; i++) {
			out += " " + F[i];
		}
		println(out);
	}
	/**
	 * Function checkArray goes through the array to check if its sorted
	 * @param F
	 * @return boolean -> expected true or false
	 */
	static boolean checkArray(int[] F) {
		for(int i = 0; i < F.length-1; i++) {
			if(F[i] > F[i+1]) {
				return false;
			}
		}
		return true;
	}

}
