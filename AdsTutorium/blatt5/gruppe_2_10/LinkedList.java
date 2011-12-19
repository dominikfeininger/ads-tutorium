package gruppe_2_10; // Aufgabe 5


public interface LinkedList {
	
	 void add (int index, MyIntObject element);
	 void addFirst (MyIntObject obj1);
	 void addLast (MyIntObject objLast);
	 void addAll(LinkedList otherList);
	 int get(int index);
	 void getFirst ();
	 void getLast ();
	 void removeFirst ();
	 void removeLast ();
	 void clear();
	 void remove(MyIntObject element);
	 void toArray();
	 boolean isEmpty ();
	 boolean contains (int val);
	 void delete (int val);
	 void cloneDeep (Object List);
	 LinkedList empty ();
	 void size(Object List);
	 void clone (Object List);	 
	 String toString();
}
