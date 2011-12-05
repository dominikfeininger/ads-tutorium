package muster.naturalMergeSort;


/**
 * Created on 03.12.2003
 * 
 * @author Wolfgang Schramm
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

// Hinweis: die zu sortierende Datei wird �berschrieben !!!

import static gdi.MakeItSimple.*;


// caution: If # elements on file is very big (~ 1000) and elements are written to file or console
//          without line feed there is a buffer overflow. The file couldn't neither be viewed with the Eclipse editor
//			nor couldn't it be printed on console.


class RunObject {
	boolean eot;       // indicates if there are elements on tape (eot)
	int     feonr;     // contains first element of next run, if it exists
}

class NaturalMergeSort {
	
  static void copyFile (String filename, String filename1) {
	  
		// if cnt > 0 print only cnt elements (only for the reason of tests)
	  	
		Object tape  = openInputFile (filename);  // no problems with file handling !!!
		Object tape1 = openOutputFile (filename1);  // no problems with file handling !!!
	    
		while (! isEndOfInputFile(tape))
			print (tape1, " " + readInt(tape));
		
		closeInputFile(tape);
		closeOutputFile(tape1);
		
  }
  

  static void printFile (String filename, int cnt) {
	  
	// if cnt > 0 print only cnt elements (only for the reason of tests)
  	
	Object tape = openInputFile (filename);  // no problems with file handling !!!
    
	println();
	println(filename + ": ");

	while (! isEndOfInputFile(tape) && cnt-- != 0)
		print (" " + readInt(tape));
	
	closeInputFile(tape);
  }
  
  
  static Object switchTapes (Object actualTape, Object tape2, Object tape3) {
  	
	// switches the destination tape in dependence on the actual destination tape
	// returns the new destination tape
  	
	if ( actualTape == tape2) return tape3;
	else return tape2;
  }

//////////////  printRunsOnFile  //////////////////////////////////////////////

  static void printRunsOnFile (String filename) {
	  
	  // Hinweis: Werden sehr viele Elemente ausgegeben, kommt es zu einem Pufferüberlauf:
	  //          Dabei wird nichts mahr auf der Konsole protokolliert.
	  // Quick Fix: Nach 500 Elementen gibt es einen Zeilenumbruch.
  	
	Object tape = openInputFile (filename);
	   // it is assumed that there are no problems with file handling !!!
	   

	boolean eot;  // indicates if there are elements on tape
	int v, vn;    // values read from tape1 v = last value, vn = actual value
	int epl = 0;  // counter: elements on line
		
	eot = ! isEndOfInputFile(tape);
	
	println (filename + ":");
	

      
	eot = !isEndOfInputFile(tape);
	
	if (!eot) {                   // empty tape
		closeInputFile(tape);
		return;
	}       
	
	vn = readInt(tape);    // read first value
	print ("(");
  
	do {
	   print (vn);       // print value vn to destination tape
	   
	   epl++;
       
	   eot = !isEndOfInputFile(tape);
	   if (eot) {                        // more elements on tape
		v = vn;
		vn = readInt(tape);
		if (vn < v)print (") (");
		else print (" ");
	   }
	   
	   if (epl == 500) println();  // line feed after every 500th element
      
	} while (eot);
    
	println(")");
    
	closeInputFile(tape);
  }
  
//------------  printRunsOnFile  ----------------------------------------------

  
//////////////  split  ////////////////////////////////////////////////////////
  
  static void split (String filename1, String filename2, String filename3) {

  // splits tape1 into 2 auxiliary tapes with runs of length rl
  // It is assumed that filename1 exits.
  
	boolean eot;  // indicates that there are elements on tape (eot) further more
  
	Object tape1    = openInputFile (filename1);   // source tape
	Object tape2    = openOutputFile (filename2);  // it is assumed that there are no
	Object tape3    = openOutputFile (filename3);  // problems with file handling !!!
	Object desttape = tape2;                       // actual destination tape for split
    
	int vl, va;  // values read from tape1 vl = last value, va = actual value
      
	eot = !isEndOfInputFile(tape1);
	
	if (!eot) {
		closeInputFile (tape1);
		closeOutputFile (tape2);
		closeOutputFile (tape3);
		return;       // no split if tape1 is empty
	}
	
	va = readInt(tape1);    // read first value
  
//	do {
//	   print (desttape, " " + va);       // write value va to desttape
//       
//	   eot = !isEndOfInputFile(tape1);
//	   if (eot) {                        // more elements on tape1
//		   vl = va;
//		   va = readInt(tape1);
//		   if (va < vl) desttape = switchTapes (desttape, tape2, tape3);
//		   		// switch destination tape when a smaller number follows the actual one
//	   }
//      
//	} while (eot);
	
	// Code ist etwas kompakter & besser verständlich als der auskommentierte
	
	vl = va;
	while (!isEndOfInputFile(tape1)) {
		print (desttape, " " + vl);       // write value vl to desttape
		va = readInt(tape1);    // read next value
		if (va < vl) desttape = switchTapes (desttape, tape2, tape3);  // if successor < predecessor --> new run, i.e.  switch output tape  
		vl = va;
	}
	print (desttape, " " + vl);       // write value vl to desttape
      	    	
//	println ("//");  // TEST: indicates end of split
    
	closeInputFile  (tape1);
	closeOutputFile (tape2);
	closeOutputFile (tape3);
  }
  
  //-----------------  end of SPLIT  ------------------------------------------
  
  
  /////////////////   copyTailOfRun    /////////////////////////////////////////
  
  static RunObject copyTailOfRun (Object tape2, Object tape1, int va) {
  	
  // function is called only if there is at last 1 element on tape2
  // copies the tail of a run on tape2 to tape1
  
  // returns the EOF state of tape2 and the fist element of the next run if it exists
 
	boolean eot2; // indicates that there are more elements on tape2
	boolean eor = false;  // indicates that a run is completed
	int     vl;   // last value on input tape tape2
	RunObject result = new RunObject ();
  
	do {
	  print (tape1, " " + va);
	  eot2 = !isEndOfInputFile(tape2);
	  
	  if (eot2) {
		 vl   = va;
		 eot2 = !isEndOfInputFile(tape2);
		 va   = readInt(tape2);
		 eor  = va < vl;
	  }
	} while ( !eor && eot2);
  
	result.eot  = eot2;
	result.feonr = va;
	return result;
  }

//-----------------  end of copyTailOfRun  ------------------------------------
  
  static int copyTailofTape (Object tape2, Object tape1, int v) {
  	
  // copies the tail of tape2 to tape1
  // v is the first element to be copied from tape2 to tape1
  
	boolean eot2;
	
	int vl;
	int rc = 1;  // at least one run has to be copied
 
	do {
	  print (tape1, " " + v);
	  eot2 = !isEndOfInputFile(tape2);
	  vl = v;
	  if (eot2) {   // tape contains more elements --> read next element 
		v = readInt (tape2);
	    if (vl > v) rc++;  // next run --> increment run counter
	  }
	} while (eot2);
	
	return rc;
  }
  
  static int min (int a, int b) {if (a < b) return a; else return b;}    
  static int max (int a, int b) {if (a > b) return a; else return b;}    



///////////////////     merge   ////////////////////////////////////////////////////

  static int merge (String filename1, String filename2, String filename3, int rl) {

  // merges file2 and file3 into file1
  
	int va2 =0, va3=0, vl2 = 0, vl3 = 0;
	
	// va2/3  = actual value read from tape2/3
	// vl2/3  = last value read from tape2/3
	// i2c = counts the values read from actual run from tape2
    
	int rc = 0;  // counts the runs on tape1
	
	boolean eot2, eot3;  // indicates that there are elements on tape2/3
	boolean eor2, eor3;  // indicates the end of a run on tape2/3
	
	RunObject runObj;    // gets result of copyTailOfRun call
  
	Object tape1 = openOutputFile (filename1);
	Object tape2 = openInputFile  (filename2);  // it is assumed that there are no
	Object tape3 = openInputFile  (filename3);  // problems with file handling !!!
    
	eot2 = !isEndOfInputFile(tape2);
	eot3 = !isEndOfInputFile(tape3);
	
	
	
	if (!eot3) { // no elements on tape3
		if (eot2) { // but elements on tape2
		  rc = copyTailofTape (tape2, tape1, readInt(tape2)); // tape3 empty copy tape2 -> tape1
		  closeOutputFile  (tape1);
		  closeInputFile   (tape2);
		  closeInputFile   (tape3);
		  return rc;
		}
	}
	
	eor2 = false;  // runs on both tapes
	eor3 = false;
	
	va2 = readInt(tape2); // element from tape2
	va3 = readInt(tape3); // element from tape3
 
	while (eot2 && eot3) { // both tapes contain elements
    	
	  if (rc == 0) rc++; // check if indeed a new run starts on tape1
	  else if (max (vl2, vl3) > min (va2, va3)) rc++; 
  	
	  // merge 2 runs:
  	  
	  do { // as long as there are elements on both runs
		if (va2 < va3) {
		   print (tape1, " " + va2);
		   eot2 = !isEndOfInputFile(tape2);
		   if (eot2) { // only read if !EOF (tape2)
			  vl2 = va2;
			  va2 = readInt(tape2);
			  eor2 =  va2 < vl2;
		   }
		   else eor2 = true; 
		}
		else {
		   print (tape1, " " + va3);
		   eot3 = !isEndOfInputFile(tape3);
		   if (eot3) { // only read if !EOF (tape3)  //// eot3 ????????
			  vl3 = va3;
			  va3 = readInt(tape3);
			  eor3 =  va3 < vl3;
		   }
		   else eor3 = true; 
		}
	  } while (eot2 && eot3 && !eor2 && !eor3);

	  // either run on tape2 or run on tape3 contains elements which are not processed    
	  // one run is complete
		
	  if (eot3 && eor2) { // run on tape2 is finished -> copy tail of run of tape3
		runObj = copyTailOfRun (tape3, tape1, va3);  // tape3 -> tape1
		va3  = runObj.feonr;
		eot3 = runObj.eot; 
		eor2 = false; // reset eor for next run
	  }
		 	
	  else if (eot2 && eor3) { // run on tape3 is finished -> copy tail of run of tape2
		runObj = copyTailOfRun (tape2, tape1, va2);  // tape3 -> tape1
		va2  = runObj.feonr;
		eot2 = runObj.eot;
		eor3 = false; // reset eor for next run
	  }
	  
//	  println ("Protokoll va2= " + va2 + " vl2= " + vl2 + " va3= " + va3 + " vl3= " + vl3);
	   	    
	} // end of merge 2 runs
	  
	// tape3 is at end and there are elements on tape2
  		
	if (eot2)  // tape3 is finished more elements on tape2 
	  rc += copyTailofTape (tape2, tape1, va2);   // copy tail of tape2 -> tape1
	   
	if (eot3)  // tape2 is finished more elements on tape3
	  rc += copyTailofTape (tape3, tape1, va3);   // copy tail of tape3 -> tape1
	
	
    
	closeOutputFile  (tape1);
	closeInputFile   (tape2);
	closeInputFile   (tape3);
	
	return rc;
    
  }
  
///////////////////   end of  merge   /////////////////////////////////////////////



  public static void main(String[] args) {

	int runlength = 1;  // length of actual run
	int rc = 3;         // no. of runs on input tape (finish if == 1)
	int cnt = 1;
	String filename, filename1;
	String filename2, filename3;
	
	print ("file to be sorted = ");
	filename = "/Users/feininger/Documents/workspace/AdsTutorium/blatt4/muster/txt/numbers01.txt";//readLine();
	
	if (isFilePresent(filename)) {
		filename1 = filename + "___1";
		filename2 = filename + "___2";
		filename3 = filename + "___3";
	}	    
	else {
		println ("file " + filename + "does not exist");
		return;  // exit program if file doesn't exist
		}
	
	copyFile (filename, filename1);  // copies filename --> filename1, source file is not changed
	
	printFile (filename1, -1);  // print unsorted file
	
	
	while (rc > 1) {
		split (filename1, filename2, filename3);
		
		println ("\nDurchlauf Nr. " + cnt++);
		println ("=================");
		printRunsOnFile (filename1);
		printRunsOnFile (filename2);
		printRunsOnFile (filename3);
		
		rc = merge (filename1, filename2, filename3, runlength);
	}
	
	
	println ("Sortierte Datei: ");
	println ("================");
	printRunsOnFile (filename1);
  
  }
  
}


