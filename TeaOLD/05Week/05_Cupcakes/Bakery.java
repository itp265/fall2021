
/**
 * Write a description of class Bakery here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bakery
{
    // instance variables - replace the example below with your own
         Cupcake sC ; // special named cupcakes
        Cupcake nc;
        Cupcake gC ;
        
    private Cupcake[] myCupcakes;
    private String name;
    private int numCupcakes;
     private BFF bff; // DECLARE bff is going to be the helper for getting input.
    
    public final int BAKERY_CAPACITY = 500;

    /**
     * Default Constructor for objects of class Bakery
     */
    public Bakery()
    {
        // initialise instance variables
        name = "White Windmill";
        myCupcakes = new Cupcake[BAKERY_CAPACITY]; // an array in Java needs a capacity
        numCupcakes = 0;
        bff = new BFF();
    }

    //overloaded constructor. takes a different name for the bakery
    public Bakery(String name){
         this(); // call the default constructor
         this.name = name;
    }
    
    
    public void makeCupcakes(){
     // make a bunch of cupcakes
     String flavor = bff.inputLine("What flavor cupcakes would you like to make?");
     String frosting = bff.inputLine("What frosting type  would you like?");
     int num = bff.inputInt("How many of those cupcakes do you want to make?", 1, 100);
     for(int i = 0; i < num; i++){
         Cupcake cup = new Cupcake(flavor, frosting);
         addCupcake(cup);
        }
        
         addCupcake(new Cupcake("carrot", "chocolate", true, true, 8.00, Cupcake.JUMBO));
    }
    
    public void findNoahsCupcake(){
     // which spot holds Noah's cupcake? Also called nc 
     int indexOfNoah = -1; // set equal to a bad value to start
     // loop through all the cupcakes, looking for noah's
     for(int i = 0; i < numCupcakes; i++) { // looking through the "filled" cupcake spots
         Cupcake currentCake = myCupcakes[i]; // get the current cake we are looking at in the collection
         if(currentCake.equals(nc)){
             System.out.println("YAY I found noah's cake at spot"  + i);
             indexOfNoah = i;
            }
     
    }
    if(indexOfNoah == -1){
         System.out.println("Noah's cake was not found");   
    }
    else {
        System.out.println("Noah's cake was  found at spot " + indexOfNoah);  
        Cupcake c = myCupcakes[indexOfNoah];
        System.out.println("Noah's cupcake " + c); // this calls the toString of Cupcake
        System.out.println("calling c.print...");
        c.print(); //cupcake go print yourself
        
    }
}
    
    public void makeSpecialCupcakes(){
         sC = new Cupcake("vanilla", "yogurt", false);
         nc = new Cupcake("carrot", "chocolate", true, true, 8.00, Cupcake.JUMBO);
         gC = new Cupcake("red velvet", "Cream cheese");
         myCupcakes[numCupcakes] = sC; numCupcakes++;  // adding one cucpake
         
         myCupcakes[numCupcakes] = nc; numCupcakes++;  //adding next
          //myCupcakes[2] = gC; numCupcakes++; 
          addCupcake(gC);
          addCupcake(new Cupcake("carrot", "chocolate", true, true, 8.00, Cupcake.JUMBO));
           addCupcake(new Cupcake("carrot", "chocolate", true, true, 8.00, Cupcake.JUMBO));
        }
        
        private void addCupcake(Cupcake c){
            myCupcakes[numCupcakes] = c;
            numCupcakes++;
        }
}
