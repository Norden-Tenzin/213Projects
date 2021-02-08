
/**
 * The Date class allows us to look at a formatted date and determine if the date are valid or not.
 * year: the year of the date.
 * month: the month of the date.
 * day: numerical day of the date.
 * @Tenzin Norden, @Vedant Mehta
 */

import java.util.Calendar;

public class Date {

  private int year;
  private int month;
  private int day;

  /**
   * Default constructor Assigns today's date to day, month, year values.
   */
  public Date() {
    Calendar dateCal = Calendar.getInstance();
    this.year = dateCal.get(Calendar.YEAR);
    this.month = dateCal.get(Calendar.MONTH) + 1;
    this.day = dateCal.get(Calendar.DATE);
  }

  /**
   * Overloads default constructor. Takes in mm/dd/yyyy formatted string and
   * processes data.
   * 
   * @param date in the format mm/dd/yyyy.
   */
  public Date(String date) {
    String dateParts[] = date.split("/");
    this.month = Integer.parseInt(dateParts[0]);
    this.day = Integer.parseInt(dateParts[1]);
    this.year = Integer.parseInt(dateParts[2]);
  }

  /**
   * Gets the book datePublished.
   * 
   * @return the book datePublished
   */
  public int getYear() {
    return this.year;
  }

  /**
   * Gets the book datePublished.
   * 
   * @return the book datePublished
   */
  public int getMonth() {
    return this.month;
  }

  /**
   * Gets the book datePublished.
   * 
   * @return the book datePublished
   */
  public int getDay() {
    return this.day;
  }

  /**
   * Checks if the date is properly formatted and if values are possible. Checks
   * to see if the year is a leap year and checks date validity accordingly.
   * 
   * @return true if the date is valid, otherwise false.
   */
  public boolean isValid() {
    int CURRENT_YEAR = 2021;

    // Year validation
    if (this.year < 1900 || this.year > CURRENT_YEAR || this.month > 12)
      return false;

    // Checks to see if the year is a leap year.
    int FEB = 28;
    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
      FEB = 29;

    // if the current day exceeds the maximum day, return false
    int[] maxDaysPerMonth = { 31, FEB, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if (this.day >= maxDaysPerMonth[this.month - 1])
      return false;

    return true;
  }

  @Override
  public String toString() {
    return (this.month + "/" + this.day + "/" + this.year);
  }
}
