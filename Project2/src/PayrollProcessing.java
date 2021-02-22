package Project2.src;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {

  public void run() {
    Company company = new Company();
    Scanner sc = new Scanner(System.in);
    // Default message when starting run.
    System.out.println("Library Kiosk running.");

    // Keep running as long as user enters line
    while (sc.hasNext()) {
      // Tokenize the string and split by ,
      StringTokenizer input = new StringTokenizer(sc.nextLine(), ",");

      String command = "";
      String name = "";
      String department = "";
      String date = "";
      String payHours = "";
      String role = "";

      // Check the input three times and set each command accordingly.
      if (input.hasMoreTokens()) command = input.nextToken(); // command is the first token value
      if (input.hasMoreTokens()) name = input.nextToken(); // bookKey can be either book number or name
      if (input.hasMoreTokens()) department = input.nextToken(); // Date will be the third token value
      if (input.hasMoreTokens()) date = input.nextToken();
      if (input.hasMoreTokens()) payHours = input.nextToken();
      if (input.hasMoreTokens()) role = input.nextToken();

      // helper boolean to check if there is only one argument
      boolean onlyOneArgument = name.equals("") && department.equals("");

      // Base case: If Q, quit the program
      if (command.equals("Q")) {
        break;
      }

      // If there is only one argument passed ie "PA", "PD", "PN"
      if (onlyOneArgument) {
        switch (command) {
          case "PA":
            if (company.getNumEmployee() == 0) {
              System.out.println("Library catalog is empty!");
            } else {
              System.out.println("**List of books in the library.");
              company.print();
              System.out.println("**End of list");
            }
            break;
          case "PD":
            if (company.getNumEmployee() == 0) {
              System.out.println("Bookshelf is empty!");
            } else {
              System.out.println("**List of books by date published.");
              company.getNumEmployee();
              System.out.println("**End of list");
            }
            break;
          case "PN":
            if (company.getNumEmployee() == 0) {
              System.out.println("Bookshelf is empty!");
            } else {
              System.out.println("**List of books by the book numbers.");
              company.getNumEmployee();
              System.out.println("**End of list");
            }
            break;
          default:
            System.out.println("Invalid command!");
        }
      } else {
        // If there is more than one command ie A, R, O, I commands.
        switch (command) {
          case "AP":
            if (new Date(date).isValid()) {
              // Add the new book to the library
              Parttime employee = new Parttime(
                new Profile(name, department, new Date(date)),
                Double.parseDouble(payHours)
              );
              company.add(employee);
              System.out.println("Employee added.");
            } else {
              System.out.println("Invalid Date!");
              continue;
            }
            break;
          case "AF":
            if (new Date(date).isValid()) {
              // Add the new book to the library
              Fulltime employee = new Fulltime(
                new Profile(name, department, new Date(date)),
                Double.parseDouble(payHours)
              );
              company.add(employee);
              System.out.println("Employee added.");
            } else {
              System.out.println("Invalid Date!");
              continue;
            }
            break;
          case "AM":
            if (new Date(date).isValid()) {
              // Add the new book to the library
              Fulltime employee = new Fulltime(
                new Profile(name, department, new Date(date)),
                Double.parseDouble(payHours),
                Integer.parseInt(role)
              );
              company.add(employee);
              System.out.println("Employee added.");
            } else {
              System.out.println("Invalid Date!");
              continue;
            }
            break;
          case "R":
            Employee removeEmployee = new Employee(
              new Profile(name, department, new Date(date))
            );
            boolean wasRemoved = company.remove(removeEmployee);
            // check to see if the book was removed
            if (wasRemoved) System.out.println(
              "Employee removed."
            ); else System.out.println(
              "Employee does not exist." // TODO list is empty
            );
            break;
          case "C":
            break;
          case "S":
            company.setEmployeeHours(new Employee(new Profile(name, department, new Date(date))), Integer.parseInt(payHours));
            break;
          default:
            System.out.println("Payroll Processing completed.");
        }
      }
    }
    System.out.println("Kiosk session ended.");
  }
}
