package test;

public abstract class Vehicle {
	
	protected String name;
	protected int ps;
	protected int axle;
	
	public Vehicle(String name, int axle, int ps){
		this.name = name;
		this.ps = ps;
		this.axle = axle;
	}
	
	public String getName(){
		return this.name;
	}

	public int getPs(){
		return this.ps;
	}
	
	public int getNumberOfAxle(){
		return this.axle;
	}
}
