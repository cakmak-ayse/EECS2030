package test1;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a weather forecast of exactly seven days. The first
 * day of the forecast is the weather for today. The forecast and its collection
 * of weather objects form a composition.
 * 
 * @author EECS2030 Fall 2016-17
 *
 */
public class WeeklyForecast extends Forecast {

    /**
     * The number of days in this forecast.
     */
    public static final int DAYS = 7;
    private List<Weather> weather;

    // ADD YOUR FIELDS HERE
    
    

    /**
     * Initializes this weekly weather forecast using the provided list of
     * weather objects. The size of the list must be equal to
     * <code>WeeklyForecast.DAYS</code> otherwise an exception is thrown.
     * 
     * @param weather
     *            the list of weather objects for this forecast
     * @throws IllegalArgumentException
     *             if the size of the list is not equal to WeeklyForecast.DAYS
     */

    public WeeklyForecast(List<Weather> weather) {
    	super(DAYS);
//        this.weather = weather;
//        this.weather = new ArrayList<Weather>(DAYS);
        if(weather.size() != DAYS) {
        	throw new IllegalArgumentException();
        }//

        this.weather = new ArrayList<Weather>(weather);

    }

    

	/**
     * Initializes this weekly weather forecast by copying another forecast.
     * 
     * @param other
     *            the forecast to copy
     */
    public WeeklyForecast(WeeklyForecast other) {
//    	super(DAYS);
//        other = new WeeklyForecast(weather);
        this(other.weather);
    }

    /**
     * Returns a deep copy of the list of weather objects for this forecast.
     * 
     * @return a deep copy of the list of weather objects for this forecast
     */
    public List<Weather> getWeather() {
    	List<Weather> result = new ArrayList<Weather>();
    	for(Weather temp : result) {
    		result.add(new Weather(temp));
    	}
    	return result;
    }

    /**
     * Get the predicted weather for <code>n</code> days from today.
     * 
     * @param n
     *            the number of days from today
     * @return the predicted weather n days in the future
     * @throws IllegalArgumentException
     *             if n is less than zero or greater than (WeeklyForecast.DAYS -
     *             1)
     */
    @Override
    public Weather getWeather(int n) {
    	if(n < 0 || n > 6) {
    		throw new IllegalArgumentException();
    	}
    	else return new Weather(this.weather.get(n));
        
    }

    /**
     * Returns a string representation of this weather forecast. The string
     * starts with "Seven day weather forecast:\n" and is followed by the string
     * returned by <code>Forecast.toString</code>.
     * 
     * @return a string representation of this weather forecast
     */
    @Override
    public String toString() {
		return "Seven day weather forecast:\n" + super.toString();
        
    }
}

