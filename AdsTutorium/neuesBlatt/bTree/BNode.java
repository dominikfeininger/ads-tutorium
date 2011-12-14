package bTree;

public class BNode {
	
	//key
	private int matNr;
	private BNode[] childs = new BNode[2];
	private boolean isLeaf;
	private BNode father;
	private Student student;

	/**
	 * Node saves no data
	 * 
	 * constuctor
	 * @param key
	 * 
	 */
	public BNode(int key){
		this.matNr = key;
	}
	
	/**
	 * Node saves student objects
	 * 
	 * constuctor
	 * @param key
	 * 
	 */
	public BNode(int key, Student data){
		this(key);
		this.student = data;
	}
	
	// getter and setter
	public BNode getFather() {
		return father;
	}

	public void setFather(BNode father) {
		this.father = father;
	}
	
	public int getValue() {
		return matNr;
	}

	public void setValue(int value) {
		this.matNr = value;
	}

	public BNode getKey0() {
		return this.childs[0];
	}
	
	public BNode getKey1() {
		return this.childs[1];
	}

	public void setKey0(BNode key) {
		this.childs[0] = key;
	}
	
	public void setKey1(BNode key) {
		this.childs[1] = key;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Student getData() {
		return student;
	}

	public void setData(Student data) {
		this.student = data;
	}

}
