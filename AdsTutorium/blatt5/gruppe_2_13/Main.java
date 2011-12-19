package gruppe_2_13;

import static gdi.MakeItSimple.*;

import java.util.Scanner;


public class Main {

	private static LinkedList list;

	public static void main(String[] args) {

		list = new MyLinkedList();

		while (true) {
			makeMenu();
		}

	}

	public static void makeMenu() {
		println("------------------- Menu -------------------");
		println("1: Print List");
		println("2: Print size of the list");
		println("3: add(index, element)");
		println("4: addFirst(element)");
		println("5: addLast(element)");
		println("6: addAll(LinkedList)");
		println("7: get(index)");
		println("8: getFirst()");
		println("9: getLast()");
		println("10: removeFirst()");
		println("11: removeLast()");
		println("12: removeAll()");
		println("13: remove(element)");

		print(" selection: ");
		Scanner eingabe=new Scanner(System.in);
		int selection = readInt();
		readLine();
		int index;
		String element;
		MyObject obj1;
		println();
		switch (selection) {
		case 1:
			element=list.toString();
			if(element.equals(""))
				println("Die Liste ist Leer!!");
			else
				println("Listzustand: "+element);
			break;
		case 2:
			println("l�nge der List ist: "+list.size());
			break;
		case 3:
			print("Geben sie die einf�ge Position ein: ");
			index=readInt();
			readLine();
			if(list.size()==0 && index!=1){
				println("ung�ltige Index!! Die Position 1 ist noch nict besetz!!");
				break;
			}
			if(index>list.size() &&(index-list.size()!=1 && index-list.size()!=-1)){
				println("ung�ltige Index!! Die Position "+list.size()+1+" muss zuerst besetz werden!!!");
				break;
			}
			print("Geben sie das Element ein: ");
			//element=eingabe.nextLine();
			element=readLine();
			MyObject neuObject=new MyObject(element);
			list.add(index, neuObject);
			println("Das Element \""+element+"\" wurde and der Position "+index+" hinzugef�gt!!");
			break;
		case 4:
			println("Geben sie das hinzuf�gende Element ein:");
			element=eingabe.nextLine();
			println("element= "+ element);
			obj1 = new MyObject(element);
			//MyObject obj1 = new MyObject("First Element");
			list.addFirst(obj1);
			println("Das Element\""+element+"\" wurde am Anfang der List hinzugef�gt!!");
			break;
		case 5:
			print("Geben sie das hinzuf�gende Element ein:");
			//element=eingabe.nextLine();
			element=readLine();
			obj1 = new MyObject(element);
			//MyObject obj1 = new MyObject("First Element");
			list.addLast(obj1);
			println("Das Element\""+element+"\" wurde am Ende der List hinzugef�gt!!");
			break;
		case 6:
			// your code here
			break;
		case 7:
			print("Geben sie das Index des gew�nschtes Elements ein:");
			index=readInt();
			if(list.get(index)!=null)
				println("Element at Position "+index+" ist: "+list.get(index).getValue());
			else
				println("********Eine ung�ltige Position wurde eingegen oder ist die Liste leer !!***********");
			break;
		case 8:
			if(list.getFirst()==null)
				println("Die Liste hat kein Element");
			else
				println("Erst Element ist: "+list.getFirst().getValue());
			break;
		case 9:
			if(list.getFirst()==null)
				println("Die Liste hat kein Element");
			else
				println("Last Element ist: "+list.getLast().getValue());
			break;
		case 10:
			list.removeFirst();
			println("Das erste Element wird gel�scht!!");
			break;
		case 11:
			list.removeLast();
			println("Das letzte Element wird gel�scht!!");
			break;
		case 12:
			list.clear();
			println("Alle Elemente der List wurden gel�scht!!");
			break;
		case 13:
			print("Geben das zu l�schende Element ein:");
			element=eingabe.nextLine();//element=readLine();
			list.delete(element);
			println("Das Element \""+element+"\" wird gel�scht!!");
			break;
		default:
			break;
		}


	}
}

