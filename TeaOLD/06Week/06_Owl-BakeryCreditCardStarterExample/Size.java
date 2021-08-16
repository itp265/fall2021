
/**
 * Enumeration class Size - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Size
{
    MINI(1.55, "A bite-size treat"),   // constructing ONE enum of this kind
    REGULAR(3.55, "your traditional standard cupcake"),
    JUMBO(4.77, "Double the delicousness");
    
    private double basePrice;
    private String description;
    
    private Size(double price, String description){
         //initialize the instance variable
         basePrice = price;
         
         this.description = description;
    }
    public double getBasePrice(){
         return basePrice;   
    }
    public void setBasePrice(double updatedPrice){
         basePrice = updatedPrice;   
    }
    
    public String getDescription(){
         return description;   
    }
}
