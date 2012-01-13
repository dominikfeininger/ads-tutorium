package muster.linkedList_v3;

import muster.basics.*;

public class ListNode {
	
	// Geeignet zur Verwaltung aller Objekte vom Typ Element
	
	private Element val;  // abstract class Element is defined in default package
	private ListNode next;

	//>>>>>>>>>>    constructors     <<<<<<<<<<<<<<<

	public ListNode (Element val, ListNode n) {
		this.val = val;
		this.next = n;
	}

	public ListNode (Element val) {
		this.val = val;
		this.next = null;
	}

	public ListNode () {
		this.val = null;
		this.next = null;
	}
	
	public ListNode clone() {
		ListNode cloned = new ListNode();
		cloned.val = val.clone();
		return cloned;
	}

	//---------------  public methods --------------------------------------------

	public void print () {
		val.print();
	}
	
	public String toString () {
		return val.toString();
	}

	public Element getListVal () {
		return val;
	}

	public void setListVal (Element val) {
		this.val = val;
	}

	public void setNext (ListNode n) {
		this.next = n;
	}

	public ListNode getNext () {
		return next;
		
	}
}

