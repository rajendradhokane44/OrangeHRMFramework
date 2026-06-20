package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener
{
	ExtentReports extent= ExtentManager.getInstance();
	
	ExtentTest test;//it is the class of "Extent Reports Library"
	//using this test-> test.pass, test.fail,test.info etc
	@Override
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.pass("Test Pass");
	}
	
	
	@Override
	public void onTestFailure(ITestResult result)//ITestResult gives the Current test info 
	{
	String path=ScreenshotUtil.takeScreenshot(BaseClass.getDriver(), result.getName());
	
	try {
		test.addScreenCaptureFromPath(path);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
//Actual Flow
/*
 Test Start
    ↓
onTestStart()
    ↓
Test Fail
    ↓
onTestFailure()
    ↓
Screenshot
    ↓
Attach Screenshot
    ↓
onFinish()
    ↓
extent.flush()
    ↓
ExtentReport.html
	 */
}
