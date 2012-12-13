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
public class quicksort {

	public static void main(String[] args) {
		int[] array = {16,4,55,1};
		int u=0;
		int o=array.length-1;
		quicksort3(array, u, o);
	}	
	
public static void quicksort3(int[] array, int u, int o)	{
int i;
if (o>u)	{
	for(int j=0; j<array.length;j++){
			print(array[j]+" ");
		}
		println();
	i=zerlege(array,u,o);
	for(int j=0; j<array.length;j++){
		print(array[j]+" ");
	}
	println();
	quicksort3(array,u,i-1);
	for(int j=0; j<array.length;j++){
		print(array[j]+" ");
	} 
	println();
	quicksort3(array,i+1,o);
	for(int j=0; j<array.length;j++){
		print(array[j]+" ");
	}
	println();
	}
}

public static int zerlege(int[]array, int u, int o){
	int p=o;
	int index=u;
	for(int zeiger=index; zeiger<o; zeiger++)	{
		if (array[zeiger]<=array[p])	{
			int speicher=array[index];
			array[index] = array[zeiger];
			array[zeiger] = speicher;
			index++;
			}
		}
	int speicher=array[index];
	array[index] = array[p];
	array[p] = speicher;
	return index;
	}

}
