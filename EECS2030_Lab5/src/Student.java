import java.util.Date;

public class Student extends Person {
	private String studentId;
	private String name;
	private Date date;

	
	protected Student(String name, Date dob, String id) {
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































