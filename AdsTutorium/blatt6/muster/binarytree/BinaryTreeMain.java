package muster.binarytree;

import static gdi.MakeItSimple.*;
import muster.basics.Element;
import muster.basics.IntElement;




enum Action  {i, s, d, ie, cl, b, f, cw, pp, pi, ppo, pl, h, ey, df, cr, dn };

//	Mögliche Aktionen (für den working tree):
// 	insert --> i
//	search --> s
//	delete --> d
//	isEmpty --> ie
//	clone --> cl
//	build form file --> b
//	save to file --> f
//	change working tree --> cw
//	printTree:
//			preorder   --> pp
//			inorder    --> pi
//			postorder  --> ppo
//			levelorder --> pl
//  help --> h (gib Menü aus)
//	empty (create empty tree) --> ey
//	clear (tree) --> cr
//	default --> df
//	terminiere --> dn




////////////////////////   main program      //////////////////////////////////


public class BinaryTreeMain  {
	

	public static void menue() {
		
		println ("Mögliche Aktionen (für den working tree):");
		println (" insert --> i");
		println (" search --> s");
		println (" isEmpty --> ie");
		println (" delete --> d");
		println (" clone --> cl");
		println (" build form file --> b");
		println (" save to file --> f");
		println (" change workling tree --> cw");
		println (" printpreorder --> pp");
		println (" printpostorder --> ppo");
		println (" printinorder --> pi");
		println (" printlevelorder --> pl");
		println (" terminate --> dn");
		println (" help (print full menu --> hp");
		println (" clear (tree) --> cr");
		println (" empty (create new empty tree) --> ey");
	}
	

	public static void shortMenue() {
		
		println();
		println ("i/s/d/ie/cl/b/f/cw/pp/pi/ppo/pl/h/ey/cr/dn/df");
	}
	
	public static int readLN (int sz) {  // liefert nur zulässige Baumnummern < sz zurück
		
		int ln;
		
		while ((ln=readInt())>= sz || ln < 0);
		readLine();  // aus technischen Gründen --> makeItSimple
		
		return ln;
	}
	
	
	public static Action getAction () {
		
		String s = readLine();
		
		if (s.equals("i")) return Action.i;
		else if (s.equals("s")) return Action.s;
		else if (s.equals("d")) return Action.d;
		else if (s.equals("ie")) return Action.ie;
		else if (s.equals("cl")) return Action.cl;
		else if (s.equals("b")) return Action.b;
		else if (s.equals("f")) return Action.f;
		else if (s.equals("cw")) return Action.cw;
		else if (s.equals("pp")) return Action.pp;
		else if (s.equals("pi")) return Action.pi;
		else if (s.equals("ppo")) return Action.ppo;		
		else if (s.equals("pl")) return Action.pl;
		else if (s.equals("h")) return Action.h;
		else if (s.equals("ey")) return Action.ey;
		else if (s.equals("cr")) return Action.cr;
		else if (s.equals("dn")) return Action.dn;
		else return Action.df;
	}

  public static void main(String[] args) {
	  
	char c;
    Element elem = null;

	BinaryTree tree = new BinaryTree (); // new instance of list
	BinaryTree cptree = null;            // deep copy of tree
	BinaryTree tt;

	int value;
	
	BinaryTree ta [] = new BinaryTree [4];
	
	for (int i = 0; i < 4; i++)
		ta [i] = new BinaryTree();
	
	int wt = 0; // working tree per default
	
	// Große Schleife für EINEN working tree
	// In dieser Schleife können alle Operationen per switch ausgeführt werden.
	// Zusätzliche Operationen: Ausgabe der aktuellen working tree Nummer
	// Ändern des aktuellen working tree
	
	println ("Starting Binary Tree ... ");
	
	menue();  // Alle möglichen Aktionen ausgeben
	
	while (true) {
		
		shortMenue();  // Alle möglichen Aktionen ausgeben
		

		switch (getAction()) {
			case i: {
				println("insert = ");
				elem = new IntElement(readInt()); readLine();
				if (ta[wt].insertr(elem))
					println(elem.toString() + " inserted");
				else
					println(elem.toString() + " already in tree");
				break;
			}
			
			case s: {
				println("search = ");
				elem = new IntElement(readInt()); readLine();
				if (ta[wt].find (elem))
				  println (elem.toString() + " found");
				else
				  println (elem.toString() + " not found");
				break;
			}
			
			case d: {
			  	println ("element to be deleted: ");
				elem = new IntElement(readInt()); readLine();
				if (ta[wt].remove (elem))
				  println (elem.toString() + " removed");
				else
				  println (elem.toString() + " not found");
				break;
			}
			
			case ie: {
				println("tree emty = " + ta[wt].ieEmpty());
				break;
			}
			
			case pp: {
				ta[wt].traverse(2);
				break;
			}
			
			case pi: {
				ta[wt].traverse(1);
				break;
			}
			
			case ppo: {
				ta[wt].traverse(3);
				break;
			}
			
			case pl: {
				ta[wt].traverse(4);
				break;
			}
			
			case cl: {
				println("destination of copy (no. of tree) = ");
				ta[readLN(ta.length)] = ta[wt].clone();
				cptree = tree.clone();
				break;
			}
			
			case b: {
				if (ta[wt].build())
					println("Baum erfolgreich aufgebaut");
				else
					println ("Baum konnte nicht erstellt werden");
				break;
			}
			
			case f: {
				if (ta[wt].save())
					println("Baum erfolgreich gesichert");
				else
					println ("Baum konnte nicht gesichert werden");
				break;
			}
			
			case cw: {
				println ("Welcher Baum soll working tree werden? Nummer = ");
				wt = readLN(ta.length);
				println ("Neue working list = Liste Nr. " + wt);
				break;
			}
			case h: {
				menue();
				break;
			}
			
			case ey: {
				ta[wt] = BinaryTree.empty();
				break;
			}

			case cr: {
				ta[wt].clear();
				break;
			}
			
			case dn: {
				return; // terminiert z.Zt. die Schleife
			}
				
			default: {
				readLine();
				break;
			}
		}
	}
  }
}

	  