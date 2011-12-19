package gruppe_2_10;

import static gdi.MakeItSimple.*;

public class MyLinkedList implements LinkedList {
	

	@Override
	public void add(int index, MyIntObject element) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void addFirst(MyIntObject obj1) {
		// TODO Auto-generated method stub	
		ListNode element = new ListNode (); //create Node
		element.setElement(obj1);
		element.setNext(null);
	}

	@Override
	public void addLast(MyIntObject objLast) {
		// TODO Auto-generated method stub
		
		ListNode element = new ListNode (); //create Node
		element.setElement(objLast);
		element.setNext(null);	
	}

	@Override
	public void addAll(LinkedList otherList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getFirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toArray() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(int val) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(int val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cloneDeep(Object List) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkedList empty() {
		// TODO Auto-generated method stub
		LinkedList newList = new MyLinkedList();
		return newList;
	}

	@Override
	public void size(Object List) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clone(Object List) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void remove(MyIntObject element) {
		// TODO Auto-generated method stub
		
	}



}
