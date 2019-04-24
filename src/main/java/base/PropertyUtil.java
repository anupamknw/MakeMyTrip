package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	private Properties prop = new Properties();
	public final static String PROPERTY_FILENAME = "config/config.properties";
	public final static String BROWSER = "BROWSER";
	public final static String BASEURL = "BASEURL";

	public PropertyUtil() {
		try {
			prop.load(new FileInputStream(
					PROPERTY_FILENAME));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		assert !prop.isEmpty();
	}
	
	public String getProperty(final String key) {
		String property = prop.getProperty(key);
		return property != null ? property.trim() : property;
	}


}
