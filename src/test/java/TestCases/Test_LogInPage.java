package TestCases;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class Test_LogInPage extends BaseClass  {

	
	@Test(dataProvider = "getLogInData")
	public void userLogInPage(HashMap<String, String> put) throws Exception 
	{
		signInApp();
		logInPage.userLogIn(put.get("V017"), put.get("V017@gmail.com"));
		tearDown();
		
	}
	
	@DataProvider
	public Object[][] getLogInData() throws IOException
	{
		List<HashMap<String, String>>data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\LogIn.json");
		return new Object[][] {{data.get(0)}};
	}
}
