package uebung06;

import static gdi.MakeItSimple.*;

public class BinaryTree {

	TreeNode root;

	/**
	 * constuctor with an root value
	 * 
	 * @param i
	 */
	public BinaryTree(int i) {
		this.root = new TreeNode();
		this.root.val = i;
	}

	/**
	 * constuctor with an empty root
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * constuct an new empty BinaryTree
	 * 
	 * @return
	 */
	public BinaryTree empty() {
		BinaryTree newTree = new BinaryTree();
		return newTree;
	}

	/**
	 * @return the root node
	 */
	public TreeNode value() {
		if(!isEmpty()){
		return root;
		}
		return null;
	}

	/**
	 * print the tree in preorder
	 * 
	 * @param Tree
	 *            Node n
	 */
	public void printPreorder(TreeNode n) {
		if (n != null) {// tree not empty
			println(n.val);
			printPreorder(n.getLeft());
			printPreorder(n.getRight());
		}
	}

	/**
	 * print the tree in postorder
	 * 
	 * @param Tree
	 *            Node n
	 */
	public void printPostorder(TreeNode n) {
		if (n != null) {
			printPostorder(n.getLeft());
			printPostorder(n.getRight());
			println(n.val);

		}
	}

	/**
	 * read the node values from file
	 * 
	 * @param file
	 */
	public void loadFromFile(Object file) {
		while (isEndOfInputFile(file)) {
			int element = readInt(file);
			insert(element);
		}

	}

	/**
	 * print the tree in Inorder
	 * 
	 * @param Tree
	 *            Node n
	 */
	public void printInorder(TreeNode n) {
		if (n != null) {
			printInorder(n.getLeft());
			println(n.val);
			printInorder(n.getRight());
		}
	}

	public void printNode(TreeNode n) {
		println(n.val);
	}

	/**
	 * remove the Node with the seached value
	 * 
	 * @param value
	 */

/*	public void remove(int value) {
		TreeNode k = new TreeNode();
		k = search(value);
		TreeNode current = null;
		if (k == null) {
			return;
		}
		if (k.getLeft() != null) {
			current = k.getLeft();
			while (current.getRight() != null)
				current = current.getRight();
			// greatest element in the left tree found
			if (current.getLeft() != null) {
				current.getParent().setRight(current.getLeft());
			}
			// set new root
			current.setLeft(k.getLeft());
			current.setRight(k.getRight());
			k = current;
		} else if (k.getRight() != null) {
			while (current.getLeft() != null) {
				current = current.getLeft();
			}
			// greatest element in the right tree found
			if (current.getRight() != null) {
				current.getParent().setRight(current.getLeft());
			}
			current.setRight(k.getRight());
			current.setLeft(k.getLeft());
			k = current;
		} else {
			k = null;
		}
	}
*/
	public void remove(int value) {
		TreeNode pointer = search(value);

		//is value in tree?
		if (pointer == null){
			println("value '" + value + "' not in tree!");
			return;
		}

		if (pointer.equals(this.root)){
			//root should be removed
			if (pointer.left == null){
				this.root = pointer.right;
			}else if(pointer.right == null){
				this.root = pointer.left;
			}else{
				TreeNode child = getMaxNode(pointer.left);
				TreeNode parent = child.getParent();

				if (parent.equals(root)){
					
				}else{
					parent.right = null;
					child.left = root.left;
				}					
				
				child.right = root.right;
				root = child;
			}
		}else{
			//normal node should be removed
			TreeNode parent = pointer.getParent();

			if(pointer.left == null){
				if (pointer.equals(parent.left)){
					parent.left = pointer.right;
				}else{
					parent.right = pointer.right;
				}		
			}else if(pointer.right == null){
				if (parent.left.equals(pointer)){
					parent.left = pointer.left;
				}else{
					parent.right = pointer.left;
				}
			}else{
				TreeNode child = getMaxNode(pointer.left);
				TreeNode parent2 = pointer.getParent();
				parent2.right = child;
				child.right = pointer.right;
				
				if (!pointer.left.equals(child)){
					child.left = pointer.left;		
				}else{
					child.left = null;
				}
				
				
			}
		}
	}
	
	/**
	 * searches the max node
	 * @return max node
	 */
	public TreeNode getMaxNode(TreeNode pointer){
		while(pointer.right != null){
			pointer = pointer.right;
		}
		return pointer;
	}

	/**
	 * seach the Node with the seached value
	 * 
	 * @param value
	 * @return the node
	 */
	public TreeNode search(int value) {
		TreeNode element;
		element = this.root;
		if (element.val == value) {
			return element;
		} else {
			while (element != null && (element.val != value)) {
				if (element.val > value) {
					element = element.getLeft();
				}
				if (element.val < value) {
					element = element.getRight();
				}
			}
		}
		return element;
	}

	/**
	 * construct an binary tree construct an binary tree from an left section
	 * beam and an right section beam and an element as combined root
	 * 
	 * @param value
	 * @param tree
	 * @return the new constucted tree
	 * @throws Exception
	 */
	public BinaryTree bin(int value, BinaryTree Tree) {
		BinaryTree newTree = new BinaryTree(value);
		if (((newTree.root.val > this.root.val) // exception
				&& (newTree.root.val > Tree.root.val) || (newTree.root.val < this.root.val)
				&& (newTree.root.val < Tree.root.val))) {
			if (this.root.val > Tree.root.val) { // choose the side where the
				// section beam should be
				// insert
				newTree.root.right = this.root;
				newTree.root.left = Tree.root;
			} else {
				newTree.root.left = this.root;
				newTree.root.right = Tree.root;
			}
		} else {
			println("false");
		}
		return newTree;

	}

	/**
	 * test if the tree is empty
	 * 
	 * @return an boolean value
	 */
	public boolean isEmpty() {
		boolean bool = false;
		if (this.root == null) {
			bool = true;
		}
		return bool;
	}

	/**
	 * find an value in the tree
	 * 
	 * @param value
	 * @return the found element
	 */
	public TreeNode find(int value) {
		TreeNode element;
		element = this.root;
		if (element.val > value) {
			while (element.left.val > value) {
				element = element.left;
			}
		} else {
			while (element.left.val < value) {
				element = element.left;
			}
			element = element.right;
		}
		return element;
	}

	/**
	 * insert an node with an value in the tree on the right place
	 * 
	 * @param i
	 * @return an boolean if the node was insert -> true, false if the element
	 *         already exists
	 */
	public boolean insert(int i) {
		TreeNode parent = null;
		TreeNode child = root;
		if (this.root == null) {
			TreeNode root = new TreeNode(i);
			this.root = root;
			return true;
		}
		while (child != null) { // at least 1 node in tree
			parent = child;
			if (i == child.val)
				return false; // element already in tree, i is not inserted
			else if (i < child.val)
				child = child.getLeft(); // insert in left tree
			else
				child = child.getRight(); // insert in left tree
		}
		// parent node found
		child = new TreeNode(i);
		if (i < parent.val)
			parent.setLeft(child); // insert left from parent
		else
			parent.setRight(child); // insert left from parent
		child.setParent(parent);
		return true; // i successfully inserted
	}

}
