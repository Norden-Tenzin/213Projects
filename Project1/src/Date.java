
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
   * processes data. Does error checking to see if date is valid
   * 
   * @param date in the format mm/dd/yyyy.
   */
  public Date(String date) {

    String dateParts[] = date.split("/");
    boolean containsLetters = false;
    // Check to see if the date contains letters
    for (int i = 0; i < date.length(); i++) {
      if (Character.isLetter(date.charAt(i)))
        containsLetters = true;
    }
    if (!date.contains("/") || dateParts.length < 3 || containsLetters) {
      // if the date is invalid, we want to generate the date with invalid values.
      final int INVALID_DATE_VALUE = -1;
      this.month = INVALID_DATE_VALUE;
      this.day = INVALID_DATE_VALUE;
      this.year = INVALID_DATE_VALUE;
    } else {
      this.month = Integer.parseInt(dateParts[0]);
      this.day = Integer.parseInt(dateParts[1]);
      this.year = Integer.parseInt(dateParts[2]);
    }
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

    Calendar dateCal = Calendar.getInstance();

    boolean outsideMonthRange = this.month > 12 || this.month < 1;
    boolean outsideYearRange = this.year < 1900 || this.year > dateCal.get(Calendar.YEAR);
    boolean afterToday = this.year >= dateCal.get(Calendar.YEAR) && this.month >= dateCal.get(Calendar.MONTH) + 1
        && this.day > dateCal.get(Calendar.DATE);

    // Year validation
    if (afterToday || outsideYearRange || outsideMonthRange)
      return false;

    // Checks to see if the year is a leap year.
    int FEB = 28;
    if (isLeapYear(year))
      FEB = 29;

    // if the current day exceeds the maximum day, return false
    int[] maxDaysPerMonth = { 31, FEB, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if (this.day > maxDaysPerMonth[this.month - 1] || this.day < 1)
      return false;

    return true;
  }

  /**
   * Counts the number of days in a year and determines if the year is a leap
   * year.
   * 
   * @param year
   * @return true if year is a leap year, false if not
   */
  public static boolean isLeapYear(int year) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, year);
    return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
  }

  /**
   * Returns the date, properly formatted.
   * 
   * @return the date in string format
   */
  @Override
  public String toString() {
    return (this.month + "/" + this.day + "/" + this.year);
  }

  public static void main(String[] args) {
    //test stuff here
  }

}
