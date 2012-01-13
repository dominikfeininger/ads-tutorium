package muster.queues;

import muster.basics.*;
import muster.linkedList_v3.List;


public class QueueLL implements Queue {
	
	private List queue;
	
	public QueueLL () {
		queue = new List();
	}
	
	public void enter (Element e) throws OverflowException {
		queue.addLast(e);		
	}
	
	public Element leave () throws UnderflowException {
		
		if (queue.isEmpty()) throw new UnderflowException();
		
		return queue.removeFirst();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}