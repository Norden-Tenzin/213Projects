package Project2.src;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {

  public void run() {
    Company company = new Company();
    Scanner sc = new Scanner(System.in);

    System.out.println("Payroll Processing starts.");

    while (sc.hasNext()) {

      // TODO:need to make it work for all whitespace

      //TODO: handle newline
      StringTokenizer input = new StringTokenizer(sc.nextLine(), " ");

      String command = "";
      String name = "";
      String department = "";
      String date = "";
      String payHours = "";
      String role = "";
      int totalInputs = input.countTokens();

      Profile employeeProfile = null;
      if (input.hasMoreTokens())
        command = input.nextToken();
      if (input.hasMoreTokens())
        name = input.nextToken();
      if (input.hasMoreTokens())
        department = input.nextToken();
      if (input.hasMoreTokens())
        date = input.nextToken();
      if (input.hasMoreTokens())
        payHours = input.nextToken();
      if (input.hasMoreTokens())
        role = input.nextToken();

      boolean onlyOneArgument = totalInputs == 1;

      if (command.equals("Q"))
        break;

      // When we have more than one argument passed, run this block:
      if (!onlyOneArgument) {
        // checks if number of arguments are valid for corresponding command.
        if (!validateArguments(command, totalInputs))
          continue;
        // create an employee profile if a date exists.
        else if (date.length() > 0) {
          employeeProfile = new Profile(name, department, new Date(date));
          if (!isValidProfile(employeeProfile))
            continue;
        }

        switch (command) {
          case "AP":
            if (validatePayHours(payHours)) {
              Parttime employee = new Parttime(employeeProfile, Double.parseDouble(payHours));
              if (!company.alreadyExists(employee)) {
                company.add(employee);
                System.out.println("Employee added.");
              } else {
                System.out.println("Employee is already in the list.");
              }
            } else
              continue;
            break;
          case "AF":
            if (validatePayHours(payHours)) {
              Fulltime employee = new Fulltime(employeeProfile, Double.parseDouble(payHours));
              if (!company.alreadyExists(employee)) {
                company.add(employee);
                System.out.println("Employee added.");
              } else {
                System.out.println("Employee is already in the list.");
              }
            } else
              continue;
            break;
          case "AM":
            if (validatePayHours(payHours) && validRole(role)) {
              Management employee = new Management(employeeProfile, Double.parseDouble(payHours),
                  Integer.parseInt(role));
              if (!company.alreadyExists(employee)) {
                company.add(employee);
                System.out.println("Employee added.");
              } else {
                System.out.println("Employee is already in the list.");
              }
            } else
              continue;
            break;
          // TODO: IDK WHY, BUT BROKEN
          case "R":
            Employee removeEmployee = new Employee(employeeProfile);
            boolean wasRemoved = company.remove(removeEmployee);
            if (wasRemoved && company.alreadyExists(removeEmployee))
              System.out.println("Employee removed.");
            else
              System.out.println("Employee does not exist.");
            break;
          case "S":
            if(Integer.parseInt(payHours) < 0){
              System.out.println("Working hours cannot be negative.");
              break;
            } 
            if(company.setEmployeeHours(new Employee(employeeProfile), Integer.parseInt(payHours))){
              System.out.println("Working hours set.");
            } else {
              System.out.println("Working hours NOT set.(Check Employee information)");
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
            if (company.getNumEmployee() == 0)
              System.out.println("Employee database is empty.");
            else {
              System.out.println("--Printing earning statements for all employees--");
              company.print();
            }
            break;
          case "PD":
            if (company.getNumEmployee() == 0)
              System.out.println("Employee database is empty.");
            else {
              System.out.println("--Printing earning statements by department--");
              company.getNumEmployee();
            }
            break;
          case "PH":
            if (company.getNumEmployee() == 0)
              System.out.println("Employee database is empty.");
            else {
              System.out.println("--Printing earning statements by date hired--");
              company.getNumEmployee();
            }
            break;
          case "C":
            company.processPayments();
            System.out.println("Calculation of employee payments is done.");
            break;
          default:
            System.out.println("Invalid command!");
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
    if (Double.parseDouble(payHours) < 0)
      return false;
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
    boolean result;
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
        result = count == DEFAULT_ARGS;
        break;
      default:
        result = false;
    }
    if (!result)
      System.out.println("Invalid arguments.");
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
    if (Integer.parseInt(role) < 0 || Integer.parseInt(role) > 3) {
      return false;
    }
    return true;
  }

}
