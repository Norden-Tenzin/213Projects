package Project3.src;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Employee class which will be used to create Employees which will be inherited by FullTime and PartTime classes.
 * The class will handle setPayment and will be used to keep track of an employee's profile.
 *  @Tenzin Norden, @Vedant Mehta
 */
public class Employee {
   private Profile profile;
   private double payment = 0;

   /**
    * Employee constructor which takes in a profile class. It also keeps track of
    * the payment for the employee.
    * 
    * @param profile of the employee which will be treated as a unique identifier.
    */
   public Employee(Profile profile) {
      this.profile = profile;
      payment = 0;
   }

   /**
    * Gets the profile of the employee.
    * 
    * @return the profile of the employee as a Profile class.
    */
   public Profile getProfile() {
      return this.profile;
   }

   /**
    * Sets the payment for the employee
    * 
    * @param ammount of dollars as a double.
    */
   public void setPayment(double ammount) {
      this.payment = ammount;
   }

   /**
    * Overridden toString method which outputs the formatted string of an employee
    * class. Format: Doe,Jane::CS::7/1/2020::Payment $0.00
    * 
    * @return A formatted string of the employee
    */
   @Override
   public String toString() {
      String personInfo = this.profile.toString();
      DecimalFormat formattedPayment = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());
      formattedPayment.setGroupingUsed(true);
      formattedPayment.setGroupingSize(3);
      return personInfo + "::Payment $" + formattedPayment.format(this.payment);
   }

   /**
    * Overridden equals method to compare two Employee classes.
    * 
    * @return true if the object is equal to the compared object
    */
   @Override
   public boolean equals(Object obj) {
      if (obj instanceof Employee) {
         Profile isEmployeeProf = ((Employee) obj).getProfile();
         return (this.profile.equals(isEmployeeProf));
      } else {
         return false;
      }
   }

   /**
    * Used as placeholder for classes which inherit Employee.
    */
   public void calculatePayment() {
   }

}