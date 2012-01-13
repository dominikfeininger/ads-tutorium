package gruppe_2_9;

public class TreeNode {

	// Node of a binary tree
	int elem;
	TreeNode left;
	TreeNode right;

	public TreeNode(int i) {
		elem = i;
		left = right = null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public int getElement() {
		return elem;
	}

	public void setLeft(TreeNode n) {
		left = n;
	}

	public void setRight(TreeNode n) {
		right = n;
	}

	public void setElement(int e) {
		elem = e;
	}
	
	public int compareTo(int element) {
		if (getElement() == element)
			return 0;
		if (getElement() < element)
			return -1;
		else
			return +1;
	}
}
