package base;

	import java.io.FileInputStream;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {

	   // public WebDriver driver;
		private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

	    public Properties prop;

	    public BaseClass() {

	        try {

	            prop = new Properties();

	            FileInputStream fis =new FileInputStream("src/test/resources/config/config.properties");

	            prop.load(fis);

	        }

	        catch(Exception e) {

	            e.printStackTrace();
	        }
	    }
		public static WebDriver getDriver()
		{
			if(driver.get()==null)
			{
				System.out.println("webdriver is not initialized");
				throw new IllegalStateException("webdriver is not initialized");
			}
			return driver.get();
			
		}

	    public WebDriver initDriver(String browser) 
	    {
// **Base Class me add kiya
//	        WebDriverManager.chromedriver().setup();
//
//	        driver = new ChromeDriver();
	    	//*ye niche wala iss liye coment kiya kyuki mai browser ab testNg se le raha hu
	    	//String browse=prop.getProperty("browser");
	    	//driver=DriverFactory.initDriver(browser);
	    	driver.set(DriverFactory.initDriver(browser));
            
//wraper method create keli so    //driver.get().manage().window().maximize();
	    	
            getDriver().manage().window().maximize();
	        getDriver().get(prop.getProperty("url"));
			//return driver.get();
	        return getDriver();
	    }

	    public void tearDown() {
	    
	    	getDriver().quit();
	    	driver.remove();

	        //driver.quit();
	    }
	}

/*
 * imp Note
 * जब भी Framework Design सीखो:

पहले पूछो:

Is code repeated?

अगर हाँ →

Utility
Base Class
Factory

में move करो।

यही framework design का मूल concept है।
	*/