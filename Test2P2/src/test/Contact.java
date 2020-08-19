package test;

public class Contact implements Comparable<Contact> {
	private String name;
	private long number;
	
	public Contact(String name, long number) {
		String length = String.valueOf(number);
		if(length.length() != 10) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.number = number;
		
	}
	
	public Contact(Contact other) {
		this(other.name, other.number);
	}
	
	
	public String getName() {
		return name;
	}
	
	public long getNumber() {
		return number;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (number ^ (number >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public int compareTo(Contact o) {
		// TODO Auto-generated method stub
		int result = 0;
		if(this.name.compareTo(o.name) < o.name.compareTo(this.name)) {
			result = -1;
		}
		else if (this.name.compareTo(o.name) > o.name.compareTo(this.name)) {
			result = 1;
		}
		return result;
	}

	@Override
	public String toString() {
		String stringNum = String.valueOf(number);
		return name + " (" + stringNum.substring(0, 3) + ") " + stringNum.substring(4, 6) + "-" + stringNum.substring(7, 10);
	}

	
}
