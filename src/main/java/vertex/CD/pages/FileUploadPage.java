package vertex.CD.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vertex.CD.base.TestBase;
import vertex.CD.util.TestUtil;


public class FileUploadPage extends TestBase{
	
	
	//Page factory - OR
		
		@FindBy(xpath="//body/div[@class='container-fluid mx-0 px-0 border-bottom']/nav[@class='navbar navbar-fixed-top navbar-expand-lg navbar-dark cPrimary']/div[@id='MasterMainMenu']/ul[@class='navbar-nav mr-auto']/li[8]/a[1]")
		WebElement uploadFilesMainMenu;
		
		@FindBy(xpath="//a[normalize-space()='Upload AI File']")
		WebElement uploadAIFile;
		
		@FindBy(xpath="//input[@id='files']")
		WebElement selectFiles;
		
		@FindBy(xpath="//button[normalize-space()='Upload']")
		WebElement upload;
		
		@FindBy(xpath="//div[contains(text(),'AI File Upload')]")
		WebElement AIFileUpload;
		
		// Initializing the Page Objects:
		
		public FileUploadPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyPageLoad(){
			
			uploadFilesMainMenu.click();
			uploadAIFile.click();
			return AIFileUpload.isDisplayed();
		}
		
		public String verifyFileUploadPageTitle(){
			uploadFilesMainMenu.click();
			uploadAIFile.click();
			return driver.getTitle();
		}
			
		public void clickOnUploadFileMenu() {
			uploadFilesMainMenu.click();
		}
		
		public void clickOnUploadFile() {
			uploadAIFile.click();
		}
		
		public void clickOnSelectFile() {
			selectFiles.click();
		}
	
		
		public String VerifyFileUpload() throws InterruptedException{
			clickOnUploadFileMenu();
			Thread.sleep(2000);
			
			clickOnUploadFile();
			Thread.sleep(3000);
			
			selectFiles.sendKeys(prop.getProperty("AIFilePath"));
			Thread.sleep(2000);
			
			upload.click();
		
			Thread.sleep(5000);
			
		//	WebDriverWait wait = new WebDriverWait(driver, 5);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println(alertText);
			alert.accept();
			
			
			
//			Alert alert = driver.switchTo().alert();
//			
//			String alertText = alert.getText();
//			System.out.println(alertText);
//			alert.accept();
			return alertText;
			
//			if (alertText.equals("AI File Uploaded Successfully")|| alertText.equals("Meineke - AI File Uploading has been failed due to duplication"))
//			   {
//					return true;
//			   }
//			else {
//				   return false;
//			     }	
		}
}
