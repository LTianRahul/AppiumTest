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

public class AllegoiOSAppTest {
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
        ltOptions.put("app", "lt://APP10160352241719505276531498"); //1315
     
         capabilities.setCapability("lt:options", ltOptions);


        try
        {
      driver =  new IOSDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);
            Thread.sleep(5000);
//            driver.executeScript("lambda-uninstall-app=org.wikipedia.alpha");

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
     	
        	// Find the Username field and enter the username
            WebElement usernameField = driver.findElement(By.xpath("//*[@name=\"login_User name\"]"));
            usernameField.sendKeys("automateduser_52519_1719854405323_345y@dev");

            // Wait for 3 seconds
            Thread.sleep(2000);

            // Find the Password field and click on it
            WebElement passwordField = driver.findElement(By.xpath("//*[@name=\"login_Password\"]"));
            passwordField.click();

            // Wait for 3 seconds
            Thread.sleep(2000);

            // Enter the password in the Password field
            passwordField.sendKeys("password1719854405322");
            Thread.sleep(2000);
            // Find the Login button and click on it
            WebElement loginButton = driver.findElement(By.xpath("//*[@name=\"login_Log in\"]"));
            loginButton.click();

            // Wait for 20 seconds
            Thread.sleep(2000);
            
//            driver.findElement(By.xpath("//*[@name=\"Allow\"]")).click();
//            
//            Thread.sleep(1000);
            
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[3]")).click();
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[3]")).sendKeys("9");
//            
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[4]")).click();
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[4]")).sendKeys("9");
//
//            
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[5]")).click();
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[5]")).sendKeys("3");
//            
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[6]")).click();
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[6]")).sendKeys("4");
//            
//            Thread.sleep(3000);
//            
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[3]")).click();
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[3]")).sendKeys("9");
//            
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[4]")).click();
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[4]")).sendKeys("9");
//
//            
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[5]")).click();
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[5]")).sendKeys("3");
//            
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[6]")).click();
//            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeWindow\"]/*[2]/*[@type=\"XCUIElementTypeOther\"]/*[6]")).sendKeys("4");
            
          //*[@type="XCUIElementTypeWindow"]/*[2]/*[@type="XCUIElementTypeOther"]/*[3]
            
          //  Thread.sleep(3000);

            // Send app in background
//            ((org.openqa.selenium.remote.RemoteWebDriver) driver).executeScript("mobile: backgroundApp", -1);

            driver.runAppInBackground(Duration.ofSeconds(-1));
            // Wait for 10 seconds
            Thread.sleep(10000);

            System.out.println("Install new app");

            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put("appUrl", "lt://APP1016016161719505178003351");
            data.put("retainData", "true");

            ((org.openqa.selenium.remote.RemoteWebDriver) driver).executeScript("lambda-install-app", data);

            // Wait for 10 seconds
            Thread.sleep(10000);

            // Activate the app
           // ((org.openqa.selenium.remote.RemoteWebDriver) driver).executeScript("mobile: activateApp", "com.allego.ios.AllegoDemo");

            driver.activateApp("com.allego.ios.AllegoDemo");
            
            // Wait for 40 seconds
            Thread.sleep(10000);
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
