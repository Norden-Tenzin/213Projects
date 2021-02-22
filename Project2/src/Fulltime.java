package Project2.src;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Fulltime extends Employee {

	private double annualSalary;
	public static final int PAYPERIOD = 26;

	public Fulltime(Profile profile, Double salary) {
		super(profile);
		this.annualSalary = salary;
	}

	public double getSalary() {
		return this.annualSalary;
	}


	@Override
    public void calculatePayment() {
        double payment  = annualSalary/PAYPERIOD;
        setPayment(payment);
    }

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fulltime) {
			return super.equals(obj);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {// "::FULL TIME::Annual Salary $xx,xxx.xx
		DecimalFormat formattedSalary = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());
		formattedSalary.setGroupingUsed(true);
		formattedSalary.setGroupingSize(3);

		return super.toString() + "::FULL TIME::Annual Salary $" + formattedSalary.format(annualSalary);
	}

}