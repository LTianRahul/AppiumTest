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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class positiveo {
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

        // ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
//        ltOptions.put("name", "test 1 "+ LocalDate.now());
         ltOptions.put("name", "test 1 " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ltOptions.put("build", "FitnessSyncer_latest");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platformName", "fireos");
//        ltOptions.put("privateCloud", true);
//        ltOptions.put("udid", "23011FDF6000KF");
       // ltOptions.put("passcode", "27946132");// for android it would be 8 digits length and for iOS it would be of 6 digits.
       // ltOptions.put("appiumVersion", "2.0.0");
        ltOptions.put("deviceName", "Amazon Fire TV Stick");
//        ltOptions.put("autoAcceptAlerts", false);
//        ltOptions.put("appProfiling", false);
//        ltOptions.put("network", false);
//        ltOptions.put("deviceOrientation", "LANDSCAPE");
       // ltOptions.put("dedicatedProxy", true);
        ltOptions.put("platformVersion", "7");  //lt://APP10160601511703202882836940
        ltOptions.put("app", "lt://APP10160502001722536819407906"); 
//        ltOptions.put("console",true);
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
        	
        	Thread.sleep(5000);
        	
        	
        	
        	
//        	driver.findElement(By.id("com.stockx.stockx.debug:id/loginButton")).sendKeys("Test");
//        	Thread.sleep(5000);
//        	driver.findElement(By.xpath("")).click();
//        	
//        	driver.findElement(By.xpath("//*[@text=\"Email\\nE-mail\"]")).sendKeys("Rahul");

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
