package Project2.src;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Parttime extends Employee {

	private double hourlyRate;
	private int hoursWorked = 0;
	public static final double OVERTIMEMULTI = 1.5;
	public static final double PAYPERIOD = 2;
	public static final int MAXHOURS = 40;

	public Parttime(Profile profile, double hourlyRate) {
		super(profile);
		this.hourlyRate = hourlyRate;
	}

	@Override
	public void calculatePayment() {
		double payment;
		double normalHrs;
		
		double weeklyHrsWorked = hoursWorked / PAYPERIOD;
		double overtimeHrs = weeklyHrsWorked - MAXHOURS;
		double overtimeRate = hourlyRate * OVERTIMEMULTI;
		

		if (overtimeHrs < 0) {
			normalHrs = weeklyHrsWorked;
			overtimeHrs = 0;
		} else {
			normalHrs = weeklyHrsWorked - overtimeHrs;
		}

		overtimeHrs *= PAYPERIOD;
		normalHrs *= PAYPERIOD;
		payment = (normalHrs * hourlyRate) + (overtimeHrs * overtimeRate);

		setPayment(payment);
	}

	public void setHours(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	@Override
	public String toString() {// ::PART TIME::Hourly Rate $xx.xx::Hours worked this period: x
		DecimalFormat formattedRate = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());
		formattedRate.setGroupingUsed(true);
		formattedRate.setGroupingSize(3);
		return super.toString() + "::PART TIME::Hourly Rate $" + formattedRate.format(hourlyRate)
				+ "::Hours worked this period: " + hoursWorked;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Parttime) {
			return super.equals(obj);
		} else {
			return false;
		}
	}

}