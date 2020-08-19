import java.util.Date;

public class GraduateStudents extends Students{
	private String sup;
	
	public GraduateStudents(String name, Date date, String id) {
		super(name, date, id);
	}

	protected void setThesisSupervisor(String supervisor) {
		this.sup = supervisor;
	}

	protected String getThesisSupervisor() {
		return this.sup;
	}

	@Override
	public String toString() {
		return "Graduate " + super.toString() + "Thesis Supervisor: " + sup + "\n" ;
	}
}
