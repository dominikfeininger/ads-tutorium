package uebung03;
//import uebung03.LineareSucheA;
import static gdi.MakeItSimple.*;
public class Test {
	public static void main(String[] args) {
		Suche stringtest = new Suche(); 
		int k = readInt();
		int [] f = {1,6,6};		//Array wird angelegt
		int test = stringtest.seqSearchA(f, k);			//Verweiﬂ auf die Methode seqSearchA
		println("ergebis von seqSearchA  " +test);
		test = stringtest.seqSearchB(f, k);			//Verweiﬂ auf die Methode seqSearchB
		println("ergebis von seqSearchB  " +test);
		int m = stringtest.binaereSuche(f, k);			//Verweiﬂ auf die Methode binaereSuche
		println("ergebis von binaereSuche  " +m);
	}
}
