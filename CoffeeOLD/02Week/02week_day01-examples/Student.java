// import the class
import java.util.*;

/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String name;
    private int age;
    private int gradYear;
    private String major;
    private char gender;
    private double height;
    private boolean inViterbi;
    private Scanner adam; // DECLARES a scanner variable named adam

    /**
     * Constructor for objects of class Student
     */
    public Student()
    {
        // initialise instance variables
       adam = new Scanner(System.in);

        System.out.println("What is the student's name?");
        name = adam.nextLine();

        System.out.println("What is " + name + " 's age?");
        while (! adam.hasNextInt()) {
            String garbage = adam.nextLine(); //get bad stuff out of stream
          System.out.println(garbage + " was Bad input. need an int for the age");   
        }
        age = adam.nextInt();
        adam.nextLine(); // get rid of the return after the number

        System.out.println("What is " + name + " 's gradYear?");
        gradYear = adam.nextInt();
        adam.nextLine(); // get rid of the return after the number

        System.out.println("What is " + name + " 's height?");
        height = adam.nextDouble();
        adam.nextLine(); // get rid of the return after the number

        System.out.println("What is " + name + " 's major?");
        major = adam.nextLine();

        System.out.println("What is " + name + " 's gender?");
        String genderString = adam.next();
        gender =  genderString.charAt(0);
        adam.nextLine(); // get rid of the return after the number

        System.out.println("Is " + name + " 's a Viterbi student? Type \"true\' or \"false\"?");
        inViterbi = adam.nextBoolean();
        adam.nextLine(); // get rid of the return after the number
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int multiplyByFive(int y)
    {
        // put your code here
        return 5 * y;
    }
    
    public int multiplyByFive(){
        System.out.println("What number do you want to multiply by 5?");
        int num = adam.nextInt();
        adam.nextLine(); // clear enter
        System.out.println(num + " * 5 = " + num*5);
        return num * 5;
    }
    

    public void takeTest(){
        System.out.println(name + " is taking a test");
    }
}
