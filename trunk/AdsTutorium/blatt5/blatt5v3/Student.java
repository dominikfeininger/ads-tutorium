package blatt5v3;

public class Student {
	
	private MatrikelNummer MatNr;
	private String Prename;
	private String Name;
	private String Birthday;
	
	public Student (int MatNr, String Prename, String Name, String Birthday) {
		this.MatNr = new MatrikelNummer(MatNr);
		this.Prename = Prename;
		this.Name = Name;
		this.Birthday = Birthday;
	}
	
	public Student () {
		this.MatNr = null;
		this.Prename = null;
		this.Name = null;
		this.Birthday = null;		
	}
	
	public void setMatNr (int MatNr) {		
		this.MatNr.setMatNr(MatNr);		
	}
	
	public MatrikelNummer getMatNr () {		
		return this.MatNr;		
	}

	
	public void setName (String Prename, String Name) {		
		this.Prename = Prename;
		this.Name = Name;
	}
	
	public void setBirthday (String Birthday) {		
		this.Birthday = Birthday;
	}	

	public String toString() {
		return ""+ MatNr.getMatNr() + ", " + Name + ", " + Birthday;
	}

}
