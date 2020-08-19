import java.util.Date;

public class Persons {
	private Date date;
	private String name;
	public Persons(String name, Date date) {
		this.date = date;
		this.name = name;
	}

	protected final String getDob() {
		return this.date.toString();
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n" + "DOB: " + date + "\n";
	}
}
