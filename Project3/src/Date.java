/**
 * The Date class allows us to look at a formatted date and determine if the date are valid or not.
 * year: the year of the date.
 * month: the month of the date.
 * day: numerical day of the date.
 * @Tenzin Norden, @Vedant Mehta
 */

package Project3.src;


import java.util.Calendar;

public class Date implements Comparable<Date> {

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

   /**
    * Overriden method used to compare two Dates
    * 
    * @return 0 if they are the same, 1 if the compared date is greater, -1 if
    *         otherwise.
    */
   @Override
   public int compareTo(Date date) { // return 1, 0, or -1
      if (this.year == date.year && this.month == date.month && this.day == date.day) {
         return 0;
      } else if (this.year > date.year) {
         return 1;
      } else if (this.year == date.year && this.month > date.month) {
         return 1;
      } else if (this.year == date.year && this.month == date.month && this.day > date.day) {
         return 1;
      } else
         return -1;
   }

   /**
    * Tester method to test the validity of the Date class. Tests leap year,
    * current date, Dates after today, formatting and impossible values.
    * 
    * @param args
    */
   public static void main(String[] args) {

      // Test current date. Expected True,True
      System.out.println("Test case 1: Current date");
      System.out.println(new Date().toString() + ": " + new Date().isValid());
      System.out.println(new Date("02/08/2021").toString() + ": " + new Date("02/08/2021").isValid());

      // Test leap year data. Expected True,True,True,False,False,False
      System.out.println("Test case 2, Leap Year Case 1: True");
      System.out.println(new Date("02/29/2016").toString() + ": " + new Date("02/29/2016").isValid());
      System.out.println(new Date("02/29/2012").toString() + ": " + new Date("02/29/2012").isValid());
      System.out.println(new Date("02/29/2008").toString() + ": " + new Date("02/29/2008").isValid());

      System.out.println("Test case 2, Leap Year Case 2: False");
      System.out.println(new Date("02/29/2009").toString() + ": " + new Date("02/29/2009").isValid());
      System.out.println(new Date("02/29/2014").toString() + ": " + new Date("02/29/2014").isValid());
      System.out.println(new Date("02/29/1804").toString() + ": " + new Date("02/29/1804").isValid());

      // Test Date after today. Expected False
      System.out.println("Test case 3: After current date");
      System.out.println(new Date("02/09/2022").toString() + ": " + new Date("02/09/2022").isValid());
      System.out.println(new Date("02/10/2021").toString() + ": " + new Date("02/10/2021").isValid());
      System.out.println(new Date("03/09/2021").toString() + ": " + new Date("03/09/2021").isValid());
      System.out.println(new Date("01/01/2022").toString() + ": " + new Date("01/01/2022").isValid());

      // Test Incorrect formatting
      // Expected False, True
      System.out.println("Test case 4, case 1: Dashes instead of /");
      System.out.println(new Date("01-12-2021").toString() + ": " + new Date("01-12-2021").isValid());
      System.out.println(new Date("1/1/2021").toString() + ": " + new Date("1/1/2021").isValid());

      // Test if letters are included in date. Expected: False
      System.out.println("Test case 4, case 2: includes letters");
      System.out.println(new Date("1/A1/20v2").toString() + ": " + new Date("1/A1/20v2").isValid());
      System.out.println(new Date("A/01/2021").toString() + ": " + new Date("A/01/2021").isValid());
      System.out.println(new Date("C /02/2021").toString() + ": " + new Date("C /02/2021").isValid());

      // Test missing data and empty string. Expected: False
      System.out.println("Test case 4, case 3: Missing data");
      System.out.println(new Date("1 1/2020").toString() + ": " + new Date("1 1/2020").isValid());
      System.out.println(new Date(" ").toString() + ": " + new Date(" ").isValid());
      System.out.println(new Date("").toString() + ": " + new Date("").isValid());
      System.out.println(new Date("2002/04/02").toString() + ": " + new Date("2002/04/02").isValid());
      System.out.println(new Date("1 1 2020").toString() + ": " + new Date("1 1 2020").isValid());

      // Test impossible date values such as 0 or negative numbers. Expected: False.
      System.out.println("Test case 5: impossible values");
      System.out.println(new Date("00/01/0200").toString() + ": " + new Date("00/01/0200").isValid());
      System.out.println(new Date("1/0/2020").toString() + ": " + new Date("1/0/2020").isValid());
      System.out.println(new Date("1/01/0").toString() + ": " + new Date("1/01/0").isValid());
      System.out.println(new Date("-1/1/2020").toString() + ": " + new Date("-1/1/2020").isValid());

      // Test known valid dates. Expected: True.
      System.out.println("Test case 6: known true values");
      System.out.println(new Date("02/08/2021").toString() + ": " + new Date("02/08/2021").isValid());
      System.out.println(new Date("05/16/1999").toString() + ": " + new Date("05/16/1999").isValid());
      System.out.println(new Date("01/01/2018").toString() + ": " + new Date("01/01/2018").isValid());
      System.out.println(new Date("02/29/2020").toString() + ": " + new Date("02/29/2020").isValid());

   }

}
