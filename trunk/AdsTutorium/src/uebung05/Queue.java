package uebung05;

import static gdi.MakeItSimple.*;

public class Queue {

	private List queue = null;

	public Queue() {
		queue = new List();
	}

	public void empty(){
		queue = new List();
	}
	
	public void enter(int obj) {
		queue.addLast(obj);
	}
	
	public int leave() {
		if (isEmpty()){
			println("queue underflow");
			return -1;
		} else {
			int leaveObj = queue.getFirst();
			queue.removeFirst();
			return leaveObj;
		}
	}
	
	public int front(){
		return queue.getFirst();
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
}