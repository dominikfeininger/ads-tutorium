package blatt3.g305;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

public class aufgabe04 {

	static void shakerSort(int[] array, boolean noProtocoll, int counter[]) {
		//function that calls up botch BubbleSort funktions
		int leftmarker = 0, rightmarker = array.length;
		while (leftmarker < rightmarker) {
			bubbleSortDown(leftmarker, rightmarker, array, counter, noProtocoll);
			rightmarker--;
			bubbleSortUp(leftmarker, rightmarker, array, counter, noProtocoll);
			leftmarker++;
		}
	}

	static void bubbleSortDown(int i, int l, int[] array, int[] counter,
			boolean noProtocoll) {
		//
		int marker;
		for (int j = i; j < l - 1; j++) {
			//searches bigger elements
			counter[0]++;//counts the comparisons
			if (array[j] > array[j + 1]) {
				//if value on index j is bigger than j+1, value is shifted down
				counter[1]++;//counts the shifts
				marker = array[j];//shifting
				array[j] = array[j + 1];//shifting
				array[j + 1] = marker;//shifting
				if (noProtocoll == false) {
					println(Arrays.toString(array));
				}
			}
		}
	}

	static void bubbleSortUp(int i, int l, int[] array, int[] counter,
			boolean noProtocoll) {
		int marker;
		for (int j = l - 1; j >= i; j--) {
			//searches smaller elements
			counter[0]++;//counts the comparisons
			if (array[j] > array[j + 1]) {
				//if value on index j is bigger than j+1, value is shifted up
				counter[1]++;//counts the shifts
				marker = array[j];//shifting
				array[j] = array[j + 1];//shifting
				array[j + 1] = marker;//shifting
				if (noProtocoll == false) {
					println(Arrays.toString(array));
				}
			}
		}
	}

	static int[] randomFillArray(int sizeOfArray) {
		// function that fills an array with a given
		// number of elements with random elements
		int data[] = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray - 1; i++) {
			data[i] = (int) Math.floor(Math.random() * sizeOfArray);
		}
		return data;
	}

	static int[] Experiment(int numberOfTrys, int sizeOfArray, boolean protocoll) {
		//statistic experiment that count the avarage number of shifts and comparisons
		//index 0 is number of comparisond, index 1 is number of shifts
		int [] result = { 0, 0 };
		for (int i = 0; i < numberOfTrys; i++) {
			int[] counter = { 0, 0 };
			int[] array = randomFillArray(sizeOfArray);
			shakerSort(array, protocoll, counter);
			//result is divided by number of trys then added to overall result
			result[0] = result[0] + (counter[0]/numberOfTrys);
			result[1] = result[1] + (counter[1]/numberOfTrys);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { 0, 0 };
		int arraySize = 0, numberOfTrys = 0;
		String enableProtocoll;
		boolean noprotocoll = false;
		println("Wollen sie einen Protokoll anzeigen lassen? y/n");
		enableProtocoll = readLine();
		if (!strEqual(enableProtocoll, "y")) {
			noprotocoll = true;
		}
		println("Geben Sie bitte die Anzahl der Suchläufe ein :");
		numberOfTrys = readInt();
		println("Geben Sie bitte die Größe des Arrays ein :");
		arraySize = readInt();
		array = Experiment(numberOfTrys, arraySize, noprotocoll);
		println("ShakerSort, Anzahl der Vergleiche im Durchschnitt:" + " "
				+ array[0]);
		println("ShakerSort, Anzahl der Shifts im Durchschnitt:" + " "
				+ array[1]);
	}

}
