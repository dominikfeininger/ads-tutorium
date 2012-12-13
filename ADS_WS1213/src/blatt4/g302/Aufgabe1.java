/*Vorname: Stefan
 *Nachname: Hintzen
 *matrikel-Nr.: 1223756
 *
 *Vorname: René	
 *Nachname: Schmidt
 *matrikel-Nr.: 1232977
 *
 *Vorname: Naranchuluu
 *Nachname: Amarsanaa
 *matrikel-Nr.: 1224483
 */
package blatt4.g302;

import static gdi.MakeItSimple.*;

public class Aufgabe1 {

	private static final String pfad="G:\\workspace\\GDI\\src\\uebung4\\";
	private static int n=0;

	public static void main(String[] args) {
		mergeSort(pfad+readLine());
	}

	public static void mergeSort(String dateipfad){
		n=2;
		/*Überprüft auf Verhandensein der Dateien. Ruft Split, Merge und printruns so lange auf, bis Blocklänge
		 * größer ist als die Anzahl der Zahlen. */
		if(isFilePresent(dateipfad)){
			if(isFilePresent(pfad+"HilfDatei1.txt")&&isFilePresent(pfad+"HilfDatei2.txt")){
				for(int blockLaenge=1;blockLaenge<n;blockLaenge*=2){
					printruns(dateipfad,blockLaenge);
					splitt(dateipfad,blockLaenge);
					merge(dateipfad,blockLaenge);
				}	
				println("Datei sortiert");
			}else println("HifDatei konnte nicht gefunden werden");
		}else println("Datei: "+dateipfad+" konnte nicht gefunden werden");
	}

	public static void splitt(String dateipfad, int blockLaenge){
		n=0;
		Object file = openInputFile(dateipfad);
		Object hilfDatei1 = openOutputFile(pfad+"HilfDatei1.txt");
		Object hilfDatei2 = openOutputFile(pfad+"HilfDatei2.txt");
		for(int i=0;!isEndOfInputFile(file);i++){
		/*Überprüft, in welche hilfsDatei welche Nummern kopiert werden: 
		 * - Nummern in geraden Blöcken in hilfDatei1.
		 * - Nummern in ungeraden Blöcken in hilfDatei2.
		 * Zählt die Anzahl der Zahlen in jedem Durchlauf.*/	
			Object datei;
			if(i%2==0)datei=hilfDatei1;
			else datei=hilfDatei2;
			for(int j=0;j<blockLaenge&&!isEndOfInputFile(file);j++){
				print(datei," "+readInt(file));
				n++;
			}

		}
		closeInputFile(file);
		closeOutputFile(hilfDatei1);
		closeOutputFile(hilfDatei2);
	}
	
	public static void merge(String dateipfad, int blockLaenge){
		Object file=openOutputFile(dateipfad);
		Object hilfDatei1=openInputFile(pfad+"HilfDatei1.txt");
		Object hilfDatei2=openInputFile(pfad+"HilfDatei2.txt");
		if(!isEndOfInputFile(hilfDatei1)&&!isEndOfInputFile(hilfDatei2)){
			int zahl1=readInt(hilfDatei1), zahl2=readInt(hilfDatei2);
			boolean ende1=false, ende2=false;
			//Solange das ende beider Dateien nicht erreicht ist
			while(!ende1||!ende2){
				int i1=0;
				int i2=0;
				//Solange kein Blockende und kein Dateiende erreicht, werden die beiden zahlen verglichen.
				while(i1<blockLaenge&&i2<blockLaenge&&!ende1&&!ende2){
					//Die kleinere Zahl wird hineingeschrieben und die nächste Zahl aus der selben hilfDatei wird ausgelesen.
					if(zahl1<zahl2){
						print(file," "+zahl1);
						if(!isEndOfInputFile(hilfDatei1)){
							zahl1=readInt(hilfDatei1);
							ende1=false;
						}else ende1=true;
						i1++;
					}else {
						print(file," "+zahl2);
						if(!isEndOfInputFile(hilfDatei2)){
							zahl2=readInt(hilfDatei2);
							ende2=false;
						}else ende2=true;
						i2++;
					}
				}
				//Der Block der noch nicht zu ende ist wird hinten dran geschrieben.
				while(i1<blockLaenge&&!ende1){
					print(file," "+zahl1);
					if(!isEndOfInputFile(hilfDatei1)){
						zahl1=readInt(hilfDatei1);
						ende1=false;
					}else ende1=true;
					i1++;

				}
				while(i2<blockLaenge&&!ende2){
					print(file," "+zahl2);
					if(!isEndOfInputFile(hilfDatei2)){
						zahl2=readInt(hilfDatei2);
						ende2=false;
					}else ende2=true;
					i2++;
				}
			}
		}
		closeOutputFile(file);
		closeInputFile(hilfDatei1);
		closeInputFile(hilfDatei2);
	}
	
	public static void printruns(String dateipfad, int blocklaenge){
		Object datei=openInputFile(dateipfad);
		while(!isEndOfInputFile(datei)){
			print("(");
			for(int i=0;!isEndOfInputFile(datei)&&i<blocklaenge;i++)
				print(readInt(datei)+" ");
			print(")");
		}
		println();
		closeInputFile(datei);
	}

}
