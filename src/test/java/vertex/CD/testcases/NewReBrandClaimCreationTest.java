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
import vertex.CD.pages.ReBrandNewWorkOrderPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class NewReBrandClaimCreationTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ReBrandNewWorkOrderPage reBrandNewWorkOrderPage;
	
	@DataProvider(name="ClaimDriverData")
	String [][] getData( ) throws IOException {
		
		String path="./TestData\\TestData.xlsx";
		
		int rownum = XLUtility.getRowCount("ReBrand");
		int colcount = XLUtility.getCellCount("ReBrand", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtility.getCellData(path, "ReBrand", i, j);
			}
		}
		
		return logindata;
		
	}
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username6"), prop.getProperty("password6"));
	reBrandNewWorkOrderPage = new ReBrandNewWorkOrderPage();
}
	
@Test(priority=1, enabled=false)
public void verifyNewReBrandWorkOrderPageLoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reBrandNewWorkOrderPage = reBrandNewWorkOrderPage.VerifyclickOnNewFile();
	Thread.sleep(2000);
	boolean result = reBrandNewWorkOrderPage.verifyNewWorkOrderPageLoaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}



@Test(priority=2, enabled=false)
public void verifyNewWorkOrderPageTitleTest() throws InterruptedException{
	reBrandNewWorkOrderPage.VerifyclickOnNewFile();
	String NWOPageTitle = reBrandNewWorkOrderPage.verifyNewWorkOrderPageTitle();
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
public void verifyClaimCreationTestbyDataDriven(String company, String astNo, String vinNo, String invNo,String autNo,String autNo2,String date,String part,String bodyLB, String paintLB, String mechLB,String frameLB,String paintMTL, String sublt,String othr,String saleTax,String subBy) throws Exception
{
	reBrandNewWorkOrderPage = reBrandNewWorkOrderPage.VerifyclickOnNewFile();
	reBrandNewWorkOrderPage.selectCompany(company);
	Thread.sleep(3000);
	reBrandNewWorkOrderPage.fillDataInNewWO(astNo,vinNo);
	Thread.sleep(2000);
	reBrandNewWorkOrderPage.fillDataInEstimateForm();
	Thread.sleep(2000);
	reBrandNewWorkOrderPage.fillDataInQualityInspectionChecklistForm();
	Thread.sleep(2000);
	reBrandNewWorkOrderPage.fillDataInCollisionInvoice(invNo, autNo, autNo2, date, part, bodyLB, paintLB, mechLB, frameLB, paintMTL, sublt, othr, saleTax, subBy);
	Thread.sleep(2000);
	boolean result = reBrandNewWorkOrderPage.claimCreationTest();
	Assert.assertTrue(result);
		
}
@Test(priority=4, enabled=false)
public void verifyClaimCreationTest() throws InterruptedException{
	reBrandNewWorkOrderPage = reBrandNewWorkOrderPage.VerifyclickOnNewFile();
	reBrandNewWorkOrderPage.selectCompany("Alsco");
	Thread.sleep(3000);
	reBrandNewWorkOrderPage.fillDataInNewWO("3125135","Test123456336Tes2");
	Thread.sleep(2000);
	reBrandNewWorkOrderPage.fillDataInEstimateForm();
	Thread.sleep(2000);
	reBrandNewWorkOrderPage.fillDataInQualityInspectionChecklistForm();
	boolean result = reBrandNewWorkOrderPage.claimCreationTest();
	Assert.assertTrue(result);
}

@AfterMethod
public void teardown() {
	   if(driver != null){
	    driver.quit();
	   }

	}

}
