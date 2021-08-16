import java.util.*;

/**
 * Write a description of class TravelList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TravelList
{
    // instance variables - replace the example below with your own
    private ArrayList<City> myList;

    /**
     * Constructor for objects of class TravelList
     */
    public TravelList()
    {
        // initialise instance variables
        myList = new ArrayList<>(); 
    }

     public void demo(){
        myList.add(new City("Tokyo", "Japan"));
        myList.add(new City("Honolulu", "USA"));
        myList.add(new City("San Diego", "USA"));
        myList.add(new City("Sydney", "AU"));
        
        myList.add(0, new City("London", "England"));
        myList.add(new City("Mumbai", "India"));
        myList.add(new City("London", "England"));;
        myList.add(new City("london", "England"));;
        System.out.println("Travel list: " + myList);
        
        // pretend somebody asked to delete London
        // there can be problems when we try to delete from a list that we are traversing over
        // ITERATOR -- a magical device that loops across a collection in a way that allows us to change the collection
        // for each is an IMPLICIT iterator (hides the details)
        City toDelete = new City("london", "england");
        myList.remove(toDelete);
        /* NOT SAFE: for(String city: myList){
            if(city.equalsIgnoreCase(toDelete)){
                myList.remove(city);
            }
        }*/
        Iterator<City> it = myList.iterator(); // special object to walk through a collection
        while(it.hasNext()){
             City thing = it.next();   
             if(thing.equals(toDelete)){
                 it.remove();
                }
        }
        
         System.out.println("Travel list: " + myList);
     }
}
