import java.util.Date;

public class SalariedEmployees extends Employees {
	private String id;
	private double salary;
	
	public SalariedEmployees(String name, Date date, String emId) {
		super(name, date);
		this.id = emId;
	}

	protected void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	protected String getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Employee\n" + super.toString() + "Employee Number: " + id + "\nHourly rate: " + salary + "\n";
	}
	
}
