package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Set;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

public class openChromeinIOS {
	String username = "rahulkumarlambdatest";
	String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
	// private RemoteWebDriver driver;
	private IOSDriver driver;
	private String status = "failed";

	public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);

//        ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
		ltOptions.put("name", "test 1 " + LocalDate.now());
		ltOptions.put("build", "wellfit");
		ltOptions.put("isRealMobile", true);
		ltOptions.put("platformName", "ios");
		ltOptions.put("deviceName", "iPhone.*");
		ltOptions.put("platformVersion", "17");
		ltOptions.put("console", true);
		ltOptions.put("newCommandTimeout", 600);

		capabilities.setCapability("LT:options", ltOptions);

		try {
			driver = new IOSDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);

		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testSimple() throws Exception {
		try {

			((InteractsWithApps) driver).activateApp("com.google.chrome.ios");

			Thread.sleep(2000);

			String context = driver.getContext();
			System.out.println(context);
			
			Thread.sleep(1000);

		//	driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeOther\" and ./parent::*[@type=\"XCUIElementTypeOther\" and ./following-sibling::*[@name=\"Toolbar\"]]]")).click();
//			Set<String> contextNames = driver.getContextHandles();
//			for (String contextName : contextNames) {
//				System.out.println("inside for: "+contextName); // Print available contexts
//				if (contextName.contains("WEBVIEW")) {
//					driver.context("NATIVE_APP"); // Switch to WebView
//					break;
//				}
//			}
			System.out.println("switching from Web to Native");
			driver.context("NATIVE_APP");
			Thread.sleep(1000);
			
			String contextafterSclick = driver.getContext();
			System.out.println("after click "+contextafterSclick);

			// driver.findElement(By.xpath("//*[@name=\"NTPCollectionViewIdentifier\"]/*[1]/*[@type=\"XCUIElementTypeOther\"]/*[1]/*[2]")).click();
			// *[@name="NTPCollectionViewIdentifier"]/*[1]/*[@type="XCUIElementTypeOther"]/*[@type="XCUIElementTypeButton"]/*[3]
			//System.out.println("clicked");

			WebElement addressBar = driver.findElement(By.name("NTPHomeFakeOmniboxAccessibilityID"));
			
			addressBar.click();
			System.out.println("clicked");
			Thread.sleep(2000);
			
			WebElement addressBar_another = driver.findElement(By.xpath("//*[@name=\"0\"]/*[5]"));
			
			addressBar_another.sendKeys("https://www.lambdatest.com");
			Thread.sleep(2000);
			addressBar_another.sendKeys(Keys.ENTER);
			
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("//*[@name=\"NTPCollectionViewIdentifier\"]/*[1]/*[@type=\"XCUIElementTypeOther\"]/*[@type=\"XCUIElementTypeButton\"]/*[3]")).sendKeys("https://www.lambdatest.com");
//            
			String contextafterSclickexecution = driver.getContext();
			System.out.println("click after click "+contextafterSclickexecution);
//            driver.get("https://www.lambdatest.com");
		
			//driver.findElement(By.xpath("//*[@name=\"Next-Generation Mobile Apps and Cross Browser Testing Cloud | LambdaTest\"]/*[5]/*[@type=\"XCUIElementTypeLink\"]/*[@type=\"XCUIElementTypeStaticText\"]")).click();
			
			System.out.println("getting all contexts");
			 Set<String> contextNames = driver.getContextHandles();
		        for (String contextName : contextNames) {
		            System.out.println("Available context: " + contextName);
		        }
		        
			
			System.out.println("switching from Native to Web");
			driver.context("WEBVIEW_");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@name=\"Menu\"]")).click();
//			driver.findElement(By.name("NTPHomeFakeOmniboxAccessibilityID")).sendKeys("https://www.lambdatest.com");
//			System.out.println("clicked");
			Thread.sleep(5000);

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
