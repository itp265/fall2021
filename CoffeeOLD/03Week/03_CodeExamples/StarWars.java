import java.util.Scanner;

/**
 * Write a description of class StarWars here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StarWars
{
    // instance variables - replace the example below with your own
    private Scanner adam; // DECLARE 

    /**
     * Constructor for objects of class StarWars
     */
    public StarWars()
    {
        // initialise instance variables
        adam = new Scanner(System.in);
    }

    public void playGame(){
        boolean done = false;
        while(!done){ // while (done == false)
            String firstName = input("What is your first name");
            String lastName = input("What is your last name");
            String maiden = input("What is your mother's maiden name");
            String city = input("What is your city of birth?");

            String newFirstName = lastName.substring(0, 3) + firstName.toLowerCase().substring(0,2);
            String newLastName = maiden.substring(0, 2) + city.toLowerCase().substring(0,3);

            System.out.println("Your star wars name is: " + newFirstName + " " + newLastName);

            String altFirstName = firstName.substring(0, 3) + lastName.toLowerCase().substring(0,2);
            System.out.println("Or with an alternate formula,your star wars name is: " + altFirstName + " " + newLastName);
            String goAgain = input("Do you want to enter another name?");
            if(goAgain.equalsIgnoreCase("yes") || goAgain.equalsIgnoreCase("y")){
                done = false;
            }
            else {
                done = true;
            }

        }
    }

    private String input(String prompt){
        System.out.print(prompt +  " >");
        String s = adam.nextLine();
        
        
        return s;
    }
}
