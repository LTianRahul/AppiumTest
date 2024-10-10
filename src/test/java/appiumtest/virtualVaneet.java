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

public class virtualVaneet {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		String username = "rahulkumarlambdatest";
		String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
		// private RemoteWebDriver driver;
		RemoteWebDriver driver;

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

		driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);

		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"” means a Web-based or offline software application that is provided by Customer or a third party and which may interoperate with the Covered Services, including, for example, an application that is developed by or for Customer, is listed on a marketplace, or is identified as Salesforce Labs or by a similar designation. Non-SFDC Applications may also be referred to as Third Party Applications.\"]")).click();
		
		driver.getPageSource();

		Thread.sleep(10000);

		driver.quit();

	}
}
