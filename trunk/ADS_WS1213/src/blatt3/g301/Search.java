package blatt3.g301;
import static gdi.MakeItSimple.*;
public class Search {

	static int linearSearch(int searchArray[], int searchWord){
		int position = -1, counter = 0;
		while(counter < searchArray.length){
			if(searchArray[counter] == searchWord){
				position = counter;
				counter++;
			}
			else{
				counter++;
			}
		}
		return position;
	}
	static int linearSearchFirst(int searchArray[], int searchWord){
		int position = -1, counter= 0;
		boolean found = false;
		while(counter < searchArray.length&& !found){ 
			if (searchArray[counter] == searchWord){
				position = counter;
				found = true; 
			}
			else{
				counter++;
			}
		}
		return position;
	}
	static int binarySearchIterativ(int searchArray[], int searchWord){
		boolean found = false;
		int position = -1, counter = 0;
		counter = (searchArray.length/2);
		int counter2 = counter;
		while(!found){
			if(searchArray[counter]==searchWord){
				position= counter;
				found=true;
			}
			else{
				if (searchArray[counter]>searchWord){
					while(!found){
						if (searchArray[counter-1]== searchWord){
							position = counter-1;
							found = true;
							return position;
						}
						else{
							if (counter-1==0){
								return position;
							}
							else{
								counter--;
							}
						}
					}
				}
				else{
					while(counter2+1<=searchArray.length&& !found){
						if (searchArray[counter2+1] == searchWord){
							position = counter2+1;
							found = true;
							return position;
						}
						else{
							if (counter+1 == searchArray.length){
								return position;
							}
							else{
								counter++;
							}
						}
					}
				}
			}
		}
		return position;
	}
	static int binarySearchRekursive(int searchArray[], int searchWord, int begin, int end){
		 int mid = (begin + end) / 2;
		 if (begin <= end) {
			 if (searchArray[mid]== searchWord){
				 return mid;
			 }
			 else if(searchArray[mid]< searchWord){
				 return binarySearchRekursive(searchArray,searchWord,mid+1,end);
			 }
			 else{
				 return binarySearchRekursive(searchArray,searchWord,begin,mid-1);
			 }
		 }
	return -1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int searchArray[];
		int counter = 0, searchWord;
		searchArray = new int [500];
		println("Bitte geben Sie ein Suchword ein.");
		searchWord = readInt();
		while(counter < searchArray.length){
			searchArray[counter]= counter;
			counter++;
		}
		println(linearSearch(searchArray,searchWord));
		println(linearSearchFirst(searchArray,searchWord));
		println(binarySearchIterativ(searchArray,searchWord));
		println(binarySearchRekursive(searchArray, searchWord, 0, 499));
	}
}
