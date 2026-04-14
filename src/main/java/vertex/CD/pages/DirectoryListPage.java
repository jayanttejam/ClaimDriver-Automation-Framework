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


public class DirectoryListPage extends TestBase{
	
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//Page factory - OR
		
		@FindBy(xpath="//a[@id='MasterMainMenu-Files']")
		WebElement filesMainMenu;
		
		@FindBy(xpath="//a[contains(text(),'New File')]")
		WebElement newFile;
		
		@FindBy(xpath="//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='List Files']")
		WebElement f_listFiles;
		
		@FindBy(xpath="//a[contains(text(),'Search Files')]") 
		WebElement searchFiles;
		
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
		
		@FindBy(xpath="//input[@id='InvoiceNo']") 
		WebElement invoiceNo;
		
		@FindBy(xpath="//input[@id='AuthNo']") 
		WebElement authNo;
		
		@FindBy(xpath="//input[@id='AuthNo2']") 
		WebElement authNo2;
		
		@FindBy(xpath="//input[@id='dtDateWork']") 
		WebElement dateWorkCompleted;
	
		@FindBy(xpath="//input[@id='PartsCost']") 
		WebElement parts;
		
		@FindBy(xpath="//input[@id='LaborCost']") 
		WebElement bodyLabor;
		
		@FindBy(xpath="//input[@id='PaintLabor']") 
		WebElement paintLabor;
		
		@FindBy(xpath="//input[@id='MechLabor']") 
		WebElement mechLabor;
		
		
		
		@FindBy(xpath="//input[@id='FrameLabor']") 
		WebElement frameLabor;
	
		@FindBy(xpath="//input[@id='PaintMaterial']") 
		WebElement paintMaterial;
		
		@FindBy(xpath="//input[@id='Sublet']") 
		WebElement sublet;
		
		@FindBy(xpath="//input[@id='OtherCost']") 
		WebElement other;
		
		@FindBy(xpath="//input[@id='SubTotal']") 
		WebElement subTotal;
		
		
		
		@FindBy(xpath="//input[@id='SalesTax']") 
		WebElement SalesTax;
	
		@FindBy(xpath="//input[@id='TotalCost']") 
		WebElement grandTotal;
		
		@FindBy(xpath="//input[@id='PartsDicount']") 
		WebElement PartsDicount;
		
		@FindBy(xpath="//input[@id='LaborDiscount']") 
		WebElement LaborDiscount;
		
		@FindBy(xpath="//input[@id='Discount']") 
		WebElement subtotalDiscount;
		
		
		
		@FindBy(xpath="//input[@id='PaymentAmount']") 
		WebElement PaymentAmount;
	
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
		
		public DirectoryListPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		public void clickOnFilesMenu() {
			filesMainMenu.click();
		}
		
		public void clickOnNewFile() {
			newFile.click();
		}
		
		public void clickOnListFiles() {
			f_listFiles.click();
		}
		
		public void clickOnSearchFiles() {
			searchFiles.click();
		}
		
		public DirectoryListPage VerifyclickOnNewFile() throws InterruptedException{
			filesMainMenu.click();
			
			Thread.sleep(2000);
			newFile.click();
			Thread.sleep(3000);
			return new DirectoryListPage();
		}
		public String verifyNewWorkOrderPageTitle(){
			return driver.getTitle();
		}
		
		public boolean verifyNewWorkOrderPageLoaded(){
			return submit.isDisplayed();
		}
		
		public void selectCompany(String company) {
			Select select = new Select(companyDropdown);
			select.selectByVisibleText(company);
		}
		
		public void fillDataInNewWO(String astNo, String vinNo) throws InterruptedException {
			asssetNumber.sendKeys(astNo);
			vin.sendKeys(vinNo);
			Thread.sleep(3000);
			vinPopUp.click();
			Thread.sleep(2000);
			submit.click();
			Thread.sleep(3000);
		}
		
		public void fillDataInCollisionInvoice(String invNo,String autNo,String autNo2,String date,String part,String bodyLB, String paintLB, String mechLB,String frameLB,String paintMTL, String sublt,String othr,String saleTax,String subBy) throws Exception {
			Thread.sleep(2000);
			invoiceNo.sendKeys(invNo);
			// js.executeScript("javascript:window.scrollBy(250,350)");
			authNo.sendKeys(autNo);
			authNo2.sendKeys(autNo2);
			Thread.sleep(1000);
			System.out.println("In fillDataColli....");
			 Actions a = new Actions(driver);
		      a.moveToElement(parts);
		      a.perform();
			
			// js.executeScript("javascript:window.scrollBy(500,500)");
			 Thread.sleep(2000);
			TestUtil.selectDate(driver, date);
			//TestUtil.selectDate(driver, "01/June/2022");
			
			parts.sendKeys(part);
			bodyLabor.sendKeys(bodyLB);
			paintLabor.sendKeys(paintLB);
			mechLabor.sendKeys(mechLB);
			frameLabor.sendKeys(frameLB);
			paintMaterial.sendKeys(paintMTL);
			sublet.sendKeys(sublt);
			other.sendKeys(othr);
			//subTotal
			SalesTax.sendKeys(saleTax);
			//grandTotal
			//PartsDicount.sendKeys("10");
			//LaborDiscount
			//subtotalDiscount
			//PaymentAmount
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
