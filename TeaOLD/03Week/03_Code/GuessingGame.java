import java.util.*;
/**
 * Write a description of class GuessingGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GuessingGame
{
    // instance variables - replace the example below with your own
    private Scanner kamryn; //DECLARE
    private int magicNumber;
    

    /**
     * Constructor for objects of class GuessingGame
     */
    public GuessingGame()
    {
        // initialise instance variables CODING (instantation
        kamryn = new Scanner(System.in);
       // magicNumber = (int)( Math.random() * 100) + 1 ;  //1-100
        
       Random generator = new Random();
       magicNumber = generator.nextInt(100) + 1;  //ctrl-space 
       
      
    }
    
    public static void main(String[] args){
         GuessingGame object = new GuessingGame();   
         object.playGame();
    }

    public static int add(int x, int y){
     return x + y;    
    }
    public  void playGame()
    {
         System.out.println("Welcome to the guessing game.");
         int numGuesses = 1;
         int guess = -1; // variables declared in a method must get values
        do {
            System.out.println("Guess my number 1-100");
             guess = kamryn.nextInt();
             kamryn.nextLine(); // get rid of enter
             //could make higher or lower statements
            if(guess != magicNumber){
                System.out.println("Wrong ");
                if(guess < magicNumber) {
                    System.out.println("Go higher");
                }
                else {
                    
                    System.out.println("Go lower");
                }
                numGuesses ++;
            }
        }while( guess != magicNumber);
        
        System.out.println("You got the magic number in " + numGuesses + " guesses");
    }
}
