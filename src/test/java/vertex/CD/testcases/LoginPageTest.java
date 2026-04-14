package vertex.CD.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vertex.CD.base.TestBase;
import vertex.CD.base.TestBaseNew;
import vertex.CD.driver.DriverManager;
import vertex.CD.pages.HomePage;
import vertex.CD.pages.LoginPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.ExcelManager;
import vertex.CD.util.TestDataProvider;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;

@Listeners(vertex.CD.util.TestListener.class)
public class LoginPageTest extends TestBaseNew {

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setup1() {
		// initialization();
		setup();
		loginPage = new LoginPage();
	}

	@Test(priority=1, enabled = true)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Automation Exercise");
	}

	@Test(priority=2, enabled = true)
	public void loginTest() throws IOException {
		homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		boolean result = loginPage.LoginTest();

		Assert.assertTrue(result);
	}

	@Test(priority=3,dataProvider = "ClaimDriverData", dataProviderClass = TestDataProvider.class, enabled = true)
	public void loginTestbyDataDriven(String user, String pwd) throws IOException {
		
		homePage = loginPage.login(user, pwd);
		boolean result = loginPage.LoginTest();
		Assert.assertTrue(result);
	}

//	@AfterMethod
//	public void tearDown() {
//		// driver.quit();
//		DriverManager.getDriver().quit();
//		DriverManager.unload();
//	}
}
