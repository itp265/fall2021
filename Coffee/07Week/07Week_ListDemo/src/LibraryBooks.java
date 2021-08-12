import java.util.ArrayList;

/**
 * Description of class goes here
 *
 * @author Kendra Walther
 * @version: Mar 4, 2021
 * email: kwalther@usc.edu
 * ITP 265, Spring 2021, Coffee Section
 * Homework xx
 */
public class LibraryBooks {
	private  ArrayList<Book> currentBooks;
	
	private static String THE_LIBRARY = "Usc library";
	
	public LibraryBooks() {
		currentBooks = new ArrayList<>( ); // default
	}
	public void addBooks() {
		// could get input from user, or could just hardcode some books
		Book b = new Book("Circe", "Madeline Miller", 27); //temp variable
		currentBooks.add(b); //adds to my list
		currentBooks.add(new Book("The gifts of imperfection", "Brene Brown", 14.95));
		
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		// the stuff that you do in BlueJ
		// right click on CLASS and make an object of the type we want to run
		System.out.println("Starting Library Book Project");
		LibraryBooks myBooks = new LibraryBooks();
		myBooks.addBooks(); // right-click ON RED OBJECT to call the method
		System.out.println("HERE ARE MY BOOKS:");
		myBooks.displayBooks();
		
		LibraryBooks marcusBooks = new LibraryBooks();
		marcusBooks.addBooks(); 
		marcusBooks.addBooks();
		System.out.println("HERE ARE Marcus's BOOKS:");
		marcusBooks.displayBooks();
		
		myBooks.insertNewBook(new Book("I'd give anything", "Marisa de los santos", 27.99));
		myBooks.insertNewBook(0, new Book("I'd give anything", "Marisa de los santos", 27.99));
		
		
		System.out.println("HERE ARE MY BOOKS:");
		myBooks.displayBooks();

	}
	private void insertNewBook(int i, Book book) {
		currentBooks.add(0, book);
		
	}
	private  void insertNewBook(Book book) {
		currentBooks.add(book);
		
	}
	private void displayBooks() {
		for(int i = 0; i < currentBooks.size(); i++) {
			System.out.println(i + ": " + currentBooks.get(i));
		}
		
	}

}
