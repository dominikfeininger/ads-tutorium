package linkedList;

import static gdi.MakeItSimple.*;

//////////////list class  ////////////////////////////////////////////////

public class List {

	Node head; // tail darf ggf. ergänzt werden

	// >>>>>>>>>> constructors <<<<<<<<<<<<<<<

	public List(Node p) {
		head = p;
	}

	public List() {
		head = null;
	}

	// --------------- public methods
	// --------------------------------------------

	public void addFirst(int val) {

		// inserts val in a new element at head of the list
		// element is created inside method addFirst

		Node n = new Node(val, head); // create a new element
		head = n;

		// head = n;
	}

	public void addLast(int val) {

		// inserts val at a new element at tail of the list
		// element is created inside method addFirst

		Node l = head;
		while (l != null && l.getNext() != null)
			l = l.getNext();

		Node n = new Node(val); // create a new element
		if (head == null)
			head = n;
		else
			l.setNext(n); // link the new element
	}

	public Node removeLast() {

		// removes last element of the list

		// search last but one element of list

		Node l = head; // last element in list
		Node lbo = null; // last but one (lbo) element of list

		if (isEmpty())
			return null; // nothing to delete

		while (l.getNext() != null) { // search for last but one element
			lbo = l;
			l = l.getNext();
		}

		if (lbo == null) { // exactly 1 element in list
			head = null;
			return l;
		}

		else {
			lbo.next = null; // delete reference to successor
			return l;
		}

	}

	public Node removeFirst() {

		// removes first element of the list

		Node l = head;

		if (head != null) {
			head = head.getNext();
		}

		return l;
	}

	public Node getFirst() {

		// returns first element of the list

		return head;

	}

	@Override
	public List clone() {

		// creates a deep copy of the this-list and returns a new list

		Node next = this.head; // first element of list l

		List resultlist = new List(); // initialize new list

		if (!isEmpty()) // copy deep if origin this-list is not empty

			while (next != null) {
				resultlist.addLast(next.val);
				next = next.getNext();
			}

		return resultlist;

	}

	public List concat(List l) {

		// creates a deep copy of the this-list
		// creates a deep copy of the list l
		// concatenates the 2 lists
		// and returns this new list

		Node next = this.head; // first element of list

		List resultlist = new List(); // initialize new list

		if (!isEmpty()) // copy deep if origin this-list is not empty == clone

			while (next != null) {
				resultlist.addLast(next.val);
				next = next.getNext();
			}

		next = l.head;

		if (!isEmpty()) // copy deep if origin list l is not empty

			while (next != null) {
				resultlist.addLast(next.val);
				next = next.getNext();
			}

		return resultlist;

	}

	public boolean isEmpty() {
		return head == null;
	}

	public void clear() {
		head = null;
	}

	// count elements
	public int size() {

		int s = 0;

		Node p = head;
		if (head == null)
			return 0;
		while (p.getNext() != null) {
			s++;
			p = p.getNext();
		}
		return s;
	}

	public int printList() { // returns no. of printed elements

		Node p = head;
		int cnt = 0;

		while (p != null) {
			if (cnt > 0)
				print(", ");
			p.print();
			p = p.getNext();
			cnt++;
		}
		println();
		return cnt;
	}

	public static List empty() { // calls the constructor
		return new List();
	}

}

// ////////////end of list class ///////////////////////////////////////

