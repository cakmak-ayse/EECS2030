package test1;

import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weather weather1 = new Weather(28, "Really hot day");
		System.out.println(weather1.toString() + "\n");
				
		Weather weather2 = new Weather(2, "cold day");
		Weather weather3 = new Weather(-88, "Really cold day");
		Weather weather4 = new Weather(20, "Perfect day");
		Weather weather5 = new Weather(99, "Way too hot");
		Weather weather6 = new Weather(17, "Not too hot, not too cold");
		Weather weather7 = new Weather(11, "ight day");
		
		List<Weather> weather = new ArrayList<Weather>();
		weather.add(weather1);
		weather.add(weather2);
		weather.add(weather3);
		weather.add(weather4);
		weather.add(weather5);
		weather.add(weather6);
		weather.add(weather7);
		
		WeeklyForecast test = new WeeklyForecast(weather);
//		for(Weather w : weather) {
//			w = new WeeklyForecast(weather);
//		}
		System.out.println(test.getWeather(6));

	}

}
