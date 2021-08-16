import java.time.*;
import java.util.*;
/**
 * Write a description of class PretendCreditCardCompany here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PretendCreditCardCompany
{
   private static long COUNTER = 100000000000l; //l at the end to make it a long
    public static final double DEFAULT_INTEREST_RATE = .15; //shared memory
    
 /**
     * Helper function for the class that returns a day 5 years in the future
     * @return
     */
    public static LocalDate generateExpiration() {
        LocalDate today = LocalDate.now(); //gives us the information at the moment the program is running
        int expYear = today.getYear() + 5;
        LocalDate exp = LocalDate.of(expYear, today.getMonth(), today.getDayOfMonth());
        return exp;
    }
       public static int generateCVV() {
           Random gen = new Random();
        int digit1 = gen.nextInt(9) + 1; // get a number 1-9
        int digit2 = gen.nextInt(10); // get a number 0-9
          int digit3 = gen.nextInt(10);
        int cvv = digit1* 100 + digit2*10 + digit3;
       
        return cvv;
    }
    
       public static double calculateLimit() {
        // for now pretending all new cards have the credit limit of 500
        return 500;
    }
      public static double getInterestRate() {
        // for now pretending all new cards have the credit limit of 500
        return DEFAULT_INTEREST_RATE ;
    }
    
    /**
     * Class level method (no object needed) will generate a unique (for this run of the program)
     * credit card number
     * @param issuer
     * @return
     */
    public static String generateCardNumber(CardIssuer issuer) {
        // cardNumber = Visa start with 4400, AMex: 3715, MasterCard = 3507
        String number = "";
        switch(issuer){
            case VISA: number += "4400"; break;
           case MASTER_CARD:
            number += "3507"; break;
            case AMEX:
            number += "3715"; break;
            case DISCOVER:
            number += "5555"; break;
        }
        
        // could make random 12 digit number to add on.
        // or a counter that would add on
        number += COUNTER; 
        COUNTER++;

        return number;
    }
}
