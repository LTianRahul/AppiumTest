package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PwCUserInfoLatest {

	private AndroidDriver driver;
	private String username = "rahulkumarlambdatest";
	private String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
	private String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
	private String userInfo;

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);
		ltOptions.put("build", "PwC User Info");
		ltOptions.put("isRealMobile", true);
		ltOptions.put("platformName", "android");
		ltOptions.put("app", "lt://APP10160492431717404631765267");
//		ltOptions.put("app", "stock");
		ltOptions.put("privateCloud", true);
		ltOptions.put("deviceName", "Galaxy Tab A7 Lite");
		ltOptions.put("platformVersion", "11");
//		ltOptions.put("optionalIntentArguments", "--user 10");
//		ltOptions.put("appPackage", "com.lambdatest.proverbial");
//		ltOptions.put("appActivity", "com.lambdatest.proverbial.MainActivity");

		// Use the extracted userInfo to set optionalIntentArguments
//		ltOptions.put("optionalIntentArguments", "--user " + extractUserId(userInfo));

		capabilities.setCapability("lt:options", ltOptions);
		driver = new AndroidDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);

		// Execute the ADB command to get user information
//		Map<String, String> params1 = new HashMap<String, String>();
//		params1.put("command", "shell");
//		params1.put("text", "pm list users");
//		
//		//adb shell am start -a android.settings.WIFI_SETTINGS
//
//
//		userInfo = (String) driver.executeScript("lambda-adb", params1);
//		System.out.println("userInfo is: " + userInfo);

		Thread.sleep(10000);

		Map<String, String> params2 = new HashMap<String, String>();
		params2.put("command", "shell");
		params2.put("text", "am start -a android.settings.WIFI_SETTINGS");

		driver.executeScript("lambda-adb", params2);

		Map<String, String> params3 = new HashMap<String, String>();

		params3.put("command", "shell");

		params3.put("text", "am start -d alkami-macu://Mobile/TransferV2");

		driver.executeScript("lambda-adb", params3);

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("w3c", true);
//        ltOptions.put("build", "PwC User Info");
//        ltOptions.put("isRealMobile", true);
//        ltOptions.put("platformName", "android");
//        ltOptions.put("app", "stock");
//        ltOptions.put("privateCloud", true);
//        ltOptions.put("deviceName", "Galaxy Tab A7 Lite");
//        ltOptions.put("platformVersion", "11");
////        ltOptions.put("appPackage", "com.lambdatest.proverbial");
////		ltOptions.put("appActivity", "com.lambdatest.proverbial.MainActivity");
//
//        capabilities.setCapability("lt:options", ltOptions);
//        driver = new AndroidDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
//
//        // Allow some time for the driver to initialize
//        Thread.sleep(10000);
//
//        // Execute the ADB command to get user information
//        Map<String, String> params1 = new HashMap<String, String>();
//        params1.put("command", "shell");
//        params1.put("text", "pm list users");
////
//        userInfo = (String) driver.executeScript("lambda-adb", params1);
//        System.out.println("userInfo is: " + userInfo);
//        
//        // Close the initial driver as we will use the userInfo for the next driver setup
//        driver.quit();
	}

	@Test
	public void test() throws MalformedURLException, InterruptedException {

		Thread.sleep(3000);
//	private String extractUserId(String userInfo) {
//		// Simple method to extract the user ID from the userInfo string
//		// Adjust the logic based on the actual format of the userInfo string
//		if (userInfo != null && userInfo.contains("UserInfo{")) {
//			String[] parts = userInfo.split("UserInfo\\{");
//			if (parts.length > 1) {
//				String[] userDetails = parts[1].split(":");
//				return userDetails[0].trim();
//			}
//		}
//		return "0"; // Default to owner if parsing fails
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

//        userInfo is: Users:
//        	UserInfo{0:Owner:c13} running
//        	UserInfo{10:Scalefusion Managed Profile:10101030} running

	}
}
