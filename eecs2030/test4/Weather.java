package eecs2030.test4;

/**
 * A class that represents a description of the weather for a single day. Every
 * Weather instance has a temperature in degrees Celcius and a string describing
 * the weather for that day.
 * 
 * @author EECS2030 Fall 2016-17
 *
 */
public class Weather {

    private String description;
    private int temperature;

    /**
     * Initializes the temperature and description of this weather object.
     * 
     * @param temperature
     *            the average temperature in degrees Celcius for the day
     * @param description
     *            a description of the weather for the day
     */
    public Weather(int temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }

    /**
     * Initializes the temperature and description of this weather object
     * by copying another weather object.
     * 
     * @param other the weather object to copy
     */
    public Weather(Weather other) {
        this.temperature = other.temperature;
        this.description = other.description;
    }

    /**
     * Returns a description of the weather for the day.
     * 
     * @return a description of the weather for the day
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the weather to the given string.
     * 
     * @param description the string describing the weather for the day
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the average temperature for the day.
     * 
     * @return the average temperature for the day
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Sets the average temperature for the day to the given value.
     * 
     * @param temperature the average temperature for the day
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * Returns a hash code for this weather object.
     * 
     * @return a hash code for this weather object
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + temperature;
        return result;
    }

    /**
     * Compares two weather instances for equality. The result is
     * true if and only if the argument is not null and a
     * Weather object that has the same temperature and description
     * as this object.
     * 
     * @return true if the given object represents a Weather object
     * equivalent to this Weather object, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Weather other = (Weather) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (temperature != other.temperature)
            return false;
        return true;
    }

    /**
     * Returns a string representation of this weather object.
     * The string returned is the temperature followed by
     * " degrees Celcius, " followed by the description of
     * this weather object.
     * 
     * @return a string representation of this weather object
     */
    @Override
    public String toString() {
        return this.temperature + " degrees Celcius, " + this.description;
    }

}
