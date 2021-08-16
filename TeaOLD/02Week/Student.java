// step 1: import the package
import java.util.*;

/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    // instance variables - stuff object "KNOWs" or stores
    // keep your variables PRIVATE == good encapsulation
    private String name;
    private int age;
    private double gpa;
    private double mileTime;
    private String major;
    private Scanner kamryn ; // DECLARES that i will have a scanner names kamryn (null to start)

    /**
     * Constructor for objects of class Student
     */
    public Student()
    {
        // initialise instance variables
        kamryn = new Scanner(System.in);
        System.out.println("What is the student's name?");
        name = kamryn.nextLine();
        
        System.out.println("What is " + name + " 's age?");
        while ( !kamryn.hasNextInt()){ // hasNext does a PEEK
          //BAD   
          String garbage = kamryn.nextLine(); // to get rid of the token data that is wrong
          System.out.println("That " + garbage+ " wasn't an int! Please enter a whole number for age!");
        }
        // now there is an int...
            age = kamryn.nextInt();
            kamryn.nextLine(); // get rid of the enter
        
        
        System.out.println("What is " + name + " 's gpa?");
        gpa = kamryn.nextDouble();
        kamryn.nextLine();
        
         System.out.println("What is " + name + " 's miletime?");
        mileTime = kamryn.nextDouble();
        kamryn.nextLine();
        
        System.out.println("What is " + name + " 's major?");
        major = kamryn.nextLine();
        
        System.out.println("What is " + name + " 's favorite hobby?");
        String hobby  = kamryn.nextLine();
        
        System.out.println("We just completed getting input about " + name + " who likes " + hobby);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int multiplyBy5(int y)
    {
        // put your code here
        return 5 * y;
    }
    
    
     public int multiplyBy5()
    {
        System.out.println("What number (int)  would you like to multiply?");
        int num = kamryn.nextInt();
        kamryn.nextLine(); // get rid of enter
        // put your code here
        return 5 * num;
    }
}
