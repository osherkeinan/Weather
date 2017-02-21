package il.ac.hit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/**
 * Weather App
 * @author osher keinan <a href="mailto:osherkeinan@gmail.com">osherkeinan@gmail.com</a>,nir bonofiel <a href="mailto:nirbono10@gmail.com">nirbono10@gmail.com</a> and chen zafrir <a href="mailto:chen20032@gmail.com">chen20032@gmail.com</a> 
 *
 */
public class WeatherData {
	
	private long id;
	private double temp;
	private String cityName;
	private String main;
	private String description;
	private double humidity;
	private double windSpeed;
	private double windDegree;
	private Date sunrise;
	private Date sunset;
	private String country;

	/**
	 * constructor with no parameters
	 */
	public WeatherData() {
		super();
	}
	/**
	 * constructor with all parameters
	 * @param id 
	 * @param temp
	 * @param name
	 * @param main
	 * @param description
	 * @param humidity
	 * @param windSpeed
	 * @param windDegree
	 * @param sunrise
	 * @param sunset
	 * @param country
	 */
	public WeatherData(long id, double temp, String name, String main, String description, double humidity, double windSpeed,
			double windDegree, String sunrise, String sunset, String country) {
		setId(id);
		setTemp(temp);
		setCityName(name);
		setMain(main);
		setDescription(description);
		setHumidity(humidity);
		setWindSpeed(windSpeed);
		setWindDegree(windDegree);
		setSunrise(sunrise);
		setSunset(sunset);
		setCountry(country);
	}
	/**
	 * get id
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * set id
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * get city name
	 * @return cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * set city name
	 * @param name
	 */
	public void setCityName(String name) {
		this.cityName = name;
	}
	/**
	 * get main weather
	 * @return main
	 */
	public String getMain() {
		return main;
	}
	/**
	 * set main weather
	 * @param main
	 */
	public void setMain(String main) {
		this.main = main;
	}
	/**
	 * get description weather
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * set description weather
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * get humidity
	 * @return humidity
	 */
	public double getHumidity() {
		return humidity;
	}
	/**
	 * set humidity
	 * @param humidity
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	/**
	 * get wind speed
	 * @return windSpeed
	 */
	public double getWindSpeed() {
		return windSpeed;
	}
	/**
	 * set wind speed
	 * @param windSpeed
	 */
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	/**
	 * get wind degree
	 * @return windDegree
	 */
	public double getWindDegree() {
		return windDegree;
	}
	/**
	 * set wind degree
	 * @param windDegree
	 */
	public void setWindDegree(double windDegree) {
		this.windDegree = windDegree;
	}
	/**
	 * get sunrise by time
	 * @return sunrise
	 */
	public String getSunrise() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss z"); 
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+2")); 
		return sdf.format(sunrise);
	}
	/**
	 * set sunrise by time
	 * @param sunrise
	 */
	public void setSunrise(String sunrise) {
		long unixSeconds = Long.parseLong(sunrise);
		this.sunrise = new Date(unixSeconds*1000L); 
	}
	/**
	 * get sunset by time
	 * @return sunset
	 */
	public String getSunset() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss z"); 
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+2")); 
		return sdf.format(sunset);
	}
	/**
	 * set sunset by time
	 * @param sunset
	 */
	public void setSunset(String sunset) {
		long unixSeconds = Long.parseLong(sunset);
		this.sunset = new Date(unixSeconds*1000L);
	}
	/**
	 * get country
	 * @return country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * set country
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * get temperature
	 * @return temp
	 */
	public double getTemp() {
		return temp;
	}
	/**
	 * set temperature
	 * @param temp
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}
	/**
	 * @return weather details
	 */
	@Override
	public String toString() {
		return "Weather in "+ cityName+","+ country +"\n"+"is " + main+","+description+"."+"\n"+ "the temperature is " + temp+ 
				"\n"+"humidity:" + (int)humidity +"%\n"+ "windSpeed:" + windSpeed +" meter/sec\n"+ "windDegree:" + (int)windDegree 
				+" deg\n" + "sunrise:" + this.getSunrise() +"\n"+ "sunset:" + this.getSunset() +"\n"+"city ID:" + id;
	}
	
}
