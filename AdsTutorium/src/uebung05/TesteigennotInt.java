package uebung05;

import static gdi.MakeItSimple.*;

public class TesteigennotInt {

	public static void main(String args[]) {
		ListnotInt list = new ListnotInt();

		list.addFirst("hallo");
		list.addFirst("else");
		list.addFirst("what");
		list.addFirst("?");
		list.addFirst("greatest");
		list.printList();
		println();
		println();
		list.cloneDeep();
		println();
		println();
	}

}
