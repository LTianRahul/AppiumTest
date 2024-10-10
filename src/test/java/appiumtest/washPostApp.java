package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.URL;


public class washPostApp {

	AppiumDriver driver;
	
    public static String userName = "rahulkumarlambdatest"; //Enter your LT Username here
    public static String accessKey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6"; //Enter your LT AccessKey here

   
    @Test
    public void AndroidApp() {
        try {
           
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
           ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Pixel 8 Pro");
            ltOptions.put("region", "eu");
            ltOptions.put("platformVersion", "14");
           ltOptions.put("app", "lt://APP10160251801717625093074278");
            ltOptions.put("build", "washpost build");
            ltOptions.put("name", "washpost name");
            ltOptions.put("isRealMobile", true);

            capabilities.setCapability("lt:options", ltOptions);

          
          driver = new AppiumDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);

            System.out.println("App started on device......");
          
            Thread.sleep(3000);
            
            driver.findElement(By.xpath("//*[@resource-id=\"com.washingtonpost.android:id/maybe_later\"]")).click();
            
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@content-desc=\"Section menu\"]")).click();
            Thread.sleep(15000);
            
       
            driver.executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"passing this as there was not error \"}} ");

		
        } catch (Exception t) {
            System.out.println();

        }


    }
	@AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
//    @AfterTest
//    public void tearDown() {
//    	driver.quit();
//    }
}