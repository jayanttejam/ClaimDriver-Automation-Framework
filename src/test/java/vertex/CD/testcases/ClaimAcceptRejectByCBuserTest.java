package vertex.CD.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vertex.CD.base.TestBase;
import vertex.CD.pages.ClaimAcceptRejectByCBuser;
import vertex.CD.pages.HomePage;
import vertex.CD.pages.ListFilesPage;
import vertex.CD.pages.LoginPage;
import vertex.CD.pages.NewWorkOrderPage;
import vertex.CD.pages.OpenedFilePage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class ClaimAcceptRejectByCBuserTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ClaimAcceptRejectByCBuser claimAcceptRejectByCBuser;
	NewWorkOrderPage newWorkOrderPage;
		
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	claimAcceptRejectByCBuser = new ClaimAcceptRejectByCBuser();
	newWorkOrderPage = new NewWorkOrderPage();
}
	


@Test(priority=1, enabled=false)
public void verify_Accept_Claim_And_Submit_Test() throws Exception
{
	
	claimAcceptRejectByCBuser.acceptClaim();
	//Assert.assertTrue(result);		
}

@Test(priority=2, enabled=true)
public void verify_Reject_Claim_And_Submit_Test() throws Exception
{
	
	claimAcceptRejectByCBuser.rejectClaim();
	//Assert.assertTrue(result);		
}

@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
