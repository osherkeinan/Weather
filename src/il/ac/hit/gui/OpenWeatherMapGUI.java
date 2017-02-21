package il.ac.hit.gui;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import il.ac.hit.IWeatherDataService;
import il.ac.hit.Location;
import il.ac.hit.WeatherData;
import il.ac.hit.WeatherDataServiceException;
import il.ac.hit.WeatherDataServiceFactory;
import il.ac.hit.WeatherDataServiceFactory.weatherDataServiceFactory;

import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OpenWeatherMapGUI {

	private JFrame frame;
	private JTextField cityNameTextField;
	private JTextField cityIdTextField;
	private JTextField coordinatesXTextField;
	private JTextField coordinatesYTextField;
	private JTextField ZipTextField;
	private JTextField countryTextField;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenWeatherMapGUI window = new OpenWeatherMapGUI();
					window.frame.setVisible(true);
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OpenWeatherMapGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Open Weather Map App");
		frame.setBounds(100, 100, 458, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLocationBy = new JLabel("Location By:");
		lblLocationBy.setBounds(10, 11, 72, 25);
		frame.getContentPane().add(lblLocationBy);
		
		JRadioButton rdbtnCityName = new JRadioButton("City Name");
		rdbtnCityName.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(rdbtnCityName.isSelected() == false)
				{
					cityNameTextField.setVisible(false);
				}
			}
		});
		rdbtnCityName.setSelected(true);
		rdbtnCityName.setBounds(6, 41, 104, 23);
		frame.getContentPane().add(rdbtnCityName);
		
		JRadioButton rdbtnCityId = new JRadioButton("City Id");
		rdbtnCityId.setBounds(6, 67, 67, 23);
		frame.getContentPane().add(rdbtnCityId);
		rdbtnCityId.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            cityIdTextField.setVisible(true);
	            cityIdTextField.setText("Enter City Id");
	        }
	    });
		rdbtnCityId.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(rdbtnCityId.isSelected() == false)
				{
					cityIdTextField.setVisible(false);
				}
		}
		});
		JRadioButton rdbtnCoordinates = new JRadioButton("Coordinates");
		rdbtnCoordinates.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            coordinatesXTextField.setVisible(true);
	            coordinatesXTextField.setText("Enter X");
	            coordinatesYTextField.setVisible(true);
	            coordinatesYTextField.setText("Enter Y");
	        }
	    });
		rdbtnCoordinates.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(rdbtnCoordinates.isSelected() == false)
				{
					coordinatesXTextField.setVisible(false);
					coordinatesYTextField.setVisible(false);
				}
		}
		});
		rdbtnCoordinates.setBounds(6, 93, 124, 23);
		frame.getContentPane().add(rdbtnCoordinates);
		
		JRadioButton rdbtnZipCode = new JRadioButton("Zip Code");
		rdbtnZipCode.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ZipTextField.setVisible(true);
	            ZipTextField.setText("Enter zip");
	            countryTextField.setVisible(true);
	            countryTextField.setText("Enter Country");
	        }
	    });
		rdbtnZipCode.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(rdbtnZipCode.isSelected() == false)
				{
					ZipTextField.setVisible(false);
					countryTextField.setVisible(false);
				}
		}
		});
		rdbtnZipCode.setBounds(6, 119, 76, 23);
		frame.getContentPane().add(rdbtnZipCode);
		
		 ButtonGroup editableGroup = new ButtonGroup();
		    editableGroup.add(rdbtnCityName);
		    editableGroup.add(rdbtnCityId);
		    editableGroup.add(rdbtnCoordinates);
		    editableGroup.add(rdbtnZipCode);

		    rdbtnCityName.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            cityNameTextField.setVisible(true);
		            cityNameTextField.setText("Enter City Name");

		        }
		    });
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			 public void actionPerformed(ActionEvent e)
		      {
				Location location = new Location();
				try {
				if(rdbtnCityName.isSelected())
				{
					location.setName(cityNameTextField.getText().replaceAll("\\s+",""));
				}
				else if(rdbtnCityId.isSelected())
				{
					location.setId(Long.parseLong(cityIdTextField.getText().replaceAll("\\s+","")));
				}
				else if(rdbtnCoordinates.isSelected())
				{
					location.setCoord(new Point2D.Double(Double.parseDouble(coordinatesXTextField.getText().replaceAll("\\s+","")), Double.parseDouble(coordinatesYTextField.getText().replaceAll("\\s+",""))));
				}
				else if(rdbtnZipCode.isSelected())
				{
					location.setZip(Integer.parseInt(ZipTextField.getText().replaceAll("\\s+","")));
					location.setCountry(countryTextField.getText().replaceAll("\\s+",""));
				}
				
				IWeatherDataService openWeatherMap  = WeatherDataServiceFactory.getWeatherDataService(weatherDataServiceFactory.OPEN_WEATHER_MAP);	
					WeatherData wData = openWeatherMap.getWeatherData(location);
					textArea_1.setVisible(true);
					textArea_1.setText(wData.toString());
				} catch (WeatherDataServiceException ex) {
					textArea_1.setText(ex.getMessage());
					textArea_1.setVisible(true);
				}
					catch (NumberFormatException ex) {
						textArea_1.setText("Numbers Format error\nThe serch by City id, Coordinates and Zip expect numbers");
						textArea_1.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(335, 134, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		cityNameTextField = new JTextField();
		cityNameTextField.setText("Enter City Name");
		cityNameTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				cityNameTextField.setText("");
			}
		});
		cityNameTextField.setBounds(138, 40, 150, 25);
		frame.getContentPane().add(cityNameTextField);
		cityNameTextField.setColumns(10);
		
		cityIdTextField = new JTextField();
		cityIdTextField.setVisible(false);
		cityIdTextField.setBounds(138, 66, 150, 24);
		cityIdTextField.setText("Enter City Id");
		cityIdTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				cityIdTextField.setText("");
			}
		});
		frame.getContentPane().add(cityIdTextField);
		cityIdTextField.setColumns(10);
		
		coordinatesXTextField = new JTextField();
		coordinatesXTextField.setVisible(false);
		coordinatesXTextField.setBounds(136, 94, 61, 20);
		coordinatesXTextField.setText("Enter X");
		coordinatesXTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				coordinatesXTextField.setText("");
			}
		});
		frame.getContentPane().add(coordinatesXTextField);
		coordinatesXTextField.setColumns(10);
		
		coordinatesYTextField = new JTextField();
		coordinatesYTextField.setVisible(false);
		coordinatesYTextField.setBounds(207, 94, 81, 20);
		coordinatesYTextField.setText("Enter Y");
		coordinatesYTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				coordinatesYTextField.setText("");
			}
		});
		frame.getContentPane().add(coordinatesYTextField);
		coordinatesYTextField.setColumns(10);
		
		ZipTextField = new JTextField();
		ZipTextField.setVisible(false);
		ZipTextField.setBounds(138, 120, 61, 20);
		ZipTextField.setText("Enter zip");
		ZipTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ZipTextField.setText("");
			}
		});
		frame.getContentPane().add(ZipTextField);
		ZipTextField.setColumns(10);
		
		countryTextField = new JTextField();
		countryTextField.setVisible(false);
		countryTextField.setBounds(207, 120, 81, 20);
		countryTextField.setText("Enter zip");
		countryTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				countryTextField.setText("");
			}
		});
		frame.getContentPane().add(countryTextField);
		countryTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 161, 399, 166);
		frame.getContentPane().add(panel);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setRows(11);
		textArea_1.setColumns(30);
		panel.add(textArea_1);
		textArea_1.setVisible(false);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		

	}
}
