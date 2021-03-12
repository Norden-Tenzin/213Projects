package Project3.src;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The Company class is a container for Employee objects. It holds all the
 * employees in the Company and handles adding, removing, setting Hours and
 * processing payments. employees: its a list of Employee objects, its a
 * collection of all the employees currently in the Company system. numEmployee:
 * its the number of employees currently in the employees array.
 * STARTING_LIBRARY_SIZE: its the initial size of the employees array it is also
 * the size at which the array grows.
 *
 * @Tenzin Norden, @Vedant Mehta
 */

public class Company {

   private Employee[] employees;
   private int numEmployee;
   final int STARTING_COMPANY_SIZE = 4;

   /**
    * Default constructor. Sets default values.
    *
    */
   public Company() {
      employees = new Employee[STARTING_COMPANY_SIZE];
      numEmployee = 0;
   }

   /**
    * Looks through the employees array to find the employee with the same profile.
    *
    * @param employee employee Object
    * @return index of the employee if employee is found in the employees array.
    *         otherwise -1.
    */
   private int find(Employee employee) {
      for (int i = 0; i < numEmployee; i++) {
         if (employee.equals(employees[i]))
            return i;
      }
      return -1;
   }

   /**
    * When called increases the size of the employees array by
    * STARTING_COMPANY_SIZE
    */
   private void grow() {
      Employee[] newArray = new Employee[employees.length + STARTING_COMPANY_SIZE];

      for (int i = 0; i < numEmployee; i++) {
         newArray[i] = employees[i];
      }
      employees = newArray;
   }

   /**
    * Adds Employee object into the employees array
    *
    * @param employee Employee Object
    * @return true if employee is added false otherwise
    */
   public boolean add(Employee employee) {
      if (employees[employees.length - 1] != null)
         grow();

      if (find(employee) != -1)
         return false;

      for (int i = 0; i < employees.length; i++) {
         if (employees[i] == null) {
            employees[i] = employee;
            numEmployee++;
            return true;
         }
      }
      return false;
   }

   /**
    * Remove the given Employee object from the employees array
    *
    * @param employee Employee Object
    * @return true if employee is removed false otherwise
    */
   public boolean remove(Employee employee) {
      int indexEmployee = find(employee);
      if (indexEmployee == -1) {
         return false;
      }
      for (int i = indexEmployee + 1; i < employees.length; i++) {
         employees[i - 1] = employees[i];
      }
      if (numEmployee >= 0) {
         numEmployee--;
      }
      return true;
   }

   /**
    * Sets the Hours Worked of a Parttime employee
    *
    * @param employee Employee Object
    * @return true if it can be set otherwise false
    */
   public boolean setHours(Employee employee) {
      int indexEmployee = find(employee);

      if (indexEmployee != -1 && employees[indexEmployee] instanceof Parttime) {
         ((Parttime) employees[indexEmployee]).setHours(((Parttime) employee).getHours());
         return true;
      }
      return false;
   }

   /**
    * Processes the payements of all the employees in the company
    *
    */
   public void processPayments() {
      for (int i = 0; i < numEmployee; i++) {
         if (employees[i] instanceof Parttime) {
            ((Parttime) employees[i]).calculatePayment();
         } else if (employees[i] instanceof Fulltime) {
            ((Fulltime) employees[i]).calculatePayment();
         } else if (employees[i] instanceof Management) {
            ((Management) employees[i]).calculatePayment();
         }
      }
   }

   /**
    * Prints the employees array as it is currently
    *
    */
   public String print() {
      String printOutput = "";
      for (int i = 0; i < numEmployee; i++) {
         printOutput += employees[i].toString() + "\n";
      }
      return printOutput;
   }

   /**
    * Aranges the employees array to be sorted by department name then prints the
    * employees array
    *
    */
   public String printByDepartment() {
      Employee temp;
      for (int i = 0; i <= this.employees.length - 1; i++) {
         for (int j = i + 1; j <= this.employees.length - 2; j++) {
            if (i == this.employees.length - 1 || this.employees[j] == null)
               break; // no employees
            // I
            String departmentI = this.employees[i].getProfile().getDepartment();
            // J
            String departmentJ = this.employees[j].getProfile().getDepartment();
            if (departmentI.compareTo(departmentJ) > 0) {
               temp = this.employees[i];
               this.employees[i] = this.employees[j];
               this.employees[j] = temp;
            }
         }
      }
      return this.print();
   }

   /**
    * Aranges the employees array to be sorted by hired date then prints the
    * employees array
    *
    */
   public String printByDate() {
      Employee temp;
      for (int i = 0; i <= this.employees.length - 1; i++) {
         for (int j = i + 1; j <= this.employees.length - 2; j++) {
            if (i == this.employees.length - 1 || this.employees[j] == null)
               break; // no employees
            // book date at i
            int EmpHiredYearI = this.employees[i].getProfile().getDateHired().getYear();
            int EmpHiredMonthI = this.employees[i].getProfile().getDateHired().getMonth();
            int EmpHiredDayI = this.employees[i].getProfile().getDateHired().getDay();
            // book date at j
            int EmpHiredYearJ = this.employees[j].getProfile().getDateHired().getYear();
            int EmpHiredMonthJ = this.employees[j].getProfile().getDateHired().getMonth();
            int EmpHiredDayJ = this.employees[j].getProfile().getDateHired().getDay();
            if (EmpHiredYearI > EmpHiredYearJ) {
               temp = this.employees[i];
               this.employees[i] = this.employees[j];
               this.employees[j] = temp;
            } else if (EmpHiredYearI == EmpHiredYearJ) {
               if (EmpHiredMonthI > EmpHiredMonthJ) {
                  temp = this.employees[i];
                  this.employees[i] = this.employees[j];
                  this.employees[j] = temp;
               } else if (EmpHiredMonthI == EmpHiredMonthJ) {
                  if (EmpHiredDayI > EmpHiredDayJ) {
                     temp = this.employees[i];
                     this.employees[i] = this.employees[j];
                     this.employees[j] = temp;
                  }
               }
            }
         }
      }
      return this.print();
   }

   /**
    * Gets the numEmployee values
    *
    * @return numEmployee
    */
   public int getNumEmployee() {
      return numEmployee;
   }

   /**
    * Finds if the given employee exisits in the employees array or not
    *
    * @return true if it does otherwise false
    */
   public boolean alreadyExists(Employee employee) {
      if (find(employee) == -1)
         return false;
      else
         return true;
   }

   /**
    * Exports the company database to a .txt file.
    * @param filename
    * @throws FileNotFoundException
    */
   public void exportDatabase(String filename) throws FileNotFoundException{
      try (PrintWriter out = new PrintWriter(filename)) {
         String fileOutput = print().replace("--Printing earning statements for all employees--","");
         out.println(fileOutput);
     }
   }
}
