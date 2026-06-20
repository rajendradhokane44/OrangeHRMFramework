//IMP Note
/*Problem समझो

आज सिर्फ 2 Pages हैं:

LoginPage
HomePage

लेकिन real project में:

LoginPage
HomePage
AdminPage
PIMPage
LeavePage
RecruitmentPage
MyInfoPage
DashboardPage
PerformancePage
BuzzPage

20-50 Pages होना common है।

हर Page में ये लिखना पड़ेगा
WebDriver driver;

ActionUtil action;

WaitUtil wait;

और constructor भी:

public LoginPage(WebDriver driver) {

    this.driver = driver;

    action = new ActionUtil(driver);

    wait = new WaitUtil(driver);
}

अगर 30 pages हैं तो?

👉 30 बार same code

❌ Problems
Code Duplication

Same code बार-बार

Maintenance Problem

अगर कल:

JavascriptUtil js;

add करना है।

तो 30 pages में add करना पड़ेगा।

Company Rule

Repeated code को centralize करो.

🎯 Solution = BasePage

हम common code एक parent class में रखेंगे।

STEP 1: Create BasePage.java

Package:

base

BasePage
   │
   ├── driver
   ├── action
   └── wait
          ▲
          │
    ┌─────┴─────┐
    │           │
LoginPage   HomePage
*/

package base;

import org.openqa.selenium.WebDriver;

import utils.ActionUtil;
import utils.WaitUtil;

public class BasePage 
{
	//NOTE:-protected WebDriver driver;likhonge to। child classes access kar sakta hai।
	//Note:Private agar kiya to login page access nahi kar payenga
	protected WebDriver driver;

	protected ActionUtil action;

	protected WaitUtil wait;
	
	//Now constructor
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		
		action=new ActionUtil(driver);
		
		wait=new WaitUtil(driver);
	}

}

