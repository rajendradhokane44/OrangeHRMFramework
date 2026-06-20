package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionUtil 
{
	WebDriver driver;
	
	//Create constructor
	
	public ActionUtil(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//now create method for click, type etc
	
	public void click(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void type(By locator, String value)
	{
		driver.findElement(locator).sendKeys(value);
	}

}
