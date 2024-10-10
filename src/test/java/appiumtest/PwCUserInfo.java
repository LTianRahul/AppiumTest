package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.SupportsLocation;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PwCUserInfo {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
//		String username = "rahulkashyap8058";
//		String authkey = "ZdBfaCldKCl0Sjo0jFcUOGoHhacNDsoJ3mrdrDwmw2v47Id84T";
		
		String username = "rahulkumarlambdatest";
		String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
		// private RemoteWebDriver driver;
		AppiumDriver driver;

		// AndroidDriver<AndroidElement> driver = new AndroidDriver<>

		String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("optionalIntentArguments", "--user 10");
//		capabilities.setCapability("appium:userProfile", 10);
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);
		ltOptions.put("build", "Live Interaction Support");
		ltOptions.put("isRealMobile", true);
//		ltOptions.put("enableImageInjection", true);
		ltOptions.put("network", true);
		ltOptions.put("network.har", true);
//		ltOptions.put("smartui.project", "AppiumTest");
		ltOptions.put("platformName", "android");
		ltOptions.put("dedicatedProxy", true);
		ltOptions.put("privateCloud", true);
		ltOptions.put("mitmProxy", true);
		ltOptions.put("resignApp", false);
//		ltOptions.put("geoLocation", "CA");
//		ltOptions.put("autoGrantPermissions", true);
		ltOptions.put("app", "lt://APP10160502001723117986617175");lt://APP10160502001723117986617175
//		ltOptions.put("appPackage", "com.lambdatest.proverbial");
//		ltOptions.put("appActivity", "com.lambdatest.proverbial.MainActivity");
		//ltOptions.put("privateCloud", true);
		//ltOptions.put("appiumVersion", "2.0.0");
//		 ltOptions.put("userProfile", 10);
//		ltOptions.put("optionalIntentArguments", "--user 10");
		ltOptions.put("deviceName", "Pixel Tablet");
		ltOptions.put("platformVersion", "13"); // RD - lt://APP1016043281709833148942420 - emu - //
												// APP1016020161710274278890661
		//ltOptions.put("app", "lt://APP1016055611715789617962501");

		// com.netflix.mediaclient/com.netflix.mediaclient.ui.launch.UIWebViewActivity
		
//		Map<String, String> paramsOption = new HashMap<String, String>();
//		paramsOption.put("--user", "10");
//		ltOptions.put("optionalIntentArguments", paramsOption);

		capabilities.setCapability("lt:options", ltOptions);

		driver = new AppiumDriver(new URL("https://webhook.site/b9db5c96-5409-4d5d-ba2c-a9eb905e8531"), capabilities);
		Thread.sleep(1000);

		// adb shell pm list users // dumpsys
		
		// for Bell media customer
//		((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot=pic1");
		 driver.findElement(By.xpath("//*[@text=\"Skip\"]")).click();
		 Thread.sleep(1000);
		// driver.findElement(By.xpath("//*[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@resource-id=\"ca.tsn.mobile.android.staging:id/onboardingSkip\"]")).click();
		 Thread.sleep(5000);
		 
		 
		
//		userInfo is: Users:
//			UserInfo{0:Owner:c13} running
//			UserInfo{10:Scalefusion Managed Profile:10101030} running

		  // Execute the ADB command to open Bluetooth settings
//        HashMap<String, Object> params1 = new HashMap<>();
//        params1.put("command", "am start -a android.settings.BLUETOOTH_SETTINGS");
//        driver.executeScript("mobile: shell", params1);
	
//Thread.sleep(10000);
//		Map<String, String> params1 = new HashMap<String, String>();
//		params1.put("command", "shell");
//		params1.put("text", "pm list users");
//		
//		//dumpsys user | grep UserInfo | awk -F 'UserInfo{' '{print $2}' | cut -d ' ' -f 1
//
//		Object userInfo = driver.executeScript("lambda-adb", params1);
//
//		System.out.println("userInfo is: " + userInfo);

		Thread.sleep(80000);

		// ((InteractsWithApps) driver).activateApp("com.netflix.mediaclient");

//	((StartsActivity) driver).startActivity(new Activity("com.netflix.mediaclient", "com.netflix.mediaclient.ui.launch.UIWebViewActivity"));

		// Switch user profile
//        Map<String, String> params2 = new HashMap<String, String>();
//        params2.put("command", "shell");
//        params2.put("text", "am switch-user 10"); // Replace 10 with the desired user ID
//
//        driver.executeScript("lambda-adb", params2);
		// Thread.sleep(10000);
//		((StartsActivity) driver).startActivity(
//				new Activity("com.netflix.mediaclient", "com.netflix.mediaclient.ui.launch.UIWebViewActivity"));
		//Thread.sleep(10000);
		// Re-launch the app if necessary
	//	((InteractsWithApps) driver).activateApp("com.netflix.mediaclient");

		// userInfo is: 0:xxx:c13}
		// 10:xxx:10101030}
		
		//((StartsActivity) driver).startActivity(new Activity("com.android.settings", "android.settings.WIFI_SETTINGS"));
//		System.out.println("Opening WiFi activity");
//		Activity activity = new Activity("com.android.settings", "com.android.settings.WIFI_SETTINGS");
//        driver.startActivity(activity);
        
        
//		Map<String, String> params2 = new HashMap<String, String>();
//		params2.put("command", "shell");
//		params2.put("text", "am start -a android.settings.WIFI_SETTINGS");
//		
//	driver.executeScript("lambda-adb", params2);

		driver.quit();
// userInfo is: 0:xxx:c13}
	}
}
