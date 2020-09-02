import java.util.Date;

public class Students extends Person {
	private String studentId;
	private String name;
	private Date date;

	
	protected Students(String name, Date dob, String id) {
		super(name, dob);
		studentId = id;
		this.name = name;
		this.date = dob;
	}
	
	protected String getStudentId() {
		return studentId;
	}
	
	@Override
	public String toString() {
		return "Student \n" + super.toString() +
				"Student Number: " + getStudentId() + "\n";
	}
	
}































