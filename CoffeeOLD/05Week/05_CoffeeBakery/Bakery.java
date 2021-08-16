
/**
 * Write a description of class Bakery here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bakery
{
    // instance variables - replace the example below with your own
    private Cupcake josephCake;
    private Cupcake mennaCake;
    private Cupcake deeganCake;
    
    private Cupcake[] myCupcakes;
    private String name;
    private int numCupcakes;

    public static final int CAPACITY = 500;
    /**
     * Constructor for objects of class Bakery
     */
    public Bakery()
    {
        // initialise instance variables
        
        myCupcakes = new Cupcake[CAPACITY]; // spots to store 500 cucpakes
        numCupcakes = 0;
        name = "Gains";
        
      makeSpecialCakes();
    }
    
    private void makeSpecialCakes(){
         josephCake = new Cupcake("Whey Protein", "Cream Cheese", 12.99, 
                               true, false, false, Cupcake.LARGE, "Kendra");
                               
        myCupcakes[0] = josephCake;
        numCupcakes++;
        mennaCake = new Cupcake("Red Velvet", "Cream Cheese", true);
        
        deeganCake = new Cupcake("Chocolate", "Chocolate");
    }
    public void showCakes(){
         System.out.println("Cupcakes are: " + josephCake + "\n"
                     + mennaCake + "\n" + deeganCake + "\n"); // print cupcake OBJECTS
            josephCake.print(); // telling the cucpake to print itself      
            double p = josephCake.getPrice();
            mennaCake.setPrice(p);
            
    }
}
    
