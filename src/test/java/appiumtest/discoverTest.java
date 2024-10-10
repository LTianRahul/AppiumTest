package appiumtest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasSettings;
import io.appium.java_client.InteractsWithApps;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class discoverTest {
    private AppiumDriver driver;
    private final String username = "rahulkumarlambdatest";
    private final String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    private final String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    private String status = "passed";

    @BeforeTest
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("name", "test 1 " + LocalDate.now());
        ltOptions.put("build", "DCSG build 1");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platform", "android");
        ltOptions.put("deviceName", "Galaxy S24");
//        ltOptions.put("reduceMotion", true);
//        ltOptions.put("noReset", true);
//        ltOptions.put("nativeWebScreenshot", true);
//        ltOptions.put("disableAnimation", true);
//        ltOptions.put("reduceMotion", true);
        ltOptions.put("platformVersion", "14");
//        ltOptions.put("autoDismissAlerts", false);
//        ltOptions.put("autoAcceptAlerts", true);
       // ltOptions.put("appiumVersion", "1.22.0");
//        ltOptions.put("maxTypingFrequency", 10);
//        ltOptions.put("sendKeyStrategy", "setValue");
        ltOptions.put("app", "lt://APP10160502001723244934371935");
        capabilities.setCapability("lt:options", ltOptions);

        try {
            driver = new AppiumDriver(new URL("http://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);
            
            Map<String, Object> settings = new HashMap<String, Object>();
//            settings.put("waitForIdleTimeout", 5.8);
//            settings.put("animationCoolOffTimeout", 1.2);
            settings.put("snapshotMaxDepth", 10);
//            settings.put("shouldUseCompactResponses", false);
//            settings.put("elementResponseAttributes", "name, label, rect, visible, enabled, displayed, selected, value");
//            ((HasSettings) driver).setSettings(settings);
           driver.setSettings(settings);
            
            
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println("Error initializing driver: " + e.getMessage());
        }
    }

    @Test
    public void testSimple() throws Exception {
//        if (driver == null) {
//            System.out.println("Driver is not initialized, skipping the test.");
//            return;
//        }

        try {
        	
        	System.out.println(driver.getSessionId());
        	
        	System.out.println("Started");
        	driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        	 Thread.sleep(5000);
        	 
        	 System.out.println(driver.findElement(By.xpath("//*[@resource-id=\"GhostButton_FeatureToggles\"]")).getText());
        	 Thread.sleep(3000);
        //   driver.findElement(By.id("//*[@resource-id=\"DFSTextInput_SessionIDInput_input\"]")).click();
           driver.findElement(By.id("DFSTextInput_SessionIDInput_input")).click();
            Thread.sleep(2000);

           

        } catch (Exception e) {
            System.out.println("Error during test execution: " + e.getMessage());
            status = "failed";
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
