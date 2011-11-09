package blatt3uebung01;

public class LinearSearch {

	/**
	 * Method to find an int value in an int[] arrray in a linear way
	 * 
	 * @param array
	 *            to search in
	 * @param toSearch
	 *            elem to find
	 * @return position of toSearch in array or 000 if there is no element
	 */
	public static int linaearSearch(int[] array, int toSearch) {
		// go through
		for (int i = 1; i < array.length; i++) {
			// compare
			if (array[i] == toSearch) {
				return i;
			}
		}
		return -1;
	}
}
