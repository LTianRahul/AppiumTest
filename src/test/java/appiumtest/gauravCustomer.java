package appiumtest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasSettings;
import io.appium.java_client.InteractsWithApps;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class gauravCustomer {
	private AppiumDriver driver;
	private final String username = "rahulkumarlambdatest";
	private final String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
	private final String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
	private String status = "passed";

	@BeforeTest
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		Map<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);
		ltOptions.put("name", "test 1 " + LocalDate.now());
		ltOptions.put("build", "PrimeBuild");
		ltOptions.put("isRealMobile", true);
		ltOptions.put("platform", "ios");
		ltOptions.put("deviceName", "iPhone.*");
		ltOptions.put("platformVersion", "16");
		ltOptions.put("unicodeKeyboard", true);
		ltOptions.put("resetKeyboard", true);
		ltOptions.put("maxTypingFrequency", 10);
		ltOptions.put("sendKeyStrategy", "setValue");
		ltOptions.put("app", "lt://APP10160311981724366376055986");
		capabilities.setCapability("lt:options", ltOptions);

		try {
			driver = new AppiumDriver(new URL(
					"http://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"),
					capabilities);

//			Map<String, Object> settings = new HashMap<String, Object>();
//			settings.put("waitForIdleTimeout", 5.8);
//			settings.put("animationCoolOffTimeout", 1.2);
//			settings.put("snapshotMaxDepth", 30);
//			((HasSettings) driver).setSettings(settings);

		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println("Error initializing driver: " + e.getMessage());
		}
	}

	@Test
	public void testSimple() throws Exception {

		try {

			Thread.sleep(10000);

			driver.findElement(By.xpath("//*[@name=\"Don't have an account? Register now.\" and @type=\"XCUIElementTypeStaticText\"]"))
					.click();

			Thread.sleep(5000);

			System.out.println("Clicking on United States button");

			driver.findElement(By.xpath("//*[@name=\"United States\"]")).click();

			Thread.sleep(2000);

			System.out.println("Entering fname");

			driver.findElement(By.xpath("//*[@name=\"First Name\"]")).click();

			driver.findElement(By.xpath("//*[@name=\"First Name\"]")).sendKeys("Fname");
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("Done")).click(); 

			Thread.sleep(2000);

			System.out.println("Entering lname");
			
			driver.findElement(By.xpath("//*[@name=\"Last Name\"]")).click();

			driver.findElement(By.xpath("//*[@name=\"Last Name\"]")).sendKeys("Lname");
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("Done")).click(); 
			
			Thread.sleep(2000);
			
			System.out.println("Entering email ID");
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Canada\"]]/*[11]")).click();
			//*[@name="Email Address (This will be your User ID)"]
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Canada\"]]/*[11]")).sendKeys("fname@lname.com");
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("Done")).click(); 
			
			Thread.sleep(2000);

			
			System.out.println("Entering Mobile number");
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Canada\"]]/*[17]")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./preceding-sibling::*[@name=\"Canada\"]]/*[17]")).sendKeys("9947949445");
			
			Thread.sleep(2000);
			//*[@type="XCUIElementTypeOther" and ./preceding-sibling::*[@name="Canada"]]/*[17]
			
			driver.findElement(By.id("Done")).click(); 
			
			Thread.sleep(3000);
			
			System.out.println("Entering SSN number");
	
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeSecureTextField\" and ./following-sibling::*[@name=\"Confirm Social Security Number\"]]")).click();
			
			//working - //*[@type=\"XCUIElementTypeSecureTextField\" and ./preceding-sibling::*[@name=\"Confirm Social Security Number\"]]
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeSecureTextField\" and ./following-sibling::*[@name=\"Confirm Social Security Number\"]]")).sendKeys("755467674");
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("Done")).click(); 
			
			Thread.sleep(3000);
			
			System.out.println("Entering Confirm SSN number");
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeSecureTextField\" and ./preceding-sibling::*[@name=\"Confirm Social Security Number\"]]")).click();
			
			//working - //*[@type=\"XCUIElementTypeSecureTextField\" and ./preceding-sibling::*[@name=\"Confirm Social Security Number\"]]
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeSecureTextField\" and ./preceding-sibling::*[@name=\"Confirm Social Security Number\"]]")).sendKeys("755467674");
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("Done")).click(); 
			
			Thread.sleep(3000);
			
			System.out.println("Entering Date of Birth");
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeTextField\" and ./preceding-sibling::*[@name=\"Date of Birth MM/DD/YYYY\"]]")).click();
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeTextField\" and ./preceding-sibling::*[@name=\"Date of Birth MM/DD/YYYY\"]]")).sendKeys("03081994");
			
			Thread.sleep(2000);
			
			driver.findElement(By.id("Done")).click(); 
			
			Thread.sleep(3000);
			
			
			
		} catch (Exception e) {
			System.out.println("Error during test execution: " + e.getMessage());
			status = "failed";
		}
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
