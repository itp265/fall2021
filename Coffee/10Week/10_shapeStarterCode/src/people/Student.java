package people;
import java.time.LocalDate;
import java.time.Month;

import shapes.Drawable;

public class Student extends Person implements Drawable{
	private double gpa;
	private String major;
	private final int ID_NUM;
	
	private static int counter = 100; // STATIC means one copy exists in memory
	// CLASS level variable, part of our template, "factory"
	// objects themselves don't "have" this data (Not an instance variable)
	// one memory location contains this data that all Students have access to
	// Bulletin Board in Student that all students could see...
	
	
	
	public Student(String name, LocalDate birthday, double gpa, String major) {
		super(name, birthday);
		this.gpa = gpa;
		this.major = major;
		ID_NUM = counter;
		Student.counter++; //change the shared piece of memory
	
	}
	public Student(String name, int year, Month month, int day, double gpa, String major) {
		this(name, LocalDate.of(year, month, day), gpa, major);
	
	}
	public Student(String name, int year, int month, int day, double gpa, String major) {
		this(name, LocalDate.of(year, month, day), gpa, major);
		
	}
	public Student(String name, int year, int month, int day, String major) {
		this(name, LocalDate.of(year, month, day), 4.0, major);
		
	}

	@Override
	public String toString() {
		return "Student " + super.toString() + ", major=" + major + ", ID_NUM=" + ID_NUM;
	}
	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}
	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the iD_NUM
	 */
	public int getID_NUM() {
		return ID_NUM;
	}
	
	public static void main(String[] args) {
		Student x = new Student("Sarah", 1999, Month.NOVEMBER, 1, 4.0, "applied math");
		System.out.println(x);
	}
	@Override
	public void drawInAcsii() {
		System.out.println("o-|-<");
		
	}
	@Override
	public void draw() {
		System.out.println("🧑‍🎓");
		
	}
	
}
