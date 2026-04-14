package vertex.CD.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vertex.CD.base.TestBase;
import vertex.CD.util.TestUtil;


public class ClaimAcceptRejectByCBuser extends TestBase{
	
	//Page factory - OR
	@FindBy(xpath="//a[@id='MasterMainMenu-Files']")
	WebElement filesMainMenu;
	
	@FindBy(xpath="//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='List Files']")
	WebElement f_listFiles;
	
	@FindBy(xpath="//tbody//tr//td[2]")
	WebElement claimNo1;
	
	@FindBy(xpath="//a[contains(text(),'Overview')]")
	WebElement overview;
	
	@FindBy(xpath="//span[contains(text(),'Participant Type')]")
	WebElement participantType;
	
	@FindBy(xpath="//a[contains(text(),'Forms')]")
	WebElement forms;
	
	
	@FindBy(xpath="//button[@id='faOpenCloseClaim-action-confirmation-submit-button']")
	WebElement yesOnPopUp;
	
	@FindBy(xpath="//div[@class='d-none d-lg-block col-md-4 col-lg-4']//li[2]//span[1]")
	WebElement fileStatus;
	
	@FindBy(xpath="//input[@id='InvoiceStatus0']")
	WebElement acceptRadiobtn;
	
	@FindBy(xpath="//input[@id='InvoiceStatus1']")
	WebElement rejectRadiobtn;
	
	@FindBy(xpath="//input[@id='btnPDFtoJournal']")
	WebElement submitbtn;
	
	
		// Initializing the Page Objects:
		
		public ClaimAcceptRejectByCBuser() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		public void clickOnFilesMenu() {
			filesMainMenu.click();
			
		}
		
		public void clickOnListFiles() {
			f_listFiles.click();
		}
		
		public void clickOnFirstClaimInList() {
			claimNo1.click();
		}
		
		public void acceptClaim() throws InterruptedException{
			for (int i=1; i<=2; i++) {
				
//				WebElement ele = driver.findElement(By.xpath("//tbody//tr//td["+ i +"]"));
//				System.out.println(ele.getText());
				
				//WebElement ele = driver.findElement(By.xpath("//tbody//tr//td[2]"));
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(4000);
			//clickOnFirstClaimInList();
			
			WebElement ele = driver.findElement(By.xpath("//tbody//tr["+ i +"]"));
			//System.out.println(ele.getText());
			ele.click();
			Thread.sleep(2000);
			forms.click();
			Thread.sleep(2000);
			 Actions a = new Actions(driver);
		      a.moveToElement(acceptRadiobtn);
		      a.perform();
			Thread.sleep(2000);
			acceptRadiobtn.click();
			Thread.sleep(2000);
			submitbtn.click();
			Thread.sleep(30000);
			
			}
		}
		
		public void rejectClaim() throws InterruptedException{
			for (int i=1; i<=2; i++) {
				
//				WebElement ele = driver.findElement(By.xpath("//tbody//tr//td["+ i +"]"));
//				System.out.println(ele.getText());
				
				//WebElement ele = driver.findElement(By.xpath("//tbody//tr//td[2]"));
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(4000);
			//clickOnFirstClaimInList();
			
			WebElement ele = driver.findElement(By.xpath("//tbody//tr["+ i +"]"));
			//System.out.println(ele.getText());
			ele.click();
			Thread.sleep(2000);
			forms.click();
			Thread.sleep(2000);
			 Actions a = new Actions(driver);
		      a.moveToElement(rejectRadiobtn);
		      a.perform();
			Thread.sleep(2000);
			rejectRadiobtn.click();
			Thread.sleep(2000);
			submitbtn.click();
			Thread.sleep(3000);
			
			}
		}
	
}
