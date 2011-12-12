package linkedList;

public class Node {
	
	// Achtung: Es werden nur int-Werte, KEINE Objekte verwaltet
	
	int  val;  // normally contains values >= 0
	Node next;

	//>>>>>>>>>>    constructors     <<<<<<<<<<<<<<<

	public Node (int val, Node n) {
		this.val = val;
		this.next = n;
	}

	public Node (int val) {
		this.val = val;
		this.next = null;
	}

	public Node () {
		this.val = 0;
		this.next = null;
	}

	//---------------  public methods --------------------------------------------

	public void setNode (int val) {
		this.val = val;
	}

	public void print () {
		gdi.MakeItSimple.print (this.val);
	}

	public int getNode () {
		return val;
	}

	public void setNext (Node n) {
		this.next = n;
	}

	public Node getNext () {
		return next;
		
	}
}

