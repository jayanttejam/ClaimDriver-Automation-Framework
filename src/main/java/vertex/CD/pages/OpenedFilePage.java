package vertex.CD.pages;

import org.openqa.selenium.Alert;
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


public class OpenedFilePage extends TestBase{
	
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
	
	@FindBy(xpath="//button[contains(text(),'Options')]")
	WebElement options;
	
	@FindBy(xpath="//a[contains(text(),'Activity Log')]")
	WebElement activityLog;
	
	@FindBy(xpath="//button[@id='newJournalToggle']")
	WebElement newActivityLog;
	
	@FindBy(xpath="//a[contains(text(),'Documents')]")
	WebElement documents;
	
	@FindBy(xpath="//button[@id='filterToggle']")
	WebElement filters;
	
	@FindBy(xpath="//a[@role='tab'][normalize-space()='Calendar']")
	WebElement calendar;
	
	@FindBy(xpath="//a[contains(text(),'Agenda')]")
	WebElement agenda;
	
	@FindBy(xpath="//a[@role='tab'][normalize-space()='Tasks']")
	WebElement tasks;
	
	@FindBy(xpath="//span[contains(text(),'Task Id')]")
	WebElement taskId;
	
	@FindBy(xpath="//button[normalize-space()='File Actions']")
	WebElement fileActions;
	
	@FindBy(xpath="//a[@id='faOpenCloseClaim']")
	WebElement closeClaim;
	
	@FindBy(xpath="//a[@id='faOpenCloseClaim']")
	WebElement openClaim;
	
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
		
		public OpenedFilePage() {
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
		
		public String verifyOpenedFilePageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			return driver.getTitle();
		}
		
		public boolean verifyOpenedFilePageLoaded() throws InterruptedException{
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			return overview.isDisplayed();
		}
		
		public String verifyOverviewPageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			overview.click();
			Thread.sleep(2000);
			return driver.getTitle();
		}
		
		public boolean verifyOverviewPageLoaded() throws InterruptedException{
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			overview.click();
			Thread.sleep(2000);
			return participantType.isDisplayed();
		}
		
		public String verifyFormsPageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			forms.click();
			Thread.sleep(2000);
			return driver.getTitle();
		}
		
		public boolean verifyFormsPageLoaded() throws InterruptedException{
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			forms.click();
			Thread.sleep(2000);
			return options.isDisplayed();
		}
		public String verifyActivityLogPageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			activityLog.click();
			Thread.sleep(2000);
			return driver.getTitle();
		}
		
		public boolean verifyActivityLogPageLoaded() throws InterruptedException{
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			activityLog.click();
			Thread.sleep(2000);
			return newActivityLog.isDisplayed();
		}
		public String verifyDocumentsPageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			documents.click();
			Thread.sleep(2000);
			return driver.getTitle();
		}
		
		public boolean verifyDocumentsPageLoaded() throws InterruptedException{
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			documents.click();
			Thread.sleep(2000);
			return filters.isDisplayed();
		}
		
		public String verifyCalendarPageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			calendar.click();
			Thread.sleep(2000);
			return driver.getTitle();
		}
		
		public boolean verifyCalendarPageLoaded() throws InterruptedException{
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			calendar.click();
			Thread.sleep(2000);
			return agenda.isDisplayed();
		}
		public String verifyTasksPageTitle() throws InterruptedException{
			Thread.sleep(1000);
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			tasks.click();
			Thread.sleep(2000);
			return driver.getTitle();
		}
		
		public boolean verifyTasksPageLoaded() throws InterruptedException{
			clickOnFilesMenu();
			Thread.sleep(1000);
			clickOnListFiles();
			Thread.sleep(1000);
			clickOnFirstClaimInList();
			Thread.sleep(2000);
			tasks.click();
			Thread.sleep(2000);
			return taskId.isDisplayed();
		}
		
		public boolean verifyFileIsClosed() throws InterruptedException{
			
			fileActions.click();
			Thread.sleep(1000);
			closeClaim.click();
			Thread.sleep(2000);
			yesOnPopUp.click();
			Thread.sleep(2000);

			String filestatus = fileStatus.getText();
			System.out.println("status:" +filestatus);
			if (filestatus.equals("Closed"))
			{
			return true;
			}
			else { 
				return false;
			}
		}
		
	   public boolean verifyFileIsReOpened() throws InterruptedException{
			
			fileActions.click();
			Thread.sleep(1000);
			closeClaim.click();
			Thread.sleep(2000);
			yesOnPopUp.click();
			Thread.sleep(2000);
			
			fileActions.click();
			Thread.sleep(1000);
			closeClaim.click();
			Thread.sleep(2000);
			yesOnPopUp.click();
			Thread.sleep(2000);
			
			String filestatus = fileStatus.getText();
			System.out.println("status:" +filestatus);
			if (filestatus.equals("Open"))
			{
			return true;
			}
			else { 
				return false;
			}
		}
	   
	   public boolean verifyAcceptClaimAndSubmit() throws InterruptedException{
			
			forms.click();
			Thread.sleep(2000);
			
			 Actions a = new Actions(driver);
		      a.moveToElement(acceptRadiobtn);
		      a.perform();
			Thread.sleep(2000);
			acceptRadiobtn.click();
			Thread.sleep(2000);
			submitbtn.click();
			Thread.sleep(2000);
			
			boolean select = acceptRadiobtn.isSelected();
			if (select == true)
			{
			return true;
			}
			else { 
				return false;
			}
		}
	   
	   public boolean verifyRejectClaimAndSubmit() throws InterruptedException{
			
			forms.click();
			Thread.sleep(2000);
			
			 Actions a = new Actions(driver);
		      a.moveToElement(rejectRadiobtn);
		      a.perform();
			Thread.sleep(2000);
			rejectRadiobtn.click();
			Thread.sleep(2000);
			submitbtn.click();
			Thread.sleep(2000);
			
			boolean select = rejectRadiobtn.isSelected();
			if (select == true)
			{
			return true;
			}
			else { 
				return false;
			}
		}
}
