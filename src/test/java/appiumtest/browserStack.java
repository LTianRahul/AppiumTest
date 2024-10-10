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

public class browserStack {
	String username = "rahulkumarlambdatest";
	String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";


	public IOSDriver driver;
	

	public String status = "passed";

	public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

	// BS hub - hub-cloud.browserstack.com

//	public String BSHub = "@hub-cloud.browserstack.com";

//  HashMap<String, Object> params = new HashMap<String, Object>();
//  HashMap<String, String> permissionSettings = new HashMap<String, String>();
//
//    // Execute the script
//    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);

//
//        // ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
		ltOptions.put("name", "test 1 " + LocalDate.now());
		ltOptions.put("build", "Dicks build 1");
		ltOptions.put("isRealMobile", true);
		ltOptions.put("platform", "ios");
//       ltOptions.put("appiumVersion", "1.22.3"); //
////        ltOptions.put("udid", "00008130-000E383A219A001C");
		ltOptions.put("deviceName", "iPhone 15 Pro");
//		ltOptions.put("bundleId", "com.dsg.qa.mobile.consumer");
		
		ltOptions.put("visual", true);
		ltOptions.put("platformVersion", "17"); // autoDismissAlerts
		ltOptions.put("autoDismissAlerts", false);
		ltOptions.put("autoAcceptAlerts", true);
		ltOptions.put("app", "lt://APP10160291931719347861338646");



		capabilities.setCapability("lt:options", ltOptions);


		// BS capabiltiies

//   	 DesiredCapabilities capabilities = new DesiredCapabilities();
//   	 HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//   	 browserstackOptions.put("appiumVersion", "2.4.1");
//   	 capabilities.setCapability("platformName", "ios");
//   	 capabilities.setCapability("platformVersion", "17");
//   	 capabilities.setCapability("deviceName", "iPhone 15 Pro");
//   	 capabilities.setCapability("app", "bs://87e6c8657c43696b214ead85f364a2cb95d8c77d");
//   	 capabilities.setCapability("autoDismissAlerts", false);
//   	 capabilities.setCapability("autoAcceptAlerts", false);
//   	 capabilities.setCapability("autoGrantPermissions", false);
////   	 browserstackOptions.put("autoDismissAlerts", true);
////   	 browserstackOptions.put("autoAcceptAlerts", false);
//   	 capabilities.setCapability("bstack:options", browserstackOptions);



		try {
			driver = new IOSDriver(new URL(
					"https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"),
					capabilities);
			// driver = new AppiumDriver(new
						// URL("https://mobileautoservic_w86Uka:SeW8HQo2LzzoUw9qsDK8@hub-cloud.browserstack.com/wd/hub"),
						// capabilities);

		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testSimple() throws Exception {
		try {
			
			

			driver.findElement(By.xpath("//*[@name=\"CONTINUE AS GUEST\"]")).click();
			Thread.sleep(2000);
			
	
			driver.findElement(By.xpath("//*[@name=\"CONTINUE\"]")).click();
			Thread.sleep(2000);
			
driver.activateApp("com.apple.preferences");
			
			Thread.sleep(5000);
		
			 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	            jsExecutor.executeScript("lambda-ios-settings", getJsonPreferences());
//
	        	Thread.sleep(10000);
//	        	
//	        	((InteractsWithApps) driver).activateApp("com.dsg.qa.mobile.consumer");
	        	
			// driver.findElement(By.id("Allow While Using App")).click();
	        driver.activateApp("com.dsg.qa.mobile.consumer");

           // ((InteractsWithApps) driver).activateApp("com.dsg.qa.mobile.consumer");
            Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@name=\"CONTINUE\"]")).click();
			Thread.sleep(2000);

//			 driver.findElement(By.xpath("//*[@name=\"Allow\"]")).click();
//			Thread.sleep(2000);

			
			
		

			driver.findElement(By.xpath("//*[@name=\"SIGN INTO SCORECARD\"]")).click();
			Thread.sleep(6000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
//            status="failed";
		}
	}

	@AfterTest
	public void tearDown() throws Exception {

		// driver.executeScript("lambda-status=" + status);
		driver.quit();

	}


	
	 // Method to construct JSON preferences
    private Map<String, Object> getJsonPreferences() {
//        Map<String, Object> jsonPreferences = new HashMap<String, Object>();
//        Map<String, String> permissionSettings = new HashMap<String, String>();
//        permissionSettings.put("Location", "While Using the App");
//        jsonPreferences.put("Permission Settings", permissionSettings);
		Map<String, Object> jsonPreferences = new HashMap<String, Object>();
		Map<String, String> permissionSettings = new HashMap<String, String>();
		permissionSettings.put("Location", "While Using the App");
//		permissionSettings.put("Precise Location", "On");
		jsonPreferences.put("Permission Settings", permissionSettings);
        return jsonPreferences;
    }
}
