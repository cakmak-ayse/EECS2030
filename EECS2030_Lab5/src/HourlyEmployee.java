import java.util.Date;

public class HourlyEmployee extends Employee {

	private String name;
	private Date date;
	private String employeeId;
	private double hourlyRate;
	
	public HourlyEmployee(String name, Date dob, String id) {
		super(name, dob, id);
		this.name = name;
		this.date = dob;	
		this.employeeId = id;
	}

	protected double getHourlyRate() {
		return this.hourlyRate;
	}

	@Override
	protected String getEmployeeId() {
		return this.employeeId;
	}

	@Override
	public String toString() {
		return super.toString() + "\nHourly rate: " + hourlyRate + "\n";
	}
}
