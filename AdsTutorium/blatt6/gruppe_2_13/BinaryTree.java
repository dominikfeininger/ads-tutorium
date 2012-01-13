package gruppe_2_13;
import static gdi.MakeItSimple.*;

public class BinaryTree {
	TreeNode wurzel;
	
	public BinaryTree empty(){
		return new BinaryTree();
	}
	
	/**
	 * This function checks if a Tree empty is or not.
	 * @return true when if Tree empty is and false otherwise.
	 */
	public boolean isEmpty(){
		if(wurzel==null)
			return true;
		else return false;
	}
	
	/**
	 * This function inserts a new element in a tree.
	 * @param val The element to insert
	 * @return true if the element was inserted and false otherwise.
	 */
	public boolean insert(int val){
		if(contains(val))
			return false;
		if(wurzel==null){
			wurzel=new TreeNode(val);
			return true;
		}
		TreeNode currentNode=wurzel;
		return insert(val,currentNode);
	}
	
	/**
	 * Recursive insertion of a new Value in the Tree
	 * @param val the value to insert
	 * @param currentNode 
	 * @return true when the value was inserted and false when not.
	 */
	private boolean insert(int val,TreeNode currentNode){
		TreeNode nextNode;
		if (currentNode.getValue()<val){
			nextNode=currentNode.getRightNode();
			if(nextNode==null){
				currentNode.setRightNode(new TreeNode(val));
				return true;
			}
		}
		else{
			nextNode=currentNode.getLeftNode();
			if(nextNode==null){
				currentNode.setLeftNode(new TreeNode(val));
				return true;
			}
		}
		return insert(val,nextNode);
		
	}
	
	/**
	 * This function inserts a new Value in the Tree with an iterative method
	 * @param val the element to been inserted
	 * @return true when element was inserted and false when not.
	 */
	public boolean insertIterativ(int val){
		TreeNode parentNode=null, childNode=wurzel;
		while(childNode!=null){//at least one node in the Tree
			parentNode=childNode;
			if(parentNode.getValue()==val)//element is already in the Tree and will be not inserted
				return false;
			else if(parentNode.getLeftNode().getValue()<val)//insert to the right size of Tree
				childNode=parentNode.getRightNode();
			else
				childNode=parentNode.getLeftNode();//insert to the left size of Tree
		}
		if(parentNode==null){//Tree is event empty
			wurzel=new TreeNode(val);
		}
		else if(parentNode.getValue()<val){
			parentNode.setLeftNode(new TreeNode(val));
		}
		else{
			parentNode.setLeftNode(new TreeNode(val));
		}
		return true;
	}
	
	/**
	 * This function go through a tree and checks if
	 * an element is present or not.
	 * @param val The element to be checked.
	 * @return true if the element is contained in the tree 
	 * and false otherwise.
	 */
	public boolean contains(int val){
		TreeNode currentNode=wurzel;
		return contains(val,currentNode);
		
	}
	
	/**
	 * This function go through a tree and checks if
	 * an element is present or not.This is going to be made 
	 * in a recursive way.
	 * @param val The element to be checked.
	 * @return true if the element is contained in the tree 
	 * and false otherwise.
	 */
	private boolean contains(int val,TreeNode currentNode){
		if(currentNode==null)
			return false;
		else if(currentNode.getValue()==val)
			return true;
		else{
			if(currentNode.getValue()<val)
				return contains(val,currentNode.getRightNode());
			else
				return contains(val,currentNode.getLeftNode());
		}
	}
	
	/**
	 * This function go through a tree and checks if
	 * an element is present or not.This is going to be made 
	 * in a iterative way.
	 * @param val The element to be checked.
	 * @return true if the element is contained in the tree 
	 * and false otherwise.
	 */
	public boolean containsIterativ(int val){
		TreeNode currentNode=wurzel;
		while(currentNode!=null){
			if(currentNode.getValue()==val)
				return true;
			else if(currentNode.getValue()<val)
				currentNode=currentNode.getRightNode();
			else
				currentNode=currentNode.getLeftNode();
		}
		return false;
	}
	
	/**
	 * This function search the knot with the value val.
	 * @param val the value to be searched.
	 * @return the knot wit the value equals val.
	 */
	private TreeNode search(int val){
		TreeNode currentNode=wurzel;
		while(currentNode!=null){
			if(currentNode.getValue()==val)
				return currentNode;
			else if(currentNode.getValue()<val)
				currentNode=currentNode.getRightNode();
			else
				currentNode=currentNode.getLeftNode();
		}
		return null;
	}

	/**
	 * This function search the biggest element of a tree. This element 
	 * is the one which most to the right. That is why we go through 
	 * the tree always by choosing the right knot. 
	 * @return the value of the last met knot. 
	 */
	public int getMax(){
		int max=-1;
		TreeNode currentNode=wurzel;
		while(currentNode!=null){
			max=currentNode.getValue();
			currentNode=currentNode.getRightNode();
		}
		return max;
	}
	
	/**
	 * This function search the smallest element of a tree. This element 
	 * is the one which most to the left. That is why we go through 
	 * the tree always by choosing the left knot. 
	 * @return the value of the last met knot. 
	 */
	public int getMin(){
		int min=-1;
		TreeNode currentNode=wurzel;
		while(currentNode!=null){
			min=currentNode.getValue();
			currentNode=currentNode.getLeftNode();
		}
		return min;
	}
	
	/**
	 * This function search the parent node for the node with the value equals 
	 * the value crossed in parameter.
	 * @param val The value the parent of which must be found 
	 * @return null if the the node with Value val ist the root and 
	 * the parent of the node otherwise
	 */
	public TreeNode getParentNode(int val){
		TreeNode node=wurzel;
		if(node.getValue()==val)//the root has no parent
			return null;
		while(node!=null){
			if(node.getLeftNode()!=null && node.getRightNode()!=null){
				if(node.getLeftNode().getValue()==val || node.getRightNode().getValue()==val)
				return node;
			}
			else if(node.getLeftNode()!=null && node.getLeftNode().getValue()==val)
					return node;
			else if(node.getRightNode()!=null && node.getRightNode().getValue()==val)
					return node;
				if(node.getValue()>val)
					node=node.getLeftNode();
				else node=node.getRightNode();
		}
		return null;
	}
	
	/**
	 * This function find out the biggest node in the left sub-tree.
	 * @param node start node(root node) from which the biggest node must be found
	 * @return The biggest node from the left sub-tree.
	 */
	private TreeNode getBiggesteNodeInLeftTree(TreeNode node){
		node=node.getLeftNode();
		while(node.getRightNode()!=null){
			node=node.getRightNode();
		}
		return node;
	}
	
	public int size(){
		return size(wurzel);
	}
	
	/**
	 * This function go in the recursive way and counts the knots of a tree.
	 * @param currentNode The knot which is treated.
	 * @return the number of knot of a tree.
	 */
	private int size(TreeNode currentNode){
		if(currentNode==null)
			return 0;//There is no knot in the tree
		else if(currentNode.getLeftNode()==null && currentNode.getRightNode()==null)
			return 1;//There is only one knot in the tree:the current knot.
		else if(currentNode.getLeftNode()==null)
		//There is one knot(root) in the tree plus the knots of the right sub-tree
			return 1+size(currentNode.getRightNode());
		//There is one knot(root) in the tree plus the knots of the left sub-tree
		else if(currentNode.getRightNode()==null)
			return 1+size(currentNode.getLeftNode());
		//There is one knot(root) int the tree plus the knots of both sub-trees.
		else return 1+size(currentNode.getLeftNode())+size(currentNode.getRightNode());
	}
	
	public  void printInorder(){
		println(inOrder(wurzel));
	}
	
	private String inOrder(TreeNode node){
		if(node==null)
			return "";
		if(node.getLeftNode()==null && node.getRightNode()==null)
			return ""+node.getValue();
		if(node.getLeftNode()!=null && node.getRightNode()!=null)
			return inOrder(node.getLeftNode())+" "+node.getValue()+" "+inOrder(node.getRightNode());
		else if(node.getLeftNode()==null)
			return node.getValue()+" "+inOrder(node.getRightNode());
		else return inOrder(node.getLeftNode())+" "+node.getValue();
	}
	
	public  void printPreorder(){
		println(preOrder(wurzel));
	}
	
	private String preOrder(TreeNode node){
		if(node==null)
			return "";
		if(node.getLeftNode()==null && node.getRightNode()==null)
			return ""+node.getValue();
		if(node.getLeftNode()!=null && node.getRightNode()!=null)
			return node.getValue()+" "+preOrder(node.getLeftNode())+" "+preOrder(node.getRightNode());
		else if(node.getLeftNode()==null)
			return node.getValue()+" "+preOrder(node.getRightNode());
		else return node.getValue()+" "+preOrder(node.getLeftNode());
	}
	
	public  void printPostorder(){
		println(postOrder(wurzel));
	}
	
	private String postOrder(TreeNode node){
		if(node==null)
			return "";
		if(node.getLeftNode()==null && node.getRightNode()==null)
			return ""+node.getValue();
		if(node.getLeftNode()!=null && node.getRightNode()!=null)
			return postOrder(node.getLeftNode())+" "+postOrder(node.getRightNode())+" "+node.getValue();
		else if(node.getLeftNode()==null)
			return postOrder(node.getRightNode())+" "+node.getValue();
		else return postOrder(node.getLeftNode())+" "+node.getValue();
	}
	
	public BinaryTree tiefClone(){
		BinaryTree newTree=new BinaryTree();
		tiefClone(wurzel,newTree);
		return newTree;
	}
	
	private void tiefClone(TreeNode node,BinaryTree newTree){
		if(node==null)
			return;
		else{
				newTree.insert(node.getValue());
				if(node.getLeftNode()!=null)
					tiefClone(node.getLeftNode(),newTree);
				if(node.getRightNode()!=null)
					tiefClone(node.getRightNode(),newTree);
		}
	}
	
	/**
	 * This function find out the Height of a tree.
	 * @return The  height of the tree.
	 */
	public  int height(){
		return getHeight(wurzel);
	}
	
	
	/**
	 * This Function find out the Height of a tree.It go on 
	 * the recursive way to find that.
	 * @param node The knot from the which the height is calculated.
	 * @return the height of the tree
	 */
	private int getHeight(TreeNode node){
		int leftHeight=0,rightHeight=0;
		if(node==null)//tree is empty.
			return 0;
		if(node.getLeftNode()==null && node.getRightNode()==null)
			return 1;//tree hat only one knot.
		if(node.getLeftNode()!=null && node.getRightNode()!=null){
			//find out the height of both treePart and take the highest
			leftHeight=getHeight(node.getLeftNode());
			rightHeight=getHeight(node.getRightNode());
			if(leftHeight>rightHeight)
				return 1+leftHeight;
			else return 1+rightHeight;
		}
		//find out the height of the not empty sub-tree.
		else if(node.getLeftNode()==null)
			return 1+getHeight(node.getRightNode());
		else return 1+getHeight(node.getLeftNode());
	}
	
	/**
	 * This function find out how much children has a node
	 * @param node The node to be checked
	 * @return null if node has more than one child and 
	 * the only child otherwise.
	 */
	private TreeNode getOnlySon(TreeNode node){
		if(node.getLeftNode()!=null && node.getRightNode()==null)
			return node.getLeftNode();
		else if(node.getLeftNode()==null && node.getRightNode()!=null)
			return node.getRightNode();
		else return null;
	}
	
	/**
	 * This Function remove an element in a tree
	 * @param val Element to be removed.
	 * @return true if element was removed and 
	 * false otherwise.
	 */
	public boolean remove(int val ){
		TreeNode nodeToDelete=search(val);
		if(nodeToDelete==null)// element is not in the tree
			return false;
		
			TreeNode parent=getParentNode(val);
			if(nodeToDelete.getLeftNode()==null && nodeToDelete.getRightNode()==null){
				//the node to delete is an sheet or the only node of the tree.
				if(nodeToDelete==wurzel)
					wurzel=null;
				else if(parent.getLeftNode()==nodeToDelete)
					parent.setLeftNode(null);
				else
					parent.setRightNode(null);
			}
			else if(nodeToDelete.getLeftNode()==null ^ nodeToDelete.getRightNode()==null)//^ is Or exclusive
				//This node has just one child
				if(nodeToDelete==wurzel)
					wurzel=getOnlySon(wurzel);
				else if(parent.getLeftNode()==nodeToDelete)
					parent.setLeftNode(getOnlySon(nodeToDelete));
				else
					parent.setRightNode(getOnlySon(nodeToDelete));
			else{//replace the node with the biggest node from the left sub-tree.
				TreeNode groessteLeftNode=getBiggesteNodeInLeftTree(nodeToDelete);
			    parent=getParentNode(groessteLeftNode.getValue());
				if(groessteLeftNode==nodeToDelete.getLeftNode()){
					//the first node in the left sub-tree is the biggest
					groessteLeftNode.setRightNode(nodeToDelete.getRightNode());
				}
				   //the biggest node in the left sub-tree is not the first
				else if(groessteLeftNode.getLeftNode()==null){// and this node has not child
					parent.setRightNode(null);
					groessteLeftNode.setLeftNode(nodeToDelete.getLeftNode());
					groessteLeftNode.setRightNode(nodeToDelete.getRightNode());
				}
				else{//this node has one child
					parent.setRightNode(groessteLeftNode.getLeftNode());
					groessteLeftNode.setLeftNode(nodeToDelete.getLeftNode());
					groessteLeftNode.setRightNode(nodeToDelete.getRightNode());
				}
				//Finally replace the node to delete by the biggest node in the left sub-tree.
				if(nodeToDelete==wurzel)
					wurzel=groessteLeftNode;
				else{
					//nodeToDelete=groessteLeftNode;
					parent=getParentNode(nodeToDelete.getValue());
					if(parent.getLeftNode()==nodeToDelete)
						parent.setLeftNode(groessteLeftNode);
					else parent.setRightNode(groessteLeftNode);
				}
			}
			return true;
	}

	/**
	 * This Function loads the values of a file in a Tree
	 * @param fileName The name (path) of File to be loaded in the tree
	 * @return true if the file was loaded und false otherwise.
	 */
	public boolean LoadFile(String fileName){
		if(!isFilePresent(fileName))
			return false;
		else{
			Object datei=openInputFile(fileName);
			while(!isEndOfInputFile(datei)){
				insert(readInt(datei));
			}
			closeInputFile(datei);
			return true;
		}
	}
}
