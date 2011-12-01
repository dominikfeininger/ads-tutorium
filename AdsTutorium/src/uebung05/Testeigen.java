package uebung05;

import static gdi.MakeItSimple.*;

public class Testeigen {

	public static void main(String args[]) {
		List list = new List();

		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);

		list.printList();

		println();

		list.delete(5);

		list.printList();

		println();

		println(list.contains(3));

		list.printList();
	}

}
