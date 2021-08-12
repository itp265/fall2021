import java.time.*;
/**
 * Write a description of class Cupcake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cupcake
{
    // instance variables - 
    private String flavor;
    private String frosting;
    private boolean hasSprinkles;
    private boolean glutenFree;
    private boolean vegan;
    private double price;
    private Size size; // new and improved - using the Size enum
    private LocalDate dateMade;
    private String madeBy;
    private int quantity;

     
     //constant
     public static final double DEFAULT_PRICE = 4.99;

    /**
     * Full Constructor for objects of class Cupcake
     */
    public Cupcake(String flavor, String icing, double price, boolean addSprinkles,
        boolean glutenFree, boolean vegan,  Size size, String madeByPerson, int numToMake)
    {
        // initialise instance variables
        this.quantity = numToMake;
       this.flavor = flavor; //parameter and IV have SAME identifier
       this.frosting = icing; // parameter and IV can be different identifier
        this.hasSprinkles = addSprinkles; // different iedintifies, using this is optional
        this.glutenFree = glutenFree;
        this.vegan = vegan;
        this.price = price;
        this.size = size; 
        dateMade = LocalDate.now();
        madeBy = madeByPerson;
        //don't do this.....
       //String madeBy = madeByPerson; //WRONG. if we include datatype -> CREATING a variable, new containter
      
    }

    public Cupcake(String flavor, String frosting, boolean hasSprinkles, int number){
        this (flavor, frosting, DEFAULT_PRICE, hasSprinkles, false, false,  Size.REGULAR, "Baker X", number);
    }
    
    public Cupcake(String flavor, String frosting, int number){
        this (flavor, frosting, false, number);
    }
    //TODO what about if we change the prices of the cupcakes instead of throwing out too?
   public boolean decrease(int amount){
        int left =  quantity -amount;
        if(left >= 0){
           quantity = left;
           return true;
        }
        else{
         return false;   
        }
       
    }
    public void increase(int amount){
        quantity += amount;
    }
    
    /////////////////////////////////////////////////////////////////////
        //                       Accessors Methods                     //
    /////////////////////////////////////////////////////////////////////
    public String getFlavor(){
         return flavor;   
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
    public Size getSize(){
        return size;
    }
  
      /////////////////////////////////////////////////////////////////////
        //                       Mutator Methods                     //
    /////////////////////////////////////////////////////////////////////
    
    public void setPrice(double updatedPrice){
         this.price = updatedPrice;   
    }



        // to String
        public void print(){
            System.out.println("Cupcake is printing itself: " + flavor + " cupcake with " + frosting + " flavored frosting");
            
        }
        
            
    public String toString(){
        String s =  size + "🧁 " + flavor + " cupcake with " + frosting + " frosting " ;
        if(hasSprinkles){
             s+= "with sprinkles ";   
        }
        
        s += ", price : $ " + price;
       return s;
        
    }
        
       public boolean equals(Cupcake other){
           // this method gets called if(myCupcake.equals(yourCupcake) -- myCupcake is "this" a0b1 and yourCupcake is "other"
            return this.flavor.equalsIgnoreCase(other.flavor)
             && this.frosting.equalsIgnoreCase(other.frosting)
             && this.hasSprinkles == other.hasSprinkles
             && this.glutenFree == other.glutenFree
             && this.size == other.size
             && Math.abs(this.price - other.price) < .001;
             // ignoring date made for equality purposes
        }
    public static void main(String[] args){
      Cupcake c = new Cupcake("Chocolate", "Chocolate", 2);
     
      System.out.println(c);
      
    }
}
