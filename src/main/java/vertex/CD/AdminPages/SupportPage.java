package vertex.CD.AdminPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import vertex.CD.base.TestBase;
import vertex.CD.pages.ReportsPage;
import vertex.CD.util.TestUtil;


public class SupportPage extends TestBase{
	
	//Page factory - OR
		
		@FindBy(xpath="//body/div[5]/nav[1]/div[1]/ul[1]/li[9]/a[1]")
		WebElement adminMainMenu;
		
		@FindBy(xpath="//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='Support']")
		WebElement supportPage;
		
		@FindBy(xpath="//a[contains(text(),'Assume Identity')]")
		WebElement assumeId;
		
		@FindBy(xpath="//input[@placeholder='User Name']")
		WebElement selectUser;
		
		@FindBy(xpath="//a[contains(text(),'Jayant Tejam')]")
		WebElement userName;
		
		@FindBy(xpath="//span[@id='bcAnchor']")
		WebElement clickOnUserName;
		
		@FindBy(xpath="//span[@class='k-icon k-i-arrow-60-down']")
		WebElement clickOnArrow;
		
		
		
		// Initializing the Page Objects:
		
		public SupportPage() {
			PageFactory.initElements(driver, this);
		}
			
		public void clickOnAdminMainMenu() {
			adminMainMenu.click();
		}
		
		public void clickOnSupport() {
			supportPage.click();
		}
		
		
		public void click_On_Support_Page() throws InterruptedException {
			clickOnAdminMainMenu();
			Thread.sleep(1000);
			clickOnSupport();
			Thread.sleep(2000);
		}
			
		public boolean verify_Support_Page_Loaded(){
			
		boolean isPresent = assumeId.isDisplayed();
		return isPresent;
		}
				
		public String verify_Support_Page_Title(){
			return driver.getTitle();
		}
		
		public boolean verify_Assume_Identity_functionality() throws InterruptedException {
			clickOnAdminMainMenu();
			Thread.sleep(1000);
			clickOnSupport();
			Thread.sleep(2000);
			selectUser.sendKeys("Jayant Tejam");
			Thread.sleep(2000);
			
			clickOnUserName.click();
			Thread.sleep(2000);
			
			Actions a = new Actions(driver);
		      a.moveToElement(assumeId);
		      a.perform();
			
			boolean btn = assumeId.isDisplayed();
			System.out.println("btn state : " +btn);
			
			boolean btne = assumeId.isEnabled();
			System.out.println("btn state : " +btne);
			
			//clickOnArrow.click();
			Thread.sleep(5000);
			assumeId.click();
			Thread.sleep(5000);
			System.out.println("clicked on assumeid : ");
//			WebElement usr = driver.findElement(By.xpath("//a[contains(text(),'Jayant Tejam')]"));
//			boolean result = usr.isDisplayed();
			boolean result = userName.isDisplayed();
			return result;
		}
}
