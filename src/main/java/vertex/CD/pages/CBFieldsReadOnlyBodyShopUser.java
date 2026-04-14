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


public class CBFieldsReadOnlyBodyShopUser extends TestBase{
	
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
		
		@FindBy(xpath="//input[@id='txtBrand']")
		WebElement brand;
		
		@FindBy(xpath="//input[@id='ShopNumber']")
		WebElement shopNumber;
		
		@FindBy(xpath="//input[@id='CustomerName']")
		WebElement fleetName;
		
		@FindBy(xpath="//input[@id='PartsDicount']") 
		WebElement partsDiscount;
		
		@FindBy(xpath="//input[@id='LaborDiscount']") 
		WebElement laborDiscount;
		
		@FindBy(xpath="//input[@id='Discount']") 
		WebElement subtotalDiscount;
		
		
		@FindBy(xpath="//input[@id='ReviewedBy']")
		WebElement reviewedBy;
		
		@FindBy(xpath="//input[@id='ApprovedBy']")
		WebElement approvedBy;
		
		@FindBy(xpath="//tbody/tr[33]/td[2]") 
		WebElement acceptedRDO;
		
		@FindBy(xpath="//tbody/tr[33]/td[2]") 
		WebElement rejectedRDO;
		
		
		
		// Initializing the Page Objects:
		
		public CBFieldsReadOnlyBodyShopUser() {
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
		
		
		public boolean verifyNewWorkOrderPageLoaded(){
			return submit.isDisplayed();
		}
		
		public void selectCompany() {
			Select select = new Select(companyDropdown);
			select.selectByVisibleText("ATT");
		}
		
		public void fillDataInNewWO() throws InterruptedException {
			selectCompany();
			asssetNumber.sendKeys("2222");
			vin.sendKeys("AUTO567890123TEST");
			Thread.sleep(2000);
			vinPopUp.click();
			Thread.sleep(2000);
			submit.click();
			Thread.sleep(2000);
		}
		
		public boolean verifyShopNoFieldDisabled(){
			
			Boolean result = false;
		    try {
		        String value = shopNumber.getAttribute("readOnly");
		        if (value != null){
		            result = true;
		        }
		    } catch (Exception e) {}

		    return result;
		}
		public boolean verifyFleetNameFieldDisabled(){
			
			Boolean result = false;
		    try {
		        String value = fleetName.getAttribute("readOnly");
		        
		        if (value != null){
		            result = true;
		        }
		    } catch (Exception e) {}

		    return result;
		}
		public boolean verifyPartsDiscountFieldDisabled(){
	
	Boolean result = false;
    try {
        String value = partsDiscount.getAttribute("readOnly");
        if (value != null){
            result = true;
        }
    } catch (Exception e) {}

    return result;
}
		public boolean verifyLaborDiscountFieldDisabled(){
	
	Boolean result = false;
    try {
        String value = laborDiscount.getAttribute("readOnly");
        if (value != null){
            result = true;
        }
    } catch (Exception e) {}

    return result;
}
		public boolean verifySubtotalDiscountFieldDisabled(){
	
	Boolean result = false;
    try {
        String value = subtotalDiscount.getAttribute("readOnly");
        if (value != null){
            result = true;
        }
    } catch (Exception e) {}

    return result;
}
		public boolean verifyReviewedByFieldDisabled(){
	
	Boolean result = false;
    try {
        String value = reviewedBy.getAttribute("readOnly");
        if (value != null){
            result = true;
        }
    } catch (Exception e) {}

    return result;
}
		public boolean verifyApprovedByFieldDisabled(){
	
	Boolean result = false;
    try {
        String value = approvedBy.getAttribute("readOnly");
        if (value != null){
            result = true;
        }
    } catch (Exception e) {}

    return result;
}
		public boolean verifyBrandFieldDisabled(){
	
	Boolean result = false;
    try {
        String value = brand.getAttribute("readOnly");
        if (value != null){
            result = true;
        }
    } catch (Exception e) {}

    return result;
}

		public boolean verifyAcceptedFieldDisabled(){
			
		//	WebElement button = driver.findElement(By.xpath("button XPath"));
			String classes = acceptedRDO.getAttribute("class");
			System.out.println(classes);
			boolean result = classes.contains("wdc10");
			
			//Boolean result = accepted.isEnabled();
			
			return result;
		}
		
	public boolean verifyRejectedFieldDisabled(){
		String classes = rejectedRDO.getAttribute("class");
		System.out.println(classes);
		boolean result = classes.contains("wdc10");
			//Boolean result = rejected.isEnabled();
			return result;
		}
}
