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

public class athenaHealth {
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
        ltOptions.put("name", "test 1 "+ LocalDate.now());
        ltOptions.put("build", "athena");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("platformName", "android");
        ltOptions.put("deviceName", "Galaxy.*");
        ltOptions.put("platformVersion", "12");
        ltOptions.put("console",true);
         capabilities.setCapability("lt:options", ltOptions);


        try
        {
            driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
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
        try
        {
//            driver.manage().window().maximize();
            Thread.sleep(15000);
            driver.get("https://www.athenahealth.com/cmp/fax-reporting-form");
            Thread.sleep(25000);

            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
            Thread.sleep(25000);

            driver.findElement(By.id("FirstName")).sendKeys("abc");
            

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll up by a specified pixel value (e.g., -500 pixels)
//            js.executeScript("window.scrollBy(0,300)");

            driver.findElement(By.id("LastName")).sendKeys("abc");
            Thread.sleep(5000);

            driver.findElement(By.id("BusinessName")).sendKeys("abc");
            Thread.sleep(5000);

            driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
            Thread.sleep(5000);
            
          driver.findElement(By.xpath("//*[@id='State']/div")).click();
            
//            WebElement dropdwon_element = driver.findElement(By.xpath("//*[@id='State']/div"));
//            
//            Actions actions = new Actions(driver);
//
//            actions.moveToElement(dropdwon_element).click().perform();
            
           // actions.click(dropdwon_element).perform();

            
            Thread.sleep(5000);
            
           

//           WebElement li= driver.findElement(By.xpath("//*[@id=\"menu-State\"]/div[3]/ul"));
//           
//           actions.moveToElement(li, 1, 1).perform();
//           
//           WebElement li1= driver.findElement(By.xpath("//*[@id=\"menu-State\"]/div[3]/ul/li[12]"));
//           
//           actions.moveToElement(li1, 1, 1).perform();
//           
//           li1.click();
           
//           li.sendKeys(Keys.DOWN);
//           li.sendKeys(Keys.RETURN);
//            li.sendKeys("Colorado");
//            li.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
 
            
//            driver.findElement(By.xpath("//*[@id='State']/div")).click();
//            Thread.sleep(1000);
//            
//            //MuiPaper-root MuiMenu-paper MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper css-pwxzbm
//            
//            WebElement m = driver.findElement(By.cssSelector(".MuiPaper-root.MuiMenu-paper.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-pwxzbm"));
//            Thread.sleep(3000);
//            
//           m.findElement(By.xpath("//*[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[2]")).click();
//            
////            m.sendKeys("Delaware");
////            
////            m.sendKeys(Keys.ENTER);
//            
            
            
//            driver.findElement(By.xpath("//*[text()='Colorado']")).click();
            
            ////*[@label='Select State']

//            driver.findElement(By.id("State")).click();
//            driver.findElement(By.name("State")).sendKeys("AL");
//            Thread.sleep(5000);

          //  dropdown.click();



//            Select l = new Select(driver.findElementByName("State"));
//            System.out.println("_____________________" + l.getOptions());
//
//            l.selectByValue("Colorado");
////            driver.findElement(By.name("State")).click();
//            Thread.sleep(5000);

//            driver.findElement(By.xpath("//*[@id=\"menu-State\"]/div[3]/ul/li[7]")).click();
//            Thread.sleep(5000);

//
            driver.findElement(By.id("phone")).sendKeys("1235678876");
            Thread.sleep(5000);
//
//            driver.findElement(By.id("fax")).click();
//            Thread.sleep(5000);

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
//
//            driver.findElement(By.id("Ireceivedafaxforsomeonewho")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.xpath("/html/body/div[11]/div[3]/ul/li[7]")).click();
//            Thread.sleep(5000);

//            driver.findElement(By.id("g_cta_ah__0_0 SubmitButton")).click();
//            Thread.sleep(5000);

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
     
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        
    }
}
