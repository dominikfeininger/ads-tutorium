package bTreeImplement;


public class TreeNode {

	// node value
	private int value;
	//qty of cilds
	private int childqty;
	// child nodes, max. childqty
	private int [] childnodes = new int[childqty];
	// leaf?
	private boolean isleaf;
	// father of this node
	TreeNode v;
	

	/**
	 * constuctor with root node value = 0;
	 */
	public TreeNode() {
		this(0);
	}

	public TreeNode(int val) {
		this.value = val;
	}
	
	//Getter and Setter
	
	public int getChildqty() {
		return childqty;
	}

	public void setChildqty(int childqty) {
		this.childqty = childqty;
	}	
	
	public int[] getChildnodes() {
		return childnodes;
	}

	public void setChildnodes(int[] childnodes) {
		this.childnodes = childnodes;
	}

	public boolean isIsleaf() {
		return isleaf;
	}

	public void setIsleaf(boolean isleaf) {
		this.isleaf = isleaf;
	}

	public TreeNode getV() {
		return v;
	}

	public void setV(TreeNode v) {
		this.v = v;
	}

	public void setValue(int val) {
		this.value = val;
	}

	public int getValue() {
		return value;
	}

}
