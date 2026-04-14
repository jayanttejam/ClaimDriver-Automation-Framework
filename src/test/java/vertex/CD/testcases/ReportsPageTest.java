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
import vertex.CD.pages.ReportsPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class ReportsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	NewWorkOrderPage newWorkOrderPage;
	ReportsPage reportsPage;
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	newWorkOrderPage = new NewWorkOrderPage();
	reportsPage = new ReportsPage();
}

/*************************  Central Billing Report  ****************************/

@Test(priority=1, enabled=true)
public void CentralBillingReportLoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.VerifyclickOnCentralBilling();
	Thread.sleep(2000);
	boolean result = reportsPage.verifyCentralBillingReportPageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=2, enabled=true)
public void verifyCentralBillingReportPageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.VerifyclickOnCentralBilling();
	String reportsPageTitle = reportsPage.verifyCentralBillingReportsPageTitle();
	Assert.assertEquals(reportsPageTitle, "Billing | ClaimDriver");
}

@Test(priority=3, enabled=true)
public void VerifyExcelReportDownloadedTest() throws Exception{
	
	reportsPage.exportReportDownload();	
}

/*************** Fleet Standard Carmax *******************/

@Test(priority=4, enabled=true)
public void FleetStandardReport_Carmax_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verifyclickOnFleetStandardCarmax();
	Thread.sleep(2000);
	boolean result = reportsPage.verifyFleetStandardCarmaxReportPageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=5, enabled=true)
public void verify_Fleet_Standard_Carmax_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verifyclickOnFleetStandardCarmax();
	String reportsPageTitle = reportsPage.verify_Fleet_Standard_Report_Carmax_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Fleet Standard Report | ClaimDriver");
}
/**************************************************************************************/

/*************** Open Vs Closed Report Carmax *******************/

@Test(priority=6, enabled=true)
public void Open_vs_Closed_Report_Carmax_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verifyclickOnOpenVsClosedCarmax();
	Thread.sleep(2000);
	boolean result = reportsPage.verifyOpenVsClosedCarmaxReportPageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=7, enabled=true)
public void verify_Open_vs_Closed_Carmax_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verifyclickOnOpenVsClosedCarmax();
	String reportsPageTitle = reportsPage.verify_OpenVsClosed_Report_Carmax_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Open vs Closed Report | ClaimDriver");
}
/*****************************************************************************************/
/*************** Claim Activity Report Carmax *******************/

@Test(priority=8, enabled=true)
public void claim_Activity_Report_Carmax_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verifyclickOnClaimActivityCarmax();
	Thread.sleep(2000);
	boolean result = reportsPage.verifyClaimActivityCarmaxReportPageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=9, enabled=true)
public void verify_claim_Activity_Carmax_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verifyclickOnClaimActivityCarmax();
	String reportsPageTitle = reportsPage.verify_ClaimActivity_Report_Carmax_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Claims Activity Report | ClaimDriver");
}
/*****************************************************************************************/

/*************** Claim Performance Report Carmax *******************/

@Test(priority=10, enabled=true)
public void claim_Performance_Report_Carmax_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_Claim_Performance_Carmax();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_Claim_Performance_Carmax_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=11, enabled=true)
public void verify_claim_Performance_Carmax_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_Claim_Performance_Carmax();
	String reportsPageTitle = reportsPage.verify_Claim_Performance_Report_Carmax_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Claim Performance Report | ClaimDriver");
}
/*****************************************************************************************/

/*************** Fleet Billing Report *******************/

@Test(priority=12, enabled=true)
public void fleet_Billing_Report_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_Fleet_Billing();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_Fleet_Billing_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=13, enabled=true)
public void verify_fleet_Billing_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_Fleet_Billing();
	String reportsPageTitle = reportsPage.verify_Fleet_Billing_Report_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Fleet Billing | ClaimDriver");
}
/*****************************************************************************************/

/*************** Fleet Billing OpenVsClose Report *******************/

@Test(priority=14, enabled=true)
public void fleet_Billing_OpenVsClosed_Report_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_Fleet_Billing_OpenVsClose();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_Fleet_Billing_OpenVsClose_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=15, enabled=true)
public void verify_fleet_Billing_OpenVsClosed_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_Fleet_Billing_OpenVsClose();
	String reportsPageTitle = reportsPage.verify_Fleet_Billing_OpenVsClose_Report_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Billing | ClaimDriver");
}
/*****************************************************************************************/

/*************** MCB Report *******************/

@Test(priority=16, enabled=true)
public void MCB_Report_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_MCB_Report();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_MCB_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=17, enabled=true)
public void verify_MCB_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_MCB_Report();
	String reportsPageTitle = reportsPage.verify_MCB_Report_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Meineke Central Billing | ClaimDriver");
}
/*****************************************************************************************/

/*************** Unifirst Report *******************/

@Test(priority=18, enabled=true)
public void UniFirst_Report_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_Unifirst_Report();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_Unifirst_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=19, enabled=true)
public void verify_Unifirst_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_Unifirst_Report();
	String reportsPageTitle = reportsPage.verify_Unifirst_Report_PageTitle();
	Assert.assertEquals(reportsPageTitle, "UniFirst Report | ClaimDriver");
}
/*****************************************************************************************/
/*************** Amazon Report *******************/

@Test(priority=20, enabled=true)
public void Amazon_Report_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_Amazon_Report();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_Amazon_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=21, enabled=true)
public void verify_Amazon_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_Amazon_Report();
	String reportsPageTitle = reportsPage.verify_Amazon_Report_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Amazon Report | ClaimDriver");
}
/*****************************************************************************************/
/*************** Hertz_Billing Report *******************/

@Test(priority=22, enabled=true)
public void Hertz_Billing_Report_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_Hertz_Billing_Report();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_Hertz_Billing_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=23, enabled=true)
public void verify_Hertz_Billing_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_Hertz_Billing_Report();
	String reportsPageTitle = reportsPage.verify_Hertz_Billing_Report_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Hertz Billing | ClaimDriver");
}
/*****************************************************************************************/
/*************** Statement_Billing Report *******************/

@Test(priority=24, enabled=true)
public void Statement_Billing_Report_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_Statement_Billing_Report();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_Statement_Billing_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=25, enabled=true)
public void verify_Statement_Billing_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_Statement_Billing_Report();
	String reportsPageTitle = reportsPage.verify_Statement_Billing_Report_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Statement/Billing Report | ClaimDriver");
}
/*****************************************************************************************/
/*************** Open_Claims Report *******************/

@Test(priority=26, enabled=true)
public void Open_Claims_Report_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_Open_Claims_Report();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_Open_Claims_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=27, enabled=true)
public void verify_Open_Claims_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_Open_Claims_Report();
	String reportsPageTitle = reportsPage.verify_Open_Claims_Report_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Open Claims Report | ClaimDriver");
}
/*****************************************************************************************/
/*************** Preferred_Location Report *******************/

@Test(priority=28, enabled=true)
public void Preferred_Location_Report_LoadedTest() throws InterruptedException{
	
	Thread.sleep(3000);
	reportsPage = reportsPage.verify_clickOn_Preferred_Location_Report();
	Thread.sleep(2000);
	boolean result = reportsPage.verify_Preferred_Location_Report_PageLoaded();
	Assert.assertEquals(result, true);	
}

@Test(priority=29, enabled=true)
public void verify_Preferred_Location_Report_PageTitleTest() throws InterruptedException{
	reportsPage = reportsPage.verify_clickOn_Preferred_Location_Report();
	String reportsPageTitle = reportsPage.verify_Preferred_Location_Report_PageTitle();
	Assert.assertEquals(reportsPageTitle, "Preferred Location Report | ClaimDriver");
}
/*****************************************************************************************/


@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
