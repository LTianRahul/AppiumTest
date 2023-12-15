package appiumtest;

import io.appium.java_client.AppiumDriver;


import java.util.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.URL;

public class bancoBMGAndroid {

	public static String userName = "rahulkumarlambdatest"; // Enter your LT Username here
	public static String accessKey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6"; // Enter your LT AccessKey
																							// here
//
//    public String gridURL = "@hub.lambdatest.com/wd/hub";

	String DeviceValue;
	String versionValue;
	String PlatformValue;

	RemoteWebDriver driver;

	@org.testng.annotations.Parameters(value = { "device", "version", "platform" })
	@Test
	public void AndroidApp(String device, String version, String platform) {
		try {
			DeviceValue = device;
			versionValue = version;
			PlatformValue = platform;

			DesiredCapabilities capabilities = new DesiredCapabilities();

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();

			ltOptions.put("platformName", PlatformValue);
			ltOptions.put("deviceName", DeviceValue);
			ltOptions.put("platformVersion", versionValue);
         ltOptions.put("app", "lt://APP1016026831697051231159667");
			// capabilities.setCapability("privateCloud", true);
			ltOptions.put("build", "SmartUI - Emulator Web App");
			//ltOptions.put("name", "SmartUI - Test");
//            ltOptions.put("appProfiling", true);
			ltOptions.put("project", "SmartUI - Emulator Web App");
			ltOptions.put("w3c", true);
			// ltOptions.put("appium:automationName", "flutter");
			// ltOptions.put("appium:appiumVersion", "2.0"); //1.19.0 in emulator default,
			// 1.22.3 in RD default
//            ltOptions.put("isRealMobile", false);
			// ltOptions.put("visual", true);
//            ltOptions.put("performance", true);

			// For SmartUI
//            ltOptions.put("smartUI.project", "android-emulator-SmartUI");
//            ltOptions.put("smartUI.build", "Emulator One");
			// ltOptions.put("udid", "785ded9f");
			// ltOptions.put("passcode", "098765");

            capabilities.setCapability("smartUI.project", "real-device-android-SmartUI Test");

			capabilities.setCapability("lt:options", ltOptions);

//            String hub = "https://" + userName + ":" + accessKey + gridURL;
//            AppiumDriver driver = new AppiumDriver(new URL(hub), capabilities);

			driver = new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),
					capabilities);

			System.out.println("App started on Real device......");

//            Thread.sleep(5000);
			// Capture smartui screenshot
			// driver.executeScript("smartui.takeScreenshot=first");

			//driver.get("https://www.lambdatest.com");

			Thread.sleep(5000);
			
			((JavascriptExecutor)driver).executeScript("lambda-name=TestName");

//          System.out.println("Clicked");
//          driver.findElement(By.id("android:id/button1")).click();

//			System.out.println("Clicking on I UNDERSTAND");
//
//			driver.findElement(By.id("providence.nassau.mobile.swedishhealth.stage:id/btnAccept")).click();
//
////            Thread.sleep(2000);
////            
////            System.out.println("Screenshot taken");
////            
////            driver.executeScript("smartui.takeScreenshot=first");
//
//			Thread.sleep(3000);
//
//			driver.findElement(By.id("providence.nassau.mobile.swedishhealth.stage:id/inputText"))
//					.sendKeys("ab@ab.com");
//			// driver.executeScript("smartui.takeScreenshot=first");
//
//			Thread.sleep(2000);
//
//			System.out.println("Screenshot taken");
//
//			driver.executeScript("smartui.takeScreenshot=first");
//
////          Thread.sleep(5000);
////          System.out.println("Clicked");
////		driver.findElement(By.id("br.com.bancobmg.bancodigital.qa:id/imageViewBottomSheetPermissionsAppClose")).click();
//			// driver.get("https://www.lambdatest.com");
//
////		Thread.sleep(3000);
////		
////		driver.findElement(By.id("")).click();

		} catch (Exception t) {
			System.out.println();

		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}