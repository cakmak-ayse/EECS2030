import java.util.Date;

public class Students extends Persons {
	private String id;
	
	public Students(String name, Date date, String id) {
		super(name, date);
		this.id = id;
	}

	protected final String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student\n" + super.toString() + "Student Number: " + id + "\n";
	}
}
