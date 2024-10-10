package appiumtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeppanshuCustomer {

	String username = "rahulkumarlambdatest";
    String authkey = "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6";
    private WebDriver driver;
    private String status = "failed";

    public String gridURL = "@hub.lambdatest.com/wd/hub";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", false);
        ltOptions.put("build", "Xpath Issue");
       // ltOptions.put("PageLoadStrategy", "eager");
        ltOptions.put("browserName", "chrome");
        ltOptions.put("platformName", "win 10");
        ltOptions.put("browserVersion", "118");
       // ltOptions.put("selenium_version", "4.13.0");
        ltOptions.put("visual", true);
        ltOptions.put("console", true);
//        ltOptions.put("tunnel", true);
       // ltOptions.put("mitm", true);
//        ltOptions.put("performance", true);
        capabilities.setCapability("lt:options", ltOptions);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
    }

    @Test
    public void testAdsDetails() throws InterruptedException {
        driver.get("https://WebUser:9v3n4rA8+N@preprod.medimerck.sk/sk/login/splash-page.html");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"signInName\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"signInName\"]")).sendKeys("joaquin.86@falkcia.com");
        
        driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Merck@1234");
//        driver.findElement(By.cssSelector(".fc-footer-buttons button p")).click();
//        Thread.sleep(30000);
        
        driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
        
        Thread.sleep(8000);
        
        driver.findElement(By.xpath("//*[@class='cmp-adv-cookie--disclaimer__controls']/div[1]/a[1]")).click();
        
        Thread.sleep(2000);
        
       driver.findElement(By.xpath("//*[@class='cmp-navigation__extralinks']/ul/li[2]")).click();
       
       Thread.sleep(1000);
       
       driver.findElement(By.xpath("//*[@class='text']/div/ul/li[2]/a")).click();
       
       
       Thread.sleep(15000);
        
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            // driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
    
}
