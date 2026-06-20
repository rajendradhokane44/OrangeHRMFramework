package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
	private static ExtentReports extent;
	
	//create method for various operation on report
	public static ExtentReports getInstance()
	{
		if(extent == null) 
		{
			ExtentSparkReporter reporter=new ExtentSparkReporter("C:/Automation/myworkspases/SeleniumWebDriver/OrangeHRM/reports/ExtentReport.html");
			
			extent=new ExtentReports();
			
			extent.attachReporter(reporter);
		}

		return extent;
		
	}

}
