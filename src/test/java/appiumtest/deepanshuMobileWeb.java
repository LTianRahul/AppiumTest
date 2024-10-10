package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.HashMap;

public class deepanshuMobileWeb {

    public static AppiumDriver driverMobile = null;
    public static RemoteWebDriver driverWeb = null;

    public String gridMobile = "@mobile-hub.lambdatest.com/wd/hub";
    public String gridWeb = "@hub.lambdatest.com/wd/hub";

    public String status = "passed";
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";

//    DesiredCapabilities capabilities2 = new DesiredCapabilities();
    @BeforeTest
    public void setUp() throws Exception {

    	
    	ChromeOptions  capabilitiesWeb = new ChromeOptions();
		// browserOptions.addArguments("--headless");
    	capabilitiesWeb.setPlatformName("Windows 11");
    	capabilitiesWeb.setBrowserVersion("dev");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		//ltOptions.put("network", true);
		ltOptions.put("headless", false);
	      ltOptions.put("name", "web");
	       ltOptions.put("build", "Sample Web");

		capabilitiesWeb.setCapability("LT:Options", ltOptions);
		
//        DesiredCapabilities capabilitiesWeb = new DesiredCapabilities();
//        capabilitiesWeb.setCapability("build", "sample web");
//        capabilitiesWeb.setCapability("name", "web");
//       // capabilitiesWeb.setCapability("network", true);
//        capabilitiesWeb.setCapability("platformName", "Windows 11");
//        capabilitiesWeb.setCapability("browser", "chrome");
//        capabilitiesWeb.setCapability("browserVersion", "latest");
//        capabilitiesWeb.setCapability("visual",true);

        
//        DesiredCapabilities capabilitiesMobile = new DesiredCapabilities();
//        HashMap<String, Object> ltOptions1 = new HashMap<String, Object>();
//        ltOptions1.put("w3c", true);
//
//       // ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
//       ltOptions1.put("name", "mobile");
//       ltOptions1.put("build", "Sample Mobile");
//       ltOptions1.put("isRealMobile", true);
//       ltOptions1.put("platformName", "android");
//       ltOptions1.put("deviceName", "Galaxy.*");
//       ltOptions1.put("platformVersion", "12");
//       ltOptions1.put("console",true);
//       ltOptions1.put("app","lt://APP1016059581713243543685477");
//       capabilitiesMobile.setCapability("LT:options", ltOptions);
        
        DesiredCapabilities capabilitiesMobile = new DesiredCapabilities();
        capabilitiesMobile.setCapability("build", "sample mobile");
        capabilitiesMobile.setCapability("name", "mobile");
        capabilitiesMobile.setCapability("isRealMobile", true);
        //capabilitiesMobile.setCapability("network", true);
        capabilitiesMobile.setCapability("platformName", "android");
        capabilitiesMobile.setCapability("deviceName", "Pixel.*");
        capabilitiesMobile.setCapability("platformVersion", "13");
        capabilitiesMobile.setCapability("visual",true);
        capabilitiesMobile.setCapability("app","lt://APP1016059581713243543685477"); //for android proverbial


        try
        {
            driverWeb = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridWeb), capabilitiesWeb);
            Thread.sleep(5000);
            driverMobile = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridMobile), capabilitiesMobile);

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
           driverWeb.get("https://www.google.com");
           Thread.sleep(30000);

           driverMobile.findElement(By.id("Text")).click();
            Thread.sleep(5000);
            driverMobile.navigate().back();
            driverMobile.close();
           // driverMobile.terminateApp("proverbial");

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
        if (driverMobile != null)
        {
        	driverMobile.executeScript("lambda-status=" + status);
        	driverMobile.quit();
        }
    }
}





















