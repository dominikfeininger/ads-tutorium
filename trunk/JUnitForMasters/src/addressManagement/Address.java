package addressManagement;

public class Address {
	
	private String street;
	private String zip;
	private String city;
	
	public Address(){
		
	}
	
	public Address(String street, String zip, String city){
		this.city = city;
		this.street = street;
		this.zip = zip;
	}

}
