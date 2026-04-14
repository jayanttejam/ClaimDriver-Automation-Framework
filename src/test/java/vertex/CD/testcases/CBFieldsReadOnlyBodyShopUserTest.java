package vertex.CD.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vertex.CD.base.TestBase;
import vertex.CD.pages.CBFieldsReadOnlyBodyShopUser;
import vertex.CD.pages.HomePage;
import vertex.CD.pages.LoginPage;
import vertex.CD.pages.NewWorkOrderPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class CBFieldsReadOnlyBodyShopUserTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	//NewWorkOrderPage newWorkOrderPage;
	CBFieldsReadOnlyBodyShopUser cbFieldValidations;
	
	
	
	
@BeforeClass
public void setup() throws InterruptedException 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username3"), prop.getProperty("password3"));
	cbFieldValidations = new CBFieldsReadOnlyBodyShopUser();
	cbFieldValidations.clickOnFilesMenu();
	Thread.sleep(1000);
	cbFieldValidations.clickOnNewFile();
	Thread.sleep(1000);
	cbFieldValidations.fillDataInNewWO();
	Thread.sleep(1000);
}

@Test(priority=1, enabled=true)
public void verify_Brand_Field_Disabled_ForShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);
	boolean result = cbFieldValidations.verifyBrandFieldDisabled();
	Assert.assertTrue(result);
}

@Test(priority=2, enabled=true)
public void verify_Shop_Number_Field_Disabled_ForShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyShopNoFieldDisabled();
	Assert.assertTrue(result);
}

@Test(priority=3, enabled=true)
public void verify_Fleet_Name_Field_Disabled_ForShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyFleetNameFieldDisabled();
	Assert.assertTrue(result);
}

@Test(priority=4, enabled=true)
public void verify_Parts_Discount_Field_Disabled_ForShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyPartsDiscountFieldDisabled();
	Assert.assertTrue(result);
}

@Test(priority=5, enabled=true)
public void verify_Labor_Discount_Field_Disabled_ForShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyLaborDiscountFieldDisabled();
	Assert.assertTrue(result);
}

@Test(priority=6, enabled=true)
public void verify_Subtotal_Discount_Field_Disabled_ForShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifySubtotalDiscountFieldDisabled();
	Assert.assertTrue(result);
}

@Test(priority=7, enabled=true)
public void verify_Reviewed_By_Field_Disabled_ForShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyReviewedByFieldDisabled();
	Assert.assertTrue(result);
}

@Test(priority=8, enabled=true)
public void verify_Approved_By_Field_Disabled_For_ShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyApprovedByFieldDisabled();
	Assert.assertTrue(result);
}

@Test(priority=9, enabled=true)
public void verify_Accepted_Option_Disabled_For_ShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyAcceptedFieldDisabled();
	Assert.assertTrue(result);
}

@Test(priority=10, enabled=true)
public void verify_Rejected_Option_Disabled_For_ShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyRejectedFieldDisabled();
	Assert.assertTrue(result);
}
//@AfterMethod
//public void tearDown()
//{
//	driver.quit();
//}
@AfterClass
public void teardown() {
	   if(driver != null){
	    driver.quit();
	   }

	}

}
