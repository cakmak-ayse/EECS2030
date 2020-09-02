

/**
 * A class that represents a range of values on the integer number line. A range
 * has two properties: a {@code minimum} value and a {@code maximum} value.
 * Range objects always ensure that the following class invariant is true:
 * 
 * <p>
 * {@code minimum <= maximum}
 * 
 * 
 */
public class Range2 {
	private int min;
	private int max;
	private int val;

	/**
	 * Initialize this range with minimum value -1 and a maximum value 1.
	 */
	public Range2() {
		this(-1, 1);
	}

	/**
	 * Initialize this range with the specified minimum and maximum values.
	 * 
	 * @param min
	 *            the minimum value of the range
	 * @param max
	 *            the maximum value of the range
	 * @throws IllegalArgumentException
	 *             if min is greater than max 
	 */
	public Range2(int min, int max) {
		this.max = max;
		this.min = min;
		if (this.min > this.max) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns the minimum value of the range
	 * 
	 * @return the minimum value of the range
	 */
	public int getMinimum() {
		return this.min;
	}

	/**
	 * Returns the maximum value of the range
	 * 
	 * @return the maximum value of the range
	 */
	public int getMaximum() {
		return this.max;
	}

	/**
	 * Sets the minimum value of this range to the specified value.
	 * 
	 * @param min
	 *            the new minimum value for this range
	 * @return a reference to this range
	 * @throws IllegalArgumentException
	 *             if min is greater than the current maximum value of this
	 *             range
	 */
	public Range2 setMinimum(int min) {
		this.min = min;
		if (this.min > this.max) {
			throw new IllegalArgumentException();
		}
		else return new Range2(this.min, this.max);
	}

	/**
	 * Sets the maximum value of this range to the specified value.
	 * 
	 * @param max
	 *            the new maximum value for this range
	 * @return a reference to this range
	 * @throws IllegalArgumentException
	 *             if max is less than the current minimum value of this range
	 */
	public Range2 setMaximum(int max) {
		this.max = max;
		if (this.max < this.min) {
			throw new IllegalArgumentException();
		}
		else return new Range2(this.min, this.max);
	}

	/**
	 * Removes all values greater than {@code value} from this range. For
	 * example, if this range is the range {@code [10, 20]} then {@code slice(15)}
	 * changes this range to be the range {@code [10, 15]} (i.e., it removes the
	 * values 16 through 20 from this range).
	 * 
	 * @param value
	 *            the greatest value to keep in this range
	 * @return a reference to this range
	 * @throws IllegalArgumentException
	 *             if value is not contained in this range
	 */
	public Range2 slice(int value) {
		if (!this.contains(value)) {
			throw new IllegalArgumentException();
		} 	return this.setMaximum(value);

		
	}

	/**
	 * Checks if {@code value} is inside this range. A value is considered
	 * inside this range if the value is greater than or equal to the minimum
	 * value of this range and value is less than or equal to the maximum value
	 * of this range.
	 * 
	 * @param value
	 *            the value to check
	 * @return true if value is inside this range, false otherwise
	 */
	public boolean contains(int value) {
		this.val = value;
		if(this.val >= this.min && this.val <= this.max) {
			return true;
		} else return false;
		
	}

	/**
	 * Checks if another range is entirely inside of this range. For example, if
	 * this range is the range {@code [10, 20]} and the other range is the range
	 * {@code [14, 16]} then the other range is inside of this range.
	 * 
	 * <p>
	 * If the other range is equal to this range (has the same minimum and
	 * maximum value) then this method returns {@code true}.
	 * 
	 * @param other
	 *            the range to check
	 * @return true if other is inside this range, false otherwise
	 */
	public boolean contains(Range2 other) {
		if (this.max == other.max && this.min == other.min) {
			return true;
		} else if (this.min <= other.min && this.max >= other.max) {
			return true;
		} else return false;
	}

	/**
	 * Removes all of the values of another range from this range. For example,
	 * if this range is the range {@code [10, 20]} and the other range is
	 * {@code [15, 25]} then {@code removeAll} will change this range to
	 * {@code [10, 14]} (i.e., it removes the values 15 through 20 from this
	 * range). If the other range does not overlap this range then no values are
	 * removed from this range.
	 * 
	 * <p>
	 * Only ranges that partially overlap this range or do not overlap this
	 * range at all can be passed as an argument to this method.
	 * 
	 * @param other
	 *            the other range containing values to remove from this range
	 * @return a reference to this range
	 * @throws IllegalArgumentException
	 *             if removing the values in other causes this range to be
	 *             empty or causes gaps in this range
	 */
	public Range2 removeAll(Range2 other) {
		if (other.contains(this) || this.contains(other)) {
			throw new IllegalArgumentException();
		}
		if (other.contains(this.min)) {
			this.setMinimum(other.max + 1);
		} else if (other.contains(this.max)) {
			this.setMaximum(other.min - 1);
		} return this;
	}

	/**
	 * Returns the string representation of a range. The string contains the
	 * minimum and maximum values separated by a comma and space all inside of a
	 * pair of square brackets. For example, the string
	 * 
	 * <p>
	 * {@code [2, 25]}
	 * 
	 * <p>
	 * represents the range whose minimum value is {@code 2} and whose maximum
	 * value is {@code 25}
	 * 
	 * @return a string representation of the range
	 * 
	 */
	@Override
	public String toString() {
		return "[" + this.getMinimum() + ", " + this.getMaximum() + "]";
	}

}
