package bTreeImplement;

public class TreeNode {

	// node value
	private int value;
	// qty of cilds
	private int childqty;
	// child nodes, max. childqty
	private TreeNode[] childnodes = new TreeNode[childqty];
	// father of this node
	private TreeNode father;
	// keys
	private int keys[] = new int[2];
	// number of keys
	private int numberOfKeys;

	/**
	 * constuctor with root node value = 0;
	 */
	public TreeNode() {
		this(0);
	}

	public TreeNode(int val) {
		this.value = val;
	}

	public TreeNode(int key, TreeNode v, TreeNode child1, TreeNode child2) {
		childnodes[0] = child1;
		childnodes[1] = child2;
		childnodes[2] = null;
		keys[0] = key;
		numberOfKeys = 1;
		this.father = v;
	}
	
	public void add(int key, TreeNode l, TreeNode r) {
		if (numberOfKeys == 2) {
			System.out.println("Knoten ist schon voll");
			return;
		}
		numberOfKeys = 2;
		if (key < keys[0]) {
			keys[1] = keys[0];
			keys[0] = key;
			childnodes[0] = l;
			childnodes[2] = childnodes[1];
			childnodes[1] = r;
		} else {
			keys[1] = key;
			childnodes[1] = l;
			childnodes[2] = r;
		}
	}
	
	/**
	 * makes System.out.println(value);
	 */
	public void print(){
		System.out.println(this.value);
	}

	// Getter and Setter
	public int[] getKeys() {
		return this.keys;
	}

	public void setKeys(int[] key) {
		this.keys = key;
	}

	public int getNumberOfKeys() {
		return this.numberOfKeys;
	}

	public void setNumberOfKeys(int numberOfKeys) {
		this.numberOfKeys = numberOfKeys;
	}

	public int getChildqty() {
		return this.childqty;
	}

	public void setChildqty(int childqty) {
		this.childqty = childqty;
	}

	public void setChildnodes(TreeNode[] childnodes) {
		this.childnodes = childnodes;
	}

	public TreeNode[] getChildnodes() {
		return this.childnodes;
	}

	public TreeNode getFather() {
		return this.father;
	}

	public void setFather(TreeNode v) {
		this.father = v;
	}

	public void setValue(int val) {
		this.value = val;
	}

	public int getValue() {
		return this.value;
	}
}
