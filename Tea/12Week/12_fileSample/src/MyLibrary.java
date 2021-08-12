import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MyLibrary {

	private String name;
	private List<Book> bookList; //plain old list of books (List is an interface)
	private Map<String, List<Book>> bookMapByAuthor; //organized MAP of books author -> books by author

	public MyLibrary(String name) {
		this.name = name;
		bookList = new ArrayList<>(); //iniitialize -- concrete type
		bookMapByAuthor = new HashMap<>(); //initialize empty map
	}

	public void run() {

		System.out.println("Welcome to " + name + "'s Library!");

		// Load books from file into library
		loadBooksFromFile();
		System.out.println("Put all the books into bookList....");
		printBookList();

		System.out.println("Organize books by author! (make a map!)....");
		organizeBooks();
		printBookMap();

		System.out.println("Write Dr. Seuss books to a file...");
		writeAuthorBooksToFile("Dr. Seuss");
	}

	public void writeAuthorBooksToFile(String author) {
		// make the file connection

		if (bookMapByAuthor.containsKey(author)) {
			List<Book> books = bookMapByAuthor.get(author);

			try (FileOutputStream fout = new FileOutputStream("src/" + author + ".txt");
					PrintWriter out = new PrintWriter(fout)){

				for(Book b : books) {
					out.println(b.toFileString());
				}
			} // everything does auto-close
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else {
			System.out.println("No data to write to a file");
		}
	}
	public void printBookMap() {
		for(String author: this.bookMapByAuthor.keySet()) {
			int num = bookMapByAuthor.get(author).size();
			System.out.println(author + " Has " + num + " book(s) in my library");
			for(Book b: bookMapByAuthor.get(author)) {
				System.out.println("\t" + b.getTitle());
			}
		}
	}

	public void organizeBooks() {
		System.out.println("Going through all books in the list to organize by author");
		// Example: put one book into the map.
		String author = "Trevor Noah";
		Book b = new Book("Born a Crime", author, 350);
		// make a list for books by that author
		ArrayList<Book> list = new ArrayList<>();
		list.add(b); //put the one book in the list

		this.bookMapByAuthor.put(author, list);

		// Now do all the books from the bookList list of books....
		for(Book book: bookList) {
			// add that book to the map
			// how do we work with the list for ANY book we want to add.
			// is there already books by that author in my map? 
			// containsKey, get(key)
			String au = book.getAuthor();

			List<Book> alist = bookMapByAuthor.get(au);
			if(alist == null) { // new author to my collection
				alist = new ArrayList<>();
			}
			alist.add(book);
			bookMapByAuthor.put(au, alist); // put into map

			/*if(bookMapByAuthor.containsKey(au)) {
				// already books by that author, let's get the current list
				alist = bookMapByAuthor.get(au);
			}
			else {
				// new author in my library, no list exists for that author
				alist = new ArrayList<>();
			}
			alist.add(book);
				bookMapByAuthor.put(au, alist);
			 */


		}


	}

	public void printBookList() {
		for(int i = 0; i < bookList.size(); i++) {
			System.out.println(i + ": " + bookList.get(i));
		}
	}

	private void loadBooksFromFile() {
		ArrayList<String> data = FileReader.readFile("bin/books.txt");
		for(String s: data) {
			Book b;
			try {
				b = parseDataIntoBook(s);
				bookList.add(b);
			} catch (BadBookException e) {
				// quietly ifgnore the bad book
				System.out.println(e);
				//e.printStackTrace();
				System.out.println("Do you want to parse this line manually?");
				b = new Book("Charlotte's Web", "EB White", 192);
				bookList.add(b);
			}


		}

	}
	private Book parseDataIntoBook(String line) throws BadBookException {
		// s is a string representation of the book: title/author/numPages
		Scanner sc = new Scanner(line); // temp scanner to read one line of the data
		sc.useDelimiter("/");
		try {
			String title= sc.next();
			String author = sc.next();
			int numPages = sc.nextInt();
			Book b = new Book(title, author, numPages);
			sc.close();
			return b;
		}
		catch(Exception e) {
			//System.out.println("Error happened in program.");
			throw new BadBookException("Error reading in a line of data: " + line);
		}
	}

	public static void main(String[] args) {
		MyLibrary kl = new MyLibrary("Kendra");
		kl.run();

	}

}
