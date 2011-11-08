package neuesUebungsblatt;

public class BBaumKnoten {

	int KnotenWert;
	
	int s[] = new int[2]; 					// gespeicherte Schluessel
	int sa; 								// Anzahl der gespeicherten Schluessel
	BBaumKnoten p[] = new BBaumKnoten[3]; 	// Zeiger auf die Soehne des Knotens
	BBaumKnoten v; 							// Vater des Knotens
	
	public BBaumKnoten(int i) {
		// TODO Auto-generated constructor stub
		KnotenWert = i;
	}
	
	public BBaumKnoten() {
		// TODO Auto-generated constructor stub
	}

}
