package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.OsUtil;

public class BaseClass {
	public WebDriver _driver;
	private static String URL = null;
	private static String BROWSER = null;
	protected static PropertyUtil _properties = new PropertyUtil();

	public void setUp(final String BROWSER) {
		if (BROWSER.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					OsUtil.isMac() ? System.getProperty("user.dir") + "/src/main/resources/geckodriver" : System.getProperty("user.dir") + "");
			
			_driver = new FirefoxDriver();
		} else if (BROWSER.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					OsUtil.isMac() ? System.getProperty("user.dir") + "/src/main/resources/chromedriver" : System.getProperty("user.dir") + "");
			
			_driver = new ChromeDriver();
		} else {
			System.err.println("Invalid browser");
			System.exit(0);
		}
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		_driver.manage().window().maximize();		
	}

	public static String getUrl() {
		// TODO: EY: Should this be done in the constructor instead?
		if (URL == null) {
			try {
				URL = _properties.getProperty(PropertyUtil.BASEURL);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			assert URL.contains("http"); // should look like a URL
		}
		return URL;
	}

	public static String getBrowser() {
		if (BROWSER == null) {
			try {
				BROWSER = _properties.getProperty(PropertyUtil.BROWSER);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return BROWSER;
	}

}
