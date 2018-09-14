package edu.century.pa1;

/**public class PayCalculator from the package edu.century.pa1
 * 	The PayCalculator class is designed for calculate the employee's salary
 * 	The class can store a employee's informations like name, report ID, and
 * 	hourly wage. The class also provide methods which can calculate Tax,
 * 	the over time, and so on.
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  PayCalculator.java, Programming Assignment 01.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 09/13/2018
 * */
public class PayCalculator implements Constants {
	private String name;
	private int reportId;
	private double hourlyWage;
	private static int increment = 0;
	
	/* @Descriptions 
	 * 		Initialize and Constructor for the PayCalculator class
	 * @Parameter
	 * 		name - a string that set the name to instance of object
	 * 		hourlyWage - the value that initialize to instance of object 
	 * @Precondition
	 * 		name cannot be empty or null.
	 * 		hourlyWage is non-negative.
	 * 		reportId start with 1000 and increase with 10.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates name and hourlyWage are null.		
	 * */
	public PayCalculator(String name, double hourlyWage) {
		super();
		
		this.name = name;
		this.reportId = 1000;
		this.reportId += increment;
		this.hourlyWage = hourlyWage;
		increment += 10;
	}
	
	/* @Descriptions 
	 * 		to get name from PayCalculator
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current of PayCalculator's name.
	 * @Thorws 		
	 * */
	public String getName() {
		return name;
	}
	
	/* @Descriptions 
	 * 		To set name to PayCalculator.
	 * @Parameter
	 * 		name - a String name that set to PayCalculator
	 * @Precondition
	 * 		name is only string type to set the name.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates name is null.
	 * */
	public void setName(String name) {
		this.name = name;
	}
	
	/* @Descriptions 
	 * 		To get the Report Id PayCalculator
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the Report ID of PayCalculator.
	 * @Thorws 		
	 * */
	public int getReportId() {
		return reportId;
	}
	
	/* @Descriptions 
	 * 		To set a ID to PayCalculator.
	 * @Parameter
	 * 		reportId - a Integer report ID that set to PayCalculator
	 * @Precondition
	 * 		reportId is non-negative
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates reportId is null.
	 * */
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	
	/* @Descriptions 
	 * 		To get the hourly wage form PayCalculator
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the hourly wage of PayCalculator.
	 * @Thorws 		
	 * */
	public double getHourlyWage() {
		return hourlyWage;
	}
	
	/* @Descriptions 
	 * 		To set hourly wage to PayCalculator.
	 * @Parameter
	 * 		hourlyWage - a value of hourly Wage that set to PayCalculator
	 * @Precondition
	 * 		hourlyWage is non-negative
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates hourlyWage is null.
	 * */
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
	/* @Descriptions 
	 * 		To increase and change Hourly Wage to PayCalculator
	 * @Parameter
	 * 		raiseRate - a value of raise Rate that increase HourlyWage
	 * @Precondition
	 * 		raiseRate is non-negative and is a percent value.
	 * @Postcondition
	 * @Thorws 
	 * 		NullPointerException - Indicates raiseRate is null.
	 * */
	public void increaseHourlyWage(double raiseRate) {
		this.hourlyWage = this.hourlyWage * (1+ (raiseRate/100));
	}
	
	/* @Descriptions 
	 * 		To calculate over Time Hours Worked
	 * @Parameter
	 * 		hoursWorked - a values of hours Worked
	 * @Precondition
	 * 		hoursWorked is non-negative
	 * @Return
	 * 		the values of over Time Hours Worked.
	 * @Thorws 	
	 * 		NullPointerException - Indicates hoursWorked is null.	
	 * */
	public double overTimeHoursWorked(double hoursWorked) {
		if(hoursWorked > FULL_TIME)
		return (hoursWorked - FULL_TIME);
		else return 0.0;
	}
	
	/* @Descriptions 
	 * 		To calculate over Time Hours Worked pay.
	 * @Parameter
	 * 		overTimeHours - a values of over time hours.
	 * @Precondition
	 * 		overTimeHours is non-negative
	 * @Return
	 * 		the values of money over Time Hours Worked.
	 * @Thorws 	
	 * 		NullPointerException - Indicates overTimeHours is null.	
	 * */
	public double overTimePay(double overTimeHours) {
		return (overTimeHours*(getHourlyWage()*OVERTIME_RATE));
	}
	
	/* @Descriptions 
	 * 		To calculate the net pay.
	 * @Parameter
	 * 		hoursWorked - a values hours Worked
	 * @Precondition
	 * 		hoursWorked is non-negative
	 * @Return
	 * 		the values of net Pay.
	 * @Thorws 	
	 * 		NullPointerException - Indicates hoursWorked is null.	
	 * */
	public double netPay(double hoursWorked) {
		return (grossPay(hoursWorked) - totalDeductions(
				federalDeductions(grossPay(hoursWorked)),
				stateDeductions(grossPay(hoursWorked))));
	}
	
	/* @Descriptions 
	 * 		To calculate the gross pay.
	 * @Parameter
	 * 		hoursWorked - a values hours Worked
	 * @Precondition
	 * 		hoursWorked is non-negative
	 * @Return
	 * 		the values of gross Pay.
	 * @Thorws 	
	 * 		NullPointerException - Indicates hoursWorked is null.	
	 * */
	public double grossPay(double hoursWorked) {
		if(hoursWorked <= FULL_TIME) {
		return (hoursWorked * getHourlyWage());
		}else return ((FULL_TIME* getHourlyWage())
				+ overTimePay(overTimeHoursWorked(hoursWorked)));
	}
	
	/* @Descriptions 
	 * 		To calculate the federal Deductions tax.
	 * @Parameter
	 * 		grossPay - a values gross Pay.
	 * @Precondition
	 * 		grossPay is non-negative
	 * @Return
	 * 		the values of federal Deductions tax.
	 * @Thorws 	
	 * 		NullPointerException - Indicates grossPay is null.	
	 * */
	public double federalDeductions(double grossPay) {
		return grossPay * FEDERAL_TAX_RATE;
	}
	
	/* @Descriptions 
	 * 		To calculate the state Deductions tax.
	 * @Parameter
	 * 		grossPay - a values gross Pay.
	 * @Precondition
	 * 		grossPay is non-negative
	 * @Return
	 * 		the values of the state Deductions tax.
	 * @Thorws 	
	 * 		NullPointerException - Indicates grossPay is null.	
	 * */
	public double stateDeductions(double grossPay) {
		return grossPay * STATE_TAX_RATE;
	}
	
	/* @Descriptions 
	 * 		To calculate the total Deductions tax.
	 * @Parameter
	 * 		federalDeductions - a values the federal deductions Pay.
	 * 		stateDeductions - a values the state deductions Pay.
	 * @Precondition
	 * 		federalDeductions and stateDeductions are non-negative
	 * @Return
	 * 		the values of the total Deductions tax.
	 * @Thorws 	
	 * 		NullPointerException - Indicates federalDeductions or stateDeductions is null.	
	 * */
	public double totalDeductions(double federalDeductions,
			double stateDeductions) {
		return federalDeductions + stateDeductions;
	}
	
	/* @Descriptions 
	 * 		To sum all of net year income.
	 * @Parameter
	 * 		hoursPerPayPeriod - a sequence array of hourly worked.
	 * @Precondition
	 * 		hoursPerPayPeriod is a sequence of hourly worked are non-negative.
	 * @Return
	 * 		the values of the total netYearIncome.
	 * @Thorws 	
	 * 		NullPointerException - Indicates hoursPerPayPeriod is null.	
	 * */
	public double netYearIncome(int[] hoursPerPayPeriod) {
		int[] hoursPPP = hoursPerPayPeriod.clone();
		double sumAllDedu =0;
		for(int hour : hoursPPP) {
			sumAllDedu += totalDeductions(federalDeductions(grossPay(hour))
					, stateDeductions(grossPay(hour))) ;
		}
		return grossYearIncome(hoursPPP)-sumAllDedu;
	}
	
	/* @Descriptions 
	 * 		To sum all of gross Year Income.
	 * @Parameter
	 * 		hoursPerPayPeriod - a sequence array of hourly worked.
	 * @Precondition
	 * 		hoursPerPayPeriod is a sequence of hourly worked are non-negative.
	 * @Return
	 * 		the values of the total gross Year Income.
	 * @Thorws 	
	 * 		NullPointerException - Indicates hoursPerPayPeriod is null.	
	 * */
	public double grossYearIncome(int[] hoursPerPayPeriod) {
		int[] hoursPPP = hoursPerPayPeriod.clone();
		double sumAllIncome =0;
		for(int hour : hoursPPP) {
			sumAllIncome += grossPay(hour);
		}
		return sumAllIncome;
	}

	/* @Descriptions 
	 * 		To get info from PayCalculator
	 * @Parameter
	 * @Precondition
	 * @Return
	 * 		the current values of instance object convert to String.
	 * @Thorws 		
	 * */
	@Override
	public String toString() {
		return "PayCalculator [name=" + name + ", reportId=" 
	+ reportId + ", hourlyWage=" + hourlyWage + "]";
	}
	
}
