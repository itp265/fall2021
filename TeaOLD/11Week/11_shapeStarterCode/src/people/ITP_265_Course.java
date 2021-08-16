package people;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

import helper.BFF;

public class ITP_265_Course {

	private Faculty teacher;
	private List<Student> owlStudents;
	private ArrayList<Student> coffeeStudents;
	private ArrayList<Person> allPeople; // can hold ANY kind of person
	private BFF myHelper;
	private Student[][] group;

	public ITP_265_Course() {
		//TODO: make sure your constructor initializes all of your instance variables
		// otherwise you will get NULL POINTER EXCEPTIONS
		myHelper = new BFF();

		teacher = new Faculty("Kendra", 1977, 11, 24, "RRB219");
		owlStudents = new ArrayList<>(); // make an empty list
		coffeeStudents = new ArrayList<>(); // make an empty list
		allPeople = new ArrayList<Person>();
		allPeople.add(teacher);

		group = new Student[2][2]; //a group of students, [row][col]

		makeTAs();
	}

	public void run() {
		boolean isDone = false;
		while(!isDone){
			switch(myHelper.getCourseMenuOption()) {
			case FAKE_DATA:
				addFakeData();
				break;
			case ADD_STUDENTS:
				addStudentsViaConsole();
				break;
			case MAKE_GROUP:
				makeGroup();
				break;
			case RANDOM_GROUP:
				makeRandomGroup();
				break;
			case FIND_PERSON:
				findPerson();
				break;
			case PRINT_GELATO:
				String s = displaySection("gelato");
				myHelper.print(s);
				break;
			case PRINT_COFFEE:
				s = displaySection("coffee");
				myHelper.print(s);
				break;
			case PRINT_ALL:
				s = displayCourse();
				myHelper.print(s);
				break;
			case PRINT_GROUP:
				myHelper.print("Group as a box of people:");
				s = displayGroup();
				myHelper.print(s);
				myHelper.print("all student data:");
				for(int row = 0; row < group.length; row++) {
					for(int col = 0; col < group[row].length; col++) {
						myHelper.print("(" + row + "," + col + "): " 
								+ group[row][col] + "\n");		
					}
				}
				break; 
			case GET_PERSON_NAMED:
				Person p = getPerson();
				if(p == null ) {
					myHelper.print("No matching person found");
				}
				else {
					myHelper.print(p.toString());
				}
				break; 
			case QUIT:
				isDone = true;
				break;
			}

			if(!isDone) myHelper.inputLine("Hit return or enter to continue");
		}
	}

	private void makeRandomGroup() {
		if(owlStudents.size() + coffeeStudents.size() < 4) {
			System.err.println("Not enough people to make a random group");
		}
		else {
			// Make a new list of regular students by combining coffee and tea
			ArrayList<Student> students = new ArrayList<>(owlStudents);
			students.addAll(coffeeStudents);
			int count = 0, x = 0, y = 0;
			while(count < 4) {
				if(y >= 2) { // when y is 2, flip to next row
					y = 0;
					x++;
				}
				int num = (int)(Math.random() * students.size());
				Student s = students.remove(num);
				System.out.println("Selected s: " + s + " for " + x + "" + y);
				group[x][y] = s; 
				y++; count++; // increment count and y
			}
			System.out.println("Finished making group");
		}
		
	}

	
	// Actually GET the object, could do something else with it...
	private Person getPerson() {
		
		myHelper.print("Please enter the information for the person you are looking for");
		Person want = myHelper.inputPerson();
		int otherIndex = allPeople.indexOf(want);
		
		Person match = null;
		boolean found = false;
		int i = 0;
		while(i < allPeople.size() && !found) {
			Person p = allPeople.get(i);
			if(p.equals(want)) {
				found = true;
				match = p;
			}
			else {
				i++;
			}
		}
		
		
		return match;
	}

	//Just find the person to print it
	private void findPerson() {
		Person found = getPerson();
		if(found != null)
			myHelper.print("FOUND person"  + found);
		else
			myHelper.print("No matching person found");
	}

	private String displayGroup() {
		String s = "";
		if(this.group[0][0] == null) {
			s = "No group to display";
		}
		else {
			s += "--------------------------------";
			s += "\n" + group[0][0].getName()  + "\t" + group[0][1].getName();
			s += "\n" + group[1][0].getName()  + "\t" + group[1][1].getName();
			s += "\n--------------------------------";
		}
		return s;
	}

	private String displayCourse() {
		int num = myHelper.inputInt("Choose 1 to get a simple list of all people "
				+"\nChoose2 to get a list of students by section", 
				1, 2); // min and max values
		String course = "*************** ITP 265 Course ***************\n";

		if(num == 1) {
			for(Person p: this.allPeople) {
				course += p + "\n";
			}
		}
		else {
			course += "Teacher: " + this.teacher + "\n";
			course += displaySection("coffee");
			course += displaySection("gelato");
		}
		return course;
	}

	private String displaySection(String sectionName) {
		String section = "*************** " + sectionName.toUpperCase() + " SECTION ***************\n";
		if(sectionName.equalsIgnoreCase("gelato")) {
			//for each loop grabs each student
			for(Student s: this.owlStudents) {
				section += s + "\n";
			}
		}
		else {
			// regular for loop to also number each student
			for(int i = 0; i < coffeeStudents.size(); i++) {
				section += (i+1) + ": " + coffeeStudents.get(i) + "\n";
			}
			
			
					
		}
		return section;
	}



	private void makeGroup() {
		boolean keepGoing = true;
		if(group[0][0] != null) {
			keepGoing = myHelper.inputYesNo("Group already exists, do you want to overwrite previous group? (y/n)");
		}
		else {
			myHelper.print("A group is made of 4 people in a square block.");
		}
		if(keepGoing) {

			myHelper.print("Please input upper-left student:");
			// NOTE: you could have also done this by choosing from the list of students (either all People or a specific class section)
			group[0][0] = myHelper.inputStudent();
			myHelper.print("Please input upper-right student:");
			group[0][1] = myHelper.inputStudent();

			myHelper.print("Please input lower-left student:");
			group[1][0] = myHelper.inputStudent();

			myHelper.print("Please input lower-right student (from matching someone on allPeople list)");
			Person p = this.getPerson();
			if(p instanceof Student) {
				group[1][1] = (Student)p;
			}
			else {
				if (p == null) {
					myHelper.print("No match. Input someone new:");
				}
				else {
					myHelper.print("That was NOT a student. Input someone new:");	
				}
				group[1][1] = myHelper.inputStudent();
			}
		}

	}

	private void addFakeData() {
		// Adding fake data just saves you time running your program!
		Student x = new Student("Krish", 1999, 11, 1, 4.0, "business");
		Student y = new Student("Diego", 1989, 5, 13, 4.0, "spanish");
		addStudent(x, "cofee");
		addStudent(y, "coffee");

		addStudent(new Student("Emily", 1999, 9, 25,"IR"), "coffee");
		y = new Student("Mandy", 2000, 10, 19, "Data Science");
		addStudent(y, "coffee");
		addStudent(new Student("Shyla", 2000, 2, 12, "Econ"), "gelato");
		addStudent(new Student("Sophia", 1999, 10, 1, "IR"), "gelato");
		addStudent(new Student("Claire", 1999, 1, 14, "BUAD"), "gelato");
	}

	public ArrayList<StudentTA> makeTAs() {
		ArrayList<StudentTA> tas = new ArrayList<>();
		tas.add(new StudentTA("Cat", 1998, 12, 27, 4.0, "CS", "ITP-265"));
		tas.add(new StudentTA("Phil", 1998, 4, 18, 4.0, "ME", "ITP-265"));
		tas.add(new StudentTA("Malik", 1997, 9, 6, 4.0, "ME", "ITP-265"));
		tas.add(new StudentTA("Kamryn", 1999, 4, 3, 4.0, "Neuro", "ITP-265"));
		tas.add(new StudentTA("Walter", 1999, 11, 23, 4.0, "Accounting", "ITP-265"));
		tas.add(new StudentTA("Anup", 1997, 7, 26, 4.0, "CS", "ITP-265"));
		tas.add(new StudentTA("Adam", 1999, 12, 21, 4.0, "BUAD", "ITP-265"));
		tas.add(new StudentTA("Kamryn", 1997, 4, 3, 4.0, "Neuro", "ITP-265"));
		
		allPeople.addAll(tas);
		return tas;
	}

	public void addStudentsViaConsole() {
		boolean moreStudents = true;
		while(moreStudents) {
			Student s = myHelper.inputStudent();
			String section = myHelper.inputWord("Which section, owl or coffee?", "owl", "coffee");
			addStudent(s, section);
			moreStudents = myHelper.inputYesNo("Do you want to add another student? (y/n)");
		}
	}

	public void addStudent(Student s, String section) {
		if(section.equalsIgnoreCase("gelato")) {
			owlStudents.add(s);
		}
		else {
			coffeeStudents.add(s);
		}
		allPeople.add(s);
	}
	

	public static void main(String[] args) {
		ITP_265_Course c = new ITP_265_Course();
		
	
		List<StudentTA> tas = c.makeTAs();
		for(StudentTA s: tas) {
			System.out.println(s);
		}
		Collections.sort(tas); //works because a TA is a Person and a Person is comparable
		Comparator<Person> myComparer = new MyComparator<Person>();
		Collections.sort(tas);
		
		System.out.println("Sorted by name:");
		for(StudentTA s: tas) {
			System.out.println(s);
		}
		Person s = new Student("Claire", 1999, 1, 14, "BUAD");

		s = new StudentTA(s.getName(), s.getBday(), ((Student)s).getGpa(), "BUAD", "ITP 265");
		//if(s instanceof Student)
		Student claire = (Student)s;
		StudentTA claireTa = (StudentTA)s;
		Collections.sort(tas, myComparer);
		
		System.out.println("Sorted by age:");
		for(StudentTA t: tas) {
			System.out.println(t);
		}
		//c.run();

	}



}
