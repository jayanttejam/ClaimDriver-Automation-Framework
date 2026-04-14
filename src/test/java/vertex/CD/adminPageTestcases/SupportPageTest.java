package vertex.CD.adminPageTestcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vertex.CD.AdminPages.AdminPage;
import vertex.CD.AdminPages.MaintenancePage;
import vertex.CD.AdminPages.SupportPage;
import vertex.CD.base.TestBase;
import vertex.CD.pages.HomePage;
import vertex.CD.pages.ListFilesPage;
import vertex.CD.pages.LoginPage;
import vertex.CD.pages.NewWorkOrderPage;
import vertex.CD.pages.SearchFilesPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class SupportPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	SupportPage supportPage;
	
	
@BeforeMethod
public void setup() 
{
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	supportPage = new SupportPage();
}
	
@Test(priority=1, enabled=false)
public void verify_Support_Page_Title_Test() throws InterruptedException{
	supportPage.click_On_Support_Page();
	String adminPageTitle = supportPage.verify_Support_Page_Title();
	Assert.assertEquals(adminPageTitle, "Support Tools | ClaimDriver");
}

@Test(priority=2, enabled=false)
public void verify_Support_Page_Loaded_Test() throws InterruptedException{
	supportPage.click_On_Support_Page();;
	
	boolean result = supportPage.verify_Support_Page_Loaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}
@Test(priority=3, enabled=true)
public void verify_Assume_Identity_Functionality_Test() throws InterruptedException{
	
	boolean result = supportPage.verify_Assume_Identity_functionality();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}

@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
