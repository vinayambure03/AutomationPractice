package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.CreateAccount;
import UtilityClass.ExtentReportClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_CreateAccount extends BaseClass{
//	String userName = "V012";
//	String userEmailId = "V012@gmail.com";
//	String password = "V@123";
//	String signOptionText = "Sign up for our newsletter!";
//	String offerLetterText = "Receive special offers from our partners!";
	
	
	@Test(dataProvider = "getData")
	public void createMyAcc(HashMap<String, String> input) throws Exception {
	
	SoftAssert ass = new SoftAssert(); 
	signInApp();
	createAcc.signInApp(input.get("userName"), input.get("userEmailId") );
	createAcc.selectRadioBtn();
	String name = createAcc.verifyName();
	ass.assertEquals(name, input.get("userName"));
	String emailId = createAcc.verifyEmailId();
	ass.assertEquals(emailId, input.get("userEmailId"));
	int iday = Integer.parseInt(input.get("day"));
	int imonth = Integer.parseInt(input.get("month"));
	createAcc.enterAccountInfo(input.get("password"), iday , imonth, input.get("data"));
	String optionText = createAcc.getOptiontext();
	ass.assertEquals(optionText, input.get("signOptionText"));
	String offerText = createAcc.getSpecialOfferText();
	ass.assertEquals(offerText, input.get("offerLetterText"));
	
	createAcc.enterAddressInfo(input.get("firstName"), input.get("lastName"),
	input.get("companyName"), input.get("addName1"), input.get("addName2"), 
	input.get("data1"), input.get("stateName"), input.get("cityName"), 
	input.get("zipCode"), input.get("mobileNo"));
	ass.fail(); 
	tearDown();
	
}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\CreateAccData.json");
		return new Object[][] {{data.get(0)}};
	}

	
	
}