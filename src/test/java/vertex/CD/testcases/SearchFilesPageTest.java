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
import vertex.CD.pages.ListFilesPage;
import vertex.CD.pages.LoginPage;
import vertex.CD.pages.NewWorkOrderPage;
import vertex.CD.pages.SearchFilesPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class SearchFilesPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	SearchFilesPage searchFilesPage;
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	searchFilesPage = new SearchFilesPage();
}
	
@Test(priority=1, enabled=true)
public void verifySearchFilesPageTitleTest() throws InterruptedException{
	String searchFilesPageTitle = searchFilesPage.verifySearchFilesPageTitle();
	Assert.assertEquals(searchFilesPageTitle, "Search Files | ClaimDriver");
}

@Test(priority=2, enabled=true)
public void verifySearchFilesPageLoadedTest() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = searchFilesPage.verifySearchFilesPageLoaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}


@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
