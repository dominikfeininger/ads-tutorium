package uebung03;
import static gdi.MakeItSimple.*;
public class aufgabe21 {
	public static void main(String[] args) {
		int normaleZahl;
		int fibZahl;
		normaleZahl = readInt();	
		fibZahl=fib(normaleZahl);
		println(fibZahl);
	}
	static int fib(int n){
		if (n<=1){			//f�r die F�lle 0 und 1
			println("return: 1");
			return 1;
		}else{				//der Fehlerfall f�r neg. Zahlen wird nicht behandelt
			println("return" + (n-1)+ "+" +(n-2));
			return fib( n-1 ) + fib( n-2 );
		}
	}
}

