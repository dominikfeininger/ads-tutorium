package gruppe_2_10;

import static gdi.MakeItSimple.*;


public class Menu {
	static LinkedList la[] = new LinkedList[3];  // array with 3 linked lists

	public static void main(String[] args) {
		
		
		for (int i = 0; i < la.length; i++)
			la[i] = new MyLinkedList();
		

		while (true) {
			makeMenu();
		}

	}

	public static void makeMenu() {
	

		int wl = 0; // working list per default
		
		
		println("------------------- Men� -------------------");
		println("1: Print List");  // calls method toString
		println("2: Print size of the list");
		println("3: add(index, element)");
		println("4: addFirst(element)");
		println("5: addLast(element)");
		println("6: addAll(LinkedList)");
		println("7: get(index)");
		println("8: getFirst()");
		println("9: getLast()");
		println("10: removeFirst()");
		println("11: removeLast()");
		println("12: removeAll()");  // calls method clear
		println("13: remove(element)");
		println("14: toArray()");
		println("15: isempty()");
		println("16: contains(element)");
		println("17: delete(index)");  // delete element at index
		println("18: cloneDeep()");
		println("20: empty()");  // returns a new (empty) list, has to be implemented as a static method
		println("30: change working list");  // sets another list as working list
		
		

		int selection = readInt();

		switch (selection) {
		case 1:
//			println(toString());
		case 2:
			// your code here
			break;
		case 3:
			// your code here
			break;
		case 4:
			println("value to add (int)= ");
			int i = readInt();
			MyIntObject obj1 = new MyIntObject(i);  // create a MyIntObject
			la[wl].addFirst(obj1);
		case 5:
			// your code here
			break;
		case 6:
			// your code here
			break;
		case 7:
			// your code here
			break;
		case 8:
			// your code here
			break;
		case 9:
			// your code here
			break;
		case 10:
			// your code here
			break;
		case 11:
			// your code here
			break;
		case 12:
			// your code here
			break;		
		case 13:
			// your code here
			break;
		case 14:
			// your code here
			break;
		case 15:
			// your code here
			break;
		case 16:
			// your code here
			break;
		case 17:
			// your code here
			break;
		case 18:
			// your code here
			break;
		case 20:
			la[wl].empty();
		case 30:
			println("select workinglist");
			println("0: workinglist 1");
			println("1: workinglist 2");
			println("2: workinglist 3");
			wl = readInt();
			while(wl<0||wl>2){
				println("select workinglist");
				println("0: workinglist 1");
				println("1: workinglist 2");
				println("2: workinglist 3");
				wl = readInt();
			}
			println("workinglist: "+wl+" selected.");

		default:
			break;
		}
		;

		readLine();

	}
}

