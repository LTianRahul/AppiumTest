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


public class AndroidApponLT {

	AppiumDriver driver;
	
    public static String userName = "rahulkumarlambdatest"; //Enter your LT Username here
    public static String accessKey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6"; //Enter your LT AccessKey here

    //public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    String DeviceValue;
    String versionValue;
    String PlatformValue;
    
    


    
	@org.testng.annotations.Parameters(value = {"device", "version", "platform"})
    @Test
    public void AndroidApp(String device, String version, String platform) {
        try {
            DeviceValue = device;
            versionValue = version;
            PlatformValue = platform;

            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
           ltOptions.put("platformName", PlatformValue);
            ltOptions.put("deviceName", DeviceValue);
            ltOptions.put("platformVersion", versionValue);
           ltOptions.put("app", "lt://APP10160631101687366258894337");
           //capabilities.setCapability("privateCloud", true);
           // ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
            ltOptions.put("build", "AppiumBuildRahulTestNA1");
            ltOptions.put("name", "AppiumTestRahulTestNA");
            ltOptions.put("appProfiling", true);
            ltOptions.put("isRealMobile", false);
            ltOptions.put("project", "AppiumProjectRahulTestNA1");

            capabilities.setCapability("lt:options", ltOptions);

//            String hub = "https://" + userName + ":" + accessKey + gridURL;
//            AppiumDriver driver = new AppiumDriver(new URL(hub), capabilities);
          
          driver = new AppiumDriver(new URL("https://" +userName +":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);

            System.out.println("App started on device......");
          
          //driver.get("https://www.lambdatest.com");
			
          Thread.sleep(3000);
		driver.findElement(By.id("com.example.onclicklisteners:id/firstWay")).click();
            
         // driver.get("https://www.lambdatest.com");
////
////
//		Thread.sleep(3000);
////		
//		driver.findElement(By.id("com.example.onclicklisteners:id/firstWay")).click();
////		
//Thread.sleep(3000);
////		
//		driver.findElement(By.id("com.example.onclicklisteners:id/second")).click();
////		
//Thread.sleep(3000);
////		
//		driver.findElement(By.id("com.example.onclicklisteners:id/second")).click();
////		
//Thread.sleep(3000);
////		
//		driver.findElement(By.id("com.example.onclicklisteners:id/secondWay")).click();
//Thread.sleep(3000);
////		
//		driver.findElement(By.id("com.example.onclicklisteners:id/thirdWay")).click();
//		
//		Thread.sleep(5000);
		
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