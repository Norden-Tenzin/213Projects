// package Project1.src;
import java.util.Calendar;

public class Date {

	private int year;
	private int month;
	private int day;

	public Date() {
		Calendar dateCal = Calendar.getInstance();
		this.year = dateCal.get(Calendar.YEAR);
		this.month = dateCal.get(Calendar.MONTH) + 1;
		this.day = dateCal.get(Calendar.DATE);
	}

	public Date(String date) {
		String dateParts [] = date.split("/");
		this.month = Integer.parseInt(dateParts[0]);
		this.day = Integer.parseInt(dateParts[1]);
		this.year = Integer.parseInt(dateParts[2]);
	}


	
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
		int [] maxDaysPerMonth = {31, FEB, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (this.day >= maxDaysPerMonth(this.year)[this.month-1]) 
				return false;
		
		return true;
	}

	public static void main(String[]cheese){
		Date b1 = new Date("8/1/1999");
		System.out.println(b1.day);
		System.out.println(b1.isValid());
	}

}