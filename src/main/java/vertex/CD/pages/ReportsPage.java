package vertex.CD.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import vertex.CD.base.TestBase;
import vertex.CD.util.TestUtil;


public class ReportsPage extends TestBase{
	
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//Page factory - OR
		
		@FindBy(xpath="//a[@id='MasterMainMenu-Report']")
		WebElement reportMainMenu;
		
		@FindBy(xpath="//a[contains(text(),'Central Billing (Archived)')]")
		WebElement centralBillingArch;
		
		@FindBy(xpath="//a[@id='MasterMainMenu-Report-1']")
		WebElement fleetStandard;		
		@FindBy(xpath="//div[@class='dropdown-submenu']//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='CarMax']")
		WebElement fleetStandardCarmax;
		

		@FindBy(xpath="//a[@id='MasterMainMenu-Report-27']")
		WebElement claimActivity;
		@FindBy(xpath="//div[@class='dropdown-submenu']//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='CarMax']")
		WebElement claimActivityCarmax;
		
		@FindBy(xpath="//a[@id='MasterMainMenu-Report-26']")
		WebElement OpenVsClosed;
		@FindBy(xpath="//div[@class='dropdown-submenu']//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='CarMax']")
		WebElement OpenVsClosedCarmax;
		
		@FindBy(xpath="//a[@id='MasterMainMenu-Report-19']")
		WebElement claimPerformance;
		@FindBy(xpath="//div[@class='dropdown-submenu']//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='CarMax']")
		WebElement claimPerformanceCarmax;
		
		@FindBy(xpath="//a[@id='MasterMainMenu-Report-FleetBillingReport']")
		WebElement fleetBillingMainMenu;
		@FindBy(xpath="//a[normalize-space()='Fleet Billing']")
		WebElement fleetBilling;
		
		@FindBy(xpath="//a[normalize-space()='Fleet Billing OpenvsClose']")
		WebElement fleetBillingOpenvsClose;
		
		
		
		@FindBy(xpath="//a[contains(text(),'Meineke Central Billing')]") 
		WebElement MCB;
		
		@FindBy(xpath="//a[contains(text(),'Unifirst Report')]") 
		WebElement unifirst;
		
		@FindBy(xpath="//a[contains(text(),'Amazon Report')]") 
		WebElement amazonReport;
		
		@FindBy(xpath="//a[contains(text(),'Hertz Billing')]") 
		WebElement hertzBilling;
		
		@FindBy(xpath="//a[contains(text(),'Statement / Billing Report')]") 
		WebElement statementBilling;
		
		@FindBy(xpath="//a[contains(text(),'Open Claims')]") 
		WebElement openClaims;
		
		@FindBy(xpath="//a[contains(text(),'Preferred Location Report')]") 
		WebElement	preferredLocation;
		
		@FindBy(xpath="//button[@class='btn btn-link collapsed']") 
		WebElement reportName;
		
		@FindBy(xpath="//input[@id='btnShowInvoice']") 
		WebElement run;
		
		@FindBy(xpath="//input[@id='btnExporttoExcel']") 
		WebElement exportToExcel;
		
		@FindBy(xpath="//input[@id='DateTimeFilters_From']") 
		WebElement dateFrom;
		
		@FindBy(xpath="//input[@id='DateTimeFilters_To']") 
		WebElement dateTo;
		
		// Initializing the Page Objects:
		
		public ReportsPage() {
			PageFactory.initElements(driver, this);
		}
			
		public void clickOnReportsMenu() {
			reportMainMenu.click();
		}
		
		
/******************* Central Billing ******************************************/
		public void clickOnCentralBilling() {
			centralBillingArch.click();
		}
		
		public boolean verifyCentralBillingReportPageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("CentralBilling Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage VerifyclickOnCentralBilling() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(2000);
			clickOnCentralBilling();
			Thread.sleep(3000);
			return new ReportsPage();
		}
		public String verifyCentralBillingReportsPageTitle(){
			return driver.getTitle();
		}
		
		public void exportReportDownload() throws InterruptedException{
			reportMainMenu.click();
			
			Thread.sleep(2000);
			centralBillingArch.click();
			Thread.sleep(3000);
			dateFrom.clear();
		    dateFrom.sendKeys("06/01/2022");
		    Thread.sleep(2000);
			run.click();
			Thread.sleep(3000);
			exportToExcel.click();
			Thread.sleep(3000);
			
			//Alert alert = driver.switchTo().alert();
			
			//alert.accept();
			//Thread.sleep(3000);
		}
/*************************************************************/	
		
/***********   Fleet standard Carmax   **************************************************/
		
		public void clickOnFleetStandardCarmax() throws InterruptedException {
			fleetStandard.click();
			Thread.sleep(100);
			fleetStandardCarmax.click();
					}
			
		public boolean verifyFleetStandardCarmaxReportPageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("CarMax Fleet Standard Report Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verifyclickOnFleetStandardCarmax() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOnFleetStandardCarmax();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Fleet_Standard_Report_Carmax_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/	
		
/***********  OpenVsClosed Carmax   **************************************************/
		
		public void clickOnOpenVsClosedCarmax() throws InterruptedException {
			OpenVsClosed.click();
			Thread.sleep(100);
			OpenVsClosedCarmax.click();
		}
			
		public boolean verifyOpenVsClosedCarmaxReportPageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("CarMax Open vs Closed Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verifyclickOnOpenVsClosedCarmax() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOnOpenVsClosedCarmax();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_OpenVsClosed_Report_Carmax_PageTitle(){
			return driver.getTitle();
		}
/*************************************************************/	
		
/***********  Claim Activity Carmax   **************************************************/
		
		public void clickOnClaimActivityCarmax() throws InterruptedException {
			claimActivity.click();
			Thread.sleep(100);
			claimActivityCarmax.click();
		}
			
		public boolean verifyClaimActivityCarmaxReportPageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("Claims Activity Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verifyclickOnClaimActivityCarmax() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOnClaimActivityCarmax();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_ClaimActivity_Report_Carmax_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/	
		
/***********  Claim Performance Carmax   **************************************************/
		
		public void clickOn_Claim_Performance_Carmax() throws InterruptedException {
			claimPerformance.click();
			Thread.sleep(100);
			claimPerformanceCarmax.click();
		}
			
		public boolean verify_Claim_Performance_Carmax_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("CarMax Claim Performance Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_Claim_Performance_Carmax() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_Claim_Performance_Carmax();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Claim_Performance_Report_Carmax_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/	
		
/***********  Fleet Billing Report- Fleet Billing ********************************************/
		
		public void clickOn_Fleet_Billing() throws InterruptedException {
			fleetBillingMainMenu.click();
			Thread.sleep(100);
			fleetBilling.click();
		}
			
		public boolean verify_Fleet_Billing_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("Fleet Billing Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_Fleet_Billing() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_Fleet_Billing();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Fleet_Billing_Report_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/	
		
/***********  Fleet Billing Open Vs Close Report- Fleet Billing ********************************************/
		
		public void clickOn_Fleet_Billing_OpenVsClose() throws InterruptedException {
			fleetBillingMainMenu.click();
			Thread.sleep(100);
			fleetBillingOpenvsClose.click();
		}
			
		public boolean verify_Fleet_Billing_OpenVsClose_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("Fleet Billing Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_Fleet_Billing_OpenVsClose() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_Fleet_Billing_OpenVsClose();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Fleet_Billing_OpenVsClose_Report_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/	
		
/***********  Meineke Central Billing Report ********************************************/
		
		public void clickOn_MCB_Report() throws InterruptedException {
			MCB.click();
			Thread.sleep(100);
				}
			
		public boolean verify_MCB_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("Meineke CentralBilling Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_MCB_Report() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_MCB_Report();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_MCB_Report_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/		
		
/***********  Unifirst Report ********************************************/
		
		public void clickOn_Unifirst_Report() throws InterruptedException {
			unifirst.click();
			Thread.sleep(100);
				}
			
		public boolean verify_Unifirst_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("UniFirst Report Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_Unifirst_Report() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_Unifirst_Report();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Unifirst_Report_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/		
		
/***********  Amazon Report ********************************************/
		
		public void clickOn_Amazon_Report() throws InterruptedException {
			amazonReport.click();
			Thread.sleep(100);
				}
			
		public boolean verify_Amazon_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("Amazon Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_Amazon_Report() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_Amazon_Report();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Amazon_Report_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/		
/***********  Hertz_Billing Report ********************************************/
		
		public void clickOn_Hertz_Billing_Report() throws InterruptedException {
			hertzBilling.click();
			Thread.sleep(100);
				}
			
		public boolean verify_Hertz_Billing_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("Hertz Billing Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_Hertz_Billing_Report() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_Hertz_Billing_Report();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Hertz_Billing_Report_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/	
/***********  Statement_Billing Report ********************************************/
		
		public void clickOn_Statement_Billing_Report() throws InterruptedException {
			statementBilling.click();
			Thread.sleep(100);
				}
			
		public boolean verify_Statement_Billing_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("Statement/Billing Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_Statement_Billing_Report() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_Statement_Billing_Report();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Statement_Billing_Report_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/	
/***********  Open_Claims Report ********************************************/
		
		public void clickOn_Open_Claims_Report() throws InterruptedException {
			openClaims.click();
			Thread.sleep(100);
				}
			
		public boolean verify_Open_Claims_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals(" Open Claims Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_Open_Claims_Report() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_Open_Claims_Report();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Open_Claims_Report_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/	
/***********  Preffered_Location Report ********************************************/
		
		public void clickOn_Preferred_Location_Report() throws InterruptedException {
			preferredLocation.click();
			Thread.sleep(100);
				}
			
		public boolean verify_Preferred_Location_Report_PageLoaded(){
			
		String reportname = reportName.getText();
		System.out.println("Report Name :" +reportName.getText());
		
		if (reportname.equals("Preferred Location Filters")) {
			return true;
		}
		else {
			return false;
		}
		}
				
		public ReportsPage verify_clickOn_Preferred_Location_Report() throws InterruptedException{
			clickOnReportsMenu();
			
			Thread.sleep(1000);
			clickOn_Preferred_Location_Report();
			Thread.sleep(2000);
			return new ReportsPage();
		}
		public String verify_Preferred_Location_Report_PageTitle(){
			return driver.getTitle();
		}
		/*************************************************************/	

}
