package gruppe_2_13;
import static gdi.MakeItSimple.*;
public class ShellSort {
	public static int anzahlDerVergleiche=0, anzahlDerVertauchungen=0;
	
	/**
	 * Diese Funktion führt der ShellSort durch.
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
				array[zaehler2]=gearbeitetElement;//PB:manchmal wird keine änderung gemacht und troztdem ist diese instruction durchgeführt
				anzahlDerVertauchungen++;
				print("mit ein Schritt von "+schritt+" ist das Array:");
				printArray(array);
			}
		}
		
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
		//int []array={44,6,55,30,94,18,1,48,33,15,66};
		int []array={15,13,26,28,59,45,35,16,28,24,11,2,3,4};
		print("eingegebene Array: ");
		printArray(array);
		meinShellSort(array);
		print("Sortirt Array    : ");
		printArray(array);
		println("Anzhal Der Vergleiche: "+anzahlDerVergleiche);
		println("Anzhal Der Vertauchungen: "+anzahlDerVertauchungen);

	}

}
