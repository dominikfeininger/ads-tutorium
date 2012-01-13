package muster.basics;

public interface Queue  {
	public void enter (Element e) throws OverflowException;
	public Element leave () throws UnderflowException;
	public boolean isEmpty ();
}