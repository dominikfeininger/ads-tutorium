package uebung06;

import static gdi.MakeItSimple.*;

public class TreeEnvironment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree(8);
		TreeNode node = new TreeNode(4);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(8);
		TreeNode node5 = new TreeNode(3);

		String harrald = "c:\\file.txt";
		if (isFilePresent(harrald)) {
			Object file = openInputFile(harrald);
			tree.loadFromFile(file);
			closeInputFile(file);
		}

		/*
		 * tree.insert(4); tree.insert(2); tree.insert(5); tree.insert(1);
		 * tree.insert(6);
		 */
		tree.printPreorder(node);
		tree.printPostorder(node);
		tree.printInorder(node);
		println(node.getElement());
		tree.printNode(node);
	}
}
