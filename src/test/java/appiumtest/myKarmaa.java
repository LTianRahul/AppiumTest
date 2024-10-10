package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.SupportsContextSwitching;

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

public class myKarmaa {
	String username = "rahulkumarlambdatest";
	String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";

	private AppiumDriver driver;

	public String status = "passed";

	public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("w3c", true);

		// ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
		ltOptions.put("name", "test 1 " + LocalDate.now());
		ltOptions.put("build", "myKarmaBuildRun");
		ltOptions.put("isRealMobile", true);
		ltOptions.put("platform", "android");
		ltOptions.put("appiumVersion", "1.17.1");
		ltOptions.put("deviceName", "Galaxy S24");
		ltOptions.put("platformVersion", "14");
		//ltOptions.put("resignApp", true);
		ltOptions.put("app", "lt://APP1016043281710234484290840");
		ltOptions.put("autoDismissAlerts", true);
		ltOptions.put("appProfiling", true);
		ltOptions.put("autoAcceptAlerts", true);
		ltOptions.put("autoGrantPermissions", true);
		ltOptions.put("unicodeKeyboard", true);
		ltOptions.put("resetKeyboard", true);

		capabilities.setCapability("lt:options", ltOptions);

		try {
			driver = new AppiumDriver(new URL(
					"https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"),
					capabilities);
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

//        	String context = ((SupportsContextSwitching) driver).getContext();
//        	
//        	System.out.println(context);

			// driver.findElement(By.xpath("//*[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
			// Thread.sleep(3000);
			WebElement loginField = driver.findElement(By.xpath("//*[@class=\"android.widget.EditText\"]"));

			loginField.click();

			loginField.sendKeys("rahul@gmail.com");

			Thread.sleep(1000);

			driver.findElement(By.xpath("//*[@text=\"Next\"]")).click();

			Thread.sleep(2000);

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
