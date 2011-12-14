package bTree;

public class BMain {

	public static void main(String[] args) {
		
		BNode root = new BNode(812345);
		BNode node1 = new BNode(821345);
		BNode node2 = new BNode(801234);
		
		BTree tree1 = new BTree(root);
		
		tree1.insert(node1);
		tree1.insert(node2);
		
		tree1.printTree(root);
	
	}

}
