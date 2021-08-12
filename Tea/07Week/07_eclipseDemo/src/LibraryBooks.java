import java.util.ArrayList;

public class LibraryBooks {
	private  ArrayList<Book> myBooks;
	
	public LibraryBooks() {
		myBooks = new ArrayList<>(); // default constructor for arraylist
		//hard-code in a sample book or two
		myBooks.add(new Book("Circe", "Madeline Miller", 27.00));
		myBooks.add(new Book("The gifts of imperfection", "Brene Brown", 14.95));
		
	}
	
	public void addBook() {
		myBooks.add(new Book("The gifts of imperfection", "Brene Brown", 14.95));
		myBooks.add(new Book("The gifts of imperfection", "Brene Brown", 14.95));
	
	}
	public  void displayBooks() {
		// print each book in the list
		
		for(int i = 0; i < myBooks.size(); i++) {
			System.out.println(i + ":" + myBooks.get(i));
			  
		}
	}
	

	public static void main(String[] args) {
		//create an object of the type of thing we are going to run
		LibraryBooks myBooks = new LibraryBooks(); // right-click on a class in BlueJ
		LibraryBooks jBooks = new LibraryBooks();
		jBooks.addBook();
		//in BlueJ you would right-click to call methods
		// here you must explicitly call each method on the object you created
		System.out.println("HERE are Jessica's library books:");
		jBooks.displayBooks(); //methds based on an OBJECT
		System.out.println("HERE are my library books:");
		myBooks.displayBooks();
	}

}
