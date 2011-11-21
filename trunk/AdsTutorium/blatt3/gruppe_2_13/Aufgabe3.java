package gruppe_2_13;
import static gdi.MakeItSimple.*;

public class Aufgabe3 {
	
	public static void printArray(int []array){
		for (int i=0;i<array.length;i++){
			print(" "+array[i]);
		}
		println();
	}

	public static int[] selectionSort(int []array){
		int anfangIndex=0,endIndex=array.length-1, kleinste,groesste,vergleicheAnzahl=0,vertauchungenAnzahl=0;
		int zaehler,arbeitLaenge,durchlaufZaehler=0;
		boolean kleinerGefunden=false, groesserGefunden=false;
		while(anfangIndex<=endIndex){
			//in that case, the smaller element between the first and the last square is in the first square
			if(array[anfangIndex]<=array[endIndex]){
				kleinste=anfangIndex;
				groesste=endIndex;
			}
			else{ //or else
				kleinste=endIndex;
				groesste=anfangIndex;
			}
			vergleicheAnzahl++;
			zaehler=anfangIndex+1;
			arbeitLaenge=endIndex-1;
			//compare the both with the Value between they
			while(zaehler<=arbeitLaenge){
				vergleicheAnzahl++;
				//if a smaller value was found keep the index of this one
				if(array[zaehler]<array[kleinste]){
					kleinste=zaehler;
					kleinerGefunden=true;
				}
				//if a higher value was found keep the index of this one
				else if (array[zaehler]>array[groesste]){
					groesste=zaehler;
					groesserGefunden=true;
				}
				zaehler++;
			}
			//if a higher value was not found and the current higher value is not in the last square
			if(!groesserGefunden && groesste!=endIndex){
				stelleTauchen(array, groesste, endIndex);
				vertauchungenAnzahl++;
				//if the smaller value found was at this location, it is now where the higher value was
				if(kleinste==endIndex)
					kleinste=groesste;
			}
			//if a smaller value was not found and the current smaller value is not in the first square
			if(!kleinerGefunden && kleinste!=anfangIndex){
				stelleTauchen(array, kleinste, anfangIndex);
				vertauchungenAnzahl++;
				//if the higher value found was at this location, it is now where the smaller value was
				if(groesste==anfangIndex)
					groesste=kleinste;
			}
			//if a smaller value was found
			if(kleinerGefunden){
				vertauchungenAnzahl++;
				stelleTauchen(array, kleinste, anfangIndex);
				kleinerGefunden=false;
			}
			//if a higher value was found
			if(groesserGefunden){
				vertauchungenAnzahl++;
				stelleTauchen(array, groesste, endIndex);
				groesserGefunden=false;
			}
			//decrease the length of the array of the both sides
			anfangIndex++;
			endIndex--;
			//increase the number of tour
			durchlaufZaehler++;
			//display the array after the round number durchlaufzaehler
			print("Nach der durchlauf "+durchlaufZaehler+": ");
			printArray(array);
		}
		println();
		println("Anzahl der Vergleiche = "+vergleicheAnzahl);
		println("Anzahl der Vertauchungen = "+vertauchungenAnzahl);
		return array;
	}
	
	public static void stelleTauchen(int []array,int index1, int index2){
		int halter;
		halter=array[index1];
		array[index1]=array[index2];
		array[index2]=halter;
	}

	public static void main(String[] args) {
		int []meinArray=new int [15];
		int zaehler=0;
		print("Ursprungarray:        ");
		while(zaehler<meinArray.length){
			meinArray[zaehler]=(int) Math.floor(Math.random()*1000);
			print(" "+meinArray[zaehler]);
			zaehler++;
		}
		println();println();
		meinArray=selectionSort(meinArray);
		zaehler=0;
		println("sortirte Array: ");
		while(zaehler<meinArray.length){
			print(" "+meinArray[zaehler]);
			zaehler++;
		}
		println();
	}

}
