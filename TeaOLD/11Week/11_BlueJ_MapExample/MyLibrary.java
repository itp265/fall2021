import java.util.*;
/**
 * Write description of class
 *
 * @author Kendra Walther
 * ITP 265, Spring 2021, NightOwl Section
 * email: kwalther@usc.edu
 * Assignment xx
 *
 */
public class MyLibrary {

    private Map<String, List<Book>> libraryMap; // author -> list of books by author
    private String name;
    private List<Book> allBooks;
    private BFF bff;

    public MyLibrary(String name) {
        this.name = name;
        this.bff = new BFF();
        libraryMap = new HashMap<>();
        allBooks = new ArrayList<>();

    }

    public void run() {
        System.out.println("Welcome to " + name + " 's Library");
        populateBooksFromFile();
        printBookList();
        organizeBooks();
        printMap();
        //getBooksByAuthor
        String author = bff.inputLine("Enter author you are looking for:");
        List<Book> books = libraryMap.get(author);
        if(books.isEmpty()) {
            System.out.println("No books by that author");
        }
        else {
            System.out.println("Books by " + author);
            for(Book b: books) {
                System.out.println(b);
            }
        }

    }

    private void printMap() {
        // go through the keys:
        System.out.println("Organized By Author: ");
        for(String author: libraryMap.keySet()) {
            List<Book> value = libraryMap.get(author);
            int number = value.size();
            System.out.println(author + " : " + number + " book(s)");
        }

    }

    private void organizeBooks() {
        // libraryMap: author --> list of books by that author

        //Example of manually adding a book - author combo
        List<Book> booksByAH = new ArrayList<>();
        booksByAH.add(new Book("Autobiagraphy of Malcolm X", "Alex Haley", 225));
        libraryMap.put("Alex Haley", booksByAH);
        // Now do it for allBooks list....
        for(Book b : allBooks) {
            String au = b.getAuthor();
            List<Book> list = libraryMap.get(au); // either list of books or null
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(b);
            libraryMap.put(au, list);
        }
        /*for(Book b: allBooks) {
            //if else to determine if author is already in library
            List<Book> booksByAuthor; 
            if(libraryMap.containsKey(b.getAuthor())) {
                // we have author in library with a list of books.
                booksByAuthor = libraryMap.get(b.getAuthor());
            }
            else { //author not in library, no book list yet
                booksByAuthor = new ArrayList<>(); // empty new list
            }
            booksByAuthor.add(b);
            libraryMap.put( b.getAuthor()  , booksByAuthor   );
        }*/

    }

    private void printBookList() {
        for(Book b: allBooks) {
            System.out.println(b);
        }

    }

    private void populateBooksFromFile() {
        ArrayList<String> dataInFile = FileReader.readFile("books.txt");
        for(String s: dataInFile) {
            //System.out.println(s);
            //need to turn String into a Book
            Scanner sc = new Scanner(s);
            sc.useDelimiter("/");
            String title = sc.next();
            String author = sc.next();
            int numPages = sc.nextInt();
            Book b = new Book(title, author, numPages);
            allBooks.add(b);
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyLibrary kl = new MyLibrary("Kendra");
        kl.run();

    }

}
