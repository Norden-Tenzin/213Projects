/**
 * A book class which holds the state of any given book in the Library class.
 * Book number: unique key associated with each book Name: The title of each
 * book. CheckedOut: determines if the book is checked out from the library.
 * Date Published: data associated with the publication of the book.
 *
 * @Tenzin Norden, @Vedant Mehta
 */

public class Book {
   private String number;
   private String name;
   private boolean checkedOut;
   private Date datePublished;

   /**
    * Default constructor which only takes in number. Sets default values.
    *
    * @param number
    */
   public Book(String number) {
      this.number = number;
      this.name = "";
      this.datePublished = new Date();
      checkedOut = false;
   }

   /**
    * Overloaded constructor which takes in number,name,date published
    *
    * @param number        is the book number
    * @param name          is the book name
    * @param datePublished is the specified Date Class of the publish date
    */
   public Book(String number, String name, Date datePublished) {
      this.number = number;
      this.name = name;
      this.datePublished = datePublished;
      checkedOut = false;
   }

   /**
    * Checks to see if the book is checked out.
    *
    * @return "is not available" if the book is unavailable, "is available"
    *         otherwise.
    */
   public String isAvailable() {
      if (this.checkedOut) {
         return "is not available";
      } else
         return "is available";
   }

   /**
    * Returns the book as a string including its information.
    *
    * @return the Book's information in a string format
    */
   @Override
   public String toString() {
      return ("Book#" + number + "::" + name + "::" + datePublished.toString() + "::" + isAvailable());
   }

   /**
    * Helper method for getting the book number.
    *
    * @return the book number
    */
   public String getNumber() {
      return number;
   }

   /**
    * Helper method for getting the book's publish date
    *
    * @return the book's publish date
    */
   public Date getDate() {
      return datePublished;
   }

   /**
    * Sets the book checkout status
    */
   public void setCheckout(Boolean checkedOut) {
      this.checkedOut = checkedOut;
   }

   /**
    * Gets the book checkout status
    */
   public Boolean getCheckout() {
      return checkedOut;
   }

}
