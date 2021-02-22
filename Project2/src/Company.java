package Project2.src;

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

public class Company {

  private Employee[] employees;
  private int numEmployee;
  final int STARTING_LIBRARY_SIZE = 4;

  /**
   * Default constructor. Sets default values.
   *
   */
  public Company() {
    employees = new Employee[STARTING_LIBRARY_SIZE];
    numEmployee = 0;
  }

  /**
   * Looks through the books array to find the book with the same number.
   *
   * @param book book Object
   * @return index of the book if book is found in the books array. otherwise -1.
   */
  private int find(Employee employee) {
    for (int i = 0; i < numEmployee; i++) {
      if (employees[i].equals(employee)) return i;
    }
    return -1;
  }

  /**
   * When called increases the size of the books array by STARTING_LIBRARY_SIZE
   */
  private void grow() {
    // Double the length of the array
    Employee[] newArray = new Employee[employees.length +
    STARTING_LIBRARY_SIZE];

    // Move elements into new array.
    for (int i = 0; i < numEmployee; i++) {
      newArray[i] = employees[i];
    }

    // Set books to new array
    employees = newArray;
  }

  /**
   * Adds book object into the books array
   *
   * @param book book Object
   */
  public void add(Employee employee) {
    // if the library is full, we double the size.
    if (employees[employees.length - 1] != null) grow();

    // Go through the array, add a book at the first empty spot.
    for (int i = 0; i < employees.length; i++) {
      if (employees[i] == null) {
        // once we find a null position, we set the index's value to the book and stop
        // the loop.
        employees[i] = employee;
        break;
      }
    }
    numEmployee++;
  }

  public boolean setHours(Employee employee) {
    int indexEmployee = find(employee);
    if (employees[indexEmployee] instanceof Parttime) {
      if (employee.getHours() >= 0) {
        employees[indexEmployee] = employee;
      }
    }
  }

  /**
   * Removes the given book object from the books array
   *
   * @param book book Object
   * @return true if books is removed, false otherwise.
   */
  public boolean remove(Employee employee) {
    int indexEmployee = find(employee);

    // If the book does not exist.
    if (indexEmployee == -1) return false;

    // shift all values in the library by one to the left.
    for (int i = indexEmployee + 1; i < employees.length; i++) {
      // Move current book back.
      employees[i - 1] = employees[i];
    }

    // since we removed, we need to decrease by 1.
    numEmployee--;
    return true;
  }

  /**
   * Prints the books array
   */
  public void print() {
    for (int i = 0; i < numEmployee; i++) {
      System.out.println(employees[i].toString());
    }
  }

  /**
   * Sorts the books array by Dates in ascending order, then prints the books
   * array
   */

  /*
   public void printByDate() {
      Employee temp;
      for (int i = 0; i <= this.books.length - 1; i++) {
         for (int j = i + 1; j <= this.books.length - 2; j++) {
            if (i == this.books.length - 1 || this.books[j] == null)
               break;
            // book date at i
            // employee.getProfile().getDateHired()

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
   */

  /**
   * Sorts the books array by Book number in assending order, then prints the
   * books array.
   */

  /*
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
   */

  /**
   * Helper method to get the number of books.
   *
   * @return the number of books in the books array
   */
  public int getNumEmployee() {
    return numEmployee;
  }
}
