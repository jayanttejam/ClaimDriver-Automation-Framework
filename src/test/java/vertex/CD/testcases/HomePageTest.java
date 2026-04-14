package vertex.CD.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vertex.CD.base.TestBase;
import vertex.CD.pages.HomePage;
import vertex.CD.pages.LoginPage;
import vertex.CD.pages.NewWorkOrderPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
		
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username6"), prop.getProperty("password6"));
}
	
@Test(priority=1, enabled=true)
public void verifyHomePageTitleTest(){
	String homePageTitle = homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "Homes | ClaimDriver");
}

@Test(priority=2, enabled=true)
public void verify_MyComm_Dashboard_Page_Loaded_Test() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = homePage.verifyMyCommDashboardPageLoaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}
@Test(priority=3, enabled=true)
public void verify_Open_Files_Page_Loaded_Test() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = homePage.verifyOpenFilesPageLoaded();
	Assert.assertEquals(result, true);
}

@Test(priority=4, enabled=true)
public void verify_LogOut_happening_Test() throws InterruptedException{
	
	boolean result = homePage.verifyLogOutHappening();
	Assert.assertEquals(result, true);	
}

@Test(priority=5, enabled=true)
public void verify_Recent_File_Present_Test() throws InterruptedException{
	
	boolean result = homePage.verifyRecentFileIsPresent();
	Assert.assertEquals(result, true);	
}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
