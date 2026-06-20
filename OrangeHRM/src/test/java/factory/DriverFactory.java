package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public static WebDriver initDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().browserVersion("148").setup();
			ChromeOptions options=new ChromeOptions();
			options.setBinary("C:\\Users\\Lenovo\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			return new ChromeDriver(options);
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {

		    WebDriverManager.firefoxdriver().setup();

		    return new FirefoxDriver();
		}
		else {

		    throw new RuntimeException("Browser not supported");
		}
		//return null;
		
	}
	

}
