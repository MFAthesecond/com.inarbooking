package config;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Utility class for reading configuration properties from a properties file.
 */
public class ConfigurationManager {

	private static final Properties CONFIG_FILE;

	static {
		try {
			// Location of properties
			String path = System.getProperty("user.dir") + "/src/main/resources/config.properties";
			// Getting this file as a stream
			FileInputStream input = new FileInputStream(path);
			// Creating an object of Properties class
			CONFIG_FILE = new Properties();
			// Loading information from the FileInputStream object into the Properties
			// object with the load method.
			CONFIG_FILE.load(input);
			// close the input FileInputStream
			input.close();

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load properties file!");
		}
	}

	/**
	 * Retrieves the value of the property with the specified key.
	 * @param keyName the key of the property to retrieve
	 * @return the value of the property
	 */
	public static String getProperty(String keyName) {
		return CONFIG_FILE.getProperty(keyName);
	}

}