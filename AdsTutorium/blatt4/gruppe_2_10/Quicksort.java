package gruppe_2_10;

public class Quicksort  {
	
	//int [] F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//	# Rekusionen: 30 # Vergleiche: 119  # Vertauschungen: 31
	
	int [] F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//	# Rekusionen: 8 # Vergleiche: 99  # Vertauschungen: 0	
	
//	F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//	# Rekusionen: 8 # Vergleiche: 74  # Vertauschungen: 5


//	F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//	# Rekusionen: 6 # Vergleiche: 41  # Vertauschungen: 9

//	F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
//	# Rekusionen: 8 # Vergleiche: 54  # Vertauschungen: 9

//	F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen
//	# Rekusionen: 7 # Vergleiche: 53  # Vertauschungen: 5


//	F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
//	# Rekusionen: 8 # Vergleiche: 90  # Vertauschungen: 1
	
//	F = new int[] {1};
//	# Rekusionen: 0 # Vergleiche: 0  # Vertauschungen: 0		

//	F = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das größte Element steht ganz links
//	# Rekusionen: 7 # Vergleiche: 81  # Vertauschungen: 9	

//	F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//	# Rekusionen: 8 # Vergleiche: 99  # Vertauschungen: 0	
	
	private int[] numbers;
	private int number;

	public void sort(int[] values) {
		// Check for empty or null array
		if (values == null || values.length==0){
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high-low)/2];

		// Divide into two lists
		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}
			
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
