
/**
 * Write a description of class Bakery here.
 * Note: this starter code version is from the night owl class, so coffee will need to dive a little deeper into this.
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bakery
{

    private CreditCard[] loyaltyClub; // 3 bestest customers

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
        loyaltyClub = new CreditCard[4]; // keep track of top 4 customers
        loadBestCustomers();
    }

    //overloaded constructo. takes a different name for the bakery
    public Bakery(String name){
        this(); // call the default constructor
        this.name = name;
    }

    private void loadBestCustomers(){
        // right now loyaltyClubCards is an EMPTY array with 3 slots.
        loyaltyClub[0] = new CreditCard("Kendra W", Issuer.VISA);
        // could get data from BFF.... or be lazy and hard code to test this out
        loyaltyClub[1] = new CreditCard("4444111122223333", "Menna",Issuer.VISA, 711,  10000, 500, 5, 2022, .12);
        loyaltyClub[2] = new CreditCard("Maria", Issuer.AMEX);
        loyaltyClub[3] = new CreditCard("Deegan", Issuer.VISA, 1000);
    }

    public void run(){
        bff.print("Welcome to the " + name + " bakery. Happy to have you working today");
        // bakery worker "menu" versus a bakery customer menu
        bff.print("Our customers of the month are (the best most loyal customers): ");
        for(int i = 0; i < loyaltyClub.length; i++){
            CreditCard card =   loyaltyClub[i];
            bff.print(card.getName());
        }

        bff.print("Making regular cupcakes ");
        //TODO make a loop here to keep making different kinds.
        makeCupcakes();

        bff.printFancy("A customer walks in the door.....");
        helpCustomer(); // first define the task
    }

    public void helpCustomer(){
        bff.print("Say friendly greeting to the customer. And get their name");
        String custName = bff.inputLine("what is the customer's name?");

        CreditCard customerCard = null; // assume no card

        // CHECK is customer is one of the favorites and we have a card on file 
        // this is not very secure
        for(int i = 0; i < loyaltyClub.length; i++){
            CreditCard card =   loyaltyClub[i];
            if(card.getName().equalsIgnoreCase(custName)){
                customerCard = card;   
            }
        }

        if(customerCard == null){ // no match
            bff.print("We need to get their credit card in order to help them....");
            //TODO
        }
        else{
            bff.print("Welcome the customer profusely since they are one of our loyal customers");
            chooseCupcakesToBuy(customerCard);
            // let's verify it's really Gabi. ppretend data came in thru bff
            //// CreditCard gabi = new CreditCard("4444111122223333", "Gabi M","Visa", 711,  10000, 500, 5, 2022, .12);
            // if(gabi.equals(customerCard)){ // gabi is "THIS" customerCard is the other

            // }
        }
    }

    public void chooseCupcakesToBuy(CreditCard currentCustomer){
        bff.print("Okay " + currentCustomer.getName() + " here are our cupcakes");
        int num = bff.inputInt("How many cupcakes would you like to buy?", 1, 12);
        Cupcake[] tray = new Cupcake[num]; // this array will hold the cupcakes gabby wants to buy
        for(int i = 0; i < tray.length; i++){
            bff.print("Please choose cupcake # " + i);
            //Cupcake choice = choiceCupcake(); //TODO 
            for(int c = 0; c < numCupcakes; c++){
                bff.print(c + ":" + this.myCupcakes[c]);

            }
            int choice = bff.inputInt(">", 0, numCupcakes);

            tray[i] = myCupcakes[choice]; // kind of -- this points to the cupcake Gabby wants to get

        }
        bff.print("Thanks for your cupcake order.");
        double price = 0;
        for(int i = 0; i < tray.length; i++){
            bff.print(i + ": " + tray[i]);
            price += tray[i].getPrice();
        }
        bff.print("Your total is: $" + price + "I will charge the card on file!");
        currentCustomer.charge(price, name);
    }

    public void makeCupcakes(){
        
        //follow the menu and make 100 of each item on the menu
        
        // make a bunch of cupcakes
        String flavor = bff.inputLine("What flavor cupcakes would you like to make?");
        String frosting = bff.inputLine("What frosting type  would you like?");
        int num = bff.inputInt("How many of those cupcakes do you want to make?", 1, 100);

        for(int i = 0; i < num; i++){
            Cupcake cup = new Cupcake(flavor, frosting);
            addCupcake(cup); // puts it in the Bakery
        }
        // every time we bake any cupcakes, we also are adding one of our special cupcake types.
        addCupcake(new Cupcake("carrot", "chocolate", 8.00, true, true, false, Size.JUMBO, "Kendra"));
    }

    private void addCupcake(Cupcake c){
        if(numCupcakes < myCupcakes.length){
            myCupcakes[numCupcakes] = c;
            numCupcakes++;
        }
        else{
            System.out.println("No space for another cupcake. Throw in the garbage or eat it.");   
        }
    }
}
