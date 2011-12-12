package bTreeImplement;

public class BMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(11);
		TreeNode node1 = new TreeNode(11);
		TreeNode node2 = new TreeNode(22);
		TreeNode node3 = new TreeNode(33);
		
		BTree bTree = new BTree(root);
		
		bTree.insert(5, node1);
		bTree.insert(7, node2);
		bTree.insert(5, node3);
		
		bTree.print();
		
	}
}
