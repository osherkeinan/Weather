package il.ac.hit;
/**
 * Weather App
 * @author osher keinan <a href="mailto:osherkeinan@gmail.com">osherkeinan@gmail.com</a>,nir bonofiel <a href="mailto:nirbono10@gmail.com">nirbono10@gmail.com</a> and chen zafrir <a href="mailto:chen20032@gmail.com">chen20032@gmail.com</a> 
 *
 */
public class WeatherDataServiceException extends Exception {
	/**
	 * Constructs a new exception with the specified detail message and throwable with the primary exception.
	 * @param msg
	 * @param thr
	 */
	public WeatherDataServiceException(String msg, Throwable thr) {
		super(msg, thr);
	}
	/**
	 * Constructs a new exception with the specified detail message.
	 * @param thr  - throw exception  
	 */
	public WeatherDataServiceException(Throwable thr) {
		super(thr);
	}
	/**
	 * Constructs a new exception with the specified detail message.
	 * @param msg  - message with exception description 
	 */
	public WeatherDataServiceException(String msg) {
		super(msg);
	}
}
