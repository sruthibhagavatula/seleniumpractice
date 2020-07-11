package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium_actions.SeleniumActions;

public class TestClass extends SeleniumActions {

	@Parameters("browser")
	@Test
	public void launchBrowser(String browser) throws InterruptedException {
		System.out.println("browser "+browser+"  is launching");
		Thread.sleep(5000);
		invokeBrowser(browser);	
		openGoogle("http://www.google.com");
		//closeBrowser();
		signIn();
	}
}
