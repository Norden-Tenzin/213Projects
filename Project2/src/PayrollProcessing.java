package Project2.src;

import java.io.File; // Added TO BE REMOVED
import java.io.FileNotFoundException; // Added TO BE REMOVED
import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {

  public void run() {
    Company company = new Company();
    Scanner sc = new Scanner(System.in); // EDITED TO BE REMOVED

    System.out.println("Payroll Processing starts.");
    while (sc.hasNext()) {
      StringTokenizer input = new StringTokenizer(sc.nextLine(), " ");

      String command = "";
      String name = "";
      String department = "";
      String date = "";
      String payHours = "";
      String role = "";
      int totalInputs = input.countTokens();

      Profile employeeProfile = null;
      if (input.hasMoreTokens()) {
        command = input.nextToken();
        if (!command.equals(command.toUpperCase())) {
          System.out.println("Command '" + command + "' not supported!");
        }
      }
      if (input.hasMoreTokens()) {
        name = input.nextToken();
      }
      if (input.hasMoreTokens()) {
        department = input.nextToken();
      }
      if (input.hasMoreTokens()) {
        date = input.nextToken();
      }
      if (input.hasMoreTokens()) {
        payHours = input.nextToken();
      }
      if (input.hasMoreTokens()) {
        role = input.nextToken();
      }

      boolean onlyOneArgument = totalInputs == 1;

      // create an employee profile if a date exists.
      if (date.length() > 0) {
        employeeProfile = new Profile(name, department, new Date(date));
        if (!isValidProfile(employeeProfile)) continue;
      }

      if (command.equals("Q")) break;

      // When we have more than one argument passed, run this block:
      if (!onlyOneArgument) {
        // checks if number of arguments are valid for corresponding command.
        if (!validateArguments(command, totalInputs)) continue;

        switch (command) {
          case "AP":
            if (validatePayHours(payHours)) {
              Parttime employee = new Parttime(
                employeeProfile,
                Double.parseDouble(payHours)
              );
              if (!company.alreadyExists(employee)) {
                company.add(employee);
                System.out.println("Employee added.");
              } else {
                System.out.println("Employee is already in the list.");
              }
            } else continue;
            break;
          case "AF":
            if (validatePayHours(payHours)) {
              Fulltime employee = new Fulltime(
                employeeProfile,
                Double.parseDouble(payHours)
              );
              if (!company.alreadyExists(employee)) {
                company.add(employee);
                System.out.println("Employee added.");
              } else {
                System.out.println("Employee is already in the list.");
              }
            } else continue;
            break;
          case "AM":
            if (!validRole(role)) {
              System.out.println("invalid Management code.");
              break;
            }
            if (validatePayHours(payHours) && validRole(role)) {
              Management employee = new Management(
                employeeProfile,
                Double.parseDouble(payHours),
                Integer.parseInt(role)
              );

              if (!company.alreadyExists(employee)) {
                company.add(employee);
                System.out.println("Employee added.");
              } else {
                System.out.println("Employee is already in the list.");
              }
            } else {
              System.out.print("in else");
            }
            break;
          case "R":
            Employee removeEmployee = new Employee(employeeProfile);
            boolean wasRemoved = company.remove(removeEmployee);
            if (
              wasRemoved && company.alreadyExists(removeEmployee)
            ) System.out.println("Employee removed."); else if (
              company.getNumEmployee() == 0
            ) {
              System.out.println("Employee database is empty.");
            } else System.out.println("Employee does not exist.");
            break;
          case "S":
            if (company.getNumEmployee() == 0) {
              System.out.println("Employee database is empty.");
              break;
            } else if (!validatePayHours(payHours)) {
              System.out.println("Working hours cannot be negative.");
              break;
            } else if (validatePayHours(payHours)) {
              Parttime emp = new Parttime(employeeProfile, 0);
              emp.setHours(Integer.parseInt(payHours));
              company.setHours(emp);
              System.out.println("Working hours set.");
            } else {
              System.out.println(
                "Working hours NOT set.(Check Employee information)"
              );
            }
            break;
          default:
            System.out.println("Payroll Processing completed.");
        }
      }

      // When we only have one argument passed:
      if (onlyOneArgument) {
        switch (command) {
          case "PA":
            if (company.getNumEmployee() == 0) System.out.println(
              "Employee database is empty."
            ); else {
              System.out.println(
                "--Printing earning statements for all employees--"
              );
              company.print();
            }
            break;
          case "PD":
            if (company.getNumEmployee() == 0) System.out.println(
              "Employee database is empty."
            ); else {
              System.out.println(
                "--Printing earning statements by department--"
              );
              company.printByDepartment();
            }
            break;
          case "PH":
            if (company.getNumEmployee() == 0) System.out.println(
              "Employee database is empty."
            ); else {
              System.out.println(
                "--Printing earning statements by date hired--"
              );
              company.printByDate();
            }
            break;
          case "C":
            if (company.getNumEmployee() != 0) {
              company.processPayments();
              System.out.println("Calculation of employee payments is done.");
            } else if (company.getNumEmployee() == 0) {
              System.out.println("Employee database is empty.");
            }
            break;
          default:
            continue;
        }
      }
    }
    System.out.println("Payroll Processing complete.");
  }

  /**
   * Validates the profile of an employee by checking date and department
   * parameters.
   *
   * @param profile of the employee.
   * @return true if valid, false otherwise
   */
  public boolean isValidProfile(Profile profile) {
    if (!profile.validateDate()) {
      System.out.println("Invalid Date!");
      return false;
    }
    if (!profile.validateDepartment()) {
      System.out.println("Invalid department code.");
      return false;
    }
    return true;
  }

  /**
   * Validates the hourly pay of an employee by checking if it is negative
   *
   * @param payHours passed as a String which equal the hourly pay.
   * @return true if the hourly pay is valid, false otherwise.
   */
  public boolean validatePayHours(String payHours) {
    if (Double.parseDouble(payHours) < 0) return false;
    return true;
  }

  /**
   * Validates the number of arguments for any given command, excluding single
   * arguement commands. AP,AF,S all require 5 arguments. R requires 4 arguments.
   * AM requires 6 arguments.
   *
   * @param command is the command passed in(AP,AF,S,R,AM).
   * @param count   is the total number of arguments passed.
   * @return true if the count is equal to the expected argument count. False
   *         otherwise.
   */
  public boolean validateArguments(String command, int count) {
    int REMOVE_ARGS = 4; // standard number of args for removal
    int DEFAULT_ARGS = 5; // standard number of args for operations
    int MANAGER_ARGS = 6; // number of args for adding a mana
    boolean result = false;
    switch (command.trim()) {
      case "AP":
        result = count == DEFAULT_ARGS;
        break;
      case "AF":
        result = count == DEFAULT_ARGS;
        break;
      case "AM":
        result = count == MANAGER_ARGS;
        break;
      case "R":
        result = count == REMOVE_ARGS;
        break;
      case "S":
        if (count >= REMOVE_ARGS) {
          result = true;
        }
        break;
      default:
        result = false;
    }
    // if (!result) System.out.println("Invalid arguments.");
    return result;
  }

  /**
   * Validates the manager role by checking if the Parsed integer from the String
   * paramter is between 0 and 3.
   *
   * @param role is the String value passed as an argument.
   * @return true if the parsed Integer from the String is between 0 and 3. False
   *         if otherwise.
   */
  public boolean validRole(String role) {
    if (Integer.parseInt(role) < 1 || Integer.parseInt(role) > 3) {
      return false;
    }
    return true;
  }
}
