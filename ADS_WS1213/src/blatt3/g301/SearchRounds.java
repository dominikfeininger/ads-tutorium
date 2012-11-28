package blatt3.g301;

import static gdi.MakeItSimple.*;


public class SearchRounds {
	static int linearSearch(int searchArray[], int searchWord){
		int counter = 0, vergleich = 0;
		while(counter < searchArray.length){
			if(searchArray[counter] == searchWord){
				vergleich++;
				counter++;
			}
			else{
				vergleich++;
				counter++;
			}
		}
		return vergleich;
	}
	static int linearSearchFirst(int searchArray[], int searchWord){
		int counter= 0, vergleich = 0;
		boolean found = false;
		while(counter < searchArray.length&& !found){ 
			if (searchArray[counter] == searchWord){
				vergleich++;
				found = true; 
			}
			else{
				vergleich++;
				counter++;
			}
		}
		return vergleich;
	}
	static int binarySearchIterativ(int searchArray[], int searchWord){
		boolean found = false;
		int counter = 0, vergleich=0;
		counter = (searchArray.length/2);
		int counter2 = counter;
		while(!found){
			if(searchArray[counter]==searchWord){
				found=true;
				vergleich++;
			}
			else{
				if (searchArray[counter]>searchWord){
					while(!found){
						if (searchArray[counter-1]== searchWord){
							vergleich++;
							found = true;
							return vergleich;
						}
						else{
							if (counter-1==0){
								vergleich++;
								return vergleich;
							}
							else{
								vergleich++;
								counter--;
							}
						}
					}
				}
				else{
					while(counter2+1<=searchArray.length&& !found){
						if (searchArray[counter2+1] == searchWord){
							found = true;
							vergleich++;
							return vergleich;
						}
						else{
							if (counter+1 == searchArray.length){
								vergleich++;
								return vergleich;
							}
							else{
								vergleich++;
								counter++;
							}
						}
					}
				}
			}
		}
		return vergleich;
	}	
	static int binarySearchRekursive(int searchArray[], int searchWord, int begin, int end){
		 int mid = (begin + end) / 2;
		 if (begin <= end) {
			 if (searchArray[mid]== searchWord){
				 comparisonBinaryRekursive++;
				 return comparisonBinaryRekursive;
			 }
			 else if(searchArray[mid]< searchWord){
				 comparisonBinaryRekursive++;
				 return binarySearchRekursive(searchArray,searchWord,mid+1,end);
			 }
			 else{
				 comparisonBinaryRekursive++;
				 return binarySearchRekursive(searchArray,searchWord,begin,mid-1);
			 }
		 }
	return -1;
	}
public static int comparisonBinaryRekursive=0;
	public static void main(String[] args) {
		int searchArray[];
		int counter = 0, searchWord, searchArraylength;
		println("Please enter the array length.");
		searchArraylength = readInt();
		readLine();
		searchArray = new int [searchArraylength];
		println("Please enter the search word.");
		searchWord= readInt();
		while(counter < searchArray.length){
			searchArray[counter]= counter;
			counter++;
		}
		println(linearSearch(searchArray,searchWord));
		println(linearSearchFirst(searchArray,searchWord));
		println(binarySearchIterativ(searchArray,searchWord));
		println(binarySearchRekursive(searchArray,searchWord,0,searchArray.length));
	}
}
