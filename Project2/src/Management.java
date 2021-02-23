/**
 * Management class will extend FullTime and will handle management employee data.
 * This class will be in charge of handling manager information and will have its own calculatePayment method since 
 * payment calculation differs from each employee type.
 *  @Tenzin Norden, @Vedant Mehta
 */

package Project2.src;

import java.text.DecimalFormat;

public class Management extends Fulltime {

   double bonus;
   double salary;
   String role = "";

   /**
    * Managment constructor which takes in a profile class, salary and a status.
    * This constructor will be used to determine which type of manager the employee
    * is as well as calculate compensation. Managers(status of 1) recieve $5000 in
    * bonus. Directors(status of 2) recieve $9500 in bonus. Department Heads(status
    * of 3) recieve a $12,000 bonus.
    * 
    * @param profile      is the profile class of the employee.
    * @param annualSalary is the salary of this employee.
    * @param statusNumber is associated with the Manager's title (role) and bonus.
    */
   public Management(Profile profile, double annualSalary, int statusNumber) {
      super(profile, annualSalary);
      switch (statusNumber) {
         case 1:
            this.role = "Manager";
            this.bonus = 5000;
            break;
         case 2:
            this.role = "Director";
            this.bonus = 9500;
            break;
         case 3:
            this.role = "Department Head";
            this.bonus = 12000;
            break;
         default:
            bonus = 0;
      }

   }

   /**
    * Overridden toString method which outputs the formatted string of an employee
    * class. Format: Doe,Jane::CS::7/1/2020::Payment $0.00::FULL TIME::Annual
    * Salary $xx,xxx.xx::Manager Compensation $xxx.xx
    * 
    * @return A formatted string of the employee
    */
   @Override
   public String toString() {
      DecimalFormat formattedCompensation = new DecimalFormat("0.00");
      formattedCompensation.setGroupingUsed(true);
      formattedCompensation.setGroupingSize(3);
      String compensationOutput = "";
      if (this.role.equals("")) {
         compensationOutput = "";
      } else {
         compensationOutput = "::" + this.role + " Compensation $"
               + formattedCompensation.format(this.bonus / PAYPERIOD);
      }
      return super.toString() + compensationOutput;
   }

   /**
    * Overriden calculatPayment method used to calculate the payment of a manager.
    * payment = (annual salary + bonus) / payperiod.
    */
   @Override
   public void calculatePayment() {
      double annualSalary = getSalary();
      double payment = (annualSalary + this.bonus) / PAYPERIOD;
      setPayment(payment);
   }

   /**
    * Overridden equals method to compare two management classes.
    * 
    * @return true if the object is equal to the compared object
    */
   @Override
   public boolean equals(Object obj) {
      if (obj instanceof Management) {
         if (((Management) obj).role == this.role) {
            return super.equals(obj);
         } else
            return false;
      } else
         return false;
   }

}