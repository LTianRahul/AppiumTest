package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;

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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

public class fitnessSyncer {
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    
    //https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub
    //private RemoteWebDriver driver;
    private AppiumDriver driver;
  //  private String status = "failed";
    
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
        ltOptions.put("platform", "android");
    //   ltOptions.put("appiumVersion", "2.3.0"); //
        //ltOptions.put("udid", "00008110000E5C212E52801E");
        ltOptions.put("deviceName", "Pixel 6");
//        ltOptions.put("minorOSVersionEnabled", true);
//        ltOptions.put("region", "eu");
       // ltOptions.put("automationName", "flutter");
       // ltOptions.put("resignApp", false);
        ltOptions.put("platformVersion", "13");  //autoDismissAlerts
//        ltOptions.put("autoDismissAlerts", false);
//        ltOptions.put("autoAcceptAlerts", false);
//        ltOptions.put("autoGrantPermissions", false);
  //      ltOptions.put("deviceOrientation", "portrait");
        ltOptions.put("appProfiling", true);
        ltOptions.put("network", true);
        ltOptions.put("network.har", true);
        ltOptions.put("network.full.har", true);
       
       // ltOptions.put("resignApp", false); 
        ltOptions.put("app", "stock"); //wiki apk 
        ltOptions.put("privateCloud", "true");
//        ltOptions.put("appium:locale", "GB"); //appium:language
//        ltOptions.put("appium:language", "en"); //appium:language
      //  ltOptions.put("appium:timezone", "UTC+0000");
      //  ltOptions.put("appium:automationName", "UIAutomator2");\
        
//        ltOptions.put("autoLaunch", true); 
      //  ltOptions.put("--relaxed-security", "true"); 
        
        //"--log-level": "debug",
       // "--relaxed-security": true,
        
        //For public device
//        ltOptions.put("autoAcceptAlerts", false);
//        ltOptions.put("app", "lt://APP10160601511707226417347195"); // for single app pass stock 
//        ltOptions.put("console",true);
        
 
  
        
        //For private cloud device
        // for ios APP10160601541707490914052529
      //  ltOptions.put("udid", "23011FDF6000KF");
//        ltOptions.put("privateCloud", "true");
//        ltOptions.put("appPackage", "com.stockx.stockx.debug");
//        ltOptions.put("appActivity", "com.stockx.stockx.ui.activity.MainActivity");
        
     
         capabilities.setCapability("lt:options", ltOptions);
         
        


        try
        {
      driver =  new AppiumDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);
            Thread.sleep(10000);
            driver.executeScript("lambda-uninstall-app=org.wikipedia.alpha");
////            
        Thread.sleep(5000);
////           
            driver.executeScript("lambda-install-app=lt://APP10160492431717404631765267"); // proverbial apk
//            
////            ((Object) driver).launchApp();//package id - org.wikipedia.alpha //activity - org.wikipedia.main.MainActivity
//            
            Thread.sleep(5000);
//            
////            driver.terminateApp("com.apple.Preferences");
//            ((InteractsWithApps) driver).activateApp("com.resideo.inhouse");
            
            ((StartsActivity) driver).startActivity(new Activity("com.lambdatest.proverbial", "com.lambdatest.proverbial.MainActivity")); //Would 
            //need AndroidDriver as a driver initialisation

          //Pass App Package and App Activity
//            Activity appActivity = new Activity("com.lambdatest.proverbial", "com.lambdatest.proverbial.MainActivity");
//
//            ((StartsActivity) driver).startActivity(appActivity);
 
//            Thread.sleep(2000);
            
       //   System.out.println(driver.getPageSource());
            
         

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
     	
//        	  Activity appActivity = new Activity("com.lambdatest.proverbial", "com.lambdatest.proverbial.MainActivity");
//
//              ((StartsActivity) driver).startActivity(appActivity);
        	
        	//((InteractsWithApps) driver).activateApp("com.resideo.inhouse");
        	
        	//For android
        	driver.findElement(By.xpath("//*[@class=\"android.widget.FrameLayout\" and ./parent::*[@resource-id=\"com.stockx.stockx.debug:id/nav_account\"]]")).click();
        	
        	//For iOS
//        driver.findElement(By.xpath("//*[@value=\"User Id\"]")).click();
//        
//        driver.findElement(By.xpath("//*[@value=\"User Id\"]")).sendKeys("Amit");
        
        Thread.sleep(5000);
        
        //((JavascriptExecutor) driver).executeScript("lambda-exceptions", exceptionCapture);
        	
//        	driver.get("https://www.lambdatest.com");
//        	
//        	Thread.sleep(50000);
//        	
//        	driver.get("https://www.lambdatest.com");
        	
    

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
