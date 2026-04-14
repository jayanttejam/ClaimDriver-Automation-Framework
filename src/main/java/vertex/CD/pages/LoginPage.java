package vertex.CD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vertex.CD.base.TestBase;
import vertex.CD.base.TestBaseNew;
import vertex.CD.driver.DriverManager;

public class LoginPage extends TestBaseNew{
	
	//Page factory - OR
	@FindBy(id="Email")
	WebElement username;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//li[contains(text(),'Bad Username/Password.')]")
	WebElement BadUNPWD;
	
	WebDriver driver = DriverManager.getDriver();
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public  boolean LoginTest()
	{
		try {
		return BadUNPWD.isDisplayed();
		}
		catch (Exception e){
			System.out.println("Login Successful");
		}
		return false;
	}
	
	public  boolean LoginTest1()
	{
		
		if (BadUNPWD.isDisplayed()== true)
		{
			return true;
		}
		else {
		return false;
		}
	}
	
	public HomePage login (String un, String pwd)
	{
	    username.sendKeys(un);
	    password.sendKeys(pwd);
	    loginBtn.click();
	    
	    return new HomePage();
	    
	}

}
