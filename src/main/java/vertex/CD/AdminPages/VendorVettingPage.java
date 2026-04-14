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


public class VendorVettingPage extends TestBase{
	
	//Page factory - OR
		
		@FindBy(xpath="//body/div[5]/nav[1]/div[1]/ul[1]/li[9]/a[1]")
		WebElement adminMainMenu;
		
		@FindBy(xpath="//a[contains(text(),'Vendor Vetting')]")
		WebElement vendorVetPage;
		
		@FindBy(xpath="//div[contains(text(),'Vendor Vetting')]")
		WebElement vendorVet;
		
		
		
		// Initializing the Page Objects:
		
		public VendorVettingPage() {
			PageFactory.initElements(driver, this);
		}
			
		public void clickOnAdminMainMenu() {
			adminMainMenu.click();
		}
		
		public void clickOnVendorVetting() {
			vendorVetPage.click();
		}
		
		
		public void click_On_VendorVetting_Page() throws InterruptedException {
			clickOnAdminMainMenu();
			Thread.sleep(1000);
			clickOnVendorVetting();
			Thread.sleep(2000);
		}
			
		public boolean verify_VendorVetting_Page_Loaded(){
			
		boolean isPresent = vendorVet.isDisplayed();
		return isPresent;
		}
				
		public String verify_VendorVetting_Page_Title(){
			return driver.getTitle();
		}

}
