package bTree;

import java.util.NoSuchElementException;

public class BTree {
	private BNode root;
	
	/**
	 * constuctor
	 * 
	 * no param -> root is null
	 */
	public BTree() {
		setRoot(null);
	}
	/**
	 * prints tree in console
	 * @param node
	 */
	public void inorderDisplay(BNode node) {
		if (node != null) {
			inorderDisplay(node.left);
			System.out.print(node.key + " ");
			inorderDisplay(node.right);
		}
	}
	
	/**
	 * 
	 * @param value -> creates new node with value
	 */
	public void insert(int value) {
		BNode y = null;
		BNode x = getRoot();
		while (x != null) {
			y = x;
			if (value < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		BNode z = new BNode(value);
		z.parent = y;
		if (y == null) {
			setRoot(z);
		} else {
			{
				if (value < y.key) {
					y.left = z;
				} else {
					y.right = z;
				}
			}

		}

	}
	/**
	 * test if value is in tree
	 * @param node -> specifies root
	 * @param value
	 * @return boolean
	 */
	public boolean contains(BNode node, int value) {
		if (node == null)
			return false;
		if (node.key == value)
			return true;
		if (value < node.key) {
			return contains(node.left, value);
		} else
			return contains(node.right, value);

	}
	/**
	 * test if value is in tree
	 * @param value
	 * @return boolean
	 */
	public boolean contains(int value) {
		BNode x = getRoot();
		if (x == null)
			return false;
		while (value != x.key) {
			if (value < x.key) {
				x = x.left;
			} else
				x = x.right;
			if (x == null)
				return false;

		}
		return true;

	}
	/**
	 * 
	 * @return min value -> most left value in tree
	 * @brief throws java.util.NoSuchElementException if there min node is null
	 */
	public int minValue() {
		BNode node = getRoot();
		while (node.left != null) {
			node = node.left;
		}
		if (node != null)
			return node.key;
		else
			throw new NoSuchElementException();
	}
	/**
	 * @return max value -> most right value in tree
	 * @brief throws java.util.NoSuchElementException if there max node is null
	 */
	public int maxValue() {
		BNode node = getRoot();
		while (node.right != null) {
			node = node.right;
		}
		if (node != null)
			return node.key;
		else
			throw new NoSuchElementException();
	}

	public void setRoot(BNode root) {
		this.root = root;
	}

	public BNode getRoot() {
		return root;
	}

}