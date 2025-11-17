package tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest2 extends BaseTest {
	
	
	@Test
	public void testLoginLogout1() {
	
	      LoginPage loginPage = new LoginPage(page);
	      HomePage homePage = new HomePage(page);
	      
	      test.info("Navigating to Login Page");
	      loginPage.navigateToLoginPage();
	      test.info("Logging into the application");
	      loginPage.loginToApplication("Admin", "admin123");
	      test.info("Clicking on Time link");
	      homePage.clickTimeLink();
	      test.info("Test completed successfully");
	      
	    }
	
	@Test
	public void testLoginLogout2() {
	
	      LoginPage loginPage = new LoginPage(page);
	      HomePage homePage = new HomePage(page);
	      
	      test.info("Navigating to Login Page");
	      loginPage.navigateToLoginPage();
	      test.info("Logging into the application");
	      loginPage.loginToApplication("Admin", "admin1231234");
	      test.info("Clicking on Time link");
	      homePage.clickTimeLink();
	      test.info("Test completed successfully");
	      
	    }
	
	@Test
	public void testLoginLogout3() {
		test.skip("Skipping this test case intentionally");
		throw new SkipException("Skipping this test case intentionally");
	}

}
