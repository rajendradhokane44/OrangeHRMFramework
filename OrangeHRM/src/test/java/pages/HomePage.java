package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class HomePage extends BasePage
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	//now use Pom
	By dashboardText=By.xpath("//h6[text()='Dashboard']");
	
	
	//Now create one method to "verify dasboard is displayed or not" ook
	public boolean isDashboardDisplayed()
	{
		
		try {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
			return driver.findElement(dashboardText).isDisplayed();
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
			
		}
		

	}

}
//Note
/*
Real Issue

Invalid Login में:

homePage.isDashboardDisplayed()

NoSuchElementException दे सकता है।

Company Solution

HomePage में Safe Method बनाते हैं।

public boolean isDashboardDisplayed()
{
    try
    {
        return dashboard.isDisplayed();
    }
    catch(Exception e)
    {
        return false;
    }
}

अब:

Dashboard मिला
      ↓
true

Dashboard नहीं मिला
      ↓
false
*/