package il.ac.hit;

import java.awt.geom.Point2D;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.*;

import il.ac.hit.WeatherDataServiceFactory.weatherDataServiceFactory;


public class Test {

	private JFrame frame;
	private JTextField text;
	public static void main(String[] args) 
		{
		
		try {
			Location location = new Location();
			//location.setCoord(new Point2D.Double(11,48));
			location.setId(293703);
			//location.setZip(94040);
			//location.setCountry("us");
			IWeatherDataService openWeatherMap  = WeatherDataServiceFactory.getWeatherDataService(weatherDataServiceFactory.OPEN_WEATHER_MAP);
			WeatherData data = openWeatherMap.getWeatherData(location);
			//System.out.println(data);
	} catch (WeatherDataServiceException e) {
		e.printStackTrace();
	}
	}


}
