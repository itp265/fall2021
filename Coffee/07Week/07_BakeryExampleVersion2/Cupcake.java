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
    private Cake flavor;
    private Frosting frosting;
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
    public Cupcake(Cake flavor, Frosting icing, boolean addSprinkles,
        boolean glutenFree, boolean vegan,  Size size, String madeByPerson, int numToMake)
    {
        // initialise instance variables
        this.quantity = numToMake;
       this.flavor = flavor; //parameter and IV have SAME identifier
       this.frosting = icing; // parameter and IV can be different identifier
        this.hasSprinkles = addSprinkles; // different iedintifies, using this is optional
        this.glutenFree = glutenFree;
        this.vegan = vegan;
        this.size = size; 
        this.price = size.getBasePrice();
        dateMade = LocalDate.now();
        madeBy = madeByPerson;
        //don't do this.....
       //String madeBy = madeByPerson; //WRONG. if we include datatype -> CREATING a variable, new containter
      
    }
 public Cupcake(Cake flavor, Frosting frosting, boolean hasSprinkles, Size s, String baker, int number){
        this (flavor, frosting,  hasSprinkles, false, false,  s, baker, number);
    }
    public Cupcake(Cake flavor, Frosting frosting, boolean hasSprinkles, int number){
        this (flavor, frosting,  hasSprinkles, false, false,  Size.REGULAR, "Baker X", number);
    }
    
    public Cupcake(Cake flavor, Frosting frosting, int number){
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
    public Cake getFlavor(){
         return flavor;   
    }
     public Frosting getFrosting(){
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
        String s =  this.quantity + " " + size + " 🧁 " + flavor + " cupcake with " + frosting + " frosting " ;
        if(hasSprinkles){
             s+= "with sprinkles ";   
        }
        
        s += ", price : $ " + price;
       return s;
        
    }
        
       public boolean equals(Cupcake other){
           // this method gets called if(myCupcake.equals(yourCupcake) -- myCupcake is "this" a0b1 and yourCupcake is "other"
            return this.flavor == other.flavor
             && this.frosting == other.frosting
             && this.hasSprinkles == other.hasSprinkles
             && this.glutenFree == other.glutenFree
             && this.size == other.size
             && Math.abs(this.price - other.price) < .001;
             // ignoring date made for equality purposes
        }
    public static void main(String[] args){
      Cupcake c = new Cupcake(Cake.BELGIAN_DARK_CHOCOLATE, Frosting.CREAM_CHEESE, 2);
     
      System.out.println(c);
      
    }
}
