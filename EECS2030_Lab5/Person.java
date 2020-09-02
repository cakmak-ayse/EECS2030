import java.util.Date;

class Person {
	 private Date dateOfBirth;
	 private String name;
	
	// use protected if there is a subclass that is in another package
	 protected Person(String nameOfPerson, Date dob) {
		dateOfBirth = dob;
		name = nameOfPerson;
	}
	
	// use protected if there is a subclass that is in another package
	protected final Date getDob() {
		return dateOfBirth;
	}
	
	// use protected if there is a subclass that is in another package
	protected final String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() + "\n" + "DOB: " + getDob() + "\n";
	}
}
