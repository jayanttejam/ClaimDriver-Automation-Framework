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
public class NewWorkOrderPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	NewWorkOrderPage newWorkOrderPage;
	
	@DataProvider(name="ClaimDriverData")
	String [][] getData( ) throws IOException {
		
		String path="./TestData\\TestData.xlsx";
		
		int rownum = XLUtility.getRowCount("NewWO");
		int colcount = XLUtility.getCellCount("NewWO", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtility.getCellData(path, "NewWO", i, j);
			}
		}
		
		return logindata;
		
	}
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username4"), prop.getProperty("password4"));
	newWorkOrderPage = new NewWorkOrderPage();
}
	
@Test(priority=1, enabled=false)
public void verifyNewWorkOrderPageLoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	newWorkOrderPage = newWorkOrderPage.VerifyclickOnNewFile();
	Thread.sleep(2000);
	boolean result = newWorkOrderPage.verifyNewWorkOrderPageLoaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}



@Test(priority=2, enabled=false)
public void verifyNewWorkOrderPageTitleTest() throws InterruptedException{
	newWorkOrderPage.VerifyclickOnNewFile();
	String NWOPageTitle = newWorkOrderPage.verifyNewWorkOrderPageTitle();
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

@Test(priority=3, dataProvider="ClaimDriverData", enabled=false)
public void verifyClaimCreationTestbyDataDriven(String company, String astNo, String vinNo, String invNo,String autNo,String autNo2,String date,String part,String bodyLB, String paintLB, String mechLB,String frameLB,String paintMTL, String sublt,String othr,String saleTax,String subBy) throws Exception
{
	newWorkOrderPage = newWorkOrderPage.VerifyclickOnNewFile();
	newWorkOrderPage.selectCompany(company);
	Thread.sleep(3000);
	newWorkOrderPage.fillDataInNewWO(astNo,vinNo);
	Thread.sleep(2000);
	newWorkOrderPage.fillDataInCollisionInvoice(invNo, autNo, autNo2, date, part, bodyLB, paintLB, mechLB, frameLB, paintMTL, sublt, othr, saleTax, subBy);
	Thread.sleep(2000);
	boolean result = newWorkOrderPage.claimCreationTest();
	Assert.assertTrue(result);
		
}

@Test(priority=4, enabled=true)
public void popupclickTest() throws InterruptedException{
	newWorkOrderPage.VerifyclickOnNewFile();
	newWorkOrderPage.selectCompany("ATT");
	Thread.sleep(3000);
	newWorkOrderPage.fillDataInNewWO("23232","Test123456336Test");
	Thread.sleep(2000);
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
