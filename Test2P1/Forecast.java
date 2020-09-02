package test1;

public abstract class Forecast {
	private int lengthOfDays;
	
	Forecast(int nDays) {
		this.lengthOfDays = nDays;
	}

	public int daysInForecast() {
		return lengthOfDays;
	}


	public abstract Weather getWeather(int n);
	
	public final Weather getToday() {
		return getWeather(0);
	}
	
	@Override
	public String toString() {
		return "Forecast [lengthOfDays=" + lengthOfDays + "]";
	}

}
