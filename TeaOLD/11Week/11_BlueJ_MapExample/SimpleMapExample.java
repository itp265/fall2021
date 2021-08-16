import java.util.*;

public class SimpleMapExample {

	private Map<String, String> emailMap; //declare variable, value is null
	
	public SimpleMapExample() {
		emailMap = new HashMap<>(); //declare - set aside the memory
		// fill my map, use the put method
		//keys have to be unique, values don't
		emailMap.put("kwalther@usc.edu", "Kendra Walther");
		emailMap.put("kendra@thewalthers.com", "Kendra Walther");
		//when we put a key in the map that is previously there, the value updates
		emailMap.put("kendra@thewalthers.com", "Eridani & Kendra Walther");
		emailMap.put("kamryn@usc.edu", "Kamryn M");
		emailMap.put("cathleey@usc.edu", "Cathleen Yang");
		
	}
	public void print() {
		System.out.println("1: Printing the map object:");
		System.out.println(emailMap);
		System.out.println("2: Printing the map keys:");
		System.out.println(emailMap.keySet());
		System.out.println("3: Printing the map values:");
		System.out.println(emailMap.values());
		System.out.println("4: Key --> Value, method 1:");
		for(String key: emailMap.keySet()) {
			String value = emailMap.get(key);
			System.out.println(key + " ==> " + value);
		}
		
		System.out.println("5: Key --> Value, method 2:");
		//funny syntax
		for(Map.Entry<String, String> pair: emailMap.entrySet()) {
			System.out.println(pair.getKey() + " ==> " + pair.getValue());
		}
	
	}
	
	public static void main(String[] args) {
		SimpleMapExample ex = new SimpleMapExample();
		ex.print();

	}

}
