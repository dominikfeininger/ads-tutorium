package bTree;

/**
 * 
 * @author feininger
 *
 */

public class BNode {
	//has properties
	int key;
	BNode parent;
	BNode left;
	BNode right;

	/**
	 * constuctor
	 * @param key -> node value
	 */
	public BNode(int key) {
		super();
		this.key = key;
	}
	
	/**
	 * constuctor
	 * @param key
	 * @param left
	 * @param right
	 */
	public BNode(int key, BNode left, BNode right) {
		super();
		this.key = key;
		this.left = left;
		this.right = right;
	}

}
