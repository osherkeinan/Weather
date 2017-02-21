package il.ac.hit;
/**
 * Weather App
 * @author osher keinan <a href="mailto:osherkeinan@gmail.com">osherkeinan@gmail.com</a>,nir bonofiel <a href="mailto:nirbono10@gmail.com">nirbono10@gmail.com</a> and chen zafrir <a href="mailto:chen20032@gmail.com">chen20032@gmail.com</a> 
 *
 */
public class WeatherDataServiceFactory {
	/**
	 * weather api type
	 *
	 */
	public enum weatherDataServiceFactory
	{
		OPEN_WEATHER_MAP;
	}
	/**
	 * 
	 * @param type
	 * @return IWeatherDataService
	 */
	public static IWeatherDataService getWeatherDataService(weatherDataServiceFactory type)
	{
		switch(type){
		case OPEN_WEATHER_MAP:
			return new OpenWeatherMap().getInstance();
		default:
			return null;
		}
	}
}
