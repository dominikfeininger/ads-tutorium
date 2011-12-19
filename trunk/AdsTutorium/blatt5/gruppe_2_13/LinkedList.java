package gruppe_2_13;

public interface LinkedList {
	
	/**
	 * This function inserts the element crossed in parameter at the begin of the List
	 * @param element the element to insert
	 */
	public void addFirst(MyObject element);
	
	/**
	 * This function inserts the element crossed in parameter at the end of the List
	 * @param element the element to insert
	 */
	public void addLast(MyObject element);
	
	/**
	 * This function inserts an element crossed in parameter in a given position 
	 * @param index the position of insertion
	 * @param element the element to be inserted
	 */
	public void add(int index, MyObject element);
	
	/**
	 * This Function inserts the list crossed in parameter at the continuation of the List
	 * @param otherList The list to be inserted
	 */
	public void addAll(MyLinkedList otherList);
	
	/**
	 * This function remove the first element of the list
	 */
	public void removeFirst();
	
	/**
	 * This function remove the Last element of the list
	 */
	public void removeLast();
	
	/**
	 * This function returns the first element of the list
	 * @return One MyObject element
	 */
	public MyObject getFirst();
	
	/**
	 * This function returns the last element of the list
	 * @return One MyObject element
	 */
	public MyObject getLast();
	
	/**
	 * This function returns an element to a given position
	 * @param index the position of element
	 * @return the element to a position index.
	 */
	public MyObject get(int index);
	
	/**
	 * This function checks if the list is empty or not
	 * @return boolean value; true if the list is empty and false if not
	 */
	public boolean isEmpty();
	
	/**
	 * This function checks if the parameter's element is in the list
	 * @param element Element to search
	 * @return true if element was found and false if not
	 */
	public boolean contains(String element);
	
	/**
	 * This function determines the length of list.
	 * @return the length.
	 */
	public int size();
	
	/**
	 * This function makes a copy superficial of the list
	 * @return A timekeeper on the head of the list
	 */
	public MyLinkedList clone();
	
	/**
	 * This function makes a copy real of the list
	 * @return A new list different from the list of origin
	 */
	public MyLinkedList cloneDeep();
	
	/**
	 * This function removes from the list the element crossed in parameter
	 * @param element element to be removed
	 */
	public void delete(String element);
	
	/**
	 * Remove all element of the list
	 */
	public void clear();
	
	/**
	 * This function returns the list in the form of String
	 * @return String
	 */
	public String toString();
	
	/**
	 * This function returns the list in the form of Array of MyObject
	 * @return []MyObject
	 */
	public MyObject[] toArray();
	
	
}
