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
import vertex.CD.pages.MCBNewWorkOrderPage;
import vertex.CD.pages.NewWorkOrderPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class MCBNewWorkOrderPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	MCBNewWorkOrderPage newWorkOrderPage;
	
	@DataProvider(name="ClaimDriverData")
	String [][] getData( ) throws IOException {
		
		String path="./TestData\\TestData.xlsx";
		
		int rownum = XLUtility.getRowCount("MCB1");
		int colcount = XLUtility.getCellCount("MCB1", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtility.getCellData(path, "MCB1", i, j);
			}
		}
		
		return logindata;
		
	}
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username2"), prop.getProperty("password2"));
	newWorkOrderPage = new MCBNewWorkOrderPage();
}
	
@Test(priority=1, enabled=false)
public void verifyMCBNewWorkOrderPageLoadedTest() throws InterruptedException{
	
	Thread.sleep(2000);
	newWorkOrderPage = newWorkOrderPage.VerifyclickOnMCBNewFile();
	Thread.sleep(2000);
	boolean result = newWorkOrderPage.verifyMCBNewWorkOrderPageLoaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}



@Test(priority=2, enabled=false)
public void verifyNewWorkOrderPageTitleTest() throws InterruptedException{
	newWorkOrderPage.VerifyclickOnMCBNewFile();
	String NWOPageTitle = newWorkOrderPage.verifyMCBNewWorkOrderPageTitle();
	Assert.assertEquals(NWOPageTitle, "New File | ClaimDriver");
}

//@Test(priority=3, enabled=false)
//public void VerifyclaimCreationTest() throws Exception{
//	
//	newWorkOrderPage = newWorkOrderPage.VerifyclickOnNewFile();
//	//newWorkOrderPage.selectCompany();
//	Thread.sleep(3000);
//	//newWorkOrderPage.fillDataInNewWO();
//	//newWorkOrderPage.fillDataInCollisionInvoice();
//	Thread.sleep(3000);
//	boolean result = newWorkOrderPage.claimCreationTest();
//	Assert.assertTrue(result);
//	
//}

@Test(priority=3, dataProvider="ClaimDriverData", enabled=true)
public void verifyMCBClaimCreationTestbyDataDriven(String company, String astNo, String vinNo,String fleetName, String invNo,String autNo,String date,String subtotal,String saleTax,String subBy) throws Exception
{
	newWorkOrderPage = newWorkOrderPage.VerifyclickOnMCBNewFile();
	newWorkOrderPage.selectCompany(company);
	Thread.sleep(3000);
	newWorkOrderPage.fillDataInNewWO(astNo,vinNo);
	Thread.sleep(2000);
	newWorkOrderPage.selectFleet(fleetName);
	Thread.sleep(2000);
	
	newWorkOrderPage.fillDataInCollisionInvoice(invNo,autNo,date,subtotal,saleTax, subBy);
	Thread.sleep(2000);
	boolean result = newWorkOrderPage.claimCreationTest();
	Assert.assertTrue(result);
		
}


//@AfterMethod
//public void tearDown()
//{
//	driver.quit();
//}
@AfterMethod
public void teardown() {
	   if(driver != null){
	    driver.quit();
	   }

	}

}
