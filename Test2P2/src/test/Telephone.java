package test;

import java.util.ArrayList;
import java.util.List;

public abstract class Telephone {
	private long number;
    List<Contact> contactlist = new ArrayList<>();
	
	public Telephone(long number) {
		String length = String.valueOf(number);
		if(length.length() != 10) {
			throw new IllegalArgumentException();
		}
		this.number = number;
	}
	
	public Telephone(Telephone other) {
		this(other.number);

	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public abstract void call(Contact contact);
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Telephone other = (Telephone) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String stringNum = String.valueOf(number);
		return " (" + stringNum.substring(0, 3) + ") " + stringNum.substring(4, 6) + "-" + stringNum.substring(7, 10);

	}


}
