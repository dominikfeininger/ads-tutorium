package blatt4.loesung.mergeSort;


/*
 * Created on 03.12.2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */


import static gdi.MakeItSimple.*;

class MergeSort  {
	
  static void copyFile (String filename, String filename1) {
	  
	  // copies filename --> filename1
	  
		// if cnt > 0 print only cnt elements (only for the reason of tests
	  	
		Object tape  = openInputFile (filename);  // no problems with file handling !!!
		Object tape1 = openOutputFile (filename1);  // no problems with file handling !!!
	    
		while (! isEndOfInputFile(tape))
			print (tape1, " " + readInt(tape));
		
		closeInputFile(tape);
		closeOutputFile(tape1);
		
  }
	 
  static void printFile (String filename) {
  	
    Object tape = openInputFile (filename);  // no problems with file handling !!!
    
    println();
    println(filename + ": ");
  
	while (! isEndOfInputFile(tape))
		print (readInt(tape) + " ");
	
	closeInputFile(tape);
  }

  
  static void printRunsOnFile (String filename, int rl) {
  	
	Object tape = openInputFile (filename);
	   // it is assumed that there are no problems with file handling !!!
	   
	int arl = 1;  // actual run length
	boolean eot;  // indicates if there are elements on tape
	
	eot = ! isEndOfInputFile(tape);
	
	println (filename + ":");
	
	if (!eot) { // empty tape
		println ("()");
		closeInputFile(tape);
		return;
	}
	
      
	while (eot) {
		
		if (arl == 1)  print ("(");
		
	    if (arl == rl) {
			print (readInt(tape) + ")");
			eot = ! isEndOfInputFile(tape); 
			arl = 1;}
		else {
			print (readInt(tape));
	        arl++;
			eot = ! isEndOfInputFile(tape);
			if (eot) print (" ");
			else print (")");
		}
    }
    
    println();
    
    closeInputFile(tape);
  }
  

  static void split (String filename1, String filename2, String filename3, int rl) {

  // splits tape1 into 2 auxiliary tapes with runs of length rl
  
    int arl;      // actual run length
    boolean eot;  // indicates that there are elements on tape further more
  
    Object tape1 = openInputFile (filename1);
    Object tape2 = openOutputFile (filename2);  // it is assumed that there are no
    Object tape3 = openOutputFile (filename3);  // problems with file handling !!!
    
    int n1;
      
    eot = !isEndOfInputFile(tape1);
  
    while (eot) {
    	
       arl = 1;

	   while (arl++ <= rl && eot) {      	   
      	   print (tape2, " " + readInt (tape1));
		   eot = !isEndOfInputFile(tape1);
       }
      	    	
       arl = 1;
       
	   while (arl++ <= rl && eot) {    	   
		   print (tape3, "  " + readInt (tape1));
		   eot = !isEndOfInputFile(tape1);
	   }
	   	   
    }
    
    println ("//");
    
    closeInputFile  (tape1);
    closeOutputFile (tape2);
	closeOutputFile (tape3);
  }
  
  static boolean copyTailOfRun (Object tape2, Object tape1, int ic, int rl, int i) {
  	
  // function is called only if there is at last 1 element on tape2
  // copies the tail of a run on tape2 to tape1
  
  // returns the EOF state of tape2
 
    boolean eot2;
  
    do {
	  print (tape1, " " + i);
	  eot2 = !isEndOfInputFile(tape2);
	  ic++;
	  if (ic < rl) i = readInt(tape2);
    } while (ic < rl && eot2);
  
    return eot2;
  }
  
  
  static void copyTailofTape (Object tape2, Object tape1, int i1) {
  	
  // copies the tail of tape2 to tape1
  
    boolean eot2;
    
	do {
	  print (tape1, " " + i1);
	  eot2 = !isEndOfInputFile(tape2);
	  i1 = readInt (tape2);
	}
	while (eot2);
  }
   

  static int merge (String filename1, String filename2, String filename3, int rl) { //  return the number of runs on tape filename1

  // merges file2 and file3 by runlength rl into file1
  
    int i2=0, i3=0, i2c=0, i3c=0;
    // i2/i3  = actual value read from tape2/3
    // i2c/i3c = counts the values read from actual run from tape2/3
    
    int rc = 0;  // counts the runs
    
    boolean eot2, eot3;  // indicate that there are elements on tape2/3
  
    Object tape1 = openOutputFile (filename1);
    Object tape2 = openInputFile  (filename2);  // it is assumed that there are no
    Object tape3 = openInputFile  (filename3);  // problems with file handling, i.e. files exist !!!
    
    eot2 = !isEndOfInputFile(tape2);
	eot3 = !isEndOfInputFile(tape3);
	
	if (!eot3) { // no elements on tape3 // this situation can only happen when there is exactly 1 element to be sorted
		if (eot2) // but elements on tape2
		   copyTailofTape (tape2, tape1, readInt(tape2)); // tape3 empty copy tape2 -> tape1
		   
		closeInputFile  (tape1);
		closeOutputFile (tape2);
		closeOutputFile (tape3);
   
		return rc;
	} 
  
    while (eot2 && eot3) { // both tapes contain elements
    	
      rc = rc+2; 
  	
   	  i2 = readInt(tape2); // element from tape2
  	  i3 = readInt(tape3); // element from tape3
  	  
  	  i2c = 0;  // reset
  	  i3c = 0;  // counters
  	
  	  while (i2c < rl && i3c < rl && eot2 && eot3) {  // neither 1 run finished nor end of tape reached
  	  	
  	    if (i2 < i3) {
  	       print (tape1, " " + i2);
		   eot2 = !isEndOfInputFile(tape2);  // kommt nur vor, wenn i2c == rl, also überflüssig
		   i2c++;
  	       if (eot2 && i2c < rl) // only read if !EOF (tape2) and run not finished
  	          i2 = readInt(tape2);  
  	    }
  	    else {
		   print (tape1, " " + i3);
		   eot3 = !isEndOfInputFile(tape3);
		   i3c++;
		   if (eot3 && i3c < rl) // only read if !EOF (tape3) and run not finished
			  i3 = readInt(tape3);  
   	    }
  	    
  	  }

	// both tapes contain elements - one run is complete
    if (eot3 && i2c == rl) { // run on tape2 is finished -> copy tail of run of tape3
	    eot3 = copyTailOfRun (tape3, tape1, i3c, rl, i3);  // tape3 -> tape1
	    i3c = rl;
    }
	 	
	else if (eot2 && i3c == rl) { // run on tape3 is finished -> copy tail of run of tape2
		eot2 = copyTailOfRun (tape2, tape1, i2c, rl, i2);  // tape2 -> tape1
		i2c = rl;
	}
	    
    }
  		
	if (eot2) { // more elements on tape2 -- if no. of elements != power of 2
	   if (i2c == rl) {
	   	   i2 = readInt(tape2);  // read once at end of run
	   	   rc++;
	   }
	   copyTailofTape (tape2, tape1, i2);   // copy tail of tape2 -> tape1
	}
	
    // close all files
	
	closeOutputFile  (tape1);
	closeInputFile   (tape2);
	closeInputFile   (tape3);
	
	return rc;
    
  }



  public static void main(String[] args) {

	int runlength = 1;  // length of actual run
	int rc = 3;         // no. of runs on input tape (finish if == 1)
	int cnt = 1;        // number of splits & merges
	String filename, filename1;
	String filename2, filename3;
	
	print ("file to be sorted = ");
	filename = readLine();
	
	if (isFilePresent (filename)) {
		filename1 = filename + "___1";
		filename2 = filename + "___2";
		filename3 = filename + "___3";
	}	    
	else {
		println ("file " + filename + "does not exist");
		return;  // exit program if file doesn't exist
	}
	
	copyFile (filename, filename1);  // copies filename --> filename1, source file is not changed
	
	printFile (filename1);
	
	
	while (rc > 2) {
		split (filename1, filename2, filename3, runlength);
		
		println ("Durchlauf Nr. " + cnt++);
		println ("=================");
		
		printRunsOnFile (filename2, runlength);
		printRunsOnFile (filename3, runlength);
		
		rc = merge (filename1, filename2, filename3, runlength);
		printFile (filename1);
		runlength *= 2;  
	}
  }
}
