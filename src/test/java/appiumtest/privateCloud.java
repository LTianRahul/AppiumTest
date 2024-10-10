package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.ios.IOSDriver;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

public class privateCloud {
	String username = "rahulkumarlambdatest";
	String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";

	public AndroidDriver driver;

	public String status = "passed";

	public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);
		ltOptions.put("name", "test 1 " + LocalDate.now());
		ltOptions.put("build", "Private Cloud");
		ltOptions.put("isRealMobile", true);
		ltOptions.put("platform", "android");
		ltOptions.put("deviceName", "Galaxy Tab A7 Lite");
		ltOptions.put("privateCloud", true);
		ltOptions.put("visual", true);
		ltOptions.put("platformVersion", "11"); 
		ltOptions.put("appPackage", "com.lambdatest.proverbial");
		ltOptions.put("appActivity", "com.lambdatest.proverbial.MainActivity");
		// To start the session on already installed/existing application in private
		// cloud device
		ltOptions.put("app", "stock");
		capabilities.setCapability("lt:options", ltOptions);

		try {
			driver = new AndroidDriver(new URL(
					"https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"),
					capabilities);

		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testSimple() throws Exception {
		try {

			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@resource-id=\"com.lambdatest.proverbial:id/color\"]")).click();


		} catch (Exception e) {
			System.out.println(e.getMessage());
			status = "failed";
		}
	}

	@AfterTest
	public void tearDown() throws Exception {

		driver.executeScript("lambda-status=" + status);
		driver.quit();

	}
}
