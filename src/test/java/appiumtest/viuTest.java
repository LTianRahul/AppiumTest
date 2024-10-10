package appiumtest;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class viuTest {
    String username = "badoyap845";
    String authkey = "MC54HMiu6YhWTbnOZo1z9fKb6YJ9lWMDHBEFiLBTDguTBwDl6h";
    //private RemoteWebDriver driver;
    private AppiumDriver driver;
    private String status = "failed";

    public String gridURL = "@hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws Exception {
    	
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
         ltOptions.put("w3c", true);
        ltOptions.put("name", "test 1 "+ LocalDate.now());
        ltOptions.put("build", "Viu");
        ltOptions.put("platformName", "macOS Sonoma");
        ltOptions.put("browserName", "Safari");
        ltOptions.put("geoLocation", "HK");
        ltOptions.put("browserVersion", "17.0");
        ltOptions.put("console",true);
        ltOptions.put("idleTimeout","1000"); 
      // ltOptions.put("fixedIP","10.242.33.52"); //   10.242.33.52 // 10.242.32.28 
      
        
        ltOptions.put("network",true);
         capabilities.setCapability("LT:options", ltOptions);//bmpui-id-124


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

        
            driver.get("https://qaauto.ottuat.com/ott/hk/en-us/");
            
//            Thread.sleep(3000);
//            
//            driver.switchTo().frame(1);
//            
//            driver.findElement(By.id("close"));
//            Thread.sleep(2000);
           WebElement element =  driver.findElement(By.id("guest_login_btn"));
            
            Actions actions = new Actions(driver);


            actions.moveToElement(element).build().perform();
           // Thread.sleep(1000);
            
            driver.findElement(By.xpath("//*[contains(text(),'Register for Free')]")).click();
            
            Thread.sleep(15000);
            
           // driver.findElement(By.xpath("//*[@class='signInSubtitle']/span")).click(); //login-logInHereLink
            
           // driver.findElement(By.cssSelector("#login-logInHereLink")).click();  
            
            //Printing the total no of iFrame
            List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
            System.out.println("Total number of iframes are " + iframeElements.size());
            
            Thread.sleep(1000);
            
            WebElement iframeElement = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/iframe"));
            
            driver.switchTo().frame(iframeElement);  //div[@class='css-y3elvi']//iframe
            
//            System.out.println(driver.switchTo().frame(1));
            
            Thread.sleep(10000);
          
//           WebElement element1 =  driver.findElement(By.cssSelector(".mainArea"));
            //*[@class='signInSubtitle']/span
          
//            actions.moveToElement(element1).build().perform();
            
            driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div[2]/span")).click();
            
            Thread.sleep(1000);
            
            driver.findElement(By.id("emailLogin-inputEmailField")).click();
            
            driver.findElement(By.id("emailLogin-inputEmailField")).sendKeys("webhkfree001@viu.com");
            
            Thread.sleep(2000);
            
            
            driver.findElement(By.id("emailLogin-inputPasswordField")).click();
            
            driver.findElement(By.id("emailLogin-inputPasswordField")).sendKeys("000000");
            
            Thread.sleep(1000);
            
            driver.findElement(By.id("emailLogin-loginButton")).click();
            
            driver.switchTo().defaultContent();
            
      Thread.sleep(5000);

      WebElement element1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div/div/div[1]/div[2]/div[1]/div/div[1]/div/a/div/div[1]/div[2]"));
    
     // actions.moveToElement(element1).build().perform();    
      
     
      
      Thread.sleep(5000);// /html/body/div[1]/main/div[2]/div[3]/div/div/div[1]/div[2]/div[1]/div/div[1]/div/a/div
      element1.click();
     // Thread.sleep(10000);
      
   // WebElement adMessage =  driver.findElement(By.xpath("//*[@id='bmpui-id-180']")); // //*[@id="bmpui-id-180"]
    
   
//    System.out.println("visible"+adMessage.isDisplayed());  
    
    Thread.sleep(120000);
    
    
//  WebElement adMessage =  driver.findElement(By.xpath("//*[@id='bmpui-id-180']")); // //*[@id="bmpui-id-180"]
//  
//  System.out.println("visible"+adMessage.isDisplayed());  
  
//            status="passed";
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
     
//            driver.executeScript("lambda-status=" + status);
            driver.quit();
        
    }
}

