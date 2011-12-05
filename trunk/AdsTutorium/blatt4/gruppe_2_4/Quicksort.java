package gruppe_2_4;



public class Quicksort {
	public static void main(String[] args) {
		//int [] F = new int[] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // "zufälliges" Feld
//		# Rekusionen: 30 # Vergleiche: 119  # Vertauschungen: 31
		
		//int [] F = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert
//		# Rekusionen: 8 # Vergleiche: 99  # Vertauschungen: 0	
		
//  	F = new int [] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
//		# Rekusionen: 8 # Vergleiche: 74  # Vertauschungen: 5


//		F = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
//		# Rekusionen: 6 # Vergleiche: 41  # Vertauschungen: 9

int [] F = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
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
		
		int[] array = {44,6,55,30,94,18};
		int untereGrenze = 0;
		int obereGrenze = array.length-1;
		QuickSort(F, untereGrenze, obereGrenze);
		System.out.println("vergleiche :" +vergleiche +"tauschen :"+tauschen);
		for (int i1 = 0; i1 < array.length; i1++) {
			System.out.print(array[i1]+" ");
		}
	}
	
	static void QuickSort(int[] array, int u, int o){
		
//		Eingabe:�zu�sorLerende�Folge�F,�
//		���������������untere�und�obere�Grenze�u,�o�
		int i = 0;
		if (o > u){ 
			i = zerlege(array, u, o);
			QuickSort(array, u, i-1);
			QuickSort(array, i+1, o);
		}
	}
	static int vergleiche = 0;
	static int tauschen = 0;
	static int zerlege (int[] f, int u, int o){
		int zwischenspeicher;

		int p = o; 
		int index=u;
		for (int zeiger = u; zeiger < o-1; zeiger++) {
			
			if (f[zeiger] <= f[p]) {
				zwischenspeicher = f[index];
				f[index] = f[zeiger];
				f[zeiger] = zwischenspeicher;
				index++;
				tauschen++;
				for (int i1 = 0; i1 < f.length; i1++) {
					System.out.print(f[i1]+" ");
				}
				System.out.println();
			}
			vergleiche++;
		}
		zwischenspeicher = f[index];
		f[index] = f[o];
		f[o] = zwischenspeicher;	
		tauschen++;
		for (int i1 = 0; i1 < f.length; i1++) {
			System.out.print(f[i1]+" ");
		}
		System.out.println();
		return index;
	}

}
