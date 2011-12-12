package gruppe_2_13;
import static gdi.MakeItSimple.*;

public class QuickSort {
	public static int anzahlDerVergleiche=0, anzahlDerVertauchungen=0;

	/**
	 * Diese Funktion f�hrt die dritte Variante der Quicksort durch.
	 * @param array Das Array zu bearbeiten.
	 * @param untereGrenze Der erste Index des Arrays.
	 * @param obereGrenze Der letze Index des Arrays.
	 */
	/**
	 * @param array
	 * @param untereGrenze
	 * @param obereGrenze
	 */
	public static void variante3_QuickSort(int[]array,int untereGrenze,int obereGrenze){
		int neueGrenze;
		if(obereGrenze>untereGrenze){
			neueGrenze=zerlege(array,untereGrenze,obereGrenze);
			variante3_QuickSort(array, untereGrenze, neueGrenze-1);
			variante3_QuickSort(array, neueGrenze+1, obereGrenze);
		}
	}
	
	/**
	 * Diese Funktion zelegt ein Array, und stellt das PivoElement an seiner richtigen Stelle.
	 * @param array Das array zu bearbeiten.
	 * @param unterGrenze Der unterer Index des Arrays.
	 * @param obereGrenze Der oberer Index des Arrays.
	 * @return Die Position der Zerlegung.
	 */
	public static int zerlege(int []array,int unterGrenze,int obereGrenze){
		int pivotIndex=obereGrenze,index=unterGrenze;
		for(int zeiger=unterGrenze;zeiger<=obereGrenze;zeiger++){
			anzahlDerVergleiche++;
			if(array[zeiger]<=array[pivotIndex]){
				anzahlDerVertauchungen++;
				tauche(array,index,zeiger);
				index++;
			}
		}
		tauche(array,index,obereGrenze);
		anzahlDerVertauchungen++;
		return index-1;//der �berfl�ssig inkrementation das index nach dem forschleife wegkriegen
	}
	
	/**
	 * Diese Funktion tauscht die Position von 2 Elemente eines Arrays.
	 * @param array Das Array zu bearbeiten.
	 * @param index1 Der Index des ersten Elements.
	 * @param index2 Der Index des zweiten Elements.
	 */
	public static void tauche(int[] array,int index1,int index2){
		int zwischenContainer=array[index1];
		array[index1]=array[index2];
		array[index2]=zwischenContainer;
	}
	
	/**
	 * Diese Funktion gibt(dr�ckt) die Elemente eines Arrays aus.
	 * @param array Das array zu bearbeiten.
	 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			print(" "+array[i]);
		}
		println();
	}

	public static void main(String[] args) {
		
		//int [] F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//		# Rekusionen: 30 # Vergleiche: 119  # Vertauschungen: 31
		
		//int [] F = new int [] {1,2,3,4,5,6,7,8,9,10};  // F ist schon sortiert
//		# Rekusionen: 8 # Vergleiche: 99  # Vertauschungen: 0	
		
//  	F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Rekusionen: 8 # Vergleiche: 74  # Vertauschungen: 5


//		F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Rekusionen: 6 # Vergleiche: 41  # Vertauschungen: 9

//		F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
//		# Rekusionen: 8 # Vergleiche: 54  # Vertauschungen: 9

//		F = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen
//		# Rekusionen: 7 # Vergleiche: 53  # Vertauschungen: 5


//		F = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
//		# Rekusionen: 8 # Vergleiche: 90  # Vertauschungen: 1
		
//		F = new int[] {1};
//		# Rekusionen: 0 # Vergleiche: 0  # Vertauschungen: 0		

//		F = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das größte Element steht ganz links
//		# Rekusionen: 7 # Vergleiche: 81  # Vertauschungen: 9	

//		F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//		# Rekusionen: 8 # Vergleiche: 99  # Vertauschungen: 0	
		//int []array=new int[6];
		int []F={1,6,55,30,94,18,1,10,33,15,9999};
		print("eingegebene Array: ");
		printArray(F);
		variante3_QuickSort(F, 0, F.length-1);
		print("Sortirt Array    : ");
		printArray(F);
		println("Anzhal Der Vergleiche: "+anzahlDerVergleiche);
		println("Anzhal Der Vertauchungen: "+anzahlDerVertauchungen);
	}

}
