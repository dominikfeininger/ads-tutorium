package blatt5v3;

import static gdi.MakeItSimple.*;

public class Menu {

	public static Student getStudentsData  () {  // getting students data for console element by element
		println ("Studentendaten eingaben");
		println ("MatNr. = ");
		int MatNr = readInt(); readLine();
		println ("Vorname = ");
		String Prename = readLine();
		println ("Name = ");
		String Name = readLine();
		println ("Geburtsdatum [tt.mm.jjjj] = ");
		String Date = readLine();
		return new Student (MatNr, Prename, Name, Date);

	}
	
	
	public static Student readStudentFromFile (Object input) { // getting students data from file		
			    	      
		if (!isEndOfInputFile(input)) {
			int MatNr = readInt(input); readLine(input);
			String Prename = readLine(input);
			String Name = readLine(input);
			String Date = readLine(input);
			return new Student (MatNr, Prename, Name, Date);
		}
		else return null;
	}
	

	public static void main(String[] args) {
	
		Hashtable ht = new Hashtable();
		
		while (true) {
	
			printMenu(); // print all options
	
			switch (getAction()) {
			
			case 0: { // terminates loop
				return;
			}
	

	
			case 1: { // put - get data from console
				
				Student s = getStudentsData();
	
				println("put " +  ht.put(s.getMatNr(), s));
	
				break;
			}
			
			case 2: { // get 
				println("Key = ");
				int key = readInt();
	
				println("mapped to  =" + ht.get(new MatrikelNummer(key)));
				
	
				break;
			}
			case 3: { // contains key
				println("Key = ");
				int key = readInt();
	
				println(" " + key + "  " + ht.containsKey(new MatrikelNummer(key)));
	
				break;
			}
			case 4: { // contains value
				println("Value = ");
				Student value = getStudentsData();
	
				println(" " + value + "  " + ht.contains(value));
	
				break;
			}
			case 5: { // print
				ht.print();
	
				break;
			}
			case 6:{ // size
				println("size = "+ht.size());
				
				break;
			}
	
			case 7: { // remove
				println("Key = ");
				int key = readInt();
	
				println("removed key " + key + "  "
						+ ht.removeKey(new MatrikelNummer(key)));
				break;
			}

	
			case 8: { // clear
				ht.clear();
				println("Hashtable cleared");
				ht.print();
	
				break;
			}
	
			case 9: {// load factor
				println("actual load factor= " + ht.getActualLoadFactor());
	
				break;
			}
	
			case 10: { // is Empty
				println("Hashtable is empty = "+ht.isEmpty());
				break;
			}
			
			case 11: { // filling the hash table from file with put
				
				String filename;
				
				print ("Input file for student data = ");
				filename = readLine();
				
				if (!isFilePresent(filename)) {

					println ("file " + filename + "does not exist");
					return;  // exit program if file doesn't exist
				}
				
				Object input    = openInputFile (filename);  // problems with file handling !!!
				
				Student s;
				
				while ((s = readStudentFromFile(input))!= null) {
					println("put " +  ht.put(s.getMatNr(), s));    // protocol result of put
				}
				
				closeInputFile(input);

				break;
				
			}
	
			default: {
				println("invalid input");
				break;
			}
	
			}
		}
	}

	public static int getAction() {
		String s = readLine();

		if (s.equals("0"))
			return 0;// exit
		else if (s.equals("1"))
			return 1;// put
		else if (s.equals("2"))
			return 2;// get
		else if (s.equals("3"))
			return 3;// containsKey
		else if (s.equals("4"))
			return 4;// containsValue
		else if (s.equals("5"))
			return 5;// print
		else if (s.equals("6"))
			return 6; // size
		else if (s.equals("7"))
			return 7;// remove
		else if (s.equals("8"))
			return 8;// clear
		else if (s.equals("9"))
			return 9;// loadFactor
		else if (s.equals("10"))
			return 10;// isEmpty
		else if (s.equals("11"))
			return 11;// fill from file


		else
			return -1;
	}

	public static void printMenu() {

		println("Mögliche Aktionen: Wählen Sie eine Zahl");
		println(" (1) put");
		println(" (2) get");
		println(" (3) contains key");
		println(" (4) contains value");
		println(" (5) print Hashtable");
		println(" (6) size");
		println(" (7) removeKey");
		println(" (8) clear Hashtable");
		println(" (9) actual load factor");
		println(" (10) is empty");
		println(" (11) read students from file");


		println(" (0) exit");

	}
}

