package uebung03;
import static gdi.MakeItSimple.*;
public class Suche {
	public final static int NO_KEY = -1; 		//classen Variable
	public int seqSearchA(int[]f, int key){
		//int key = 1;
		int res = NO_KEY;
		int i = 0;
		//println("search key = ");
		//key = readInt();					//Variable key wird eigelesen
		while (i < f.length) {			
			//Schleife die läuft solange das ende des array 
			//nicht erreicht wurde !!!und!!! noch kein Ergebnis gefunden wurde
			if (f[i] == key) res = i;		
			//test ob der eingegebene Wert gleich 
			//der Wert des Arrays an der Stelle i ist
			i++;
		}
		println(i);
		return res;
	}
	public int seqSearchB(int[]f, int key){
		//int key = 1;
		int res = NO_KEY;
		int i = 0;
		//println("search key = ");
		//key = readInt();					//Variable key wird eigelesen
		while (i < f.length && res == NO_KEY) {			
			//Schleife die läuft solange das ende des array 
			//nicht erreicht wurde !!!und!!! noch kein Ergebnis gefunden wurde
			if (f[i] == key) res = i;		
			//test ob der eingegebene Wert gleich 
			//der Wert des Arrays an der Stelle i ist
			i++;
		}
		println(i);
		return res;
	}
	public int binaereSuche(int[]f, int k){
		int u, m, o;
		//println("search key = ");
		//k =readInt();		//Variable key wird eigelesen
		u=0;			//counter
		m=0;		//stelle im Array an der das Ergebnis liegt
		o = f.length;
		//Eingabe: Folge F der Länge n, Suchschlüssel k
		//Ausgabe: Position p des ersten Elements aus F, das gleich k ist, sonst NO_KEY
		if(f.length != 0){
			while (u <= o){			// Schleife die läuft, bis das Ende des Arrays erreicht wurde
				m = (u + o)/2;		
				if (f[m]== k){			//testet den Inhalt		
					println("anzahl durchläufe  " +u);	
					return m; 	// gefunden !
				}else if(k < f[m]){ 
					o =m-1;			// suche in der unteren Hälfte weiter
				}else{
					u = m + 1; 					// suche in der oberen Hälfte weiter
				}if(u==0){
					return NO_KEY;
				}
			}
			println("leeres Array");
		}
		println("anzahl durchläufe  " +u);
		return NO_KEY;
	}
}

