package AbstractMethods;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {

	WebDriver driver;
	
	public AbstractClass(WebDriver driver) 
	{

		this.driver = driver;
	}

	public void waitTillElementAppear(By ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	
	}

	
	public void selectByVisibleText(WebElement ele, int value) {
		
		Select select = new Select(ele);
		select.selectByIndex(value); 
		
	}
	
public void selectByVisibleText(WebElement ele, String data) {
		
		Select select = new Select(ele);
		select.selectByVisibleText(data);
		
	}

 public void scrollToPage(int ScrollTo) {
	 
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("window.scrollBy(0, "+ScrollTo+");");
 }
 
 public void scrollToSpecifiElement(WebElement element)
 {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", element);
 }
 
 
 public static void captureScreenshot(WebDriver driver, String path) throws IOException {
     // Capture screenshot
     File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

     // Save screenshot to specified path
     FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"\\ScreenShots\\"+path+".png"));
 }
}
