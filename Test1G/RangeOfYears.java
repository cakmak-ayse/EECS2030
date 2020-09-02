

/**
 * A class that represents a range of years. A range has two properties: a
 * {@code minimum} year and a {@code maximum} year. Range objects always ensure
 * that the following class invariant is true:
 * 
 * <p>
 * {@code minimum <= maximum}
 * 
 * 
 */
public class RangeOfYears {
	private int minYear;
	private int maxYear;
	private int year;
	
	
	/**
	 * Initialize this range with minimum year of 0 and a maximum year of 2020.
	 */
	public RangeOfYears() {
		this(0, 2020);
	}

	/**
	 * Initialize this range with the specified minimum and maximum years.
	 * 
	 * @param min
	 *            the minimum year of the range
	 * @param max
	 *            the maximum year of the range
	 * @throws IllegalArgumentException
	 *             if min is greater than max
	 * @throws IllegalArgumentException
	 *             if min is less than 0
	 */
	public RangeOfYears(int min, int max) {
		this.maxYear = max;
		this.minYear = min;
		
		if (min < 0) {
			throw new IllegalArgumentException();
		}
		
		if (min > max ) {
			throw new IllegalArgumentException();
		}	
	}

	/**
	 * Returns the minimum year of the range
	 * 
	 * @return the minimum year of the range
	 */
	public int getMinimum() {
		return this.minYear;
	}

	/**
	 * Returns the maximum year of the range
	 * 
	 * @return the maximum year of the range
	 */
	public int getMaximum() {
		return this.maxYear;
	}

	/**
	 * Sets the minimum year of this range to the specified year.
	 * 
	 * @param min
	 *            the new minimum year for this range
	 * @return a reference to this range
	 * @throws IllegalArgumentException
	 *             if min is greater than the current maximum year of this range
	 */
	public RangeOfYears setMinimum(int min) {
		this.minYear = min;
		if (min > this.maxYear) {
			throw new IllegalArgumentException();
		}
		else {
			RangeOfYears result = new RangeOfYears();
			return result;
		}
	}

	/**
	 * Sets the maximum year of this range to the specified year.
	 * 
	 * @param max
	 *            the new maximum year for this range
	 * @return a reference to this range
	 * @throws IllegalArgumentException
	 *             if max is less than the current minimum year of this range
	 */
	public RangeOfYears setMaximum(int max) {
		this.maxYear = max;
		if (max < this.getMinimum()) {
			throw new IllegalArgumentException();
		}
		else {
			RangeOfYears result = new RangeOfYears();
			return result;
		}
	}

	/**
	 * Returns the number of years in this range that are leap years. See the
	 * test web page for the definition of a leap year.
	 * 
	 * @return the number of years in this range that are leap years
	 */
	public int numberOfLeapYears() {
		int count = 0;
		for (int year = this.getMinimum(); year <= this.getMaximum(); year++ ) {
			if (year % 4 == 0 && year % 100 != 0) {
				count++;
			}
			if (year % 400 == 0) {
				count++;
			}
		}
		return count;
		
	}

	/**
	 * Removes all years less than {@code year} from this range. For example,
	 * if this range is the range {@code [1900, 2020]} then {@code slice(2000)} changes this
	 * range to be the range {@code [2000, 2020]} (i.e., it removes the years 1900 through
	 * 1999 from this range).
	 * 
	 * @param year
	 *            the smallest year to keep in this range
	 * @return a reference to this range
	 * @throws IllegalArgumentException
	 *             if year is not contained in this range
	 */
	public RangeOfYears slice(int year) {
		this.year = year;
		if (this.contains(this.year)) {
			this.minYear = this.year;
			RangeOfYears result = new RangeOfYears();
			return result;
		} else throw new IllegalArgumentException();
	}

	/**
	 * Checks if {@code year} is inside this range. A year is considered inside
	 * this range if the year is greater than or equal to the minimum year of
	 * this range and year is less than or equal to the maximum year of this
	 * range.
	 * 
	 * @param year
	 *            the year to check
	 * @return true if year is inside this range, false otherwise
	 */
	public boolean contains(int year) {
		this.year = year;
		if (this.year >= this.getMinimum() && this.year <= this.getMaximum()) {
			return true;
		}
		else return false;
	}

	/**
	 * Returns a new range formed by the intersection of this range and the
	 * specified range. The intersection of two ranges is the range equal
	 * to the overlapping years of the two ranges. For example, the 
	 * intersection of the two ranges:
	 * 
	 * <p>
	 * {@code [2000, 2005]} and {@code [2004, 2010]} is the range {@code [2004, 2005]}.
	 * 
	 * <p>
	 * The range {@code [0, 0]} is returned if the two ranges do not overlap.
	 * 
	 * @param other the range to intersect with this range
	 * @return the new range equal to the intersection of this range and
	 * the other range
	 */
	public RangeOfYears intersect(RangeOfYears other) {
		if (this.maxYear < other.minYear || this.minYear > other.maxYear) {
			return new RangeOfYears(0, 0);
		}
		else if(other.contains(this.maxYear) && other.contains(this.minYear)) {
			return new RangeOfYears(this.minYear, this.maxYear);
		}
		else if (this.contains(other.maxYear) && this.contains(other.minYear)) {
			return new RangeOfYears(other.minYear, other.maxYear);
		}
		else if (this.contains(other.maxYear)) {
			return new RangeOfYears(this.minYear, other.maxYear);
		}
		else return new RangeOfYears(other.minYear, this.maxYear);
 	}

	/**
	 * Returns the string representation of a range. The string contains the
	 * minimum and maximum years separated by a comma and space all inside of a
	 * pair of square brackets. For example, the string
	 * 
	 * <p>
	 * {@code [2, 25]}
	 * 
	 * <p>
	 * represents the range whose minimum year is {@code 2} and whose maximum
	 * year is {@code 25}
	 * 
	 * @return a string representation of the range
	 * 
	 */
	@Override
	public String toString() {
		// already done!
		return "[" + this.getMinimum() + ", " + this.getMaximum() + "]";
	}

}
