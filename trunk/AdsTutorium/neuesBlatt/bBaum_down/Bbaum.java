package bBaum_down;

/**
 * 
 * File: Bbaum.java
 * 
 * @author Dominik Feininger ?
 */

// xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
// Bbaum-KLASSE
// xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
public class Bbaum {

	Bknoten Wurzel; // Wurzel des Baumes

	// ---Konstruktor--------------------------------------------------------------------

	public Bbaum() {

		Wurzel = null;

	}

	// ---sucht nach einem Schluessel in einem
	// B-Baum:-----------------------------------

	public boolean suche(int key) {
		return suche(key, Wurzel);
	}

	public boolean suche(int key, Bknoten k) {

		// Suche endet im Blatt:

		if (k == null)
			return false;

		// falls nur ein Schluessel enthalten ist:

		if (k.sa == 1) {

			if (k.s[0] == key)
				return true;

			if (key < k.s[0])
				return suche(key, k.p[0]);

			if (key > k.s[0])
				return suche(key, k.p[1]);

		}

		// falls zwei Schluessel enthalten sind:

		if (key < k.s[0])
			return suche(key, k.p[0]);

		if ((key > k.s[0]) && (key < k.s[1]))
			return suche(key, k.p[1]);

		if (key > k.s[1])
			return suche(key, k.p[2]);

		return true;

	}

	// ---Fuegt einen neuen Schluessel in den B-Baum
	// ein---------------------------------

	public void einfuegen(int key) {

		// falls der Schluessel bereits vorhanden ist:

		if (suche(key)) {
			System.out.println("Schluessel " + key + " bereits vorhanden!");
			return;
		}

		System.out.println(key + " einfuegen");

		// Baum ist leer:

		if (Wurzel == null) {
			Wurzel = new Bknoten(key, null, null, null);
			return;
		}

		// sonst:

		einfuegen(key, Wurzel);

	}

	// ---------------------------------------------------------------------------------

	public void einfuegen(int key, Bknoten k) {

		// Knoten hat nur einen Schluessel:

		if (k.sa == 1) {

			if (key < k.s[0]) {

				if (k.p[0] == null) {
					k.dazufuegen(key, null, null);
					return;
				}// hier dazufuegen

				else {
					einfuegen(key, k.p[0]);
					return;
				} // weiterreichen

			} else {

				if (k.p[1] == null) {
					k.dazufuegen(key, null, null);
					return;
				}// hier dazufuegen

				else {
					einfuegen(key, k.p[1]);
					return;
				} // weiterreichen

			}

		}

		// Knoten hat zwei Schluessel:

		if (key < k.s[0]) {

			if (k.p[0] == null) {
				teilen(key, k, null, null);
				return;
			}

			else {
				einfuegen(key, k.p[0]);
				return;
			}

		}

		if (key > k.s[1]) {

			if (k.p[2] == null) {
				teilen(key, k, null, null);
				return;
			}

			else {
				einfuegen(key, k.p[2]);
				return;
			}

		}

		if (k.p[1] == null) {
			teilen(key, k, null, null);
			return;
		}

		else {
			einfuegen(key, k.p[1]);
			return;
		}

	}

	// -------------------------------------------------------------------------------

	/*
	 * Die Methode <teilen> fuegt den Schluessel key in den Knoten k ein.
	 * 
	 * Dabei sind l und r Zeiger auf Knoten,die Schluessel < key,bzw > key
	 * 
	 * enthalten.
	 * 
	 * 
	 * 
	 * Dabei wird k eventuell in zwei Knoten aufgeteilt,und der mittlere
	 * 
	 * Schluesselwert in den Vaterknoten ebenfalls durch die <teile>
	 * 
	 * Methode eingefuegt,bis zur Wurzel.
	 */

	// -------------------------------------------------------------------------------
	public void teilen(int key, Bknoten k, Bknoten l, Bknoten r) {

		Bknoten k0, k1, k2, v;

		// Wurzel teilen:

		if (k == null) {

			Wurzel = new Bknoten(key, null, l, r);

			l.v = Wurzel;
			r.v = Wurzel;

			return;

		}

		// falls der Knoten nur einen Schluessel hat:(kein teilen)

		if (k.sa == 1) {

			k.dazufuegen(key, l, r);

			return;

		}

		// falls der Knoten mehrere Schluessel hat:

		v = k.v;

		// key am kleinsten

		if (key < k.s[0]) {

			k0 = new Bknoten(key, v, l, r); // teilt den Knoten auf

			k1 = new Bknoten(k.s[1], v, k.p[1], k.p[2]); // "          "

			k0.v = v;
			k1.v = v;

			teilen(k.s[0], v, k0, k1); // den mittleren Schluessel nach oben
			// weiterreichen

			return;

		}

		// key am groessten

		if (key > k.s[1]) {

			k0 = new Bknoten(k.s[0], v, k.p[0], k.p[1]);

			k1 = new Bknoten(key, v, l, r);

			k0.v = v;
			k1.v = v;

			teilen(k.s[1], v, k0, k1);

			return;

		}

		// key dazwischen

		k0 = new Bknoten(k.s[0], v, k.p[0], l);

		k1 = new Bknoten(k.s[1], v, r, k.p[2]);

		k0.v = v;
		k1.v = v;

		teilen(key, v, k0, k1);

		return;

	}

}
