package bTree;

public class BTree {

	private BNode root;

	/**
	 * B Tree saves any kind of BNodes
	 * 
	 * constuctor
	 * 
	 * @param root
	 */
	public BTree(BNode root) {
		this.root = root;
	}

	public void insert(BNode node) {
		// insert as root
		if (root == null) {
			this.root = node;
		} else {
			// insert as child, smaller than parent
			if (node.getValue() < root.getValue()) {
				root.setKey0(node);
				node.setLeaf(true);
			} else {
				// insert as child, bigger than parent
				root.setKey1(node);
				node.setLeaf(true);
			}
		}
	}

	public void printRoot() {
		System.out.println(root.getValue());
	}

	public void printTree(BNode node) {
		// print root node
		System.out.println(node.getValue());
		// print childs
		if (!node.getKey0().isLeaf()) {
			printTree(node.getKey0());
		} else {
			System.out.println(node.getKey0().getValue());
		}
		if (!node.getKey1().isLeaf()) {
			printTree(node.getKey1());
		} else {
			System.out.println(node.getKey1().getValue());
		}

	}

	// getter and setter
	public BNode getRoot() {
		return root;
	}

	public void setRoot(BNode root) {
		this.root = root;
	}

}
