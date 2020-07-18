import java.util.Date;

public class Person {
	Date dateOfBirth;
	String name;
	
	
	public Person(String name, Date dob) {
		dateOfBirth = dob;
		this.name = name;
	}
	
	public final Date getDob() {
		return this.dateOfBirth;
	}
	
	public final String getName() {
		return this.name;
	}
}
