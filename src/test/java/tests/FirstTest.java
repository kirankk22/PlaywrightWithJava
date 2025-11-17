package tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import base.BaseTest;

public class FirstTest extends BaseTest {

	@Test
	public void verifyPageTitle() {
		page.navigate("https://google.com/ncr");

		// Optional: Handle any pop-ups or consent forms here
		if (page.isVisible("button:has-text('Accept all')")) {
			page.click("button:has-text('Accept all')");
		}

		System.out.println("Page title: " + page.title());
	}

	
}
