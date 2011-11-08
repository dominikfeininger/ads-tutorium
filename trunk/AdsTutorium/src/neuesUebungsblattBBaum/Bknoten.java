package neuesUebungsblattBBaum;

/**
 * File: Bknoten.java
 * 
 * @author Dominik Feininger ?
 */
// xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
// Bknoten-KLASSE
// xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
public class Bknoten {
	int s[] = new int[2]; // gespeicherte Schluessel
	int sa; // Anzahl der gespeicherten Schluessel
	Bknoten p[] = new Bknoten[3]; // Zeiger auf die Soehne des Knotens
	Bknoten v; // Vater des Knotens

	// ---Konstruktor Knoten mit nur einem
	// Schluessel:-------------------------------
	public Bknoten(int s0, Bknoten v, Bknoten p0, Bknoten p1) {
		p[0] = p0;
		p[1] = p1;
		p[2] = null;
		s[0] = s0;
		sa = 1;
		this.v = v;
	}

	// ---Schluessel in Knoten
	// dazufuegen:--------------------------------------------
	public void dazufuegen(int key, Bknoten l, Bknoten r) {
		if (sa == 2) {
			System.out.println("Knoten ist schon voll");
			return;
		}
		sa = 2;
		if (key < s[0]) {
			s[1] = s[0];
			s[0] = key;
			p[0] = l;
			p[2] = p[1];
			p[1] = r;
		} else {
			s[1] = key;
			p[1] = l;
			p[2] = r;
		}
	}

}
