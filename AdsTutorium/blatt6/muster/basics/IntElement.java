package muster.basics;

import static gdi.MakeItSimple.*;

public class IntElement extends Element {
	
	private int val;
	
	public IntElement (int val) {
		this.val = val;
	}
	
	public IntElement () {
		this.val = 0;
	}
	
	public void setVal (int val) {
		this.val = val;
	}
	
	public int getVal () {
		return this.val;
	}

	public int compareTo(Element e) {
		if (e instanceof IntElement)
			if (this.val < ((IntElement)e).getVal()) return -1;
			else if (this.val > ((IntElement)e).getVal()) return 1;
			else return 0;
		else return -5; // Durch Exception ersetzen, wenn behandelt
	}
		
	public Element clone() {
		return new IntElement (this.val);
		
	}
	public void print() {
		gdi.MakeItSimple.print (this.val + " ");
	}
	
	public String toString() {
		Integer ival = val;
		return ival.toString();
	}


}
