package uebung06;

import static gdi.MakeItSimple.*;

public class TreeNode {
	int val;
	TreeNode parent;
	TreeNode left;
	TreeNode right;
	TreeNode child;

	/**
	 * constuctor with an parameter
	 * 
	 * @param i
	 */
	public TreeNode(int i) {
		val = i;
	}

	/**
	 * constructor without an parameter
	 */
	public TreeNode() {
	}

	public TreeNode getParent() {
		return this.parent;
	}

	/**
	 * the method get the left side of the tree
	 * 
	 * @return the node witch is on the left side.
	 */
	public TreeNode getLeft() {
		return this.left;
	}

	/**
	 * the method get the right side of the tree
	 * 
	 * @return the node witch is on the right side.
	 */
	public TreeNode getRight() {
		return this.right;
	}

	/**
	 * get the elements value
	 * 
	 * @return the integer value of the node
	 */
	public int getElement() {
		return val;
	}

	/**
	 * set the reference of the node to the "new" node
	 * 
	 * @param n ,
	 *            is the given tree node
	 */
	public void setLeft(TreeNode n) {
		left = n;
	}

	/**
	 * * set the reference of the node to the "new" node
	 * 
	 * @param n ,
	 *            is the given tree node
	 */
	public void setRight(TreeNode n) {
		right = n;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
		// TODO Auto-generated method stub

	}
}
