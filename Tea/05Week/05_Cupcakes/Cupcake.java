import java.time.*;
/**
 * Write a description of class Cupcake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cupcake
{
    // instance variables - replace the example below with your own
    private String flavor;
    private String icing;
    private boolean hasSprinkles;
    private boolean glutenFree;
    private double price;
    private int size; // MINI or REGULAR or JUMBO
    private LocalDate dateMade;
    
    // enumeration (preview) - MAGIC NUMBERS
    public static final int MINI = 0;
    public static final int REGULAR = 1;
     public static final int JUMBO = 2;

    /**
     * Full Constructor for objects of class Cupcake
     */
    public Cupcake(String flavor, String frosting, boolean addSprinkles,
        boolean glutenFree, double price, int size)
    {
        // initialise instance variables
       this.flavor = flavor; //parameter and IV have SAME identifier
       icing = frosting; // parameter and IV can be different identifier
        this.hasSprinkles = addSprinkles; // different iedintifies, using this is optional
        this.glutenFree = glutenFree;
        this.price = price;
        this.size = size;
        dateMade = LocalDate.now();
    }

    public Cupcake(String flavor, String frosting){
        this (flavor, frosting, false, false, 3.99, REGULAR);
    }
    
    public Cupcake(String flavor, String frosting, boolean sprinkles){
        this (flavor, frosting, sprinkles, false, 3.99, REGULAR);
    }
    
    // Accessors for everything
    public String getFlavor(){
         return flavor;   
    }
     public String getIcing(){
         return icing;   
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double updatedPrice){
         this.price = updatedPrice;   
    }
    
    public int getSize(){
        return size;
    }

    
      public String getSizeWord(){
          String word = "";
       if(size == MINI){
           word = "mini";
        }
        else if(size == REGULAR){
         word = "regular";   
        }
        else if(size == JUMBO){
             word = "jumbo";   
        }
        else{
             word = "unknown cupcake size " + size;   
        }
        return word;
    }
    public LocalDate getDateMade(){
        return this.dateMade;
    }
        // to String
        public void print(){
            System.out.println(flavor + " cupcake with " + icing + " flavored frosting");
            
        }
        
       public boolean equals(Cupcake other){
           // this method gets called if(myCupcake.equals(yourCupcake) -- myCupcake is "this" a0b1 and yourCupcake is "other"
            return this.flavor.equalsIgnoreCase(other.flavor)
             && this.icing.equalsIgnoreCase(other.icing)
             && this.hasSprinkles == other.hasSprinkles
             && this.glutenFree == other.glutenFree
             && this.size == other.size
             && Math.abs(this.price - other.price) < .001;
             // ignoring date made for equality purposes
        }

}
