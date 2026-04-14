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
import vertex.CD.pages.KeysInKeysOutFunctionality;
import vertex.CD.pages.LoginPage;
import vertex.CD.pages.NewWorkOrderPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class KeysInKeysOutFunctionalityTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	//NewWorkOrderPage newWorkOrderPage;
    KeysInKeysOutFunctionality keysInKeysOutFunctionality;
	
	
	
	
@BeforeClass
public void setup() throws Exception 
{
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username3"), prop.getProperty("password3"));
	keysInKeysOutFunctionality = new KeysInKeysOutFunctionality();
	keysInKeysOutFunctionality.clickOnFilesMenu();
	Thread.sleep(1000);
	keysInKeysOutFunctionality.clickOnNewFile();
	Thread.sleep(1000);
	keysInKeysOutFunctionality.fillDataInNewWO();
	Thread.sleep(1000);
	keysInKeysOutFunctionality.fillDataInCollisionInvoice();
}

@Test(priority=1, enabled=false)
public void verify_KeysIn_Field_Present_On_Form_Test() throws InterruptedException{
	//Thread.sleep(1000);
	boolean result = keysInKeysOutFunctionality.verifyKeysInPresent();
	Assert.assertTrue(result);
}

@Test(priority=2, enabled=false)
public void verify_KeysOut_Field_Present_On_Form_Test() throws InterruptedException{
	//Thread.sleep(1000);

	boolean result = keysInKeysOutFunctionality.verifyKeysOutPresent();
	Assert.assertTrue(result);
}
@Test(priority=3, enabled=false)
public void verify_KeysIn_Field_Editable_For_ShopUser_Test() throws InterruptedException{
	//Thread.sleep(1000);
	boolean result = keysInKeysOutFunctionality.verifyKeysInFieldEditable();
	Assert.assertFalse(result);
}

@Test(priority=4, enabled=false)
public void verify_KeysOut_Field_Disabled_For_ShopUser_Test() throws InterruptedException{
	//Thread.sleep(1000);

	boolean result = keysInKeysOutFunctionality.verifyKeysOutFieldEditable();
	Assert.assertTrue(result);
}

@Test(priority=5, enabled=true)
public void verify_KeysIn_Value_Saved_For_BodyShopUser_Test() throws Exception{
	keysInKeysOutFunctionality.keysInDateSave();
	Thread.sleep(1000);

	boolean result = keysInKeysOutFunctionality.verifyKeysInDateSave();
	Assert.assertTrue(result);
}
@Test(priority=6, enabled=true)

public void verify_KeysIn_Field_Disabled_After_KeysIn_Date_Saved_For_BodyShopUser_Test() throws Exception{
	//keysInKeysOutFunctionality.keysInDateSave();
	Thread.sleep(1000);

	boolean result = keysInKeysOutFunctionality.verifyKeysInFieldDisabled();
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
