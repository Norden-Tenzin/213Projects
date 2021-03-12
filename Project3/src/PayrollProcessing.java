/**
 * Payroll processing method which will be used to take in input and process output.
 * Primarily focuses on AP,AF,AM,R,C,S,P,Q,PA,PD,PH commands.
 *  @Tenzin Norden, @Vedant Mehta
 */
package Project3.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {
   private Company company = new Company();
   private String[] output = new String[4];

   /**
    * Run method used to run PayrollProcessing.
    */
   private void grow() {
      String[] newArray = new String[output.length + 4];

      for (int i = 0; i < output.length; i++) {
         newArray[i] = output[i];
      }
      output = newArray;
   }

   public void add(String str) {
      if (output[output.length - 1] != null)
         grow();

      for (int i = 0; i < output.length; i++) {
         if (output[i] == null) {
            output[i] = str;
            break;
         }
      }
   }

   public String importFile() {
      Scanner sc;
      String output = "";

      try {
         File test = new File("Project3/src/database.txt"); // Added TO BE REMOVED
         sc = new Scanner(test);
         while (sc.hasNext()) {
            StringTokenizer input = new StringTokenizer(sc.nextLine(), ",");

            String command = "";
            String name = "";
            String lastName="";
            String firstName="";
            String department = "";
            String date = "";
            String payHours = "";
            String role = "";

            if (input.hasMoreTokens())
               command = "A" + input.nextToken();
            if (input.hasMoreTokens()){
               name = input.nextToken();
               firstName = name.split(" ")[0];
               lastName = name.split(" ")[1];
            }
            if (input.hasMoreTokens())
               department = input.nextToken();
            if (input.hasMoreTokens())
               date = input.nextToken();
            if (input.hasMoreTokens())
               payHours = input.nextToken();
            if (input.hasMoreTokens())
               role = input.nextToken();
            
            String extracted = command + " " + lastName + "," + firstName + " " + department + " " + date + " " + payHours + " "
               + role;
            output = output + run(extracted);
            
         }
      } catch (FileNotFoundException e) {
         System.out.println("File Not Found");
      }
      return output;
   }

   public String[] run(String inputCommands) {
      if (output[0] == null) {
         add("Payroll Processing starts.");
      }
      StringTokenizer input = new StringTokenizer(inputCommands, " ");
      String command = "";
      String name = "";
      String department = "";
      String date = "";
      String payHours = "";
      String role = "";
      int totalInputs = input.countTokens();
      Profile employeeProfile = null;

      // Check for valid command
      if (input.hasMoreTokens()) {
         command = input.nextToken();
         String[] commands = { "AP", "AF", "AM", "R", "C", "S", "P", "Q", "PA", "PD", "PH", };
         boolean isValidCommand = false;
         for (int i = 0; i < commands.length; i++) {
            if (command.equals(commands[i])) {
               isValidCommand = true;
               break;
            }
         }
         if (!isValidCommand) {
            add("Command '" + command + "' not supported!");
         }
      }

      // get tokenized input
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
         // if (!isValidProfile(employeeProfile))
         // continue;
      }

      // if (command.equals("Q"))
      // break;

      // When we have more than one argument passed, run this block:
      if (!onlyOneArgument) {
         // checks if number of arguments are valid for corresponding command.
         // if (!validateArguments(command, totalInputs))
         // continue;

         switch (command) {
         case "AP":
            if (validatePayHours(payHours)) {
               Parttime employee = new Parttime(employeeProfile, Double.parseDouble(payHours));
               if (!company.alreadyExists(employee)) {
                  company.add(employee);
                  add("Employee added.");
               } else {
                  add("Employee is already in the list.");
               }
            }
            break;
         case "AF":
            if (validatePayHours(payHours)) {
               Fulltime employee = new Fulltime(employeeProfile, Double.parseDouble(payHours));
               if (!company.alreadyExists(employee)) {
                  company.add(employee);
                  add("Employee added.");
               } else {
                  add("Employee is already in the list.");
               }
            }
            break;
         case "AM":
            if (!validRole(role)) {
               add("invalid Management code.");

               break;
            }
            if (validatePayHours(payHours) && validRole(role)) {
               Management employee = new Management(employeeProfile, Double.parseDouble(payHours),
                     Integer.parseInt(role));

               if (!company.alreadyExists(employee)) {
                  company.add(employee);
                  add("Employee added.");
               } else {
                  add("Employee is already in the list.");
               }
            }
            break;
         case "R":
            Employee removeEmployee = new Employee(employeeProfile);
            boolean wasRemoved = company.remove(removeEmployee);
            if (wasRemoved)
               add("Employee removed.");
            else if (company.getNumEmployee() == 0) {
               add("Employee database is empty.");
            } else
               add("Employee does not exist.");
            break;
         case "S":
            if (company.getNumEmployee() == 0) {
               add("Employee database is empty.");
               break;
            } else if (!validatePayHours(payHours)) {
               add("Working hours cannot be negative.");
               break;
            } else if (Integer.parseInt(payHours) > Parttime.OVERFLOWHOURS) {
               add("Invalid Hours: over 100.");
               break;
            } else if (validatePayHours(payHours)) {
               Parttime emp = new Parttime(employeeProfile, 0);
               emp.setHours(Integer.parseInt(payHours));
               company.setHours(emp);
               add("Working hours set.");
            }
            break;
         default:
            add("Payroll Processing completed.");
         }
      }

      // When we only have one argument passed:
      String printArr[];
      if (onlyOneArgument) {
         switch (command) {
         case "PA":
            this.output = new String[4];
            if (company.getNumEmployee() == 0)
               add("Employee database is empty.");
            else {
               add("--Printing earning statements for all employees--");
               printArr = company.print();
               for (String str : printArr) {
                  add(str);
               }
            }
            break;
         case "PD":
            this.output = new String[4];
            if (company.getNumEmployee() == 0)
               add("Employee database is empty.");
            else {
               add("--Printing earning statements by department--");
               printArr = company.printByDepartment();
               for (String str : printArr) {
                  add(str);
               }
            }
            break;
         case "PH":
            this.output = new String[4];
            if (company.getNumEmployee() == 0)
               add("Employee database is empty.");
            else {
               add("--Printing earning statements by date hired--");
               printArr = company.printByDate();
               for (String str : printArr) {
                  add(str);
               }
            }
            break;
         case "C":
            if (company.getNumEmployee() != 0) {
               company.processPayments();
               add("Calculation of employee payments is done.");
            } else if (company.getNumEmployee() == 0) {
               add("Employee database is empty.");
            }
            break;
         }
      }
      return output;
      // add(output, "Payroll Processing complete.");
   }

   /**
    * Validates the profile of an employee by checking date and department
    * parameters.
    *
    * @param profile of the employee.
    * @return true if valid, false otherwise
    */
   public boolean isValidProfile(Profile profile) {
      String date = profile.getDateHired().toString();
      if (!profile.validateDate()) {
         add(date + " is not a valid date!");
         return false;
      }
      String department = profile.getDepartment();
      if (!profile.validateDepartment()) {
         add(department + " is not a valid department code.");
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
