import java.util.*;

/**
 * Write a description of class GuessingGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GuessingGame
{
    // instance variables - setting the containers
    private Scanner adam; // DECLARE 
    private int magicNumber; 

    /**
     * Constructor for objects of class GuessingGame
     */
    public GuessingGame()
    {
        // initialise instance variables
        adam = new Scanner(System.in);
        Random anup = new Random(); // makes a random number generator
        // the SEED gives me random numbers in a predictable order
        magicNumber = anup.nextInt(100) + 1; // 1-100

        //magicNumber = (int)(Math.random() * 100)  + 1;

    }

    public void playGame(){
        System.out.println("Welcome to my guessing game program!");
        int guess = -1;
        int numGuesses = 1;
        do{
            System.out.println("Guess the number 1-100: ");
            guess = adam.nextInt();
            adam.nextLine(); // get rid of the enter

            if(guess == magicNumber){ //==: int char boolean
                System.out.println("Awesome. you guess correctly, the random number was " + magicNumber); 
            }
            else {
                System.out.println("sorry. you guessed wrong");
                numGuesses ++;
                if(guess < magicNumber) System.out.println("Go higher");
                else  System.out.println("Go lower");
                
                // auto-complete is control-space
            }

        } while(guess != magicNumber);
        
        System.out.println("You got the correct number in " + numGuesses + " guesses");
        
        // do you want to play again? new random blah blah
    }
}
