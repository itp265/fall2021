package people;
import java.time.LocalDate;
import java.time.Month;

public class StudentTA extends Student {
	
	private String course; // the course for which the Student is a TA

	public StudentTA(String name, LocalDate birthday, double gpa, String major, String course) {
		super(name, birthday, gpa, major);
		this.course = course;
	}

	public StudentTA(String name, int year, Month month, int day, double gpa, String major, String course) {
		this(name, LocalDate.of(year, month, day), gpa, major, course);
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	public StudentTA(String name, int year, int month, int day, double gpa, String major, String course) {
		this(name, LocalDate.of(year, month, day), gpa, major, course);
	}
	
	public String toString() {
		return super.toString() + " and TA for: " + course;
	}
}
