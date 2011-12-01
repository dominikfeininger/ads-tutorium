package uebung05;

import static gdi.MakeItSimple.*;

public class ListnotInt {

	/**
	 * @param args
	 */
	NodeObject head;
	NodeObject tail;

	//constructor, produce an empty list
	public ListnotInt() {
		this.head = null;
		this.tail = null;
	}
	//constrictor, produce an list with an first value
	public ListnotInt(Object value) {
		this.addFirst(value);
	}
	//methode to add an first element to the others
	public void addFirst(Object value) {
		//an new node object will be born
		NodeObject element = new NodeObject();
		//the element gets the value of the node 
		element.val = value;
		element.next = this.head;
		//if the list is empty the head and tail will set on the node element.
		if (isEmpty()) {
			this.head = element;
			this.tail = element;
		} else {
			this.head = element;
		}
	}
	//methode to add an element at the end
	public void addLast(Object value) {
		NodeObject element = new NodeObject(); // create Node
		element.val = value;
		element.next = null;
		// search tail of list
		NodeObject p = this.head;
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

	public Object getFirst() {// anstatt return int --> Object
		return this.head.val;
	}

	public Object getLast() { // anstatt return int --> Object
		return this.tail.val;
	}

	public void removeFirst() {
		//the pointer head will be set on the next element
		this.head = head.next;
	}

	public void printList() {
		NodeObject pointer;
		pointer = this.head;
		if (!isEmpty()) {
			//loop to run through the list
			while (pointer.next != null) {
				//the element get print
				print(pointer.val + " ");
				pointer = pointer.next;
			}
			print(this.tail.val);
		}
	}
	//test if the list contains the seached value
	public boolean contains(Object value) {
		NodeObject pointer;
		pointer = this.head;
		if (!isEmpty()) {
			while (pointer.next != null) {
				if (pointer.val.equals(value)) { // anstatt: if (pointer.val ==
					// value) {
					return true;
				}
				pointer = pointer.next;
			}
		}
		return false;
	}
	//cleared the colplete list
	public void clear() {
		this.head = null;
		this.tail = null;
	}
	//test the size an give the size back
	public int size() {
		NodeObject pointer;
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
	//create an new list and copy the reference of the list
	public ListnotInt clone() {
		ListnotInt clonedList = this;
		return clonedList;
	}
	
	public void delete(int value) {
		NodeObject pointer;
		pointer = this.head;
		if (!isEmpty()) {
			//if the head has the seached value the head will be delete
			if (pointer.val.equals(value)){
				removeFirst();
				return;
			}
			//an loop runs through till the pointers next element equals the searched value
			while (pointer != null) {
				if (pointer.next.val.equals(value)) {
					pointer.next = pointer.next.next;
				}
				//the tail will be set on the tail.prev element
				if (pointer.next.next == null && pointer.next.val.equals(value)) {
					this.tail = pointer;
				}
				pointer = pointer.next;
			}
		}
	}

	public ListnotInt cloneDeep() {
		ListnotInt listcd = new ListnotInt();
		NodeObject pointer = this.head;
		
		NodeObject element = new NodeObject();
		int value = 0;
		element.val = value;
		element.next = this.head;
		if (isEmpty()) {
			this.head = element;
			this.tail = element;
		} else {
			this.head = element;
		}
		while (pointer != null) {
			listcd.addLast(pointer.val);
			pointer = pointer.next;
		}
		println(listcd);
		println();
		printl(listcd);
		return listcd;
	}
	//joins two list
	public void concatList(ListnotInt list) {
		ListnotInt concatList = list.cloneDeep();
		NodeObject pointer = concatList.head;
		while (pointer != null) {
			this.addLast(pointer.val);
			pointer = pointer.next;
		}
	}
	//helpmethod to print any list 
	public void printl(ListnotInt list) {
		NodeObject pointer = list.head;
		if (list.head != null && list.head.next != null) {
			while (pointer.next != null) {
				println(pointer.val);
				pointer = pointer.next;
			}
				println(pointer.val);
		} else {
			println("die Liste ist leer");
		}
	}
}