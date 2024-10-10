package appiumtest;

import io.appium.java_client.AppiumDriver;

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

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

public class fitnessSyncerCreateAccount {
	String username = "rahulkumarlambdatest";
	String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
	// private RemoteWebDriver driver;
	private AppiumDriver driver;
	// private String status = "failed";

	public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);

		// ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
		ltOptions.put("name", "test 1 " + LocalDate.now());
		ltOptions.put("build", "FitnessSyncer");
		ltOptions.put("isRealMobile", true);
		ltOptions.put("platformName", "ios");
		//ltOptions.put("appiumVersion", "2.0.0");
		//ltOptions.put( "browserName", "Safari" );
		ltOptions.put("deviceName", "iPhone 8");
		ltOptions.put("autoAcceptAlerts", false);
		ltOptions.put( "network", true );
		ltOptions.put("udid", "f2b33ed06f59ac86e8f1e2d4a6f3c09b464cca94");
		ltOptions.put( "unicodeKeyboard", true );
		ltOptions.put( "resetKeyboard", true );
		ltOptions.put("platformVersion", "16"); // lt://APP10160601511703202882836940
		ltOptions.put("app", "lt://APP10160582261717617696411274");
		ltOptions.put("console", true);
		capabilities.setCapability("lt:options", ltOptions);

		try {
			driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
			Thread.sleep(5000);

		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testSimple() throws Exception {
		try {
		
			driver.findElement(By.name("Create Account")).click();

			Thread.sleep(20000);

			driver.findElement(By.className("XCUIElementTypeTextField")).click();

			driver.findElement(By.className("XCUIElementTypeTextField")).sendKeys("rahul@gmail.com");

			WebElement passwordField = driver.findElement(By.className("XCUIElementTypeSecureTextField"));

			passwordField.click();

			passwordField.sendKeys( "a" ); // 1

			// Clearing the password field using backspace key events
			String passwordValue = passwordField.getText();

			System.out.println("Old Password is " + passwordValue);

			int passwordLength = passwordField.getText().length();
			System.out.println("Length of Old password is " + passwordLength);
//			for (int i = 0; i < passwordLength; i++) {
//				passwordField.sendKeys(Keys.BACK_SPACE);
//			}

			passwordField.sendKeys(Keys.DELETE);
			
			passwordField.sendKeys( "b" ); // 2
			
			//hideKeyboard();

			Thread.sleep(2000);

			String newPasswordValue = passwordField.getText();

			System.out.println("New Password is " + newPasswordValue);

			int newPasswordValueLength = passwordField.getText().length();
			
			System.out.println("Length of New password is " + newPasswordValueLength);
			// status="passed";

			driver.findElement(By.className("XCUIElementTypeStaticText")).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// status="failed";
		}
	}

	@AfterTest
	public void tearDown() throws Exception {

		// driver.executeScript("lambda-status=" + status);
		driver.quit();

	}
	
//	public void hideKeyboard() {
//	    try {
//	        ((AppiumDriver) driver).getKeyboard().pressKey( Keys.RETURN );
//	    } catch ( Exception ex ) {
//	        // Handle any exceptions that might occur
//	    }
//	}

}
