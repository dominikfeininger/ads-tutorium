package uebung01;

public class Motorcylce extends Vehicle{
	
	public Motorcylce(int axle, String name, int ps){
		super (name, axle, ps);
	}
	public void drive (){
		System.out.println("drive Motorcycle (" + super.name +")");
	}

}
