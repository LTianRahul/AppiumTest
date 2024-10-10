package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
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

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class visualRD {
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    String screenshotName = "build1";
    int pageCount;
    //private RemoteWebDriver driver;
    private static AppiumDriver driver;
    private String status = "failed";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String timestamp = LocalDateTime.now().format(formatter);
    String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8); // generates an 8 character alphanumeric string



    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws Exception {
    	
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
         ltOptions.put("w3c", true);

  
        ltOptions.put("name", "test 1 "+ LocalDate.now());
        ltOptions.put("build", "SmartUI RD");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platformName", "android");
        ltOptions.put("platformVersion", "11");
        ltOptions.put("deviceName", "Galaxy S21 5G");
        ltOptions.put("autoAcceptAlerts", false);
        ltOptions.put("appProfiling", true);
   
        ltOptions.put("network.har", true);
        ltOptions.put("network.har.full", true);
        ltOptions.put("app", "lt://APP10160251801717414173808635");
        
 
        ltOptions.put("console",true);
        
        ltOptions.put("smartUI.project", "smartUI-05thSept2024"); // Replace the name of project with the new project name (Mandatory)
        ltOptions.put("smartUI.build", "build5");
        ltOptions.put("smartUI.basline", false); 
       // ltOptions.put("smartUI.build", "smartUI " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      //  ltOptions.put("smartUI.build", "smartUI " + randomString + " Sample " + timestamp);
        capabilities.setCapability("lt:options", ltOptions);


        try
        {
            driver = new AppiumDriver(new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"), capabilities);
   

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
//        	driver.executeScript("lambda:network"); 
        	//takeScreenshotFullPage(screenshotName);
        	//driver.findElement(null)
      
//        	Map<String, Object> config = new HashMap<>();
//        	config.put("screenshotName", "build1");
//        	config.put("fullPage", true);
//        	config.put("pageCount", 15); // Enter the number of pages for the Full Page screenshot (Minimum 1, Maximum 20)
//        	((JavascriptExecutor)driver).executeScript("smartui.takeScreenshot", config);
        	
        	Thread.sleep(3000);
//        	
        	((AppiumDriver)driver).executeScript("smartui.takeScreenshot=Pic1");
        	

        	
        Thread.sleep(5000);
   

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
    
//    public static void takeScreenshotFullPage(String screenshotName) {
//        Map<String, Object> config = new HashMap<>();
//        config.put("screenshotName", screenshotName);
//        config.put("fullPage", true);
//       //     pageCount); // Enter the number of pages for the Full Page screenshot (Minimum 1, Maximum
//        // 20)
//      
//        ((JavascriptExecutor) driver).executeScript("smartui.takeScreenshot", config);
//      }
}
