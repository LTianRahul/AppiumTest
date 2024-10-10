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

public class footLockerExecutionTime {
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    private AppiumDriver driver;
    private String status = "failed";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws Exception {
    	
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
         ltOptions.put("w3c", true);
        ltOptions.put("name", "test 1 "+ LocalDate.now());
        ltOptions.put("build", "footlocker Build");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platformName", "ios");
        ltOptions.put("platformVersion", "17"); 
        ltOptions.put("deviceName", "iPhone.1.*");
        ltOptions.put("appProfiling", true);
        //ltOptions.put("region", "US");
        ltOptions.put("visual", true);
        ltOptions.put("network", true);
//        ltOptions.put("network.har", true);
//        ltOptions.put("network.full.har", true);
       // ltOptions.put("deviceName", "Pixel.*");
        ltOptions.put("app", "lt://APP10160542501728503142931434");
       // ltOptions.put("visual",true);
 
         capabilities.setCapability("lt:options", ltOptions);


        try
        {
            driver = new AppiumDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);
//            Thread.sleep(30000);

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
        	
        	driver.findElement(By.xpath("//*[@resource-id=\"com.footlocker.approved:id/btn_skip\"]")).click();
        	
        	driver.findElement(By.xpath("//*[@resource-id=\"com.footlocker.approved:id/btn_guest\"]")).click();
        	
        	Thread.sleep(1000);
        	
        	driver.findElement(By.xpath("//*[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
        	
        	
        	
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
