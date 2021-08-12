import java.util.*;

public class SimpleMapExample {
	
	private Map<String, String> emailMap; // declare

	
	public SimpleMapExample() {
		emailMap = new HashMap<>(); // initialize, make the thing in memory
		
		// put some things in my map -- notice keys of type string are case sensitive
		emailMap.put("kwalther@usc.edu", "Kendra Walther");
		emailMap.put("kendra@thewalthers.com", "Kendra Walther");
		emailMap.put("elamrous@usc.edu", "Menna Elamroussy");
		//put something that is already in the map (but keys are supposed to be unique)
		String old = emailMap.put("kendra@thewalthers.com", "Kendra & eri Walther");
		if(old != null) {
			System.out.println("Replaced previous value of: " + old);
		}
		
	}
	
	public void printMap() {
		System.out.println("1: Directly print the map object");
		System.out.println(emailMap);
		
		System.out.println("2:  print the map's keys");
		for (String email: emailMap.keySet()) {
			System.out.println(email);
		}
		
		System.out.println("3:  print the map's keys --> value");
		for (String email: emailMap.keySet()) {
			System.out.println(email + "--> " + emailMap.get(email));
		}
		
		System.out.println("4:  print the map's values");
		for (String names: emailMap.values()) {
	
			System.out.println(names);
		}
		
		System.out.println("5:  print the map's pairs");
		for( Map.Entry<String, String> pair :emailMap.entrySet()) {
	
			System.out.println(pair.getKey() + " ==> " + pair.getValue());
		}
		
	}
	public static void main(String[] args) {
		SimpleMapExample program = new SimpleMapExample();
		program.printMap();

	}

}
