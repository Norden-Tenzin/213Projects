/**
 * FullTime class will extend Employee and will handle FullTime employee data.
 * This class will be in charge of handling some manager information and will have its own calculatePayment method since 
 * payment calculation differs from each employee type.
 *  @Tenzin Norden, @Vedant Mehta
 */

package Project3.src;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Fulltime extends Employee {

   private double annualSalary;
   public static final int PAYPERIOD = 26;

   /**
    * Fulltime employee constructor.
    * 
    * @param profile is the Profile class needed for Employee.java
    * @param salary  is the salary associated with this employee
    */
   public Fulltime(Profile profile, Double salary) {
      super(profile);
      this.annualSalary = salary;
   }

   /**
    * Fulltime employee constructor which takes in an integer rather than a double
    * for salary amount.
    * 
    * @param profile is the Profile class needed for Employee.java
    * @param salary  is the salary associated with this employee, but as an Integer
    */
   public Fulltime(Profile profile, int salary) {
      super(profile);
      this.annualSalary = salary;
   }

   /**
    * Simple helper method to get the Fulltime employee's salary.
    * 
    * @return the employee's salary
    */
   public double getSalary() {
      return this.annualSalary;
   }

   /**
    * Overriden calculatPayment method used to calculate the payment of a full time
    * employee. payment = annual salary / payperiod.
    */
   @Override
   public void calculatePayment() {
      double payment = annualSalary / PAYPERIOD;
      setPayment(payment);
   }

   /**
    * Overridden equals method to compare two fulltime employee classes.
    * 
    * @return true if the object is equal to the compared object
    */
   @Override
   public boolean equals(Object obj) {
      if (obj instanceof Fulltime) {
         return super.equals(obj);
      } else {
         return false;
      }
   }

   /**
    * Overridden toString method which outputs the formatted string of an employee
    * class. Format: Doe,Jane::CS::7/1/2020::Payment $0.00::FULL TIME::Annual
    * Salary $xx,xxx.xx
    * 
    * @return A formatted string of the employee
    */
   @Override
   public String toString() {
      DecimalFormat formattedSalary = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());
      formattedSalary.setGroupingUsed(true);
      formattedSalary.setGroupingSize(3);

      return super.toString() + "::FULL TIME::Annual Salary $" + formattedSalary.format(annualSalary);
   }

}