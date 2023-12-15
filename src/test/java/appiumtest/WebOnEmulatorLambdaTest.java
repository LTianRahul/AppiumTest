package appiumtest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebOnEmulatorLambdaTest {



    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "rahulkumarlambdatest" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
//        ltOptions.put("platformName", "ios");
//        ltOptions.put("deviceName", "iPhone 11");
//        ltOptions.put("platformVersion", "13.0");
        ltOptions.put("platformName", "Android");
        ltOptions.put("deviceName", "Galaxy S23");
        ltOptions.put("platformVersion", "14");
        //ltOptions.put("browserName", "Chrome");
        ltOptions.put("build", "debug");
        ltOptions.put("user","rahulkumarlambdatest");
        ltOptions.put("visual", true);
        //ltOptions.put("appiumVersion", "1.22.3");
        ltOptions.put("accessKey", "dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6");
        // ltOptions.put("name", platform+" "+device+" "+version);
        //`ltOptions.put("isRealMobile", true);
      //  ltOptions.put("region", "eu");
//        Map<String, String> map = new HashMap();
//        map.put("was-secret", "ey1adigppewebmob");
//        ltOptions.put("customHeaders",map);
        capabilities.setCapability("LT:Options", ltOptions);
//
//        String gridUrl = "@mobile-hub.lambdatest.com/wd/hub";
//        String hub = "https://" + userName + ":" + accessKey + gridURL;

        driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @Test
    public void basicTest() throws InterruptedException {
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.get("https://lambdatest.github.io/sample-todo-app/");

        System.out.println("Checking Box");
        driver.findElement(By.name("li1")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li2")).click();

        System.out.println("Checking Box");
        driver.findElement(By.name("li3")).click();

        System.out.println("Checking Another Box");
        driver.findElement(By.name("li4")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
        driver.findElement(By.id("addbutton")).click();

        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
        driver.findElement(By.id("addbutton")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}