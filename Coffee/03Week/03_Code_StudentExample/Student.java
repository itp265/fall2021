
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    // instance variables - 
    private String name;
    private int age;
    private String major;
    public double gpa;
    
    public static String section = "Coffee";


    /**
     * Student Constructor
     *
     * @param name the name of the student
     * @param theAge A parameter
     * @param theMajor A parameter
     */
    public Student(String name, int theAge, String theMajor ) //full version constructor
    {
        // initialise instance variables
        this.name = name; //THIS is a reference to the self (object spot in memory)
        this.age = theAge; //ctrl-space to get auto-completion
        major = theMajor;
        gpa = 3.0;
     
    }
    
 
      public Student(String name, int theAge ) //another constructor
    {
        // initialise instance variables
       this (name, theAge, "undeclared");
       // this.name = name; //THIS is a reference to the self (object spot in memory)
       // this.age = theAge; //ctrl-space to get auto-completion
       // major = "undeclared";
    
    }
    
      
      public Student(String name ) //another constructor
    {
        // initialise instance variables
       // this(name, 20, "undeclared");
        this(name, 20);
    }
  
    public String getName(){
     return name;   
    }
    public void setMajor(String newMajor){
      major = newMajor;   
    }
    
    public boolean setGpa(double value){
        boolean acceptedValue = false;
     if (value >= 0.0 && value <= 4.0){
         gpa = value; // accept change
         acceptedValue = true;
    }
    return acceptedValue;
}

/**
 * Method toString - instead of classs type @ memory location, make it look nice
 *
 * @return The return value
 */
public String toString(){
    String s = major + " Student named " + name;
    return s;
}

// Compare this (blue paper a12) student in memory to some OTHER student in memory
// like zoom student z22 -- if the stuff inside is the same, then they are equals
     public boolean equals(Student other){
        return  this.name.equalsIgnoreCase(other.name)
             && this.age == other.age
         && this.major.equalsIgnoreCase(other.major);
        }
/**
 * This method will primt the student's name and the number of characters in the name
 *
 */
public void printName(){
 
    System.out.println("My name is " +  name + ". There are " + name.length() 
    + " letters in my name");
}
}
