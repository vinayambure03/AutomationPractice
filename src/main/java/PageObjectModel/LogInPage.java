package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractMethods.AbstractClass;

public class LogInPage extends AbstractClass{

	WebDriver driver;
	public LogInPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[data-qa='login-email']") 
	WebElement emailAddressEle;
	By emailIdAppear = By.cssSelector("input[data-qa='login-email']");
	@FindBy(css = "input[data-qa='login-password']") 
	WebElement passwordEle;
	@FindBy(css = "button[data-qa='login-button']") 
	WebElement logInEle;
	
	
	
	
	
	public void userLogIn(String emailId, String password)
	{
		waitTillElementAppear(emailIdAppear);
		emailAddressEle.clear();
		emailAddressEle.sendKeys();
		
		passwordEle.clear();
		passwordEle.sendKeys();
		
		logInEle.click();
	}
	
	
}
