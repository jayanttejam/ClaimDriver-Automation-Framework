package vertex.CD.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver initDriver(String browser) {

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup(); // ✅ FIX

            ChromeOptions co = new ChromeOptions();
            co.addArguments("--start-maximized");
            co.addArguments("--remote-allow-origins=*");
            co.addArguments("--headless=new");

            driver = new ChromeDriver(co);

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        return driver;
    }
}
