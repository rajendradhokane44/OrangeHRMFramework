package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil 
{
	WebDriver driver;
	
	//create one constructor
	public WaitUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//create method for wait
	public void waitForElemeny(WebElement username)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated( (By) username));
	}

}
