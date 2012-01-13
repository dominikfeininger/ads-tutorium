package muster.basics;

public class OverflowException extends Exception {
	public int overflowelement;
	OverflowException (int i) {overflowelement = i;}
}