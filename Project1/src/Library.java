package Project1.src;

public class Library {

  private Book[] books; // array-based implementation of the bag data structure
  private int numBooks; // the number of books currently in the bag

  public Library() {
    this.books = new Book[4];
    this.numBooks = 0;
  } //default constructor to create an empty bag

  private int find(Book book) {} // helper method to find a book in the bag

  private void grow() {
    int len = this.books.length;
    Book newBag[] = new Book[len + 4];
    for(int i = 0; i <= len-1; i++){
      newBag[i] = this.books[i];
    }
    this.books = newBag;
  } // helper method to grow the capacity by 4

  public void add(Book book) {}

  public boolean remove(Book book) {}

  public boolean checkOut(Book book) {}

  public boolean returns(Book book) {}

  public void print() {} //print the list of books in the bag

  public void printByDate() {} //print the list of books by datePublished (ascending)

  public void printByNumber() {} //print the list of books by number (ascending)
}
