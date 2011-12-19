package gruppe_2_6;

public class MyObject {
	
	private int value;   // 

	/**
	 * Konstruktor
	 */
	public MyObject() {
	}

	/**Konstruktor with parameter value
	 * @param value
	 */
	public MyObject(int value) {
		this.value = value;
	}

	/** Returns the value of the Object
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	/**Set the value of this object
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyObject other = (MyObject) obj;
		return other.value == value;
	}

	public String toString() {
		return "MyObject [value= " + value + "]";
	}


}
