package il.ac.hit;
/**
 * IWeatherDataService
 * @author osher keinan <a href="mailto:osherkeinan@gmail.com">osherkeinan@gmail.com</a>, nir bonofiel <a href="mailto:nirbono10@gmail.com">nirbono10@gmail.com</a> and chen zafrir <a href="mailto:chen20032@gmail.com">chen20032@gmail.com</a>
 *
 */
import java.util.List;
/**
 * Weather App
 * @author osher keinan <a href="mailto:osherkeinan@gmail.com">osherkeinan@gmail.com</a>,nir bonofiel <a href="mailto:nirbono10@gmail.com">nirbono10@gmail.com</a> and chen zafrir <a href="mailto:chen20032@gmail.com">chen20032@gmail.com</a> 
 *
 */
public interface IWeatherDataService 	{
	/**
	 * get weather description about city by the location 
	 * @param location - the location of the city the user looking for
	 * @return WeatherData object which presents the weather information 
	 * @throws WeatherDataServiceException
	 */
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException;
}
