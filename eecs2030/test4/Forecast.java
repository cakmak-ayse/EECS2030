package eecs2030.test4;

/**
 * A class that represents a weather forecast for one or more
 * days. 
 * 
 * @author EECS2030 Fall 2016-17
 *
 */
public abstract class Forecast {

    private final static int[] AVG_TEMP = { 5, 5, 5, 4, 4, 3, 3 };
    private int nDays;

    /**
     * Initializes a forecast of length <code>nDays</code>.
     * 
     * @param nDays the number of days in this weather forecast
     * @throws IllegalArgumentException if nDays is less than one
     */
    public Forecast(int nDays) {
        if (nDays < 1) {
            throw new IllegalArgumentException(
                    "Forecast must have at least 1 day.");
        }
        this.nDays = nDays;
    }

    /**
     * Get the predicted weather for today. This method
     * returns the same value as <code>getWeather(0)</code>.
     * 
     * @return the predicted weather for today
     */
    public final Weather getToday() {
        return this.getWeather(0);
    }

    /**
     * Get the predicted weather for <code>n</code> days
     * from today.
     * 
     * @param n the number of days from today
     * @return the predicted weather n days in the future
     * @throws IllegalArgumentException
     *             if n is less than zero or greater than the
     *             number of days in the forecast minus 1
     */
    public abstract Weather getWeather(int n);

    /**
     * Returns the number of days in this weather forecast.
     * 
     * @return the number of days in this weather forecast
     */
    public int daysInForecast() {
        return this.nDays;
    }

    /**
     * Returns a string representation of this weather forecast.
     * The returned string has one line for each day of the forecast describing
     * the weather for that day. Each line starts with a description
     * of how the temperature for that day compares to the seasonal average
     * temperature for that day, and is followed by a string equal to
     * that returned by <code>Weather.toString</code>.
     * 
     * @return a string representation of this weather forecast
     * 
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.nDays; i++) {
            Weather w = this.getWeather(i);
            System.out.println(w);
            if (w.getTemperature() < Forecast.AVG_TEMP[i] - 1) {
                s.append("Cooler than normal. ");
            } else if (w.getTemperature() > Forecast.AVG_TEMP[i] + 1) {
                s.append("Warmer than normal. ");
            } else {
                s.append("Seasonal. ");
            }
            s.append(w.toString());
            s.append("\n");
        }
        return s.toString();
    }

}
