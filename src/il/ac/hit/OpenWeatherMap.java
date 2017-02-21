package il.ac.hit;

import java.awt.geom.Point2D;
import java.io.*;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;


import javax.json.JsonReader;
/**
 * Weather App
 * @author osher keinan <a href="mailto:osherkeinan@gmail.com">osherkeinan@gmail.com</a>,nir bonofiel <a href="mailto:nirbono10@gmail.com">nirbono10@gmail.com</a> and chen zafrir <a href="mailto:chen20032@gmail.com">chen20032@gmail.com</a> 
 *
 */

public class OpenWeatherMap implements IWeatherDataService {
	
	private static OpenWeatherMap instance = null;
	/**
	 * singelton pattern, creat's instance of OpenWeatherMap
	 * @return instance of OpenWeatherMap
	 */
	public static OpenWeatherMap getInstance()
	{
		if(instance == null)
		{
			instance = new OpenWeatherMap();
		}
		
		return instance;
	}
	/**
	 * get weather description about city by the location 
	 * @param location - the location of the city the user looking for
	 * @return WeatherData object which presents the weather information 
	 * @throws WeatherDataServiceException
	 */
	@Override
	public WeatherData getWeatherData(Location location) throws WeatherDataServiceException {
		String cityName = location.getName();
		long id = location.getId();
		Point2D.Double coord = location.getCoord();
		String country = location.getCountry();
		WeatherData weatherData = new WeatherData();
		URL url = null;
		int zip = location.getZip();
		
		try {
			if(cityName != null)
			{
				url  = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&sys.sunrise=time&units=metric&appid=e3373a15556e423c3cab2b81baa124fe");
			}
			else if(id != 0)
			{
				url  = new URL("http://api.openweathermap.org/data/2.5/weather?id=" + id + "&units=metric&appid=e3373a15556e423c3cab2b81baa124fe");
			}
			else if(location.getCoord() != null)
			{
				url  = new URL("http://api.openweathermap.org/data/2.5/weather?lat=" + coord.getX() + "&units=metric&lon=" + coord.getY() + "&appid=e3373a15556e423c3cab2b81baa124fe");
			}
			else if(zip != 0 && country != null)
			{
				url  = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zip + "," + country + "&units=metric&appid=e3373a15556e423c3cab2b81baa124fe");
			}
			else
			{
				throw new WeatherDataServiceException("can't get Location");
			}
			InputStream is = url.openStream();
			JsonReader rdr = Json.createReader(is);
			JsonObject object = rdr.readObject();
			JsonObject main = object.getJsonObject("main");
			weatherData.setCityName(object.getString("name"));
			weatherData.setHumidity(Double.parseDouble("" + main.getJsonNumber("humidity")));
			weatherData.setTemp(Double.parseDouble("" + main.getJsonNumber("temp")));
			JsonObject weather = object.getJsonArray("weather").getJsonObject(0);
			weatherData.setMain(weather.getString("main"));
			weatherData.setDescription(weather.getString("description"));
			JsonObject system = object.getJsonObject("sys");
			weatherData.setCountry(system.getString("country"));
			weatherData.setId(Long.parseLong("" + object.getJsonNumber("id")));
			weatherData.setSunrise("" + system.getJsonNumber("sunrise"));
			weatherData.setSunset("" + system.getJsonNumber("sunset"));
			JsonObject wind = object.getJsonObject("wind");
			weatherData.setWindSpeed(Double.parseDouble("" + wind.getJsonNumber("speed")));
			JsonNumber windDegree = wind.getJsonNumber("deg");
			if(windDegree != null)
			{
				weatherData.setWindDegree(Double.parseDouble("" + windDegree));
			}
		} catch (IOException e) {
			throw new WeatherDataServiceException("City Not Found");
		
		} catch (NumberFormatException e) {
			throw new WeatherDataServiceException("Numbers Format error occured in communication with the server");
		}
		return weatherData;
	}

}
