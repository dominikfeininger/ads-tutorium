package bTree;

public class BTest {
	
	public static void main(String[] args) {
        BTree tree = new BTree();
        tree.insert(5);
        tree.insert(8);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(100);
        tree.insert(4);
        tree.insert(999);
        tree.insert(400);
        tree.insert(401);
        tree.insert(-1000);
        tree.inorderDisplay(tree.getRoot());
        System.out.println(tree.contains(tree.getRoot(), -1));
        System.out.println(tree.contains(tree.getRoot(), 1));
        System.out.println(tree.contains(tree.getRoot(), 101));
        System.out.println(tree.contains(tree.getRoot(), 100));
        System.out.println("----------------------------");
        System.out.println(tree.contains(-1));
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(101));
        System.out.println(tree.contains(100));
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(7));

        System.out.println("min:" + tree.minValue());
        System.out.println("max:" + tree.maxValue());
}

}
