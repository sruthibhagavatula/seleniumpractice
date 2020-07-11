package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium_actions.IrctcRegistration;
import selenium_actions.SeleniumActions;

public class TestIrctc extends IrctcRegistration {

	@Parameters("browser")
	@Test
	public void launchBrowser(String browser) throws InterruptedException {
		System.out.println("browser "+browser+"  is launching");
		Thread.sleep(5000);
		invokeBrowser(browser);	
		openIrctc("https://www.irctc.co.in/nget/profile/user-registration");
		register();
	}
}
