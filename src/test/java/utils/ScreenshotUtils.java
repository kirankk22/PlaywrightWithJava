package utils;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;

public class ScreenshotUtils {
	public static String takeScreenshot(Page page, String testName) {
		// Placeholder for screenshot logic
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String screenshotPath = "test-output/screenshots/" + testName + "_" + timestamp + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)).setFullPage(false));
		
		return screenshotPath;
	}

}
