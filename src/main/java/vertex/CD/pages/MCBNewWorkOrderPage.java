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


public class MCBNewWorkOrderPage extends TestBase{
	
	//public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//Page factory - OR
		
		@FindBy(xpath="//a[@id='MasterMainMenu-Files']")
		WebElement filesMainMenu;
		
		@FindBy(xpath="//a[contains(text(),'New File')]")
		WebElement newFile;
		
		@FindBy(xpath="//input[@value='Submit']") 
		WebElement submit;
		
		@FindBy(xpath="//select[@id='SelectedInsurerId']") 
		WebElement companyDropdown;
		
		@FindBy(xpath="//input[@id='AssetNumber']") 
		WebElement asssetNumber;
		
		@FindBy(xpath="//input[@placeholder='VIN']") 
		WebElement vin;
		
		@FindBy(xpath="//input[@id='DateOfLossWithUSFormat']") 
		WebElement dateOfLoss;
		
		@FindBy(xpath="//select[@id='SelectedWorkFileTypeId']") 
		WebElement fileType;
		
		// Collision invoice OR
		
		@FindBy(xpath="//select[@id='ddFleetName']") 
		WebElement fleetDropDown;
		
		@FindBy(xpath="//input[@id='InvoiceNo']") 
		WebElement invoiceNo;
		
		@FindBy(xpath="//input[@id='AuthNo']") 
		WebElement authNo;
		
		@FindBy(xpath="//input[@id='dtDateWork']") 
		WebElement dateWorkCompleted;
	
		
		@FindBy(xpath="//input[@id='SubTotal']") 
		WebElement subTotal;
		
		
		
		@FindBy(xpath="//input[@id='SalesTax']") 
		WebElement SalesTax;
	
		@FindBy(xpath="//input[@id='TotalCost']") 
		WebElement grandTotal;
	
	
		@FindBy(xpath="//input[@id='SubmittedBy']") 
		WebElement SubmittedBy;
		
		@FindBy(xpath="//input[@id='ReviewedBy']") 
		WebElement ReviewedBy;
		
		@FindBy(xpath="//input[@id='ApprovedBy']") 
		WebElement ApprovedBy;
		
		@FindBy(xpath="//input[@id='InvoiceStatus0']") 
		WebElement accepted;
		
		@FindBy(xpath="//input[@id='InvoiceStatus1']") 
		WebElement rejected;
		
		
		@FindBy(xpath="//input[@id='InvoiceUpload']") 
		WebElement uploadFiles;
		
		@FindBy(xpath="//input[@id='btnPDFtoJournal']") 
		WebElement submitInvoice;
		
		@FindBy(xpath="//input[@id='btnPrint']") 
		WebElement print;
		
		@FindBy(xpath="//input[@id='btnSave']") 
		WebElement save;
		
		@FindBy(xpath="//a[normalize-space()='Overview']")
		WebElement overview;
		
		@FindBy(xpath="//span[@class='k-icon k-i-arrow-60-down']")
		WebElement vinPopUp;
		
		
		// Initializing the Page Objects:
		
		public MCBNewWorkOrderPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		public void clickOnFilesMenu() {
			filesMainMenu.click();
		}
		
		public void clickOnNewFile() {
			newFile.click();
		}
		
		
		public MCBNewWorkOrderPage VerifyclickOnMCBNewFile() throws InterruptedException{
			filesMainMenu.click();
			
			Thread.sleep(2000);
			newFile.click();
			Thread.sleep(2000);
			return new MCBNewWorkOrderPage();
		}
		public String verifyMCBNewWorkOrderPageTitle(){
			return driver.getTitle();
		}
		
		public boolean verifyMCBNewWorkOrderPageLoaded(){
			return submit.isDisplayed();
		}
		
		public void selectCompany(String company) {
			Select select = new Select(companyDropdown);
			select.selectByVisibleText(company);
		}
		
		public void selectFleet(String fleetName) {
			Select select = new Select(fleetDropDown);
			select.selectByVisibleText(fleetName);
		}
		
		public void fillDataInNewWO(String astNo, String vinNo) throws InterruptedException {
			asssetNumber.sendKeys(astNo);
			vin.sendKeys(vinNo);
			Thread.sleep(2000);
			vinPopUp.click();
			Thread.sleep(2000);
			submit.click();
			Thread.sleep(2000);
		}
		
		public void fillDataInCollisionInvoice(String invNo,String autNo,String date,String subtotal,String saleTax,String subBy) throws Exception {
			Thread.sleep(1000);
			 Actions a = new Actions(driver);
		      a.moveToElement(subTotal);
		      a.perform();
		      Thread.sleep(2000);
			invoiceNo.sendKeys(invNo);
			// js.executeScript("javascript:window.scrollBy(250,350)");
			authNo.sendKeys(autNo);
			
			Thread.sleep(1000);
			System.out.println("In fillDataColli....");
//			 Actions a = new Actions(driver);
//		      a.moveToElement(parts);
//		      a.perform();
			
			// js.executeScript("javascript:window.scrollBy(500,500)");
			
			TestUtil.selectDate(driver, date);
			//TestUtil.selectDate(driver, "01/June/2022");
			
		
			subTotal.sendKeys(subtotal);
			SalesTax.sendKeys(saleTax);
			
			SubmittedBy.sendKeys(subBy);
			//ReviewedBy.sendKeys("AutoReview");
			//ApprovedBy.sendKeys("auto Test appr);
			//accepted.click();
			//rejected
			//uploadFiles
			submitInvoice.click();
			//print
			//save
		}
		public  boolean claimCreationTest()
		{
			try {
			return overview.isDisplayed();
			}
			catch (Exception e){
				System.out.println("Claim creation failed");
			}
			return false;
		}

}
