package gruppe_2_13;
import static gdi.MakeItSimple.*;

public class QuickSort {
	public static int anzahlDerVergleiche=0, anzahlDerVertauchungen=0;

	/**
	 * Diese Funktion führt die dritte Variante der Quicksort durch.
	 * @param array Das Array zu bearbeiten.
	 * @param untereGrenze Der erste Index des Arrays.
	 * @param obereGrenze Der letze Index des Arrays.
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
		return index-1;//der überflüssig inkrementation das index nach dem forschleife wegkriegen
	}
	
	/**
	 * Diese Funktion tauscht die Position von 2 Elemente eines Arrays.
	 * @param array Das Array zu bearbeiten.
	 * @param index1 Der Index des ersten Elements.
	 * @param index2 Der Index des zweiten Elements.
	 */
	public static void tauche(int []array,int index1,int index2){
		int zwischenContainer=array[index1];
		array[index1]=array[index2];
		array[index2]=zwischenContainer;
	}
	
	/**
	 * Diese Funktion gibt(drückt) die Elemente eines Arrays aus.
	 * @param array Das array zu bearbeiten.
	 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			print(" "+array[i]);
		}
		println();
	}

	public static void main(String[] args) {
		//int []array=new int[6];
		int []array={44,6,55,30,94,18,1,48,33,15,66};
		print("eingegebene Array: ");
		printArray(array);
		variante3_QuickSort(array, 0, array.length-1);
		print("Sortirt Array    : ");
		printArray(array);
		println("Anzhal Der Vergleiche: "+anzahlDerVergleiche);
		println("Anzhal Der Vertauchungen: "+anzahlDerVertauchungen);
	}

}
