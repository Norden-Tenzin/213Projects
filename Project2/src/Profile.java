package Project2.src;

public class Profile {

  private String name;
  private String department;
  private Date dateHired;
  private final String[] departments = { "ECE", "IT", "CS" };

  /**
   * Constructor which sets the values for name, department and dateHired
   *
   */
  public Profile(String name, String department, Date dateHired) {
    this.name = name;
    this.department = department;
    this.dateHired = dateHired;
  }

  /**
   * Gets the profile name
   *
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the department name
   *
   * @return department
   */
  public String getDepartment() {
    return this.department;
  }

  /**
   * Gets the dateHired date
   *
   * @return dateHired
   */
  public Date getDateHired() {
    return this.dateHired;
  }

  /**
   * Checks if the date is valid or not
   *
   * @return true if it is otherwise false
   */
  public boolean validateDate() {
    return this.dateHired.isValid();
  }

  /**
   * Checks if the department is valid
   *
   * @return true if it is otherwise false
   */
  public boolean validateDepartment() {
    for (int i = 0; i < departments.length; i++) {
      if (this.department.equals(departments[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   * Overridden toString method which outputs the formatted string of a Profile class.
   * Format: Doe,Jane::CS::7/1/2020
   * @return A formatted string of the profile
   */
  @Override
  public String toString() { //Doe,Jane::CS::7/1/2020
    return name + "::" + department + "::" + dateHired.toString();
  }

  /**
   * Overridden equals method to compare two Profile classes.
   * @return true if the object is equal to the compared object
   */
  @Override
  public boolean equals(Object obj) {
    int dateComp;
    if (obj instanceof Profile) {
      Profile prof = (Profile) obj;
      boolean equalName = prof.getName().equals(this.name);
      boolean equalDepartment = prof.getDepartment().equals(this.department);
      dateComp = prof.getDateHired().compareTo(this.dateHired);
      boolean equalDate = (dateComp == 0);
      return (equalName && equalDepartment && equalDate);
    }
    return false;
  }
}
