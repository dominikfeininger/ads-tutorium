package gruppe_2_13;

public class TreeNode {
	private int value;
	private TreeNode leftNode;
	private TreeNode rightNode;
	
	TreeNode(){
		value=0;
		leftNode=rightNode=null;
	}
	
	TreeNode(int element){
		this.value=element;
		leftNode=rightNode=null;
	}

	public int getValue(){
		return value;
	}
	
	public TreeNode getLeftNode(){
		return leftNode;
	}
	
	public TreeNode getRightNode(){
		return rightNode;
	}
	
	public void setElement(int element){
		this.value=element;
	}
	
	public void setLeftNode(TreeNode node){
		this.leftNode=node;
	}
	
	public void setRightNode(TreeNode node){
		this.rightNode=node;
	}

}
