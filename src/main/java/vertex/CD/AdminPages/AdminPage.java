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


public class AdminPage extends TestBase{
	
	//Page factory - OR
		
		@FindBy(xpath="//body/div[5]/nav[1]/div[1]/ul[1]/li[9]/a[1]")
		WebElement adminMainMenu;
		
		@FindBy(xpath="//a[contains(text(),'Admin')]")
		WebElement adminPage;
		
		@FindBy(xpath="//a[contains(text(),'Diagnostics')]")
		WebElement diagnostics;
		
		@FindBy(xpath="//a[contains(text(),'Meineke Central Billing')]") 
		WebElement MCB;
		
		
		
		// Initializing the Page Objects:
		
		public AdminPage() {
			PageFactory.initElements(driver, this);
		}
			
		public void clickOnAdminMainMenu() {
			adminMainMenu.click();
		}
		
		public void clickOnAdmin() {
			adminPage.click();
		}
		
		
		public void clickOn_AdminPage() throws InterruptedException {
			clickOnAdminMainMenu();
			Thread.sleep(1000);
			clickOnAdmin();
			Thread.sleep(2000);
		}
			
		public boolean verify_Admin_Page_Loaded(){
			
		boolean isPresent = diagnostics.isDisplayed();
		return isPresent;
		}
				
		public String verify_Admin_Page_Title(){
			return driver.getTitle();
		}

}
