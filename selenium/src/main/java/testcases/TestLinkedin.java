package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import selenium_actions.Linkedin;
import selenium_actions.LinkedinMessage;


public class TestLinkedin extends LinkedinMessage {

	@Parameters("browser")
	@Test
	public void launchBrowser(String browser) throws InterruptedException {
		System.out.println("browser "+browser+"  is launching");
		Thread.sleep(5000);
		invokeBrowser(browser);	
		openLinkedin("https://www.linkedin.com/");
		messageLinkedin();
	}
}
