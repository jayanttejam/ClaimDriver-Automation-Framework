package vertex.CD.util;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import vertex.CD.base.TestBase;
import vertex.CD.base.TestBaseNew;
import vertex.CD.driver.DriverManager;

public class TestUtil extends TestBaseNew {
	
	public static int Page_load_timeout = 30;
	public static long Implicit_wait = 10;
	//public static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public static void captureScreen(String tname) throws IOException
	{
		WebDriver driver = DriverManager.getDriver();
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = today.format(formatter);
        System.out.println(formattedDate);
				
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname+"-" + formattedDate +"-" + System.currentTimeMillis() +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot captured");
	}
	
	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
		
	}
	
	public static void selectDate1(String Day, String Month, String Year) throws InterruptedException {
		WebDriver driver = DriverManager.getDriver();
		Calendar calendar = Calendar.getInstance();
		int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
		int targetMonth = calendar.get(Calendar.MONTH);
		int targetYear = calendar.get(Calendar.YEAR);
		
		System.out.println(targetDay);
		System.out.println(targetMonth);
		System.out.println(targetYear);
		
		driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']")).click();
		Thread.sleep(4000);
	
		//String monthYearVal = driver.findElement(By.xpath("//a[contains(text(),'August 2022')]")).getText();
		String monthYearVal = driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
		
		System.out.println("after datepicker click");
		System.out.println(monthYearVal);
		
		while (!(getMonthYear(monthYearVal)[0].equals(Month) && getMonthYear(monthYearVal)[1].equals(Year)))
		{
			System.out.println("In While loop");

			driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-right']")).click();
			//driver.findElement(By.xpath("//a[@class='k-link k-nav-next']")).click();
			Thread.sleep(3000);
			System.out.println("after next button click");
			monthYearVal = driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
			
		}
		
		while (!(getMonthYear(monthYearVal)[0].equals(Month) && getMonthYear(monthYearVal)[1].equals(Year)))
		{
			System.out.println("In While loop");

			driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-right']")).click();
			//driver.findElement(By.xpath("//a[@class='k-link k-nav-next']")).click();
			Thread.sleep(3000);
			System.out.println("after next button click");
			monthYearVal = driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
			
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='"+Day+"']")).click();
		//a[normalize-space()='16']
		
	}
	
	
	public static void selectDate2(WebDriver driver,String targetDate, String dateFormat) throws Exception {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat targetDateFormat = new SimpleDateFormat(dateFormat);
		Date formattedTargetDate;
		try {
			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(targetDate);
			calendar.setTime(formattedTargetDate);

			int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
			int targetMonth = calendar.get(Calendar.MONTH);
			int targetYear = calendar.get(Calendar.YEAR);
			
			System.out.println(targetDay);
			System.out.println(targetMonth);
			System.out.println(targetYear);
			
			driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']")).click();
			Thread.sleep(4000);

			String actualDate = driver.findElement(By.className("//a[@class='k-link k-nav-fast']")).getText(); 
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

			int actualMonth = calendar.get(Calendar.MONTH);
			int actualYear = calendar.get(Calendar.YEAR);

			while(targetMonth < actualMonth || targetYear < actualYear) {
				driver.findElement(By.className("k-icon k-i-arrow-60-left")).click();
				actualDate = driver.findElement(By.className("//a[@class='k-link k-nav-fast']")).getText(); 
				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			while(targetMonth > actualMonth || targetYear > actualYear) {
				driver.findElement(By.className("//span[@class='k-icon k-i-arrow-60-right']")).click();
				actualDate = driver.findElement(By.className("//a[@class='k-link k-nav-fast']")).getText(); 
				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			driver.findElement(By.xpath("//a[normalize-space()='"+targetDay+"]")).click();

		} catch (ParseException e) {
			throw new Exception("Invalid date is provided, please check input date");
		}
	}
	
	
	public static void selectDate(WebDriver driver, String date) throws Exception {
		System.out.println("In selectDate method");
		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			targetDateFormat.setLenient(false);
			Date formattedTargetDate = targetDateFormat.parse(date);
			calendar.setTime(formattedTargetDate);
		} catch (Exception e) {
			throw new Exception("Invalid date is provided, please check the input date!!");
		}
		
		driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']")).click();
		Thread.sleep(2000);
		
		int targetMonth = calendar.get(Calendar.MONTH);
		int targetYear = calendar.get(Calendar.YEAR);
		int targetDay = calendar.get(Calendar.DAY_OF_MONTH);

		String currentDate = driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
		System.out.println("current date is" +currentDate);
		calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);

		while(currentMonth < targetMonth || currentYear < targetYear) {
			driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-right']")).click();
			Thread.sleep(2000);
			currentDate = driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
		}

		while(currentMonth > targetMonth || currentYear > targetYear) {
			driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-left']")).click();
			Thread.sleep(2000);
			currentDate = driver.findElement(By.xpath("//a[@class='k-link k-nav-fast']")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentDate));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
		}

		if(currentMonth == targetMonth && currentYear == targetYear)
			//driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()="+targetDay+"]")).click();
		   // driver.findElement(By.xpath("//a[@title='Tuesday, July "+targetDay+", 2022']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='"+targetDay+"']")).click();		
		
		else
			throw new Exception("unable to select the date because of current and target dates mismatch");
	}
	
	
	
	
}
