package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest extends BaseClass
{
	 @BeforeMethod
	 @Parameters("browser")
	    public void startBrowser(String browser) {

	       // setup();
		 initDriver(browser);
	    }

	    @AfterMethod
	    public void closeBrowser() 
	    {

	        tearDown();

        }
}


//Consider lots of Test Class
//to hare test class me after() and before() use karna padenga
//usse acca use centralize kare is "BaseTest" class me then extend karo
//1) time(LoginTest)
/*@BeforeMethod
public void startBrowser() {
    setup();
}

@AfterMethod
public void closeBrowser() {
    tearDown();
}

//2) time (HomeTest)
 @BeforeMethod
public void startBrowser() {
    setup();
}

@AfterMethod
public void closeBrowser() {
    tearDown();
}
//3)LogOutTest
ETC If 50 test classes then use 50 times this
Solution:-Repeated code should be centralized.
**Solution = BaseTest**

*BaseClass
    ↑
BaseTest
    ↑
LoginTest
 */