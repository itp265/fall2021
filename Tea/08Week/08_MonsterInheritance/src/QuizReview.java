import java.util.ArrayList;
import java.util.Arrays;

public class QuizReview {
	
	// 1d arrays
	//Arrays of primitives -- calendar, grade average max of grades
	//Declare am array of ages - for 12 people
	// ARRAYS: .length and [] to access
	//ENUMS... we can get an array (.values() --> returning an array of enum values)
	//LIST -- (ArrayList and LinkedList) objects and they have LOTS of METHODS including size() --> everything is a method so we see ()
	
	private int[] ageArray;
	private BFF helper;
	private String[] namesArray;
	private int numNames;
	//static for a variable means ONE piece of memory no matter how many objects are created
	// final the variable can not be changed once it's been set to something
	private static  String[] sectionNames =  {"NightOwls", "Coffee", "Cactus"};
	private ArrayList<String> favoriteFood;
	//sectionNames[2] = "Python Cactus";
	
	// static methods are FUNCTIONS -- there's no objects or outside memory that is accessed. info comes in (if needed)
		// and the method/function performs an action
	
	
	public static String getRandomSectionNames() {
		return sectionNames[2];
	}
	
	public static int addsNumbers(int[] array) {
		int sum = 0;
		for(int i: array) {
			sum+= i;
		}
		return sum;
	}
	
	public QuizReview() {
		helper = new BFF();
		ageArray = new int[12];  // slots to hold 12 items of type int
		// any primitive starts off as 0 (for int), 0.0 (float/double), false (boolean)
		namesArray = new String[100];
		numNames = 0;
		
		this.favoriteFood = new ArrayList<String>(); // means i get a list with 10 spots to start
		this.favoriteFood = new ArrayList<String>(100); // means i get a list with 100 spots to start
		//favoriteFood.get(0);
		//favoriteFood.size();
		favoriteFood.add("Sushi");
		System.out.println("1: " + favoriteFood);
		favoriteFood.add(0, "Ice Cream");
		System.out.println("2: " + favoriteFood);
		favoriteFood.set(1, "Poke");
		System.out.println("3: " + favoriteFood);
		favoriteFood.add("Pizza");
		System.out.println("4: " + favoriteFood);
		
		favoriteFood.add(0, "Sushi");
		System.out.println("5: " + favoriteFood);
		// loops to print each item or we could print all in one line
		
		//FILL AN ARRAY - with a loop one by one
		for(int i = 0; i < ageArray.length; i++) {
			//System.out.println("spot " + i + " : " + ageArray[i]);
		//	int age = helper.inputInt("Please give me the age of student " + i + ">");
			ageArray[i] = 20;
		}
		System.out.println("Here's age array with " +  Arrays.toString(ageArray));
		
		//fill an array with an initializer
		ageArray = new int[] {22, 21, 22, 24, 20, 19, 18};
		System.out.println("Replaced age array with " + ageArray.length + "spots holding " + Arrays.toString(ageArray));
		
		
	}

	public void showOffStuff() {
		// length
		// first spot in the array.... spot 0
		System.out.println("First thing in the array: " + ageArray[0]);
		System.out.println("LAST thing in the array: " + ageArray[ageArray.length -1]);
	
		//partially size arrays.... need an extra variable..
		// add things to my array of names....
		printAllNameArray();
		addNames();
		
		printNameArray();
	}
	
	private void printAllNameArray() {
		for(int i = 0; i < namesArray.length; i++) {
			System.out.println(i + " : " + namesArray[i]);
		}
		
	}

	private void printNameArray() {
	//partially filled array - i can't access all the elemnts
		for(int i = 0; i < numNames; i++) {
			System.out.println(i + " : " + namesArray[i]);
		}
		int numSpots = namesArray.length - numNames;
		System.out.println("There are " + numSpots + " empty spaces in the array");
	}

	public void addNames() {
		boolean keepGoing = true;
		while(keepGoing) {
			String name = helper.inputLine("What is a name to enter?");
			namesArray[numNames] = name;
			numNames++;
			
			keepGoing = helper.inputYesNo("Add more names? (y/n)?");
			
		}
	
	}
	
	
	public static void main(String[] args) {
	QuizReview review = new QuizReview();
	review.showOffStuff();
	System.out.println("Answer is: " +	addsNumbers( new int[] {33, 44, 5,6, 7, 8, 9}) );
	review.showOffEnums();
	
	}

	private void showOffEnums() {
		Planet home = Planet.EARTH;
		System.out.println("Home is: " + home);
		
//		System.out.println("Other options are....");
//		for(Planet p: Planet.values()) { //every enum has the values method
//			System.out.println(p);
//		}
		
	
		System.out.println(Planet.toMenu());
		int num = helper.inputInt("Choose your planet", 0, Planet.getNumPlanets()-1); 
		
		home = Planet.getPlanetNumber(num);
		System.out.println("Home is: " + home);
		System.out.println("My Home has: " + home.getNumMoons() + " moons");
		
		
	}

}
