package Project2.src;

import java.text.DecimalFormat;

public class Management extends Fulltime {

	double bonus;
	double salary;
	String role;

	public Management(Profile profile, double annualSalary, int statusNumber) {
		super(profile, annualSalary);
		switch (statusNumber) {
			case 1:
				this.role = "Manager";
				this.bonus = 5000;
				break;
			case 2:
				this.role = "Director";
				this.bonus = 9500;
				break;
			case 3:
				this.role = "Department Head";
				this.bonus = 12000;
				break;
			default:
				bonus = 0;
		}

	}

	@Override
	public String toString() {// ::Manager Compensation $xxx.xx
		DecimalFormat formattedCompensation = new DecimalFormat("0.00");
		formattedCompensation.setGroupingUsed(true);
		formattedCompensation.setGroupingSize(3);
		return super.toString() + "::" + this.role + " Compensation $"
				+ formattedCompensation.format(this.bonus / PAYPERIOD);
	}

	@Override
	public void calculatePayment() {
		double annualSalary = getSalary();
		double payment = (annualSalary + this.bonus) / PAYPERIOD;
		setPayment(payment);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Management) {
			return super.equals(obj);
		} else {
			return false;
		}

	}

}