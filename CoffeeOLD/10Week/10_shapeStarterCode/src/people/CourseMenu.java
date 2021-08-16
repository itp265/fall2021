package people;

public enum CourseMenu {
	FAKE_DATA("Add fake data (add a bunch of students automatically)"),
	ADD_STUDENTS("Add students via console"),
	MAKE_GROUP("Make study group (one can exist at a time)"),
	FIND_PERSON("Find a person (to work must have instaceof version of equals)"),
	PRINT_GELATO("Print Gelato Section"),
	PRINT_COFFEE("Print Coffee Section"),
	PRINT_ALL("Print ITP 265 Course Data"),
	PRINT_GROUP("Print Study Group"),
	RANDOM_GROUP("MAKE Random Study Group"),
	GET_PERSON_NAMED("Get the Person named..."),
	QUIT("Quit menu");
	
	private String displayString;
	private CourseMenu(String display){
		this.displayString = display;
	}
	
	public String getDisplayString(){
		return this.displayString;
	}
	
	
}
