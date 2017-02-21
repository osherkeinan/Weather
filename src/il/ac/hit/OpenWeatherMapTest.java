package il.ac.hit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import il.ac.hit.WeatherDataServiceFactory.weatherDataServiceFactory;

public class OpenWeatherMapTest {
	private static OpenWeatherMap openWeatherMap;
	private WeatherData data;
	private Location location;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		openWeatherMap = (OpenWeatherMap) WeatherDataServiceFactory.getWeatherDataService(weatherDataServiceFactory.OPEN_WEATHER_MAP);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		location = new Location();
		location.setName("TelAviv");
		data = openWeatherMap.getWeatherData(location);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWeatherData() {
		OpenWeatherMap openWeatherMapToTest = (OpenWeatherMap) WeatherDataServiceFactory.getWeatherDataService(weatherDataServiceFactory.OPEN_WEATHER_MAP);
		try {
			WeatherData dataToTest = openWeatherMapToTest.getWeatherData(location);
			double actualTemp = dataToTest.getTemp();
			double expectedTemp = data.getTemp();
			assertEquals("Testing Temp",expectedTemp, actualTemp, 0.05);
		} catch (WeatherDataServiceException e) {
			e.printStackTrace();
		}
	}

}
