import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareNames {


	
	public static void compareNames(String name1, String name2) {
		if(name1.compareTo(name2) < 0) {
			System.out.println(name1 + " < " + name2);
		}
		else if (name1.compareTo(name2) > 0) {
			System.out.println(name1 + " > " + name2);
		}
	else {
		System.out.println(name1 + " = " + name2);
	}
	}
	
	public static void main(String[] args) {
		Name name1 = new Name("Gabi");
		Name name2 = new Name("Jenny");
		Name name3 = new Name("Atieno");
		Name name4 = new Name("Nithya");
		Name name5 = new Name("Jenny");
		
		
		List<Name> nameList = new ArrayList<>();
		nameList.add(name1);nameList.add(name5);nameList.add(name2);
		nameList.add(name3);nameList.add(name4);
		
		System.out.println("BEFORE SORTING");
		for(Name n: nameList) {
			System.out.println(n);
		}
		// to sort a list of names....
		// bubble sort, merge sort, quicksort, insertion sort, selection sort
		/*for(int i = 0; i < nameList.size(); i++) {
			for (int j = 0; j < nameList.size(); j++) {
				if(nameList.get(i).compareTo(nameList.get(j)) > 0 ) {
					// then swap the items
					Name iName =nameList.get(i);
					Name temp = nameList.get(i);
					nameList.set(i, nameList.get(j));
					nameList.set(j, temp);
				}
			}
		}*/
		
		
		
		Collections.sort(nameList); // sort relies on compareTo method
		System.out.println("AFTER SORTING");
		for(Name n: nameList) {
			System.out.println(n);
		}

	}

}
