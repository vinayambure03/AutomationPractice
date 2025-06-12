package UtilityClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportClass {

	public ExtentReports extent;
	
	public void extentReportConfig()
	{
		
		String path = System.getProperty("user.dir")+"\\reportTest\\index.html";
		ExtentSparkReporter reporter = new  ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Testing");
		reporter.config().setDocumentTitle("Project");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vinayak Ambure");
	}
}
