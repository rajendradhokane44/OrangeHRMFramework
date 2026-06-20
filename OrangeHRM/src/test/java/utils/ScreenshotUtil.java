package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ScreenshotUtil 
{
	public static String takeScreenshot(WebDriver driver, String testName)
	{
		try {
			File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path= "screenshots/"+ testName+ ".png";
			
			File dist=new File(path);
			
			FileUtils.copyFile(src, dist);
			return path;
		} 
		catch (WebDriverException | IOException e) {

			e.printStackTrace();
		}
		return null;
	}
}
	/*
       Fail
       ↓
       Screenshot
       ↓
       PNG File
       ↓
       screenshots folder	
	 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		try {
//			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			
//			String path="screenshots/"+ testName+ ".png";
//			File destination=new File(path);
//			
//			FileUtils.copyFile(source, destination);
//			return path;
//		} 
//		catch (WebDriverException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}	
		
//	}	
//
//}
