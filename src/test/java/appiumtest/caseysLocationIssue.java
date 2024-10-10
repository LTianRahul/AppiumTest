package appiumtest;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;

public class caseysLocationIssue {
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    //private RemoteWebDriver driver;
    private AndroidDriver driver;
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
//        ltOptions.put("geoLocation", "US");
   // ltOptions.put("region", "US");
        ltOptions.put("platformVersion", "13");
//        ltOptions.put("appiumVersion", "1.22.3");
//        ltOptions.put("privateCloud", true);
        ltOptions.put("app", "lt://APP10160492431717404631765267");
//        ltOptions.put("noReset", true);
//        ltOptions.put("fullReset", false);
        ltOptions.put("deviceName", "Pixel.*");

//        ltOptions.put("app", "stock");
//        ltOptions.put("appPackage", "com.caseys.appdev");
//        ltOptions.put("appActivity", "com.caseys.commerce.activity.MainActivity");
        ltOptions.put("visual",true);
 
         capabilities.setCapability("lt:options", ltOptions);


        try
        {
            driver = new AndroidDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);
            Thread.sleep(3000);

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
        	
        	//driver.startActivity("com.caseys.appdev", "com.caseys.commerce.activity.MainActivity");
        	
        	//((StartsActivity) driver).startActivity(new Activity("com.caseys.appdev", "com.caseys.commerce.activity.MainActivity"));
        	//driver.findElement(By.xpath("//*[@resource-id=\"android:id/button1\"]")).click();
        	
        	Thread.sleep(50000);
        	
//        	driver.findElement(By.xpath("//*[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//        	
//        	Thread.sleep(4000);
        	
        	//driver.findElement(By.xpath("//*[@text=\"Account\"]")).click();
        	
        	Thread.sleep(3000);
        	
        	SessionId sessionID= driver.getSessionId();   
        	
        	System.out.println("sessionID is "+sessionID);
        	
        	driver.findElement(By.xpath("//*[@resource-id=\"com.caseys.appdev:id/my_profile_sign_in_btn\"]")).click();
        	
        	Thread.sleep(40000);
        	
        	//driver.findElement(By.xpath("//*[@class=\"android.widget.CheckBox\"]")).click();
        	
        	//Thread.sleep(10000);
        	
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
