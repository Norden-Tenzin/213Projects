/**
 * Company testing class for Junit testing. This will be used to test:
 * add(), remove(), and setHours()
 *  @Tenzin Norden, @Vedant Mehta
 */
package Project2.src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

   /**
    * Testing method for the add() method.
    */
   @Test
   void add() {
      Company company = new Company();

      // Create Employees
      Employee PartTimeEmployee = new Parttime(new Profile("Doe,John", "ECE", new Date("4/20/2010")), 40.5);
      Employee FullTimeEmployee = new Fulltime(new Profile("Doe,John", "CS", new Date("6/09/2001")), 34000);
      Employee ManagerEmployee = new Management(new Profile("Doe,John", "IT", new Date("01/02/1999")), 14500, 3);

      // Since not already in the directory,adding is possible:
      assertTrue(company.add(FullTimeEmployee));
      assertTrue(company.add(ManagerEmployee));
      assertTrue(company.add(PartTimeEmployee));

      // Already exists in the directory, adding is not possible:
      assertFalse(company.add(FullTimeEmployee));
      assertFalse(company.add(ManagerEmployee));
      assertFalse(company.add(PartTimeEmployee));

   }

   /**
    * Testing method for the Company.remove() method.
    */
   @Test
   void remove() {
      Company company = new Company();

      // Create employees
      Employee FullTimeEmployee = new Fulltime(new Profile("Doe,JohnFull", "CS", new Date("4/20/2010")), 10000);
      Employee ManagerEmployee = new Management(new Profile("Doe,JohnMAN", "IT", new Date("01/02/1999")), 14500, 1);
      Employee PartTimeEmployee = new Parttime(new Profile("Doe,JohnPart", "ECE", new Date("07/26/2019")), 25);

      // Doesnt exist in the company directory:
      assertFalse(company.remove(FullTimeEmployee));
      assertFalse(company.remove(ManagerEmployee));
      assertFalse(company.remove(PartTimeEmployee));

      company.add(FullTimeEmployee);
      company.add(ManagerEmployee);
      company.add(PartTimeEmployee);

      // Since added, you can remove:
      assertTrue(company.remove(FullTimeEmployee));
      assertTrue(company.remove(ManagerEmployee));
      assertTrue(company.remove(PartTimeEmployee));

      // Check again, after removal to see if possible to remove:
      assertFalse(company.remove(FullTimeEmployee));
      assertFalse(company.remove(ManagerEmployee));
      assertFalse(company.remove(PartTimeEmployee));

   }

   /**
    * Testing method for the setHours() method.
    */
   @Test
   void setHours() {
      Company company = new Company();

      // Create the variables
      Employee FullTimeEmployee = new Fulltime(new Profile("Doe,JohnFull", "CS", new Date("4/20/2010")), 10000);
      Employee ManagerEmployee = new Management(new Profile("Doe,JohnMAN", "IT", new Date("01/02/1999")), 14500, 1);
      Employee PartTimeEmployee = new Parttime(new Profile("Doe,JohnPart", "ECE", new Date("07/26/2019")), 25);

      // Add employees to directory
      company.add(FullTimeEmployee);
      company.add(ManagerEmployee);
      company.add(PartTimeEmployee);

      // Can set hours for part time
      assertTrue(company.setHours(PartTimeEmployee));

      // Cannot set hours for non-part time employee
      assertFalse(company.setHours(FullTimeEmployee));
      assertFalse(company.setHours(ManagerEmployee));

   }

}
