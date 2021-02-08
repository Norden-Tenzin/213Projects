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

  public Book(String number) {
    this.number = number;
    this.name = "";
    this.datePublished = new Date();
    checkedOut = false;
  }

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

  @Override
  public String toString() {
    return ("Book#" + number + "::" + name + "::" + datePublished.toString() + "::" + isAvailable());
  }

  public String getNumber() {
    return number;
  }

  public Date getDate() {
    return datePublished;
  }

  public void setCheckout(Boolean checkedOut) {
    this.checkedOut = checkedOut;
  }

  public Boolean getCheckout() {
    return checkedOut;
  }

}
