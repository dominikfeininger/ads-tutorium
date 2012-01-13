package gruppe_2_9;

import static gdi.MakeItSimple.*;

public class Main {

	public static void main(String[] args) {

		while (true) {
			makeMenu();
		}
	}

	public static void makeMenu() {
		boolean change=false;
		BinaryTree bt[] = new BinaryTree[3]; // array with 3 linked lists

		for (int i = 0; i < bt.length; i++)
			bt[i] = new BinaryTree();
		int wl = 0;// working list per default
		while (true) {
			if(!change){
				wl=0;
			}

			println("------------------- Men� -------------------");
			println("1: Print Tree"); //x calls method toString
			println("2: Print size of the Tree");//
			println("3: Print height of the Tree");//
			println("4: add(element)");//x
			println("5: getMax()");//
			println("6: getMin()");//
			println("7: contains(element)");//x
			println("8: remove(element)");//
			println("9: isEmpty(element)");//
			println("10: empty()"); //x returns a new (empty) list, has to be
									// implemented as a static method
			println("11: change working list"); //x sets another list as working
												// list

			// - toString: gibt einen String zurück, der den gesamten Inhalt
			// der Liste enthält.
			// - add(int index, MyObject element): fügt das Element element an
			// der Stelle index in die Liste ein.
			// - get(int index): gibt das Element an der Stelle index zurück.
			// - toArray : liefert die LinkedList als Array von Objekten
			// zurück.
			// - addAll(LinkedList otherList)

			int selection = readInt();

			switch (selection) {
			case 1:
				bt[wl].printPreorder();
				break;
			case 2:
				println(bt[wl].size());
				break;
			case 3:
				println(bt[wl].height());
				break;
			case 4:
				println("value to add= ");
				int i = readInt();
				bt[wl].insert(i);
				break;
			case 5:
				println("Max= ");
				println(bt[wl].getMax());
				break;
		
			case 6:
				println("Min= ");
				println(bt[wl].getMin());
				break;
		
			case 7:
				println("value to search= ");
				int o = readInt();
				println(bt[wl].contains(o));
				break;
			case 8:
				int o1 = readInt();
				println(bt[wl].remove(o1));
				break;
			case 9:
				println(bt[wl].isEmpty());
				break;
			case 10:
//				println("Neue Liste Nr. ");
//				la[wl]=la[wl].empty();
				break;
			case 11:
//				println("W�hle Liste: ");
//				wl = readInt();
//				change=true;
				break;
			default:
				break;
			}
			;

			readLine();
			println();
		}
	}
}
