import java.util.Date;

public class GraduateStudent extends Student{
	private String supName;
	private String name;
	private Date date;
	private String id;
	
		
	protected GraduateStudent(String name, Date dob, String id) {
		super(name, dob, id);
		this.name = name;
		this.date = dob;
		this.id = id;
	}

	protected void setThesisSupervisor(String supervisorName) {
		this.supName = supervisorName;
	}

	protected String getThesisSupervisor() {
		return this.supName;
	}

	@Override
	public String toString() {
		return "Graduate Student \n" + 
				"Name: " + name + 
				"\nDOB: " + date + 
				"\nStudent Number: " + id +
				"\nThesis Supervisor: " + getThesisSupervisor() + "\n";
	}
	
	
	
	
	
}
