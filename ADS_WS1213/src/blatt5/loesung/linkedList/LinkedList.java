package blatt5.loesung.linkedList;

import static gdi.MakeItSimple.*;

//////////////list class  ////////////////////////////////////////////////

public class LinkedList {

	Node head; // tail darf ggf. ergänzt werden

	// >>>>>>>>>> constructors <<<<<<<<<<<<<<<

	public LinkedList(Node p) {
		head = p;
	}

	public LinkedList() {
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
	public LinkedList clone() {

		// creates a deep copy of the this-list and returns a new list

		Node next = this.head; // first element of list l

		LinkedList resultlist = new LinkedList(); // initialize new list

		if (!isEmpty()) // copy deep if origin this-list is not empty

			while (next != null) {
				resultlist.addLast(next.val);
				next = next.getNext();
			}

		return resultlist;

	}
	
	public void addAll (LinkedList otherList) {
		// appends a deep copy of otherList to this-list
		
		LinkedList tempList = otherList.clone();
		this.append(tempList);
	}
	
	private void append (LinkedList otherList) {
		
		//appends otherList to this-list
		
		Node next = this.head;
		
		if (!isEmpty()) { // move to last element of this-list

			while (next.getNext() != null) 
				next = next.getNext();
			
			next.setNext(otherList.head);
		}
		else // this-list is empty
			this.head = otherList.head;	
	}
	
	
	public LinkedList concat(LinkedList l) {

		// creates a deep copy of the this-list
		// creates a deep copy of the list l
		// concatenates the 2 lists
		// and returns this new list

		Node next = this.head; // first element of list

		LinkedList resultlist = new LinkedList(); // initialize new list

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
	
	public int get (int index) {  // index range of list starts with 1
		
		if (index < 1 || index > this.size()) {
			println("Zugriff außerhalb des gültigen Bereichs!");
			return -1;
		}
		
		else {
			Node p = head;
			for (int i = 1; i < index; i++)  p = p.getNext();
				
			return p.getNode();		
		}
	}
	
	public int add (int val, int index) {  // index range of list starts with 1
		
		if (index < 1 || index > this.size()) {
			println("Zugriff außerhalb des gültigen Bereichs!");
			return -1;
		}
		else if (index == 1) {
			 head = new Node(val, head);
			 return index;
		}		
		else {
			Node p = head;
			for (int i = 1; i < index-1; i++)  p = p.getNext();
			p.next = new Node(val, p.getNext()); // create a new element
			return index;
		}
	}
	
	public int[] toArray () {
		
		int [] result = new int [this.size()];
		
		for (int i = 0; i < result.length; i++)
			result[i] = this.get(i+1);
		
		return result;
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
		
		while (p != null) {
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
	
	public String toString (){ // returns elements of list as string

		Node p = head;
		int cnt = 0;
		String res = "";

		while (p != null) {
			if (cnt > 0)
				res += ", ";
			res += p.val;
			p = p.getNext();
			cnt++;
		}
		res += "\n";
		return res;
	}

	public static LinkedList empty() { // calls the constructor
		return new LinkedList();
	}

}

// ////////////end of list class ///////////////////////////////////////

