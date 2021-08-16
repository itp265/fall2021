package people;

import java.util.Comparator;

public class MyComparator<T> implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
	if(o1.equals(o2)) {
		return 0;
	}
	else {
		int num = -1 * o1.getBday().compareTo(o2.getBday());
		if(num == 0) {
			num = o1.getName().compareTo(o2.getName());
		}
		return num;
	}
	}
	
}
