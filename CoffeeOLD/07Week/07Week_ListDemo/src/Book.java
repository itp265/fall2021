/*
 * BOOK is POJO (plain old java object) - something that stores data for us
 * maybe has a few other methods, but most of it is about data storage
 */

/**   <- type this and hit enter and the comment pops up!
 * 
 * Description of class goes here
 *
 * @author Kendra Walther
 * @version: Mar 4, 2021
 * email: kwalther@usc.edu
 * ITP 265, Spring 2021, Coffee Section
 * Homework xx
 */
public class Book {
  // instance variables here
	
	
	private String title;
	private String author;
	private double price;
	
	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public Book(String title, String author) {
		this(title, author, 9.99);
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return "Book: " + title + " by " + author + ", price= $" + price ;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	// public boolean equals(Book other) -- SIMPLIFIED VERSION
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

}
