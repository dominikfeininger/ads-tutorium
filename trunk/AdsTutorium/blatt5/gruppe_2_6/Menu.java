package gruppe_2_6;

import static gdi.MakeItSimple.*;

public class Menu {

	public static void main(String[] args) {

		while (true) {
			makeMenu();
		}
	}

	public static void makeMenu() {
		boolean change=false;
		LinkedList la[] = new LinkedList[3]; // array with 3 linked lists

		for (int i = 0; i < la.length; i++)
			la[i] = new MyLinkedList();
		int wl = 0;// working list per default
		while (true) {
			if(!change){
				wl=0;
			}

			println("------------------- Men� -------------------");
			println("1: Print List"); //x calls method toString
			println("2: Print size of the list");//x
			println("3: add(index, element)");//x
			println("4: addFirst(element)");//x
			println("5: addLast(element)");//x
			println("6: addAll(LinkedList)");//x
			println("7: get(index)");//x
			println("8: getFirst()");//x
			println("9: getLast()");//x
			println("10: removeFirst()");//x
			println("11: removeLast()");//x
			println("12: removeAll()"); //x
			println("13: remove(element)");//x
			println("14: toArray()");//x
			println("15: isempty()");//x
			println("16: contains(element)");//x
			println("18: cloneDeep()");
			println("20: empty()"); //x returns a new (empty) list, has to be
									// implemented as a static method
			println("30: change working list"); //x sets another list as working
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
				println(la[wl].toString());
				break;
			case 2:
				print("Die Liste enth�lt " + la[wl].size() + " Elemente");
				break;
			case 3:
				println("index where to add= ");
				int ix = readInt();
				println("valie to add= ");
				int v = readInt();
				MyObject obj3 = new MyObject(v);
				la[wl].add(ix, obj3);
				break;
			case 4:
				println("value to add= ");
				int i = readInt();
				MyObject obj1 = new MyObject(i); // create a MyObject first before adding to list
				la[wl].addFirst(obj1);
				break;
			case 5:
				println("value to add= ");
				int j = readInt();
				MyObject obj2 = new MyObject(j);
				la[wl].addLast(obj2);
				break;
			case 6:
				println("Which List you want to add: ");
				int l = readInt();
				la[wl].addAll(la[l]);
				
				break;
			case 7:
				println("index to print= ");// The list must contain at least one element
				int tmp = readInt();
				println(la[wl].get(tmp));
				break;
			case 8:
				println(la[wl].getFirst());	// The list must contain at least one element
				break;
			case 9:
				println(la[wl].getLast());	// The list must contain at least one element
				break;
			case 10:
				la[wl].removeFirst();
				break;
			case 11:
				la[wl].removeLast();
				break;
			case 12:
				la[wl].removeAll();
				break;
			case 13:
				println("index where to remove= ");
				int ir = readInt();
				la[wl].remove(ir);
				break;
			case 14:
				MyObject Array[] = new MyObject[la[wl].size()];
				Array = la[wl].toArray();
				for (int k=0;k<Array.length;k++)
					println(Array[k]);
				break;
			case 15:
				if (la[wl].isEmpty())
					println("Die Liste ist leer.");
				else
					println("Die Liste ist nicht leer.");
				break;
			case 16:
				println("value to search= ");
				int o = readInt();
				MyObject obj4 = new MyObject(o);
				println(la[wl].contains(obj4));
				break;
			case 18:
				// your code here
				break;
			case 20:
				println("Neue Liste Nr. ");
				la[wl]=la[wl].empty();
				break;
			case 30:
				println("W�hle Liste: ");
				wl = readInt();
				change=true;
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
