package Project2.src;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {

  public void run() {
    Company company = new Company();
    Scanner sc = new Scanner(System.in);

    System.out.println("Library Kiosk running.");

    while (sc.hasNext()) {

      // TODO:need to make it work for all whitespace
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

      boolean onlyOneArgument = name.equals("");

      // create an employee profile if a date exists.
      if (date.length() > 0) {
        employeeProfile = new Profile(name, department, new Date(date));
        if (!isValidProfile(employeeProfile))
          continue;
      }

      if (command.equals("Q")) break;

      if (!onlyOneArgument) {

        // checks if number of arguments are valid for corrispoinding command.
        if (!validateArguments(command, totalInputs)) continue;

        switch (command) {
          case "AP":
            if (validatePayHours(payHours)) {
              Parttime employee = new Parttime(employeeProfile, Double.parseDouble(payHours));
              company.add(employee);
              System.out.println("Employee added.");
            } else
              continue;
            break;
          case "AF":
            if (validatePayHours(payHours)) {
              Fulltime employee = new Fulltime(employeeProfile, Double.parseDouble(payHours));
              company.add(employee);
              System.out.println("Employee added.");
            } else
              continue;
            break;
          case "AM":
            if (validatePayHours(payHours) || !validRole(role)) {
              Management employee = new Management(employeeProfile, Double.parseDouble(payHours),
                  Integer.parseInt(role));
              company.add(employee);
              System.out.println("Employee added.");
            } else
              continue;
            break;
          case "R":
            Employee removeEmployee = new Employee(employeeProfile);
            boolean wasRemoved = company.remove(removeEmployee);
            if (wasRemoved)
              System.out.println("Employee removed.");
            else
              System.out.println("Employee does not exist.");
            break;
          case "S":
            company.setEmployeeHours(new Employee(employeeProfile), Integer.parseInt(payHours));
            break;
          default:
            System.out.println("Payroll Processing completed.");
        }
      } else
        singleCommands(command, company);
    }
    System.out.println("Payroll Processing complete.");
  }

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

  public boolean validatePayHours(String payHours) {
    if (Double.parseDouble(payHours) < 0)
      return false;
    return true;
  }

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
        result =  count == DEFAULT_ARGS;
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
        System.out.println("Invalid arguments.");
        result = false;
    }
    if(!result) System.out.println("Invalid arguments.");
    return result;
  }

  public boolean validRole(String role) {
    if (Integer.parseInt(role) < 0 || Integer.parseInt(role) > 3) {
      return false;
    }
    return true;
  }

  public static void singleCommands(String command, Company company) {
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
        System.out.println("TODO: CALCULATE PAYMENTS");
        break;
      default:
        System.out.println("Invalid command!");
    }
  }

}
