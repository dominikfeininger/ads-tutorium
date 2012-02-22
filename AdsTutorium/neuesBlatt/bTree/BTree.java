package bTree;

import java.util.NoSuchElementException;

public class BTree {
        private BNode root;

        public BTree() {
                setRoot(null);
        }

        public void inorderDisplay(BNode node) {
                if (node != null) {
                        inorderDisplay(node.left);
                        System.out.print(node.key + " ");
                        inorderDisplay(node.right);
                }
        }

        public void insert(int value) {
                BNode y = null; // 指向插入位置的parent
                BNode x = getRoot(); // 指向插入的位置
                while (x != null) {
                        y = x;
                        if (value < x.key) {
                                x = x.left;
                        } else {
                                x = x.right;
                        }
                }
                BNode z = new BNode(value);
                z.parent = y;
                if (y == null) {
                        setRoot(z);
                } else {
                        {
                                if (value < y.key) {
                                        y.left = z;
                                } else {
                                        y.right = z;
                                }
                        }

                }

        }

        public boolean contains(BNode node, int value) {
                if (node == null)
                        return false;
                if (node.key == value)
                        return true;
                if (value < node.key) {
                        return contains(node.left, value);
                } else
                        return contains(node.right, value);

        }

        public boolean contains(int value) {
                BNode x = getRoot();
                if (x == null)
                        return false;
                while (value != x.key) {
                        if (value < x.key) {
                                x = x.left;
                        } else
                                x = x.right;
                        if (x == null)
                                return false;

                }
                return true;

        }

        public int minValue() {
                BNode node = getRoot();
                while (node.left != null) {
                        node = node.left;
                }
                if (node != null)
                        return node.key;
                else
                        throw new NoSuchElementException();
        }

        public int maxValue() {
                BNode node = getRoot();
                while (node.right != null) {
                        node = node.right;
                }
                if (node != null)
                        return node.key;
                else
                        throw new NoSuchElementException();
        }

		public void setRoot(BNode root) {
			this.root = root;
		}

		public BNode getRoot() {
			return root;
		}

}