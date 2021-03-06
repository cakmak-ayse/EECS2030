

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
public class Range3 implements Comparable<Range3> {
	
	private int min;
	private int max;
	private int val;
	
	/**
	 * Initialize this range with minimum value -1 and a maximum value 1.
	 */
	public Range3() {
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
	public Range3(int min, int max) {
		if(min > max) {
			throw new IllegalArgumentException();
		}
		this.max = max;
		this.min = min;
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
	 * Expands the width of this range by decreasing the minimum value of this
	 * range by 1 if possible. If the range cannot be expanded then nothing
	 * happens to this range.
	 * 
	 * @return a reference to this range
	 */
	public Range3 expandLeft() {
		if (this.min > Integer.MIN_VALUE) {
			this.min--;
		}
		return this;
	}

	/**
	 * Expands the width of this range by increasing the maximum value of this
	 * range by the specified amount if possible. If the range cannot be
	 * expanded then nothing happens to this range.
	 * 
	 * @return a reference to this range
	 * @throws IllegalArgumentException if amount is less than zero
	 */
	public Range3 expandRight(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException();
		} 
		else if ((0L + this.max + amount) <= Integer.MAX_VALUE) {
			this.max += amount;
		}
		return this;
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
		if (this.val <= this.max && this.val >= this.min) {
			return true;
		} else return false;
	}

	/**
	 * Compares this range to another range using the widths of the two ranges.
	 * The narrower range is considered to be "less than" the wider range.
	 * 
	 * @param other
	 *            range to compare
	 * @return a negative integer if this range is "less than" the other range,
	 *         a positive integer if this range is "greater than" the other
	 *         range, and 0 otherwise
	 */
	@Override
	public int compareTo(Range3 other) {
		long width = 0L + this.max - this.min;
		long otherWidth = 0L + other.max - other.min;
		return Long.compare(width, otherWidth);
	}

	/**
	 * A common interview question for software developers.
	 * 
	 * <p>
	 * Returns a string representation of this range where the string contains
	 * the values of this range (in order from the minimum to maximum value)
	 * where the values are separated by a comma and a space. If a value is
	 * evenly divisible by 3 then the string {@code "fizz"} appears instead of
	 * the value. If a value is evenly divisible by 5 then the string
	 * {@code "buzz"} appears instead of the value. If a value is evenly
	 * divisible by 3 and evenly divisible by 5 then the string
	 * {@code "fizzbuzz"} appears instead of the value. For example, the range
	 * {@code [10, 15]} will produce the string equal to:
	 * 
	 * <p>
	 * {@code "buzz, 11, fizz, 13, 14, fizzbuzz"}
	 */
	public String fizzBuzz() {
		StringBuilder app = new StringBuilder();
		for (int i = this.min; i <= this.max; i++) {
			if (this.contains(i) && i % 3 == 0 && i % 5 == 0) {
				app.append("fizzbuzz");
			} else if (this.contains(i) && i % 5 == 0) {
				app.append("buzz");
			} else if (this.contains(i) && i % 3 == 0) {
				app.append("fizz");
			} else app.append(i);
			if(i < this.max) {
				app.append(", ");
			}
		}
		return app.toString();
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
