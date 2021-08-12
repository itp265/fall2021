package people;
import java.time.LocalDate;
import java.time.Month;

public class Faculty extends Person {
	
	private String officeLocation;

	public Faculty(String name, LocalDate birthday, String officeLocation) {
		super(name, birthday);
		this.officeLocation = officeLocation;
	}

	public Faculty(String name, int year, int month, int day, String officeLoc) {
		this(name, LocalDate.of(year, month, day), officeLoc);
		
	}

	public Faculty(String name, int year, Month month, int day, String officeLoc) {
		this(name, LocalDate.of(year, month, day), officeLoc);
		
	}


	public String toString() {
		return "Faculty " + super.toString() + ", office = " + officeLocation;
	}

	//If we want to match on Person characterisics, we can't have equals here
/*	public boolean equals(Object other) {
		boolean match = false; //assume not a match
		if ( super.equals(other)) { // compare Person attributes
			if(other instanceof Faculty) { //check if more specific type is Faculty
				Faculty f = (Faculty)other; //cast to Faculty to access those attributes
				// match is true if Person attributes AND officeLocation match
				match =  this.officeLocation.equalsIgnoreCase(f.officeLocation);
			}
		}
		return match;
	}
	*/

}
