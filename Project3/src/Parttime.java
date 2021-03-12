package Project3.src;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * PartTime class will extend Employee and will handle Parttime employee data.
 * This class will be in charge of handling some Parttime employee information and will have its own calculatePayment method since 
 * payment calculation differs from each employee type.
 * This class will also be used to set the hours worked and hourly rate of the employee.
 *  @Tenzin Norden, @Vedant Mehta
 */
public class Parttime extends Employee {

   private double hourlyRate;
   private int hoursWorked = 0;
   public static final double OVERTIMEMULTI = 1.5;
   public static final double PAYPERIOD = 2;
   public static final int MAXHOURS = 40;
   public static final int OVERFLOWHOURS = 100;

   /**
    * Parttime employee constructor which takes in an hourly rate and a profile
    * class
    * 
    * @param profile    class used as a unique identifier for the employee.
    * @param hourlyRate double used to denote the hourly rate of an employee in
    *                   dollars.
    */
   public Parttime(Profile profile, double hourlyRate) {
      super(profile);
      this.hourlyRate = hourlyRate;
   }

   /**
    * Overriden calculatPayment method used to calculate the payment of a part time
    * employee. payment = (total normal hours * hourly rate) + (total overtime
    * hours * overtime rate)
    */
   @Override
   public void calculatePayment() {
      double payment;
      double normalHrs;

      double weeklyHrsWorked = hoursWorked / PAYPERIOD;
      double overtimeHrs = weeklyHrsWorked - MAXHOURS;
      double overtimeRate = hourlyRate * OVERTIMEMULTI;

      if (overtimeHrs < 0) {
         normalHrs = weeklyHrsWorked;
         overtimeHrs = 0;
      } else {
         normalHrs = weeklyHrsWorked - overtimeHrs;
      }

      overtimeHrs *= PAYPERIOD;
      normalHrs *= PAYPERIOD;
      payment = (normalHrs * hourlyRate) + (overtimeHrs * overtimeRate);

      setPayment(payment);
   }

   /**
    * Simple helper method used to set the hours worked of the employee
    * 
    * @param hoursWorked integer value denoting the number of hours worked by the
    *                    employee.
    */
   public void setHours(int hoursWorked) {
      this.hoursWorked = hoursWorked;
   }

   /**
    * Simple helper method to get the number of hours worked by the employee
    * 
    * @return an integer value of the hours worked by the employee.
    */
   public int getHours() {
      return this.hoursWorked;
   }

   /**
    * Overridden toString method which outputs the formatted string of an employee
    * class. Format: Doe,Jane::CS::7/1/2020::Payment $0.00::PART TIME::Hourly Rate
    * $xx.xx::Hours worked this period: x
    * 
    * @return A formatted string of the employee
    */
   @Override
   public String toString() {
      DecimalFormat formattedRate = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());
      formattedRate.setGroupingUsed(true);
      formattedRate.setGroupingSize(3);
      return super.toString() + "::PART TIME::Hourly Rate $" + formattedRate.format(hourlyRate)
            + "::Hours worked this period: " + hoursWorked;
   }

   /**
    * Overridden equals method to compare two Parttime employee classes.
    * 
    * @return true if the object is equal to the compared object
    */
   @Override
   public boolean equals(Object obj) {
      if (obj instanceof Parttime) {
         return super.equals(obj);
      } else {
         return false;
      }
   }
}