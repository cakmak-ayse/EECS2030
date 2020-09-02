import java.util.Date;

abstract public class Employee extends Person {
	private String name;
	private Date date;
	private String employeeId;
	
	public Employee(String name, Date dob, String id) {
		super(name, dob);
		this.name = name;
		this.date = dob;
		this.employeeId = id;
	}
	
	abstract protected String getEmployeeId();

	@Override
	public String toString() {
		return "Employee \n" + 
				"Name: " + name + 
				"\nDOB: " + date + 
				"\nEmployee Number: " + employeeId;
	}
	
	
	 
}
