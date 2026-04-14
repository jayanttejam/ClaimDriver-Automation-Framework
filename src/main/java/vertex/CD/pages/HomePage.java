package vertex.CD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vertex.CD.base.TestBase;
import vertex.CD.base.TestBaseNew;
import vertex.CD.driver.DriverManager;

public class HomePage extends TestBaseNew{
	
	//Page factory - OR
	
		@FindBy(xpath="//a[@id='MasterMainMenu-Workdesk']")
		WebElement workDeskMainMenu;
		
		@FindBy(xpath="//a[contains(text(),'Open Files')]")
		WebElement openFiles;
		
		@FindBy(xpath="//button[@id='btnListFiles']")
		WebElement search;
		
		@FindBy(xpath="//a[contains(text(),'My Communications Dashboard')]") 
		WebElement myCommDashboard;
		
		@FindBy(xpath="//label[contains(text(),'My Messages')]") 
		WebElement myMessages;
		
		@FindBy(xpath="//div[contains(text(),'My Recent Files')]") 
		WebElement myRecentFiles;
		
//		@FindBy(xpath="//a[contains(text(),'Jayant Tejam')]") 
//		WebElement userName;
		
		@FindBy(xpath="//div[@class='dropdown']//a[@id='MasterMainMenu-DropDownMenuLink']") 
		WebElement userName;
		
		@FindBy(xpath="//a[contains(text(),'Log out')]") 
		WebElement logOut;
		
		@FindBy(xpath="//p[contains(text(),'Sign in to ClaimDriver:')]") 
		WebElement loginPageLabel;
		
		@FindBy(xpath="//tbody//tr//td[2]")
		WebElement claimNo1;
		WebDriver driver = DriverManager.getDriver();
		
		// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		
		public boolean verifyMyCommDashboardPageLoaded() throws InterruptedException{
			myCommDashboard.click();
			Thread.sleep(2000);
			return myMessages.isDisplayed();
		}
		
		public boolean verifyOpenFilesPageLoaded() throws InterruptedException{
			openFiles.click();
			Thread.sleep(2000);
			return search.isDisplayed();
		}
		public boolean verifyLogOutHappening() throws InterruptedException{
			userName.click();
			Thread.sleep(1000);
			logOut.click();
			Thread.sleep(2000);
			return loginPageLabel.isDisplayed();
		}
		public boolean verifyRecentFileIsPresent() throws InterruptedException{
			
			Thread.sleep(1000);
			return claimNo1.isDisplayed();
		}
}
