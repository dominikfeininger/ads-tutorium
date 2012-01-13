package muster.binarytree;

import muster.basics.*;

public class TreeNode extends Element{// Node of a binary tree
	
////////////////////////class TreeNode     //////////////////////////////////
	  Element elem;
	  TreeNode left;
	  TreeNode right;

	  public TreeNode (Element i) {
		elem = i;
		left = right = null;
	  }

	  public TreeNode getLeft () {
		return left;
	  }

	  public TreeNode getRight () {
		return right;
	  }

	  public Element getElement () {
		return elem;
	  }

	  public void setLeft (TreeNode n) {
	   left = n;
	 }

	 public void setRight (TreeNode n) {
	 right = n;
	 }

	 public void print () {
	   elem.print();
	 }
	 
	 public Element value () {
		 return this.value();
	 }

	@Override
	public Element clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Element e) {
		// TODO Auto-generated method stub
		return 0;
	}
	}

	//////////////////////// end of class TreeNode   ///////////////////////////////

