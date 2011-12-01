package uebung05;

import static gdi.MakeItSimple.*;

public class Test {

    public static void main(String args[]) {
        boolean check = true;
        boolean error;
        int val;

        List list1 = new List();
        List list2 = new List();
        List list3 = new List();
        List listPointer = null;

        //loop for choosing the current list
        do {
            error = false;
            println("choose list to work with: ");
            println("    (1) List1");
            println("    (2) List2");
            println("    (3) List3");

            val = readInt();
            readLine();
            switch (val) {
                case 1:
                    listPointer = list1;
                    break;
                case 2:
                    listPointer = list2;
                    break;
                case 3:
                    listPointer = list3;
                    break;
                default:
                    error = true;
                    break;
            }
          //  println(val + " " + error);
        } while (error == true);


        //main loop with all actions
        do {

            println();
            println("choose an action: ");
            println("    ( 1) add value to list (@ first position)");
            println("    ( 2) add value to list (@ last position)");
            println("    ( 3) clear list");
            println("    ( 4) print list");
            println("    ( 5) remove First");
            println("    ( 6) get first");
            println("    ( 7) get last");
            println("    ( 8) is empty");
            println("    ( 9) get size of list");
            println("    (10) change current list");
            println("    (11) delete element");
            println("    (12) concat list with another");
            println("    (13) clone list (flat)");
            println("    (14) clone list (deep)");
            println("    (15) END");


            switch (readInt()) {
                case 1:
                    print("enter an int value: ");
                    val = readInt();
                    listPointer.addFirst(val);
                    println("the value " + val + " has been added to list");
                    break;
                case 2:
                    print("enter an int value: ");
                    val = readInt();
                    listPointer.addLast(val);
                    println("the value " + val + " has been added to list");
                    break;
                case 3:
                    listPointer.clear();
                    println("list has been cleared!");
                    break;
                case 4:
                    print("list: ");
                    listPointer.printList();
                    break;
                case 5:
                    listPointer.removeFirst();
                    println("first element has been deleted!");
                    break;
                case 6:
                    println("first value is: " + listPointer.getFirst());
                    break;
                case 7:
                    println("last value is: " + listPointer.getFirst());
                    break;
                case 8:
                    if (listPointer.isEmpty()) {
                        println("the list is empty!");
                    } else {
                        println("the list is not empty!");
                    }
                    break;
                case 9:
                    println("the size of the list is " + listPointer.size());
                    break;
                case 10:
                    //loop for choosing the current list
                    do {
                        error = false;
                        println("choose list to work with: ");
                        println("    (1) List1");
                        println("    (2) List2");
                        println("    (3) List3");

                        switch (readInt()) {
                            case 1:
                                listPointer = list1;
                                break;
                            case 2:
                                listPointer = list2;
                                break;
                            case 3:
                                listPointer = list3;
                                break;
                            default:
                                error = true;
                                break;
                        }
                    } while (error == true);
                    break;
                case 11:
                    print("enter an int value: ");
                    val = readInt();
                    listPointer.delete(val);
                    break;
                case 12:
                    do {
                        error = false;
                        println("choose list which should be appended to current list: ");
                        println("    (1) List1");
                        println("    (2) List2");
                        println("    (3) List3");

                        switch (readInt()) {
                            case 1:
                                listPointer.concatList(list1);
                                break;
                            case 2:
                                listPointer.concatList(list2);
                                break;
                            case 3:
                                listPointer.concatList(list3);
                                break;
                            default:
                                error = true;
                                break;
                        }
                    } while (error == true);
                    break;
                case 13:
                    do {
                        error = false;
                        println("choose list which should be cloned to current list: ");
                        println("    (1) List1");
                        println("    (2) List2");
                        println("    (3) List3");

                        switch (readInt()) {
                            case 1:
                                listPointer = list1.clone();
                                break;
                            case 2:
                                listPointer = list2.clone();
                                break;
                            case 3:
                                listPointer = list3.clone();
                                break;
                            default:
                                error = true;
                                break;
                        }
                    } while (error == true);
                    break;
                case 14:
                    do {
                        error = false;
                        println("choose list which should be cloned to current list: ");
                        println("    (1) List1");
                        println("    (2) List2");
                        println("    (3) List3");

                        switch (readInt()) {
                            case 1:
                                listPointer = list1.cloneDeep();
                                break;
                            case 2:
                                listPointer = list2.cloneDeep();
                                break;
                            case 3:
                                listPointer = list3.cloneDeep();
                                break;
                            default:
                                error = true;
                                break;
                        }
                    } while (error == true);

                case 15:
                    check = false;
                default:
                    println("error! no correct number inserted!");
                    break;
            }

            println();
            print("list1: ");
            list1.printList();
            println(" - size: " + list1.size());
            print("list2: ");
            list2.printList();
            println(" - size: " + list2.size());
            print("list3: ");
            list3.printList();
            println(" - size: " + list3.size());

        } while (check == true);


        println("Programmende!");
        readLine();
    }
}
