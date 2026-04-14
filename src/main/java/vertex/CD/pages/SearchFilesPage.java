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


public class SearchFilesPage extends TestBase{
	
	//public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//Page factory - OR
	@FindBy(xpath="//a[@id='MasterMainMenu-Files']")
	WebElement filesMainMenu;
	
	@FindBy(xpath="//a[contains(text(),'Search Files')]")
	WebElement searchFiles;
	
	@FindBy(xpath="//button[@id='btnSearch2']")
	WebElement Search;
	
	@FindBy(xpath="//label[@class='col-sm-2 col-form-label font-weight-bold']")
	WebElement lbl_LIstFiles;
	
	
	
		// Initializing the Page Objects:
		
		public SearchFilesPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		public void clickOnFilesMenu() {
			filesMainMenu.click();
			
		}
		
		public void clickOnSearchFiles() {
			searchFiles.click();
		}
		
		public String verifySearchFilesPageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnSearchFiles();
			Thread.sleep(1000);
			return driver.getTitle();
		}
		
		public boolean verifySearchFilesPageLoaded() throws InterruptedException{
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnSearchFiles();
			Thread.sleep(1000);
			
			return Search.isDisplayed();
		}
		
}
