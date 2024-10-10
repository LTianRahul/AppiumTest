package appiumtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class applePayTesting {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("deviceName", "iPhone 13");
        ltOptions.put("platformVersion", "15");
        ltOptions.put("platformName", "ios");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("privateCloud", true);
        ltOptions.put("queueTimeout", 900);
        ltOptions.put("idleTimeout", 900);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);
        ltOptions.put("network", true);
        ltOptions.put("devicelog", true);
        ltOptions.put("build", "ApplePay Spencer's Demo");

        //  ApplePay Capabilities
        ltOptions.put("privateCloud", true);
        ltOptions.put("applePay", true);
        ltOptions.put("passcode", "000786");
        ltOptions.put("applePayCardType", new String[] { "discover" });

        capabilities.setCapability("lt:options", ltOptions);

        IOSDriver driver = new IOSDriver(
                new URL("https://rahulkumarlambdatest:dboZK7so8koMnIR1tN11aKfMgxyKtDpb90IlyaCj4n6n7tQeK6@mobile-hub.lambdatest.com/wd/hub"),
                capabilities);

        try {

            driver.get("https://applepaydemo.apple.com/");
            Thread.sleep(3000);

            //String pageSource = driver.getPageSource();
            WebElement ele = driver.findElement(By.id("transcriptButton"));
            ele.getRect();

            int centerX = ele.getRect().x + (ele.getSize().width / 2);
            int centerY = ele.getRect().y + (ele.getSize().height / 2);
            System.out.println("centerX" + centerX);
            System.out.println("centerY" + centerY);
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(tap));


            Map<String, Object> scriptArgs = new HashMap<String, Object>();
            scriptArgs.put("confirm", true);
            ((JavascriptExecutor) driver).executeScript("lambda-applepay", scriptArgs);
            new Actions(driver).sendKeys("000786").perform();

          //  System.out.println("After JSON object");

            driver.executeScript("lambda-status=passed");
            Thread.sleep(3000);
            driver.quit();

        } catch (Exception e) {
            System.out.println("Exception:"+ e);
            driver.executeScript("lambda-status=failed");
            driver.quit();
        }

    }
}