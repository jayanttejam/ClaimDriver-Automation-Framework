package vertex.CD.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import vertex.CD.base.TestBase;
import vertex.CD.util.TestUtil;


public class ListMessagesPage extends TestBase{
	
	//public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//Page factory - OR
	@FindBy(xpath="//a[@id='MasterMainMenu-Messages']") 
	WebElement messages;
	
	@FindBy(xpath="//div[@class='dropdown-menu show']//a[@class='dropdown-item'][contains(text(),'List Messages')]") 
	WebElement listMessages;
	
	@FindBy(xpath="//label[contains(text(),'My Messages')]")
	WebElement lbl_MyMessages;
	
	
		// Initializing the Page Objects:
		
		public ListMessagesPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		public void clickOnMessagesMenu() {
			messages.click();
			
		}
		
		public void clickOnListMessages() {
			listMessages.click();
		}
		
		public String verifyMessagesPageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnMessagesMenu();
			Thread.sleep(1000);
			clickOnListMessages();
			Thread.sleep(1000);
			return driver.getTitle();
		}
		
		public boolean verifyMessagesPageLoaded() throws InterruptedException{
			clickOnMessagesMenu();
			Thread.sleep(1000);
			clickOnListMessages();
			Thread.sleep(1000);
			
			return lbl_MyMessages.isDisplayed();
		}
		
}
