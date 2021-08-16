
/**
 * Write a description of class City here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class City
{
    // instance variables - replace the example below with your own
    private String name;
    private String country;

    /**
     * Constructor for objects of class City
     */
    public City(String name, String country)
    {
        // initialise instance variables
        this.name = name;
        this.country = country;
    }

   public String toString(){
         return "(CITY: " +  name + ", " + country +")";  
    }
    
    public boolean equals(City other){
         return this.name.equalsIgnoreCase(other.name) &&
                 this.country.equalsIgnoreCase(other.country);
    }
}
