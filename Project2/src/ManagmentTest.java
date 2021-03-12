/**
 * Managment testing class. This will be used to test the calculatePayments() method.
 *  @Tenzin Norden, @Vedant Mehta
 */
package Project2.src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagmentTest {

      @Test
      void calculatePayment() {

            // Create employee
            Employee employee = new Management(new Profile("Doe,John", "CS", new Date("2/20/2020")), 10000, 1);
            Employee employee2 = new Management(new Profile("Doe,John2", "CS", new Date("2/20/2020")), 50000, 2);
            Employee employee3 = new Management(new Profile("Doe,John3", "CS", new Date("2/20/2020")), 25000, 3);
            Employee employee4 = new Management(new Profile("Doe,John5", "CS", new Date("2/20/2020")), 45000, 0);

            // Calculate payments
            employee.calculatePayment();
            employee2.calculatePayment();
            employee3.calculatePayment();
            employee4.calculatePayment();

            // Check to see if out matches expected output
            assertTrue(employee.toString().equals(
                        "Doe,John::CS::2/20/2020::Payment $576.92::FULL TIME::Annual Salary $10,000.00::Manager Compensation $192.31"));
            assertTrue(employee2.toString().equals(
                        "Doe,John2::CS::2/20/2020::Payment $2,288.46::FULL TIME::Annual Salary $50,000.00::Director Compensation $365.38"));
            assertTrue(employee3.toString().equals(
                        "Doe,John3::CS::2/20/2020::Payment $1,423.08::FULL TIME::Annual Salary $25,000.00::Department Head Compensation $461.54"));
            assertTrue(employee4.toString()
                        .equals("Doe,John5::CS::2/20/2020::Payment $1,730.77::FULL TIME::Annual Salary $45,000.00"));

      }
}
