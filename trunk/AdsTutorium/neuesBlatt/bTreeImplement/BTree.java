package bTreeImplement;

public class BTree {

	private TreeNode root;

	/**
	 * constuctor
	 * root = null
	 * 
	 */
	public BTree() {
		root = null;
	}

	public TreeNode getRoot() {
		return this.root;
	}

	private boolean search(int key) {
		return search(key, root);
	}

	public boolean search(int key, TreeNode treenode) {
		// search end in leaf
		if (treenode == null)
			return false;
		// if just one key
		if (treenode.getChildqty() == 1) {

			if (treenode.getKeys()[0] == key)
				return true;

			if (key < treenode.getKeys()[0])
				return search(key, treenode.getChildnodes()[0]);

			if (key > treenode.getKeys()[0])
				return search(key, treenode.getChildnodes()[1]);

		}

		// if two keys
		if (treenode.getChildqty() == 1)
			return search(key, treenode.getChildnodes()[0]);

		if ((key > treenode.getKeys()[0] && (key < treenode.getKeys()[1])))
			return search(key, treenode.getChildnodes()[1]);

		if (key > treenode.getKeys()[1])
			return search(key, treenode.getChildnodes()[2]);

		return true;
	}

	/**
	 * prints all Nodes of a BTree
	 */
	public void print() {
		this.root.print();
	}

	private void insert(int key) {
		// if key is already in tree
		if (search(key)) {
			System.out.println("key " + key + " already in tree");
			return;
		}
		System.out.println(key + " add");
		// empty tree
		if (root == null) {
			root = new TreeNode(key, null, null, null);
			return;
		}
		insert(key, root);
	}

	public void insert(int key, TreeNode tNode) {
		// node has one key
		if (tNode.getNumberOfKeys() == 1) {
			if (key < tNode.getKeys()[0]) {
				if (tNode.getChildnodes()[0] == null) {
					tNode.add(key, null, null);
					return;
				}// add
				else {
					insert(key, tNode.getChildnodes()[0]);
					return;
				} // pass

			} else {
				if (tNode.getChildnodes()[1] == null) {
					tNode.add(key, null, null);
					return;
				}// add
				else {
					insert(key, tNode.getChildnodes()[1]);
					return;
				} // pass
			}
		}
		// node has two keys
		if (key < tNode.getKeys()[0]) {
			if (tNode.getChildnodes()[0] == null) {
				split(key, tNode, null, null);
				return;
			}

			else {
				insert(key, tNode.getChildnodes()[0]);
				return;
			}

		}

		if (key > tNode.getKeys()[1]) {
			if (tNode.getChildnodes()[2] == null) {
				split(key, tNode, null, null);
				return;
			} else {
				insert(key, tNode.getChildnodes()[2]);
				return;
			}
		}
		if (tNode.getChildnodes()[1] == null) {
			split(key, tNode, null, null);
			return;
		} else {
			insert(key, tNode.getChildnodes()[1]);
			return;
		}
	}

	public void split(int key, TreeNode k, TreeNode l, TreeNode r) {
		TreeNode k0, k1, k2, v;
		// split root
		if (k == null) {
			root = new TreeNode(key, null, l, r);
			l.setFather(root);
			r.setFather(root);
			return;
		}
		// node has just one key(no split)
		if (k.getChildqty() == 1) {
			k.add(key, l, r);
			return;
		}
		// node has more keys
		v = k.getFather();
		// smalest key
		if (key < k.getKeys()[0]) {
			// split
			k0 = new TreeNode(key, v, l, r);
			k1 = new TreeNode(k.getKeys()[1], v, k.getChildnodes()[1],
					k.getChildnodes()[2]); 
			k0.setFather(v);
			k1.setFather(v);
			// pass middle key upper
			split(k.getKeys()[0], v, k0, k1);
			return;
		}
		// greatest key
		if (key > k.getKeys()[1]) {
			k0 = new TreeNode(k.getKeys()[0], v, k.getChildnodes()[0],
					k.getChildnodes()[1]);
			k1 = new TreeNode(key, v, l, r);
			k0.setFather(v);
			k1.setFather(v);
			split(k.getKeys()[1], v, k0, k1);
			return;
		}
		// key between
		k0 = new TreeNode(k.getKeys()[0], v, k.getChildnodes()[0], l);
		k1 = new TreeNode(k.getKeys()[1], v, r, k.getChildnodes()[2]);
		k0.setFather(v);
		k1.setFather(v);
		split(key, v, k0, k1);
		return;
	}
}
