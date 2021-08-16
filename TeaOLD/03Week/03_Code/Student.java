
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String name;
    private int age;
    private String major;
    private double gpa;
    public static String section = "Owl";

    /**
     * Constructor for objects of class Student
     */
    public Student(String name, int theAge, String theMajor) //Full version of the constructor
    // full version sets up ALL instance variables
    {
        // initialise instance variables
        this.name = name;
        this.age = theAge;
        major = theMajor;
        gpa = 3.0;
        
    }
     
      public Student(String theName, int age){ //non-full
           this(theName, age, "undeclared");
            }

    public Student(String theName){
      this(theName, 20); // two hops
      //this(theName, 20, "undeclared");     //one hop -- up to the full version    
    }
    public void printName(){
        System.out.println(section + " " +      name.toLowerCase());
    }
      // ACCESSOR -- getting things
      public String getName(){
          return name;
        }
      
      //MUTATOR -- setting things
      public void setMajor(String major){
         this.major = major; 
        }
        
        public boolean setGpa(double value){
            boolean changedGpa = true;
             if(value > 0 && value <= 4.0){
                 this.gpa = value;
                 changedGpa = true;
            }
            else{
                changedGpa = false;
            }
            return changedGpa;
        }
        
        // all students can study
        public void study(){
             System.out.println(name + " is studying right now.");   
        }
    
        /**
         * toString is to return a String version of the object that is nicely formatted
         * (and not just the memory address of where the object lives)
         * MAGIC method 
         */
        public String toString(){
            String s = major + " Student named " + name;
            return s;
        }
        
        
        /**
         * Method equals: looks at the object ittself in memory (blue paper spot a12)
         * versus looking at the object somewhere else in memory (zoom student spot 89)
         * Returns true if the values stored inside those objects are the same (ignore capitals)
         *
         * @param other A parameter
         * @return The return value
         */
        public boolean equals(Student other){
           return  this.getName().equalsIgnoreCase(other.name)
            && this.age == other.age
            && this.major.equalsIgnoreCase(other.major);
        }
        
    public static void main (String[] args){
      Student s1 = new Student("Brianna", 22, "Neuroscience"); //@a meory location B2
      Student s2 = new Student("Noah");
      s1.printName(); // go to memory location B@ and tell that thing print your name
      System.out.println("Student 1 is " + s1);
      System.out.println("Studnet 2 is " + s2);
    }
}
