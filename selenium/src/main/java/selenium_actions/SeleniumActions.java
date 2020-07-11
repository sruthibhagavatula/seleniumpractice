package selenium_actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SeleniumActions {

	RemoteWebDriver driver;
	public void invokeBrowser(String browser) throws InterruptedException
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			Thread.sleep(5000);
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		else
		{
			System.out.println("invalid browser type");
		}
	}
	
	public void openGoogle(String url) {
		 System.out.println("url" +url+" is invoked");
		 driver.manage().window().maximize();
		 driver.get(url);
		}
	public void closeBrowser() {
		driver.close();
	}

		public void signIn() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[text()[contains(.,'Sign in')]]").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//span[text()[contains(.,'Create account')]]").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//div[text()[contains(.,'For myself')]]").click();
		Thread.sleep(5000);
		driver.findElementById("firstName").sendKeys("sruthi");
		driver.findElementById("lastName").sendKeys("bhagavatula");
		driver.findElementById("username").sendKeys("sruthibhagavatular29");
		driver.findElementByName("Passwd").sendKeys("Asdf@1234");
		driver.findElementByName("ConfirmPasswd").sendKeys("Asdf@1234");
		//driver.findElementByXPath("//span[text()[contains(.,'Next')]]").click();
		driver.findElementByXPath("//div[text()[contains(.,'Sign in instead')]]").click();
		Thread.sleep(3000);
		driver.findElementById("identifierId").sendKeys("sruthir91@gmail.com");
		driver.findElementByXPath("//span[text()[contains(.,'Next')]]").click();
		
		
		
	}
}