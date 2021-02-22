package Project1.src;
/**
 * The Library class is a container for Book objects. It holds all the books in
 * the library and handles adding, removing, checkingout and returning. books:
 * its a list of Book objects, its a collection of all the books currently in
 * the library system. numBooks: its the number of books currently in the books
 * array. STARTING_LIBRARY_SIZE: its the initial size of the books array it is
 * also the size at which the array grows.
 *
 * @Tenzin Norden, @Vedant Mehta
 */

public class Library {

   private Book[] books;
   private int numBooks;
   final int STARTING_LIBRARY_SIZE = 4;

   /**
    * Default constructor. Sets default values.
    *
    */
   public Library() {
      books = new Book[STARTING_LIBRARY_SIZE];
      numBooks = 0;
   }

   /**
    * Looks through the books array to find the book with the same number.
    *
    * @param book book Object
    * @return index of the book if book is found in the books array. otherwise -1.
    */
   private int find(Book book) {
      for (int i = 0; i < numBooks; i++) {
         if (books[i].getNumber().equals(book.getNumber()))
            return i;
      }
      return -1;
   }

   /**
    * When called increases the size of the books array by STARTING_LIBRARY_SIZE
    */
   private void grow() {
      // Double the length of the array
      Book[] newArray = new Book[books.length + STARTING_LIBRARY_SIZE];

      // Move elements into new array.
      for (int i = 0; i < numBooks; i++) {
         newArray[i] = books[i];
      }

      // Set books to new array
      books = newArray;
   }

   /**
    * Adds book object into the books array
    * 
    * @param book book Object
    */
   public void add(Book book) {
      // if the library is full, we double the size.
      if (books[books.length - 1] != null)
         grow();

      // Go through the array, add a book at the first empty spot.
      for (int i = 0; i < books.length; i++) {
         if (books[i] == null) {
            // once we find a null position, we set the index's value to the book and stop
            // the loop.
            books[i] = book;
            break;
         }
      }
      numBooks++;
   }

   /**
    * Removes the given book object from the books array
    *
    * @param book book Object
    * @return true if books is removed, false otherwise.
    */
   public boolean remove(Book book) {
      int indexBook = find(book);

      // If the book does not exist.
      if (indexBook == -1)
         return false;

      // shift all values in the library by one to the left.
      for (int i = indexBook + 1; i < books.length; i++) {
         // Move current book back.
         books[i - 1] = books[i];
      }

      // since we removed, we need to decrease by 1.
      numBooks--;
      return true;
   }

   /**
    * Checks out the given book object from the books array
    *
    * @param book book Object
    * @return true if book is able to be checkedout, false otherwise.
    */
   public boolean checkOut(Book book) {
      int indexBook = find(book);

      // If the book does not exist or is already checked out.
      if (indexBook == -1 || books[indexBook].getCheckout() == true)
         return false;

      // Set checked out to true.
      books[indexBook].setCheckout(true);
      return true;
   }

   /**
    * Checksout the given book object from the books array
    *
    * @param book book Object
    * @return true if book is able to be checkedout, false otherwise.
    */
   public boolean returns(Book book) {
      int indexBook = find(book);

      // Check if book exists or if the book is not checked out
      if (indexBook == -1 || books[indexBook].getCheckout() == false)
         return false;

      // Set checked out to false now that the book is returned
      books[indexBook].setCheckout(false);
      return true;
   }

   /**
    * Prints the books array
    */
   public void print() {
      for (int i = 0; i < numBooks; i++) {
         System.out.println(books[i].toString());
      }
   }

   /**
    * Sorts the books array by Dates in ascending order, then prints the books
    * array
    */
   public void printByDate() {
      Book temp;
      for (int i = 0; i <= this.books.length - 1; i++) {
         for (int j = i + 1; j <= this.books.length - 2; j++) {
            if (i == this.books.length - 1 || this.books[j] == null)
               break;
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
   } // print the list of books by datePublished (ascending)

   /**
    * Sorts the books array by Book number in assending order, then prints the
    * books array.
    */
   public void printByNumber() {
      Book temp;
      for (int i = 0; i <= this.books.length - 1; i++) {
         for (int j = i + 1; j <= this.books.length - 2; j++) {
            if (i == this.books.length - 1 || this.books[j] == null)
               break;
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
   } // print the list of books by number (ascending)

   /**
    * Helper method to get the number of books.
    * 
    * @return the number of books in the books array
    */
   public int getNumBooks() {
      return numBooks;
   }
}
