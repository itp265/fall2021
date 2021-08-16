import java.util.*;

/**
 * Write a description of class Sample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sample
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // choice = input ("give me a number")
        System.out.println("Enter a valid number:");
        int age = sc.nextInt();
        
        boolean valid; 
        if(age == -1 || ( age > 0 && age < 11) ) {
            
            valid = true;
        }
        else {
            valid = false;
            System.out.println("Not valid");
        }    
            
        boolean valid2 = (age == -1 || ( age > 0 && age < 11) );
        System.out.println("The boolean is holding: " + valid);
    }
}
