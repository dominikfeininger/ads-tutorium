package uebung06;

import static gdi.MakeItSimple.*;

public class Test {

	public static void main(String args[]) {
		boolean check = true;
		boolean error;
		int val = 0;

		BinaryTree tree = new BinaryTree();
		TreeNode node1 = new TreeNode(6);

		// main loop with all actions
		do {

			println();
			println("choose an action: ");
			println("    ( 1) print preorder");
			println("    ( 2) print postorder");
			println("    ( 3) print inorder");
			println("    ( 4) load from file");
			println("    ( 5) new tree with parameter");
			println("    ( 6) new tree without parameter");
			println("    ( 7) construct an new tree from two section beam");
			println("    ( 8) is empty");
			println("    ( 9) get the root");
			println("    (10) remove an element");
			println("    (11) search");
			println("    (12) insert an element");
			println("    (13) end");

			switch (readInt()) {
			case 1:
				tree.printPreorder(tree.value());
				break;
			case 2:
				tree.printPostorder(tree.value());
				break;
			case 3:
				tree.printInorder(tree.value());
				break;
			case 4:
				String harrald = "c:\\file.txt";
				if (isFilePresent(harrald)) {
					Object file = openInputFile(harrald);
					tree.loadFromFile(file);
					closeInputFile(file);
				} else {
					println("file not found");
				}
				println("the values were correct loaded");
				break;
			case 5:
				println("insert an value");
				val = readInt();
				tree.insert(val);
				break;
			case 6:
				BinaryTree tree1 = new BinaryTree();
				break;
			case 7:
				println("write an Integer for your root");
				val = readInt();
				tree.bin(val, tree);
				break;
			case 8:
				error = tree.isEmpty();
				println(error);
				break;
			case 9:
				node1 = tree.value();
				if(node1 != null){
				println(node1.getElement());
				}else{
					println("false");
				}
				break;
			case 10:
				println("which element would you remove?");
				val = readInt();
				tree.remove(val);
				break;
			case 11:
				println("which value you are seaching for?");
				val = readInt();
				node1 = tree.search(val);
				println(node1.getElement());
				break;
			case 12:
				println("whitch value would you insert?");
				val = readInt();
				tree.insert(val);
				break;
			case 13:
				check = false;
				break;
			default:
				println("false entry");
				break;
			}
		} while (check == true);
		println("Programmende!");
	}
}
