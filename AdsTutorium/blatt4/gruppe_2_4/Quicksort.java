package gruppe_2_4;



public class Quicksort {
	public static void main(String[] args) {
		int[] array = {44,6,55,30,94,18};
		int untereGrenze = 0;
		int obereGrenze = array.length-1;
		QuickSort(array, untereGrenze, obereGrenze);
		System.out.println("vergleiche :" +vergleiche +"tauschen :"+tauschen);
		for (int i1 = 0; i1 < array.length; i1++) {
			System.out.print(array[i1]+" ");
		}
	}
	
	static void QuickSort(int[] array, int u, int o){
		
//		Eingabe: zu sorLerende Folge F, 
//		               untere und obere Grenze u, o 
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
