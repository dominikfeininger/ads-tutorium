package gruppe_2_6;

public interface LinkedList {
	
	void addFirst(MyObject element);

	void addLast(MyObject element);

	void removeFirst();
	
	void removeLast();

	MyObject getFirst();

	MyObject getLast();

	boolean isEmpty();
	
	MyLinkedList empty();
	
	boolean contains(MyObject element);
	
	void removeAll();
	
	int size();
		
	void remove(int index);
	
	String toString();
	
	void add(int index, MyObject element);
	
	MyObject get(int index);
	
	MyObject[] toArray();
	
	void addAll(LinkedList otherList);
	
	void cloneDeep();

}
