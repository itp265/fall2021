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

	private ArrayList<CreditCard> loyaltyClubCards; 

	private ArrayList<Cupcake> myCupcakes;
	private String name;
	private BFF bff; // DECLARE bff is going to be the helper for getting input.

	/**
	 * Default Constructor for objects of class Bakery
	 */
	public Bakery()
	{
		// initialise instance variables
		name = "White Windmill";
		myCupcakes = new ArrayList<Cupcake>();

		bff = new BFF();
		loyaltyClubCards = new ArrayList<>(); 
	}
	//overloaded constructo. takes a different name for the bakery
	public Bakery(String name){
		this(); // call the default constructor
		this.name = name;
	}

	/**
	 * For this course, often your main method will be as simple as this one.
	 * @param args
	 */
	public static void main(String[] args) {
		Bakery b = new Bakery();
		b.run();
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
			case SHOW_INVENTORY: showAllCakes(); break;
			case SHOW_MENU: showMenu(); break;
			case  HANDLE_CUSTOMER:  helpCustomer(); break;
			case RUN_SELLING_STATS:  showBakeryStats(); break;
			case LOAD_LOYALTY_MEMBERS: loadLoyaltyMembers(); break;
			case LOYALTY_MEMBERS:  printLoyaltyMembers(); break;
			case REGISTER_MEMBER:  registerLoyaltyMember(); break;
			case QUIT   :  keepGoing = false; break;
			}
		}
		bff.print("Goodbye");
	}

	private void showAllCakes(){
		for(int i = 0; i < myCupcakes.size(); i++){
			bff.print(i + " : " + myCupcakes.get(i).toString());   
		}
	}

	public void showMenu(){
		bff.print("🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁");
		bff.print("\t\t" + this.name + " Bakery ");
		bff.print("🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁");
		bff.print("All cupcakes come in these sizes: " + Arrays.asList(Size.values()));
		//for(BakeryMenu item: BakeryMenu.values()){
		for(int i = 0; i < BakeryMenu.values().length; i++) {
			BakeryMenu item = BakeryMenu.values()[i];
			bff.print(i + " : " + item.toString());
		}
		bff.print("🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁🧁");

	}
	private void showBakeryStats(){
		bff.print("TODO: showBakeryStats method");   
	}

	private void loadLoyaltyMembers(){
		bff.print("Rigth now loading loyalty members is just hardcoding the 3 best customers");
		// right now loyaltyClubCards is an EMPTY array with 3 slots.
		loyaltyClubCards.add(new CreditCard("Kendra W", Issuer.VISA));
		// could get data from BFF.... or be lazy and hard code to test this out
		loyaltyClubCards.add(new CreditCard("4444111122223333", "Gabi M",Issuer.VISA, 711,  10000, 500, 5, 2022, .12));
		loyaltyClubCards.add(new CreditCard("Sean V", Issuer.AMEX));
		bff.print("Loading members from file.....");
		ArrayList<String> dataInFile = FileReader.readFile("bin/MyMembers.txt");
		
		//int lengthOfarray = dataInFile.size() - 1; 
		//CreditCard[] array = new CreditCard[lengthOfarray];
		
		// the first line of data is usually a HEADER (a line we can ignore)
		for(int i = 1; i < dataInFile.size(); i++) { // start at line 1 instead of 0
			String line = dataInFile.get(i); // current line of data
			// break that line into tokens (pieces) that correspond with my current card data
			Scanner parser = new Scanner(line); // tell Scanner it is working on the CURRENT LINE of data
			parser.useDelimiter("\t"); // tab separated values
			// using my knowledge of the file to get the individual columns of data
			String cardNum = parser.next();
			String name = parser.next();
			String cardType = parser.next();
			int cvv = parser.nextInt();
			double limit = parser.nextDouble();
			double balance = parser.nextDouble();
			int month  = parser.nextInt();
			int year = parser.nextInt();
			double rate = parser.nextDouble();
			// need to figure out special cases
			// need cardType as an Issuer enum type
			Issuer issuer = Issuer.matchCardType(cardType); // code will crash if not a valid card-type

			CreditCard c = new CreditCard(cardNum, name, issuer, cvv, limit,
					balance, month, year, rate);

			System.out.println("Made cc from info in file: " + c);

			//array[i] = c;
			this.loyaltyClubCards.add(c);
		}
	}




	private void printLoyaltyMembers(){
		bff.print("Our customers of the month are (the best most loyal customers): ");
		for(int i = 0; i < loyaltyClubCards.size(); i++){
			CreditCard card =   loyaltyClubCards.get(i);
			bff.print(card.getName());
		}
	}
	private void registerLoyaltyMember(){
		bff.print("TODO: registerLoyaltyMember method -- could involve manipulating array order");
	}
	//TODO: this method doesn't quite work correctly.
	private CreditCard getCreditCardInfo(String custName){
		CreditCard customerCard = null; // assume no card

		boolean member = bff.inputYesNo("Are you part of our loyalty club? (y/n)");
		if(member) {
			customerCard = lookUpMembership(custName);
		}
		// don't need else, because if the card is still empty, we need to register them
		if (customerCard == null) {
			//get their card informationn

			bff.print("We need to get their credit card in order to help them....");
			customerCard = bff.inputCreditCardInfo();
		}

		return customerCard;
	}

	private CreditCard lookUpMembership(String custName) {
		CreditCard customerCard = null; 
		int i = 0; boolean found = false;
		while(!found && i < loyaltyClubCards.size()){
			CreditCard card =  loyaltyClubCards.get(i);
			if(card.getName().equalsIgnoreCase(custName)){ //match 
				//verify
				int cvv = bff.inputInt(custName + ", could you please verify your CVV for the card on file?");
				if(cvv == card.getCvv()){
					customerCard = card;   
					found = true;
				}
				else{
					bff.print("Sorry, but the cvv doesn't match that on file");
					//one more shot to try
					cvv = bff.inputInt(custName + ", please give me the cvv again");
					if(cvv == card.getCvv()){
						customerCard = card;   
						found = true;
					}
				}
			}
			i++;
		}// end of while loop looking for card
		if(customerCard == null){ // either didn't find, OR cvv was wrong
			boolean name  = bff.inputYesNo("Could your membership be under another name?");
			if(name == true) {
				//get new name
				String newName = bff.inputLine("What other name could your membership be under?");
				customerCard = lookUpMembership(newName);
			}
		}
		// either we have a matching card, or it's still null
		return customerCard;

	}
	public void helpCustomer(){
		bff.print("Say friendly greeting to the customer");
		String name = bff.inputLine("what is the customer's name?");

		Cupcake[][] order = getCustomerOrder();
		bff.print("Thanks for your cupcake order. You have:");
		double price = 0;
		for(int row = 0; row < order.length; row++){
			for(int col = 0; col < order[row].length; col++) {
				Cupcake c = order[row][col];
				if(c == null) {
					System.out.print("X ");
				}
				else {
					System.out.print("🧁");
					price += c.getPrice();
				}
			}// end of one row
			System.out.println(); 
		} // end of all rows
		//bff.print(i + ": " + order[i]);
		//price += order[i].getPrice();

		CreditCard card = getCreditCardInfo(name); 

		bff.print("Your total is: $" + price + "I will charge your card");
		card.charge(price, name);
	}



	public Cupcake[][] getCustomerOrder(){
		int num = bff.inputInt("How many cupcakes would you like to buy?", 1, 16);
		//	int left = num;
		Cupcake[][] tray = new Cupcake[4][4]; // 2d array for a cupcake tin 
		for(int i = 0; i < num; i++){
			bff.print("Please choose cupcake type " + i);
			Cupcake choice = chooseCupcake(); //TODO 
			// int amount = bff.inputInt("How many cupcakes of that type would you like?", 1, left);
			int rowSpot = i/4; // inter division for the row
			int colSpot = i%4;
			System.out.println("Putting cupcake in spot " + rowSpot + ", " + colSpot);
			tray[rowSpot][colSpot] = choice; // kind of -- this points to the cupcake Gabby wants to get
			//TODO
			if(!choice.decrease()) {
				bff.print("Oops, may have run out...");
			}
		}
		return tray;
	}

	private Cupcake chooseCupcake() {
		this.showMenu();
		int choice = bff.inputInt("Which cupcake type do you want?\n>", 0, BakeryMenu.values().length-1);
		Size s = bff.inputSize();
		BakeryMenu item = BakeryMenu.values()[choice];
		Cupcake type = null;
		//change to while to sell older cakes to first
		for(Cupcake c : myCupcakes) {
			if(c.getFlavor().equals(item.getCakeType())
					&& c.getFrosting().equals(item.getFrosting()) && c.getSize() == s) {
				type = c;
			}		
		}


		return type;
	}
	public void bakeMenuItems(){
		String bakerName = bff.inputLine("What is your name?");
		int num = bff.inputInt("How many (of each size) of each item are you baking today?", 1, 100);
		boolean sprinkles = bff.inputYesNo("Will you add sprinkles?");
		//loop
		for(int i = 0; i < BakeryMenu.values().length; i++){
			BakeryMenu item = BakeryMenu.values()[i];
			for(Size size: Size.values()){
				Cupcake type = new Cupcake(item.getCakeType(), item.getFrosting(), sprinkles, size, bakerName, num);
				addCupcake(type);
			}
		}
	}

	private void addCupcake(Cupcake c){
		myCupcakes.add(c);

	}
}
