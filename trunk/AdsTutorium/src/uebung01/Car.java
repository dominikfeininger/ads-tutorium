package uebung01;

public class Car extends Vehicle{
	
	public Car(int axle, String name, int ps){
		super (name, axle, ps);
	}
	
	public void drive (){
		System.out.println("drive Car (" + super.name + ")");
	}

}
