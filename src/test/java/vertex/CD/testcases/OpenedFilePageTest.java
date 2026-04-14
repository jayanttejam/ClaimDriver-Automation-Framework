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
import vertex.CD.pages.OpenedFilePage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class OpenedFilePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	OpenedFilePage openedFilePage;
	NewWorkOrderPage newWorkOrderPage;
	
	
	@DataProvider(name="ClaimDriverData")
	String [][] getData( ) throws IOException {
		
		String path="./TestData\\TestData.xlsx";
		
		int rownum = XLUtility.getRowCount("CloseClaim");
		int colcount = XLUtility.getCellCount("CloseClaim", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtility.getCellData(path, "CloseClaim", i, j);
			}
		}
		
		return logindata;
		
	}
	
	
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	openedFilePage = new OpenedFilePage();
	newWorkOrderPage = new NewWorkOrderPage();
}
	
@Test(priority=1, enabled=false)
public void verify_Opened_File_Page_Loaded_Test() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyOpenedFilePageLoaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}


@Test(priority=2, enabled=false)
public void verify_Opened_File_Page_Title_Test() throws InterruptedException{
	String OpenedFilePageTitle = openedFilePage.verifyOpenedFilePageTitle();
	Assert.assertEquals(OpenedFilePageTitle, "Overview | ClaimDriver");
}

@Test(priority=3, enabled=false)
public void verify_Overview_Page_Loaded_Test() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyOverviewPageLoaded();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}


@Test(priority=4, enabled=false)
public void verify_Overview_Page_Title_Test() throws InterruptedException{
	String OpenedFilePageTitle = openedFilePage.verifyOverviewPageTitle();
	Assert.assertEquals(OpenedFilePageTitle, "Overview | ClaimDriver");
}

@Test(priority=5, enabled=false)
public void verify_Forms_Page_Loaded_Test() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyFormsPageLoaded();
	Assert.assertEquals(result, true);
}


@Test(priority=6, enabled=false)
public void verify_Forms_Page_Title_Test() throws InterruptedException{
	String OpenedFilePageTitle = openedFilePage.verifyFormsPageTitle();
	Assert.assertEquals(OpenedFilePageTitle, "Forms | ClaimDriver");
}

@Test(priority=7, enabled=false)
public void verify_Activity_Log_Page_Loaded_Test() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyActivityLogPageLoaded();
	Assert.assertEquals(result, true);
}

@Test(priority=8, enabled=false)
public void verify_Activity_Log_Page_Title_Test() throws InterruptedException{
	String OpenedFilePageTitle = openedFilePage.verifyActivityLogPageTitle();
	Assert.assertEquals(OpenedFilePageTitle, "Activity Log | ClaimDriver");
}

@Test(priority=9, enabled=false)
public void verify_Documents_Page_Loaded_Test() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyDocumentsPageLoaded();
	Assert.assertEquals(result, true);
}

@Test(priority=10, enabled=false)
public void verify_Documents_Page_Title_Test() throws InterruptedException{
	String OpenedFilePageTitle = openedFilePage.verifyDocumentsPageTitle();
	Assert.assertEquals(OpenedFilePageTitle, "Documents | ClaimDriver");
}

@Test(priority=11, enabled=false)
public void verify_Calendar_Page_Loaded_Test() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyCalendarPageLoaded();
	Assert.assertEquals(result, true);
}

@Test(priority=12, enabled=false)
public void verify_Calendar_Page_Title_Test() throws InterruptedException{
	String OpenedFilePageTitle = openedFilePage.verifyCalendarPageTitle();
	Assert.assertEquals(OpenedFilePageTitle, "Calendar | ClaimDriver");
}

@Test(priority=13, enabled=false)
public void verify_Tasks_Page_Loaded_Test() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyTasksPageLoaded();
	Assert.assertEquals(result, true);
}

@Test(priority=14, enabled=false)
public void verify_Tasks_Page_Title_Test() throws InterruptedException{
	String OpenedFilePageTitle = openedFilePage.verifyTasksPageTitle();
	Assert.assertEquals(OpenedFilePageTitle, "Tasks | ClaimDriver");
}


@Test(priority=15, dataProvider="ClaimDriverData", enabled=false)
public void verify_File_Closed_Test(String company, String astNo, String vinNo, String invNo,String autNo,String autNo2,String date,String part,String bodyLB, String paintLB, String mechLB,String frameLB,String paintMTL, String sublt,String othr,String saleTax,String subBy) throws Exception
{
	newWorkOrderPage = newWorkOrderPage.VerifyclickOnNewFile();
	newWorkOrderPage.selectCompany(company);
	Thread.sleep(3000);
	newWorkOrderPage.fillDataInNewWO(astNo,vinNo);
	Thread.sleep(2000);
	newWorkOrderPage.fillDataInCollisionInvoice(invNo, autNo, autNo2, date, part, bodyLB, paintLB, mechLB, frameLB, paintMTL, sublt, othr, saleTax, subBy);
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyFileIsClosed();
	Assert.assertTrue(result);		
}

@Test(priority=16, dataProvider="ClaimDriverData", enabled=false)
public void verify_File_ReOpened_Test(String company, String astNo, String vinNo, String invNo,String autNo,String autNo2,String date,String part,String bodyLB, String paintLB, String mechLB,String frameLB,String paintMTL, String sublt,String othr,String saleTax,String subBy) throws Exception
{
	newWorkOrderPage = newWorkOrderPage.VerifyclickOnNewFile();
	newWorkOrderPage.selectCompany(company);
	Thread.sleep(3000);
	newWorkOrderPage.fillDataInNewWO(astNo,vinNo);
	Thread.sleep(2000);
	newWorkOrderPage.fillDataInCollisionInvoice(invNo, autNo, autNo2, date, part, bodyLB, paintLB, mechLB, frameLB, paintMTL, sublt, othr, saleTax, subBy);
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyFileIsReOpened();
	Assert.assertTrue(result);		
}

@Test(priority=17, dataProvider="ClaimDriverData", enabled=false)
public void verify_Accept_Claim_And_Submit_Test(String company, String astNo, String vinNo, String invNo,String autNo,String autNo2,String date,String part,String bodyLB, String paintLB, String mechLB,String frameLB,String paintMTL, String sublt,String othr,String saleTax,String subBy) throws Exception
{
	newWorkOrderPage = newWorkOrderPage.VerifyclickOnNewFile();
	newWorkOrderPage.selectCompany(company);
	Thread.sleep(3000);
	newWorkOrderPage.fillDataInNewWO(astNo,vinNo);
	Thread.sleep(2000);
	newWorkOrderPage.fillDataInCollisionInvoice(invNo, autNo, autNo2, date, part, bodyLB, paintLB, mechLB, frameLB, paintMTL, sublt, othr, saleTax, subBy);
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyAcceptClaimAndSubmit();
	Assert.assertTrue(result);		
}

@Test(priority=18, dataProvider="ClaimDriverData", enabled=true)
public void verify_Reject_Claim_And_Submit_Test(String company, String astNo, String vinNo, String invNo,String autNo,String autNo2,String date,String part,String bodyLB, String paintLB, String mechLB,String frameLB,String paintMTL, String sublt,String othr,String saleTax,String subBy) throws Exception
{
	newWorkOrderPage = newWorkOrderPage.VerifyclickOnNewFile();
	newWorkOrderPage.selectCompany(company);
	Thread.sleep(3000);
	newWorkOrderPage.fillDataInNewWO(astNo,vinNo);
	Thread.sleep(2000);
	newWorkOrderPage.fillDataInCollisionInvoice(invNo, autNo, autNo2, date, part, bodyLB, paintLB, mechLB, frameLB, paintMTL, sublt, othr, saleTax, subBy);
	Thread.sleep(2000);
	boolean result = openedFilePage.verifyRejectClaimAndSubmit();
	Assert.assertTrue(result);		
}

@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
