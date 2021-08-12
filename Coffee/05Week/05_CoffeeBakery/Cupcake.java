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
    private String frosting;
    private double price;
    private boolean hasSprinkles;
    private int size;
    private boolean glutenFree;
    private boolean vegan;
    private LocalDate dateMade;
    private String madeBy;

    //constant variables to represent the size options
    // we call this enumerating the possibilities
    public static final int SMALL = 0;
    public static final int MEDIUM = 1;
    public static final int LARGE = 2;
    ;
    public static final double DEFAULT_PRICE = 4.99;
    /**
     * FULL Constructor for objects of class Cupcake
     */
    public Cupcake(String flavor, String frosting, double price, 
                boolean withSprinkles, boolean gluten, boolean vegan,
                int size, String madeByPerson)
    {
        // initialise instance variables with values passed into the constructor
       this.flavor = flavor; // if IV & param have same name, MUST distinguist
       this.frosting = frosting;
       this.price = price;
       this.hasSprinkles = withSprinkles; //different names, can use this
       glutenFree = gluten; //different names can skip this
       this.vegan = vegan;
       setSize(size);
       //don't do this.....
       //String madeBy = madeByPerson; //WRONG. if we include datatype -> CREATING a variable, new containter
       madeBy = madeByPerson;
       dateMade = LocalDate.now();
    }

   public Cupcake(String flavor, String frosting, boolean hasSprinkles){
        this (flavor,  frosting, DEFAULT_PRICE,hasSprinkles, false, false,
        MEDIUM, "Baker X");
    }
    
     public Cupcake(String flavor, String frosting){
        this (flavor,  frosting, false);
    }
    
    
    //Accessors
    public String getFlavor(){
        return this.flavor; //this is optional
    }
    public String getFrosting(){
        return frosting;
    }
    public double getPrice(){
         return price;   
    }
    public boolean hasSprinkles(){
         return hasSprinkles;   
    }
    public boolean isGlutenFree(){
         return glutenFree;   
    }
    public boolean isVegan(){
         return vegan;   
    }
    public LocalDate getDateMade(){
         return dateMade;   
    }
    
    //mutator for price only
    public void setPrice(double newCost){
         this.price = newCost; // this optional since identifiers are different   
    }
    private void setSize(int size){
        if(size == SMALL || size == MEDIUM || size == LARGE){
            
             this.size = size;   
            }
            else{
             this.size = MEDIUM;   
            }
    }
    
    public void print(){
     System.out.println("This is a cupcake with " + flavor + " cake " + " and " 
                 + frosting  + " frosting");
    }
    
    public String toString(){
        String s =  flavor + " cupcake with " + frosting + " frosting " ;
        if(hasSprinkles){
             s+= "with sprinkles ";   
        }
        
        s += ", price : $ " + price;
        return s;
        
    }
}
