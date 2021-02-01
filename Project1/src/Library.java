/**
 * The Library class is a container for Book objects.
 * @Tenzin Norden, @Vedant Mehta
 */

package Project1.src;

public class Library {

  private Book[] books; // array-based implementation of the bag data structure
  private int numBooks; // the number of books currently in the bag

  public Library() {
    this.books = new Book[4];
    this.numBooks = 10001;
  } // default constructor to create an empty bag

  private int find(Book book) {
    int indexBook = -1;
    for (int i = 0; i <= this.books.length - 1; i++) {
      if (book.equals(this.books[i])) {
        indexBook = i;
      }
    }
    return indexBook;
  } // helper method to find a book in the bag

  private void grow() {
    int len = this.books.length;
    Book newBag[] = new Book[len + 4];
    for (int i = 0; i <= len - 1; i++) {
      newBag[i] = this.books[i];
    }
    this.books = newBag;
  } // helper method to grow the capacity by 4

  public void add(Book book) {
    boolean availableSpace = false;
    int indexSpace = 0;
    book.setNumber(String.valueOf(this.numBooks));
    this.numBooks++;
    for (int i = 0; i <= this.books.length; i++) {
      if (this.books[i] == null) {
        availableSpace = true;
        indexSpace = i;
        break;
      }
    }
    if (availableSpace) {
      this.books[indexSpace] = book;
    } else {
      this.grow();
      add(book);
    }
  } // adds book to bag. if bag is full grow the bag and then add

  public boolean remove(Book book) {
    int indexBook = find(book);
    if (indexBook != -1) {
      for (int i = 0; i <= this.books.length - 1; i++) {
        if (i >= indexBook && i < this.books.length - 1) {
          this.books[i] = this.books[i + 1];
        }
      }
      this.books[this.books.length - 1] = null;
      return true;
    } else {
      return false;
    }
  } // if bag has book remove it. true if removed else false.

  public boolean checkOut(Book book) {
    boolean foundBook = false;
    for (int i = 0; i <= this.books.length - 1; i++) {
      if (book.equals(this.books[i])) {
        this.books[i].setCheckout(true);
        foundBook = true;
        break;
      }
    }
    return foundBook;
  } // set the checkout to true

  public boolean returns(Book book) {
    boolean foundBook = false;
    for (int i = 0; i <= this.books.length - 1; i++) {
      if (book.equals(this.books[i])) {
        this.books[i].setCheckout(false);
        foundBook = true;
        break;
      }
    }
    return foundBook;
  } // set the checkout to false

  // POTENTIAL PROBLEM: what if there is only one book in the library?
  public void print() {
    for (int i = 0; i <= this.books.length - 1; i++) {
      if (this.books[i] != null) {
        System.out.println(this.books[i].toString());
      }
    }
  } // print the list of books in the bag

  public void printByDate() {
    Book temp;
    for (int i = 0; i <= this.books.length - 1; i++) {
      if (i == this.books.length - 1 || this.books[i] == null) break;
      for (int j = i + 1; j <= this.books.length - 2; j++) {
        // book date at i 
        int bookYearI = this.books[i].getDate().getYear();
        int bookMonthI = this.books[i].getDate().getMonth();
        int bookDayI = this.books[i].getDate().getDay();
        // book date at j
        int bookYearJ = this.books[j].getDate().getYear();
        int bookMonthJ = this.books[j].getDate().getMonth();
        int bookDayJ = this.books[j].getDate().getDay();
        if (bookYearI > bookYearJ) {
          temp = this.books[i];
          this.books[i] = this.books[j];
          this.books[j] = temp;
        } else if (bookYearI == bookYearJ) {
          if (bookMonthI > bookMonthJ) {
            temp = this.books[i];
            this.books[i] = this.books[j];
            this.books[j] = temp;
          } else if (bookMonthI == bookMonthJ) {
            if (bookDayI > bookDayJ) {
              temp = this.books[i];
              this.books[i] = this.books[j];
              this.books[j] = temp;
            }
          }
        }
      }
    }
    this.print();
  } //print the list of books by datePublished (ascending)

  public void printByNumber() { 
    Book temp;
    for (int i = 0; i <= this.books.length - 1; i++) {
      if (i == this.books.length - 1 || this.books[i] == null) break;
      for (int j = i + 1; j <= this.books.length - 2; j++) {
        int bookI = Integer.parseInt(this.books[i].getNumber());
        int bookJ = Integer.parseInt(this.books[j].getNumber());
        if (bookI > bookJ) {
          temp = this.books[i];
          this.books[i] = this.books[j];
          this.books[j] = temp;
        }
      }
    }
    this.print();
  } //print the list of books by number (ascending)
}
