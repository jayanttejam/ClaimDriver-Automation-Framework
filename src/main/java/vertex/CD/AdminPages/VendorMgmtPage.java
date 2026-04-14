package vertex.CD.AdminPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import vertex.CD.base.TestBase;
import vertex.CD.pages.ReportsPage;
import vertex.CD.util.TestUtil;


public class VendorMgmtPage extends TestBase{
	
	//Page factory - OR
		
		@FindBy(xpath="//body/div[5]/nav[1]/div[1]/ul[1]/li[9]/a[1]")
		WebElement adminMainMenu;
		
		@FindBy(xpath="//a[contains(text(),'Vendor Management')]")
		WebElement vendorMgmtPage;
		
		@FindBy(xpath="//a[normalize-space()='Preferred Users']")
		WebElement prefUsers;
		
		
		
		// Initializing the Page Objects:
		
		public VendorMgmtPage() {
			PageFactory.initElements(driver, this);
		}
			
		public void clickOnAdminMainMenu() {
			adminMainMenu.click();
		}
		
		public void clickOnVendorMgmt() {
			vendorMgmtPage.click();
		}
		
		
		public void click_On_VendorMgmt_Page() throws InterruptedException {
			clickOnAdminMainMenu();
			Thread.sleep(1000);
			clickOnVendorMgmt();
			Thread.sleep(2000);
		}
			
		public boolean verify_VendorMgmt_Page_Loaded(){
			
		boolean isPresent = prefUsers.isDisplayed();
		return isPresent;
		}
				
		public String verify_VendorMgmt_Page_Title(){
			return driver.getTitle();
		}

}
