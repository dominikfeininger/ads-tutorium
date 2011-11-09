package blatt2uebung01;

public class MainRekursionMulti {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(f(1,2));
		System.out.println(f(3,4));
		System.out.println(f(7,9));
	}
	
	public static int f(int x,int y){
		if(y == 1){
			return x;
		}else{
			return x + f(x,y-1);
		}
	}
}
