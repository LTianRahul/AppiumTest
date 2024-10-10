package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;
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
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;

public class MohammedCustomer {
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    
 
    private IOSDriver driver;

    
    public String status = "passed";

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws Exception {
    	
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
         ltOptions.put("w3c", true);
        ltOptions.put("name", "test 1 "+ LocalDate.now());
        ltOptions.put("build", "LT build");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platform", "ios");
        ltOptions.put("autoAcceptAlerts", true);
        ltOptions.put("deviceName", "iPhone.*");

//       ltOptions.put("appiumVersion", "2.2.1");
        ltOptions.put("platformVersion", "17");  
       
       // ltOptions.put("resignApp", false); 

     
         capabilities.setCapability("lt:options", ltOptions);


        try
        {
      driver =  new IOSDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);
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
        	
        	
        	driver.findElement(By.id("Create Account")).click();
     	
        	driver.findElement(By.xpath("//*[@name=\"Allow\"]")).click();

        	
        	driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeButton\"]")).click();
        	Thread.sleep(2000);
        	
         	driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeButton\"]")).click();
         	
         	Thread.sleep(2000);
         	
          	driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeButton\"]")).click();
          	Thread.sleep(5000);
          	
          	driver.findElement(By.xpath("//*[@value=\"تسجيل الدخول\"]")).click();
          	
          	Thread.sleep(3000);
          	
          	driver.findElement(By.xpath("//*[@value=\"5xxxxxxx\"]")).click();
        	Thread.sleep(1000);
          	driver.findElement(By.xpath("//*[@value=\"5xxxxxxx\"]")).sendKeys("555555072");
        	Thread.sleep(3000);
        	
        	driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Done']")).click();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("//*[@name=\"متابعة\" and @type=\"XCUIElementTypeButton\"]")).click();
        	Thread.sleep(3000);
        	
        	driver.findElement(By.xpath("//*[@value=\"كلمة المرور\"]")).click();
         	Thread.sleep(1000);
        	driver.findElement(By.xpath("//*[@value=\"كلمة المرور\"]")).sendKeys("123459876@Bb");
        	
        	Thread.sleep(2000);
        	
        	driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Done']")).click();
        	
        	Thread.sleep(5000);
        	
        	driver.findElement(By.xpath("//*[@name=\"دخول\" and @type=\"XCUIElementTypeButton\"]")).click();
        	Thread.sleep(10000);
        	

//          	123459876@Bb
          	
           

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
