package appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

public class atehnaHealthWeb {
    String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    private RemoteWebDriver driver;
    private String status = "failed";

    public String gridURL = "@hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws Exception {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("name", "test 1 "+ LocalDate.now());
//        capabilities.setCapability("build", "athena");
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("platformName", "Windows 11");
//        capabilities.setCapability("browserVersion", "115.0");
//        capabilities.setCapability("visual",true);
//        capabilities.setCapability("console",true);
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);

       // ltOptions.put(MobileCapabilityType.BROWSER_NAME, "chrome");
       // ltOptions.put("name", "test 1 "+ LocalDate.now());
        ltOptions.put("build", "athena");
        ltOptions.put("browserName", "chrome");
        ltOptions.put("platformName", "macOS Sonoma");
        ltOptions.put("browserVersion", "123.0");
//        ltOptions.put("selenium_version", "4.13.0");
        ltOptions.put("visual",true);
        ltOptions.put("console",true);
        ltOptions.put("selenium_version","latest");
        ltOptions.put("performance", true);
        ltOptions.put("network", true);
        ltOptions.put("network.har", true);
        ltOptions.put("network.full.har", true);
       // ltOptions.put("video",false);
        capabilities.setCapability("lt:options", ltOptions);



        try
        {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
            Thread.sleep(5000);

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
    	((JavascriptExecutor)driver).executeScript("lambda-name=TestName");
    	
        try
        {
        	
        
//            driver.manage().window().maximize();
            Thread.sleep(15000);
            driver.get("https://www.athenahealth.com/cmp/fax-reporting-form");
            Thread.sleep(15000);

            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
            Thread.sleep(5000);

            driver.findElement(By.id("FirstName")).sendKeys("abc");
            Thread.sleep(15000);
            

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll up by a specified pixel value (e.g., -500 pixels)
//            js.executeScript("window.scrollBy(0,300)");

            driver.findElement(By.id("LastName")).sendKeys("abc");
            Thread.sleep(5000);

            driver.findElement(By.id("BusinessName")).sendKeys("abc");
            Thread.sleep(5000);

            driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
            Thread.sleep(5000);
            
            driver.findElement(By.id("State")).click();
            
            Thread.sleep(5000);
            
            Actions actions = new Actions(driver);

           WebElement li= driver.findElement(By.xpath("//*[@id=\"menu-State\"]/div[3]/ul"));
           
           actions.moveToElement(li, 1, 1).perform();
           
           WebElement li1= driver.findElement(By.xpath("//*[@id=\"menu-State\"]/div[3]/ul/li[12]"));
           
           actions.moveToElement(li1, 1, 1).perform();
           
           li1.click();
           
//           li.sendKeys(Keys.DOWN);
//           li.sendKeys(Keys.RETURN);
//            li.sendKeys("Colorado");
//            li.sendKeys(Keys.ENTER);
            Thread.sleep(5000);

            
           // driver.findElement(By.xpath("//*[@id=\"menu-State\"]/div[3]")).click();

            driver.findElement(By.id("phone")).sendKeys("1235678876");
            Thread.sleep(5000);

            driver.findElement(By.id("fax")).click();
            Thread.sleep(5000);




//            Select l = new Select(driver.findElementByName("State"));
//            System.out.println("_____________________" + l.getOptions());
//
//            l.selectByValue("Colorado");
////            driver.findElement(By.name("State")).click();
//            Thread.sleep(5000);

//            driver.findElement(By.xpath("//*[@id=\"menu-State\"]/div[3]/ul/li[7]")).click();
//            Thread.sleep(5000);

//
//            driver.findElement(By.id("DateReceived")).click();
//            Thread.sleep(5000);

//            driver.findElement(By.id("DocumentID")).sendKeys("abc");
//            Thread.sleep(5000);
//
//            driver.findElement(By.id("CallBackNumber")).sendKeys("1234567987");
//            Thread.sleep(5000);
//
//
//            driver.findElement(By.id("Ireceivedafaxforsomeonewho")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.xpath("/html/body/div[11]/div[3]/ul/li[4]")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.id("IssueDescription")).click();
//            Thread.sleep(5000);
////
//            driver.findElement(By.id("Ireceivedafaxforsomeonewho")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.xpath("/html/body/div[11]/div[3]/ul/li[7]")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.id("g_cta_ah__0_0 SubmitButton")).click();
//            Thread.sleep(5000);
            driver.executeScript("lambda:network");
            status="passed";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            status="failed";
        }
    }
   
    @AfterTest
    public void tearDown(ITestResult result) throws Exception
    {
        if (driver != null)
        {
           // driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}