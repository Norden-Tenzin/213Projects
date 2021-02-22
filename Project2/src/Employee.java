package Project2.src;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Employee {

	private Profile profile;
	private double payment = 0;

	public Employee(Profile profile) {
		this.profile = profile;
		payment = 0;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setPayment(double ammount) {
		this.payment = ammount;
	}

	@Override
	public String toString() { // Doe,Jane::CS::7/1/2020::Payment $0.00::STATUS
		String personInfo = this.profile.toString();
		DecimalFormat formattedPayment = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());
		formattedPayment.setGroupingUsed(true);
		formattedPayment.setGroupingSize(3);
		return personInfo + "::Payment $" + formattedPayment.format(this.payment);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Profile isEmployeeProf = ((Employee) obj).getProfile();
			return (this.profile.equals(isEmployeeProf));
		} else {
			return false;
		}
	}
	
	public void calculatePayment() {}

}