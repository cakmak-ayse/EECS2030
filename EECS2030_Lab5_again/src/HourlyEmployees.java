import java.util.Date;

public class HourlyEmployees extends Employees {
	private String id;
	private double hourlyRate;
	
	public HourlyEmployees(String name, Date date, String emId) {
		super(name, date);
		this.id = emId;
	}

	protected double getHourlyRate() {
		return hourlyRate;
	}

	protected void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	protected String getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Employee\n" + super.toString() + "Employee Number: " + id + "\nHourly rate: " + hourlyRate + "\n";
	}
	
}
