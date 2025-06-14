package PageObjectModel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractMethods.AbstractClass;

public class CreateAccount extends AbstractClass {

	WebDriver driver;
	
	public CreateAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "a[href='/login']")
	WebElement logInSignInEle;
	@FindBy(name = "name")
	WebElement nameEle;
	By nameWait = By.name("name");
	@FindBy(css = "input[data-qa='signup-email']")
	WebElement emailIDEle;
	@FindBy(css = "button[data-qa='signup-button']")
	WebElement signInEle;
	@FindBy(css = "div[class='radio'] input[id='id_gender1']")
	WebElement titleMREle;
	By radioBtn = By.cssSelector("div[class='radio'] input[id='id_gender1']");
	@FindBy(css = "input[data-qa='email']")
	WebElement emailIDfield;
	@FindBy(id = "password")
	WebElement passWordEle;
	@FindBy(id = "days")
	WebElement dayEle;
	@FindBy(id = "months")
	WebElement monthEle;
	@FindBy(id = "years")
	WebElement yearEle;
	@FindBy(css = "#newsletter")
	WebElement signCheckBoxEle;
	@FindBy(css = "label[for='newsletter']")
	WebElement signCheckBoxText;
	@FindBy(css = "#optin")
	WebElement specialOfferEle;
	@FindBy(css = "label[for='optin']")
	WebElement specialOfferText;

// ADDRESS INFORMATION Elements
	
	@FindBy(css = "#first_name")
	WebElement firstNameEle;
	@FindBy(css = "#last_name")
	WebElement lastNameEle; 
	@FindBy(css = "#company")
	WebElement companyEle;
	@FindBy(css = "#address1")
	WebElement address1Ele;
	@FindBy(css = "#address2")
	WebElement address2Ele;
	@FindBy(xpath = "//select[@id='country']")
	WebElement countryEle;
	@FindBy(css = "#state")
	WebElement stateEle;
	@FindBy(css = "#city")
	WebElement cityEle;
	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipCodeEle;
	@FindBy(xpath = "//input[@id='mobile_number']")
	WebElement mobileNoEle;
	@FindBy(css = "button[data-qa='create-account']")
	WebElement createAccEle;
	@FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
	WebElement congratulationsEle;
	

	public void goToUrl() 
	{
		driver.get("https:automationexercise.com"); 
		logInSignInEle.click();
	}

	public void signInApp(String name, String emailId) 
	{
		
		nameEle.clear();
		nameEle.sendKeys(name);
		emailIDEle.clear();
		emailIDEle.sendKeys(emailId);
		signInEle.click();
	}
	
	public void selectRadioBtn() {
		//driver.switchTo().frame("csrfmiddlewaretoken");
		waitTillElementAppear(radioBtn);
		titleMREle.click();
	}
	
	public String verifyName() 
	{
	String name =nameEle.getText();
	 return name;
	}
	
	public String verifyEmailId() 
	{
	String emailId =emailIDfield.getText();
	return emailId;
	}

	public void enterAccountInfo(String psw, int day, int month, String data) throws InterruptedException 
	{
		 
		passWordEle.sendKeys(psw);
		dayEle.click();
		scrollToPage(500);
		Thread.sleep(2000); 
		selectByVisibleText(dayEle, day );
		Thread.sleep(2000);
		monthEle.click();
		Thread.sleep(2000);
		selectByVisibleText(monthEle, month);
		yearEle.click();
		Thread.sleep(2000);
		selectByVisibleText(yearEle, data);
			
	}
	
	public String getOptiontext() {
		
		signCheckBoxEle.click();
		 String signBoxText =signCheckBoxText.getText();
		 return signBoxText;
		 
	}
	
	public String getSpecialOfferText() {
		
		specialOfferEle.click();
		 String specialOffText =specialOfferText.getText();
		 return specialOffText;
		 
	}
	
	
	public LogInPage  enterAddressInfo(String firstName, String lastName, 
	String companyName, String addName1, String addName2, 
	String data1, String stateName, String cityName,
	String zipCode, String mobileNo) throws InterruptedException, IOException
	
	{
		Thread.sleep(2000);
		firstNameEle.clear();
		firstNameEle.sendKeys(firstName);
		
		lastNameEle.clear();
		lastNameEle.sendKeys(lastName);
		
		companyEle.clear();
		companyEle.sendKeys(companyName);
		
		address1Ele.clear();
		address1Ele.sendKeys(addName1);
		
		//scrollToPage(1100);
		
		//Thread.sleep(2000);
		address2Ele.clear();
		address2Ele.sendKeys(addName2);
		
		countryEle.click();
		Thread.sleep(2000);
		selectByVisibleText(countryEle, data1);
		
		stateEle.clear();
		stateEle.sendKeys(stateName);
		
		cityEle.clear();
		cityEle.sendKeys(cityName);
		
		scrollToSpecifiElement(zipCodeEle);
		Thread.sleep(2000);
		zipCodeEle.clear();
		zipCodeEle.sendKeys(zipCode);
		
		mobileNoEle.clear();
		mobileNoEle.sendKeys(mobileNo);
		
		createAccEle.click();
		
		Thread.sleep(2000);
		captureScreenshot(driver,"Congratulations");
		String congratulations = congratulationsEle.getText();
		System.out.println(congratulations);
		
		return new LogInPage(driver);
		
	}
	
}
