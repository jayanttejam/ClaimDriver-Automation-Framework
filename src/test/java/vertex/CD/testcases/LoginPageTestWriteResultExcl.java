package vertex.CD.testcases;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vertex.CD.base.TestBase;
import vertex.CD.pages.HomePage;
import vertex.CD.pages.LoginPage;
import vertex.CD.util.CustomListener;
import vertex.CD.util.TestUtil;
import vertex.CD.util.XLUtility;


@Listeners(CustomListener.class)
public class LoginPageTestWriteResultExcl extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	private Workbook workbook;
	private String sheetName = "TestResults";
	private String filePath = "./TestData\\TestData1.xlsx";
	String testResult="";
	
	@DataProvider(name="ClaimDriverData")
	String [][] getData( ) throws IOException {
		
		String path="./TestData\\TestData.xlsx";
		
		int rownum = XLUtility.getRowCount("Login");
		int colcount = XLUtility.getCellCount("Login", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtility.getCellData(path, "Login", i, j);
			}
		}
		
		return logindata;
		
	}
	
public static void setData(Integer no, String testResult ) throws IOException {
		
		String path="./TestData\\TestData.xlsx";
		
		int rownum = XLUtility.getRowCount("Login");
		int colcount = XLUtility.getCellCount("Login", 1);
		
		//String logindata[][] = new String [rownum][colcount];
		
		for(int i=no;i<=rownum;i++)
		{
			for (int j=colcount;j<=colcount;j++)
			{
				XLUtility.setCellData(path, "Login", i, j, testResult);
			}
			break;
		}
		
		//return logindata;
		
	}
	
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage = new LoginPage();
	workbook = new XSSFWorkbook();
}
	
@Test(priority=1, enabled=false)
public void loginPageTitleTest()
{
	String title = loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "Log in | ClaimDriver");
}

@Test(priority=2, enabled=false)
public void loginTest() throws IOException
{
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	boolean result = loginPage.LoginTest();
	
	Assert.assertFalse(result);
	
//	if(result == true) 
//	{
//		Assert.assertTrue(true);
//		//logger.info("Login test passed");
//	}
//	
//	else 
//	{
//		TestUtil.captureScreen(driver,"loginTest");
//		Assert.assertTrue(false);
//		//logger.info("Login test failed");	
//	}
   //Assert.assertEquals(result, true);
}

@Test(priority=3, dataProvider="ClaimDriverData", enabled=true)
public void loginTestbyDataDriven(String no, String user, String pwd) throws IOException
{
	
	int num =Integer.parseInt(no);
	System.out.println(no);
	homePage = loginPage.login(user,pwd);
	boolean result = loginPage.LoginTest();
	
	Assert.assertFalse(result);
	
	if (result==false)
	{
		System.out.println("In IF");
		testResult="PASS";
	}
	else {
		System.out.println("In else");
		testResult="FAIL";
	}
	
	setData(num, testResult);
	
/*	Sheet sheet = workbook.createSheet(sheetName);

    // Create a header row for each test execution
    Row headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("Test Case Name");
    headerRow.createCell(1).setCellValue("Test Result");
    
     

    // Create a data row for each test execution
    Row dataRow = sheet.createRow(1);
    dataRow.createCell(num - 1).setCellValue(user);
    dataRow.createCell(num).setCellValue(testResult);

    // You can add more test data as needed

    try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
        workbook.write(outputStream);
    } catch (IOException e) {
        e.printStackTrace();
    } */
}


@AfterMethod
public void tearDown()
{
	try {
        workbook.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
	driver.quit();
}
}
