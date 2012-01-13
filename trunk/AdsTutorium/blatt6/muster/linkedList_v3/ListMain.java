package muster.linkedList_v3;


import static gdi.MakeItSimple.*;
import muster.basics.IntElement;

enum Action  {af, al, rf, rl, ie, cl, co, cw, pl, dn, hp, df, ey, cr};

	//	M�gliche Aktionen (f�r die working list):
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
	//  help --> gib Men� aus
	//	empty (create empty list) --> ey
	//	clear (list) --> cr
	//	default --> df


public class ListMain {
	
	public static void menue() {
		
		println ("M�gliche Aktionen (f�r die working list):");
		println (" addFirst --> af");
		println (" addLast --> al");
		println (" removeFirst --> rf");
		println (" removeLast --> rl");
		println (" isEmpty --> ie");
		println (" clone --> cl");
		println (" concatenate --> co");
		println (" change workling list --> cw");
		println (" printList --> pl");
		println (" terminate --> dn");
		println (" help (print full menu --> hp");
		println (" clear (list) --> cr");
		println (" empty (create new empty list) --> ey");
	}
	
	public static void shortMenue() {
		
		println ("af/al/rf/rl/ie/cl/co/cw/pl/dn/hp/cr/ey");
	}
	
	public static int readLN (int sz) {  // liefert nur zul�ssige Listennummern < sz zur�ck
		
		int ln;
		
		while ((ln=readInt())>= sz || ln < 0);
		readLine();  // aus technischen Gr�nden --> makeItSimple
		
		return ln;
	}
	
	
	public static Action getAction () {
		
		String s = readLine();
		
		if (s.equals("af")) return Action.af;
		else if (s.equals("al")) return Action.al;
		else if (s.equals("rf")) return Action.rf;
		else if (s.equals("rl")) return Action.rl;
		else if (s.equals("ie")) return Action.ie;
		else if (s.equals("cl")) return Action.cl;
		else if (s.equals("co")) return Action.co;
		else if (s.equals("cw")) return Action.cw;
		else if (s.equals("pl")) return Action.pl;
		else if (s.equals("hp")) return Action.hp;
		else if (s.equals("dn")) return Action.dn;
		else if (s.equals("cr")) return Action.cr;
		else if (s.equals("ey")) return Action.ey;
		else return Action.df;
	}

	
	public static void main (String[] args) {
	
			
		List la [] = new List[4];
		
		for (int i = 0; i < 4; i++)
			la [i] = new List();
		
		int wl = 0; // working list per default
		
		// Gro�e Schleife f�r EINE working list
		// In dieser Schleife k�nnen alle Operationen per switch ausgef�hrt werden.
		// Zus�tzliche Operationen: Ausgabe der aktuellen working list Nummer
		// �ndern der aktuellen workimg list
		
		
		println ("Starting program ListMain .... ");
		
		menue();  // Alle m�glichen Aktionen ausgeben
		
		while (true) {
			
			shortMenue();  // Alle m�glichen Aktionen ausgeben
			

			switch (getAction()) {
				case af: {
					println ("Wert = ");
					la[wl].addFirst(new IntElement(readInt()));
					readLine();  // aus technischen Gr�nden --> makeItSimple
					break;
				}
			
				case al: {
					println ("Wert = ");
					la[wl].addLast(new IntElement(readInt()));
					readLine();  // aus technischen Gr�nden --> makeItSimple
			  		break;
				}
				case rf: {
					IntElement p = (IntElement)la[wl].removeFirst();
					if (p != null)
						println ("node " + p.toString() + " removed");
					else
						println ("list is empty - nothing to remove");

					break;
				}
			
				case pl: {
					la[wl].printList();
				break;
				}
				
				case rl: {
					IntElement p = (IntElement)la[wl].removeLast();
					if (p != null)
						println ("node " + p.toString() + " removed");
					else
						println ("list is empty - nothing to remove");

					break;
				}
				case ie: {
					if (la[wl].isEmpty())
						println ("Liste " + wl + " ist leer.");
					else
						println ("Liste " + wl + " ist nicht leer.");

					break;
				}
				case cl: {
					println ("In welche Liste soll working list gecloned werden? Nummer = ");
					la[readLN(la.length)] = la[wl].clone();

					break;
				}
				
				case co: {
					println ("Welche Liste sollen mit der working list konkateniert werden? Nummer = ");
					int clno = readLN(la.length);
					println ("Welcher Liste soll die konkatenierte Liste zugewiesen werden? Nummer = ");
					la[readLN(la.length)] = la[wl].concat(la[clno]);

					break;
				}
				
				case cw: {
					println ("Welche Liste soll working list werden? Nummer = ");
					wl = readLN(la.length);
					println ("Neue working list = Liste Nr. " + wl);

					break;
				}

				case dn: { // terminiert z.Zt. die Schleife
					return;
				}

				case hp : {
					menue();
					break;
				}
				
				case cr : {
					la[wl].clear();
					break;
				}
				
				case ey : {
					la[wl] = List.empty();
					break;
				}

				default : {
					readLine();  // aus technischen Gr�nden --> makeItSimple
					break;
				}
					
				
			}
	
		}
	}

}
