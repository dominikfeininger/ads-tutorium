package bBaumImplement;

public class BBaumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BBaumKnoten knoten1 = new BBaumKnoten(11);
		BBaumKnoten knoten2 = new BBaumKnoten(17);
		BBaumKnoten knoten3 = new BBaumKnoten(1);
		BBaumKnoten knoten4 = new BBaumKnoten(4);
		
		BBaumBaum baum1 = new BBaumBaum();
		baum1.einfuegen(knoten1);
		baum1.einfuegen(knoten2);
		baum1.einfuegen(knoten3);
		baum1.einfuegen(knoten4);

		baum1.drucken();
		
	}
}
