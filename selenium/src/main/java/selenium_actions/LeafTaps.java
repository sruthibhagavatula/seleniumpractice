package selenium_actions;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class LeafTaps {

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
	
	public void openLeafTaps(String url) {
		 System.out.println("url" +url+" is invoked");
		 driver.manage().window().maximize();
		 driver.get(url);
		}
	public void leafTapsScenario() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoCSR");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		String title = driver.findElementByXPath("//h2[text()[contains(.,'Welcome ')]]").getText();
		System.out.println(title);
		driver.findElementByXPath("//a[text()[contains(.,'CRM/SFA')]]").click();
		String homepagetitle = driver.findElementByXPath("//div[text()[contains(.,'My Home')]]").getText();
		System.out.println(homepagetitle);
		
		  driver.findElementByXPath("//a[text()[contains(.,'Create Lead')]]").click();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.findElementById("createLeadForm_companyName").sendKeys("Testa1120");
		  driver.findElementById("createLeadForm_firstName").sendKeys("Testa1120");
		  driver.findElementById("createLeadForm_lastName").sendKeys("Testa1120");
		  driver.findElementByName("submitButton").click(); 
		  String viewlead=  driver.findElementByXPath("//div[text()[contains(.,'View Lead')]]").getText() ;
		  System.out.println(viewlead);
		  driver.findElementByLinkText("Create Lead").click();
		  driver.findElementById("createLeadForm_companyName").sendKeys("Testb11720");
		  driver.findElementById("createLeadForm_firstName").sendKeys("Testb11720");
		  driver.findElementById("createLeadForm_lastName").sendKeys("Testb11720");
		  driver.findElementByName("submitButton").click();
		 
		driver.findElementByLinkText("Logout").click();
		
		//login to application using demosalesmanager
		driver.findElementByName("USERNAME").sendKeys("DEMOSALESMANAGER");
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		driver.findElementByClassName("loginButton").click();
		WebDriverWait wait = new  WebDriverWait(driver, Duration.ofMillis(20));
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Merge Leads").click();
		String verifytext = driver.findElementByXPath("//div[text()[contains(.,'Merge Leads')]]").getText();
		System.out.println(verifytext);
		
		
		//click on from lead image
		driver.findElementByXPath("//table[@name='ComboBox_partyIdFrom']/following::img").click();
		String parentWin = driver.getWindowHandle();
		Set<String> win = driver.getWindowHandles();
		for (String winloop : win) {
			driver.switchTo().window(winloop);	
		}		
		//wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		String wintitle = driver.findElementByXPath("//span[text()[contains(.,'Find Leads')]]").getText();
		System.out.println(wintitle);
		driver.findElementByName("firstName").sendKeys("Testa1120");
		driver.findElementByXPath("//button[text()[contains(.,'Find Leads')]]").click();
		driver.findElementByLinkText("Testa1120").click();
		driver.switchTo().window(parentWin);
		driver.findElementByXPath("//input[@id='partyIdTo']/following::img").click();
		Set<String> win2 = driver.getWindowHandles();
		for (String win2loop : win2) {
			driver.switchTo().window(win2loop);	
		}	
		String wintitle1 = driver.findElementByXPath("//span[text()[contains(.,'Find Leads')]]").getText();
		System.out.println(wintitle1);
		driver.findElementByName("firstName").sendKeys("Testb11720");
		driver.findElementByXPath("//button[text()[contains(.,'Find Leads')]]").click();
		driver.findElementByLinkText("Testb11720").click();
		driver.switchTo().window(parentWin);
		driver.findElementByLinkText("Merge").click();
		driver.switchTo().alert().accept();
		String viewleadtitle = driver.findElementByXPath("//div[text()[contains(.,'View Lead')]]").getText();
		System.out.println(viewleadtitle);
		driver.findElementByLinkText("Logout").click();
		driver.close();
		
		
	}
		
		
		
		
	}
