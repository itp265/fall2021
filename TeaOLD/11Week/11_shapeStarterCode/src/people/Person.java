package people;

import java.time.LocalDate;

public class Person implements Comparable<Person> {
	private String name;
	private LocalDate bday;
	
	public Person(String name, LocalDate bday) {
		this.name = name;
		this.bday = bday;
	}
	
	public Person(String name, int year, int month, int day) {
		this(name, LocalDate.of(year, month, day));		
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the bday
	 */
	public LocalDate getBday() {
		return bday;
	}
	/**
	 * @param bday the bday to set
	 */
	public void setBday(LocalDate bday) {
		this.bday = bday;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", bday=" + bday + "]";
	}
	
	public boolean equals(Person other) {
		return this.name.equalsIgnoreCase(other.name)
				&& this.bday.equals(other.bday);
	}



	//@Override
	public int compareTo(Person o) {
		System.out.println("Comparing " + this.name + " To " + o.name);
		//are they equal? --> return 0
		if(this.equals(o)) return 0;
		// otherwise compare variables in order. 
		//Our natural ordering is age first
		//bday does oldest first, reverse do -1* ansewr
		
		int num = this.name.compareToIgnoreCase(o.name);
				
		if(num == 0) {		
				num = -1*this.bday.compareTo(o.bday);
		}
		
		return num;
	}

	
}
