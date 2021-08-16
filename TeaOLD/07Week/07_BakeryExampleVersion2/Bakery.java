import java.util.*;

/**
 * Write a description of class Bakery here.
 * Note: this starter code version is from the night owl class, so coffee will need to dive a little deeper into this.
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bakery
{
    // instance variables - replace the example below with your own

    private CreditCard[] loyaltyClubCards; // 3 bestest customers

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
        loyaltyClubCards = new CreditCard[3]; // keep track of top 3 customers
    }
    //overloaded constructo. takes a different name for the bakery
    public Bakery(String name){
        this(); // call the default constructor
        this.name = name;
    }

    public void run(){
        bff.print("Welcome to the " + name + " bakery");
        boolean keepGoing = true;
        while(keepGoing){
            BakeryOperationsMenu.printMenu();
            int num = bff.inputInt(">", 0,  BakeryOperationsMenu.getNumOptions());
            BakeryOperationsMenu option = BakeryOperationsMenu.values()[num];
            switch(option){
                case BAKE_MENU_ITEMS: bakeMenuItems(); break;
                case SHOW_INVENTORY: showCakes(); break;
                case SHOW_MENU: showMenu(); break;
                case  HANDLE_CUSTOMER:  helpCustomer(); break;
                case RUN_SELLING_STATS:  showBakeryStats(); break;
                case LOAD_LOYALTY_MEMBERS: loadLoyaltyMembers(); break;
                case SET_NUMBER_MEMBERS:  setNumberOfLoyaltyMembers(); break;
                case LOYALTY_MEMBERS:  printLoyaltyMembers(); break;
                case REGISTER_MEMBER:  registerLoyaltyMember(); break;
                case QUIT   :  keepGoing = false; break;
            }
        }
        bff.print("Goodbye");
    }
    
    private void showCakes(){
        for(int i = 0; i < numCupcakes; i++){
             bff.print(i + " : " + myCupcakes[i].toString());   
        }
    }
    
    public void showMenu(){
        bff.print("All cupcakes come in these sizes: " + Arrays.asList(Size.values()));
         for(BakeryMenu item: BakeryMenu.values()){
                 bff.print(item.toString());
            }
    }
    private void showBakeryStats(){
         bff.print("TODO: showBakeryStats method");   
    }
    
     private void loadLoyaltyMembers(){
         bff.print("Rigth now loading loyalty members is just hardcoding the 3 best customers");
        // right now loyaltyClubCards is an EMPTY array with 3 slots.
        loyaltyClubCards[0] = new CreditCard("Kendra W", Issuer.VISA);
        // could get data from BFF.... or be lazy and hard code to test this out
        loyaltyClubCards[1] = new CreditCard("4444111122223333", "Gabi M",Issuer.VISA, 711,  10000, 500, 5, 2022, .12);
        loyaltyClubCards[2] = new CreditCard("Sean V", Issuer.AMEX);
    }
    
    private void setNumberOfLoyaltyMembers(){
         bff.print("TODO: setNumberOfLoyaltyMembers method -- could involve manipulating size of array");
    }
    
    private void printLoyaltyMembers(){
          bff.print("Our customers of the month are (the best most loyal customers): ");
        for(int i = 0; i < loyaltyClubCards.length; i++){
            CreditCard card =   loyaltyClubCards[i];
            bff.print(card.getName());
        }
    }
    private void registerLoyaltyMember(){
        bff.print("TODO: registerLoyaltyMember method -- could involve manipulating array order");
    }
    private CreditCard getCreditCardInfo(String custName){
            CreditCard customerCard = null; // assume no card
            
            boolean member = bff.inputYesNo("Are you part of our loyalty club? (y/n)");
            while(member){
                int i = 0; boolean found = false;
                while(!found && i < loyaltyClubCards.length){
                    CreditCard card =  loyaltyClubCards[i];
                    if(card.getName().equalsIgnoreCase(custName)){
                        int cvv = bff.inputInt(custName + ", could you please verify your CVV for the card on file?");
                        if(cvv == card.getCvv()){
                            customerCard = card;   
                            found = true;
                        }
                        else{
                             bff.print("Sorry, but the cvv doesn't match that on file");
                        }
                    }
                    i++;
                    
                }
                   if(customerCard == null){
                       member = bff.inputYesNo("Would you like to try again with a different cvv (y/n)");
                    }
            }

        if(customerCard == null){ // no match
            bff.print("We need to get their credit card in order to help them....");
            customerCard = bff.inputCreditCardInfo();
        }
      
        return customerCard;
    }
    
    public void helpCustomer(){
        bff.print("Say friendly greeting to the customer. And get their name");
        String name = bff.inputLine("what is the customer's name?");
        CreditCard card = getCreditCardInfo(name); 
          Cupcake[] order = getCustomerOrder();
           bff.print("Thanks for your cupcake order. You have:");
        double price = 0;
        for(int i = 0; i < order.length; i++){
            bff.print(i + ": " + order[i]);
            price += order[i].getPrice();
        }
        bff.print("Your total is: $" + price + "I will charge the card on file!");
        card.charge(price, name);
    }

        

    public Cupcake[] getCustomerOrder(){
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
       return tray;
    }

    public void bakeMenuItems(){
        String bakerName = bff.inputLine("What is your name?");
        //loop
        for(int i = 0; i < BakeryMenu.values().length; i++){
            BakeryMenu item = BakeryMenu.values()[i];
            int num = bff.inputInt("How many (of each size) of item:  " + item.getName() + " are you baking today?", 1, 100);
            boolean sprinkles = bff.inputYesNo("Will you add sprinkles?");
            for(Size size: Size.values()){
                Cupcake type = new Cupcake(item.getCakeType(), item.getFrosting(), sprinkles, size, bakerName, num);
                addCupcake(type);
            }
        }
    }
   
    private void addCupcake(Cupcake c){
        myCupcakes[numCupcakes] = c;
        numCupcakes++;
    }
}
