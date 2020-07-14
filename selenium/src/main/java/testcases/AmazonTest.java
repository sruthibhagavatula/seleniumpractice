package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class AmazonTest {

	
	RemoteWebDriver driver;
	WebDriverWait wait;
	
	@Parameters("browser")
	@BeforeSuite
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
		 wait= new  WebDriverWait(driver, Duration.ofMillis(5));
	}	
	
	@Parameters	("url")
	@BeforeClass
	public void openAmazon(String url) {
		 System.out.println("url" +url+" is invoked");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get(url);
		}
	
	@Test
	public void addToCart() throws InterruptedException {
		
			
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,150)", "");
		List<WebElement> frames = driver.findElementsByTagName("iframe");
		System.out.println(frames.size());
		for (WebElement webElement : frames) {
			try {
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
				driver.findElementByXPath("//a[contains(@href,'https://www.amazon.in/Laptops/b')]/img").click();
				String parentwindow = driver.getWindowHandle();
				Set<String> win = driver.getWindowHandles();
				System.out.println(win);
				for (String webElement2 : win) {
					
					driver.switchTo().window(webElement2);
				}
				
				String wintitle =  driver.findElementByXPath("//h1[text()[contains(.,'Laptops')]]").getText();
				System.out.println(wintitle);
				driver.findElementByXPath("//a//img[contains(@alt,'multimedia')]").click();
				 js.executeScript("window.scrollBy(0,650)", "");
				 WebElement drpdwn = driver.findElementById("sort");
				 Select sel = new Select(drpdwn);
				 sel.selectByVisibleText("Price: Low to High");
				 
				 List<WebElement> lenovo = driver.findElementsByXPath("//h2//a[contains(@href,'Lenovo-Intel-14-inch-Laptop-81YA')]");
				 System.out.println(lenovo.size());
				 
				 for (WebElement laptoplinks : lenovo) {
					 laptoplinks.click();
					 String currentwin = driver.getWindowHandle();
				 System.out.println("1st lenovo link clicked");
				 Set<String> win1 = driver.getWindowHandles();			 
				 for (String webElement2 : win1) {
					
						driver.switchTo().window(webElement2);
						
					}
				 System.out.println("window switched");
				 driver.findElementByName("submit.add-to-cart").click();
				 System.out.println();
				 driver.close();
				 //continue;
				 driver.switchTo().window(currentwin);
				
					 
					}
				 
			}
			catch(StaleElementReferenceException e)
			{
				
				System.out.println("stale element exception");
			}
			
			
	}
		
		}
	
		
		
		
		
		}
	
	
	

