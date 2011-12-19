package gruppe_2_10;



/**
 * The class ListNode is a helper class for every kind of LinkedLists
 * 
 * @author Wolfgang Schramm
 */
public class ListNode {

	private MyIntObject element;
	private ListNode next;
	
	/**
	 * @return the value of the current node
	 */
	public MyIntObject getElement() {
		return element;
	}

	/**
	 * @param value
	 *            the new value of the current node
	 */
	public void setElement(MyIntObject value) {
		this.element = value;
	}

	/**
	 * @return the next element
	 */
	public ListNode getNext() {
		return next;
	}

	/**
	 * 
	 * @param next
	 *            the new next element
	 */
	public void setNext(ListNode next) {
		this.next = next;
	}
}