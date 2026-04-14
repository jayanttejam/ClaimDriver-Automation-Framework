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
import vertex.CD.AdminPages.VendorMgmtPage;
import vertex.CD.AdminPages.VendorVettingPage;
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
public class VendorVettingPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	VendorVettingPage vendorVettingPage;
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	vendorVettingPage = new VendorVettingPage();
}
	
@Test(priority=1, enabled=true)
public void verify_Vendor_Vetting_Page_Title_Test() throws InterruptedException{
	vendorVettingPage.click_On_VendorVetting_Page();
	String adminPageTitle = vendorVettingPage.verify_VendorVetting_Page_Title();
	Assert.assertEquals(adminPageTitle, "Vendor Vetting | ClaimDriver");
}

@Test(priority=2, enabled=true)
public void verify_Vendor_Vetting_Page_Loaded_Test() throws InterruptedException{
	vendorVettingPage.click_On_VendorVetting_Page();
	
	boolean result = vendorVettingPage.verify_VendorVetting_Page_Loaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}


@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
