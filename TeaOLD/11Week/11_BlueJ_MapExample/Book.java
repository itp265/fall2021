import java.io.Serializable;

/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265, Spring 2021
 * Email: kwalther@usc.edu
 *
 */
public class Book implements Comparable<Book>, Serializable{
    private String title;
    private String author;
    private int numPages;
    private double price;
    /**
     * @param title
     * @param author
     * @param numSold
     */
    public Book(String title, String author, int numPages) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        price = 9.99;
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
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }
    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumPages() {
        return numPages;
    }


    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", numPages=" + numPages + "]";
    }





    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + numPages;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }




    @Override
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
        if (numPages != other.numPages)
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




    @Override
    public int compareTo(Book o) {
        
    //    System.err.println("In compareTo, Looking at: " + this.title 
    //            + " AND comparing to " + o.title);
        
        // int tells us >, < , = (pos, neg, 0 number)
        // numpages, price, title, author: Order we want
        int diff =this.numPages - o.numPages; 

        if(diff == 0) {
            // equal for now (same num sold), look at more characteriscs
            double num = this.price - o.price;
            if(Math.abs(num) < .001) { //esentially 0
                //look at more characteristics
                diff = this.title.compareTo(o.title);
                if(diff == 0) {
                    diff = this.author.compareTo(o.author);
                }
            }
            else if (num <0) {
                diff = -1; // any negative number
            }
            else { // > 0
                diff = 1; // any positive number
            }
        }
    
        return diff;
    }
    
    public String fileString() {
        //Carry on/Rainbow Rowell/528
        
        return title + "/" + author + "/"+ this.numPages;
    }
}
