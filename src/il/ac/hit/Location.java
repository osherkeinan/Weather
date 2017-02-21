package il.ac.hit;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
/**
 * Weather App
 * @author osher keinan <a href="mailto:osherkeinan@gmail.com">osherkeinan@gmail.com</a>,nir bonofiel <a href="mailto:nirbono10@gmail.com">nirbono10@gmail.com</a> and chen zafrir <a href="mailto:chen20032@gmail.com">chen20032@gmail.com</a> 
 *
 */
public class Location {
	
	private long id;
	private String name;
	private int zip;
	private String country;
	private Point2D.Double coord;
	/**
	 * constructor with all parameters
	 * @param id
	 * @param name
	 * @param country
	 * @param coord
	 * @param zip
	 */
	public Location(long id, String name, String country, Double coord, int zip) {
		setId(id);
		setName(name);
		setCountry(country);
		setCoord(coord);
		setZip(zip);
	}
	/**
	 * constructor with no parameters
	 */
	public Location() {
		super();
	}
	/**
	 * get location by zip code
	 * @return zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * set location by zip code
	 * @param zip
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	/**
	 * get location by id
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * set location by id
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * get location by city name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * set location by city name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get location by country works with zip 
	 * @return country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * set location by country works with zip
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * get location by coordinates
	 * @return coord
	 */
	public Point2D.Double getCoord() {
		return coord;
	}
	/**
	 * set location by coordinates
	 * @param coord
	 */
	public void setCoord(Point2D.Double coord) {
		this.coord = coord;
	}
	
	
	
}
