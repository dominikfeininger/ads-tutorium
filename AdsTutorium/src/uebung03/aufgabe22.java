package uebung03;
import static gdi.MakeItSimple.*;
public class aufgabe22 {
	public static void main(String[] args) {
		int normaleZahl;
		int fibZahl;
		normaleZahl = readInt();	
		fibZahl= fib(normaleZahl);
		println(fibZahl);
	}

	static int fib (int n){
		return h (n,1,1);
	}

	static int h(int n, int a, int b){
		if (n==0){			//für die Fälle 0 und 1
			return a;
		}else{				//der Fehlerfall für neg. Zahlen wird nicht behandelt
			println("return: " +(a));
			return h( n-1,b, b+a);
		}
	}
}

