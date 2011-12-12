package blatt5v3;

public class MatrikelNummer {
	
	private int MatNr;
	
	public void setMatNr (int MatNr) {		
		this.MatNr = MatNr;		
	}
	
	public int getMatNr () {		
		return this.MatNr;		
	}

	public MatrikelNummer (int MatNr) {
		this.MatNr = MatNr;				
	}
	
	public int hashCode () {
		int qs = 0;
		int i = this.MatNr;
		
		while (i > 0) {
			qs += i % 10;
			i = i /10;
		}
		
		return qs;
	}
	
	public String toString() {
		return ""+ MatNr;
	}

}
