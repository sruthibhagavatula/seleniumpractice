package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium_actions.LeafTaps;
import selenium_actions.Linkedin;
import selenium_actions.LinkedinMessage;


public class TestLeafTaps extends LeafTaps {

	@Parameters("browser")
	@Test
	public void launchBrowser(String browser) throws InterruptedException {
		System.out.println("browser "+browser+"  is launching");
		Thread.sleep(5000);
		invokeBrowser(browser);	
		openLeafTaps("http://leaftaps.com/opentaps/control/main");
		leafTapsScenario();
	}
}
