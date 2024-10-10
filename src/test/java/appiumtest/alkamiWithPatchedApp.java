package appiumtest;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;

public class alkamiWithPatchedApp {
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    //private RemoteWebDriver driver;
    private AppiumDriver driver;
    private String status = "failed";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws Exception {
    	
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
         ltOptions.put("w3c", true);
        ltOptions.put("name", "test 1 "+ LocalDate.now());
        ltOptions.put("build", "Alkami Build");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platformName", "android");
        ltOptions.put("platformVersion", "14");
        ltOptions.put("deviceName", "Pixel.*");
        ltOptions.put("app", "lt://APP10160502001720011457970851");
        ltOptions.put("visual",true);
 
         capabilities.setCapability("lt:options", ltOptions);


        try
        {
            driver = new AppiumDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);
            Thread.sleep(30000);

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
        	//WebElement element = driver.findElement(By.id("Perform a tap gesture 5 times to show more environment options."));
        	
//        	WebElement element = driver.findElement(By.xpath("//android.view.View[@content-desc='Perform a tap gesture 5 times to show more environment options.']"));
//            int x = element.getLocation().getX() + (element.getSize().getWidth() / 2);
//            int y = element.getLocation().getY() + (element.getSize().getHeight() / 2);
//
//            // Perform 5 taps on the coordinates
//            TouchAction action = new TouchAction((PerformsTouchActions) driver);
//            for (int i = 0; i < 5; i++) {
//                action.tap(PointOption.point(x, y)).perform();
//                action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))); // Optional: wait between taps
//            }
            
//        	MobileElement element = driver.findElement(By.id("Perform a tap gesture 5 times to show more environment options."));
//        	
//        	TouchAction action = new TouchAction((PerformsTouchActions) driver);
//            for (int i = 0; i < 5; i++) {
//                action.tap(TapOptions.tapOptions().withElement(PointOption.point((element).getCenter()))).perform();
//                action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))); // Optional: wait between taps
//            }

            status="passed";
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
