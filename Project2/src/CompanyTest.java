package Project2.src;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CompanyTest {
 @Test
    void add() {
        Company company = new Company();
        Employee PartTimeEmployee = new Parttime(new Profile("Doe,John", "ECE", new Date("4/20/2010")), 40.5);
        Employee FullTimeEmployee = new Fulltime(new Profile("Doe,John", "CS", new Date("6/09/2001")), 34000);
        Employee ManagerEmployee = new Management(new Profile("Doe,John", "IT", new Date("10/20/1989")), 15000, 3);

        assertTrue(company.add(FullTimeEmployee));
        assertTrue(company.add(ManagerEmployee));
        assertTrue(company.add(PartTimeEmployee));

        assertFalse(company.add(FullTimeEmployee));
        assertFalse(company.add(ManagerEmployee));
        assertFalse(company.add(PartTimeEmployee));

    }

    @Test
    void remove() {
        Company company = new Company();
        Employee FullTimeEmployee = new Fulltime(new Profile("BobFT", "CS", new Date("7/31/2001")), 10000);
        Employee ManagerEmployee = new Management(new Profile("BobM", "IT", new Date("10/20/1989")), 15000, 1);
        Employee PartTimeEmployee = new Parttime(new Profile("BobPT", "ECE", new Date("8/20/2010")), 10);
        Employee PartTimeEmployee2 = new Parttime(new Profile("BobPT2", "IT", new Date("9/30/2000")), 20);
        Employee PartTimeEmployee3 = new Parttime(new Profile("BobPT3", "CS", new Date("10/20/2008")), 15);

        assertFalse(company.remove(FullTimeEmployee));
        assertFalse(company.remove(ManagerEmployee));
        assertFalse(company.remove(PartTimeEmployee));
        assertFalse(company.remove(PartTimeEmployee2));
        assertFalse(company.remove(PartTimeEmployee3));

        company.add(FullTimeEmployee);
        company.add(ManagerEmployee);
        company.add(PartTimeEmployee);
        company.add(PartTimeEmployee2);
        company.add(PartTimeEmployee3);

        assertTrue(company.remove(FullTimeEmployee));
        assertTrue(company.remove(ManagerEmployee));
        assertTrue(company.remove(PartTimeEmployee));
        assertTrue(company.remove(PartTimeEmployee2));
        assertTrue(company.remove(PartTimeEmployee3));

        assertFalse(company.remove(FullTimeEmployee));
        assertFalse(company.remove(ManagerEmployee));
        assertFalse(company.remove(PartTimeEmployee));
        assertFalse(company.remove(PartTimeEmployee2));
        assertFalse(company.remove(PartTimeEmployee3));
    }

    @Test
    void setHours() {
        Company company = new Company();
        Employee FullTimeEmployee = new Fulltime(new Profile("BobFT", "CS", new Date("7/31/2001")), 10000);
        Employee ManagerEmployee = new Management(new Profile("BobM", "IT", new Date("10/20/1989")), 15000, 1);
        Employee PartTimeEmployee = new Parttime(new Profile("BobPT", "ECE", new Date("8/20/2010")), 10);
        Employee PartTimeEmployee2 = new Parttime(new Profile("BobPT2", "IT", new Date("9/30/2000")), 20);
        Employee PartTimeEmployee3 = new Parttime(new Profile("BobPT3", "CS", new Date("10/20/2008")), 15);

        company.add(FullTimeEmployee);
        company.add(ManagerEmployee);
        company.add(PartTimeEmployee);
        company.add(PartTimeEmployee2);
        company.add(PartTimeEmployee3);

        assertTrue(company.setHours(PartTimeEmployee));
        assertTrue(company.setHours(PartTimeEmployee2));
        assertTrue(company.setHours(PartTimeEmployee3));
        assertFalse(company.setHours(FullTimeEmployee));
        assertFalse(company.setHours(ManagerEmployee));

    }

    @Test
    void processPayments() {
        Company company = new Company();
        Employee FullTimeEmployee = new Fulltime(new Profile("BobFT", "CS", new Date("7/31/2001")), 10000);
        Employee ManagerEmployee = new Management(new Profile("BobM", "IT", new Date("10/20/1989")), 15000, 1);
 

        company.add(FullTimeEmployee);
        company.add(ManagerEmployee);

        company.processPayments();

        assertTrue(FullTimeEmployee.toString().equals("BobFT::CS::7/31/2001::Payment $384.62::FULL TIME::Annual Salary $10,000.00"));
        assertTrue(ManagerEmployee.toString().equals("BobM::IT::10/20/1989::Payment $769.23::FULL TIME::Annual Salary $15,000.00::Manager Compensation $192.31"));

    }

   
}
