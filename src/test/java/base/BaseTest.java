package base;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.ExtentManager;

public class BaseTest {
	
	protected Playwright playwright;
	protected Browser browser;
	protected Page page;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeMethod
	public void setUp(Method method) {
		// Common setup code for all tests can go here
		
		// Reporting setup
		extent = ExtentManager.getInstance();
		test = extent.createTest(method.getName());
		
		// Playwright setup
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		page = browser.newPage();
		//page.setDefaultTimeout(4000);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		// Common teardown code for all tests can go here
		
		// Reporting teardown
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable());
			
			// Capture screenshot on failure
			String screenshotPath = utils.ScreenshotUtils.takeScreenshot(page, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test skipped");
		}
		extent.flush();
		
		// Playwright teardown
		if (browser != null) {
			browser.close();
		}
		
		if (playwright != null) {
			playwright.close();
		}
	}
	

}
