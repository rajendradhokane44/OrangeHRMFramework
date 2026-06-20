package utils;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class DataProviderUtil 
{
	LoginPage lp;
	//this type of dataProvider() use for small projects
	@DataProvider(name="loginData")
	public Object[][] loginData() throws IOException {

	   /* return new Object[][] {
	        {"Admin","admin123"},
	        {"Admin","wrong123"}
	    };*/
		
		return ExcelUtil.getLoginData();
	}
	
	/*@Test(dataProvider="loginData")
	public void verifyLogin(String user,String pass)
	{
		
	}*/
	
	@Test(dataProvider = "loginData", dataProviderClass =  DataProviderUtil.class, retryAnalyzer = retry.RetryAnalyzer.class)
	public void verifyLogin(String username, String password, String expectedResult)
	{
		LoginPage lp=new LoginPage(BaseClass.getDriver());
		lp.login(username, password);
		HomePage hp=new HomePage(BaseClass.getDriver());
	//OR	//boolean actualResult =hp.isDashboardDisplayed();
		if(expectedResult.equalsIgnoreCase("PASS"))
		{
			Assert.assertTrue(hp.isDashboardDisplayed());
			//OR
		     //Assert.assertTrue(actualResult);
		}
		else
		{
		     Assert.assertFalse(hp.isDashboardDisplayed());
		     //OR
		     //Assert.assertTrue(actualResult);
		}
	}
	
	//Note
	/*
	 * अगर DataProvider उसी class में है:

@Test(dataProvider="loginData")

चल जाएगा।

लेकिन अगर DataProvider अलग class में है:

DataProviderUtil.java

तो:

@Test(
 dataProvider="loginData",
 dataProviderClass=DataProviderUtil.class
)

लिखना पड़ेगा।
	 */
}
