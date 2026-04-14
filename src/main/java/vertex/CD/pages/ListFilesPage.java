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


public class ListFilesPage extends TestBase{
	
	//public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//Page factory - OR
	@FindBy(xpath="//a[@id='MasterMainMenu-Files']")
	WebElement filesMainMenu;
	
	@FindBy(xpath="//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='List Files']")
	WebElement f_listFiles;
	
	@FindBy(xpath="//button[@id='btnListFiles']")
	WebElement Search;
	
	@FindBy(xpath="//label[@class='col-sm-2 col-form-label font-weight-bold']")
	WebElement lbl_LIstFiles;
	
	
	
		// Initializing the Page Objects:
		
		public ListFilesPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		public void clickOnFilesMenu() {
			filesMainMenu.click();
			
		}
		
		public void clickOnListFiles() {
			f_listFiles.click();
		}
		
		public String verifyListFilesPageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			return driver.getTitle();
		}
		
		public boolean verifyListFilesPageLoaded() throws InterruptedException{
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			
			return Search.isDisplayed();
		}
		
}
