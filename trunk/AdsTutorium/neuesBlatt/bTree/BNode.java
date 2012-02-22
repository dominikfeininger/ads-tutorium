package bTree;

public class BNode {
        int key;
        BNode parent;
        BNode left;
        BNode right;

        public BNode(int key) {
                super();
                this.key = key;
        }

        public BNode(int key, BNode left, BNode right) {
                super();
                this.key = key;
                this.left = left;
                this.right = right;
        }

}
