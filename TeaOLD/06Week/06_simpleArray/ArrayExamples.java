import java.time.*;

/**
 * Write a description of class ArrayExamples here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayExamples
{
    // instance variables - replace the example below with your own
    private String[] tas;
    private BFF bff;

    /**
     * Constructor for objects of class ArrayExamples
     */
    public ArrayExamples()
    {
        // initialise instance variables
        bff = new BFF();
        tas = new String[]{"Kamryn", "Cat", "Malik", "Anup", "Adam", "Walter", "Phil"};
        // notice that when we declare separate from initialization, we have to use the new String[]
    }

    public void demo(){
        System.out.println("The tas are:" + tas);

        Person[] myFamily = {new Person("Bryce", LocalDate.of(2006, 4, 19)),
                new Person("Eri", LocalDate.of(2009, 5, 22)),
                new Person("Kendra", LocalDate.of(1977, 11, 24)),
                new Person("Andy", LocalDate.of(1978, 8, 27))};

        System.out.println("My family: " + myFamily);
        // or can loop to print people on a line
        System.out.println("The Walther Family:");
        for(int i = 0; i < myFamily.length; i++){
            System.out.println("\t" + myFamily[i]);   
        }

        boolean searchFamily = bff.inputYesNo("Would you like to look for a person in my family");
        while(searchFamily){
            String name = bff.inputLine("Enter name");
            LocalDate bday = bff.inputDate("Enter birthday"); // TODO: write this method in BFF
            findPerson(name, bday, myFamily);
            searchFamily = bff.inputYesNo("Would you like to look for a person in my family");
        }

    }

    // Functions to find a person
    public static void findPerson(String name, LocalDate bday, Person[] people){

        findPerson(new Person(name, bday), people); 
    }

    public static void findPerson(Person p, Person[] people){
        int index = -1; //-1 indicates not found

        /* // non ideal way, espically if array is long, keeps looking after we found person
        for(int i = 0 ; i < people.length; i++){
        Person current = people[i];
        if(current.equals(p)){
        index = -1;   
        }
        }*/
        int i = 0;
        while (index == -1 && i < people.length){
            Person current = people[i];
            if(current.equals(p)){
                index = i;   
            }
            i++;
        }

        if(index == -1){
            System.out.println(p + " was NOT found in the list of people");    
        }
        else{
            System.out.println(p + " was found in the list of people at spot: " + index); 
        }

    }

    public static void main(String[] args){ 
        Person[] peeps = new Person[]{new Person("Adam", 1999, 12, 21),   // year month day
                new Person("Cat", 2000, 11, 11), 
                new Person("Malik", 1997, 9, 6), 
                new Person("Kamryn", 1999, 4, 3), 
                new Person("Anup", 2000, 11, 11), 
                new Person("Walter", 2000, 11, 11), 
                new Person("Phil", 2000, 11, 11), 
                new Person("Kendra", 1977, 11, 24) 
            };
        BFF bff = new BFF();
        boolean find = bff.inputYesNo("Would you like to look for a person in my list?");
        while(find){
            String name = bff.inputLine("Enter name");
            LocalDate bday = bff.inputDate("Enter birthday"); // TODO: write this method in BFF
            findPerson(name, bday, peeps);
            find = bff.inputYesNo("Would you like to look for a person in my list?");
        }
    }

}
