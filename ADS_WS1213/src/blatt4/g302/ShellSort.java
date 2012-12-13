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
public class ShellSort {
	public static void main(String[] args) {
		/*int[] array = new int [10];
		for(int i=0; i<array.length; i++){
			array[i]=(int) Math.floor(Math.random()*11);
		}*/
		int[] array = {2, 3, 0, 4, 3, 9, 3, 4, 0, 6};
		for(int i=0; i<array.length; i++){
			print(array[i]+" ");
		}
		println();
		shellSort(array);
		for(int i=0; i<array.length; i++){
			print(array[i]+" ");
		}
	}
	static void shellSort(int [] array){
		int []h={9, 7, 4, 1};
		for(int i=0; i<h.length;i++){
			int arrayIndex=0;
			while(arrayIndex<array.length){
				if(arrayIndex+h[i] < array.length && array[arrayIndex] > array[arrayIndex+h[i]]){
					int m=array[arrayIndex];
					array[arrayIndex]=array[arrayIndex+h[i]];
					array[arrayIndex+h[i]]=m;
					int arrayIndex2=arrayIndex;
					while(arrayIndex2-h[i] >= 0 && array[arrayIndex2] <                                                                                                                                           array[arrayIndex2-h[i]]){
						m=array[arrayIndex2];
						array[arrayIndex2]=array[arrayIndex2-h[i]];
						array[arrayIndex2-h[i]]=m;
						arrayIndex2-=h[i];
					}
				}
				arrayIndex++;
			}
		}
	}
}
