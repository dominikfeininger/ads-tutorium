package gruppe_2_13;
import static gdi.MakeItSimple.*;

public class MyLinkedList implements LinkedList {

	private ListNode head;
	private ListNode tail;
	
	public void addFirst(MyObject element) {
		ListNode neuElement=new ListNode();
		neuElement.setElement(element);
		neuElement.setNext(head);
		if(head==null)
			tail=neuElement;
		head=neuElement;
	}

	public void addLast(MyObject element) {
		ListNode neuElement=new ListNode();
		neuElement.setElement(element);
		if(tail!=null){
			tail.setNext(neuElement);
			tail=neuElement;
		}
		else
			this.addFirst(element);
	}

	public void add(int index, MyObject element) {
		int laenge=this.size();
		boolean letze=false;
		ListNode hinzugefuegendeNode=new ListNode();
		ListNode currentNode=this.head;
		ListNode temporare;
		hinzugefuegendeNode.setElement(element);
		if(index>laenge)
			letze=true;
		if(this.size()==0){
			this.addFirst(element);
			return;
		}
		for(int i=1;i<=laenge;i++){
			if(i+1==index){
				temporare=currentNode.getNext();
				currentNode.setNext(hinzugefuegendeNode);
				hinzugefuegendeNode.setNext(temporare);
				if(letze)
					this.tail=hinzugefuegendeNode;
				break;
			}
			else currentNode=currentNode.getNext();
		}
		
	}
	
	public void addAll(MyLinkedList otherList) {
		int laenge=otherList.size();
		for(int i=1;i<=laenge;i++)
			this.addLast(otherList.get(i));
	}
	
	public void removeFirst() {
		if(this.head==null)
			return;
		this.head=this.head.getNext();
		
	}
	
	public void removeLast(){
		ListNode currentNode=this.head;
		ListNode nextNode;
		int zaehler=2;
		if(this.head==null)
			return;
		if(currentNode.getNext()==null){
			this.head=null;
		}
		else while(zaehler<=this.size()){
			nextNode=currentNode.getNext();
			if(nextNode.getNext()==null){
				currentNode.setNext(null);
				break;
			}
			currentNode=nextNode;
			nextNode=currentNode.getNext();
			zaehler++;
		}
	}

	public void delete(String element) {
		ListNode currentNode=head;
		ListNode nextNode;
		for(int i=1;i<=this.size();i++){
			nextNode=currentNode.getNext();
			if(i==1){
				if(currentNode.getElement()==null){return;}
				if(currentNode.getElement().getValue().equals(element)){
					head=head.getNext();
					break;
				}
			}	
			if(nextNode.getElement().getValue().equals(element)){
				if(nextNode.getNext()==null){
					currentNode.setNext(null);
					this.tail=currentNode;
				}
					
				else
					currentNode.setNext(nextNode.getNext());
			}
			currentNode=nextNode;
		}
		
	}
	
	public void clear() {
		this.head=null;
		this.tail=null;
		
	}
	
	public MyObject getFirst() {
		if(this.head!=null)
			return this.head.getElement();
		else return null;
	}

	public MyObject getLast() {
		if(this.tail!=null)
			return tail.getElement();
		else return null;
	}

	public MyObject get(int index) {
		int laenge=this.size();
		ListNode currentNode=this.head;
		for(int i=1;i<=laenge;i++){
			if(i==index)
				return currentNode.getElement();
			else
				currentNode=currentNode.getNext();
		}
		return null;
	}
	
	public boolean isEmpty() {
		if(head==null)
			return true;
		return false;
	}

	public boolean contains(String element) {
		ListNode currentNode=head;
		if(currentNode.getElement().getValue().equals(element))
			return true;
		else while(currentNode.getNext()!=null){
			currentNode=currentNode.getNext();
			if(currentNode.getElement().getValue().equals(element))
				return true;
		}
		return false;
	}

	public int size() {
		int laenge=0;
		ListNode currentNode=head;
		//if(!this.isEmpty())
			while(currentNode!=null){
				laenge++;
				if(currentNode.getNext()==null)
					return laenge;
				else
					currentNode=currentNode.getNext();
			}
		return 0;
	}
	
	public MyObject[] toArray() {
		MyObject []meinArray=new MyObject[this.size()];
		ListNode currentNode=head;
		for(int i=0;i<this.size();i++){
			meinArray[i]=currentNode.getElement();
			currentNode=currentNode.getNext();
		}
		return meinArray;
	}
	
	public String toString() {
		String ausgabe="";
		ListNode currentNode=this.head;
		for(int i=0;i<this.size();i++){
			if(i!=this.size()-1)
				ausgabe+=currentNode.getElement().getValue()+", ";
			else
				ausgabe+=currentNode.getElement().getValue();
			currentNode=currentNode.getNext();
		}
		return ausgabe;
	}

	public MyLinkedList cloneDeep(){
		MyLinkedList liste=new MyLinkedList();
		ListNode currentNode=this.head;
		MyObject currentObject;
		int anzahl=1;
		while(anzahl<=this.size()){
			if(currentNode!=null){
				currentObject=new MyObject(currentNode.getElement().getValue());
				liste.addLast(currentObject);
				currentNode=currentNode.getNext();
			}
			else break;
		}
		return liste;
	}
	
	public MyLinkedList clone(){
		return this;
	}

	public void printList(){
		ListNode element=this.head;
		while(element!=null){
			print("-"+element.getElement().getValue());
			element=element.getNext();
		}
		println();
	}
	

	public ListNode getFirstNode(){
		return this.head;
	}
	
	public static MyLinkedList empty(){
		MyLinkedList list= new MyLinkedList();
		return list;
	}
	
	
//	public void addAll(MyLinkedList otherList) {
//		if (this!=otherList)//ohne diese bedingung erzeugt sich ein unendlische schleife, denn tail geht wieder nach head
//			this.tail.setNext(otherList.getFirstNode());
//	}

}
