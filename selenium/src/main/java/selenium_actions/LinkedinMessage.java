package selenium_actions;

import java.time.Duration;
import java.util.List;
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



public class LinkedinMessage {

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
	
	public void openLinkedin(String url) {
		 System.out.println("url" +url+" is invoked");
		 driver.manage().window().maximize();
		 driver.get(url);
		}
	public void messageLinkedin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[text()[contains(.,'Sign in')]]").click();
		Thread.sleep(2000);
		driver.findElementByName("session_key").sendKeys("sruthir91@gmail.com");
		driver.findElementByName("session_password").sendKeys("Honey@29");
		driver.findElementByXPath("//button[text()[contains(.,'Sign in')]]").click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5));
		WebElement name = driver.findElementByXPath("//input[@id[contains(.,'typeahead-input')]]");
		wait.until(ExpectedConditions.elementToBeClickable(name));
		name.sendKeys("Pranathi Sadhula");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@class[contains(.,'contenteditable')]]/p").sendKeys("Hi this is an automated message");
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()[contains(.,'Send')]]").click();
		
		
				}
		
		
		
		
	}
