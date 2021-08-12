import java.util.*;

/**
 * Write a description of class TravelProgram here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TravelProgram
{
    // instance variables - replace the example below with your own
    private LinkedList<City> travelList;

    /**
     * Constructor for objects of class TravelProgram
     */
    public TravelProgram()
    {
        // initialise instance variables
       travelList = new LinkedList<>(); // capacity is increased to 20
    }

    public void demo(){
         System.out.println("Welcome to the travel program....");
          System.out.println(travelList.size() + " places on your list: " + travelList);
          
          // demo just hardcodes adding stuff to the list.
          travelList.add(new City("Cairo", "Egypt"));
          travelList.add(new City("Tokyo", "Japan"));
          travelList.add(new City("Barcelona", "Spain"));
          travelList.add(new City("Montevideo", "Uruguay"));
          travelList.add(new City("Bali", "Indonesia"));
          
           System.out.println("Added a bunch of places\n" + travelList.size() + " places on your list: " + travelList);
           
           travelList.add(0, new City("Anchorage", "Alaska"));
     
           
           System.out.println("Added to spot 0 and 2... \n" + travelList.size() + " places on your list: " + travelList);
           

          
            System.out.println("Added duplicate of places\n" + travelList.size() + " places on your list: " + travelList);
         
            for(int i = 0; i < travelList.size(); i++){
                 System.out.println(i + " : " + travelList.get(i));   
            }
            
         //  int spot =  travelList.indexOf("Bali") ; // first spot Bali appears in
        //     int spot2 =  travelList.indexOf("Anchourage") ; // first spot Anchourage appears in
             
          //  System.out.println("Bali is in spot: " + spot +  " and achourage is in spot: " + spot2);
           // travelList.remove(spot); // remove spot 6 -- OVERLOADED -- index (int) or OBJECT (data value)
           // travelList.remove("Bali"); // remove the first Bali from the list
        
           // REMOVE every time BALI is on the list AS we STEP through the LIST
           // the only safe way to do so is with an EXPLICIT iterator
           /* THIS iS IMPLICIT
           for(String city: travelList){
                 if(city.equalsIgnoreCase("Bali")){
                     travelList.remove(city);
                    }
            }*/
            Iterator<City> myIterator = travelList.iterator(); 
            while(myIterator.hasNext()){
                City city = myIterator.next();  
                if(city.equals(new City("Bali", "Indonesia"))){
                    myIterator.remove(); // SAFELY modify the collectio 
                }
            }
            
             System.out.println("REMOVED all instances of Bali with loop\n" + travelList.size() + " places on your list: " + travelList);
         
           
        }
}
