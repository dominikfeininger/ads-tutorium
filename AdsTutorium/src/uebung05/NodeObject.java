package uebung05;

/**
 * this class implements a Node
 * 
 * @author Dominik Feiniger & Dominik Garrecht
 * 
 */
public class NodeObject {
	Object val;
	NodeObject next;

	/**
	 * standard constructor
	 */
	public NodeObject() {
		this.val = null;
		this.next = null;
	}

	/**
	 * advanced constructor - initializes a node with given parameters
	 * 
	 * @param value
	 *            value of the Node
	 * @param next
	 *            reference to the next node
	 */
	public NodeObject(Object value, NodeObject next) {
		this.val = value;
		this.next = next;
	}

}
