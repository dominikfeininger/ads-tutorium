package bTreeImplement;

import bBaum_down.Bknoten;

public class BTree {

	private TreeNode root;

	/**
	 * constuctor
	 * 
	 * @param root node
	 */
	public BTree(TreeNode root) {
		this.root = root;
	}
	
	/**
	 * constructor
	 * root = null
	 */
	public BTree(){
		this(null);
	}

	/**
	 * inserts a TreeNode into a BTree
	 * 
	 * @param node
	 */
	public void insert(TreeNode node) {

	}
	
	/**
	 * 
	 * @return the root node of type TreeNode
	 */
	public TreeNode getRoot() {
		return this.root;
	}
	
	public boolean search(TreeNode toSearch){
		if(true)
			return true;
		else
			return false;
	}


	/**
	 * prints all Nodes of a BTree
	 */
	public void print() {
		
	}
	
	public boolean search(int key) {
		return search(key, root);
	}

	public boolean search(int key, TreeNode treenode) {

		// search end in leaf

		if (treenode == null)
			return false;

		// if just one key

		if (treenode.getChildqty() == 1) {

			if (treenode.getChildnodes()[0] == key)
				return true;

			if (key < treenode.getChildnodes()[0])
				return search(key, treenode.p[0]);

			if (key > treenode.getChildnodes()[0])
				return search(key, treenode.p[1]);

		}

		// if two keys

		if (key < treenode.getChildnodes()[0])
			return search(key, treenode.p[0]);

		if ((key > treenode.getChildnodes()[0] && (key < treenode.getChildnodes()[1])))
			return search(key, treenode.p[1]);

		if (key > treenode.getChildnodes()[1])
			return search(key, treenode.p[2]);

		return true;

	}



}
