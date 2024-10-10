package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.TouchAction;
//import org.junit.Test;
import io.appium.java_client.touch.WaitOptions;
import java.time.Duration;
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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

public class mohammadSumUpCustomer {
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
        ltOptions.put("name", "test 1 "+ LocalDate.now());
        ltOptions.put("build", "LT build");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platform", "ios");
        ltOptions.put("deviceName", "iPhone 14");

        ltOptions.put("platformVersion", "16");  //autoDismissAlerts

        ltOptions.put("appProfiling", true);

        ltOptions.put("app", "lt://APP10160361821718342686553319"); //wiki apk        
     
         capabilities.setCapability("lt:options", ltOptions);

        try
        {
      driver = new AppiumDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);
 
            Thread.sleep(2000);
            
          System.out.println(driver.getPageSource());
            
         

        }
        catch (MalformedURLException e)
        {
            System.out.println("Invalid grid URL");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testSimple() throws Exception
    {
        try
        {
        	
        	WebElement longPressLoginBtn = driver.findElement(By.xpath("//*[@name=\"WelcomeContentLoginButton\"]"));
        	
        	 TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

             // Perform long press on the button
             touchAction.longPress(ElementOption.element(longPressLoginBtn))
                         .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))) // long press duration
                         .release()
                         .perform();

           // status="passed";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            status="failed";
        }
    }
    
   
    
    @AfterTest
    public void tearDown() throws Exception
    {
     
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        
    }
}
