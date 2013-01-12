package addressManagement;

public class Person {
	
	private String lastname;
	private String surname;
	private Address address;
	
	/**
	 * constuctor
	 * @param lastname
	 * @param surname
	 * @param adress
	 */
	public Person(String lastname, String surname, Address adress){
		this.address = adress;
		this.lastname = lastname;
		this.surname = surname;
	}
	
	/**
	 * constuctor
	 */
	public Person(){
		
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAdress() {
		return address;
	}

	public void setAdress(Address adress) {
		this.address = adress;
	}

}
