package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utils.ActionUtil;
import utils.WaitUtil;

public class LoginPage extends BasePage
{
//	WebDriver driver;
//	ActionUtil action;
//	WaitUtil wait;
	
	//create one constructor same as class name
	
	public LoginPage(WebDriver driver)
	{
		//Note:- Parent class (BasePage)ka constructor call karo
		super(driver);
		PageFactory.initElements(driver, this); //kisi browser me element findOut karne keliye
//		//driver=this.driver;
//		this.driver=driver;
//		
//		action=new ActionUtil(driver);
//		wait=new WaitUtil(driver);
	}
	
//here use withought page factory POM Consept
	//By username= By.name("username");
	
//here use with page factory POM Consept
	@FindBy(name="username") WebElement username;
	
	//By password=By.name("password");
	@FindBy(name="password") WebElement password;
	
	By LoginBtn=By.xpath("//button[@type='submit']");
	@FindBy(xpath = "//button[@type='submit']") WebElement loginBtn;
	
	//here create one "login" method to perform action on elements
	public void login(String user, String pass)
	{
	/*   //driver.findElement(username).sendKeys(user);
		
		//driver.findElement(password).sendKeys(pass);
		
		//driver.findElement(LoginBtn).click();*/
		//use wait********
		wait.waitForElemeny(username);
		username.sendKeys(user);
		//action.type(username, user);
		//action.type(password, pass);
		password.sendKeys(pass);
		//action.click(LoginBtn);
		loginBtn.click();
	}
//Note: Jab bhi hum POM With pageFactory use karenge tab tab hame "PageFactory.initElement()"
	//Constructor me add arna honga

}
