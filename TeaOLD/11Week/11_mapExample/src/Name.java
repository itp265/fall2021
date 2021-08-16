
public class Name implements Comparable<Name> {
	private String name;
	private int idNum;
	
	private static int ID = 0;
	
	public Name(String n) {
		name = n;
		idNum = ID;
		ID++;
	}
	public String getName() {
			return name;
	}
	@Override
	public int compareTo(Name o) {
		// this < other  --> return neg num
		// this > other --> return pos
		// this == other -> return 0
		int  num = this.name.compareTo(o.name);
		if(num == 0) { //same name
			num = this.idNum - o.idNum;
		}
		
		System.out.println("CompareTo: " + this.name + " versus " + 
						o.name + " returns " + num);
		return num;
	}
	
	public String toString() {
		return this.name + "(" + idNum + ")";
	}
}
