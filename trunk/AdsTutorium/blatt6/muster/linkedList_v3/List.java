package muster.linkedList_v3;

import static gdi.MakeItSimple.*;
import muster.basics.Element;


//first level OO linked list

//Hinweis: Es werden keine Objekte in der LL verwaltet, sondern nur int-Werte


//////////////list class  ////////////////////////////////////////////////

public class List  {
	
	ListNode head;   // tail darf ggf. erg�nzt werden

	//>>>>>>>>>>    constructors     <<<<<<<<<<<<<<<
	
	public List (ListNode p) {
		head = p;
	}
	
	public List () {
		  head = null;
	}
	
	
	//---------------  public methods --------------------------------------------
	
	public void addFirst (Element val) {
	
	// inserts val in a new element at head of the list
	// element is created inside method addFirst
	
	ListNode n = new ListNode (val, head);  // create a new element
	head = n;
	
	// head = n;
	}
	
	public void addLast (Element val) {
	
	// inserts val at a new element at tail of the list
	// element is created inside method addFirst
	
	ListNode l = head;
	while (l != null && l.getNext() != null)
	  l = l.getNext();
	  
	ListNode n = new ListNode (val);  // create a new element
	if (head == null)
		head = n;
	else
		l.setNext(n);  // link the new element
	}
	
	public Element removeLast () {
	
		// removes last element of the list
		
		// search last but one element of list
		
		ListNode l   = head;  // last element in list
		ListNode lbo = null;  // last but one (lbo) element of list
		
		if (isEmpty()) return null;  // nothing to delete
		
		while (l.getNext() != null) { // search for last but one element
		  lbo = l;
		  l = l.getNext();
		}
		
		if (lbo == null)  { // exactly  1 element in list
			head = null;
			return l.getListVal();
		}
			
		else {
			lbo.setNext(null); // delete reference to successor
			return l.getListVal();
		}
		
	}

	public  Element removeFirst () {
		
		// removes first element of the list
		
		ListNode l   = head;
				
		if (head != null) {
		  head = head.getNext();
		}

		return l.getListVal();
	}
	
	public List clone () {
	
		// creates a deep copy of the this-list and returns a new list
	
		ListNode next = this.head; // first element of list l
	
		List resultlist = new List();   // initialize new list
		
		if (! isEmpty())  // copy deep if origin this-list is not empty
	
			while (next!= null) {
			   resultlist.addLast (next.getListVal().clone());  // clone the list value
			   next = next.getNext();
			}
		
		return resultlist;
	
	}
	
	public List concat (List l) {
		
		// creates a deep copy of the this-list
		// creates a deep copy of the list l
		// concatenates the 2 lists
		// and returns this new list
	
		ListNode next = this.head; // first element of list
	
		List resultlist = new List();   // initialize new list
		
		if (!isEmpty())  // copy deep if origin this-list is not empty  == clone
		
			while (next != null) {
			   resultlist.addLast (next.getListVal().clone()); // clone the list value
			   next = next.getNext();
			}
			
		next = l.head;
			
		if (!isEmpty())  // copy deep if origin list l is not empty
			
			while (next != null) {
				   resultlist.addLast (next.getListVal().clone()); // clone the list value
				   next = next.getNext();
			}
			
		return resultlist;
		
	}
	
	public boolean isEmpty () {
		return head  == null;
	}
	
	public void clear () {
		head = null;
	}
	
	
	// count elements
	public int size () {
	
		int s = 0;
	
		ListNode p = head;
		if (head == null) return 0;
		while (p.getNext() != null) {
		  s++;
		  p = p.getNext();
		}
		return s;
	}
	
	public int printList () { // returns no. of printed elements
	
	ListNode p = head;
	int cnt = 0;
	
	while (p != null) {
	  if (cnt > 0) print(", ");
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


//////////////end of list class  ///////////////////////////////////////

