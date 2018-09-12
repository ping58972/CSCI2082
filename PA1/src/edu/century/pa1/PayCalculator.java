package edu.century.pa1;

public class PayCalculator implements Constants {
	private String name;
	private int reportId =1000;
	private double hourlyWage;
	private static int increment = 0;
	public PayCalculator(String name, double hourlyWage) {
		super();
		
		this.name = name;
		this.reportId += increment;
		this.hourlyWage = hourlyWage;
		increment += 10;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public double getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
	public void increaseHourlyWage(double raiseRate) {
		this.hourlyWage = this.hourlyWage * (1+ (raiseRate/100));
	}
	public double overTimeHoursWorked(double hoursWorked) {
		if(hoursWorked > FULL_TIME)
		return (hoursWorked - FULL_TIME);
		else return 0.0;
	}
	public double overTimePay(double overTimeHours) {
		return (overTimeHours*(getHourlyWage()*OVERTIME_RATE));
	}
	public double netPay(double hoursWorked) {
		return (grossPay(hoursWorked) - totalDeductions(
				federalDeductions(grossPay(hoursWorked)),
				stateDeductions(grossPay(hoursWorked))));
	}
	public double grossPay(double hoursWorked) {
		if(hoursWorked <= FULL_TIME) {
		return (hoursWorked * getHourlyWage());
		}else return ((FULL_TIME* getHourlyWage())
				+ overTimePay(overTimeHoursWorked(hoursWorked)));
	}
	public double federalDeductions(double grossPay) {
		return grossPay * FEDERAL_TAX_RATE;
	}
	public double stateDeductions(double grossPay) {
		return grossPay * STATE_TAX_RATE;
	}
	public double totalDeductions(double federalDeductions,
			double stateDeductions) {
		return federalDeductions + stateDeductions;
	}
	public double netYearIncome(int[] hoursPerPayPeriod) {
		int[] hoursPPP = hoursPerPayPeriod.clone();
		double sumAllDedu =0;
		for(int hour : hoursPPP) {
			sumAllDedu += totalDeductions(federalDeductions(grossPay(hour))
					, stateDeductions(grossPay(hour))) ;
		}
		return grossYearIncome(hoursPPP)-sumAllDedu;
	}
	public double grossYearIncome(int[] hoursPerPayPeriod) {
		int[] hoursPPP = hoursPerPayPeriod.clone();
		double sumAllIncome =0;
		for(int hour : hoursPPP) {
			sumAllIncome += grossPay(hour);
		}
		return sumAllIncome;
	}

	@Override
	public String toString() {
		return "PayCalculator [name=" + name + ", reportId=" 
	+ reportId + ", hourlyWage=" + hourlyWage + "]";
	}
	
}
