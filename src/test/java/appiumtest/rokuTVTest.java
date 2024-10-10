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
import java.util.HashMap;

public class rokuTVTest {
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    //private RemoteWebDriver driver;
     AppiumDriver driver;

   // public String gridURL = "@mobile-hub-internal.lambdatest.com/wd/hub";
    
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws Exception {
    	
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//         ltOptions.put("w3c", true);

        // ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
        ltOptions.put("name", "test 1");
        ltOptions.put("build", "Apple build");
        ltOptions.put("isRealMobile", true);
//        ltOptions.put("platformName", "roku");
//        ltOptions.put("deviceName", "Roku Express");
//
//        ltOptions.put("platformVersion", "11");  //lt://APP10160601511703202882836940
       // ltOptions.put("app", "lt://APP1016053741710863919537546");  //Tel- lt://APP1016059581713029607224644

        //for AppleTV
        ltOptions.put("platformName", "tvos");
        ltOptions.put("deviceName", "Apple TV");
        ltOptions.put("platformVersion", "16"); 
        ltOptions.put("app", "lt://APP1016059581713029607224644");
         capabilities.setCapability("lt:options", ltOptions);
         


        try
        {
            driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
            Thread.sleep(50000);

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
        driver.findElement(By.xpath("//*[@id='test']"));
    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
