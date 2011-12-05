package gruppe_2_13;
import static gdi.MakeItSimple.*;
public class ShellSort {
	public static int anzahlDerVergleiche=0, anzahlDerVertauchungen=0;
	
	/**
	 * Diese Funktion f�hrt der ShellSort durch.
	 * @param array Das Array zu bearbeiten.
	 */
	public static void meinShellSort(int[]array){
		int letzteIndex=array.length-1,gearbeitetElement,zaehler2,schritt;
		int []meineSchritt={9,7,4,1};
		for(int indexSchritt=0;indexSchritt<meineSchritt.length;indexSchritt++){
			schritt=meineSchritt[indexSchritt];
			for(int zaehler=schritt;zaehler<=letzteIndex;zaehler++){
				gearbeitetElement=array[zaehler];
				zaehler2=zaehler;
				while(zaehler2>=schritt){
					anzahlDerVergleiche++;
					if(array[zaehler2-schritt]>=gearbeitetElement){
						array[zaehler2]=array[zaehler2-schritt];
						anzahlDerVertauchungen++;
						zaehler2=zaehler2-schritt;
					}
					else break;
				}
				array[zaehler2]=gearbeitetElement;//PB:manchmal wird keine �nderung gemacht und troztdem ist diese instruction durchgef�hrt
				anzahlDerVertauchungen++;
				print("mit ein Schritt von "+schritt+" ist das Array:");
				printArray(array);
			}
		}
		
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
		
		//int[] F = new int[40];
		//int[] F = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//int [] F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//		# Vergleiche: 106  # Vertauschungen: 68	
//		int [] F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//		# Vergleiche: 23  # Vertauschungen: 0		
  	int [] F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Vergleiche: 32  # Vertauschungen: 18
//		int [] F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Vergleiche: 34  # Vertauschungen: 21
//		int [] F = new int [] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  // F ist sortiert - alle Elemente sind gleich
//		# Vergleiche: 23  # Vertauschungen: 0
  	
  	
		//int []array={44,6,55,30,94,18,1,48,33,15,66};
		int []array={15,13,26,28,59,45,35,16,28,24,11,2,3,4};
		print("eingegebene Array: ");
		printArray(F);
		meinShellSort(F);
		print("Sortirt Array    : ");
		printArray(F);
		println("Anzhal Der Vergleiche: "+anzahlDerVergleiche);
		println("Anzhal Der Vertauchungen: "+anzahlDerVertauchungen);

	}

}
