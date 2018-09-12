package edu.century.pa1;

public class PayCalculator implements Constants {
	private String name;
	private int reportId =1000;
	private double hourlyWage;
	private static int increment = 0;
	/*Constructor
	 * */
	public PayCalculator(String name, double hourlyWage) {
		super();
		
		this.name = name;
		this.reportId += increment;
		this.hourlyWage = hourlyWage;
		increment += 10;
	}
	
	/* getName
	 * 		public String getName()
	 * 		to get name from PayCalculator
	 * 		Return:
	 * 			the string name of PayCalculator.
	 * */
	public String getName() {
		return name;
	}
	
	/* setName
	 * 		public void setName(String name)
	 * 		to set name to PayCalculator.
	 * 		Parameters: name - a String name that set to PayCalculator
	 * 		Return: void.
	 * */
	public void setName(String name) {
		this.name = name;
	}
	
	/* getReportId
	 * 		public int getReportId()
	 * 		To get the Report Id PayCalculator
	 * 		Return:
	 * 			the Report ID of PayCalculator.
	 * */
	public int getReportId() {
		return reportId;
	}
	
	/* setReportId
	 * 		public void setReportId(int reportId)
	 * 		to set a ID to PayCalculator.
	 * 		Parameters: reportId - a report Id that set to PayCalculator
	 * 		Return: void.
	 * */
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	
	/* getHourlyWage
	 * 		public double getHourlyWage()
	 * 		to get hourly wage form PayCalculator
	 * 		Return:
	 * 			the Report ID of PayCalculator.
	 * */
	public double getHourlyWage() {
		return hourlyWage;
	}
	
	/* setHourlyWage
	 * 		public void setHourlyWage(double hourlyWage)
	 * 		to set hourly wage to PayCalculator
	 * 		Parameters: hourlyWage - a value of hourly Wage that set to PayCalculator
	 * 		Return: void.
	 * */
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
	/* increaseHourlyWage
	 * 		public void increaseHourlyWage(double raiseRate) 
	 * 			to increase Hourly Wage to PayCalculator
	 * 		Parameters: raiseRate - a value of raise Rate that increase HourlyWage
	 * 		Return: void.
	 * */
	public void increaseHourlyWage(double raiseRate) {
		this.hourlyWage = this.hourlyWage * (1+ (raiseRate/100));
	}
	
	/* overTimeHoursWorked
	 * 		public double overTimeHoursWorked(double hoursWorked) 
	 * 			to calculate over Time Hours Worked
	 * 		Parameters: hoursWorked - a values of hours Worked
	 * 		Return: the values of over Time Hours Worked.
	 * */
	public double overTimeHoursWorked(double hoursWorked) {
		if(hoursWorked > FULL_TIME)
		return (hoursWorked - FULL_TIME);
		else return 0.0;
	}
	
	/* overTimePay
	 * 		public double overTimePay(double overTimeHours)  
	 * 			to calculate over Time Hours pay.
	 * 		Parameters: overTimeHours - a values over Time hours Worked
	 * 		Return: the values of money over Time Hours Worked.
	 * */
	public double overTimePay(double overTimeHours) {
		return (overTimeHours*(getHourlyWage()*OVERTIME_RATE));
	}
	
	/* netPay
	 * 		public double netPay(double hoursWorked)  
	 * 			to calculate the net pay.
	 * 		Parameters: hoursWorked - a values hours Worked
	 * 		Return: the values of net Pay.
	 * */
	public double netPay(double hoursWorked) {
		return (grossPay(hoursWorked) - totalDeductions(
				federalDeductions(grossPay(hoursWorked)),
				stateDeductions(grossPay(hoursWorked))));
	}
	
	/* grossPay
	 * 		public double grossPay(double hoursWorked)  
	 * 			to calculate the gross pay.
	 * 		Parameters: hoursWorked - a values hours Worked
	 * 		Return: the values of gross Pay.
	 * */
	public double grossPay(double hoursWorked) {
		if(hoursWorked <= FULL_TIME) {
		return (hoursWorked * getHourlyWage());
		}else return ((FULL_TIME* getHourlyWage())
				+ overTimePay(overTimeHoursWorked(hoursWorked)));
	}
	
	/* federalDeductions
	 * 		public double federalDeductions(double grossPay)  
	 * 			to calculate the federal Deductions tax.
	 * 		Parameters: grossPay - a values gross pay.
	 * 		Return: the values of federal Deductions tax.
	 * */
	public double federalDeductions(double grossPay) {
		return grossPay * FEDERAL_TAX_RATE;
	}
	
	/* stateDeductions
	 * 		public double stateDeductions(double grossPay) 
	 * 			to calculate the state Deductions tax.
	 * 		Parameters: grossPay - a values gross pay.
	 * 		Return: the values of state Deductions tax.
	 * */
	public double stateDeductions(double grossPay) {
		return grossPay * STATE_TAX_RATE;
	}
	
	/* totalDeductions
	 * 		public double totalDeductions(double federalDeductions, double stateDeductions) 
	 * 			to calculate the total Deductions tax.
	 * 		Parameters: federalDeductions - the values of federal Deductions tax.
	 * 					stateDeductions   - the values of state Deductions tax.
	 * 		Return: the values of total Deductions tax.
	 * */
	public double totalDeductions(double federalDeductions,
			double stateDeductions) {
		return federalDeductions + stateDeductions;
	}
	
	/* netYearIncome
	 * 		public double netYearIncome(int[] hoursPerPayPeriod) 
	 * 			to sum all of net year income.
	 * 		Parameters: hoursPerPayPeriod - the array of hours worked.
	 * 		Return: the values of total netYearIncome.
	 * 		Throws: array null exceptions.
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
	
	/* grossYearIncome
	 * 		public double grossYearIncome(int[] hoursPerPayPeriod)
	 * 			to sum all of gross Year Income.
	 * 		Parameters: hoursPerPayPeriod - the array of hours worked.
	 * 		Return: the values of total gross Year Income.
	 * 		Throws: array null exceptions. 
	 * */
	public double grossYearIncome(int[] hoursPerPayPeriod) {
		int[] hoursPPP = hoursPerPayPeriod.clone();
		double sumAllIncome =0;
		for(int hour : hoursPPP) {
			sumAllIncome += grossPay(hour);
		}
		return sumAllIncome;
	}

	/* toString
	 * 		public String toString()
	 * 		to get info from PayCalculator
	 * 		Return:
	 * 			the values of PayCalculator to string.
	 * */
	@Override
	public String toString() {
		return "PayCalculator [name=" + name + ", reportId=" 
	+ reportId + ", hourlyWage=" + hourlyWage + "]";
	}
	
}
