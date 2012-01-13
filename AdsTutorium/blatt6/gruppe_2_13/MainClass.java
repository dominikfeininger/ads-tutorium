package gruppe_2_13;
import static gdi.MakeItSimple.*;

public class MainClass {

	public static void main(String[] args) {
		BinaryTree myTree=new BinaryTree(), myCloneTree=new BinaryTree();
		boolean isCopyBaumPresent=false;

		int auswahl=0,val;
		while(auswahl!=15){	
			println("1: Datei Laden");
			println("2: Insert");
			println("3: Remove");
			println("4: Contains");
			println("5: Size");
			println("6: Height");
			println("7: getMax");
			println("8: getMin");
			println("9: isEmpty");
			println("10: empty");
			println("11: printInorder");
			println("12: printPreorder");
			println("13: printPostorder");
			println("14: clone");
			println("15: Programm beenden");
			print("			Auswahl: ");
			auswahl=readInt();readLine();
			switch(auswahl){
			case 1:
				print("Geben sie den DateiName ein: ");
				String fileName=readLine();
				if(isFilePresent(fileName)){
					if(myTree.LoadFile(fileName))
						println("Der Datei wurde erfolgreich geladen");	
				}
				else println("Ung�ltiger DateiName");
				break;
			case 2:
				println("Geben sie ein integer ein:");
				val=readInt(); readLine();
				if(myTree.insert(val))
					println("Das Element wurde eingef�gt.");
				else println("Erfolglos Einf�gen!!");
				break;
			case 3:
				println("Geben sie das zu l�schende element ein:");
				val=readInt(); readLine();
				if(myTree.remove(val))
					println("Das Element wurde erfolgreich gel�scht");
				else
					println("L�schen unm�glich!!");
				break;
			case 4:
				println("Geben sie das zu pr�fende Element ein:");
				val=readInt(); readLine();
				if(myTree.contains(val))
					println("Das Element wurde im Baum gefunden");
				else
					println("Der Baum enth�lt nicht "+val);
				break;
			case 5:
				if(isCopyBaumPresent){
					println("Der Orginalbaum hat: "+myTree.size()+" Knoten");
					println("Der Copybaum hat: "+myCloneTree.size()+" Knoten");
					break;	
				}
				println("Der Baum hat: "+myTree.size()+" Knoten");
				break;
			case 6:
				if(isCopyBaumPresent){
					println("Der Orginalbaum ist der H�he: "+myTree.height());
					println("Der Copybaum ist der H�he: "+myCloneTree.height());
					break;
				}
				println("Der Baum ist der H�he "+myTree.height());
				break;
			case 7: 
				if(isCopyBaumPresent){
					println("Der gr��te Element des OrginalBaumes ist: "+myTree.getMax());
					println("Der gr��te Element des CopyBaumes ist: "+myCloneTree.getMax());
					break;
				}
				println("Der gr��te Element des Baumes ist: "+myTree.getMax());
				break;
			case 8: 
				if(isCopyBaumPresent){
					println("Der kleinste Element des OrginalBaumes ist: "+myTree.getMin());
					println("Der kleinste Element des CopyBaumes ist: "+myCloneTree.getMin());
					break;
				}
				println("Der kleinste Element des Baumes ist: "+myTree.getMin());
				break;
			case 9:
				if(myTree.isEmpty())
					println("Der Baum ist leer");
				else
					println("Der Baum ist nicht leer");
				break;
			case 10:
				myTree=myTree.empty();
				println("Einer leer Baum wurde erzeugt und in dem Alte zugewiesen");
				break;
			case 11:
				if(isCopyBaumPresent){
					println("Ausgabe des OrginalBaumes in Inorder:");
					myTree.printInorder();
					println("Ausgabe des CopyBaumes in Inorder:");
					myCloneTree.printInorder();
					break;
				}
				println("Ausgabe der BaumElemente in Inorder:");
				myTree.printInorder();
				break;
			case 12:
				if(isCopyBaumPresent){
					println("Ausgabe des OrginalBaumes in Preorder:");
					myTree.printPreorder();
					println("Ausgabe des CopyBaumes in Preorder:");
					myCloneTree.printPreorder();
					break;
				}
				println("Ausgabe der BaumElemente in Preorder:");
				myTree.printPreorder();
				break;
			case 13:
				if(isCopyBaumPresent){
					println("Ausgabe des OrginalBaumes in Postorder:");
					myTree.printPostorder();
					println("Ausgabe des CopyBaumes in Postorder:");
					myCloneTree.printPostorder();
					break;
				}
				println("Ausgabe der BaumElemente in Postorder:");
				myTree.printPostorder();
				break;
			case 14:
				myCloneTree=myCloneTree.empty();
				myCloneTree=myTree.tiefClone();
				println("Ein tiefClone des Baumes wurde erzeugt!");
				isCopyBaumPresent=true;
				break;
			default:
				break;
			}
			println();
		}

	}

}
