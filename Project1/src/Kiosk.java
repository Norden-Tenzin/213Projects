package Project1.src;
/**
 * Kiosk class will be used to run library.
 * All functions and commands are through the run() method. This will be useful later for multithreading.
 *
 *  @Tenzin Norden, @Vedant Mehta
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

   public void run() {

      Library library = new Library();
      // Starting book number
      final int STARTING_BOOK_NUMBER = 10001;
      // Increment the book number
      int incrementBook = 0;

      Scanner sc = new Scanner(System.in);
      // Default message when starting run.
      System.out.println("Library Kiosk running.");

      // Keep running as long as user enters line
      while (sc.hasNext()) {

         // Tokenize the string and split by ,
         StringTokenizer input = new StringTokenizer(sc.nextLine(), ",");

         String command = "";
         String bookKey = "";
         String date = "";

         // Check the input three times and set each command accordingly.
         if (input.hasMoreTokens())
            command = input.nextToken(); // command is the first token value
         if (input.hasMoreTokens())
            bookKey = input.nextToken(); // bookKey can be either book number or name
         if (input.hasMoreTokens())
            date = input.nextToken(); // Date will be the third token value

         // helper boolean to check if there is only one argument
         boolean onlyOneArgument = bookKey.equals("") && date.equals("");

         // Base case: If Q, quit the program
         if (command.equals("Q")) {
            break;
         }

         // If there is only one argument passed ie "PA", "PD", "PN"
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
            // If there is more than one command ie A, R, O, I commands.
            switch (command) {
               case "A":
                  if (new Date(date).isValid()) {
                     // Set the book number equal to 10001 + the current increment number
                     int bookNum = STARTING_BOOK_NUMBER + incrementBook;

                     // Add the new book to the library
                     Book book = new Book(Integer.toString(bookNum), bookKey, new Date(date));
                     library.add(book);

                     System.out.println(bookKey + " added to the library.");
                     incrementBook++;
                  } else {
                     System.out.println("Invalid Date!");
                     continue;
                  }
                  break;

               case "R":
                  Book removeBook = new Book(bookKey);
                  boolean wasRemoved = library.remove(removeBook);
                  // check to see if the book was removed
                  if (wasRemoved)
                     System.out.println("Book# " + bookKey + " removed");
                  else
                     System.out.println("Unable to remove, the library does not have this book.");
                  break;

               case "O":
                  Book checkOutBook = new Book(bookKey);
                  // library.checkOut returns true if the book was able to be checked out.
                  boolean checkOut = library.checkOut(checkOutBook);
                  if (checkOut)
                     System.out.println("You've checked out Book#" + bookKey + ". Enjoy!");
                  else
                     System.out.println("Book#" + bookKey + " is not available.");
                  break;

               case "I":
                  Book returnsBook = new Book(bookKey);
                  // library.returns returns true if the book was able to be returned.
                  boolean returns = library.returns(returnsBook);
                  if (returns)
                     System.out.println("Book#" + bookKey + " return has completed. Thanks!");
                  else
                     System.out.println("Unable to return Book#" + bookKey + ".");
                  break;

               default:
                  System.out.println("Invalid command!");

            }

         }

      }
      System.out.println("Kiosk session ended.");

   }
}