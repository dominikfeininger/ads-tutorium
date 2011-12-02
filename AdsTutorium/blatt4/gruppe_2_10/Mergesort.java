package gruppe_2_10;

import static gdi.MakeItSimple.*;

public class Mergesort {
	public static 	Object log=openOutputFile("log.txt");
	public static int run=1;
	
	/**printruns:
	 * 
	 * open chosen file, compares 2 numbers and save them as run.
	 * 
	 * @param chosen
	 */
	static void printruns(String chosen){ 
		Object file=openInputFile(chosen);
		int counter=1;
		int length;

		length=readInt(file);
		String runs="";
		int number1H1=readInt(file);
		int number2H1;
		runs=runs+" "+number1H1;
		number2H1=readInt(file);
		
		while(counter<length){//repeat the compares

			while (number2H1>=number1H1&&counter<length){// compares till the following number smaller than the number before 
				counter++;
				runs=runs+" "+number2H1;
				number1H1=number2H1;
				if (counter==length){
				}else number2H1=readInt(file);
			}
			println( log, "run:"+run+"  ("+runs+" )" );
			run++;
			runs="";
			number1H1=number2H1;
		}
		closeInputFile(file);
	}
	
	/**split:
	 * 
	 * open chosen file, compares 2 numbers and split them in 2 files.
	 * 
	 * @param chosen
	 */
	static void split(String chosen){
		
		Object file = openInputFile(chosen);
		
		int length= readInt(file);
		int number2;
		int number1;
		String one;
		String two="";
		int counter= 1;
		boolean saveInOne=true;
		int numbersInOne=1;
		int numbersInTwo=0;

		number1=readInt(file);
		one=" "+number1;
		while(counter<length){ // check if the following number is smaller than the number before, and save them in a String

				number2=readInt(file);
		
			if (saveInOne==true){
				if(counter>length){
				}else{
					if(number2>=number1){//save in first String
						one=one+" "+number2;
						number1=number2;
						counter++;
						numbersInOne++;
					}else{//if the number if smaller save the number in the second String 
						two=two+" "+number2;
						number1=number2;
						counter++;
						saveInOne=false;//prevents that the following numbers saved in first String
						numbersInTwo++;
					}
				}
			}else if (saveInOne==false){
				if(counter>length){
				}else{
					if(number2>=number1){//save in second String
						two=two+" "+number2;
						number1=number2;
						counter++;
						numbersInTwo++;
					}else{//if the number if smaller save the number in the first String 
						one=one+" "+number2;
						number1=number2;
						counter++;
						saveInOne=true;//prevents that the following numbers saved in second String
						numbersInOne++;
					}
				}	
			}
		}	
		if (numbersInTwo==0){//terminates the program, if the second String is empty
			println("done!");
			closeOutputFile(log);
			System.exit(0);	
		}
		
		Object helper1=openOutputFile("helper1.txt");
		Object helper2=openOutputFile("helper2.txt");
		println( helper1, numbersInOne+one );
		println( helper2, numbersInTwo+two );
		closeOutputFile(helper1);
		closeOutputFile(helper2);	
		closeInputFile(file);
	}
	
	
	/**merge:
	 * 
	 * open files helper1 and helper2, check the lowest number from run1 helper1 and run1 helper2
	 * save them in a String
	 * repeat it till every run is processed
	 * @param chosen
	 */
	static void merge(String chosen){
		int lengthHelper1;
		int lengthHelper2;
		Object file = openOutputFile(chosen);
		Object helper1 = openInputFile("helper1.txt");
		Object helper2 = openInputFile("helper2.txt");

		lengthHelper1=readInt(helper1);
		lengthHelper2=readInt(helper2);
		
		int length= (lengthHelper1+lengthHelper2);
		int number2;
		int number1;
		int number1Helper2;
		int number2Helper2;
		boolean run2end=false;
		boolean run1end=false;
		
		String merge="";
		int counter= 1;
		
		number1=readInt(helper1);
		number2=number1;
		number1Helper2=readInt(helper2);
		number2Helper2=number1Helper2;
		while(counter<=length){//merge
			if (lengthHelper1==0){///if helper1 is empty save the remaining numbers from helper2  
				while(lengthHelper2!=0){
					merge=merge+" "+number2Helper2;
					lengthHelper2--;
					counter++;
					if (lengthHelper2!=0){
						number1Helper2=number2Helper2;
						number2Helper2=readInt(helper2);
					}
				}
			}
			if (lengthHelper2==0){///if helper2 is empty save the remaining numbers from helper1  
				while(lengthHelper1!=0){
					merge=merge+" "+number2;
					lengthHelper1--;
					counter++;
					
					if (lengthHelper1!=0){
						number1=number2;
						number2=readInt(helper1);
					}
				}
			}
			if (run2end==true){//if run 2 ends save the remaining numbers from run 1
				while(number2>=number1&&counter<length){
					merge=merge+" "+number2;
					lengthHelper1--;
					counter++;
					if (lengthHelper1!=0){
						number1=number2;
						if (counter==length||lengthHelper1<0){
							
						}else number2=readInt(helper1);
					}
				}
				run2end=false;//after that, the numbers form helper2 can be read again
				number1=number2;
			}
			if (run1end==true){//if run 1 ends save the remaining numbers from run 2
				while(number2Helper2>=number1Helper2&&counter<length){
					merge=merge+" "+number2Helper2;
					lengthHelper2--;
					counter++;
					
					if (lengthHelper2!=0){
						number1Helper2=number2Helper2;
						if (counter==length||lengthHelper2<0){
							
						}else number2Helper2=readInt(helper2);
						
						
					}
				}
				run1end=false;//after that, the numbers form helper2 can be read again
				number1Helper2=number2Helper2;
			}
			if (run1end==true){	
			}else{
				if (lengthHelper1>0){
					if (number2<=number2Helper2&&number2>=number1){//check the lowest number form helper1 and save them in the chosen file
						merge=merge+" "+number2;
						lengthHelper1--;
						counter++;
							
						if (lengthHelper1!=0){//stops read from helper1, if helper1 is completely checked
							number1=number2;
							number2=readInt(helper1);
						}
						if (number2<number1){//run end
							run1end=true;//prevents that the following numbers from helper1 saved in String
							number1=number2;
						}
					}
				}
			}
			if (run2end==true){	
			}else{
				if (lengthHelper2>0){
					if(number2Helper2<=number2&&number2Helper2>=number1Helper2){//check the lowest number form helper2 and save them in the chosen file
						merge=merge+" "+number2Helper2;
						lengthHelper2--;
						counter++;
						
						if (lengthHelper2!=0){//stops read from helper2, if helper1 is completely checked
							number1Helper2=number2Helper2;
							number2Helper2=readInt(helper2);
						}
						if (number2Helper2<number1Helper2){//run end
							run2end=true;//prevents that the following numbers from helper2 saved in String
							number1Helper2=number2Helper2;
						}							
					}
				}
			}
		}

		println( file,length+""+merge );	
		closeInputFile(helper1);
		closeInputFile(helper2);
		closeOutputFile(file);
	}	
	
	/**main:
	 * 
	 * demands a number to choose a file
	 * check whether file is present and readable and sort it with the mergesort
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean done=false;
		println("Choose a File.");
		println("Type \"1\" for: numbers01");
		println("Type \"2\" for: numbers02");
		println("Type \"3\" for: numbers03");
		println("Type \"4\" for: numbers04");
		println("Type \"5\" for: numbers05");
		
		int choose= readInt();
		readLine();
		String chosen="";
		if (choose==1) chosen="numbers01.txt";
		if (choose==2) chosen="numbers02.txt";
		if (choose==3) chosen="numbers03.txt";
		if (choose==4) chosen="numbers04.txt";
		if (choose==5) chosen="numbers05.txt";
		if ( isFilePresent(chosen)!=true||isFileReadable(chosen)!=true||isFileWritable(chosen)!=true) {//is file present?
			if ( isFilePresent( chosen)!=true) println("File isn't existent!");
			if ( isFileReadable( chosen)!=true) println("File isn't readable!");
			if (isFileWritable(chosen)!=true) println("File isn't writable!");
		}else{
			while (done==false){
				printruns(chosen);
				split(chosen);
				merge(chosen);
			}
		}
	}
	
}
