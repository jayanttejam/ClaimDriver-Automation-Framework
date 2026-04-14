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
import vertex.CD.pages.CBFieldsNotReadOnlyForAdminUser;
import vertex.CD.pages.CBFieldsReadOnlyBodyShopUser;
import vertex.CD.pages.HomePage;
import vertex.CD.pages.LoginPage;
import vertex.CD.pages.NewWorkOrderPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class CBFieldsNotReadOnlyForAdminUserTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	//NewWorkOrderPage newWorkOrderPage;
	CBFieldsNotReadOnlyForAdminUser cbFieldValidations;
	
	
	
	
@BeforeClass
public void setup() throws InterruptedException 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	cbFieldValidations = new CBFieldsNotReadOnlyForAdminUser();
	cbFieldValidations.clickOnFilesMenu();
	Thread.sleep(1000);
	cbFieldValidations.clickOnNewFile();
	Thread.sleep(1000);
	cbFieldValidations.fillDataInNewWO();
	Thread.sleep(1000);
}

@Test(priority=1, enabled=true)
public void verify_Brand_Field_Editable_For_Admin_User_Test() throws InterruptedException{
	Thread.sleep(1000);
	boolean result = cbFieldValidations.verifyBrandFieldEditable();
	//Assert.assertTrue(result);
	Assert.assertFalse(result);
}

@Test(priority=2, enabled=true)
public void verify_Shop_Number_Field_Editable_For_Admin_User_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyShopNoFieldEditable();
	Assert.assertFalse(result);
}

@Test(priority=3, enabled=true)
public void verify_Fleet_Name_Field_Editable_For_Admin_User_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyFleetNameFieldEditable();
	Assert.assertFalse(result);
}

@Test(priority=4, enabled=true)
public void verify_Parts_Discount_Field_Editable_For_Admin_User_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyPartsDiscountFieldEditable();
	Assert.assertFalse(result);
}

@Test(priority=5, enabled=true)
public void verify_Labor_Discount_Field_Editable_For_Admin_User_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyLaborDiscountFieldEditable();
	Assert.assertFalse(result);
}

@Test(priority=6, enabled=true)
public void verify_Subtotal_Discount_Field_Editable_For_Admin_User_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifySubtotalDiscountFieldEditable();
	Assert.assertFalse(result);
}

@Test(priority=7, enabled=true)
public void verify_Reviewed_By_Field_Editable_For_Admin_User_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyReviewedByFieldEditable();
	Assert.assertFalse(result);
}

@Test(priority=8, enabled=true)
public void verify_Approved_By_Field_Editable_For_Admin_User_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyApprovedByFieldEditable();
	Assert.assertFalse(result);
}
@Test(priority=9, enabled=true)
public void verify_SubTotal_Field_Editable_For_Admin_User_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifySubTotalFieldEditable();
	Assert.assertFalse(result);
}
@Test(priority=10, enabled=true)
public void verify_Accepted_Option_Disabled_For_ShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyAcceptedFieldEnabled();
	Assert.assertTrue(result);
}

@Test(priority=11, enabled=true)
public void verify_Rejected_Option_Disabled_For_ShopUser_Test() throws InterruptedException{
	Thread.sleep(1000);

	boolean result = cbFieldValidations.verifyRejectedFieldEnabled();
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
