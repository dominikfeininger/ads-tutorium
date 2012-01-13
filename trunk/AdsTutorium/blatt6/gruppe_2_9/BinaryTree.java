package gruppe_2_9;

import static gdi.MakeItSimple.*;

public class BinaryTree {

	private TreeNode root;

	/**
	 * 
	 * @return a empty binary tree
	 */
	public BinaryTree empty() {
		this.root = null;
		BinaryTree tree = new BinaryTree();
		return tree;
	}

	/**
	 * inserts a value in a binary tree
	 * 
	 * @param val
	 * @return true if insertion was successful, false if not
	 */
	public boolean insert(int val) {
		if (this.root == null) {
			this.root = new TreeNode(val);
			return true;
		} else {
			return insertRecursive(val, this.root);
		}
	}

	private boolean insertRecursive(int val, TreeNode node) {
		if (val < node.getElement()) {
			if (node.getLeft() == null) {
				node.setLeft(new TreeNode(val));
				return true;
			} else {
				return insertRecursive(val, node.getLeft());
			}
		} else if (val > node.getElement()) {
			if (node.getRight() == null) {
				node.setRight(new TreeNode(val));
				return true;
			} else {
				return insertRecursive(val, node.getRight());
			}
		}
		return false;
	}

	/**
	 * checks if a value exists in a binary tree
	 * 
	 * @param val
	 * @return true if a binary tree contains a value, false if not
	 */
	public boolean contains(int val) {
		TreeNode node = this.root;

		if (this.root == null) {
			return false;
		}

		while (node != null) {

			if (val == node.getElement()) {
				return true;
			}

			else if (val < node.getElement()) {
				node = node.getRight();
			}

			else if (val > node.getElement()) {
				node = node.getRight();
			}
		}

		return false;
	}

	/**
	 * removes a value from a binary tree
	 * 
	 * @param val
	 * @return true if value has been removed, false if not
	 */
	public boolean remove(int val) {
		TreeNode node = this.root;
		TreeNode rememberNode = null;
		return true;
	}

	/**
	 * checks if a binary tree is empty
	 * 
	 * @return true if binary tree is empty, false if not
	 */
	public boolean isEmpty() {

		// if the root is null the tree is empty
		if (this.root == null)
			return true;

		else
			return false;
	}

	/**
	 * counts the amount of nodes of a binary tree
	 * 
	 * @return the amount of nodes of a binary tree
	 */
	public int size() {
		return size(root);
	}

	/**
	 * Ermittelt die Anzahl der Knoten im Baum
	 * 
	 * @return Anzahl der Knoten
	 */
	private int size(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return size(node.getLeft()) + size(node.getRight()) + 1;
		}
	}

	/**
	 * counts the amount of nodes of a binary tree recursive way
	 * 
	 * @param node
	 * @return the amount of nodes of a binary tree
	 */
	private int sizeRecursive(TreeNode node) {
		int treeSize = 1;
		// if the left node is not null, treeSize is raised by 1 and the
		// function is executed with the left node
		if (node.getLeft() != null) {
			treeSize++;
			sizeRecursive(node.getLeft());
		}

		// if the right node is not null, treeSize is raised by 1 and the
		// function is executed with the right node
		if (node.getRight() != null) {
			treeSize++;
			sizeRecursive(node.getRight());
		}
		return treeSize;
	}

	/**
	 * counts the height of a binary tree
	 * 
	 * @return the height of a binary tree
	 */
	public int height() {
		return height(root);
	}

	/**
	 * Ermittelt die H�he des Baums
	 * 
	 * @return H�he des Baums
	 */
	private int height(TreeNode node) {
		int heightLeft = 0, heightRight = 0;
		// Null-Pointer Test
		if (root.getLeft() == null && root.getRight() == null) {
			return 1;
		} else {
			// Rekursiver Aufruf in den Kinder-Knoten
			heightLeft = height(node.getLeft());
			heightRight = height(node.getRight());
			// Weitergabe der l�ngsten Knoten-Folge bzw. linke Knoten-Folge bei
			// gleicher L�nge
			if (heightLeft >= heightRight) {
				return heightLeft + 1;
			}
			if (heightRight > heightLeft) {
				return heightRight + 1;
			}
		}
		return -1;
	}

	/**
	 * searches the highest number of a binary tree
	 * 
	 * @return the highest number of a binary tree
	 */
	public int getMax() {
		int max = 0;
		// if root is null it returns 0
		if (this.root == null) {
			return max;
		}
		TreeNode node = this.root;
		max = node.getElement();

		// searches the biggest element of the right subtree till the right node
		// is null
		while (node != null) {

			if (node.getRight() != null) {
				node = node.getRight();
				max = node.getElement();
			}

			// gets the next node, so the loop interrupted
			else if (node.getRight() == null) {
				node = node.getRight();
			}
		}
		return max;
	}

	/**
	 * searches the smallest number of a binary tree
	 * 
	 * @return the smallest number of a binary tree
	 */
	public int getMin() {
		int min = 0;

		// if root is null it returns 0
		if (root == null)
			return min;
		TreeNode node = root;
		min = node.getElement();

		while (node != null) {

			// searches the smallest element of the left subtree till the left
			// node is null
			if (node.getLeft() != null) {
				node = node.getLeft();
				min = node.getElement();
			}

			// gets the next node, so the loop interrupted
			else if (node.getLeft() == null) {
				node = node.getLeft();
			}
		}
		return min;
	}

	public void printInorder() {

	}

	/**
	 * executes printPreorderRecursive()
	 */
	public void printPreorder() {
		if (this.root == null) {
			println("Tree is empty");
		}
		printPreorderRecursive(this.root);
	}

	private void printPreorderRecursive(TreeNode node) {
		print(node.getElement() + " ");
		if (node.getLeft() != null) {
			printPreorderRecursive(node.getLeft());
		}
		if (node.getRight() != null) {
			printPreorderRecursive(node.getRight());
		}
	}

	public void printPostorder() {
		if (this.root == null) {
			println("Tree is empty");
		}

	}

	private void printPostorderRecursive(TreeNode node) {
	}

	public BinaryTree cloneDeep(BinaryTree copy) {
		BinaryTree clone = new BinaryTree();
		if (this.root == null) {
			return clone;
		} else
			return cloneDeepRecursive(copy, this.root);
	}

	private BinaryTree cloneDeepRecursive(BinaryTree copy, TreeNode node) {
		if (node != null) {
			copy.insert(node.getElement());
		}
		if (node.getLeft() != null) {
			cloneDeepRecursive(copy, node.getLeft());
		}
		if (node.getRight() != null) {
			cloneDeepRecursive(copy, node.getRight());
		}
		return copy;
	}

	/**
	 * fills a tree with numbers from a file
	 * 
	 * @param file
	 */
	public void fillFromData(Object file) {
		while (!isEndOfInputFile(file)) {
			int value = readInt(file);
			insert(value);
		}
	}

}
