package TestCases;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.CreateAccount;
import PageObjectModel.LogInPage;




public class Test_LogInPage extends BaseClass  {
	
	LogInPage logInPage;
	
	@Test(dataProvider = "getLogInData")
	public void userLogInPage(HashMap<String, String> input) throws Exception 
	{
		initializerDriver();
		logInPage = new LogInPage(driver);
		logInPage.goToUrl();
		logInPage.userLogIn(input.get("emailId"), input.get("password"));
		tearDown();
		
	}
	
	@DataProvider
	public Object[][] getLogInData() throws IOException
	{
		List<HashMap<String, String>>data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\LogIn.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}, {data.get(3)}};
	}
}
