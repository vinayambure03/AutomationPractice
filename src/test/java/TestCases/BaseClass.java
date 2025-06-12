package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjectModel.CreateAccount;
import UtilityClass.ExtentReportClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver; 
	CreateAccount createAcc;
	ExtentTest test;
	ExtentReports extent;
	ExtentReportClass  erc;
	
	public WebDriver initializerDriver() throws Exception
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Global.proporties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			 erc= new ExtentReportClass();
			 erc.extentReportConfig();
			 extent = erc.extent; // <-- Fix: Assign erc.extent to local extent
			 test =extent.createTest("Login Test");
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		}else {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonData(String path) throws IOException
	{
	// Convert json file into string	
		String jsonFile = FileUtils.readFileToString(new File(path), "UTF-8");
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(jsonFile, new TypeReference<List<HashMap<String, String>>>(){});
		
	}
	
	
	
	@BeforeTest
	public CreateAccount signInApp() throws Exception
	{
		driver = initializerDriver();
		createAcc =  new CreateAccount(driver);
		createAcc.goToUrl();
		return createAcc;
	}
	
	@AfterTest
	public void tearDown() throws Exception
	{
		if (driver != null) {
	        driver.close();
	    }
	    if (extent != null) {
	        extent.flush();
	    }
	}
}
