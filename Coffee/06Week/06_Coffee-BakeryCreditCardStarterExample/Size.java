
/**
 * Enumeration class Size - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Size
{
    MINI(1.99, "bite-size treat"),
    REGULAR(3.99, "a delicious normal sized cupcake"),
    JUMBO(4.99, "an oversized treat");
    
    private double basePrice;
    private String description;
    
    private Size(double p, String description){
        //initialize instance variables
        basePrice = p;
        this.description= description;
    }
    
    public double getBasePrice(){
         return basePrice;   
    }
    
    public String toString(){
        // super.toString() will get the name of the enum for us.
         return super.toString() + ", basePrice = $" + basePrice + " description = " + description; 
    }
}
