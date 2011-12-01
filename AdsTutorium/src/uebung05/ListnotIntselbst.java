package uebung05;

import static gdi.MakeItSimple.*;

public class ListnotIntselbst {

	/**
	 * @param args
	 */
	Node head;
	Node tail;

	public ListnotIntselbst() {
		this.head = null;
		this.tail = null;
	}

	public ListnotIntselbst(int value) {
		this.addFirst(value);
	}

	public void addFirst(int value) {
		Node element = new Node();
		element.val = value;
		element.next = this.head;
		if (isEmpty()) {
			this.head = element;
			this.tail = element;
		} else {
			this.head = element;
		}
	}

	public void addLast(int value) {
		Node element = new Node(); // create Node
		element.val = value;
		element.next = null;
		// search tail of list
		Node p = this.head;
		while (p != null && p.next != null) {
			p = p.next;
		}
		// append at tail
		if (p == null) // empty list
			this.head = element;
		else
			// list contains elements
			p.next = element;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public int getFirst() {
		return this.head.val;
	}

	public int getLast() {
		return this.tail.val;
	}

	public void removeFirst() {
		this.head = head.next;
	}

	public void printList() {
		Node pointer;
		pointer = this.head;
		if (!isEmpty()) {
			while (pointer.next != null) {
				print(pointer.val + " ");
				pointer = pointer.next;
			}
			print(this.tail.val);
		}
	}

	public boolean contains(int value) {
		Node pointer;
		pointer = this.head;
		if (!isEmpty()) {
			while (pointer.next != null) {
				if (pointer.val == value) {
					return true;
				}
				pointer = pointer.next;
			}
		}
		return false;
	}

	public void clear() {
		this.head = null;
		this.tail = null;
	}

	public int size() {
		Node pointer;
		pointer = this.head;
		int sizeCounter = 0;
		if (!isEmpty()) {
			while (pointer.next != null) {
				sizeCounter++;
				pointer = pointer.next;
			}
			sizeCounter++;
		}
		return sizeCounter;
	}

	public ListnotIntselbst clone() {
		ListnotIntselbst clonedList = this;
		return clonedList;
	}

	public void delete(int value) {
		Node pointer;
		pointer = this.head;
		if (!isEmpty()) {
			if (pointer.val == value) {
				removeFirst();
				return;
			}
			while (pointer != null) {
				if (pointer.next.val == value) {
					pointer.next = pointer.next.next;
				}
				if (pointer.next.next == null && pointer.next.val == value) {
					this.tail = pointer;
				}
				pointer = pointer.next;
			}
		}
	}

	public List cloneDeep() {
		List listcd = new List();
		Node pointer = this.head;
		while (pointer != null) {
			listcd.addLast(pointer.val);
			pointer = pointer.next;
		}
		return listcd;
	}

	public void concatList(List list) {
		List concatList = list.cloneDeep();
		Node pointer = concatList.head;
		while (pointer != null) {
			this.addLast(pointer.val);
			pointer = pointer.next;
		}
	}
}