package Project1.src;

import jdk.nashorn.internal.ir.IndexNode;

public class Library {

  private Book[] books; // array-based implementation of the bag data structure
  private int numBooks; // the number of books currently in the bag

  public Library() {
    this.books = new Book[4];
    this.numBooks = 0;
  } //default constructor to create an empty bag

  private int find(Book book) {
    int indexBook = -1;
    for(int i = 0; i <= this.books.length-1; i++){
      if(book.equals(this.books[i])){
        indexBook = i;
      }
    }
    return indexBook;
  } // helper method to find a book in the bag

  private void grow() {
    int len = this.books.length;
    Book newBag[] = new Book[len + 4];
    for(int i = 0; i <= len-1; i++){
      newBag[i] = this.books[i];
    }
    this.books = newBag;
  } // helper method to grow the capacity by 4

  public void add(Book book) {
    boolean availableSpace = false;
    int indexSpace = 0;
    for(int i = 0; i <= this.books.length; i++){
      if(this.books[i] == null){
        availableSpace = true;
        indexSpace = i;
        break;
      }
    }
    if(availableSpace){
      this.books[indexSpace] = book;
    }else{
      this.grow();
      add(book);
    }
  } // adds book to bag. if bag is full grow the bag and then add

  public boolean remove(Book book) {
    int indexBook = find(book);
    if(indexBook != -1){
      for(int i = 0; i <= this.books.length-1; i++){
        if(i >= indexBook && i < this.books.length-1){
          this.books[i] = this.books[i+1];
        }
      }
      this.books[this.books.length-1] = null;
      return true;
    } else {
      return false;
    }
  } // if bag has book remove it. true if removed else false.

  public boolean checkOut(Book book) {}

  public boolean returns(Book book) {}

  public void print() {
    for(int i = 0; i <= this.books.length-1; i++){
      System.out.println(this.books[0].toString());
    }
  } //print the list of books in the bag

  public void printByDate() {} //print the list of books by datePublished (ascending)

  public void printByNumber() {} //print the list of books by number (ascending)
}
