package Project2.src;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
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

  private int find(Employee employee) {
    for (int i = 0; i < numEmployee; i++) {
      if (employee.equals(employees[i]))
        return i;
    }
    return -1;
  }

  /**
   * When called increases the size of the books array by STARTING_COMPANY_SIZE
   */
  private void grow() {
    Employee[] newArray = new Employee[employees.length + STARTING_COMPANY_SIZE];

    for (int i = 0; i < numEmployee; i++) {
      newArray[i] = employees[i];
    }
    employees = newArray;
  }

  public boolean add(Employee employee) {
    if (employees[employees.length - 1] != null)
      grow();
    
    for (int i = 0; i < employees.length; i++) {
      if (employees[i] == null) {
        employees[i] = employee;
        numEmployee++;
        return true;
      }
    }
    return false;
  }

  public boolean remove(Employee employee) {
    int indexEmployee = find(employee);
    if (indexEmployee == -1){
      return false;
    }

    for (int i = indexEmployee + 1; i < employees.length; i++) {
      employees[i - 1] = employees[i];
    }

    numEmployee--;
    return true;
  }

  // TODO: Might need to re-write
  public boolean setHours(Employee employee) {
    int indexEmployee = find(employee);
    
    if (employees[indexEmployee] instanceof Parttime) {
      if (((Parttime) employee).getHours() >= 0) {
        return true;
      }
    }
    return false;
  }

  public void processPayments(){
    for (int i = 0; i < numEmployee; i++) {
      if (employees[i] instanceof Parttime){
        ((Parttime)employees[i]).calculatePayment();
      } else if  (employees[i] instanceof Fulltime){
        ((Fulltime)employees[i]).calculatePayment();
      } else if  (employees[i] instanceof Management){
        ((Management)employees[i]).calculatePayment();
      }
    }
  }

  public boolean setEmployeeHours(Employee employee, int hours) {
    int indexEmployee = find(employee);
    if(indexEmployee != -1){
      ((Parttime) employees[indexEmployee]).setHours(hours);
      return true;
    } 
    return false;
  }

  public void print() {
    for (int i = 0; i < numEmployee; i++) {
      System.out.println(employees[i].toString());
    }
  }

  public int getNumEmployee() {
    return numEmployee;
  }

  public boolean alreadyExists(Employee employee){
    if(find(employee)==-1)
      return false;
    else
      return true;
  }
}
