package appiumtest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import org.junit.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class mmtsocket {
    String username = "deepanshulambdatest";
    String authkey = "vvI4dCayA0O65Pzpj2mUqdOtwPIYfVlpEnX3OQtzLJDgQdAJME";
    private AppiumDriver driver;
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    public String status = "passed";

    @BeforeMethod
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("build", "mmt new");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("name", "international+socket");
        ltOptions.put("platformName", "ios");
        ltOptions.put("app", "lt://APP10160601511704968707280589");
        ltOptions.put("deviceName", "iPhone 15.*");
        ltOptions.put("platformVersion", "17");
        ltOptions.put("console", true);
        ltOptions.put("w3c", true);
        ltOptions.put("network", true);
        ltOptions.put("appiumVersion", "2.0");
        ltOptions.put("autoAcceptAlerts", "true");
        capabilities.setCapability("lt:options", ltOptions);


        try {
            driver = new AppiumDriver(new URL("https://" + username + ":" + authkey + gridURL), capabilities);
            Thread.sleep(2000);

        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testSimple1() throws Exception {
        try {

            driver.get("mmyt://df/listing/?tripType=OW&sector=DEL-DXB&onwardDate=30-01-2024&noOfAdults=1&noOfChildren=0&noOfInfants=0&classType=ECONOMY&region=in");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//*[@name=\"Allow Once\"]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@name=\"OKAY, GOT IT!\"]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@type=\"XCUIElementTypeButton\" and ./preceding-sibling::*[@name=\"FltQuickFilterView_SORT_FILTER_VIEW\"]]")).click();
            Thread.sleep(3000);


            HashMap<String, Object> scrollObject = new HashMap<String, Object>();
            scrollObject.put("name", "Show More Airlines");
            scrollObject.put("direction", "down");
            driver.executeScript("mobile:scroll", scrollObject);
            Thread.sleep(5000);

            for (int i = 0; i < 3; i++) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("mobile: scroll", "{\"direction\": \"down\"}");
            }
           // MobileElement elementToScrollTo = (MobileElement) driver.findElement(By.xpath("//*[@name=\"Show More Airlines\"]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
          //  js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);


            status = "passed";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            status = "failed";
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + status);
        driver.quit();
    }

}
