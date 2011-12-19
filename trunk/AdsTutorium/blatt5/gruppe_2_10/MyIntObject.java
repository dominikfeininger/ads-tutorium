package gruppe_2_10;

public class MyIntObject {
	
	private int value;   

	public MyIntObject() {
	}

	public MyIntObject(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

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
		MyIntObject other = (MyIntObject) obj;
		return other.value == value;
	
	}

	public String toString() {
		return "MyObject [value= " + value + "]";
	}


}
