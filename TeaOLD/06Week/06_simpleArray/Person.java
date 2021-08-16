import java.time.*;
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String name;
    private LocalDate bday;

    /**
     * Constructor for objects of class Person
     */
    public Person(String name, LocalDate bday)
    {
        // initialise instance variables
       this.name = name;
       this.bday = bday;
    }
      public Person(String name, int year, int month, int date)
    {
        this(name, LocalDate.of(year, month, date));
    }
    
    public String getName(){
         return name;   
    }
    public String getBdayString(){
         return bday.getMonth() + " " +  bday.getDayOfMonth() + ", " + bday.getYear();
    }
    public LocalDate getBday(){
         return bday;   
    }
  
    public String toString(){
         return "Person: " + name + ", bday = " + getBdayString();   
    }
    
    public boolean equals(Person other){
         return this.name.equalsIgnoreCase(other.name) && this.bday.equals(other.bday);   
    }
    
}
