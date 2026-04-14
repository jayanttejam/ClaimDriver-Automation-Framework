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
import vertex.CD.AdminPages.RulesPage;
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
public class RulesPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	RulesPage rulesPage;
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	rulesPage = new RulesPage();
}
	
@Test(priority=1, enabled=true)
public void verify_Admin_Page_Title_Test() throws InterruptedException{
	rulesPage.click_On_Rules_Page();
	String adminPageTitle = rulesPage.verify_Rules_Page_Title();
	Assert.assertEquals(adminPageTitle, "Workflow and Rules | ClaimDriver");
}

@Test(priority=2, enabled=true)
public void verify_Admin_Page_Loaded_Test() throws InterruptedException{
	rulesPage.click_On_Rules_Page();;
	
	boolean result = rulesPage.verify_Rules_Page_Loaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}


@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
