package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.OSUtil;

public class BaseClass {
	public WebDriver driver;
	private static String URL = null;
	private static String BROWSER = null;
	private static String FROM = null;
	private static String TO = null;
	protected static PropertyBase _properties = new PropertyBase();

	public void setUp(final String BROWSER) {
		if (BROWSER.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					OSUtil.isMac() ? System.getProperty("user.dir") + "/src/main/resources/geckodriver"
							: System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");

			driver = new FirefoxDriver();
		} else if (BROWSER.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					OSUtil.isMac() ? System.getProperty("user.dir") + "/src/main/resources/chromedriver"
							: System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		} else {
			System.err.println("Invalid browser");
			System.exit(0);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static String getUrl() {
		if (URL == null) {
			try {
				URL = _properties.getProperty(PropertyBase.BASEURL);
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
				BROWSER = _properties.getProperty(PropertyBase.BROWSER);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return BROWSER;
	}
	
	public static String getFrom() {
		if (FROM == null) {
			try {
				FROM = _properties.getProperty(PropertyBase.FROM);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return FROM;
	}
	
	public static String getTo() {
		if (TO == null) {
			try {
				TO = _properties.getProperty(PropertyBase.TO);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return TO;
	}

}
