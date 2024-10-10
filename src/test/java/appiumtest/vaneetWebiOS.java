package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.SupportsContextSwitching;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Set;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

public class vaneetWebiOS {
	String username = "rahulkumarlambdatest";
	String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
	// private RemoteWebDriver driver;
	private RemoteWebDriver driver;
	private String status = "failed";

	public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);
		ltOptions.put("name", "test 1 " + LocalDate.now());
		ltOptions.put("build", "Wellfit");
		ltOptions.put("isRealMobile", false);
		ltOptions.put("platformName", "ios");
		ltOptions.put("deviceName", "iPhone 15");
//		ltOptions.put("tunnel", true);
//		ltOptions.put("dedicatedProxy", true);
//		ltOptions.put("platformVersion", "17");
//		ltOptions.put("autoGrantPermissions", true);
//		ltOptions.put("autoAceptAlerts", true);
//		ltOptions.put("network", true);

		capabilities.setCapability("LT:options", ltOptions);

		try {
			driver = new IOSDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@hub.lambdatest.com/wd/hub"), capabilities);

		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testSimple() throws Exception {
		try {

			
			driver.get("https://www.gps-coordinates.net/my-location");

			Thread.sleep(5000);
			
			 Set<String> contexts = ((SupportsContextSwitching) driver).getContextHandles();
		        System.out.println("Available contexts: " + contexts);

		        
		        //((SupportsContextSwitching) driver).context("NATIVE_APP");
		        
		        // Switch to the web view context (usually starts with WEBVIEW)
		        for (String context : contexts) {
		            if (context.contains("NATIVE_APP")) {
		                ((SupportsContextSwitching) driver).context(context);
		                System.out.println("Switched to context: " + context);
		                break;
		            }
		        }
			
			System.out.println("After Switching "+contexts);
		
//			((SupportsContextSwitching) driver).context("NATIVE_APP");
		
//			Thread.sleep(3000);
		
//			System.out.println(((SupportsContextSwitching) driver).getContextHandles());
		
//			Thread.sleep(5000);
			
			//driver.findElement(By.xpath("//*[@resource-id=\"com.android.chrome:id/positive_button\"]")).click();
			
			Thread.sleep(1000);
			//*[@content-desc="Allow while visiting the site"]
			
			//driver.findElement(By.xpath("//*[@content-desc=\"Allow while visiting the site\"]")).click();
			
			driver.findElement(By.xpath("//*[@name=\"Allow While Using App\"]")).click();
			
			Thread.sleep(3000);
			
			//driver.findElement(By.xpath("//*[@name=\"Allow\"]")).click();
			
			
			

			status = "passed";
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
