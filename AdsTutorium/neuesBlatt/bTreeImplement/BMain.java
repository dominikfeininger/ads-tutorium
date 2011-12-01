package bTreeImplement;

public class BMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(11);
		TreeNode node2 = new TreeNode(22);
		TreeNode node3 = new TreeNode(33);
		BTree bTree = new BTree();
		//bTree.insert(1, node1);
		//bTree.insert(2, node2);
		//bTree.insert(3, node3);
		bTree.print();
		
	}
}
