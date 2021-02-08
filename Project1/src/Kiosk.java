import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

  public void run() {

    Library library = new Library();
    final int STARTING_BOOK_NUMBER = 10001;
    int increment = 0;

    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {

      StringTokenizer input = new StringTokenizer(sc.nextLine(), ",");

      
      String command = "";
      String bookKey = "";
      String date = "";

      // Check the input three times and set each command accordingly. 
      if (input.hasMoreTokens()) command = input.nextToken();
      if (input.hasMoreTokens()) bookKey = input.nextToken();
      if (input.hasMoreTokens()) date = input.nextToken();

      Boolean onlyOneArgument = bookKey.equals("") && date.equals("");

      if (command.equals("Q")) {
        break;
      }

      if (onlyOneArgument) {
        switch (command) {
          case "PA":
            if (library.getNumBooks() == 0) {
              System.out.println("Library catalog is empty!");
            } else {
              System.out.println("**List of books in the library.");
              library.print();
              System.out.println("**End of list");
            }
            break;

          case "PD":
            if (library.getNumBooks() == 0) {
              System.out.println("Bookshelf is empty!");
            } else {
              System.out.println("**List of books by date published.");
              library.printByDate();
              System.out.println("**End of list");
            }
            break;
          case "PN":
            if (library.getNumBooks() == 0) {
              System.out.println("Bookshelf is empty!");
            } else {
              System.out.println("**List of books by the book numbers.");
              library.printByNumber();
              System.out.println("**End of list");
            }
            break;
          default:
            System.out.println("Invalid command!");

        }
      } else {

        switch (command) {
          case "A":
            if (new Date(date).isValid()) {
              int bookNum = STARTING_BOOK_NUMBER + increment;
              Book book = new Book(Integer.toString(bookNum), bookKey, new Date(date));
              library.add(book);
              System.out.println(bookKey + " added to the library.");
              increment++;
            } else {
              System.out.println("Invalid Date!");
              continue;
            }
            break;
          case "R":
            Book removeBook = new Book(bookKey);

            Boolean wasRemoved = library.remove(removeBook);
            if (wasRemoved) {
              System.out.println("Book# " + bookKey + " removed");
            } else {
              System.out.println("Unable to remove, the library does not have this book.");
            }
            break;
          case "O":
            Book checkOutBook = new Book(bookKey);

            Boolean checkOut = library.checkOut(checkOutBook);
            if (checkOut) {
              System.out.println("You've checked out Book#" + bookKey + ". Enjoy!");
            } else {
              System.out.println("Book#" + bookKey + " is not available.");
            }
            break;
          case "I":
            Book returnsBook = new Book(bookKey);

            Boolean returns = library.returns(returnsBook);
            if (returns) {
              System.out.println("Book#" + bookKey + " return has completed. Thanks!");
            } else {
              System.out.println("Unable to return Book#" + bookKey + ".");
            }
            break;
          default:
            System.out.println("Invalid command!");

        }

      }

    }
    System.out.println("Kiosk session ended.");

  }
}