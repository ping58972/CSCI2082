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
		
	}
	public double overTimeHoursWorked(double hoursWorked) {
		return 19;
	}
	public double overTimePay(double overTimeHours) {
		return 12;
	}
	public double grossPay(double hoursWorked) {
		return 598.85;
	}
	public double federalDeductions(double grossPay) {
		return 598.85;
	}
	public double stateDeductions(double grossPay) {
		return 89;
	}
	public double totalDeductions(double federalDeductions, double stateDeductions) {
		return 598.85;
	}
	public double netYearIncome(int[] hoursPerPayPeriod) {
		return 20646.53;
	}
	public double grossYearIncome(int[] hoursPerPayPeriod) {
		return 29079.62;
	}
	public double netPay(double hoursWorked) {
		return 979.18;
	}
	@Override
	public String toString() {
		return "PayCalculator [name=" + name + ", reportId=" + reportId + ", hourlyWage=" + hourlyWage + "]";
	}


}
