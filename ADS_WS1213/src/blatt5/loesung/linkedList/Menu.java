package blatt5.loesung.linkedList;

import static gdi.MakeItSimple.*;

//first level OO linked list

//Hinweis: Es werden keine Objekte in der LL verwaltet, sondern nur int-Werte

	
	enum Action  {af, al, rf, rl, ie, cl, co, cw, pl, dn, hp, df, ey, cr, gt, ad, aa, ta};

	//	Mögliche Aktionen (für die working list):
	// 	addFirst --> af
	//	addLast --> al
	//	removeFirst --> rf
	//	removeLast --> rl
	//	isEmpty --> ie
	//	clone --> cl
	//	concatenate --> co
	//	change workling list --> cw
	//	printList --> pl
	//	terminiere --> dn
	//  help --> gib Menü aus
	//	empty (create empty list) --> ey
	//	clear (list) --> cr
	// 	get (index) --> gt
	//  add (val, index) --> ad
	//	addAll --> aa
	// 	toArray --> ta
	//	default --> df
	

public class Menu {

	public static void menue() {

		println("Mögliche Aktionen (für die working list):");
		println(" addFirst --> af");
		println(" addLast --> al");
		println(" removeFirst --> rf");
		println(" removeLast --> rl");
		println(" isEmpty --> ie");
		println(" clone --> cl");
		println(" concatenate --> co");
		println(" change workling list --> cw");
		println(" printList --> pl");
		println(" terminate --> dn");
		println(" help (print full menu --> hp");
		println(" clear (list) --> cr");
		println(" empty (create new empty list) --> ey");
		println(" clear (list) --> cr");
		println(" get (index) --> gt");
		println(" add (val, index) --> ad");
		println(" addAll --> aa");
		println(" toArray --> ta");
	}

	public static void shortMenue() {

		println("af/al/rf/rl/ie/cl/co/cw/pl/dn/hp/cr/ey/gt/ad/aa/ta");
	}

	public static int readLN(int sz) { // liefert nur zulässige Listennummern <  sz zurück

		int ln;

		while ((ln = readInt()) >= sz || ln < 0)
			;
		readLine(); // aus technischen Gründen --> makeItSimple

		return ln;
	}

	public static Action getAction() {

		String s = readLine();

		if (s.equals("af"))
			return Action.af;
		else if (s.equals("al"))
			return Action.al;
		else if (s.equals("rf"))
			return Action.rf;
		else if (s.equals("rl"))
			return Action.rl;
		else if (s.equals("ie"))
			return Action.ie;
		else if (s.equals("cl"))
			return Action.cl;
		else if (s.equals("co"))
			return Action.co;
		else if (s.equals("cw"))
			return Action.cw;
		else if (s.equals("pl"))
			return Action.pl;
		else if (s.equals("hp"))
			return Action.hp;
		else if (s.equals("dn"))
			return Action.dn;
		else if (s.equals("cr"))
			return Action.cr;
		else if (s.equals("gt"))
			return Action.gt;
		else if (s.equals("ad"))
			return Action.ad;
		else if (s.equals("aa"))
			return Action.aa;
		else if (s.equals("ta"))
			return Action.ta;
		else
			return Action.df;
	}

	public static void main(String[] args) {

		LinkedList la[] = new LinkedList[4];

		for (int i = 0; i < 4; i++)
			la[i] = new LinkedList();

		int wl = 0; // working list per default

		// Große Schleife für EINE working list
		// In dieser Schleife können alle Operationen per switch ausgeführt
		// werden.
		// Zusätzliche Operationen: Ausgabe der aktuellen working list Nummer
		// Ändern der aktuellen workimg list

		menue(); // Alle möglichen Aktionen ausgeben

		while (true) {

			shortMenue(); // Alle möglichen Aktionen ausgeben

			switch (getAction()) {
			case af: {
				println("Wert = ");
				la[wl].addFirst(readInt());
				readLine(); // aus technischen Gründen --> makeItSimple
				break;
			}

			case al: {
				println("Wert = ");
				la[wl].addLast(readInt());
				readLine(); // aus technischen Gründen --> makeItSimple
				break;
			}
			case rf: {
				Node p = la[wl].removeFirst();
				if (p != null)
					println("node " + p.val + " removed");
				else
					println("list is empty - nothing to remove");

				break;
			}

			case pl: {
				System.out.println(la[wl]);
//				la[wl].printList();
				break;
			}

			case rl: {
				Node p = la[wl].removeLast();
				if (p != null)
					println("node " + p.val + " removed");
				else
					println("list is empty - nothing to remove");

				break;
			}
			case ie: {
				if (la[wl].isEmpty())
					println("Liste " + wl + " ist leer.");
				else
					println("Liste " + wl + " ist nicht leer.");

				break;
			}
			case cl: {
				println("In welche Liste soll working list gecloned werden? Nummer = ");
				la[readLN(la.length)] = la[wl].clone();

				break;
			}

			case co: {
				println("Welche Liste sollen mit der working list konkateniert werden? Nummer = ");
				int clno = readLN(la.length);
				println("Welcher Liste soll die konkatenierte Liste zugewiesen werden? Nummer = ");
				la[readLN(la.length)] = la[wl].concat(la[clno]);

				break;
			}

			case cw: {
				println("Welche Liste soll working list werden? Nummer = ");
				wl = readLN(la.length);
				println("Neue working list = Liste Nr. " + wl);

				break;
			}

			case dn: { // terminiert z.Zt. die Schleife
				return;
			}

			case hp: {
				menue();
				break;
			}

			case cr: {
				la[wl].clear();
				break;
			}

			case ey: {
				la[wl] = LinkedList.empty();
				break;
			}
			
			case gt: {
				println("An welcher Stelle der Liste soll das hinterlegte Element gelesen werden?");
				int idx = readInt();
				println ("Wert an Stelle "+ idx + " = " + la[wl].get(idx));

				break;
			}
			case ad: {
				println("An welcher Stelle der Liste soll das  Element abgelegt werden?");
				int idx = readInt();
				println("Eelment =");
				int val = readInt();
				println ("Wert an Stelle "+ la[wl].add(val,idx) + " erfolgreich abgelegt.");

				break;
			}
			
			case ta: {
				int[] intArray = la[wl].toArray();
				println ("Liste als Array");
				for (int i = 0; i < intArray.length-1; i++ ) print(intArray[i] + ", ");
				println (intArray[intArray.length-1]);

				break;
			}

			default: {
				readLine(); // aus technischen Gründen --> makeItSimple
				break;
			}

			}

		}
	}
}

