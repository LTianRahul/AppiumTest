package appiumtest;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;
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
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class virtualDeviceDemo {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		String username = "rahulkumarlambdatest";
		String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
		// private RemoteWebDriver driver;
		AppiumDriver driver;

		// AndroidDriver<AndroidElement> driver = new AndroidDriver<>

		String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);
		ltOptions.put("build", "Time change");
		ltOptions.put("isRealMobile", false);
		ltOptions.put("platformName", "ios");
		ltOptions.put("deviceName", "iPhone 15");
		//ltOptions.put("geoLocation", "CA");
		ltOptions.put("platformVersion", "17.0"); // RD - lt://APP1016043281709833148942420 - emu - // APP1016020161710274278890661
		ltOptions.put("app", "lt://APP10160601521727978132444161");

		capabilities.setCapability("lt:options", ltOptions);

		driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);

		Thread.sleep(3000);
		// driver.setLocation(new Location(25.0330, 121.5654));

		//driver.setLocation(new Location(37.4316, 78.6569, 8)); // io.appium.java_client.android.Location // Virginia
		Thread.sleep(3000);													// coordinates
		driver.getPageSource();
		
		
		
		Thread.sleep(10000);
		
		System.out.println("page source is "+driver.getPageSource());

//		String getLocation = driver.getLocationContext().location().toString();
//		
//		System.out.println("Location is "+getLocation);

		// Thread.sleep(1000);

		Map<String, String> params = new HashMap<String, String>();
		params.put("command", "shell");
		params.put("text", "su root date -s 11:30"); //root

		Object timeOutput = driver.executeScript("lambda-adb", params);

		System.out.println("timeOutput is: " + timeOutput);
		
		Thread.sleep(2000);
		Map<String, String> params1 = new HashMap<String, String>();
		params1.put("command", "shell");
		params1.put("text", "settings put global time_zone Europe/Madrid"); //root

		Object timeOutput1 = driver.executeScript("lambda-adb", params1);

		System.out.println("timeOutput is: " + timeOutput1);
//		adb shell settings get global time_zone  

		Thread.sleep(10000);

		driver.quit();

	}
}
