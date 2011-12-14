package bTree;

public class Student {

	private String MatNr;
	private String Prename;
	private String Name;
	private String Birthday;

	/**
	 * constuctor
	 * 
	 * @param MatNr
	 * @param Prename
	 * @param Name
	 * @param Birthday
	 */
	public Student(String MatNr, String Prename, String Name, String Birthday) {
		this.MatNr = MatNr;
		this.Prename = Prename;
		this.Name = Name;
		this.Birthday = Birthday;
	}
	
	/**
	 * constuctor
	 * 
	 * all params initialized with mull
	 */
	public Student() {
		this.MatNr = null;
		this.Prename = null;
		this.Name = null;
		this.Birthday = null;
	}

	public String toString() {
		return "" + MatNr + ", " + Name + ", " + Birthday;
	}

	//getter and setter
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getPreame() {
		return Name;
	}

	public void setPrename(String Preame) {
		this.Prename = Prename;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String Birthday) {
		this.Birthday = Birthday;
	}

	public void setMatNr(String MatNr) {
		this.MatNr = MatNr;
	}

	public String getMatNr() {
		return this.MatNr;
	}
}
