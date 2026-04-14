package vertex.CD.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;

import vertex.CD.util.TestUtil;

public class TestBase {

public static WebDriver driver;

public static Properties prop;


public TestBase()
{

	
	try {
	    prop = new Properties();
	    System.out.println("Loading properties file");
	    InputStream ip = getClass().getClassLoader().getResourceAsStream("vertex/CD/config/config.properties");
	    
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

public static void initialization()
{
	ChromeOptions co = new ChromeOptions();
	co.addArguments("--start-maximiZed");
	String browserPath = SeleniumManager.getInstance().getDriverPath(co, false).browserPath;
	String driverPath = SeleniumManager.getInstance().getDriverPath(co, false).driverPath;
	
	System.out.println("In Initialisation-" +browserPath );
	System.out.println("In Initialisation-" +driverPath );
	
	System.out.println("In Initialisation");
	String browserName = prop.getProperty("browser");
	String chromepath = prop.getProperty("chromepath");
	String ffpath = prop.getProperty("firefoxpath");
	
	if (browserName.equals("chrome"))
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\102\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", chromepath);
		//System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver(co);
		
	}
	
	else if (browserName.equals("firefox"))
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\99\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", ffpath);
		driver = new FirefoxDriver();
	}
	
	//driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	System.out.println("after maximize");
	//driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
	//driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
	//driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout);
	//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Page_load_timeout));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_wait));
	System.out.println("after wait");
	driver.get(prop.getProperty("baseURL"));
	System.out.println("after getting baseurl");
	
}


}
