package vertex.CD.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vertex.CD.base.TestBase;
import vertex.CD.pages.FileUploadPage;
import vertex.CD.pages.HomePage;
import vertex.CD.pages.LoginPage;
import vertex.CD.pages.NewWorkOrderPage;
import vertex.CD.pages.ReportsPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class FileUploadPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	FileUploadPage fileuploadPage;
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	fileuploadPage = new FileUploadPage();
}
	
@Test(priority=1, enabled=false)
public void fileUploadPageLoadedTest() throws InterruptedException{
	
	Thread.sleep(2000);
	boolean result = fileuploadPage.verifyPageLoad();
	Assert.assertEquals(result, true);
	//Assert.assertTrue(true);
	
}



@Test(priority=2, enabled=false)
public void verifyFileUploadPageTitleTest() throws InterruptedException{
	
	String fileUploadPageTitle = fileuploadPage.verifyFileUploadPageTitle();
	Assert.assertEquals(fileUploadPageTitle, "AIUpload | ClaimDriver");
}

@Test(priority=3, enabled=true)
public void VerifyFileUploadTest() throws Exception{
	
	String alertText = fileuploadPage.VerifyFileUpload();
	
	if (alertText.equals("AI File Uploaded Successfully") || alertText.equals("Meineke - AI File Uploading has been failed due to duplication"))
		   {
				Assert.assertTrue(true, "Upload successful");
		   }
		else {
			   Assert.assertTrue(false, "Error uploading file");
		     }	
//	Assert.assertEquals(result, expected);
//	Assert.assertTrue(result);
	
	//Assert.assertTrue(fileuploadPage.VerifyFileUpload());
	//Assert.assertEquals(alertText, "Index was outside the bounds of the array.");
	//Invalid Excel Sheet - Column order/names are not matching
	//Meineke - AI File Uploading has been failed due to duplication
	//AI File Uploaded Successfully
}


@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
