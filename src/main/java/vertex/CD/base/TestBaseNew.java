package vertex.CD.base;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import vertex.CD.driver.DriverFactory;
import vertex.CD.driver.DriverManager;
import vertex.CD.util.TestUtil;

public class TestBaseNew {

	public static Properties prop;

	public TestBaseNew() {
		try {
			prop = new Properties();
			System.out.println("Loading properties file");

			//InputStream ip = getClass().getClassLoader().getResourceAsStream("vertex/CD/config/config.properties");
			InputStream ip = getClass().getClassLoader().getResourceAsStream("config.properties");

			if (ip == null) {
				System.out.println("Sorry, unable to find config.properties");
			} else {
				System.out.println("Loaded properties file");
				prop.load(ip);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// @BeforeMethod
	public void setup() {
		System.out.println("In the setup method");
		String browserName = prop.getProperty("browser");

		if (browserName == null) {
			throw new RuntimeException("Browser value is NULL. Check config.properties");
		}

		System.out.println("Browser Name: " + browserName);
		System.out.println("Loaded properties file 1");
		// ✅ Create driver via factory

		try {
			DriverManager.setDriver(DriverFactory.initDriver(browserName));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// DriverManager.setDriver(DriverFactory.initDriver(browserName));
		System.out.println("Loaded properties file 2");
		System.out.println("Driver initialized for thread: " + Thread.currentThread().getId());

		DriverManager.getDriver().manage().deleteAllCookies();

		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Page_load_timeout));

		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_wait));

		DriverManager.getDriver().get(prop.getProperty("baseURL"));
	}

	@AfterMethod
	public void tearDown() {

		System.out.println("Closing driver for thread: " + Thread.currentThread().getId());

		DriverManager.getDriver().quit();
		DriverManager.unload();
	}
}