package gruppe_2_6;

import static gdi.MakeItSimple.*;

public class MyLinkedList implements LinkedList {
	ListNode head;

	/**
	 * adds an element at the first position of the list
	 */
	public void addFirst(MyObject element) {
		ListNode tmpelement = new ListNode();
		tmpelement.setElement(element);
		tmpelement.setNext(head);
		head = tmpelement;
	}

	/**
	 * adds an element at the last position of the list
	 */
	public void addLast(MyObject element) {
		ListNode tmpelement = new ListNode(); // Create temp ListNode
		tmpelement.setElement(element);
		tmpelement.setNext(null);
		// search tail of list
		ListNode n = head;
		while (n != null && n.getNext() != null) {
			n = n.getNext();
		}
		if (n == null) // empty list
			head = tmpelement;
		else
			// list contains elements
			n.setNext(tmpelement);
	}

	public void add(int index, MyObject element) {
		int i = 0;
		// Start at head and go to the Position
		ListNode n = head;
		while (i < index && n.getNext() != null) {
			n = n.getNext();
			i++;
		}
		// Check if the inputed index i valid
		if (i < index) { // If the Index is bigger then add the element on the
							// last position
			ListNode tempelement = new ListNode();
			println("Dieser Index ist nicht vorhanden es wird stattdessen an der Position des letzten Elements der Liste angeh�ngt ");
			tempelement.setElement(element);
			tempelement.setNext(null);
			n.setNext(tempelement);
		} else { // If not then put the element on the position
			ListNode tempelement = new ListNode();
			tempelement.setElement(element);
			tempelement.setNext(n.getNext());
			n.setNext(tempelement);
		}
	}

	/**
	 * deletes first element of the list. The list must contain at least one
	 * element
	 */
	public void removeFirst() {
		if (head.getNext() != null) {
			ListNode tempelement = head.getNext();
			head = tempelement;
		} else
			head = null;
	}

	/**
	 * deletes last element of the list. The list must contain at least one
	 * element
	 */
	public void removeLast() {
		// Set the head as first element and look if there are more then one
		// element
		ListNode tempelement1 = head;
		if (tempelement1.getNext() != null) { // if there are more elements go
												// to the last one
			ListNode tempelement2 = tempelement1.getNext();
			while (tempelement2.getNext() != null) {
				tempelement1 = tempelement2;
				tempelement2 = tempelement2.getNext();
			}
			tempelement1.setNext(null);
		} else
			// if there is only one element
			head = null;
	}
	
	/* (non-Javadoc)
	 * @see uebung05.LinkedList#remove(int)
	 */
	public void remove(int index){
		int i = 0;
		ListNode n = head;
		ListNode tmpelement = new ListNode(); // Create temp ListNode
		// Go throw the List and find the element
		while (i < index && n.getNext() != null) {
			tmpelement = n;
			n = n.getNext();
			i++;
		}// Erase it if found or give an error that it not exsist
		if (i < index)
			println("Dieser Index ist nicht vorhanden! ");
		else{
			n=tmpelement.getNext();
			tmpelement.setNext(n.getNext());
		}
	}
	
	/**
	 * returns the first element of the list. The list must contain at least one
	 * element !!
	 */
	public MyObject getFirst() {
		return head.getElement();
	}

	/**
	 * returns the last element of the list. The list must contain at least one
	 * element !!
	 */
	public MyObject getLast() {
		ListNode n = head;
		while (n.getNext() != null) {
			n = n.getNext();
		}
		return n.getElement();
	}

	/**
	 * returns the element at index. The list must contain at least one element
	 * !!
	 */
	public MyObject get(int index) {
		int i = 0;
		ListNode n = head;
		while (i < index && n.getNext() != null) {
			n = n.getNext();
			i++;
		}
		if (i < index)
			println("Dieses Element ist nicht vorhanden es wird stattdessen das letzte Element der Liste mit dem index "
					+ i + " ausgegeben.");
		return n.getElement();
	}

	/**
	 * checks if list contains any elements
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		int i = 1;
		String Output = "";
		ListNode n = head;
		// Start at head an go throw all elements and save them in the Output
		// String
		while (n != null && n.getNext() != null) {
			Output = Output + i + ". Element: " + n.getElement();
			n = n.getNext();
			i++;
		}
		// Add the last element
		Output = Output + i + ". Element: " + n.getElement();
		return Output;
	}

	public MyLinkedList empty() {
		return  new MyLinkedList();
	}

	/* (non-Javadoc)
	 * @see uebung05.LinkedList#contains(uebung05.MyObject)
	 */
	public boolean contains(MyObject element) {
		// Start at head an go throw the list if the element is there true else false
		ListNode n = head;
		if (n.getNext() == null) {
			if (n.getElement().getValue() == element.getValue())
				return true;
		}
		else{
			while (n.getNext() != null) {
				if (n.getElement().getValue() == element.getValue())
					return true;
				n = n.getNext();
			}
			if (n.getElement().getValue() == element.getValue())
				return true;
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see uebung05.LinkedList#removeAll()
	 */
	public void removeAll() {
		int s=0,e=size() ;
		while(s<e){
			removeFirst();
			s++;
		}
	}

	public int size() {
		int cnt = 1;
		ListNode n = head;
		while (n != null && n.getNext() != null) {
			n = n.getNext();
			cnt++;
		}
		if (head != null)
			return cnt;
		else
			return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uebung05.LinkedList#toArray()
	 */
	public MyObject[] toArray() {
		int alength, i = 0;
		alength = size();
		MyObject AoObject[] = new MyObject[alength];
		while (i < alength) {
			AoObject[i] = get(i);
			i++;
		}
		return AoObject;
	}

	/* (non-Javadoc)
	 * @see uebung05.LinkedList#addAll(uebung05.LinkedList)
	 */
	public void addAll(LinkedList otherList) {
		int s=0,e ;
		e=otherList.size();
		//Set the end to the otherlist length and then go throw and add all elements at the end
		while (s<e){
			println(otherList.size());
			addLast(otherList.get(s));
			s++;
		}
	}

	public void cloneDeep() {

	}

}
