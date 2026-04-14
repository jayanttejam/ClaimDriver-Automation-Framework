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


public class SecurityPage extends TestBase{
	
	//Page factory - OR
		
		@FindBy(xpath="//body/div[5]/nav[1]/div[1]/ul[1]/li[9]/a[1]")
		WebElement adminMainMenu;
		
		@FindBy(xpath="//a[normalize-space()='Security']")
		WebElement securityPage;
		
		@FindBy(xpath="//a[contains(text(),'User Activity')]")
		WebElement userAct;
		
		
		
		// Initializing the Page Objects:
		
		public SecurityPage() {
			PageFactory.initElements(driver, this);
		}
			
		public void clickOnAdminMainMenu() {
			adminMainMenu.click();
		}
		
		public void clickOnSecurity() {
			securityPage.click();
		}
		
		
		public void click_On_Security_Page() throws InterruptedException {
			clickOnAdminMainMenu();
			Thread.sleep(1000);
			clickOnSecurity();
			Thread.sleep(2000);
		}
			
		public boolean verify_Security_Page_Loaded(){
			
		boolean isPresent = userAct.isDisplayed();
		return isPresent;
		}
				
		public String verify_Security_Page_Title(){
			return driver.getTitle();
		}

}
