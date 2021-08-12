
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
    s1 = new Student("Brianna", 22, "Neuroscience");
       s2 = new Student("Noah");
       s3 = new Student("Jenny", 19, "Applied Math");
       s4 = new Student("Sean", 22);
       
      System.out.println("Student 1 is " + s1); // s1 is a Student object
// i see a memory address
      System.out.println("Studnet 2 is " + s2);
      System.out.println("Students in the group");
      int x = 42;
      System.out.println(" x is holding " + x);   //int --> Integer
      s1.printName();
      s2.printName();
      s3.printName();
      s4.printName();
    }

    public void study(){
         s1.study();
         s2.study();
         s3.study();
         s4.study();
         System.out.println("All students in group have studied and will ace their quiz");
         s1.setGpa(4.0);
         
    }
    
}
