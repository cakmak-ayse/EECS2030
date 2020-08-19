import java.util.Date;

public abstract class Employees extends Persons {	
	public Employees(String name, Date date) {
		super(name, date);
	}

	protected abstract String getId();
}
