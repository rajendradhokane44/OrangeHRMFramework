package tests;
//1)LoginTest->setup()method->Chrome Open->OrangeHRM Open->LoginPage->Username Enter->Password Enter->Login Click->HomePage->Dashboard Check->Pass->tearDown()
//2)LoginTest->BaseClass Constructor->config.properties Read->URL Loaded->Username Loaded->Password Loaded->Browser Open->Login
//3)@BeforeMethod->setup()->Chrome Open->OrangeHRM Open->@Test->Login->Dashboard Validation->@AfterMethod->tearDown()->Browser Close
//4)LoginPage->ActionUtil->findElement->click/sendKeys
//5)LoginTest->LoginPage->WaitUtil->Element Visible->ActionUtil->SendKeys->Click
//6)LoginTest->new LoginPage(driver)->Constructor->PageFactory.initElements()->@FindBy Elements Initialize->login()->sendKeys()->click()
//7)Run LoginTest->BaseTest.startBrowser()->setup()->Browser Open->Login Test Execute->BaseTest.closeBrowser()->Browser Close
//8)config.properties->browser=chrome->BaseClass->DriverFactory->ChromeDriver->Return Driver->BaseClass->Open URL
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.DataProviderUtil;

public class LoginTest extends BaseTest
{
	/*Remove now this duplication after extend BaseTest Class
	@BeforeMethod
	public void startBrowser()
	{
		setup();
	}*/
	
	
	@Test
	public void verifyLogin()
	{
		
		LoginPage lp=new LoginPage(getDriver());
		
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
		
		HomePage hp=new HomePage(getDriver());
		
		Assert.assertTrue(hp.isDashboardDisplayed());
		System.out.println(Thread.currentThread().getId());
		
	}
	/*Remove now this duplication after extend BaseTest Class
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
	*/
	
/* This code is available DataProviderUtil.java
  public class LoginTest extends BaseTest
{
LoginPage lp;
@Test(dataProvider = "loginData", dataProviderClass =  DataProviderUtil.class)
	public void verifyLogin(String username, String password)
	{
		lp.login(username, password);
	}
}
 */
}
