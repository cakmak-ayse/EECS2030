

/**
 * A class that represents the time of day in hours and minutes such as might be
 * used on a digital alarm clock. Times before noon (AM) are different from
 * times from noon onwards (PM).
 *
 * <p>
 * Times start at 12:00 AM (midnight) and go up to 11:59 PM.
 */
public class TimeOfDay {
	private int hour;
	private int min;
	private boolean isAM;
	
	
	/**
	 * Initializes this time to 12:00 AM (midnight).
	 */
	public TimeOfDay() {
		this(12, 00, true);
	}

	/**
	 * Initializes this time to the specified hours and minutes. If {@code isAM}
	 * is true then the time is before noon, otherwise the time is from noon
	 * onwards.
	 * 
	 * @param hour
	 *            the hour of this time
	 * @param minute
	 *            the minute of this time
	 * @param isAM
	 *            if true then the time is before noon, otherwise the time is
	 *            from noon onwards
	 * @throws IllegalArgumentException
	 *             if hour is not between 1 and 12, inclusive
	 * @throws IllegalArgumentException
	 *             if minute is not between 0 and 59, inclusive
	 */
	public TimeOfDay(int hour, int minute, boolean isAM) {
		if (hour < 1 || hour > 12 || minute < 0 || minute > 59) {
			throw new IllegalArgumentException();
		}
		this.hour = hour;
		this.min = minute;
		this.isAM = isAM;
	}

	/**
	 * Initializes this time by copying the hour, minute, and AM/PM indicator
	 * form another {@code TimeOfDay} instance.
	 * 
	 * @param other
	 *            the time to copy
	 */
	public TimeOfDay(TimeOfDay other) {
		this.hour = other.hour;
		this.min = other.min;
		this.isAM = other.isAM;
	}

	/**
	 * Returns the hour of this time. The returned value is between 1 and 12,
	 * inclusive.
	 * 
	 * @return the hour of this time
	 */
	public int getHour() {
		return this.hour;
	}

	/**
	 * Returns the minute of this time. The returned value is between 0 and 59,
	 * inclusive.
	 * 
	 * @return the minute of this time
	 */
	public int getMinute() {
		return this.min;
	}

	/**
	 * Sets the hour of this time to the specified hour.
	 * 
	 * @param hour
	 *            the new hour of this time
	 * @return a reference to this object
	 * @throws IllegalArgumentException
	 *             if hour is not between 1 and 12, inclusive
	 */
	public TimeOfDay setHour(int hour) {
		if (hour < 1 || hour > 12) {
			throw new IllegalArgumentException();
		}
		this.hour = hour;
		return this;	}

	/**
	 * Sets the minute of this time to the specified minute.
	 * 
	 * @param minute
	 *            the new minute of this time
	 * @return a reference to this object
	 * @throws IllegalArgumentException
	 *             if minute is not between 0 and 59, inclusive
	 */
	public TimeOfDay setMinute(int minute) {
		if (minute < 0 || minute > 59) {
			throw new IllegalArgumentException();
		} 
		this.min = minute;
		return this;
	}

	/**
	 * Returns true if the time is before noon, and false otherwise.
	 * 
	 * @return true if the time is before noon, and false otherwise
	 */
	public boolean isAM() {
		return this.isAM;
	}

	/**
	 * Advances the time forward by the specified number of minutes, or winds
	 * back the time by the specified number of minutes if {@code minutes} is
	 * negative. For example, if the current time is 10:15 AM then advancing the
	 * time by +3 minutes changes the time to 10:18 AM. If the current time is
	 * 10:15 AM then advancing the time by -3 minutes changes the time to 10:12
	 * AM.
	 * 
	 * <p>
	 * The time can be advanced past the end of the day in which case the time
	 * wraps around towards the start of the day. For example, if the current
	 * time is 11:59 PM then advancing the time by +2 minutes changes the time
	 * to 12:01 AM.
	 * 
	 * <p>
	 * Similarly, the time can be wound back past the start of the day, in which
	 * case the time wraps around towards the end of the day. For example, if
	 * the current time is 12:01 AM then advancing the time by -2 minutes
	 * changes the time to 11:59 PM.
	 * 
	 * @param minutes the number of minutes to advance the time
	 * @return a reference to this object
	 */
	public TimeOfDay advance(int minutes) {

		return null;
	}

	
	/**
	 * Returns a string representation of this time. The string representation
	 * is the hour followed by a colon followed by the minutes followed by 
	 * a space followed by the string {@code "AM"} or {@code "PM"}. For
	 * example the string representation of the time five minutes after
	 * three in the afternoon is the string equal to {@code "3:05 PM"}.
	 * 
	 * @return a string representation of this time
	 */
	@Override
	public String toString() {
		String m = "AM";
		if (!this.isAM()) {
			m = "PM";
		} 
		return String.format("%s:%02d ", this.getHour(), this.getMinute()) + m;
	
	}

}
