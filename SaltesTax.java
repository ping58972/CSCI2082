	
public class SaltesTax {
	public final double STATE_TAX =0.04;
	 public final double COUNTY_TAX =0.02;
	private double saltesTax;

	public SaltesTax(double saltesTax) {
		super();
		this.saltesTax = saltesTax;
	}

	public double getSaltesTax() {
		return saltesTax;
	}

	public void setSaltesTax(double saltesTax) {
		this.saltesTax = saltesTax;
	}
	public double totalSales() {
		return (STATE_TAX + COUNTY_TAX )*this.saltesTax;
	}
	
	public static void main(String[] args) {
		SaltesTax salts = new SaltesTax(120) ;
		System.out.print(salts.totalSales());
	}
}
