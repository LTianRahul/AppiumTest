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

public class shymalCulvers {
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
        ltOptions.put("platform", "android");
        ltOptions.put("autoAcceptAlerts", true);
        ltOptions.put("deviceName", "Galaxy.*");//R52W70BK3ZK
        ltOptions.put("app", "lt://APP10160361821722012431173709");
        
//        ltOptions.put("udid", "R52W70BK3ZK");
        

       ltOptions.put("appiumVersion", "2.2.1");
        ltOptions.put("platformVersion", "14");  
       
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
        	
        	
        	driver.findElement(By.xpath("//*[@text=\"CONTINUE AS GUEST\"]")).click();
        	
        	Thread.sleep(2000);
        	
        	driver.findElement(By.xpath("//*[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
        	
        	Thread.sleep(2000);
        	
        	driver.findElement(By.xpath("//*[@content-desc=\"Find A Location\"]")).click();
        	
        	Thread.sleep(1000);
        	
        	driver.findElement(By.xpath("//*[@resource-id=\"locator-modal-search-input\"]")).click();
        	
        	driver.findElement(By.xpath("//*[@resource-id=\"locator-modal-search-input\"]")).sendKeys("sauk city");
        
         	Thread.sleep(1000);
        	
        	driver.findElement(By.xpath("//*[@content-desc=\"Sauk City, WI US\"]")).click();
          	
           

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
