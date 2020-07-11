package selenium_actions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class IrctcRegistration {

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
	
	public void openIrctc(String url) {
		 System.out.println("url" +url+" is invoked");
		 driver.manage().window().maximize();
		 driver.get(url);
		}
	public void register() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//span[text()[contains(.,'Alert')]]").click();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,1000)", "");
		 */
		driver.findElementByXPath("//button[text()[contains(.,'Ok')]]").click();
		Thread.sleep(5000);
		/*
		 * Actions act = new Actions(driver);
		 * act.click(scroll).keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		 * Thread.sleep(5000);
		 */
		driver.findElementById("userName").sendKeys("sruthi23991");
		driver.findElementById("usrPwd").sendKeys("Sruthi91");
		driver.findElementById("cnfUsrPwd").sendKeys("Sruthi91");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)", "");
		driver.findElementByXPath("//label[text()[contains(.,\"Select Security Question\")]]").click();
		driver.findElementByXPath("//span[text()[contains(.,\"What is your favorite past-time?\")]]").click();
		driver.findElementByXPath("//label[text()[contains(.,'Security Answer')]]/following::div/input").click();
		driver.findElementByXPath("//label[text()[contains(.,'Security Answer')]]/following::div/input").sendKeys("gardening");
		driver.findElementByXPath("//label[text()[contains(.,'Select Preferred Language')]]").click();
		driver.findElementByXPath("//span[text()[contains(.,\"English\")]]").click();
		
		driver.findElementById("firstName").sendKeys("Sruthi");
		driver.findElementById("F").click();
		driver.findElementByXPath("//label[text()[contains(.,'Date Of Birth')]]/following::input").click();
		driver.findElementByXPath("//div[@class='ui-datepicker-title']/select/option[text()[contains(.,'April')]]").click();
		
		Thread.sleep(3000);
		driver.findElementByXPath("//select[@class='ui-datepicker-year ng-tns-c11-6 ng-star-inserted']/option[text()[contains(.,'1991')]]").click();
		driver.findElementByXPath("//tbody[@class='ng-tns-c11-6']/tr[5]/td[2]").click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		driver.findElementByXPath("//label[text()[contains(.,\"Select Occupation\")]]").click();
		driver.findElementByXPath("//span[text()[contains(.,\"STUDENT\")]]").click();
		driver.findElementById("mobile").sendKeys("9864314582");
		driver.findElementById("resAddress1").sendKeys("Ramanthapur");
		driver.findElementByName("resPinCode").sendKeys("500013");
		driver.findElementById("resState").sendKeys("Telangana");
		js.executeScript("window.scrollBy(0,150)", "");
		driver.findElementByXPath("//label[text()[contains(.,'City/Town')]]/following::div/select/option[text()[contains(.,'HYDERABAD')]]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//label[text()[contains(.,'Post Office ')]]/following::div/select/option[text()[contains(.,'Amberpet S.O')]]").click();
		driver.findElementById("resPhone").sendKeys("04023122989");
		driver.findElementByXPath("//label[text()[contains(.,'Copy Residence to office Address ')]]/following::div/input").click();
		
		
		
		
		}
		
		
		
		
	}
