
/**
 * Write a description of class StudyGroup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudyGroup
{
    // instance variables - replace the example below with your own
    private Student s1;
    private Student s2;
    private Student s3;
    private Student s4;

    /**
     * Constructor for objects of class StudyGroup
     */
    public StudyGroup()
    {
        // initialise instance variables
       s1 = new Student("Ash", 19, "Mechanical Engineering");
        s2 = new Student("Austen", 20, "IMGD");
         s3 = new Student("Ashleigh", 20, "IRGB");
         // s4 = new Student("Abigail", 20, "IMGD");
          s4 = new Student("Abigail", 20 );
          System.out.println("Student 1 is " + s1); // atuomatically calls toString method
    }

    public void printNamesOfMembers(){
     System.out.println("Study Group contains: " + s1.getName()   + " and " + s2.getName());
     s3.printName();
     String s4Name = s4.getName();
     System.out.println(s4Name + " starts with the letter " + s4Name.charAt(0));
   
    }
}
