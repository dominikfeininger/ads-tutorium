package uebung05;

import static gdi.MakeItSimple.*;

public class List {

	/**
	 * @param args
	 */
	Node head;
	Node tail;

	public List() {
		this.head = null;
		this.tail = null;
	}

	public List(int value) {
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

	/**
	 * method printList()
	 * The method printList test, if list is null -> don't print anything.
	 * Then it starts a loop till the pointer on the next node is empty(not there).
	 * Then in every loop pass the method print the value of the pointer.
	 * In the next step the pointer will be set to the next node.
	 */
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

	public List clone() {
		List clonedList = this;
		return clonedList;
	}

	public void delete(int value) {
		Node pointer;
		pointer = this.head;
		if (!isEmpty()) {
			if (this.head.val == value) {
				removeFirst();
				return;
			}
			while (pointer.next != null) {
				if (pointer.next.val == value && pointer.next.next == null) {
					pointer.next = null;
					this.tail = pointer;
					return;
				}
				if (pointer.next.val == value) {
					pointer.next = pointer.next.next;
					return;
				}
				pointer = pointer.next;
			}
		}
	}

	/**
	 * method cloneDeep()
	 * The method cloneDeep construct a new object of type List with the name listcd.
	 * An object pointer of type node will be created with the value head.
	 * A loop step through till the pointer is null.
	 * The object listcd runs the method addLast with the value of the pointer on this node.
	 * In the next step the pointer will be set to the next node.
	 * The method returns the cloned list.
	 */
	public List cloneDeep() {
		List listcd = new List();
		Node pointer = this.head;
		while (pointer != null) {
			listcd.addLast(pointer.val);
			pointer = pointer.next;
		}
		return listcd;
	}

	/**
	 * method concatList()
	 * The method concatList create a new list with help of the method 
	 * cloneDeep with the name is concatList.
	 * An object pointer of type node will be created with the value head.
	 * The loop runs till the pointer is null.
	 * Every value of the original list on the node where the pointer is,
	 * to be added on the end of the list with the method addLast.
	 * In the next step the pointer will be set to the next node.
	 */
	public void concatList(List list) {
		List concatList = list.cloneDeep();
		Node pointer = concatList.head;
		while (pointer != null) {
			this.addLast(pointer.val);
			pointer = pointer.next;
		}
	}
}