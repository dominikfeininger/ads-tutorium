package muster.binarytree;

import static gdi.MakeItSimple.*;
import muster.basics.*;
import muster.queues.QueueLL;


class BinaryTree {

	private TreeNode root = null;

	private static final int INORDER = 1;
	private static final int PREORDER = 2;
	private static final int POSTORDER = 3;
	private static final int LEVELORDER = 4;

	public static BinaryTree empty() { // creates a new empty tree
		return new BinaryTree();
	}

	public void clear() { // reinitalize current tree
		this.root = null;
	}

	protected void printInorder(TreeNode n) {
		if (n != null) {// tree not empty
			printInorder(n.getLeft());
			n.print();
			printInorder(n.getRight());
		}
	}

	private void printPreorder(TreeNode n) {
		if (n != null) {// tree not empty
			n.print();
			printPreorder(n.getLeft());
			printPreorder(n.getRight());
		}
	}

	private void printPostorder(TreeNode n) {
		if (n != null) {// tree not empty
			printPostorder(n.getLeft());
			printPostorder(n.getRight());
			n.print();
		}
	}

	private void printLevelorder(Queue q) {
		while (!q.isEmpty()) {
			try {
				TreeNode n = (TreeNode) q.leave();
				if (n.getLeft() != null)
					q.enter(n.getLeft());
				if (n.getRight() != null)
					q.enter(n.getRight());
				n.print();
			} catch (Exception e) {
			} // ignore exceptions
		}
	}

	private void savePreorder(TreeNode n, Object fn) {
		// save tree with root n to file fn node by node while traversing tree in preorder
		
		if (n != null) {// tree not empty
			print(fn, " " + n.getElement().toString()); // write values as strings
			savePreorder(n.getLeft(), fn);
			savePreorder(n.getRight(), fn);
		}
	}

	private void copyPreorder(TreeNode n, BinaryTree t) {
		// traverses tree in preorder and inserts node by node in t
		if (n != null) {// tree not empty
			t.insert(n.getElement()); // get element to insert in t
			copyPreorder(n.getLeft(), t);
			copyPreorder(n.getRight(), t);
		}
	}

	public BinaryTree clone () {
		BinaryTree res = new BinaryTree(); // new tree for deep copy
		copyPreorder(root, res); // copy tree element by element when traversing tree in preorder
		return res;
	}

	public void traverse(int strategy) {
		switch (strategy) {
		case INORDER:
			printInorder(root);
			break;
		case PREORDER:
			printPreorder(root);
			break;
		case POSTORDER:
			printPostorder(root);
			break;
		case LEVELORDER:
			Queue queue = new QueueLL();
			if (root != null)
				try {
					queue.enter(root);
				} catch (OverflowException e) {
				} // ignore - never happens
			printLevelorder(queue);
			break;
		default:
		}
	}

	public TreeNode findNode(Element i) {
		TreeNode n = root;
		while (n != null) {
			if (i.compareTo(n.getElement()) == 0)
				return n;
			else if (i.compareTo(n.getElement()) == -1)
				n = n.getLeft();
			else
				n = n.getRight();
		}
		return null;
	}

	public boolean find(Element i) {
		return (findNode(i) != null);
	}

	public boolean ieEmpty() {
		return (this.root == null);
	}

	public TreeNode value() {
		return root;
	}


//	public void insertr(Element i) {
//		root = insertrr(root, i);
//
//	}

//	public TreeNode insertrr(TreeNode n, Element i) { // recursive implementation of insert returns root of current subtree
//
//		if (n != null) {
//			if (i.compareTo(n.getElement()) == 0)
//				return n; // element already in tree, i is not inserted
//			else if (i.compareTo(n.getElement()) < 0) // insert in left tree
//				if (n.getLeft() != null)
//					n.setLeft(insertrr(n.getLeft(), i)); // insert in left tree
//				else {
//					n.setLeft(new TreeNode(i)); // insert a new leaf
//					return n;
//				}
//			else if (n.getRight() != null)
//				n.setRight(insertrr(n.getRight(), i)); // insert in right tree
//			else {
//				n.setRight(new TreeNode(i)); // insert a new leaf
//				return n;
//			}
//		} else { // empty tree
//			root = new TreeNode(i);
//			return root;
//		}
//
//		return n;
//	}
	
	
	public boolean insertr(Element i) {
		return insertrr(root, i);

	}
	

	public boolean insertrr(TreeNode n, Element i) { // recursive implementation of insert

		if (n != null) {
			if (i.compareTo(n.getElement()) == 0)
				return false; // element already in tree, i is not inserted
			else if (i.compareTo(n.getElement()) < 0) // insert in left tree
				if (n.getLeft() != null)
					return insertrr(n.getLeft(), i); // insert in left tree
				else {
					n.setLeft(new TreeNode(i)); // insert a new leaf
					return true;
				}
			else if (n.getRight() != null)
				return insertrr(n.getRight(), i); // insert in right tree
			else {
				n.setRight(new TreeNode(i)); // insert a new leaf
				return true;
			}
		} else { // empty tree
			root = new TreeNode(i);
			return true;
		}
	}

	
	public boolean insert(Element i) { // iterative implementation of insert
		TreeNode parent = null;
		TreeNode child = root;
		while (child != null) {
			parent = child;
			if (i.compareTo(child.getElement()) == 0)
				return false; // element already in tree, i is not inserted
			else if (i.compareTo(child.getElement()) < 0)
				child = child.getLeft(); // insert in left tree
			else
				child = child.getRight(); // insert in right tree
		}
		// parent node found
		if (parent == null) // empty tree -> insert first node
			root = new TreeNode(i);
		else if (i.compareTo(parent.getElement()) < 0)
			parent.setLeft(new TreeNode(i)); // insert in left subtree (from
												// parent)
		else
			parent.setRight(new TreeNode(i)); // insert right subtree (from
												// parent)

		return true; // i successfully inserted
	}

	public boolean remove(Element e) {
		TreeNode parent = null, node = root, child, tmp;

		if (root == null) // empty tree
			return false;

		// search node to be deleted

		while (node != null && e.compareTo(node.getElement()) != 0) {
			parent = node;
			if (e.compareTo(node.getElement()) < 0)
				node = node.getLeft();
			else
				node = node.getRight();
		}

		if (node == null) // no node found
			return false;

		// delete node

		if (parent == null) { // root has to be deleted
			if (node.getLeft() == null) // there is no child on left
				root = node.getRight();
			else if (node.getRight() == null) // there is no child on right
				root = node.getLeft();
			else { // search smallest node in right subtree
				tmp = node;
				child = node.getRight();
				while (child.getLeft() != null) {
					tmp = child;
					child = child.getLeft();
				}
				if (node != tmp) { // right subtree has more than one node
					tmp.setLeft(child.getRight());
					child.setRight(node.getRight());
				}
				child.setLeft(node.getLeft());
				root = child; // new root
			}
		}

		// node to be deleted != root

		// case A - D: node has only one child either on right or on left
		else if (node.getLeft() == null) { // there is no child on left
			if (parent.getLeft() == node) // node < parent
				parent.setLeft(node.getRight()); // case A
			else
				// node > parent
				parent.setRight(node.getRight()); // case B
		} else if (node.getRight() == null) { // there is no child on right
			if (parent.getLeft() == node) // node < parent
				parent.setLeft(node.getLeft()); // case C
			else
				// node > parent
				parent.setRight(node.getLeft()); // case D
		} else { // true inner node: 2 children => determine tmp and child
			tmp = node;
			child = node.getRight();
			while (child.getLeft() != null) {
				tmp = child;
				child = child.getLeft();
			}
			child.setLeft(node.getLeft());
			if (node != tmp) { // right subtree has more than one node
				tmp.setLeft(child.getRight());
				child.setRight(node.getRight());
			}
			if (parent.getRight() == node)
				parent.setRight(child);
			else
				parent.setLeft(child);
		}
		return true;
	}

	public boolean build() {

		// build binary tree from file

		// HIER Abhängigkeit vom Typ der konkreten Elemente (int) ===> für Übungsaufgabe ok, aber zu sehr eingeschränkt
		// Ursache: bild ist eigentlich keine Opertion von BinaryTree

		String filename;

		print("Eingabedatei für binären Baum: ");
		filename = readLine();
		if (isFilePresent(filename)) {

			Object file = openInputFile(filename); // no problems with file handling !!!

			while (!isEndOfInputFile(file))
				insert(new IntElement(readInt(file))); // <<< int-Werte einlesen

			closeInputFile(file);
		} else {
			println("Datei " + filename + "unbekannt");
			return false; // exit program if file doesn't exist
		}
		return true; // tree successfully built
	}
	

	public boolean save() { // save binary tree to file in preorder

		String filename;

		print("Zieldatei für binären Baum: ");
		filename = readLine();

		if (!isFilePresent(filename)) {

			Object file = openOutputFile(filename); // no problems with file handling !!!
			savePreorder(root, file);
			closeOutputFile(file);
		} else {
			println("Datei " + filename + "existiert schon");
			return false; // exit program if file doesn't exist
		}
		return true; // tree successfully saved
	}
}

// ////////////////////// end of class Tree /////////////////////////////////

