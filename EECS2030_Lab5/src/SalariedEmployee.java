import java.util.Date;

public class SalariedEmployee extends Employee {

	private String name;
	private Date date;
	private String employeeId;
	private double salaryRate;
	
	public SalariedEmployee(String name, Date dob, String id) {
		super(name, dob, id);
		this.name = name;
		this.date = dob;	
		this.employeeId = id;
	}

	protected void setSalary(double rate) {
		this.salaryRate = rate;
	}
	
	protected double getSalary() {
		return this.salaryRate;
	}
	
	@Override
	protected String getEmployeeId() {
		return this.employeeId;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nSalary: " + salaryRate + "\n";
	}
}
